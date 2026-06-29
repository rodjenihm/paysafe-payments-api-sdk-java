// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.model.applepay.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The payment data type
 */
public enum PaymentDataType {

  EMV("EMV"),

  _3_D_SECURE("3DSecure");

  private final String value;

  PaymentDataType(String value) {
    this.value = value;
  }

  @JsonCreator
  public static PaymentDataType fromValue(String value) {
    for (PaymentDataType b : PaymentDataType.values()) {
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
