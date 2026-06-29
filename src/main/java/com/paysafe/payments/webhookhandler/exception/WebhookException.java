// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.webhookhandler.exception;

public class WebhookException extends Exception {

  public WebhookException(String message, Throwable cause) {
    super(message, cause);
  }

  public WebhookException(String message) {
    super(message);
  }
}
