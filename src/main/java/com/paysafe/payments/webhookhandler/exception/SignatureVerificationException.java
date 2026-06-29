// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.webhookhandler.exception;

public class SignatureVerificationException extends WebhookException {

  public SignatureVerificationException(String errorMessage) {
    super(errorMessage);
  }

  public SignatureVerificationException(String errorMessage, Throwable cause) {
    super(errorMessage, cause);
  }
}
