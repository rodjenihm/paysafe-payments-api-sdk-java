// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.model.card.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * This is type of card used for the request. - AM - American Express - DI - Discover - JC - JCB - MC - Mastercard - MD - Maestro - SO - Solo - VI - Visa - VD - Visa Debit - VE - Visa Electron
 */
public enum CardType {

  AM("AM"),

  DI("DI"),

  JC("JC"),

  MC("MC"),

  MD("MD"),

  SO("SO"),

  VI("VI"),

  VD("VD"),

  VE("VE");

  private final String value;

  CardType(String value) {
    this.value = value;
  }

  @JsonCreator
  public static CardType fromValue(String value) {
    for (CardType b : CardType.values()) {
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
