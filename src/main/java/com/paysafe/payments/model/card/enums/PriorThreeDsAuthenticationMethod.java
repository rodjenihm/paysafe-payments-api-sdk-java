// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.model.card.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Mechanism used previously by the cardholder to authenticate to the 3DS Requestor.
 */
public enum PriorThreeDsAuthenticationMethod {

  FRICTIONLESS_AUTHENTICATION("FRICTIONLESS_AUTHENTICATION"),

  ACS_CHALLENGE("ACS_CHALLENGE"),

  AVS_VERIFIED("AVS_VERIFIED"),

  OTHER_ISSUER_METHOD("OTHER_ISSUER_METHOD");

  private final String value;

  PriorThreeDsAuthenticationMethod(String value) {
    this.value = value;
  }

  @JsonCreator
  public static PriorThreeDsAuthenticationMethod fromValue(String value) {
    for (PriorThreeDsAuthenticationMethod b : PriorThreeDsAuthenticationMethod.values()) {
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
