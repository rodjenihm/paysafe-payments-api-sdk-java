// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.model.card.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.paysafe.payments.model.card.threeds.Authentication;

/**
 * Type of Authentication request.
 */
public enum ThreeDsAuthenticationPurpose {

  PAYMENT_TRANSACTION("PAYMENT_TRANSACTION"),

  RECURRING_TRANSACTION("RECURRING_TRANSACTION"),

  INSTALMENT_TRANSACTION("INSTALMENT_TRANSACTION"),

  ADD_CARD("ADD_CARD"),

  MAINTAIN_CARD("MAINTAIN_CARD"),

  EMV_TOKEN_VERIFICATION("EMV_TOKEN_VERIFICATION");

  private final String value;

  ThreeDsAuthenticationPurpose(String value) {
    this.value = value;
  }

  @JsonCreator
  public static ThreeDsAuthenticationPurpose fromValue(String value) {
    for (ThreeDsAuthenticationPurpose b : ThreeDsAuthenticationPurpose.values()) {
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
