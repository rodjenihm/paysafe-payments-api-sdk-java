// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.model.card.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The type of token (APPLE_PAY, NETWORK_TOKEN, GOOGLE_PAY)
 */
public enum TokenType {

  APPLE_PAY("APPLE_PAY"),

  NETWORK_TOKEN("NETWORK_TOKEN"),

  GOOGLE_PAY("GOOGLE_PAY");

  private final String value;

  TokenType(String value) {
    this.value = value;
  }

  @JsonCreator
  public static TokenType fromValue(String value) {
    for (TokenType b : TokenType.values()) {
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
