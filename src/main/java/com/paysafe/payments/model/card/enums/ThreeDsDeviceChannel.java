// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.model.card.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Type of channel interface used to initiate the transaction.
 */
public enum ThreeDsDeviceChannel {

  BROWSER("BROWSER"),

  SDK("SDK"),

  _3_RI("3RI");

  private final String value;

  ThreeDsDeviceChannel(String value) {
    this.value = value;
  }

  @JsonCreator
  public static ThreeDsDeviceChannel fromValue(String value) {
    for (ThreeDsDeviceChannel b : ThreeDsDeviceChannel.values()) {
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
