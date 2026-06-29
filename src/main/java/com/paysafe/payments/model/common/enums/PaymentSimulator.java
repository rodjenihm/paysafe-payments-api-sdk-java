// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.model.common.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.paysafe.payments.model.lpm.Skrill;
import com.paysafe.payments.model.payment.Payment;

/**
 * Defines which Payment Simulator to use for processing test payment transactions. You can choose whether you want to simulate the actual end customer experience or you want to use a page, which lets you simulate all payment handle statuses. Possible values: <ul>   <li>INTERNAL, which redirects to the status simulator page.</li>   <li>EXTERNAL (default), which redirects/connects to the downstream payment method website, e.g. Skrill authentication page</li> </ul>
 */
public enum PaymentSimulator {

  EXTERNAL("EXTERNAL"),

  INTERNAL("INTERNAL");

  private final String value;

  PaymentSimulator(String value) {
    this.value = value;
  }

  @JsonCreator
  public static PaymentSimulator fromValue(String value) {
    for (PaymentSimulator b : PaymentSimulator.values()) {
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
