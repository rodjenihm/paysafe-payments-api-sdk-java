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
import com.paysafe.payments.model.originalcredit.OriginalCredit;
import com.paysafe.payments.model.originalcredit.OriginalCreditList;
import com.paysafe.payments.model.originalcredit.OriginalCreditRequest;
import com.paysafe.payments.model.paymenthandle.enums.PaymentType;

class OriginalCreditServiceTest extends BaseStubServerTest {

  public static final String ORIGINAL_CREDIT_ENDPOINT = "/paymenthub/v1/originalcredits";
  private static final String ORIGINAL_CREDIT_ID = "e075f2ae-dfc4-4f6d-8d89-61158367b6a6";

  @Test
  void testProcessOriginalCredit_isSuccessful() throws PaysafeSdkException {
    stubServer.stub("POST", ORIGINAL_CREDIT_ENDPOINT, UrlMatchType.PATH_EQUAL,
        StubResponse.builder().status(200).header("Content-Type", "application/json")
            .bodyFile("original_credit/process_original_credit_card_response.json").build());
    OriginalCreditRequest req = OriginalCreditRequest.builder().amount(100).merchantRefNum("05e19427-a3d1-46f7-8b2e-bdf8ced0341e").currencyCode(CurrencyCode.USD).customerIp("204.91.0.12").description("Winning payment from Loto 649").build();
    OriginalCredit originalCredit = paysafeClient.originalCreditService().processOriginalCredit(req);
    stubServer.verify(1, "POST", ORIGINAL_CREDIT_ENDPOINT);
    assertNotNull(originalCredit);
    assertEquals("ee9010926e3edd01a799", originalCredit.getMerchantRefNum());
  }

  @Test
  void testProcessOriginalCredit_throwsExceptionOnEntityNotFoundError() {
    stubServer.stub("POST", ORIGINAL_CREDIT_ENDPOINT, UrlMatchType.PATH_EQUAL,
        StubResponse.builder().status(404).header("Content-Type", "application/json")
            .bodyFile("error/404_entity_not_found_response.json").build());
    OriginalCreditRequest req = OriginalCreditRequest.builder().amount(100).merchantRefNum("invalid-merchant-ref-num").currencyCode(CurrencyCode.USD).build();
    PaysafeSdkException exception = assertThrows(PaysafeSdkException.class, () -> paysafeClient.originalCreditService().processOriginalCredit(req));
    stubServer.verify(1, "POST", ORIGINAL_CREDIT_ENDPOINT);
    assertEquals(404, exception.getCode());
    assertEquals("5269", exception.getError().getCode());
  }

  @Test
  void testGetOriginalCreditById_isSuccessful() throws PaysafeSdkException {
    stubServer.stub("GET", String.format("%s/%s", ORIGINAL_CREDIT_ENDPOINT, ORIGINAL_CREDIT_ID), UrlMatchType.PATH_EQUAL,
        StubResponse.builder().status(200).header("Content-Type", "application/json")
            .bodyFile("original_credit/get_original_credit_by_id_response.json").build());
    OriginalCredit response = paysafeClient.originalCreditService().getOriginalCreditById(ORIGINAL_CREDIT_ID);
    stubServer.verify(1, "GET", String.format("%s/%s", ORIGINAL_CREDIT_ENDPOINT, ORIGINAL_CREDIT_ID));
    assertNotNull(response);
    assertEquals(ORIGINAL_CREDIT_ID, response.getId());
    assertEquals(PaymentType.CARD, response.getPaymentType());
    assertEquals("merchantRefNum-151", response.getMerchantRefNum());
  }

  @Test
  void testGetOriginalCreditById_throwsExceptionOnEntityNotFoundError() {
    stubServer.stub("GET", String.format("%s/%s", ORIGINAL_CREDIT_ENDPOINT, ORIGINAL_CREDIT_ID), UrlMatchType.PATH_EQUAL,
        StubResponse.builder().status(404).header("Content-Type", "application/json")
            .bodyFile("error/404_entity_not_found_response.json").build());
    PaysafeSdkException exception = assertThrows(PaysafeSdkException.class, () -> paysafeClient.originalCreditService().getOriginalCreditById(ORIGINAL_CREDIT_ID));
    stubServer.verify(1, "GET", String.format("%s/%s", ORIGINAL_CREDIT_ENDPOINT, ORIGINAL_CREDIT_ID));
    assertEquals(404, exception.getCode());
    assertEquals("5269", exception.getError().getCode());
  }

  @Test
  void testGetOriginalCreditUsingMerchantReferenceNumber_isSuccessful() throws PaysafeSdkException {
    stubServer.stub("GET", ORIGINAL_CREDIT_ENDPOINT, UrlMatchType.PATH_EQUAL,
        StubResponse.builder().status(200).header("Content-Type", "application/json")
            .bodyFile("original_credit/get_original_credit_using_merchant_ref_number_response.json").build());
    OriginalCreditList response = paysafeClient.originalCreditService().getOriginalCreditUsingMerchantReferenceNumber("merchantRefNum-151", null, null, null, null);
    stubServer.verifyByPath(1, "GET", ORIGINAL_CREDIT_ENDPOINT);
    assertNotNull(response);
    assertEquals(1, response.getMeta().getNumberOfRecords());
    assertFalse(response.getOriginalCredits().isEmpty());
    assertEquals("merchantRefNum-151", response.getOriginalCredits().get(0).getMerchantRefNum());
  }

  @Test
  void testGetOriginalCreditUsingMerchantReferenceNumber_throwsExceptionOnEntityNotFoundError() {
    stubServer.stub("GET", ORIGINAL_CREDIT_ENDPOINT, UrlMatchType.PATH_EQUAL,
        StubResponse.builder().status(404).header("Content-Type", "application/json")
            .bodyFile("error/404_entity_not_found_response.json").build());
    PaysafeSdkException exception = assertThrows(PaysafeSdkException.class,
        () -> paysafeClient.originalCreditService().getOriginalCreditUsingMerchantReferenceNumber("merchantRefNum-151", null, null, null, null));
    stubServer.verifyByPath(1, "GET", ORIGINAL_CREDIT_ENDPOINT);
    assertEquals(404, exception.getCode());
    assertEquals("5269", exception.getError().getCode());
  }

  @Test
  void testCancelOriginalCredit_isSuccessful() throws PaysafeSdkException {
    stubServer.stub("PUT", String.format("%s/%s", ORIGINAL_CREDIT_ENDPOINT, ORIGINAL_CREDIT_ID), UrlMatchType.PATH_EQUAL,
        StubResponse.builder().status(200).header("Content-Type", "application/json")
            .bodyFile("original_credit/cancel_original_credit_response.json").build());
    CancelRequest cancelRequest = CancelRequest.builder().status(TransactionRequestStatus.CANCELLED).build();
    CancelResponse response = paysafeClient.originalCreditService().cancelOriginalCredit(ORIGINAL_CREDIT_ID, cancelRequest);
    stubServer.verify(1, "PUT", String.format("%s/%s", ORIGINAL_CREDIT_ENDPOINT, ORIGINAL_CREDIT_ID));
    assertNotNull(response);
    assertEquals(ORIGINAL_CREDIT_ID, response.getId());
    assertEquals(TransactionRequestStatus.CANCELLED, response.getStatus());
  }

  @Test
  void testCancelOriginalCredit_throwsExceptionOnEntityNotFoundError() {
    stubServer.stub("PUT", String.format("%s/%s", ORIGINAL_CREDIT_ENDPOINT, "invalid-original-credit-id"), UrlMatchType.PATH_EQUAL,
        StubResponse.builder().status(404).header("Content-Type", "application/json")
            .bodyFile("error/404_entity_not_found_response.json").build());
    CancelRequest cancelRequest = CancelRequest.builder().status(TransactionRequestStatus.CANCELLED).build();
    PaysafeSdkException exception = assertThrows(PaysafeSdkException.class,
        () -> paysafeClient.originalCreditService().cancelOriginalCredit("invalid-original-credit-id", cancelRequest));
    stubServer.verify(1, "PUT", String.format("%s/%s", ORIGINAL_CREDIT_ENDPOINT, "invalid-original-credit-id"));
    assertEquals(404, exception.getCode());
    assertEquals("5269", exception.getError().getCode());
  }
}
