// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.model.card.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Indicates whether a challenge is requested for this transaction.
 */
public enum ThreeDsRequestorChallengePreference {

  NO_PREFERENCE("NO_PREFERENCE"),

  NO_CHALLENGE_REQUESTED("NO_CHALLENGE_REQUESTED"),

  CHALLENGE_REQUESTED("CHALLENGE_REQUESTED"),

  CHALLENGE_MANDATED("CHALLENGE_MANDATED");

  private final String value;

  ThreeDsRequestorChallengePreference(String value) {
    this.value = value;
  }

  @JsonCreator
  public static ThreeDsRequestorChallengePreference fromValue(String value) {
    for (ThreeDsRequestorChallengePreference b : ThreeDsRequestorChallengePreference.values()) {
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
