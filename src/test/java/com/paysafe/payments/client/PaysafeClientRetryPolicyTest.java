// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static com.paysafe.payments.config.TestHttpClientProvider.createTestSslContext;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import com.paysafe.payments.api.PaysafeApiClient;
import com.paysafe.payments.api.RequestOptions;
import com.paysafe.payments.base.BaseStubServerTest;
import com.paysafe.payments.base.TestStubServer.RecordedRequest;
import com.paysafe.payments.base.TestStubServer.StubResponse;
import com.paysafe.payments.base.TestStubServer.UrlMatchType;
import com.paysafe.payments.errorhandling.exception.ApiConnectionException;
import com.paysafe.payments.errorhandling.exception.ApiException;
import com.paysafe.payments.errorhandling.exception.InvalidCredentialsException;
import com.paysafe.payments.errorhandling.exception.InvalidRequestException;
import com.paysafe.payments.errorhandling.exception.PaysafeSdkException;
import com.paysafe.payments.errorhandling.exception.RequestConflictException;
import com.paysafe.payments.errorhandling.exception.RequestDeclinedException;
import com.paysafe.payments.errorhandling.exception.UnauthorizedException;
import com.paysafe.payments.model.monitor.MonitorResponse;
import com.paysafe.payments.model.monitor.enums.ServiceStatus;
import com.paysafe.payments.model.paymenthandle.PaymentHandleRequest;
import com.paysafe.payments.service.MonitorService;
import com.paysafe.payments.service.impl.MonitorServiceImpl;

public class PaysafeClientRetryPolicyTest extends BaseStubServerTest {

  public static final String MONITOR_ENDPOINT = "/paymenthub/v1/monitor";
  public static final String PAYMENT_HANDLES_ENDPOINT = "/paymenthub/v1/paymenthandles";

  @Test
  void test_defaultAutomaticRetryPolicy() {
    // 3 faults then success - but default retries is 2, so it should fail after 3 attempts
    stubServer.stubSequence("GET", MONITOR_ENDPOINT, UrlMatchType.PATH_EQUAL, List.of(
        StubResponse.fault(),
        StubResponse.fault(),
        StubResponse.fault(),
        StubResponse.builder().status(200).header("Content-Type", "application/json")
            .bodyFile("monitor/verify_that_service_is_accessible_response.json").build()
    ));

    PaysafeSdkException exception = assertThrows(ApiConnectionException.class,
        paysafeClient.monitorService()::verifyThatServiceIsAccessible);

    stubServer.verify(3, "GET", MONITOR_ENDPOINT);
    assertTrue(exception.getMessage().contains("Error connecting to " + baseUrl));
  }

  @Test
  void test_doesNotRepeatOn400() {
    stubServer.stubSequence("GET", MONITOR_ENDPOINT, UrlMatchType.PATH_EQUAL, List.of(
        StubResponse.builder().status(400).header("Content-Type", "application/json")
            .bodyFile("error/400_bad_request_field_errors_response.json").build(),
        StubResponse.builder().status(200).header("Content-Type", "application/json")
            .bodyFile("monitor/verify_that_service_is_accessible_response.json").build()
    ));

    assertThrows(InvalidRequestException.class, paysafeClient.monitorService()::verifyThatServiceIsAccessible);
    stubServer.verify(1, "GET", MONITOR_ENDPOINT);
  }

  @Test
  void test_doesNotRepeatOn401() {
    stubServer.stubSequence("GET", MONITOR_ENDPOINT, UrlMatchType.PATH_EQUAL, List.of(
        StubResponse.builder().status(401).header("Content-Type", "application/json")
            .bodyFile("error/401_invalid_credentials_response.json").build(),
        StubResponse.builder().status(200).header("Content-Type", "application/json")
            .bodyFile("monitor/verify_that_service_is_accessible_response.json").build()
    ));

    assertThrows(InvalidCredentialsException.class, paysafeClient.monitorService()::verifyThatServiceIsAccessible);
    stubServer.verify(1, "GET", MONITOR_ENDPOINT);
  }

  @Test
  void test_doesNotRepeatOn402() {
    stubServer.stubSequence("POST", PAYMENT_HANDLES_ENDPOINT, UrlMatchType.PATH_EQUAL, List.of(
        StubResponse.builder().status(402).header("Content-Type", "application/json")
            .bodyFile("error/402_request_declined_response.json").build(),
        StubResponse.builder().status(200).header("Content-Type", "application/json")
            .bodyFile("monitor/verify_that_service_is_accessible_response.json").build()
    ));

    assertThrows(RequestDeclinedException.class,
        () -> paysafeClient.paymentHandleService().createPaymentHandle(new PaymentHandleRequest()));
    stubServer.verify(1, "POST", PAYMENT_HANDLES_ENDPOINT);
  }

  @Test
  void test_doesNotRepeatOn403() {
    stubServer.stubSequence("GET", MONITOR_ENDPOINT, UrlMatchType.PATH_EQUAL, List.of(
        StubResponse.builder().status(403).header("Content-Type", "application/json")
            .bodyFile("error/403_unauthorized_response.json").build(),
        StubResponse.builder().status(200).header("Content-Type", "application/json")
            .bodyFile("monitor/verify_that_service_is_accessible_response.json").build()
    ));

    assertThrows(UnauthorizedException.class, paysafeClient.monitorService()::verifyThatServiceIsAccessible);
    stubServer.verify(1, "GET", MONITOR_ENDPOINT);
  }

  @Test
  void test_doesNotRepeatOn404() {
    stubServer.stubSequence("GET", MONITOR_ENDPOINT, UrlMatchType.PATH_EQUAL, List.of(
        StubResponse.builder().status(404).header("Content-Type", "application/json")
            .bodyFile("error/404_entity_not_found_response.json").build(),
        StubResponse.builder().status(200).header("Content-Type", "application/json")
            .bodyFile("monitor/verify_that_service_is_accessible_response.json").build()
    ));

    assertThrows(PaysafeSdkException.class, paysafeClient.monitorService()::verifyThatServiceIsAccessible);
    stubServer.verify(1, "GET", MONITOR_ENDPOINT);
  }

  @Test
  void test_doesNotRepeatOn409() {
    stubServer.stubSequence("GET", MONITOR_ENDPOINT, UrlMatchType.PATH_EQUAL, List.of(
        StubResponse.builder().status(409).header("Content-Type", "application/json")
            .bodyFile("error/409_request_conflict_response.json").build(),
        StubResponse.builder().status(200).header("Content-Type", "application/json")
            .bodyFile("monitor/verify_that_service_is_accessible_response.json").build()
    ));

    assertThrows(RequestConflictException.class, paysafeClient.monitorService()::verifyThatServiceIsAccessible);
    stubServer.verify(1, "GET", MONITOR_ENDPOINT);
  }

  @Test
  void test_doesNotRepeatOn500() {
    stubServer.stubSequence("GET", MONITOR_ENDPOINT, UrlMatchType.PATH_EQUAL, List.of(
        StubResponse.builder().status(500).header("Content-Type", "application/json")
            .bodyFile("error/500_internal_server_error_response.json").build(),
        StubResponse.builder().status(200).header("Content-Type", "application/json")
            .bodyFile("monitor/verify_that_service_is_accessible_response.json").build()
    ));

    assertThrows(ApiException.class, paysafeClient.monitorService()::verifyThatServiceIsAccessible);
    stubServer.verify(1, "GET", MONITOR_ENDPOINT);
  }

  @Test
  void test_usingRequestOptions() {
    stubServer.stubSequence("GET", MONITOR_ENDPOINT, UrlMatchType.PATH_EQUAL, List.of(
        StubResponse.fault(),
        StubResponse.builder().status(200).header("Content-Type", "application/json")
            .bodyFile("monitor/verify_that_service_is_accessible_response.json")
            .delayMs(3000).build()
    ));

    RequestOptions requestOptions = new RequestOptions();
    requestOptions.setMaxAutomaticRetries(1);
    requestOptions.setResponseTimeout(2000);

    PaysafeSdkException exception = assertThrows(ApiConnectionException.class,
        () -> paysafeClient.monitorService().verifyThatServiceIsAccessible(requestOptions));

    List<RecordedRequest> events = stubServer.getRecordedRequests();
    assertEquals(2, events.size());

    List<RecordedRequest> sortedEvents = events.stream()
        .sorted(Comparator.comparingLong(RecordedRequest::getTimestamp))
        .collect(Collectors.toList());

    long t0 = sortedEvents.get(0).getTimestamp();
    long t1 = sortedEvents.get(1).getTimestamp();
    long delay1 = t1 - t0;

    // For an exponential backoff with a base delay of 100ms and jitter in range 75% - 100%
    assertTrue(delay1 >= 75);

    stubServer.verify(2, "GET", MONITOR_ENDPOINT);
    assertTrue(exception.getMessage().contains("Error connecting to " + baseUrl));
    assertTrue(exception.getMessage().contains("reason: Read timed out"));
  }

  @Test
  void test_customAutomaticRetryPolicy() throws PaysafeSdkException, NoSuchAlgorithmException, KeyManagementException {
    stubServer.stubSequence("GET", MONITOR_ENDPOINT, UrlMatchType.PATH_EQUAL, List.of(
        StubResponse.fault(),
        StubResponse.fault(),
        StubResponse.fault(),
        StubResponse.builder().status(200).header("Content-Type", "application/json")
            .bodyFile("monitor/verify_that_service_is_accessible_response.json").build()
    ));

    PaysafeApiClient paysafeApiClient = PaysafeApiClient.builder()
        .apiKey(API_KEY)
        .sslContext(createTestSslContext())
        .maxAutomaticRetries(3)
        .connectTimeout(1000)
        .responseTimeout(5000)
        .build();
    paysafeApiClient.overrideBaseUrl(baseUrl);

    MonitorService customMonitorService = new MonitorServiceImpl(paysafeApiClient);

    MonitorResponse monitorResponse = customMonitorService.verifyThatServiceIsAccessible();

    stubServer.verify(4, "GET", MONITOR_ENDPOINT);
    assertEquals(ServiceStatus.READY, monitorResponse.getStatus());

    List<RecordedRequest> events = stubServer.getRecordedRequests();
    assertEquals(4, events.size());

    List<RecordedRequest> sortedEvents = events.stream()
        .sorted(Comparator.comparingLong(RecordedRequest::getTimestamp))
        .collect(Collectors.toList());

    long t0 = sortedEvents.get(0).getTimestamp();
    long t1 = sortedEvents.get(1).getTimestamp();
    long t2 = sortedEvents.get(2).getTimestamp();
    long t3 = sortedEvents.get(3).getTimestamp();

    long delay1 = t1 - t0;
    long delay2 = t2 - t1;
    long delay3 = t3 - t2;

    // For an exponential backoff with a base delay of 100ms and jitter in range 75% - 100%:
    // 1st delay >= 75ms, 2nd delay >= 225ms, 3rd delay >= 675ms
    assertTrue(delay1 >= 75);
    assertTrue(delay2 >= delay1);
    assertTrue(delay3 >= delay2);
  }
}
