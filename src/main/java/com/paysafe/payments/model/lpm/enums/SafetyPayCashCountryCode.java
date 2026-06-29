// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.model.lpm.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.paysafe.payments.model.lpm.SafetyPayCash;

/**
 * Allowed countryCode for SafetyPayCash.
 */
public enum SafetyPayCashCountryCode {

  BRL("BRL"),

  CLP("CLP"),

  COP("COP"),

  CRC("CRC"),

  PEN("PEN"),

  USD("USD");

  private final String value;

  SafetyPayCashCountryCode(String value) {
    this.value = value;
  }

  @JsonCreator
  public static SafetyPayCashCountryCode fromValue(String value) {
    for (SafetyPayCashCountryCode b : SafetyPayCashCountryCode.values()) {
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
