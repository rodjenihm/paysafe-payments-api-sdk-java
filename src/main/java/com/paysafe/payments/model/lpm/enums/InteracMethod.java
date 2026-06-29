// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.model.lpm.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.paysafe.payments.model.lpm.Interac;

/**
 * Interac E-Transfer transaction type.
 */
public enum InteracMethod {

  SEND_MONEY("SEND_MONEY");

  private final String value;

  InteracMethod(String value) {
    this.value = value;
  }

  @JsonCreator
  public static InteracMethod fromValue(String value) {
    for (InteracMethod b : InteracMethod.values()) {
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
