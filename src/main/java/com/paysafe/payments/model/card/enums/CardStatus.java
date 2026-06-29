// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.model.card.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.paysafe.payments.model.customer.Customer;

/**
 * Optional. Present only if the card is stored for the Customer.
 */
public enum CardStatus {

  ACTIVE("ACTIVE"),

  SUSPENDED("SUSPENDED");

  private final String value;

  CardStatus(String value) {
    this.value = value;
  }

  @JsonCreator
  public static CardStatus fromValue(String value) {
    for (CardStatus b : CardStatus.values()) {
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
