// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package config;

import java.net.Socket;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509ExtendedTrustManager;

/**
 * Provides a test-only SSLContext that trusts all certificates.
 * <p>
 * <strong>WARNING:</strong> This disables certificate validation entirely and must never be used
 * outside of tests. It is intentionally scoped to {@code src/test} and is only used to communicate
 * with a local WireMock HTTPS server running during unit tests.
 * </p>
 */
public class TestHttpClientProvider {

  private TestHttpClientProvider() {
    // utility class
  }

  /**
   * Creates an {@link SSLContext} that accepts any certificate without validation.
   * Used exclusively so tests can connect to WireMock's local self-signed HTTPS server.
   */
  public static SSLContext createTestSslContext() throws NoSuchAlgorithmException, KeyManagementException {
    SSLContext context = SSLContext.getInstance("TLS");
    context.init(null, new TrustManager[]{TRUST_ALL}, null);
    return context;
  }

  private static final X509ExtendedTrustManager TRUST_ALL = new X509ExtendedTrustManager() {
    @Override
    public X509Certificate[] getAcceptedIssuers() {
      return new X509Certificate[0];
    }

    @Override
    public void checkClientTrusted(X509Certificate[] chain, String authType) {
      // Intentionally empty - all client certificates are trusted in test environment
    }

    @Override
    public void checkServerTrusted(X509Certificate[] chain, String authType) {
      // Intentionally empty - all server certificates are trusted in test environment
    }

    @Override
    public void checkClientTrusted(X509Certificate[] chain, String authType, Socket socket) {
      // Intentionally empty - all client certificates are trusted in test environment
    }

    @Override
    public void checkServerTrusted(X509Certificate[] chain, String authType, Socket socket) {
      // Intentionally empty - all server certificates are trusted in test environment
    }

    @Override
    public void checkClientTrusted(X509Certificate[] chain, String authType, SSLEngine engine) {
      // Intentionally empty - all client certificates are trusted in test environment
    }

    @Override
    public void checkServerTrusted(X509Certificate[] chain, String authType, SSLEngine engine) {
      // Intentionally empty - all server certificates are trusted in test environment
    }
  };

}
