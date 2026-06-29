// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.paysafe.payments.base.BaseStubServerTest;
import com.paysafe.payments.base.TestStubServer.StubResponse;
import com.paysafe.payments.base.TestStubServer.UrlMatchType;
import com.paysafe.payments.errorhandling.exception.ApiConnectionException;
import com.paysafe.payments.errorhandling.exception.PaysafeSdkException;
import com.paysafe.payments.errorhandling.exception.UnauthorizedException;
import com.paysafe.payments.model.card.MerchantDescriptor;
import com.paysafe.payments.model.common.cancel.CancelRequest;
import com.paysafe.payments.model.common.cancel.CancelResponse;
import com.paysafe.payments.model.common.enums.CurrencyCode;
import com.paysafe.payments.model.common.enums.TransactionRequestStatus;
import com.paysafe.payments.model.common.travel.airline.AirlineTicket;
import com.paysafe.payments.model.common.travel.airline.AirlineTravelDetails;
import com.paysafe.payments.model.common.travel.airline.Passenger;
import com.paysafe.payments.model.common.travel.airline.Passengers;
import com.paysafe.payments.model.common.travel.airline.enums.Gender;
import com.paysafe.payments.model.payment.Payment;
import com.paysafe.payments.model.payment.PaymentList;
import com.paysafe.payments.model.payment.PaymentRequest;

class PaymentServiceTest extends BaseStubServerTest {

  public static final String PAYMENT_ENDPOINT = "/paymenthub/v1/payments";
  public static final String PAYMENT_ID = "3aeb9c63-6386-46a3-9f8e-f452e722228a";
  public static final String MERCHANT_REF_NUM = "MerchantRefNum-145";

  @Test
  void testGetPaymentById_isSuccessful() throws PaysafeSdkException {
    stubServer.stub("GET", String.format("%s/%s", PAYMENT_ENDPOINT, PAYMENT_ID), UrlMatchType.PATH_EQUAL,
        StubResponse.builder().status(200).header("Content-Type", "application/json")
            .bodyFile("payment/get_payment_by_id_response.json").build());
    Payment response = paysafeClient.paymentService().getPaymentById(PAYMENT_ID);
    stubServer.verify(1, "GET", String.format("%s/%s", PAYMENT_ENDPOINT, PAYMENT_ID));
    assertNotNull(response);
  }

  @Test
  void testGetPaymentById_throwsExceptionOnUnauthorizedAccessError() {
    stubServer.stub("GET", String.format("%s/%s", PAYMENT_ENDPOINT, PAYMENT_ID), UrlMatchType.PATH_EQUAL,
        StubResponse.builder().status(403).header("Content-Type", "application/json")
            .bodyFile("error/403_unauthorized_response.json").build());
    PaysafeSdkException exception = assertThrows(PaysafeSdkException.class, () -> paysafeClient.paymentService().getPaymentById(PAYMENT_ID));
    stubServer.verify(1, "GET", String.format("%s/%s", PAYMENT_ENDPOINT, PAYMENT_ID));
    assertEquals("5270", exception.getError().getCode());
    assertEquals("Unauthorized access", exception.getError().getMessage());
  }

  @Test
  void testGetPaymentById_throwsExceptionOnInvalidCredentialsError() {
    stubServer.stub("GET", String.format("%s/%s", PAYMENT_ENDPOINT, PAYMENT_ID), UrlMatchType.PATH_EQUAL,
        StubResponse.builder().status(401).header("Content-Type", "application/json")
            .bodyFile("error/401_invalid_credentials_response.json").build());
    PaysafeSdkException exception = assertThrows(PaysafeSdkException.class, () -> paysafeClient.paymentService().getPaymentById(PAYMENT_ID));
    stubServer.verify(1, "GET", String.format("%s/%s", PAYMENT_ENDPOINT, PAYMENT_ID));
    assertEquals(401, exception.getCode());
    assertNull(exception.getInternalCorrelationId());
    assertEquals("5279", exception.getError().getCode());
  }

  @Test
  void testGetPaymentById_throwsPaysafeSdkExceptionOnIOError() {
    stubServer.stub("GET", String.format("%s/%s", PAYMENT_ENDPOINT, PAYMENT_ID), UrlMatchType.PATH_EQUAL, StubResponse.fault());
    PaysafeSdkException exception = assertThrows(PaysafeSdkException.class, () -> paysafeClient.paymentService().getPaymentById(PAYMENT_ID));
    stubServer.verify(3, "GET", String.format("%s/%s", PAYMENT_ENDPOINT, PAYMENT_ID));
    assertNull(exception.getCode());
    assertTrue(exception.getMessage().contains("Error connecting to " + baseUrl));
  }

  @Test
  void testGetPaymentsUsingMerchantReferenceNumber_isSuccessful() throws PaysafeSdkException {
    stubServer.stub("GET", PAYMENT_ENDPOINT, UrlMatchType.PATH_EQUAL,
        StubResponse.builder().status(200).header("Content-Type", "application/json")
            .bodyFile("payment/get_payment_using_merchant_ref_number_response.json").build());
    PaymentList response = paysafeClient.paymentService().getPaymentsUsingMerchantReferenceNumber(MERCHANT_REF_NUM, null, null, null, null);
    stubServer.verify(1, "GET", String.format("%s?merchantRefNum=%s", PAYMENT_ENDPOINT, MERCHANT_REF_NUM));
    assertNotNull(response);
    assertNotNull(response.getMeta());
    assertFalse(response.getPayments().isEmpty());
  }

  @Test
  void testGetPaymentsUsingMerchantReferenceNumber_queryParamsAreSetCorrectly() throws PaysafeSdkException {
    stubServer.stub("GET", PAYMENT_ENDPOINT, UrlMatchType.PATH_EQUAL,
        StubResponse.builder().status(200).header("Content-Type", "application/json")
            .bodyFile("payment/get_payment_using_merchant_ref_number_response.json").build());

    paysafeClient.paymentService().getPaymentsUsingMerchantReferenceNumber("merchantRefNum-145", "2022-12-19", 32, 0, "2022-11-18");
    stubServer.verify(1, "GET", String.format("%s?merchantRefNum=merchantRefNum-145&endDate=2022-12-19&limit=32&offset=0&startDate=2022-11-18", PAYMENT_ENDPOINT));

    stubServer.resetAll();
    stubServer.stub("GET", PAYMENT_ENDPOINT, UrlMatchType.PATH_EQUAL,
        StubResponse.builder().status(200).header("Content-Type", "application/json")
            .bodyFile("payment/get_payment_using_merchant_ref_number_response.json").build());

    paysafeClient.paymentService().getPaymentsUsingMerchantReferenceNumber(null, "2022-12-19", 32, 0, "2022-11-18");
    stubServer.verify(1, "GET", String.format("%s?endDate=2022-12-19&limit=32&offset=0&startDate=2022-11-18", PAYMENT_ENDPOINT));
  }

  @Test
  void testGetPaymentsUsingMerchantReferenceNumber_throwsExceptionOnInvalidCredentialsError() {
    stubServer.stub("GET", PAYMENT_ENDPOINT, UrlMatchType.PATH_EQUAL,
        StubResponse.builder().status(401).header("Content-Type", "application/json")
            .bodyFile("error/401_invalid_credentials_response.json").build());
    PaysafeSdkException exception = assertThrows(PaysafeSdkException.class,
        () -> paysafeClient.paymentService().getPaymentsUsingMerchantReferenceNumber(MERCHANT_REF_NUM, null, null, null, null));
    stubServer.verify(1, "GET", String.format("%s?merchantRefNum=%s", PAYMENT_ENDPOINT, MERCHANT_REF_NUM));
    assertEquals(401, exception.getCode());
    assertEquals("5279", exception.getError().getCode());
  }

  @Test
  void testGetPaymentsUsingMerchantReferenceNumber_throwsPaysafeSdkExceptionOnIOError() {
    stubServer.stub("GET", PAYMENT_ENDPOINT, UrlMatchType.PATH_EQUAL, StubResponse.fault());
    PaysafeSdkException exception = assertThrows(PaysafeSdkException.class,
        () -> paysafeClient.paymentService().getPaymentsUsingMerchantReferenceNumber(MERCHANT_REF_NUM, null, null, null, null));
    stubServer.verify(3, "GET", String.format("%s?merchantRefNum=%s", PAYMENT_ENDPOINT, MERCHANT_REF_NUM));
    assertTrue(exception.getMessage().contains("Error connecting to " + baseUrl));
  }

  @Test
  void testGetPaymentsUsingMerchantReferenceNumber_throwsExceptionOnUnauthorizedAccessError() {
    stubServer.stub("GET", PAYMENT_ENDPOINT, UrlMatchType.PATH_EQUAL,
        StubResponse.builder().status(403).header("Content-Type", "application/json")
            .bodyFile("error/403_unauthorized_response.json").build());
    PaysafeSdkException exception = assertThrows(PaysafeSdkException.class,
        () -> paysafeClient.paymentService().getPaymentsUsingMerchantReferenceNumber(MERCHANT_REF_NUM, null, null, null, null));
    stubServer.verify(1, "GET", String.format("%s?merchantRefNum=%s", PAYMENT_ENDPOINT, MERCHANT_REF_NUM));
    assertEquals(403, exception.getCode());
    assertEquals("5270", exception.getError().getCode());
  }

  @Test
  void testCancelPayment_isSuccessful() throws PaysafeSdkException {
    stubServer.stub("PUT", String.format("%s/%s", PAYMENT_ENDPOINT, PAYMENT_ID), UrlMatchType.PATH_EQUAL,
        StubResponse.builder().status(200).header("Content-Type", "application/json")
            .bodyFile("payment/cancel_payment_response.json").build());
    CancelRequest requestBody = CancelRequest.builder().status(TransactionRequestStatus.CANCELLED).build();
    CancelResponse response = paysafeClient.paymentService().cancelPayment(PAYMENT_ID, requestBody);
    stubServer.verify(1, "PUT", String.format("%s/%s", PAYMENT_ENDPOINT, PAYMENT_ID));
    assertNotNull(response);
    assertEquals(PAYMENT_ID, response.getId());
    assertEquals(TransactionRequestStatus.CANCELLED, response.getStatus());
  }

  @Test
  void testCancelPayment_throwsExceptionOnUnauthorizedAccessError() {
    stubServer.stub("PUT", String.format("%s/%s", PAYMENT_ENDPOINT, PAYMENT_ID), UrlMatchType.PATH_EQUAL,
        StubResponse.builder().status(403).header("Content-Type", "application/json")
            .bodyFile("error/403_unauthorized_response.json").build());
    CancelRequest requestBody = CancelRequest.builder().status(TransactionRequestStatus.CANCELLED).build();
    PaysafeSdkException exception = assertThrows(PaysafeSdkException.class, () -> paysafeClient.paymentService().cancelPayment(PAYMENT_ID, requestBody));
    stubServer.verify(1, "PUT", String.format("%s/%s", PAYMENT_ENDPOINT, PAYMENT_ID));
    assertEquals(403, exception.getCode());
    assertEquals("5270", exception.getError().getCode());
  }

  @Test
  void testCancelPayment_throwsExceptionOnEntityNotFoundError() {
    stubServer.stub("PUT", String.format("%s/%s", PAYMENT_ENDPOINT, PAYMENT_ID), UrlMatchType.PATH_EQUAL,
        StubResponse.builder().status(404).header("Content-Type", "application/json")
            .bodyFile("error/404_entity_not_found_response.json").build());
    CancelRequest requestBody = CancelRequest.builder().status(TransactionRequestStatus.CANCELLED).build();
    PaysafeSdkException exception = assertThrows(PaysafeSdkException.class, () -> paysafeClient.paymentService().cancelPayment(PAYMENT_ID, requestBody));
    stubServer.verify(1, "PUT", String.format("%s/%s", PAYMENT_ENDPOINT, PAYMENT_ID));
    assertEquals(404, exception.getCode());
    assertEquals("5269", exception.getError().getCode());
  }

  @Test
  void testCancelPayment_throwsPaysafeSdkExceptionOnIOError() {
    stubServer.stub("PUT", String.format("%s/%s", PAYMENT_ENDPOINT, PAYMENT_ID), UrlMatchType.PATH_EQUAL, StubResponse.fault());
    CancelRequest requestBody = CancelRequest.builder().status(TransactionRequestStatus.CANCELLED).build();
    PaysafeSdkException exception = assertThrows(PaysafeSdkException.class, () -> paysafeClient.paymentService().cancelPayment(PAYMENT_ID, requestBody));
    stubServer.verify(1, "PUT", String.format("%s/%s", PAYMENT_ENDPOINT, PAYMENT_ID));
    assertTrue(exception.getMessage().contains("Error connecting to " + baseUrl));
  }

  @Test
  void testProcessPayment_isSuccessful() throws PaysafeSdkException {
    stubServer.stub("POST", PAYMENT_ENDPOINT, UrlMatchType.PATH_EQUAL,
        StubResponse.builder().status(200).header("Content-Type", "application/json")
            .bodyFile("payment/process_payment_card_with_airline_travel_details_response.json").build());
    PaymentRequest paymentRequest = PaymentRequest.builder()
        .merchantRefNum("fc5b62df1202e491475d").amount(500).settleWithAuth(true)
        .paymentHandleToken("SC2INoYvSe2MzQuB").customerIp("172.0.0.1").currencyCode(CurrencyCode.USD)
        .merchantDescriptor(MerchantDescriptor.builder().dynamicDescriptor("100,test").phone("1000000000").build())
        .airlineTravelDetails(createAirlineTravelDetails()).preAuth(false).build();
    Payment response = paysafeClient.paymentService().processPayment(paymentRequest);
    stubServer.verify(1, "POST", PAYMENT_ENDPOINT);
    assertNotNull(response);
  }

  @Test
  void testProcessPayment_throwsExceptionOnInvalidCredentialsError() {
    stubServer.stub("POST", PAYMENT_ENDPOINT, UrlMatchType.PATH_EQUAL,
        StubResponse.builder().status(401).header("Content-Type", "application/json")
            .bodyFile("error/401_invalid_credentials_response.json").build());
    PaysafeSdkException exception = assertThrows(PaysafeSdkException.class, () -> paysafeClient.paymentService().processPayment(new PaymentRequest()));
    stubServer.verify(1, "POST", PAYMENT_ENDPOINT);
    assertEquals(401, exception.getCode());
    assertEquals("5279", exception.getError().getCode());
  }

  @Test
  void testProcessPayment_throwsExceptionOnUnauthorizedAccessError() {
    stubServer.stub("POST", PAYMENT_ENDPOINT, UrlMatchType.PATH_EQUAL,
        StubResponse.builder().status(403).header("Content-Type", "application/json")
            .bodyFile("error/403_unauthorized_response.json").build());
    PaysafeSdkException exception = assertThrows(UnauthorizedException.class, () -> paysafeClient.paymentService().processPayment(new PaymentRequest()));
    stubServer.verify(1, "POST", PAYMENT_ENDPOINT);
    assertEquals(403, exception.getCode());
    assertEquals("5270", exception.getError().getCode());
  }

  @Test
  void testProcessPayment_throwsApiConnectionException() {
    stubServer.stub("POST", PAYMENT_ENDPOINT, UrlMatchType.PATH_EQUAL, StubResponse.fault());
    PaysafeSdkException exception = assertThrows(ApiConnectionException.class, () -> paysafeClient.paymentService().processPayment(new PaymentRequest()));
    stubServer.verify(1, "POST", PAYMENT_ENDPOINT);
    assertTrue(exception.getMessage().contains("Error connecting to " + baseUrl));
  }

  public static AirlineTravelDetails createAirlineTravelDetails() {
    return AirlineTravelDetails.builder()
        .passengerName("John Smith").departureDate("2023-05-25").origin("YUL")
        .customerReferenceNumber("123456").passengerNameRecord("passNamRec")
        .additionalBookingReference("additionalBookingRef").totalFare(1000).totalFee(100).totalTaxes(10)
        .ticket(AirlineTicket.builder().ticketNumber("198J8928").isRestrictedTicket(false).build())
        .passengers(Passengers.builder()
            .passenger1(Passenger.builder().ticketNumber("56827").firstName("Suzy").lastName("Doe").phoneNumber("7181855783").passengerCode("INF").gender(Gender.M).build())
            .passenger2(Passenger.builder().ticketNumber("56828").firstName("John").lastName("Doe").phoneNumber("7181855785").passengerCode("INF").gender(Gender.M).build())
            .build())
        .build();
  }
}
