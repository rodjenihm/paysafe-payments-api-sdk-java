// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.model.card.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Enum representing the various processor applied types for funding transactions. The fundingTransaction processorAppliedType value is chosen by Paysafe based on the merchant configuration. It is equal to the one which is used by Paysafe based on your MCC and registration. If you provide value which is applicable for your MCC but you have been registered for another use case, Paysafe will assign the value you have registered for as use case and will provide it into the response as processorAppliedType. In case the merchant is not registered in the relevant card scheme system, the processorAppliedValue received into the response will be 'NOT_APPLIED'. The processorAppliedType can be seen in the auth response.
 */
public enum FundingTransactionType {

  SVDW_FUNDS_TRANSFER("SVDW_FUNDS_TRANSFER"),

  SDW_WALLET_TRANSFER("SDW_WALLET_TRANSFER"),

  ACCOUNT_TO_ACCOUNT("ACCOUNT_TO_ACCOUNT"),

  PERSON_TO_PERSON("PERSON_TO_PERSON"),

  NOT_APPLIED("NOT_APPLIED");

  private final String value;

  FundingTransactionType(String value) {
    this.value = value;
  }

  @JsonCreator
  public static FundingTransactionType fromValue(String value) {
    for (FundingTransactionType b : FundingTransactionType.values()) {
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
