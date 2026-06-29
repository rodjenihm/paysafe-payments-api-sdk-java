// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.model.common.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Indicates whether a value has been verified.
 */
public enum VerificationIndicator {

  NOT_VERIFIED("NOT_VERIFIED"),

  VERIFIED("VERIFIED");

  private final String value;

  VerificationIndicator(String value) {
    this.value = value;
  }

  @JsonCreator
  public static VerificationIndicator fromValue(String value) {
    for (VerificationIndicator b : VerificationIndicator.values()) {
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
