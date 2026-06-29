// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.model.paymenthandle.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.paysafe.payments.model.payment.Payment;

/**
 * This is the status of the payment handle. Possible values are: - INITIATED - The transaction was initiated with the downstream provider. - PAYABLE - The merchant can use the Payment Handle for a Payment request. - PROCESSING - The Payment Handle was authorized by customer, awaiting PSP response. - FAILED - The transaction failed due to either an error or being declined. - EXPIRED - The Payment Handle expired because the merchant did not proceed with the Payment. - COMPLETED - The Payment request was initiated successfully using the Payment Handle.
 */
public enum PaymentHandleStatus {

  INITIATED("INITIATED"),

  PAYABLE("PAYABLE"),

  PROCESSING("PROCESSING"),

  FAILED("FAILED"),

  EXPIRED("EXPIRED"),

  COMPLETED("COMPLETED");

  private final String value;

  PaymentHandleStatus(String value) {
    this.value = value;
  }

  @JsonCreator
  public static PaymentHandleStatus fromValue(String value) {
    for (PaymentHandleStatus b : PaymentHandleStatus.values()) {
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
