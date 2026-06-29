// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.model.common.travel.airline;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.paysafe.payments.model.common.travel.airline.enums.TicketDeliveryMethod;



/**
 * Information about the Airline Ticket Number and if the ticket is restricted.
 */
public class AirlineTicket {

  @JsonProperty("ticketNumber")
  private String ticketNumber;
  @JsonProperty("isRestrictedTicket")
  private Boolean isRestrictedTicket;
  @JsonProperty("cityOfTicketIssuing")
  private String cityOfTicketIssuing;
  @JsonProperty("ticketDeliveryMethod")
  private TicketDeliveryMethod ticketDeliveryMethod;
  @JsonProperty("isAgencyCard")
  private Boolean isAgencyCard;
  @JsonProperty("ticketIssueDate")
  private String ticketIssueDate;
  @JsonProperty("ticketPrice")
  private BigDecimal ticketPrice;
  @JsonProperty("numberOfPax")
  private Integer numberOfPax;

  public AirlineTicket() {
    super();
  }

  private AirlineTicket(final Builder builder) {
    setTicketNumber(builder.ticketNumber);
    setIsRestrictedTicket(builder.isRestrictedTicket);
    setCityOfTicketIssuing(builder.cityOfTicketIssuing);
    setTicketDeliveryMethod(builder.ticketDeliveryMethod);
    setIsAgencyCard(builder.isAgencyCard);
    setTicketIssueDate(builder.ticketIssueDate);
    setTicketPrice(builder.ticketPrice);
    setNumberOfPax(builder.numberOfPax);
  }

  public static Builder builder() {
    return new Builder();
  }


  public AirlineTicket ticketNumber(String ticketNumber) {
    this.ticketNumber = ticketNumber;
    return this;
  }

  /**
   * Airline ticket number
   *
   * @return ticketNumber
   */
  public String getTicketNumber() {
    return ticketNumber;
  }

  public void setTicketNumber(String ticketNumber) {
    this.ticketNumber = ticketNumber;
  }


  public AirlineTicket isRestrictedTicket(Boolean isRestrictedTicket) {
    this.isRestrictedTicket = isRestrictedTicket;
    return this;
  }

  /**
   * Indicates whether this ticket is non-refundable. false - No restriction (default), true - Restricted (non-refundable) ticket
   *
   * @return isRestrictedTicket
   */
  public Boolean getIsRestrictedTicket() {
    return isRestrictedTicket;
  }

  public void setIsRestrictedTicket(Boolean isRestrictedTicket) {
    this.isRestrictedTicket = isRestrictedTicket;
  }


  public AirlineTicket cityOfTicketIssuing(String cityOfTicketIssuing) {
    this.cityOfTicketIssuing = cityOfTicketIssuing;
    return this;
  }

  /**
   * City where the ticket was issued
   *
   * @return cityOfTicketIssuing
   */
  public String getCityOfTicketIssuing() {
    return cityOfTicketIssuing;
  }

  public void setCityOfTicketIssuing(String cityOfTicketIssuing) {
    this.cityOfTicketIssuing = cityOfTicketIssuing;
  }


  public AirlineTicket ticketDeliveryMethod(TicketDeliveryMethod ticketDeliveryMethod) {
    this.ticketDeliveryMethod = ticketDeliveryMethod;
    return this;
  }

  /**
   * Get ticketDeliveryMethod
   *
   * @return ticketDeliveryMethod
   */
  public TicketDeliveryMethod getTicketDeliveryMethod() {
    return ticketDeliveryMethod;
  }

  public void setTicketDeliveryMethod(TicketDeliveryMethod ticketDeliveryMethod) {
    this.ticketDeliveryMethod = ticketDeliveryMethod;
  }


  public AirlineTicket isAgencyCard(Boolean isAgencyCard) {
    this.isAgencyCard = isAgencyCard;
    return this;
  }

  /**
   * Specifies whether the purchaser is the ticket holder or agency
   *
   * @return isAgencyCard
   */
  public Boolean getIsAgencyCard() {
    return isAgencyCard;
  }

  public void setIsAgencyCard(Boolean isAgencyCard) {
    this.isAgencyCard = isAgencyCard;
  }


  public AirlineTicket ticketIssueDate(String ticketIssueDate) {
    this.ticketIssueDate = ticketIssueDate;
    return this;
  }

  /**
   * Ticket's issue date. Date format YYYY-MM-DD, ISO 8601, e.g., 2021-01-26
   *
   * @return ticketIssueDate
   */
  public String getTicketIssueDate() {
    return ticketIssueDate;
  }

  public void setTicketIssueDate(String ticketIssueDate) {
    this.ticketIssueDate = ticketIssueDate;
  }


  public AirlineTicket ticketPrice(BigDecimal ticketPrice) {
    this.ticketPrice = ticketPrice;
    return this;
  }

  /**
   * Price for one ticket
   *
   * @return ticketPrice
   */
  public BigDecimal getTicketPrice() {
    return ticketPrice;
  }

  public void setTicketPrice(BigDecimal ticketPrice) {
    this.ticketPrice = ticketPrice;
  }


  public AirlineTicket numberOfPax(Integer numberOfPax) {
    this.numberOfPax = numberOfPax;
    return this;
  }

  /**
   * The number of the passengers which tickets are with the same PNR. Required during settlement request with TSYS processor
   *
   * @return numberOfPax
   */
  public Integer getNumberOfPax() {
    return numberOfPax;
  }

  public void setNumberOfPax(Integer numberOfPax) {
    this.numberOfPax = numberOfPax;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AirlineTicket airlineTicket = (AirlineTicket) o;
    return Objects.equals(this.ticketNumber, airlineTicket.ticketNumber) &&
        Objects.equals(this.isRestrictedTicket, airlineTicket.isRestrictedTicket) &&
        Objects.equals(this.cityOfTicketIssuing, airlineTicket.cityOfTicketIssuing) &&
        Objects.equals(this.ticketDeliveryMethod, airlineTicket.ticketDeliveryMethod) &&
        Objects.equals(this.isAgencyCard, airlineTicket.isAgencyCard) &&
        Objects.equals(this.ticketIssueDate, airlineTicket.ticketIssueDate) &&
        Objects.equals(this.ticketPrice, airlineTicket.ticketPrice) &&
        Objects.equals(this.numberOfPax, airlineTicket.numberOfPax);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ticketNumber, isRestrictedTicket, cityOfTicketIssuing, ticketDeliveryMethod, isAgencyCard, ticketIssueDate, ticketPrice, numberOfPax);
  }

  @Override
  public String toString() {

    return "class AirlineTicket {\n"
        + "    ticketNumber: " + toIndentedString(ticketNumber) + "\n"
        + "    isRestrictedTicket: " + toIndentedString(isRestrictedTicket) + "\n"
        + "    cityOfTicketIssuing: " + toIndentedString(cityOfTicketIssuing) + "\n"
        + "    ticketDeliveryMethod: " + toIndentedString(ticketDeliveryMethod) + "\n"
        + "    isAgencyCard: " + toIndentedString(isAgencyCard) + "\n"
        + "    ticketIssueDate: " + toIndentedString(ticketIssueDate) + "\n"
        + "    ticketPrice: " + toIndentedString(ticketPrice) + "\n"
        + "    numberOfPax: " + toIndentedString(numberOfPax) + "\n"
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
   * Information about the Airline Ticket Number and if the ticket is restricted. builder static inner class.
   */
  public static final class Builder {
    private String ticketNumber;
    private Boolean isRestrictedTicket;
    private String cityOfTicketIssuing;
    private TicketDeliveryMethod ticketDeliveryMethod;
    private Boolean isAgencyCard;
    private String ticketIssueDate;
    private BigDecimal ticketPrice;
    private Integer numberOfPax;

    private Builder() {
    }

    /**
     * Airline ticket number
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
     * Indicates whether this ticket is non-refundable. false - No restriction (default), true - Restricted (non-refundable) ticket
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
     * City where the ticket was issued
     * <p>
     * Sets the cityOfTicketIssuing and returns a reference to this Builder enabling method chaining.
     *
     * @param cityOfTicketIssuing the cityOfTicketIssuing to set
     * @return a reference to this Builder
     */
    public Builder cityOfTicketIssuing(String cityOfTicketIssuing) {
      this.cityOfTicketIssuing = cityOfTicketIssuing;
      return this;
    }

    /**
     * Sets the ticketDeliveryMethod and returns a reference to this Builder enabling method chaining.
     *
     * @param ticketDeliveryMethod the ticketDeliveryMethod to set
     * @return a reference to this Builder
     */
    public Builder ticketDeliveryMethod(TicketDeliveryMethod ticketDeliveryMethod) {
      this.ticketDeliveryMethod = ticketDeliveryMethod;
      return this;
    }

    /**
     * Specifies whether the purchaser is the ticket holder or agency
     * <p>
     * Sets the isAgencyCard and returns a reference to this Builder enabling method chaining.
     *
     * @param isAgencyCard the isAgencyCard to set
     * @return a reference to this Builder
     */
    public Builder isAgencyCard(Boolean isAgencyCard) {
      this.isAgencyCard = isAgencyCard;
      return this;
    }

    /**
     * Ticket's issue date. Date format YYYY-MM-DD, ISO 8601, e.g., 2021-01-26
     * <p>
     * Sets the ticketIssueDate and returns a reference to this Builder enabling method chaining.
     *
     * @param ticketIssueDate the ticketIssueDate to set
     * @return a reference to this Builder
     */
    public Builder ticketIssueDate(String ticketIssueDate) {
      this.ticketIssueDate = ticketIssueDate;
      return this;
    }

    /**
     * Price for one ticket
     * <p>
     * Sets the ticketPrice and returns a reference to this Builder enabling method chaining.
     *
     * @param ticketPrice the ticketPrice to set
     * @return a reference to this Builder
     */
    public Builder ticketPrice(BigDecimal ticketPrice) {
      this.ticketPrice = ticketPrice;
      return this;
    }

    /**
     * The number of the passengers which tickets are with the same PNR. Required during settlement request with TSYS processor
     * <p>
     * Sets the numberOfPax and returns a reference to this Builder enabling method chaining.
     *
     * @param numberOfPax the numberOfPax to set
     * @return a reference to this Builder
     */
    public Builder numberOfPax(Integer numberOfPax) {
      this.numberOfPax = numberOfPax;
      return this;
    }

    /**
     * Returns a AirlineTicket built from the parameters previously set.
     *
     * @return a AirlineTicket built with parameters of this AirlineTicket.Builder
     */
    public AirlineTicket build() {
      return new AirlineTicket(this);
    }
  }
}
