// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.model.common.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The status of the mandate request response
 */
public enum MandateStatus {

  PENDING("PENDING"),

  ACTIVE("ACTIVE"),

  CANCELLED("CANCELLED"),

  INACTIVE("INACTIVE");

  private final String value;

  MandateStatus(String value) {
    this.value = value;
  }

  @JsonCreator
  public static MandateStatus fromValue(String value) {
    for (MandateStatus b : MandateStatus.values()) {
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
