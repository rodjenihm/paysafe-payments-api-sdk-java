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
import com.paysafe.payments.model.common.enums.TransactionRequestStatus;
import com.paysafe.payments.model.refund.Refund;
import com.paysafe.payments.model.refund.RefundList;
import com.paysafe.payments.model.refund.RefundRequest;

class RefundServiceTest extends BaseStubServerTest {

  public static final String PROCESS_REFUND_ENDPOINT = "/paymenthub/v1/settlements/%s/refunds";
  public static final String REFUND_ENDPOINT = "/paymenthub/v1/refunds";
  public static final String REFUND_ID = "6cf00c1c-fb83-4cc8-a7cc-cd9118ce4f53";
  public static final String SETTLEMENT_ID = "3aeb9c63-6386-46a3-9f8e-f452e722228a";
  public static final String MERCHANT_REF_NUM = "a9318b525273ee3cda79a2f947a9";

  @Test
  void testProcessRefund_isSuccessful() throws PaysafeSdkException {
    String urlPath = String.format(PROCESS_REFUND_ENDPOINT, SETTLEMENT_ID);
    stubServer.stub("POST", urlPath, UrlMatchType.PATH_EQUAL,
        StubResponse.builder().status(200).header("Content-Type", "application/json")
            .bodyFile("refund/process_refund_card_response.json").build());
    RefundRequest refundRequest = RefundRequest.builder().merchantRefNum("92cf2183-2298-44a6-99d4-5af6d727cea3").amount(500).dupCheck(true).build();
    Refund refund = paysafeClient.refundService().processRefund(SETTLEMENT_ID, refundRequest);
    stubServer.verify(1, "POST", String.format(PROCESS_REFUND_ENDPOINT, SETTLEMENT_ID));
    assertNotNull(refund);
  }

  @Test
  void testGetRefundById_isSuccessful() throws PaysafeSdkException {
    stubServer.stub("GET", String.format("%s/%s", REFUND_ENDPOINT, REFUND_ID), UrlMatchType.PATH_EQUAL,
        StubResponse.builder().status(200).header("Content-Type", "application/json")
            .bodyFile("refund/get_refund_by_id_card_response.json").build());
    Refund response = paysafeClient.refundService().getRefundById(REFUND_ID);
    stubServer.verify(1, "GET", String.format("%s/%s", REFUND_ENDPOINT, REFUND_ID));
    assertNotNull(response);
    assertEquals(REFUND_ID, response.getId());
  }

  @Test
  void testGetRefundById_throwsExceptionOnEntityNotFoundError() {
    stubServer.stub("GET", String.format("%s/%s", REFUND_ENDPOINT, REFUND_ID), UrlMatchType.PATH_EQUAL,
        StubResponse.builder().status(404).header("Content-Type", "application/json")
            .bodyFile("error/404_entity_not_found_response.json").build());
    PaysafeSdkException exception = assertThrows(PaysafeSdkException.class, () -> paysafeClient.refundService().getRefundById(REFUND_ID));
    stubServer.verify(1, "GET", String.format("%s/%s", REFUND_ENDPOINT, REFUND_ID));
    assertEquals(404, exception.getCode());
    assertEquals("5269", exception.getError().getCode());
  }

  @Test
  void testUsingMerchantReferenceNumber_isSuccessful() throws PaysafeSdkException {
    stubServer.stub("GET", REFUND_ENDPOINT, UrlMatchType.PATH_EQUAL,
        StubResponse.builder().status(200).header("Content-Type", "application/json")
            .bodyFile("refund/get_refund_using_merchant_ref_number_card_response.json").build());
    RefundList response = paysafeClient.refundService().getRefundUsingMerchantReferenceNumber(MERCHANT_REF_NUM, null, null, null, null);
    stubServer.verifyByPath(1, "GET", REFUND_ENDPOINT);
    assertNotNull(response);
    assertEquals(1, response.getMeta().getNumberOfRecords());
    assertFalse(response.getRefunds().isEmpty());
    assertEquals(MERCHANT_REF_NUM, response.getRefunds().get(0).getMerchantRefNum());
  }

  @Test
  void testUsingMerchantReferenceNumber_throwsExceptionOnEntityNotFoundError() {
    stubServer.stub("GET", REFUND_ENDPOINT, UrlMatchType.PATH_EQUAL,
        StubResponse.builder().status(404).header("Content-Type", "application/json")
            .bodyFile("error/404_entity_not_found_response.json").build());
    PaysafeSdkException exception = assertThrows(PaysafeSdkException.class,
        () -> paysafeClient.refundService().getRefundUsingMerchantReferenceNumber(MERCHANT_REF_NUM, null, null, null, null));
    stubServer.verifyByPath(1, "GET", REFUND_ENDPOINT);
    assertEquals(404, exception.getCode());
    assertEquals("5269", exception.getError().getCode());
  }

  @Test
  void testCancelRefund_isSuccessful() throws PaysafeSdkException {
    String refundId = "6cf00c1c-fb83-4cc8-a7cc-cd9118ce4f64";
    stubServer.stub("PUT", String.format("%s/%s", REFUND_ENDPOINT, refundId), UrlMatchType.PATH_EQUAL,
        StubResponse.builder().status(200).header("Content-Type", "application/json")
            .bodyFile("refund/cancel_refund_response.json").build());
    CancelRequest cancelRequest = CancelRequest.builder().status(TransactionRequestStatus.CANCELLED).build();
    CancelResponse response = paysafeClient.refundService().cancelRefund(refundId, cancelRequest);
    stubServer.verify(1, "PUT", String.format("%s/%s", REFUND_ENDPOINT, refundId));
    assertNotNull(response);
    assertEquals(refundId, response.getId());
    assertEquals(TransactionRequestStatus.CANCELLED, response.getStatus());
  }

  @Test
  void testCancelRefund_throwsExceptionOnEntityNotFoundError() {
    String invalidRefundId = "invalid-refund-id";
    stubServer.stub("PUT", String.format("%s/%s", REFUND_ENDPOINT, invalidRefundId), UrlMatchType.PATH_EQUAL,
        StubResponse.builder().status(404).header("Content-Type", "application/json")
            .bodyFile("error/404_entity_not_found_response.json").build());
    CancelRequest cancelRequest = CancelRequest.builder().status(TransactionRequestStatus.CANCELLED).build();
    PaysafeSdkException exception = assertThrows(PaysafeSdkException.class,
        () -> paysafeClient.refundService().cancelRefund(invalidRefundId, cancelRequest));
    stubServer.verify(1, "PUT", String.format("%s/%s", REFUND_ENDPOINT, invalidRefundId));
    assertEquals(404, exception.getCode());
    assertEquals("5269", exception.getError().getCode());
  }
}
