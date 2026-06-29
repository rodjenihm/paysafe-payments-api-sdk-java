// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.model.lpm.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * This is the payment type. Possible values are: - WEB - Website originated debit (Personal bank accounts only) - TEL - Telephone-Initiated Entry (Personal bank accounts only) - PPD - Personal account debit (Personal bank accounts only) - CCD - Business account debit (Business bank accounts only)
 */
public enum AchPayMethod {

  WEB("WEB"),

  TEL("TEL"),

  PPD("PPD"),

  CCD("CCD");

  private final String value;

  AchPayMethod(String value) {
    this.value = value;
  }

  @JsonCreator
  public static AchPayMethod fromValue(String value) {
    for (AchPayMethod b : AchPayMethod.values()) {
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
