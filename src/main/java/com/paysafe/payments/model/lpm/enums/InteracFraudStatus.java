// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.model.lpm.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.paysafe.payments.model.lpm.Interac;

/**
 * This is the status of the Standalone Interac's Credit call response. Possible values for the fraud status: - CONFIRM_FRAUD - payment is confirmed fraud - CONFIRM_LEGITIMATE - payment is confirmed legitimate - SCAM - payment is scam - PRESUME_LEGITIMATE - payment is presume legitimate - SUSPICIOUS - payment is suspicious
 */
public enum InteracFraudStatus {

  CONFIRM_FRAUD("CONFIRM_FRAUD"),

  CONFIRM_LEGITIMATE("CONFIRM_LEGITIMATE"),

  SCAM("SCAM"),

  PRESUME_LEGITIMATE("PRESUME_LEGITIMATE"),

  SUSPICIOUS("SUSPICIOUS");

  private final String value;

  InteracFraudStatus(String value) {
    this.value = value;
  }

  @JsonCreator
  public static InteracFraudStatus fromValue(String value) {
    for (InteracFraudStatus b : InteracFraudStatus.values()) {
      if (b.value.equalsIgnoreCase(value)) {
        return b;
      }
    }
    return null;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }
}
