// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.model.common.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * This is the status of the mandate request response.
 */
public enum MandateRequestStatus {
  PENDING("PENDING"),

  ACTIVE("ACTIVE"),

  CANCELLED("CANCELLED"),

  INACTIVE("INACTIVE");

  private final String value;

  MandateRequestStatus(String value) {
    this.value = value;
  }

  @JsonCreator
  public static MandateRequestStatus fromValue(String value) {
    for (MandateRequestStatus b : MandateRequestStatus.values()) {
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