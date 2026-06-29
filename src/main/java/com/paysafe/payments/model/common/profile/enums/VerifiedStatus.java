// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.model.common.profile.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Whether the customer's phone number or email ID has been verified by merchant
 */
public enum VerifiedStatus {

  NOT_VERIFIED("NOT_VERIFIED"),

  VERIFIED("VERIFIED");

  private final String value;

  VerifiedStatus(String value) {
    this.value = value;
  }

  @JsonCreator
  public static VerifiedStatus fromValue(String value) {
    for (VerifiedStatus b : VerifiedStatus.values()) {
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
