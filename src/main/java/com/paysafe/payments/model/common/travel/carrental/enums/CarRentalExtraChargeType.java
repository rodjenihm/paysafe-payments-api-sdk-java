// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.model.common.travel.carrental.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Enum representing the various types of extra charges that may apply to a car rental reservation.
 */
public enum CarRentalExtraChargeType {

  GASOLINE("GASOLINE"),

  MILEAGE("MILEAGE"),

  LATE_RETURN("LATE_RETURN"),

  ONE_WAY_SERVICE_FEE("ONE_WAY_SERVICE_FEE"),

  DRIVING_VIOLATION("DRIVING_VIOLATION");

  private final String value;

  CarRentalExtraChargeType(String value) {
    this.value = value;
  }

  @JsonCreator
  public static CarRentalExtraChargeType fromValue(String value) {
    for (CarRentalExtraChargeType b : CarRentalExtraChargeType.values()) {
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
