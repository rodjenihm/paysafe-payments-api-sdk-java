// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.model.card.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The bit depth of the color palette for displaying images, in bits per pixel.
 */
public enum BrowserColorDepth {

  _1("1"),

  _4("4"),

  _5("5"),

  _15("15"),

  _16("16"),

  _24("24"),

  _32("32"),

  _48("48");

  private final String value;

  BrowserColorDepth(String value) {
    this.value = value;
  }

  @JsonCreator
  public static BrowserColorDepth fromValue(String value) {
    for (BrowserColorDepth b : BrowserColorDepth.values()) {
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
