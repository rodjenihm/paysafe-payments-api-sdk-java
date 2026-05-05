// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.customer.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * This field indicates the Customer's gender. M - Male F - Female
 */
public enum Gender {
  M("M"),

  F("F");

  private final String value;

  Gender(String value) {
    this.value = value;
  }

  @JsonCreator
  public static Gender fromValue(String value) {
    for (Gender b : Gender.values()) {
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