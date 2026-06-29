// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.model.payment.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The current status of the payment transaction. Possible values are: - RECEIVED -  The request has been received. - PROCESSING - The payment is being processed. - COMPLETED - The payment has been completed. - HELD - The payment has been held (e.g. for risk review). - FAILED - The payment failed. - CANCELLED - The payment was cancelled. - PENDING - The payment is pending.
 */
public enum PaymentStatus {

  RECEIVED("RECEIVED"),

  PROCESSING("PROCESSING"),

  COMPLETED("COMPLETED"),

  HELD("HELD"),

  FAILED("FAILED"),

  CANCELLED("CANCELLED"),

  PENDING("PENDING");

  private final String value;

  PaymentStatus(String value) {
    this.value = value;
  }

  @JsonCreator
  public static PaymentStatus fromValue(String value) {
    for (PaymentStatus b : PaymentStatus.values()) {
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
