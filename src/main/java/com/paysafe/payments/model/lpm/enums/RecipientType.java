// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.model.lpm.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.paysafe.payments.model.lpm.Paypal;

/**
 * Type of payout recipient. For Paypal, only supported value is PAYPAL_ID.
 */
public enum RecipientType {

  PAYPAL_ID("PAYPAL_ID"),

  USER_ID("USER_ID"),

  EMAIL("EMAIL"),

  PHONE("PHONE");

  private final String value;

  RecipientType(String value) {
    this.value = value;
  }

  @JsonCreator
  public static RecipientType fromValue(String value) {
    for (RecipientType b : RecipientType.values()) {
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
