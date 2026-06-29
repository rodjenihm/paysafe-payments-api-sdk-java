// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.model.customer.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.paysafe.payments.model.customer.Customer;

/**
 * This field indicates the Customer's gender. M - Male F - Female
 */
public enum CustomerGender {

  M("M"),

  F("F");

  private final String value;

  CustomerGender(String value) {
    this.value = value;
  }

  @JsonCreator
  public static CustomerGender fromValue(String value) {
    for (CustomerGender b : CustomerGender.values()) {
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
