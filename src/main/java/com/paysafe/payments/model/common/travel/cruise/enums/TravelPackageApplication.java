// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.model.common.travel.cruise.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Indicates if the package includes car rental, airline flight, both or neither.
 */
public enum TravelPackageApplication {

  CAR_RENTAL_RESERVATION("CAR_RENTAL_RESERVATION"),

  AIRLINE_RESERVATION("AIRLINE_RESERVATION"),

  CAR_RENTAL_AND_AIRLINE_RESERVATION("CAR_RENTAL_AND_AIRLINE_RESERVATION"),

  UNKNOWN("UNKNOWN");

  private final String value;

  TravelPackageApplication(String value) {
    this.value = value;
  }

  @JsonCreator
  public static TravelPackageApplication fromValue(String value) {
    for (TravelPackageApplication b : TravelPackageApplication.values()) {
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
