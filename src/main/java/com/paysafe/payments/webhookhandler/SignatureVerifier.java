// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.webhookhandler;

import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import com.paysafe.payments.webhookhandler.exception.SignatureVerificationException;

public final class SignatureVerifier {

  private SignatureVerifier() {
    // Private constructor to prevent instantiation
  }

  public static void verifySignature(String payload, String signHeader, String secretKey) throws SignatureVerificationException {
    try {
      String computedSignature = computeHmacSha256Base64(payload, secretKey);

      boolean valid = MessageDigest.isEqual(
          computedSignature.getBytes(StandardCharsets.UTF_8),
          signHeader.getBytes(StandardCharsets.UTF_8)
      );

      if (!valid) {
        throw new SignatureVerificationException("Invalid webhook signature!");
      }
    } catch (NoSuchAlgorithmException | InvalidKeyException e) {
      throw new SignatureVerificationException("Error computing signature", e);
    }
  }

  private static String computeHmacSha256Base64(String payload, String secretKey) throws NoSuchAlgorithmException, InvalidKeyException {
    Mac mac = Mac.getInstance("HmacSHA256");
    SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(StandardCharsets.UTF_8), "HmacSHA256");
    mac.init(secretKeySpec);

    byte[] digest = mac.doFinal(payload.getBytes(StandardCharsets.UTF_8));

    return Base64.getEncoder().encodeToString(digest);
  }
}
