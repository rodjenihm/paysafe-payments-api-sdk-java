// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.model.card.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The status of the Enrollment Lookup request.
 */
public enum AuthenticationStatus {

  COMPLETED("COMPLETED"),

  FAILED("FAILED");

  private final String value;

  AuthenticationStatus(String value) {
    this.value = value;
  }

  @JsonCreator
  public static AuthenticationStatus fromValue(String value) {
    for (AuthenticationStatus b : AuthenticationStatus.values()) {
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
