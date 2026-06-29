// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.model.card.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Range when the shipping address was first used.
 */
public enum ShippingAddressUsageRange {

  CURRENT_TRANSACTION("CURRENT_TRANSACTION"),

  LESS_THAN_THIRTY_DAYS("LESS_THAN_THIRTY_DAYS"),

  THIRTY_TO_SIXTY_DAYS("THIRTY_TO_SIXTY_DAYS"),

  MORE_THAN_SIXTY_DAYS("MORE_THAN_SIXTY_DAYS");

  private final String value;

  ShippingAddressUsageRange(String value) {
    this.value = value;
  }

  @JsonCreator
  public static ShippingAddressUsageRange fromValue(String value) {
    for (ShippingAddressUsageRange b : ShippingAddressUsageRange.values()) {
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
