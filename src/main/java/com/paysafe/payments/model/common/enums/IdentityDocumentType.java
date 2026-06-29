// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.model.common.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Type of identity document.
 */
public enum IdentityDocumentType {

  PASSPORT("PASSPORT"),

  DRIVING_LICENSE("DRIVING_LICENSE"),

  NATIONAL_IDENTITY("NATIONAL_IDENTITY"),

  IDENTITY_CARD("IDENTITY_CARD"),

  TAX_IDENTIFICATION("TAX_IDENTIFICATION");

  private final String value;

  IdentityDocumentType(String value) {
    this.value = value;
  }

  @JsonCreator
  public static IdentityDocumentType fromValue(String value) {
    for (IdentityDocumentType b : IdentityDocumentType.values()) {
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
