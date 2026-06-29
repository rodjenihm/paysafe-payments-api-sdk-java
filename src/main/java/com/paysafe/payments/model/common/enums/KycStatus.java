// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.model.common.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.paysafe.payments.model.lpm.Paysafecash;

/**
 * This is the customer's KYC status for Paysafecash only. VERIFIED is sent as FULL to Paysafecash platform PARTIALLY_VERIFIED is sent as SIMPLE to Paysafecash platform
 */
public enum KycStatus {

  VERIFIED("VERIFIED"),

  PARTIALLY_VERIFIED("PARTIALLY_VERIFIED");

  private final String value;

  KycStatus(String value) {
    this.value = value;
  }

  @JsonCreator
  public static KycStatus fromValue(String value) {
    for (KycStatus b : KycStatus.values()) {
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
