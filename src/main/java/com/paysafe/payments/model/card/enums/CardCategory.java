// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.card.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The type of card being used. CREDIT or DEBIT
 */
public enum CardCategory {
  CREDIT("CREDIT"),

  DEBIT("DEBIT");

  private final String value;

  CardCategory(String value) {
    this.value = value;
  }

  @JsonCreator
  public static CardCategory fromValue(String value) {
    for (CardCategory b : CardCategory.values()) {
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
