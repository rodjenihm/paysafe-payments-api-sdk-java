// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.model.card.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The type of financing offered.
 */
public enum AccordDFinancingType {

  DEFERRED_PAYMENT("DEFERRED_PAYMENT"),

  EQUAL_PAYMENT("EQUAL_PAYMENT");

  private final String value;

  AccordDFinancingType(String value) {
    this.value = value;
  }

  @JsonCreator
  public static AccordDFinancingType fromValue(String value) {
    for (AccordDFinancingType b : AccordDFinancingType.values()) {
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
