// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.model.common.travel.airline.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Way of delivering the ticket.
 */
public enum TicketDeliveryMethod {

  E_TICKET("E_TICKET"),

  CITY_TICKET_OFFICE("CITY_TICKET_OFFICE"),

  AIRPORT_TICKET_OFFICE("AIRPORT_TICKET_OFFICE"),

  TICKET_BY_MAIL("TICKET_BY_MAIL"),

  TICKET_ON_DEPARTURE("TICKET_ON_DEPARTURE");

  private final String value;

  TicketDeliveryMethod(String value) {
    this.value = value;
  }

  @JsonCreator
  public static TicketDeliveryMethod fromValue(String value) {
    for (TicketDeliveryMethod b : TicketDeliveryMethod.values()) {
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
