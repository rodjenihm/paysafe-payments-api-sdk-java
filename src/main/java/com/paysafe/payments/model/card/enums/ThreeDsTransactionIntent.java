// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.model.card.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Identifies the type of transaction being authenticated.
 */
public enum ThreeDsTransactionIntent {

  GOODS_OR_SERVICE_PURCHASE("GOODS_OR_SERVICE_PURCHASE"),

  CHECK_ACCEPTANCE("CHECK_ACCEPTANCE"),

  ACCOUNT_FUNDING("ACCOUNT_FUNDING"),

  QUASI_CASH_TRANSACTION("QUASI_CASH_TRANSACTION"),

  PREPAID_ACTIVATION("PREPAID_ACTIVATION");

  private final String value;

  ThreeDsTransactionIntent(String value) {
    this.value = value;
  }

  @JsonCreator
  public static ThreeDsTransactionIntent fromValue(String value) {
    for (ThreeDsTransactionIntent b : ThreeDsTransactionIntent.values()) {
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
