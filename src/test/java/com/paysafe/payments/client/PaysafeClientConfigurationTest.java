// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static com.paysafe.payments.config.TestHttpClientProvider.createTestSslContext;
import static com.paysafe.payments.validation.ErrorMessages.MESSAGE_CONNECT_TIMEOUT_MUST_BE_A_POSITIVE_VALUE;
import static com.paysafe.payments.validation.ErrorMessages.MESSAGE_MAXIMUM_ALLOWED_NUMBER_OF_MAX_AUTOMATIC_RETRIES;
import static com.paysafe.payments.validation.ErrorMessages.MESSAGE_MAX_AUTOMATIC_RETRIES_CANNOT_BE_NEGATIVE;
import static com.paysafe.payments.validation.ErrorMessages.MESSAGE_RESPONSE_TIMEOUT_MUST_BE_A_POSITIVE_VALUE;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import org.junit.jupiter.api.Test;

import com.paysafe.payments.api.PaysafeApiClient;
import com.paysafe.payments.api.RequestOptions;
import com.paysafe.payments.base.BaseStubServerTest;
import com.paysafe.payments.base.TestStubServer.StubResponse;
import com.paysafe.payments.base.TestStubServer.UrlMatchType;
import com.paysafe.payments.errorhandling.exception.ApiConnectionException;
import com.paysafe.payments.errorhandling.exception.IllegalArgumentException;
import com.paysafe.payments.errorhandling.exception.PaysafeSdkException;
import com.paysafe.payments.service.MonitorService;
import com.paysafe.payments.service.impl.MonitorServiceImpl;

public class PaysafeClientConfigurationTest extends BaseStubServerTest {

  public static final String MONITOR_ENDPOINT = "/paymenthub/v1/monitor";

  @Test
  void test_customConnectTimeout() throws NoSuchAlgorithmException, KeyManagementException, IllegalArgumentException {
    // we are using non-routable base url for testing connect timeout
    PaysafeApiClient customPaysafeApiClient = PaysafeApiClient.builder()
        .apiKey(API_KEY)
        .sslContext(createTestSslContext())
        .maxAutomaticRetries(0)
        .connectTimeout(1000)
        .responseTimeout(5000)
        .build();
    customPaysafeApiClient.overrideBaseUrl("http://192.0.0.1:8080");

    MonitorService customMonitorService = new MonitorServiceImpl(customPaysafeApiClient);

    long startTime = System.currentTimeMillis();
    PaysafeSdkException exception = assertThrows(ApiConnectionException.class, customMonitorService::verifyThatServiceIsAccessible);
    long endTime = System.currentTimeMillis();

    assertTrue(exception.getMessage().contains("Error connecting to http://192.0.0.1:8080"));
    assertTrue(exception.getMessage().contains("failed: connect timed out"));
    assertTrue(endTime - startTime >= 1000);
    assertTrue(endTime - startTime <= 2000);
  }

  @Test
  void test_customRequestTimeout() throws NoSuchAlgorithmException, KeyManagementException, IllegalArgumentException {
    stubServer.stub("GET", MONITOR_ENDPOINT, UrlMatchType.PATH_EQUAL,
        StubResponse.builder()
            .status(200)
            .header("Content-Type", "application/json")
            .bodyFile("monitor/verify_that_service_is_accessible_response.json")
            .delayMs(6000)
            .build());

    PaysafeApiClient customPaysafeApiClient = PaysafeApiClient.builder()
        .apiKey(API_KEY)
        .sslContext(createTestSslContext())
        .maxAutomaticRetries(0)
        .connectTimeout(1000)
        .responseTimeout(5000)
        .build();
    customPaysafeApiClient.overrideBaseUrl(baseUrl);

    MonitorService customMonitorService = new MonitorServiceImpl(customPaysafeApiClient);

    PaysafeSdkException exception = assertThrows(ApiConnectionException.class, customMonitorService::verifyThatServiceIsAccessible);

    stubServer.verify(1, "GET", MONITOR_ENDPOINT);
    assertTrue(exception.getMessage().contains("Error connecting to " + baseUrl));
    assertTrue(exception.getMessage().contains("reason: Read timed out"));
  }

  @Test
  void test_validateRequestOptions() {
    RequestOptions requestOptions = new RequestOptions();
    requestOptions.setConnectTimeout(-0);

    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
        () -> paysafeClient.monitorService().verifyThatServiceIsAccessible(requestOptions));
    assertEquals(MESSAGE_CONNECT_TIMEOUT_MUST_BE_A_POSITIVE_VALUE, exception.getMessage());

    requestOptions.setConnectTimeout(1000);
    requestOptions.setResponseTimeout(-100);
    exception = assertThrows(IllegalArgumentException.class,
        () -> paysafeClient.monitorService().verifyThatServiceIsAccessible(requestOptions));
    assertEquals(MESSAGE_RESPONSE_TIMEOUT_MUST_BE_A_POSITIVE_VALUE, exception.getMessage());

    requestOptions.setMaxAutomaticRetries(-5);
    exception = assertThrows(IllegalArgumentException.class,
        () -> paysafeClient.monitorService().verifyThatServiceIsAccessible(requestOptions));
    assertEquals(MESSAGE_MAX_AUTOMATIC_RETRIES_CANNOT_BE_NEGATIVE, exception.getMessage());

    requestOptions.setMaxAutomaticRetries(1000);
    exception = assertThrows(IllegalArgumentException.class,
        () -> paysafeClient.monitorService().verifyThatServiceIsAccessible(requestOptions));
    assertEquals(MESSAGE_MAXIMUM_ALLOWED_NUMBER_OF_MAX_AUTOMATIC_RETRIES, exception.getMessage());

    requestOptions.setMaxAutomaticRetries(1);
  }
}
