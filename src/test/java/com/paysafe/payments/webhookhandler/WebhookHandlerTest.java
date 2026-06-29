// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.webhookhandler;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.paysafe.payments.logging.SdkLogger;
import com.paysafe.payments.webhookhandler.exception.SignatureVerificationException;
import com.paysafe.payments.webhookhandler.exception.WebhookEventParsingException;
import com.paysafe.payments.webhookhandler.model.WebhookEvent;

class WebhookHandlerTest {

  private static final String SECRET_KEY = "test-secret-key";
  private WebhookHandler webhookHandler;
  private SdkLogger logger;

  @BeforeEach
  void setUp() {
    logger = mock(SdkLogger.class);
    webhookHandler = new WebhookHandler(logger);
  }

  @Test
  void parseAndValidate_validPayload_shouldReturnWebhookEvent() throws Exception {
    String payload = "{\n"
        + "    \"payload\": {\n"
        + "        \"accountId\": \"123456\",\n"
        + "        \"id\": \"99d13831-253d-42fd-751d-45fdaf8f4239\",\n"
        + "        \"merchantRefNum\": \"merchant123\",\n"
        + "        \"amount\": 500,\n"
        + "        \"currencyCode\": \"USD\",\n"
        + "        \"status\": \"COMPLETED\",\n"
        + "        \"paymentType\": \"CARD\",\n"
        + "        \"txnTime\": \"2025-08-29T09:12:20.744\",\n"
        + "        \"paymentHandleToken\": \"token123\"\n"
        + "    },\n"
        + "    \"attemptNumber\": \"1\",\n"
        + "    \"type\": \"PAYMENT_HANDLE\",\n"
        + "    \"resourceId\": \"99d13831-253d-42fd-751d-45fdaf8f4239\",\n"
        + "    \"links\": [\n"
        + "        {\n"
        + "            \"rel\": \"payment_handle\"\n"
        + "        }\n"
        + "    ],\n"
        + "    \"eventDate\": \"2026-04-28T12:41:05Z\",\n"
        + "    \"eventName\": \"PAYMENT_HANDLE_COMPLETED\"\n"
        + "}";
    String signature = "jR68qVSIGjNNebdxrLt52fWVjG0ze+9GhIBdZOX9yxA=";

    WebhookEvent event = webhookHandler.parseAndValidate(payload, signature, SECRET_KEY);

    assertNotNull(event);
    verify(logger).logEvent(eq("Webhook signature verified successfully"), isNull());
    verify(logger).logEvent("Webhook event parsed successfully", event);
  }

  @Test
  void parseAndValidate_invalidSignature_shouldThrowSignatureVerificationException() {
    assertThrows(SignatureVerificationException.class,
        () -> webhookHandler.parseAndValidate("{}", "bad-sig", SECRET_KEY));

    verify(logger).logEvent(eq("Validating webhook signature"), isNull());
    verify(logger, never()).logEvent(eq("Webhook signature verified successfully"), isNull());
  }

  @Test
  void parseAndValidate_invalidJson_shouldThrowParsingException() {
    String payload = "not-json";
    String signature = "f09v2+ljW+xoAnkkrpthfduyf1LyaRCMpilr5e8volk=";

    assertThrows(WebhookEventParsingException.class,
        () -> webhookHandler.parseAndValidate(payload, signature, SECRET_KEY));

    verify(logger).logError(eq("Error parsing webhook payload"), any(Exception.class), eq(payload));
  }
}
