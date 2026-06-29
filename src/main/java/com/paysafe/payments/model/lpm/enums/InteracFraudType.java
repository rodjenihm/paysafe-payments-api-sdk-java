// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.model.lpm.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * This is the type of fraudulent transaction that was carried out with the intention of financial gain. Possible values for the fraud type: - ACCOUNT_TAKEOVER - Account Takeover - BAD_DEPOSIT - Proceeds of Bad Deposit - FIRST_PARTY_FRAUD - First Party Fraud - INTERCEPTED_PAYMENT - Intercepted Transfer - MERCHANT_DISPUTE - Merchant Dispute - FAMILY_FRIEND_FRAUD - Family/Friendly Fraud - BUSINESS_EMAIL_COMPROMISE - Business Email Compromise - VENDOR_EMAIL_COMPROMISE - Vendor Email Compromise - MALWARE - Malware - APPLICATION_FRAUD - Application Fraud - FRAUD_BUSINESS - Fraudulent Business - OTHER - Other fraud type
 */
public enum InteracFraudType {

  ACCOUNT_TAKEOVER("ACCOUNT_TAKEOVER"),

  BAD_DEPOSIT("BAD_DEPOSIT"),

  FIRST_PARTY_FRAUD("FIRST_PARTY_FRAUD"),

  INTERCEPTED_PAYMENT("INTERCEPTED_PAYMENT"),

  MERCHANT_DISPUTE("MERCHANT_DISPUTE"),

  FAMILY_FRIEND_FRAUD("FAMILY_FRIEND_FRAUD"),

  BUSINESS_EMAIL_COMPROMISE("BUSINESS_EMAIL_COMPROMISE"),

  VENDOR_EMAIL_COMPROMISE("VENDOR_EMAIL_COMPROMISE"),

  MALWARE("MALWARE"),

  APPLICATION_FRAUD("APPLICATION_FRAUD"),

  FRAUD_BUSINESS("FRAUD_BUSINESS"),

  OTHER("OTHER");

  private final String value;

  InteracFraudType(String value) {
    this.value = value;
  }

  @JsonCreator
  public static InteracFraudType fromValue(String value) {
    for (InteracFraudType b : InteracFraudType.values()) {
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
