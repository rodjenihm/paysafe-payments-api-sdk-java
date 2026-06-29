// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.model.card.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.paysafe.payments.model.card.threeds.Authentication;
import com.paysafe.payments.model.customer.Customer;

/**
 * Exemption indicator for bypassing Strong Customer Authentication or 3DS.
 */
public enum ThreeDsExemptionIndicator {

  LOW_VALUE_EXEMPTION("LOW_VALUE_EXEMPTION"),

  TRA_EXEMPTION("TRA_EXEMPTION");

  private final String value;

  ThreeDsExemptionIndicator(String value) {
    this.value = value;
  }

  @JsonCreator
  public static ThreeDsExemptionIndicator fromValue(String value) {
    for (ThreeDsExemptionIndicator b : ThreeDsExemptionIndicator.values()) {
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
