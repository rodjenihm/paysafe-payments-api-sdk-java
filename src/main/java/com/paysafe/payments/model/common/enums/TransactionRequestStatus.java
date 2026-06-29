// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.model.common.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * This is the status of the transaction request for standalone and original credits. Possible values are: - RECEIVED – Our system has received the request and is waiting for the downstream processor's response. - INITIATED – The transaction was initiated with the downstream provider. - PENDING - The transaction is awaiting the payment service provider's response. - FAILED – The transaction failed, due to either an error or being declined. - CANCELLED – The transaction request is cancelled. - EXPIRED – The transaction request is expired. - COMPLETED – The transaction request is completed.
 */
public enum TransactionRequestStatus {

  RECEIVED("RECEIVED"),

  INITIATED("INITIATED"),

  PENDING("PENDING"),

  FAILED("FAILED"),

  CANCELLED("CANCELLED"),

  EXPIRED("EXPIRED"),

  COMPLETED("COMPLETED");

  private final String value;

  TransactionRequestStatus(String value) {
    this.value = value;
  }

  @JsonCreator
  public static TransactionRequestStatus fromValue(String value) {
    for (TransactionRequestStatus b : TransactionRequestStatus.values()) {
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
