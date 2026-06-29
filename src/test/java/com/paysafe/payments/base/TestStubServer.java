// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;
import java.util.stream.Collectors;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;

/**
 * A lightweight HTTP/HTTPS stub server for tests, backed by raw ServerSocket.
 * <p>
 * Uses raw sockets (not JDK's HttpServer) to enable fault simulation - closing a TCP connection
 * without sending any HTTP response, which triggers IOException/retry logic in Apache HttpClient.
 */
public class TestStubServer {

  private ServerSocket serverSocket;
  private final List<StubMapping> stubs = new CopyOnWriteArrayList<>();
  private final List<RecordedRequest> recordedRequests = new CopyOnWriteArrayList<>();
  private final AtomicBoolean running = new AtomicBoolean(false);
  private ExecutorService executor;

  // Lifecycle

  /** Starts an HTTPS server on the given port (use 0 for dynamic port). */
  public void startHttps(int port) throws Exception {
    SSLContext sslContext = createServerSslContext();
    SSLServerSocketFactory factory = sslContext.getServerSocketFactory();
    SSLServerSocket sslServerSocket = (SSLServerSocket) factory.createServerSocket(port);
    sslServerSocket.setNeedClientAuth(false);
    this.serverSocket = sslServerSocket;
    startAcceptLoop();
  }

  /** Starts an HTTP (plain) server on the given port (use 0 for dynamic port). */
  public void startHttp(int port) throws Exception {
    this.serverSocket = new ServerSocket(port);
    startAcceptLoop();
  }

  /** Returns the actual port the server is listening on. */
  public int getPort() {
    return serverSocket.getLocalPort();
  }

  /** Returns the base URL for this server instance. */
  public String getBaseUrl() {
    String scheme = (serverSocket instanceof SSLServerSocket) ? "https" : "http";
    return scheme + "://localhost:" + getPort();
  }

  /** Stops the server immediately. */
  public void stop() {
    running.set(false);
    try {
      if (serverSocket != null && !serverSocket.isClosed()) {
        serverSocket.close();
      }
    } catch (IOException e) {
      // Expected when socket is already closed during shutdown
    }
    if (executor != null) {
      executor.shutdownNow();
    }
  }

  /** Clears all stubs and recorded requests. */
  public void resetAll() {
    stubs.clear();
    recordedRequests.clear();
  }

  // Stub Registration

  /** Registers a stub that returns the given response for matching requests. */
  public void stub(String method, String urlPattern, UrlMatchType matchType, StubResponse response) {
    stubs.add(new StubMapping(method, urlPattern, matchType, Collections.singletonList(response)));
  }

  /**
   * Registers a stub with sequential responses (for retry testing).
   * Each call consumes the next response in order; after exhausting all, the last one repeats.
   */
  public void stubSequence(String method, String urlPattern, UrlMatchType matchType, List<StubResponse> responses) {
    stubs.add(new StubMapping(method, urlPattern, matchType, responses));
  }

  // Verification

  /** Verifies exact match on full URL (path + query string). */
  public void verify(int expectedCount, String method, String url) {
    long actual = recordedRequests.stream()
        .filter(r -> r.method.equalsIgnoreCase(method) && r.url.equals(url))
        .count();
    if (actual != expectedCount) {
      throw new AssertionError(String.format(
          "Expected %d request(s) to %s %s but got %d. Recorded: %s",
          expectedCount, method, url, actual,
          recordedRequests.stream().map(r -> r.method + " " + r.url).collect(Collectors.joining(", "))));
    }
  }

  /** Verifies match on path only (ignores query string). */
  public void verifyByPath(int expectedCount, String method, String path) {
    long actual = recordedRequests.stream()
        .filter(r -> r.method.equalsIgnoreCase(method) && r.path.equals(path))
        .count();
    if (actual != expectedCount) {
      throw new AssertionError(String.format(
          "Expected %d request(s) to %s %s but got %d", expectedCount, method, path, actual));
    }
  }

  /** Returns all recorded requests (for timestamp analysis in retry tests). */
  public List<RecordedRequest> getRecordedRequests() {
    return Collections.unmodifiableList(new ArrayList<>(recordedRequests));
  }

  // Connection Handling

  private void startAcceptLoop() {
    running.set(true);
    executor = Executors.newCachedThreadPool(r -> {
      Thread t = new Thread(r, "TestStubServer-worker");
      t.setDaemon(true);
      return t;
    });
    Thread acceptThread = new Thread(() -> {
      while (running.get()) {
        try {
          Socket clientSocket = serverSocket.accept();
          executor.submit(() -> handleConnection(clientSocket));
        } catch (IOException e) {
          // Expected when shutting down; ignore
        }
      }
    }, "TestStubServer-accept");
    acceptThread.setDaemon(true);
    acceptThread.start();
  }

  private void handleConnection(Socket socket) {
    try {
      socket.setSoTimeout(30000);
      BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));

      String requestLine = reader.readLine();
      if (requestLine == null || requestLine.isEmpty()) {
        socket.close();
        return;
      }

      String[] parts = requestLine.split(" ", 3);
      if (parts.length < 2) {
        socket.close();
        return;
      }

      String method = parts[0];
      String url = extractUrl(parts[1]);
      String path = url.contains("?") ? url.substring(0, url.indexOf('?')) : url;

      // Read headers
      Map<String, String> headers = new HashMap<>();
      int contentLength = 0;
      String headerLine;
      while ((headerLine = reader.readLine()) != null && !headerLine.isEmpty()) {
        int colon = headerLine.indexOf(':');
        if (colon > 0) {
          String name = headerLine.substring(0, colon).trim();
          String value = headerLine.substring(colon + 1).trim();
          headers.put(name, value);
          if ("Content-Length".equalsIgnoreCase(name)) {
            contentLength = Integer.parseInt(value);
          }
        }
      }

      // Consume request body
      if (contentLength > 0) {
        char[] buf = new char[contentLength];
        int read = 0;
        while (read < contentLength) {
          int n = reader.read(buf, read, contentLength - read);
          if (n == -1) break;
          read += n;
        }
      }

      // Record
      recordedRequests.add(new RecordedRequest(method, path, url, System.currentTimeMillis()));

      // Match
      StubMapping matched = findMatchingStub(method, path, url);
      if (matched == null) {
        sendResponse(socket.getOutputStream(), 404, Collections.emptyMap(),
            ("No stub matched: " + method + " " + url).getBytes(StandardCharsets.UTF_8));
        socket.close();
        return;
      }

      StubResponse response = matched.nextResponse();

      // Fault: drop connection immediately
      if (response.fault) {
        socket.close();
        return;
      }

      // Delay
      if (response.delayMs > 0) {
        simulateDelay(response.delayMs);
      }

      sendResponse(socket.getOutputStream(), response.status, response.headers, loadBody(response));
      socket.close();

    } catch (IOException e) {
      closeQuietly(socket);
    }
  }

  /** Strips scheme+authority from absolute proxy URIs, keeping only path+query. */
  private static String extractUrl(String rawUri) {
    if (rawUri.startsWith("http://") || rawUri.startsWith("https://")) {
      int schemeEnd = rawUri.indexOf("://") + 3;
      int pathStart = rawUri.indexOf('/', schemeEnd);
      return pathStart >= 0 ? rawUri.substring(pathStart) : "/";
    }
    return rawUri;
  }

  private void sendResponse(OutputStream out, int status, Map<String, String> headers, byte[] body) throws IOException {
    StringBuilder sb = new StringBuilder();
    sb.append("HTTP/1.1 ").append(status).append(' ').append(reasonPhrase(status)).append("\r\n");
    sb.append("Content-Length: ").append(body.length).append("\r\n");
    sb.append("Connection: close\r\n");
    for (Map.Entry<String, String> h : headers.entrySet()) {
      sb.append(h.getKey()).append(": ").append(h.getValue()).append("\r\n");
    }
    sb.append("\r\n");
    out.write(sb.toString().getBytes(StandardCharsets.UTF_8));
    if (body.length > 0) {
      out.write(body);
    }
    out.flush();
  }

  private StubMapping findMatchingStub(String method, String path, String url) {
    for (int i = stubs.size() - 1; i >= 0; i--) {
      StubMapping stub = stubs.get(i);
      if (!stub.method.equalsIgnoreCase(method)) continue;
      if (stub.matchType == UrlMatchType.PATH_EQUAL && path.equals(stub.urlPattern)) return stub;
      if (stub.matchType == UrlMatchType.URL_EQUAL && url.equals(stub.urlPattern)) return stub;
    }
    return null;
  }

  private byte[] loadBody(StubResponse response) throws IOException {
    if (response.body != null) {
      return response.body.getBytes(StandardCharsets.UTF_8);
    }
    if (response.bodyFile != null) {
      try (InputStream is = getClass().getResourceAsStream("/__files/" + response.bodyFile)) {
        if (is == null) {
          throw new IOException("Body file not found: /__files/" + response.bodyFile);
        }
        return is.readAllBytes();
      }
    }
    return new byte[0];
  }

  private static String reasonPhrase(int status) {
    switch (status) {
      case 200: return "OK";
      case 201: return "Created";
      case 400: return "Bad Request";
      case 401: return "Unauthorized";
      case 402: return "Payment Required";
      case 403: return "Forbidden";
      case 404: return "Not Found";
      case 409: return "Conflict";
      case 500: return "Internal Server Error";
      default: return "Unknown";
    }
  }

  private static void simulateDelay(int delayMs) {
    LockSupport.parkNanos((long) delayMs * 1_000_000);
  }

  private static void closeQuietly(Socket socket) {
    try {
      socket.close();
    } catch (IOException e) {
      // Nothing to do - closing a socket that may already be closed
    }
  }

  private static SSLContext createServerSslContext() throws Exception {
    KeyStore ks = KeyStore.getInstance("PKCS12");
    try (InputStream is = TestStubServer.class.getResourceAsStream("/test-keystore.p12")) {
      if (is == null) throw new IllegalStateException("test-keystore.p12 not found on classpath");
      ks.load(is, "changeit".toCharArray());
    }
    KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
    kmf.init(ks, "changeit".toCharArray());
    SSLContext ctx = SSLContext.getInstance("TLS");
    ctx.init(kmf.getKeyManagers(), null, null);
    return ctx;
  }

  // Inner Types

  public enum UrlMatchType {
    /** Matches the path portion only (ignores query string). */
    PATH_EQUAL,
    /** Matches the full URL (path + query string). */
    URL_EQUAL
  }

  public static class StubResponse {
    final int status;
    final Map<String, String> headers;
    final String bodyFile;
    final String body;
    final int delayMs;
    final boolean fault;

    private StubResponse(Builder b) {
      this.status = b.status;
      this.headers = Collections.unmodifiableMap(new HashMap<>(b.headers));
      this.bodyFile = b.bodyFile;
      this.body = b.body;
      this.delayMs = b.delayMs;
      this.fault = b.fault;
    }

    public static Builder builder() { return new Builder(); }

    /** Creates a fault response that drops the TCP connection without any HTTP response. */
    public static StubResponse fault() {
      Builder b = new Builder();
      b.fault = true;
      return b.build();
    }

    // Public accessors kept for tests that inspect StubResponse directly
    public int getStatus() { return status; }
    public Map<String, String> getHeaders() { return headers; }
    public boolean isFault() { return fault; }
    public int getDelayMs() { return delayMs; }

    public static class Builder {
      private int status = 200;
      private final Map<String, String> headers = new HashMap<>();
      private String bodyFile;
      private String body;
      private int delayMs;
      private boolean fault;

      public Builder status(int status) { this.status = status; return this; }
      public Builder header(String name, String value) { this.headers.put(name, value); return this; }
      public Builder bodyFile(String file) { this.bodyFile = file; return this; }
      public Builder body(String body) { this.body = body; return this; }
      public Builder delayMs(int delayMs) { this.delayMs = delayMs; return this; }
      public StubResponse build() { return new StubResponse(this); }
    }
  }

  static class StubMapping {
    final String method;
    final String urlPattern;
    final UrlMatchType matchType;
    private final List<StubResponse> responses;
    private final AtomicInteger callCount = new AtomicInteger(0);

    StubMapping(String method, String urlPattern, UrlMatchType matchType, List<StubResponse> responses) {
      this.method = method;
      this.urlPattern = urlPattern;
      this.matchType = matchType;
      this.responses = new ArrayList<>(responses);
    }

    StubResponse nextResponse() {
      int idx = callCount.getAndIncrement();
      return idx < responses.size() ? responses.get(idx) : responses.get(responses.size() - 1);
    }
  }

  public static class RecordedRequest {
    final String method;
    final String path;
    final String url;
    final long timestamp;

    RecordedRequest(String method, String path, String url, long timestamp) {
      this.method = method;
      this.path = path;
      this.url = url;
      this.timestamp = timestamp;
    }

    public String getMethod() { return method; }
    public String getPath() { return path; }
    public String getUrl() { return url; }
    public long getTimestamp() { return timestamp; }
  }
}

