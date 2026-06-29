// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.paysafe.payments.base.BaseStubServerTest;
import com.paysafe.payments.base.TestStubServer.StubResponse;
import com.paysafe.payments.base.TestStubServer.UrlMatchType;
import com.paysafe.payments.errorhandling.exception.PaysafeSdkException;
import com.paysafe.payments.model.common.cancel.CancelRequest;
import com.paysafe.payments.model.common.cancel.CancelResponse;
import com.paysafe.payments.model.common.enums.CurrencyCode;
import com.paysafe.payments.model.common.enums.TransactionRequestStatus;
import com.paysafe.payments.model.lpm.Interac;
import com.paysafe.payments.model.lpm.enums.InteracFraudStatus;
import com.paysafe.payments.model.lpm.enums.InteracFraudType;
import com.paysafe.payments.model.standalonecredit.StandaloneCredit;
import com.paysafe.payments.model.standalonecredit.StandaloneCreditList;
import com.paysafe.payments.model.standalonecredit.StandaloneCreditRequest;
import com.paysafe.payments.model.standalonecredit.StandaloneCreditUpdateRequest;

class StandaloneCreditServiceTest extends BaseStubServerTest {

  private static final String STANDALONE_CREDIT_ENDPOINT = "/paymenthub/v1/standalonecredits";
  private static final String MERCHANT_REF_NUM = "32be35aac78dbfe252a2";
  private static final String STANDALONE_CREDIT_ID = "eddbec36-6fc7-48fb-a694-dfc5b314ec0d";

  @Test
  void testProcessStandaloneCredit_isSuccessful() throws PaysafeSdkException {
    stubServer.stub("POST", STANDALONE_CREDIT_ENDPOINT, UrlMatchType.PATH_EQUAL,
        StubResponse.builder().status(200).header("Content-Type", "application/json")
            .bodyFile("standalone_credit/process_standalone_credit_card_response.json").build());
    StandaloneCreditRequest creditRequest = StandaloneCreditRequest.builder().merchantRefNum("32be35aac78dbfe252a2").amount(500).currencyCode(CurrencyCode.USD).paymentHandleToken("SCQp7CmWCSRFmvzv").description("Winning payment from Loto 649").build();
    StandaloneCredit standaloneCredit = paysafeClient.standaloneCreditService().processStandaloneCredit(creditRequest);
    stubServer.verifyByPath(1, "POST", STANDALONE_CREDIT_ENDPOINT);
    assertNotNull(standaloneCredit);
  }

  @Test
  void testGetStandaloneCreditsUsingMerchantReferenceNumber_isSuccessful() throws PaysafeSdkException {
    stubServer.stub("GET", STANDALONE_CREDIT_ENDPOINT, UrlMatchType.PATH_EQUAL,
        StubResponse.builder().status(200).header("Content-Type", "application/json")
            .bodyFile("standalone_credit/get_standalone_credit_using_merchant_ref_number_response.json").build());
    StandaloneCreditList response = paysafeClient.standaloneCreditService().getStandaloneCreditUsingMerchantReferenceNumber(MERCHANT_REF_NUM, null, null, null, null);
    stubServer.verifyByPath(1, "GET", STANDALONE_CREDIT_ENDPOINT);
    assertNotNull(response);
    assertEquals(1, response.getMeta().getNumberOfRecords());
    assertFalse(response.getStandaloneCredits().isEmpty());
    assertEquals(MERCHANT_REF_NUM, response.getStandaloneCredits().get(0).getMerchantRefNum());
  }

  @Test
  void testGetStandaloneCreditsUsingMerchantReferenceNumber_throwsExceptionOnEntityNotFoundError() {
    stubServer.stub("GET", STANDALONE_CREDIT_ENDPOINT, UrlMatchType.PATH_EQUAL,
        StubResponse.builder().status(404).header("Content-Type", "application/json")
            .bodyFile("error/404_entity_not_found_response.json").build());
    PaysafeSdkException exception = assertThrows(PaysafeSdkException.class,
        () -> paysafeClient.standaloneCreditService().getStandaloneCreditUsingMerchantReferenceNumber(MERCHANT_REF_NUM, null, 10, 0, null));
    stubServer.verifyByPath(1, "GET", STANDALONE_CREDIT_ENDPOINT);
    assertEquals(404, exception.getCode());
    assertEquals("5269", exception.getError().getCode());
  }

  @Test
  void testGetStandaloneCreditById_isSuccessful() throws PaysafeSdkException {
    stubServer.stub("GET", STANDALONE_CREDIT_ENDPOINT + "/" + STANDALONE_CREDIT_ID, UrlMatchType.PATH_EQUAL,
        StubResponse.builder().status(200).header("Content-Type", "application/json")
            .bodyFile("standalone_credit/get_standalone_credit_by_id_response.json").build());
    StandaloneCredit response = paysafeClient.standaloneCreditService().getStandaloneCreditById(STANDALONE_CREDIT_ID);
    stubServer.verifyByPath(1, "GET", STANDALONE_CREDIT_ENDPOINT + "/" + STANDALONE_CREDIT_ID);
    assertNotNull(response);
    assertEquals(STANDALONE_CREDIT_ID, response.getId());
    assertEquals(MERCHANT_REF_NUM, response.getMerchantRefNum());
    assertEquals(CurrencyCode.USD, response.getCurrencyCode());
    assertEquals(500, response.getAmount());
    assertEquals("SIM1UZ3YM7IS1", response.getCardSchemeTransactionId());
  }

  @Test
  void testGetStandaloneCreditById_throwsExceptionOnEntityNotFoundError() {
    String standaloneCreditId = "bad-id";
    stubServer.stub("GET", STANDALONE_CREDIT_ENDPOINT + "/" + standaloneCreditId, UrlMatchType.PATH_EQUAL,
        StubResponse.builder().status(404).header("Content-Type", "application/json")
            .bodyFile("error/404_entity_not_found_response.json").build());
    PaysafeSdkException exception = assertThrows(PaysafeSdkException.class,
        () -> paysafeClient.standaloneCreditService().getStandaloneCreditById(standaloneCreditId));
    stubServer.verifyByPath(1, "GET", STANDALONE_CREDIT_ENDPOINT + "/" + standaloneCreditId);
    assertEquals(404, exception.getCode());
    assertEquals("5269", exception.getError().getCode());
  }

  @Test
  void testCancelStandaloneCredit_isSuccessful() throws PaysafeSdkException {
    stubServer.stub("PUT", String.format("%s/%s", STANDALONE_CREDIT_ENDPOINT, STANDALONE_CREDIT_ID), UrlMatchType.PATH_EQUAL,
        StubResponse.builder().status(200).header("Content-Type", "application/json")
            .bodyFile("standalone_credit/cancel_standalone_credit_response.json").build());
    CancelRequest cancelRequest = CancelRequest.builder().status(TransactionRequestStatus.CANCELLED).build();
    CancelResponse response = paysafeClient.standaloneCreditService().cancelStandaloneCredit(STANDALONE_CREDIT_ID, cancelRequest);
    stubServer.verify(1, "PUT", String.format("%s/%s", STANDALONE_CREDIT_ENDPOINT, STANDALONE_CREDIT_ID));
    assertNotNull(response);
    assertEquals(STANDALONE_CREDIT_ID, response.getId());
    assertEquals(TransactionRequestStatus.CANCELLED, response.getStatus());
  }

  @Test
  void testCancelStandaloneCredit_throwsExceptionOnEntityNotFoundError() {
    String invalidId = "invalid-credit-id";
    stubServer.stub("PUT", String.format("%s/%s", STANDALONE_CREDIT_ENDPOINT, invalidId), UrlMatchType.PATH_EQUAL,
        StubResponse.builder().status(404).header("Content-Type", "application/json")
            .bodyFile("error/404_entity_not_found_response.json").build());
    CancelRequest cancelRequest = CancelRequest.builder().status(TransactionRequestStatus.CANCELLED).build();
    PaysafeSdkException exception = assertThrows(PaysafeSdkException.class,
        () -> paysafeClient.standaloneCreditService().cancelStandaloneCredit(invalidId, cancelRequest));
    stubServer.verify(1, "PUT", String.format("%s/%s", STANDALONE_CREDIT_ENDPOINT, invalidId));
    assertEquals(404, exception.getCode());
    assertEquals("5269", exception.getError().getCode());
  }

  @Test
  void testPatchStandaloneCreditStatusForInteracFraud_isSuccessful() throws PaysafeSdkException {
    String standaloneCreditId = "a2afe762-2421-4d57-9c5e-17b06bfb2af6";
    stubServer.stub("PATCH", String.format("%s/%s", STANDALONE_CREDIT_ENDPOINT, standaloneCreditId), UrlMatchType.PATH_EQUAL,
        StubResponse.builder().status(200).header("Content-Type", "application/json")
            .bodyFile("standalone_credit/patch_standalone_credit_response.json").build());
    StandaloneCreditUpdateRequest updateRequest = StandaloneCreditUpdateRequest.builder()
        .interacEtransfer(Interac.builder().consumerId("123456").fraudStatus(InteracFraudStatus.CONFIRM_FRAUD).fraudType(InteracFraudType.FRAUD_BUSINESS).build()).build();
    StandaloneCredit response = paysafeClient.standaloneCreditService().patchStandaloneCreditStatusForInteracFraud(standaloneCreditId, updateRequest);
    stubServer.verify(1, "PATCH", String.format("%s/%s", STANDALONE_CREDIT_ENDPOINT, standaloneCreditId));
    assertNotNull(response);
    assertEquals(standaloneCreditId, response.getId());
  }

  @Test
  void testPatchStandaloneCreditStatusForInteracFraud_throwsExceptionOnEntityNotFoundError() {
    String invalidId = "invalid-credit-id";
    stubServer.stub("PATCH", String.format("%s/%s", STANDALONE_CREDIT_ENDPOINT, invalidId), UrlMatchType.PATH_EQUAL,
        StubResponse.builder().status(404).header("Content-Type", "application/json")
            .bodyFile("error/404_entity_not_found_response.json").build());
    StandaloneCreditUpdateRequest updateRequest = StandaloneCreditUpdateRequest.builder()
        .interacEtransfer(Interac.builder().consumerId("123456").fraudStatus(InteracFraudStatus.CONFIRM_FRAUD).fraudType(InteracFraudType.FRAUD_BUSINESS).build()).build();
    PaysafeSdkException exception = assertThrows(PaysafeSdkException.class,
        () -> paysafeClient.standaloneCreditService().patchStandaloneCreditStatusForInteracFraud(invalidId, updateRequest));
    stubServer.verify(1, "PATCH", String.format("%s/%s", STANDALONE_CREDIT_ENDPOINT, invalidId));
    assertEquals(404, exception.getCode());
    assertEquals("5269", exception.getError().getCode());
  }
}
