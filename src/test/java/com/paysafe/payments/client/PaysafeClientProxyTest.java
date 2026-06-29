// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.client;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import com.paysafe.payments.PaysafeClient;
import com.paysafe.payments.base.TestStubServer;
import com.paysafe.payments.base.TestStubServer.StubResponse;
import com.paysafe.payments.base.TestStubServer.UrlMatchType;
import com.paysafe.payments.errorhandling.exception.PaysafeSdkException;
import com.paysafe.payments.model.monitor.MonitorResponse;
import com.paysafe.payments.model.monitor.enums.ServiceStatus;

/**
 * Uses a plain HTTP TestStubServer instance for proxy testing.
 * The stub server acts as both the "proxy" and the "target" - when the client sends
 * a request through a proxy pointing to our stub server, the server receives the request
 * and responds with the stubbed response.
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PaysafeClientProxyTest {

  public static final String MONITOR_ENDPOINT = "/paymenthub/v1/monitor";
  public static final String API_KEY = "clientId:clientKey";

  private TestStubServer stubServer;
  private int serverPort;

  @BeforeAll
  void init() throws Exception {
    stubServer = new TestStubServer();
    stubServer.startHttp(0);
    serverPort = stubServer.getPort();
  }

  @AfterAll
  void stopServer() {
    if (stubServer != null) {
      stubServer.stop();
    }
  }

  @BeforeEach
  void resetAll() {
    stubServer.resetAll();
  }

  @AfterEach
  void clearSystemProperties() {
    System.clearProperty("http.proxyHost");
    System.clearProperty("http.proxyPort");
    System.clearProperty("http.proxyUser");
    System.clearProperty("http.proxyPassword");
    System.clearProperty("https.proxyHost");
    System.clearProperty("https.proxyPort");
    System.clearProperty("https.proxyUser");
    System.clearProperty("https.proxyPassword");
  }

  @Test
  void testProxy_withProvidedProxy() throws PaysafeSdkException {
    stubServer.stub("GET", MONITOR_ENDPOINT, UrlMatchType.PATH_EQUAL,
        StubResponse.builder().status(200).header("Content-Type", "application/json")
            .bodyFile("monitor/verify_that_service_is_accessible_response.json").build());

    Proxy proxy = new Proxy(Type.HTTP, new InetSocketAddress("localhost", serverPort));

    PaysafeClient paysafeClient = PaysafeClient.builder()
        .apiKey(API_KEY)
        .maxAutomaticRetries(0)
        .proxy(proxy)
        .build();
    paysafeClient.overrideBaseUrl("http://url_to_be_proxied:500");

    MonitorResponse monitorResponse = paysafeClient.monitorService().verifyThatServiceIsAccessible();

    stubServer.verify(1, "GET", MONITOR_ENDPOINT);
    assertEquals(ServiceStatus.READY, monitorResponse.getStatus());
  }

  @Test
  void testProxy_withSystemPropertiesHttp() throws PaysafeSdkException {
    System.setProperty("http.proxyHost", "localhost");
    System.setProperty("http.proxyPort", String.valueOf(serverPort));
    System.setProperty("http.proxyUser", "squid");
    System.setProperty("http.proxyPassword", "ward");

    stubServer.stub("GET", MONITOR_ENDPOINT, UrlMatchType.PATH_EQUAL,
        StubResponse.builder().status(200).header("Content-Type", "application/json")
            .bodyFile("monitor/verify_that_service_is_accessible_response.json").build());

    PaysafeClient paysafeClient = PaysafeClient.builder()
        .apiKey(API_KEY)
        .maxAutomaticRetries(0)
        .build();
    paysafeClient.overrideBaseUrl("http://url_to_be_proxied:500");

    MonitorResponse monitorResponse = paysafeClient.monitorService().verifyThatServiceIsAccessible();

    stubServer.verify(1, "GET", MONITOR_ENDPOINT);
    assertEquals(ServiceStatus.READY, monitorResponse.getStatus());
  }

  @Test
  void testProxy_withSystemPropertiesHttps() throws PaysafeSdkException {
    System.setProperty("https.proxyHost", "localhost");
    System.setProperty("https.proxyPort", String.valueOf(serverPort));
    System.setProperty("https.proxyUser", "squid");
    System.setProperty("https.proxyPassword", "ward");

    stubServer.stub("GET", MONITOR_ENDPOINT, UrlMatchType.PATH_EQUAL,
        StubResponse.builder().status(200).header("Content-Type", "application/json")
            .bodyFile("monitor/verify_that_service_is_accessible_response.json").build());

    PaysafeClient paysafeClient = PaysafeClient.builder()
        .apiKey(API_KEY)
        .maxAutomaticRetries(0)
        .build();
    paysafeClient.overrideBaseUrl("http://url_to_be_proxied:500");

    MonitorResponse monitorResponse = paysafeClient.monitorService().verifyThatServiceIsAccessible();

    stubServer.verify(1, "GET", MONITOR_ENDPOINT);
    assertEquals(ServiceStatus.READY, monitorResponse.getStatus());
  }

  @Test
  void testProxy_providedProxyOverridesSystemProperties() throws PaysafeSdkException {
    System.setProperty("http.proxyHost", "testuri");
    System.setProperty("http.proxyPort", "1000");
    System.setProperty("http.proxyUser", "squid");
    System.setProperty("http.proxyPassword", "ward");

    stubServer.stub("GET", MONITOR_ENDPOINT, UrlMatchType.PATH_EQUAL,
        StubResponse.builder().status(200).header("Content-Type", "application/json")
            .bodyFile("monitor/verify_that_service_is_accessible_response.json").build());

    Proxy proxy = new Proxy(Type.HTTP, new InetSocketAddress("localhost", serverPort));

    PaysafeClient paysafeClient = PaysafeClient.builder()
        .apiKey(API_KEY)
        .maxAutomaticRetries(0)
        .proxy(proxy)
        .build();
    paysafeClient.overrideBaseUrl("http://url_to_be_proxied:500");

    MonitorResponse monitorResponse = paysafeClient.monitorService().verifyThatServiceIsAccessible();

    stubServer.verify(1, "GET", MONITOR_ENDPOINT);
    assertEquals(ServiceStatus.READY, monitorResponse.getStatus());
  }
}
