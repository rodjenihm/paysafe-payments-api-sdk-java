// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.model.paymenthandle.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.paysafe.payments.model.payment.Payment;

/**
 * Specifies the action of the merchant server to complete the Payment.
 */
public enum ExecutionMode {

  SYNCHRONOUS("SYNCHRONOUS"),

  ASYNCHRONOUS("ASYNCHRONOUS");

  private final String value;

  ExecutionMode(String value) {
    this.value = value;
  }

  @JsonCreator
  public static ExecutionMode fromValue(String value) {
    for (ExecutionMode b : ExecutionMode.values()) {
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
