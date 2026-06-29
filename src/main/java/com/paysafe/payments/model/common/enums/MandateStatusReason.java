// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.model.common.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The status reason of the mandate request response
 */
public enum MandateStatusReason {

  MERCHANT_CANCELLED("MERCHANT_CANCELLED"),

  BANK_CANCELLED("BANK_CANCELLED"),

  DECLINED("DECLINED"),

  REJECTED("REJECTED"),

  DISPUTED("DISPUTED"),

  UNAUTHORIZED("UNAUTHORIZED"),

  TRANSFERRED("TRANSFERRED");

  private final String value;

  MandateStatusReason(String value) {
    this.value = value;
  }

  @JsonCreator
  public static MandateStatusReason fromValue(String value) {
    for (MandateStatusReason b : MandateStatusReason.values()) {
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
