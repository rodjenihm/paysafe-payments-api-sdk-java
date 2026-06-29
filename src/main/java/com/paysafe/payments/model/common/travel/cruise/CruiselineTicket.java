// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.model.common.travel.cruise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;



/**
 * Information about the Cruise line Ticket Number and if the ticket is restricted. Required during settlement. <br>**Note:** This object is only for Cruise line Merchants.
 */
public class CruiselineTicket {

  @JsonProperty("ticketNumber")
  private String ticketNumber;
  @JsonProperty("isRestrictedTicket")
  private Boolean isRestrictedTicket;

  public CruiselineTicket() {
    super();
  }

  private CruiselineTicket(final Builder builder) {
    setTicketNumber(builder.ticketNumber);
    setIsRestrictedTicket(builder.isRestrictedTicket);
  }

  public static Builder builder() {
    return new Builder();
  }


  public CruiselineTicket ticketNumber(String ticketNumber) {
    this.ticketNumber = ticketNumber;
    return this;
  }

  /**
   * Cruise ticket number. Required during settlement
   *
   * @return ticketNumber
   */
  public String getTicketNumber() {
    return ticketNumber;
  }

  public void setTicketNumber(String ticketNumber) {
    this.ticketNumber = ticketNumber;
  }


  public CruiselineTicket isRestrictedTicket(Boolean isRestrictedTicket) {
    this.isRestrictedTicket = isRestrictedTicket;
    return this;
  }

  /**
   * Indicates whether this ticket is non-refundable. false - No restriction (default), true - Restricted (non-refundable) ticket. Required during settlement request for integration with TSYS processor
   *
   * @return isRestrictedTicket
   */
  public Boolean getIsRestrictedTicket() {
    return isRestrictedTicket;
  }

  public void setIsRestrictedTicket(Boolean isRestrictedTicket) {
    this.isRestrictedTicket = isRestrictedTicket;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CruiselineTicket cruiselineTicket = (CruiselineTicket) o;
    return Objects.equals(this.ticketNumber, cruiselineTicket.ticketNumber) &&
        Objects.equals(this.isRestrictedTicket, cruiselineTicket.isRestrictedTicket);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ticketNumber, isRestrictedTicket);
  }

  @Override
  public String toString() {

    return "class CruiselineTicket {\n"
        + "    ticketNumber: " + toIndentedString(ticketNumber) + "\n"
        + "    isRestrictedTicket: " + toIndentedString(isRestrictedTicket) + "\n"
        + "}";
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

  /**
   * Information about the Cruise line Ticket Number and if the ticket is restricted. Required during settlement. <br>**Note:** This object is only for Cruise line Merchants. builder static inner class.
   */
  public static final class Builder {
    private String ticketNumber;
    private Boolean isRestrictedTicket;

    private Builder() {
    }

    /**
     * Cruise ticket number. Required during settlement
     * <p>
     * Sets the ticketNumber and returns a reference to this Builder enabling method chaining.
     *
     * @param ticketNumber the ticketNumber to set
     * @return a reference to this Builder
     */
    public Builder ticketNumber(String ticketNumber) {
      this.ticketNumber = ticketNumber;
      return this;
    }

    /**
     * Indicates whether this ticket is non-refundable. false - No restriction (default), true - Restricted (non-refundable) ticket. Required during settlement request for integration with TSYS processor
     * <p>
     * Sets the isRestrictedTicket and returns a reference to this Builder enabling method chaining.
     *
     * @param isRestrictedTicket the isRestrictedTicket to set
     * @return a reference to this Builder
     */
    public Builder isRestrictedTicket(Boolean isRestrictedTicket) {
      this.isRestrictedTicket = isRestrictedTicket;
      return this;
    }

    /**
     * Returns a CruiselineTicket built from the parameters previously set.
     *
     * @return a CruiselineTicket built with parameters of this CruiselineTicket.Builder
     */
    public CruiselineTicket build() {
      return new CruiselineTicket(this);
    }
  }
}
