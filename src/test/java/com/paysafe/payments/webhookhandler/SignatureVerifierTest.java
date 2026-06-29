// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.webhookhandler;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mockStatic;

import java.security.NoSuchAlgorithmException;

import javax.crypto.Mac;

import org.junit.jupiter.api.Test;

import com.paysafe.payments.webhookhandler.exception.SignatureVerificationException;

class SignatureVerifierTest {

  private static final String SECRET_KEY = "test-secret-key";
  private static final String PAYLOAD = "{\n"
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
  private static final String VALID_SIGNATURE = "jR68qVSIGjNNebdxrLt52fWVjG0ze+9GhIBdZOX9yxA=";

  @Test
  void verifySignature_validSignature_shouldNotThrowException() {
    assertDoesNotThrow(() -> SignatureVerifier.verifySignature(PAYLOAD, VALID_SIGNATURE, SECRET_KEY));
  }

  @Test
  void verifySignature_invalidSignature_shouldThrowSignatureVerificationException() {
    SignatureVerificationException ex = assertThrows(SignatureVerificationException.class,
        () -> SignatureVerifier.verifySignature(PAYLOAD, "invalid-signature", SECRET_KEY));

    assertEquals("Invalid webhook signature!", ex.getMessage());
  }

  @Test
  void verifySignature_tamperedPayload_shouldThrowSignatureVerificationException() {
    assertThrows(SignatureVerificationException.class,
        () -> SignatureVerifier.verifySignature("{\"event\":\"tampered\"}", VALID_SIGNATURE, SECRET_KEY));
  }

  @Test
  void verifySignature_wrongKey_shouldThrowSignatureVerificationException() {
    assertThrows(SignatureVerificationException.class,
        () -> SignatureVerifier.verifySignature(PAYLOAD, VALID_SIGNATURE, "wrong-key"));
  }

  @Test
  void verifySignature_algorithmError_shouldThrowSignatureVerificationException() {
    try (var macMock = mockStatic(javax.crypto.Mac.class)) {
      macMock.when(() -> Mac.getInstance("HmacSHA256"))
          .thenThrow(new NoSuchAlgorithmException("mocked"));

      SignatureVerificationException ex = assertThrows(SignatureVerificationException.class,
          () -> SignatureVerifier.verifySignature(PAYLOAD, VALID_SIGNATURE, SECRET_KEY));

      assertEquals("Error computing signature", ex.getMessage());
    }
  }
}
