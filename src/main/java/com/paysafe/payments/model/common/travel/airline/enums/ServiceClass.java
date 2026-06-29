// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.model.common.travel.airline.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Indicates service class (first class, business class, etc.). Example values (not limited to): - F - first class - J - business class - W - premium economy class - Y - economy class
 */
public enum ServiceClass {

  F("F"),

  J("J"),

  W("W"),

  Y("Y");

  private final String value;

  ServiceClass(String value) {
    this.value = value;
  }

  @JsonCreator
  public static ServiceClass fromValue(String value) {
    for (ServiceClass b : ServiceClass.values()) {
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
