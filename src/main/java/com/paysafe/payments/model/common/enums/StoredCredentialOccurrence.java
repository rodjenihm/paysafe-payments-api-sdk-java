// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.model.common.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Specifies whether this stored credential request is initial or recurring.
 */
public enum StoredCredentialOccurrence {

  INITIAL("INITIAL"),

  SUBSEQUENT("SUBSEQUENT");

  private final String value;

  StoredCredentialOccurrence(String value) {
    this.value = value;
  }

  @JsonCreator
  public static StoredCredentialOccurrence fromValue(String value) {
    for (StoredCredentialOccurrence b : StoredCredentialOccurrence.values()) {
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
