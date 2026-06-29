// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.model.card.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The 3D Secure signature verification result value.
 */
public enum ThreeDSignatureStatus {

  Y("Y"),

  N("N");

  private final String value;

  ThreeDSignatureStatus(String value) {
    this.value = value;
  }

  @JsonCreator
  public static ThreeDSignatureStatus fromValue(String value) {
    for (ThreeDSignatureStatus b : ThreeDSignatureStatus.values()) {
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
