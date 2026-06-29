// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.base;

import static com.paysafe.payments.config.TestHttpClientProvider.createTestSslContext;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;

import com.paysafe.payments.PaysafeClient;
import com.paysafe.payments.errorhandling.exception.IllegalArgumentException;

/**
 * Base test class backed by JDK's raw socket server (via TestStubServer).
 * <p>
 * Uses PER_CLASS lifecycle so each subclass gets its own independent server instance
 * and avoids static field sharing/conflicts between test classes.
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseStubServerTest {

  public static final String API_KEY = "clientId:clientKey";

  protected TestStubServer stubServer;
  protected PaysafeClient paysafeClient;
  protected String baseUrl;

  @BeforeAll
  void initStubServer() throws Exception {
    stubServer = new TestStubServer();
    stubServer.startHttps(0);
    baseUrl = stubServer.getBaseUrl();
    paysafeClient = buildPaysafeClient();
  }

  @AfterAll
  void stopStubServer() {
    if (stubServer != null) {
      stubServer.stop();
    }
  }

  @BeforeEach
  void resetStubServer() {
    stubServer.resetAll();
  }

  protected PaysafeClient buildPaysafeClient() throws NoSuchAlgorithmException, KeyManagementException, IllegalArgumentException {
    PaysafeClient client = PaysafeClient.builder()
        .apiKey(API_KEY)
        .sslContext(createTestSslContext())
        .build();
    client.overrideBaseUrl(baseUrl);
    return client;
  }
}

