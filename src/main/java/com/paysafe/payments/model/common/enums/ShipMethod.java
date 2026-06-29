// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.model.common.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The method of shipment. N - Next Day, T - Two-Day, C - Lowest Cost, O - Other, S - Same Day.
 */
public enum ShipMethod {

  N("N"),

  T("T"),

  C("C"),

  O("O"),

  S("S");

  private final String value;

  ShipMethod(String value) {
    this.value = value;
  }

  @JsonCreator
  public static ShipMethod fromValue(String value) {
    for (ShipMethod b : ShipMethod.values()) {
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
