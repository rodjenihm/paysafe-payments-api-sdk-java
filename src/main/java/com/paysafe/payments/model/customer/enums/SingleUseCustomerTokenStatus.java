// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.model.customer.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * This is the status of the single-use customer token
 */
public enum SingleUseCustomerTokenStatus {

  INITIAL("INITIAL"),

  ACTIVE("ACTIVE");

  private final String value;

  SingleUseCustomerTokenStatus(String value) {
    this.value = value;
  }

  @JsonCreator
  public static SingleUseCustomerTokenStatus fromValue(String value) {
    for (SingleUseCustomerTokenStatus b : SingleUseCustomerTokenStatus.values()) {
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
