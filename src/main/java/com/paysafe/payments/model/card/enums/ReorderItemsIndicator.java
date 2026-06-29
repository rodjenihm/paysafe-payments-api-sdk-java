// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.model.card.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Indicates whether the cardholder is reordering merchandise.
 */
public enum ReorderItemsIndicator {

  FIRST_TIME_ORDER("FIRST_TIME_ORDER"),

  REORDER("REORDER");

  private final String value;

  ReorderItemsIndicator(String value) {
    this.value = value;
  }

  @JsonCreator
  public static ReorderItemsIndicator fromValue(String value) {
    for (ReorderItemsIndicator b : ReorderItemsIndicator.values()) {
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
