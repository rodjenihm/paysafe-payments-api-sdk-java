// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.model.card.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * For CARD. Defines the processing rails options used for this transaction, indicating whether it is processed via pinless or regular card scheme network.
 */
public enum ProcessingRails {

  PINLESS("PINLESS"),

  CARD_SCHEME_ROUTED("CARD_SCHEME_ROUTED");

  private final String value;

  ProcessingRails(String value) {
    this.value = value;
  }

  @JsonCreator
  public static ProcessingRails fromValue(String value) {
    for (ProcessingRails b : ProcessingRails.values()) {
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
