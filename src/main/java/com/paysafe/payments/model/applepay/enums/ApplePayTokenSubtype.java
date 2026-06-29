// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.model.applepay.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The subtype of the Apple Pay token.
 */
public enum ApplePayTokenSubtype {

  MERCHANT("MERCHANT"),

  DEVICE("DEVICE");

  private final String value;

  ApplePayTokenSubtype(String value) {
    this.value = value;
  }

  @JsonCreator
  public static ApplePayTokenSubtype fromValue(String value) {
    for (ApplePayTokenSubtype b : ApplePayTokenSubtype.values()) {
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
