// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.model.lpm.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.paysafe.payments.model.lpm.Interac;

/**
 * This parameter is used to to identify if user is registered for Interac E-Transfer.
 */
public enum InteracTransferType {

  ALIAS_REGULAR("ALIAS_REGULAR"),

  ALIAS_AUTODEPOSIT("ALIAS_AUTODEPOSIT");

  private final String value;

  InteracTransferType(String value) {
    this.value = value;
  }

  @JsonCreator
  public static InteracTransferType fromValue(String value) {
    for (InteracTransferType b : InteracTransferType.values()) {
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
