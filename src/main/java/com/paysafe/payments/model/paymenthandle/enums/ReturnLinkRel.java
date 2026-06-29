// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.model.paymenthandle.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * This is the link type that allows different endpoints to be targeted depending on the end state of the transaction.
 */
public enum ReturnLinkRel {

  REDIRECT_PAYMENT("redirect_payment"),

  REDIRECT_REGISTRATION("redirect_registration"),

  ON_COMPLETED("on_completed"),

  DEFAULT("default"),

  ON_FAILED("on_failed"),

  ON_CANCELLED("on_cancelled");

  private final String value;

  ReturnLinkRel(String value) {
    this.value = value;
  }

  @JsonCreator
  public static ReturnLinkRel fromValue(String value) {
    for (ReturnLinkRel b : ReturnLinkRel.values()) {
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
