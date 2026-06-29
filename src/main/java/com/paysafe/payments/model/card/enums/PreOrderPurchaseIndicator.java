// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.model.card.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Indicates whether merchandise is available or has a future availability date.
 */
public enum PreOrderPurchaseIndicator {

  MERCHANDISE_AVAILABLE("MERCHANDISE_AVAILABLE"),

  FUTURE_AVAILABILITY("FUTURE_AVAILABILITY");

  private final String value;

  PreOrderPurchaseIndicator(String value) {
    this.value = value;
  }

  @JsonCreator
  public static PreOrderPurchaseIndicator fromValue(String value) {
    for (PreOrderPurchaseIndicator b : PreOrderPurchaseIndicator.values()) {
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
