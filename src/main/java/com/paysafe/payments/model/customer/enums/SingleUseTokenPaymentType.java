// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.model.customer.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * List of possible payment types for Single Use Tokens. Possible values: - CARD - EFT - ACH - BACS - SEPA
 */
public enum SingleUseTokenPaymentType {

  CARD("CARD"),

  EFT("EFT"),

  ACH("ACH"),

  BACS("BACS"),

  SEPA("SEPA");

  private final String value;

  SingleUseTokenPaymentType(String value) {
    this.value = value;
  }

  @JsonCreator
  public static SingleUseTokenPaymentType fromValue(String value) {
    for (SingleUseTokenPaymentType b : SingleUseTokenPaymentType.values()) {
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
