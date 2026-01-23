// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.model.card.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.paysafe.payments.model.card.threeds.Authentication;

/**
 * Indicates the outcome of the Authentication.
 */
public enum ThreeDResult {

  Y("Y"),

  A("A"),

  N("N"),

  U("U"),

  E("E"),

  C("C");

  private final String value;

  ThreeDResult(String value) {
    this.value = value;
  }

  @JsonCreator
  public static ThreeDResult fromValue(String value) {
    for (ThreeDResult b : ThreeDResult.values()) {
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
