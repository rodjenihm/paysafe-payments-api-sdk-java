// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.model.common.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Specifies the type of stored credential request.
 */
public enum StoredCredentialType {

  ADHOC("ADHOC"),

  TOPUP("TOPUP"),

  RECURRING("RECURRING");

  private final String value;

  StoredCredentialType(String value) {
    this.value = value;
  }

  @JsonCreator
  public static StoredCredentialType fromValue(String value) {
    for (StoredCredentialType b : StoredCredentialType.values()) {
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
