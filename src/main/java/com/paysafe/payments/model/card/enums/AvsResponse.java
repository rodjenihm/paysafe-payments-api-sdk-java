// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.model.card.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The AVS response returned from the card issuer.
 */
public enum AvsResponse {

  MATCH("MATCH"),

  MATCH_ADDRESS_ONLY("MATCH_ADDRESS_ONLY"),

  MATCH_ZIP_ONLY("MATCH_ZIP_ONLY"),

  NO_MATCH("NO_MATCH"),

  NOT_PROCESSED("NOT_PROCESSED"),

  UNKNOWN("UNKNOWN");

  private final String value;

  AvsResponse(String value) {
    this.value = value;
  }

  @JsonCreator
  public static AvsResponse fromValue(String value) {
    for (AvsResponse b : AvsResponse.values()) {
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
