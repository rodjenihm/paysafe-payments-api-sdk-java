// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.model.card.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Category of the message for a specific use case.
 */
public enum ThreeDsMessageCategory {

  PAYMENT("PAYMENT"),

  NON_PAYMENT("NON_PAYMENT");

  private final String value;

  ThreeDsMessageCategory(String value) {
    this.value = value;
  }

  @JsonCreator
  public static ThreeDsMessageCategory fromValue(String value) {
    for (ThreeDsMessageCategory b : ThreeDsMessageCategory.values()) {
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
