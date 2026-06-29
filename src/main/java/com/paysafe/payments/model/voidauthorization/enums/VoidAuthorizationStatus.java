// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.model.voidauthorization.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * This is the status of the transaction request. Possible values are: - RECEIVED - Our system has received the request and is waiting for the downstream processor's response. - COMPLETED - The transaction has been completed. - HELD - The transaction has been placed on hold due to risk considerations. - FAILED - The transaction failed, due to either an error or being declined. - CANCELLED - The request has been fully voided (reversed). - PENDING - The request is pending.
 */
public enum VoidAuthorizationStatus {

  RECEIVED("RECEIVED"),

  COMPLETED("COMPLETED"),

  HELD("HELD"),

  FAILED("FAILED"),

  CANCELLED("CANCELLED"),

  PENDING("PENDING");

  private final String value;

  VoidAuthorizationStatus(String value) {
    this.value = value;
  }

  @JsonCreator
  public static VoidAuthorizationStatus fromValue(String value) {
    for (VoidAuthorizationStatus b : VoidAuthorizationStatus.values()) {
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
