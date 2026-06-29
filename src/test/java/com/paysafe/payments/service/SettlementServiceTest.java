// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.paysafe.payments.base.BaseStubServerTest;
import com.paysafe.payments.base.TestStubServer.StubResponse;
import com.paysafe.payments.base.TestStubServer.UrlMatchType;
import com.paysafe.payments.errorhandling.exception.ApiConnectionException;
import com.paysafe.payments.errorhandling.exception.PaysafeSdkException;
import com.paysafe.payments.model.common.cancel.CancelRequest;
import com.paysafe.payments.model.common.cancel.CancelResponse;
import com.paysafe.payments.model.common.enums.TransactionRequestStatus;
import com.paysafe.payments.model.settlement.Settlement;
import com.paysafe.payments.model.settlement.SettlementList;
import com.paysafe.payments.model.settlement.SettlementRequest;
import com.paysafe.payments.model.settlement.enums.SettlementStatus;

class SettlementServiceTest extends BaseStubServerTest {

  public static final String PAYMENT_SETTLEMENT_ENDPOINT = "/paymenthub/v1/payments/%s/settlements";
  public static final String SETTLEMENT_ENDPOINT = "/paymenthub/v1/settlements";
  public static final String PAYMENT_ID = "9b84dedd-2a92-47bf-a8ee-131e2d898105";
  public static final String SETTLEMENT_ID = "8d951743-78e5-4fa5-aa15-2c42f0c05228";
  public static final String MERCHANT_REF_NUM = "a9318b525273ee3cda79a2f947a9";

  @Test
  void testProcessSettlement_isSuccessful() throws PaysafeSdkException {
    stubServer.stub("POST", String.format(PAYMENT_SETTLEMENT_ENDPOINT, PAYMENT_ID), UrlMatchType.PATH_EQUAL,
        StubResponse.builder().status(201).header("Content-Type", "application/json")
            .bodyFile("settlement/process_settlement_card_response.json").build());
    SettlementRequest request = SettlementRequest.builder().merchantRefNum("test-merchantRefNum").amount(500).build();
    Settlement response = paysafeClient.settlementService().processSettlement(PAYMENT_ID, request);
    stubServer.verify(1, "POST", String.format(PAYMENT_SETTLEMENT_ENDPOINT, PAYMENT_ID));
    assertNotNull(response);
    assertEquals("25f6dadf-176a-415f-95c9-6ff39ff697ba", response.getId());
    assertEquals(SettlementStatus.PENDING, response.getStatus());
    assertEquals(500, response.getAvailableToRefund());
  }

  @Test
  void testProcessSettlement_throwsExceptionOnUnauthorizedAccessError() {
    stubServer.stub("POST", String.format(PAYMENT_SETTLEMENT_ENDPOINT, PAYMENT_ID), UrlMatchType.PATH_EQUAL,
        StubResponse.builder().status(403).header("Content-Type", "application/json")
            .bodyFile("error/403_unauthorized_response.json").build());
    PaysafeSdkException exception = assertThrows(PaysafeSdkException.class, () -> paysafeClient.settlementService().processSettlement(PAYMENT_ID, new SettlementRequest()));
    stubServer.verify(1, "POST", String.format(PAYMENT_SETTLEMENT_ENDPOINT, PAYMENT_ID));
    assertEquals(403, exception.getCode());
    assertEquals("5270", exception.getError().getCode());
  }

  @Test
  void testProcessSettlement_throwsExceptionOnInvalidCredentialsError() {
    stubServer.stub("POST", String.format(PAYMENT_SETTLEMENT_ENDPOINT, PAYMENT_ID), UrlMatchType.PATH_EQUAL,
        StubResponse.builder().status(401).header("Content-Type", "application/json")
            .bodyFile("error/401_invalid_credentials_response.json").build());
    PaysafeSdkException exception = assertThrows(PaysafeSdkException.class, () -> paysafeClient.settlementService().processSettlement(PAYMENT_ID, new SettlementRequest()));
    stubServer.verify(1, "POST", String.format(PAYMENT_SETTLEMENT_ENDPOINT, PAYMENT_ID));
    assertEquals(401, exception.getCode());
    assertEquals("5279", exception.getError().getCode());
  }

  @Test
  void testProcessSettlement_throwsExceptionOnEntityNotFoundError() {
    stubServer.stub("POST", String.format(PAYMENT_SETTLEMENT_ENDPOINT, "invalid-payment-id"), UrlMatchType.PATH_EQUAL,
        StubResponse.builder().status(404).header("Content-Type", "application/json")
            .bodyFile("error/404_entity_not_found_response.json").build());
    PaysafeSdkException exception = assertThrows(PaysafeSdkException.class, () -> paysafeClient.settlementService().processSettlement("invalid-payment-id", new SettlementRequest()));
    stubServer.verify(1, "POST", String.format(PAYMENT_SETTLEMENT_ENDPOINT, "invalid-payment-id"));
    assertEquals(404, exception.getCode());
    assertEquals("5269", exception.getError().getCode());
  }

  @Test
  void testProcessSettlement_throwsPaysafeSdkExceptionOnIOError() {
    stubServer.stub("POST", String.format(PAYMENT_SETTLEMENT_ENDPOINT, PAYMENT_ID), UrlMatchType.PATH_EQUAL, StubResponse.fault());
    ApiConnectionException exception = assertThrows(ApiConnectionException.class, () -> paysafeClient.settlementService().processSettlement(PAYMENT_ID, new SettlementRequest()));
    stubServer.verify(1, "POST", String.format(PAYMENT_SETTLEMENT_ENDPOINT, PAYMENT_ID));
    assertTrue(exception.getMessage().contains("Error connecting to " + baseUrl));
  }

  @Test
  void testGetSettlementById_isSuccessful() throws PaysafeSdkException {
    stubServer.stub("GET", String.format("%s/%s", SETTLEMENT_ENDPOINT, SETTLEMENT_ID), UrlMatchType.PATH_EQUAL,
        StubResponse.builder().status(200).header("Content-Type", "application/json")
            .bodyFile("settlement/get_settlement_by_id_response.json").build());
    Settlement response = paysafeClient.settlementService().getSettlementById(SETTLEMENT_ID);
    stubServer.verify(1, "GET", String.format("%s/%s", SETTLEMENT_ENDPOINT, SETTLEMENT_ID));
    assertNotNull(response);
    assertEquals(SETTLEMENT_ID, response.getId());
  }

  @Test
  void testGetSettlementById_throwsExceptionOnUnauthorizedAccessError() {
    stubServer.stub("GET", String.format("%s/%s", SETTLEMENT_ENDPOINT, SETTLEMENT_ID), UrlMatchType.PATH_EQUAL,
        StubResponse.builder().status(403).header("Content-Type", "application/json")
            .bodyFile("error/403_unauthorized_response.json").build());
    PaysafeSdkException exception = assertThrows(PaysafeSdkException.class, () -> paysafeClient.settlementService().getSettlementById(SETTLEMENT_ID));
    stubServer.verify(1, "GET", String.format("%s/%s", SETTLEMENT_ENDPOINT, SETTLEMENT_ID));
    assertEquals("5270", exception.getError().getCode());
  }

  @Test
  void testGetSettlementById_throwsExceptionOnInvalidCredentialsError() {
    stubServer.stub("GET", String.format("%s/%s", SETTLEMENT_ENDPOINT, SETTLEMENT_ID), UrlMatchType.PATH_EQUAL,
        StubResponse.builder().status(401).header("Content-Type", "application/json")
            .bodyFile("error/401_invalid_credentials_response.json").build());
    PaysafeSdkException exception = assertThrows(PaysafeSdkException.class, () -> paysafeClient.settlementService().getSettlementById(SETTLEMENT_ID));
    stubServer.verify(1, "GET", String.format("%s/%s", SETTLEMENT_ENDPOINT, SETTLEMENT_ID));
    assertEquals(401, exception.getCode());
    assertEquals("5279", exception.getError().getCode());
  }

  @Test
  void testGetSettlementById_throwsPaysafeSdkExceptionOnIOError() {
    stubServer.stub("GET", String.format("%s/%s", SETTLEMENT_ENDPOINT, SETTLEMENT_ID), UrlMatchType.PATH_EQUAL, StubResponse.fault());
    PaysafeSdkException exception = assertThrows(PaysafeSdkException.class, () -> paysafeClient.settlementService().getSettlementById(SETTLEMENT_ID));
    stubServer.verify(3, "GET", String.format("%s/%s", SETTLEMENT_ENDPOINT, SETTLEMENT_ID));
    assertTrue(exception.getMessage().contains("Error connecting to " + baseUrl));
  }

  @Test
  void testGetSettlementsByMerchantReferenceNumber_isSuccessful() throws PaysafeSdkException {
    stubServer.stub("GET", SETTLEMENT_ENDPOINT, UrlMatchType.PATH_EQUAL,
        StubResponse.builder().status(200).header("Content-Type", "application/json")
            .bodyFile("settlement/get_settlement_using_merchant_ref_number_response.json").build());
    SettlementList response = paysafeClient.settlementService().getSettlementsUsingMerchantReferenceNumber(MERCHANT_REF_NUM, null, null, null, null);
    stubServer.verify(1, "GET", String.format("%s?merchantRefNum=%s", SETTLEMENT_ENDPOINT, MERCHANT_REF_NUM));
    assertNotNull(response);
    assertNotNull(response.getMeta());
    assertFalse(response.getSettlements().isEmpty());
  }

  @Test
  void testGetSettlementsByMerchantReferenceNumber_queryParamsAreSetCorrectly() throws PaysafeSdkException {
    stubServer.stub("GET", SETTLEMENT_ENDPOINT, UrlMatchType.PATH_EQUAL,
        StubResponse.builder().status(200).header("Content-Type", "application/json")
            .bodyFile("settlement/get_settlement_using_merchant_ref_number_response.json").build());
    paysafeClient.settlementService().getSettlementsUsingMerchantReferenceNumber(MERCHANT_REF_NUM, "2022-12-19", 32, 0, "2022-11-18");
    stubServer.verifyByPath(1, "GET", SETTLEMENT_ENDPOINT);
  }

  @Test
  void testGetSettlementsByMerchantReferenceNumber_throwsExceptionOnInvalidCredentialsError() {
    stubServer.stub("GET", SETTLEMENT_ENDPOINT, UrlMatchType.PATH_EQUAL,
        StubResponse.builder().status(401).header("Content-Type", "application/json")
            .bodyFile("error/401_invalid_credentials_response.json").build());
    PaysafeSdkException exception = assertThrows(PaysafeSdkException.class,
        () -> paysafeClient.settlementService().getSettlementsUsingMerchantReferenceNumber(MERCHANT_REF_NUM, null, null, 0, "2022-11-18"));
    stubServer.verifyByPath(1, "GET", SETTLEMENT_ENDPOINT);
    assertEquals(401, exception.getCode());
    assertEquals("5279", exception.getError().getCode());
  }

  @Test
  void testGetSettlementsByMerchantReferenceNumber_throwsExceptionOnUnauthorizedAccessError() {
    stubServer.stub("GET", SETTLEMENT_ENDPOINT, UrlMatchType.PATH_EQUAL,
        StubResponse.builder().status(403).header("Content-Type", "application/json")
            .bodyFile("error/403_unauthorized_response.json").build());
    PaysafeSdkException exception = assertThrows(PaysafeSdkException.class,
        () -> paysafeClient.settlementService().getSettlementsUsingMerchantReferenceNumber(MERCHANT_REF_NUM, null, null, 0, "2022-11-18"));
    stubServer.verifyByPath(1, "GET", SETTLEMENT_ENDPOINT);
    assertEquals(403, exception.getCode());
    assertEquals("5270", exception.getError().getCode());
  }

  @Test
  void testCancelSettlement_isSuccessful() throws PaysafeSdkException {
    stubServer.stub("PUT", String.format("%s/%s", SETTLEMENT_ENDPOINT, SETTLEMENT_ID), UrlMatchType.PATH_EQUAL,
        StubResponse.builder().status(200).header("Content-Type", "application/json")
            .bodyFile("settlement/cancel_settlement_response.json").build());
    CancelRequest cancelRequest = CancelRequest.builder().status(TransactionRequestStatus.CANCELLED).build();
    CancelResponse response = paysafeClient.settlementService().cancelSettlement(SETTLEMENT_ID, cancelRequest);
    stubServer.verify(1, "PUT", String.format("%s/%s", SETTLEMENT_ENDPOINT, SETTLEMENT_ID));
    assertNotNull(response);
    assertEquals(SETTLEMENT_ID, response.getId());
    assertEquals(TransactionRequestStatus.CANCELLED, response.getStatus());
  }

  @Test
  void testCancelSettlement_throwsExceptionOnInvalidCredentialsError() {
    stubServer.stub("PUT", String.format("%s/%s", SETTLEMENT_ENDPOINT, SETTLEMENT_ID), UrlMatchType.PATH_EQUAL,
        StubResponse.builder().status(401).header("Content-Type", "application/json")
            .bodyFile("error/401_invalid_credentials_response.json").build());
    CancelRequest cancelRequest = CancelRequest.builder().status(TransactionRequestStatus.CANCELLED).build();
    PaysafeSdkException exception = assertThrows(PaysafeSdkException.class, () -> paysafeClient.settlementService().cancelSettlement(SETTLEMENT_ID, cancelRequest));
    stubServer.verify(1, "PUT", String.format("%s/%s", SETTLEMENT_ENDPOINT, SETTLEMENT_ID));
    assertEquals(401, exception.getCode());
    assertEquals("5279", exception.getError().getCode());
  }

  @Test
  void testCancelSettlement_throwsExceptionOnUnauthorizedAccessError() {
    stubServer.stub("PUT", String.format("%s/%s", SETTLEMENT_ENDPOINT, SETTLEMENT_ID), UrlMatchType.PATH_EQUAL,
        StubResponse.builder().status(403).header("Content-Type", "application/json")
            .bodyFile("error/403_unauthorized_response.json").build());
    CancelRequest cancelRequest = CancelRequest.builder().status(TransactionRequestStatus.CANCELLED).build();
    PaysafeSdkException exception = assertThrows(PaysafeSdkException.class, () -> paysafeClient.settlementService().cancelSettlement(SETTLEMENT_ID, cancelRequest));
    stubServer.verify(1, "PUT", String.format("%s/%s", SETTLEMENT_ENDPOINT, SETTLEMENT_ID));
    assertEquals(403, exception.getCode());
    assertEquals("5270", exception.getError().getCode());
  }

  @Test
  void testCancelSettlement_throwsExceptionOnEntityNotFoundError() {
    stubServer.stub("PUT", String.format("%s/%s", SETTLEMENT_ENDPOINT, "invalid-settlement-id"), UrlMatchType.PATH_EQUAL,
        StubResponse.builder().status(404).header("Content-Type", "application/json")
            .bodyFile("error/404_entity_not_found_response.json").build());
    CancelRequest cancelRequest = CancelRequest.builder().status(TransactionRequestStatus.CANCELLED).build();
    PaysafeSdkException exception = assertThrows(PaysafeSdkException.class, () -> paysafeClient.settlementService().cancelSettlement("invalid-settlement-id", cancelRequest));
    stubServer.verify(1, "PUT", String.format("%s/%s", SETTLEMENT_ENDPOINT, "invalid-settlement-id"));
    assertEquals(404, exception.getCode());
    assertEquals("5269", exception.getError().getCode());
  }
}