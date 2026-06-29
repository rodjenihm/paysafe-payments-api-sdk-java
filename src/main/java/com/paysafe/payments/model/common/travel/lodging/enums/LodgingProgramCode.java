// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.model.common.travel.lodging.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Code that corresponds to the category of lodging charges detailed in this message. Allowed values: - LODGING - (Default) Submitted charges are for lodging - NO_SHOW - Submitted charges are for the failure of the guest(s) to check in for reserved room - ADVANCED_DEPOSIT - Submitted charges are for an Advanced Deposit to reserve one or more rooms. In this case, the settlement date will be sent to the schemes for both the check-in and check-out dates. <br>**Note:** If no value is submitted the default value 'LODGING' is used.
 */
public enum LodgingProgramCode {

  LODGING("LODGING"),

  NO_SHOW("NO_SHOW"),

  ADVANCED_DEPOSIT("ADVANCED_DEPOSIT");

  private final String value;

  LodgingProgramCode(String value) {
    this.value = value;
  }

  @JsonCreator
  public static LodgingProgramCode fromValue(String value) {
    for (LodgingProgramCode b : LodgingProgramCode.values()) {
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
