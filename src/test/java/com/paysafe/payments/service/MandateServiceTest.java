// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.paysafe.payments.base.BaseStubServerTest;
import com.paysafe.payments.base.TestStubServer.StubResponse;
import com.paysafe.payments.base.TestStubServer.UrlMatchType;
import com.paysafe.payments.errorhandling.exception.PaysafeSdkException;
import com.paysafe.payments.model.common.Mandate;
import com.paysafe.payments.model.common.enums.MandateStatus;
import com.paysafe.payments.model.common.enums.MandateStatusReason;

class MandateServiceTest extends BaseStubServerTest {

  private static final String MANDATES_ENDPOINT = "/paymenthub/v1/customers/%s/paymenthandles/%s/mandates";
  private static final String MANDATE_BY_ID_ENDPOINT = "/paymenthub/v1/customers/%s/paymenthandles/%s/mandates/%s";
  private static final String CUSTOMER_ID = "921cd968-6882-422c-ae4f-a10ddbae95ff";
  private static final String PAYMENT_HANDLE_ID = "c672fd10-962e-4f57-a1f2-1c3105ffe5d3";
  private static final String MANDATE_ID = "fb24c07e-7a7d-4334-b3b1-c32af1541aa7";
  private static final String NON_EXISTING_MANDATE_ID = "00000000-0000-0000-0000-000000000000";

  @Test
  void testCreateMandate_isSuccessful() throws PaysafeSdkException {
    final String urlPath = String.format(MANDATES_ENDPOINT, CUSTOMER_ID, PAYMENT_HANDLE_ID);

    stubServer.stub("POST", urlPath, UrlMatchType.PATH_EQUAL,
        StubResponse.builder()
            .status(201)
            .header("Content-Type", "application/json")
            .bodyFile("mandate/create_mandate_response.json")
            .build());

    Map<String, Object> requestBody = new HashMap<>();
    requestBody.put("reference", "GTWYRM6230");

    Mandate mandate = paysafeClient.mandateService().createMandate(CUSTOMER_ID, PAYMENT_HANDLE_ID, requestBody, null);

    stubServer.verify(1, "POST", urlPath);
    assertNotNull(mandate);
    assertEquals("fb24c07e-7a7d-4334-b3b1-c32af1541aa7", mandate.getId());
    assertEquals("GTWYRM6230", mandate.getReference());
    assertEquals(MandateStatus.PENDING, mandate.getStatus());
  }

  @Test
  void testCreateMandate_notFound_throwsException() {
    final String urlPath = String.format(MANDATES_ENDPOINT, CUSTOMER_ID, PAYMENT_HANDLE_ID);

    stubServer.stub("POST", urlPath, UrlMatchType.PATH_EQUAL,
        StubResponse.builder()
            .status(404)
            .header("Content-Type", "application/json")
            .bodyFile("error/404_entity_not_found_response.json")
            .build());

    Map<String, Object> requestBody = new HashMap<>();
    requestBody.put("reference", "GTWYRM6230");

    assertThrows(PaysafeSdkException.class,
        () -> paysafeClient.mandateService().createMandate(CUSTOMER_ID, PAYMENT_HANDLE_ID, requestBody, null));
  }

  @Test
  void testGetMandateStatus_isSuccessful() throws PaysafeSdkException {
    final String urlPath = String.format(MANDATE_BY_ID_ENDPOINT, CUSTOMER_ID, PAYMENT_HANDLE_ID, MANDATE_ID);

    stubServer.stub("GET", urlPath, UrlMatchType.PATH_EQUAL,
        StubResponse.builder()
            .status(200)
            .header("Content-Type", "application/json")
            .bodyFile("mandate/get_mandate_response.json")
            .build());

    Mandate mandate = paysafeClient.mandateService().getMandateStatus(CUSTOMER_ID, PAYMENT_HANDLE_ID, MANDATE_ID, null);

    stubServer.verify(1, "GET", urlPath);
    assertNotNull(mandate);
    assertEquals("fb24c07e-7a7d-4334-b3b1-c32af1541aa7", mandate.getId());
    assertEquals("GTWYRM6230", mandate.getReference());
    assertEquals(MandateStatus.PENDING, mandate.getStatus());
  }

  @Test
  void testGetMandateStatus_notFound_throwsException() {
    final String urlPath = String.format(MANDATE_BY_ID_ENDPOINT, CUSTOMER_ID, PAYMENT_HANDLE_ID, NON_EXISTING_MANDATE_ID);

    stubServer.stub("GET", urlPath, UrlMatchType.PATH_EQUAL,
        StubResponse.builder()
            .status(404)
            .header("Content-Type", "application/json")
            .bodyFile("error/404_entity_not_found_response.json")
            .build());

    assertThrows(PaysafeSdkException.class,
        () -> paysafeClient.mandateService().getMandateStatus(CUSTOMER_ID, PAYMENT_HANDLE_ID, NON_EXISTING_MANDATE_ID, null));
  }

  @Test
  void testCancelMandate_isSuccessful() throws PaysafeSdkException {
    final String urlPath = String.format(MANDATE_BY_ID_ENDPOINT, CUSTOMER_ID, PAYMENT_HANDLE_ID, MANDATE_ID);

    stubServer.stub("PUT", urlPath, UrlMatchType.PATH_EQUAL,
        StubResponse.builder()
            .status(200)
            .header("Content-Type", "application/json")
            .bodyFile("mandate/cancel_mandate_response.json")
            .build());

    Map<String, Object> requestBody = new HashMap<>();
    requestBody.put("status", "CANCELLED");

    Mandate mandate = paysafeClient.mandateService().cancelMandate(CUSTOMER_ID, PAYMENT_HANDLE_ID, MANDATE_ID, requestBody, null);

    stubServer.verify(1, "PUT", urlPath);
    assertNotNull(mandate);
    assertEquals("fb24c07e-7a7d-4334-b3b1-c32af1541aa7", mandate.getId());
    assertEquals("GTWYRM6230", mandate.getReference());
    assertEquals(MandateStatus.CANCELLED, mandate.getStatus());
    assertEquals(MandateStatusReason.MERCHANT_CANCELLED, mandate.getStatusReason());
  }

  @Test
  void testCancelMandate_notFound_throwsException() {
    final String urlPath = String.format(MANDATE_BY_ID_ENDPOINT, CUSTOMER_ID, PAYMENT_HANDLE_ID, NON_EXISTING_MANDATE_ID);

    stubServer.stub("PUT", urlPath, UrlMatchType.PATH_EQUAL,
        StubResponse.builder()
            .status(404)
            .header("Content-Type", "application/json")
            .bodyFile("error/404_entity_not_found_response.json")
            .build());

    Map<String, Object> requestBody = new HashMap<>();
    requestBody.put("status", "CANCELLED");

    assertThrows(PaysafeSdkException.class,
        () -> paysafeClient.mandateService().cancelMandate(CUSTOMER_ID, PAYMENT_HANDLE_ID, NON_EXISTING_MANDATE_ID, requestBody, null));
  }
}
