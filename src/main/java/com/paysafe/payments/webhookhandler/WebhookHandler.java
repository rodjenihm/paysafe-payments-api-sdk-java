// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.webhookhandler;

import static com.paysafe.payments.config.ObjectMapperConfiguration.getObjectMapper;
import static com.paysafe.payments.webhookhandler.SignatureVerifier.verifySignature;

import com.paysafe.payments.logging.SdkLogger;
import com.paysafe.payments.webhookhandler.exception.WebhookEventParsingException;
import com.paysafe.payments.webhookhandler.exception.WebhookException;
import com.paysafe.payments.webhookhandler.model.WebhookEvent;

public class WebhookHandler {

  private final SdkLogger logger;

  public WebhookHandler(final SdkLogger logger) {
    this.logger = logger;
  }

  public WebhookEvent parseAndValidate(String payload, String signHeader, String secretKey) throws WebhookException {
    logger.logEvent("Validating webhook signature", null);
    verifySignature(payload, signHeader, secretKey);
    logger.logEvent("Webhook signature verified successfully", null);

    try {
      logger.logEvent("Parsing webhook payload", getObjectMapper().readTree(payload));
      WebhookEvent event = getObjectMapper().readValue(payload, WebhookEvent.class);
      logger.logEvent("Webhook event parsed successfully", event);

      return event;
    } catch (Exception e) {
      logger.logError("Error parsing webhook payload", e, payload);
      throw new WebhookEventParsingException("Error parsing webhook payload", e);
    }
  }
}
