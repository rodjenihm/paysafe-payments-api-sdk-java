// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.model.common.travel.airline.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Indicates the computerized reservation system used to make the reservation and purchase the ticket. Required only if the ticket is purchased in Germany
 */
public enum ComputerizedReservationSystem {

  STRT("STRT"),

  PARS("PARS"),

  DATS("DATS"),

  SABR("SABR"),

  DALA("DALA"),

  BLAN("BLAN"),

  DERD("DERD"),

  TUID("TUID");

  private final String value;

  ComputerizedReservationSystem(String value) {
    this.value = value;
  }

  @JsonCreator
  public static ComputerizedReservationSystem fromValue(String value) {
    for (ComputerizedReservationSystem b : ComputerizedReservationSystem.values()) {
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
