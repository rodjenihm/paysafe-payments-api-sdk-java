// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.model.paymenthandle.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The type of transaction for which a payment handle is created
 */
public enum TransactionType {

  PAYMENT("PAYMENT"),

  STANDALONE_CREDIT("STANDALONE_CREDIT"),

  ORIGINAL_CREDIT("ORIGINAL_CREDIT"),

  VERIFICATION("VERIFICATION");

  private final String value;

  TransactionType(String value) {
    this.value = value;
  }

  @JsonCreator
  public static TransactionType fromValue(String value) {
    for (TransactionType b : TransactionType.values()) {
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
