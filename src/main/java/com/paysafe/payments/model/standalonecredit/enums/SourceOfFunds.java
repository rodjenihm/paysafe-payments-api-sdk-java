// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.model.standalonecredit.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * This field contains the information representing the payment transaction funding source. Possible values: Credit, Debit, Prepaid, Cash, Deposit account, Credit account, Mobile money account
 */
public enum SourceOfFunds {

  CREDIT("Credit"),

  DEBIT("Debit"),

  PREPAID("Prepaid"),

  CASH("Cash"),

  DEPOSIT_ACCOUNT("Deposit account"),

  CREDIT_ACCOUNT("Credit account"),

  MOBILE_MONEY_ACCOUNT("Mobile money account");

  private final String value;

  SourceOfFunds(String value) {
    this.value = value;
  }

  @JsonCreator
  public static SourceOfFunds fromValue(String value) {
    for (SourceOfFunds b : SourceOfFunds.values()) {
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
