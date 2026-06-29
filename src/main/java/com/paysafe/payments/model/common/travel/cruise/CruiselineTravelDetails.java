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
import com.paysafe.payments.model.common.travel.airline.Passengers;
import com.paysafe.payments.model.common.travel.cruise.enums.TravelPackageApplication;



/**
 * Contains information about your cruise line travel. <br>**Note:** This object is only for Cruise line Merchants. <br>**Note:** This field has to be passed only in case of card transactions.
 */
public class CruiselineTravelDetails {

  @JsonProperty("cruiseShipName")
  private String cruiseShipName;
  @JsonProperty("passengerName")
  private String passengerName;
  @JsonProperty("departureDate")
  private String departureDate;
  @JsonProperty("returnDate")
  private String returnDate;
  @JsonProperty("country")
  private String country;
  @JsonProperty("state")
  private String state;
  @JsonProperty("originCity")
  private String originCity;
  @JsonProperty("roomRate")
  private BigDecimal roomRate;
  @JsonProperty("travelPackageApplication")
  private TravelPackageApplication travelPackageApplication;
  @JsonProperty("ticket")
  private CruiselineTicket ticket;
  @JsonProperty("passengers")
  private Passengers passengers;
  @JsonProperty("tripLegs")
  private CruiselineTripLegs tripLegs;

  public CruiselineTravelDetails() {
    super();
  }

  private CruiselineTravelDetails(final Builder builder) {
    setCruiseShipName(builder.cruiseShipName);
    setPassengerName(builder.passengerName);
    setDepartureDate(builder.departureDate);
    setReturnDate(builder.returnDate);
    setCountry(builder.country);
    setState(builder.state);
    setOriginCity(builder.originCity);
    setRoomRate(builder.roomRate);
    setTravelPackageApplication(builder.travelPackageApplication);
    setTicket(builder.ticket);
    setPassengers(builder.passengers);
    setTripLegs(builder.tripLegs);
  }

  public static Builder builder() {
    return new Builder();
  }


  public CruiselineTravelDetails cruiseShipName(String cruiseShipName) {
    this.cruiseShipName = cruiseShipName;
    return this;
  }

  /**
   * The ship name booked for the cruise. * Required during settlement request with AMEX for integration with TSYS processor
   *
   * @return cruiseShipName
   */
  public String getCruiseShipName() {
    return cruiseShipName;
  }

  public void setCruiseShipName(String cruiseShipName) {
    this.cruiseShipName = cruiseShipName;
  }


  public CruiselineTravelDetails passengerName(String passengerName) {
    this.passengerName = passengerName;
    return this;
  }

  /**
   * Name of the passenger to whom the ticket was issued. * Required during authorization request with AMEX for integration or TSYS processor * Required during settlement request with Visa or Mastercard for integration with TSYS processor
   *
   * @return passengerName
   */
  public String getPassengerName() {
    return passengerName;
  }

  public void setPassengerName(String passengerName) {
    this.passengerName = passengerName;
  }


  public CruiselineTravelDetails departureDate(String departureDate) {
    this.departureDate = departureDate;
    return this;
  }

  /**
   * Date of passenger's departure. Date format = YYYY-MM-DD, ISO 8601 expected. * Required during authorization request with AMEX for integration with TSYS processor * Required during settlement request for integration with TSYS processor _UTC Date Format_
   *
   * @return departureDate
   */
  public String getDepartureDate() {
    return departureDate;
  }

  public void setDepartureDate(String departureDate) {
    this.departureDate = departureDate;
  }


  public CruiselineTravelDetails returnDate(String returnDate) {
    this.returnDate = returnDate;
    return this;
  }

  /**
   * Date of passenger's return. Date format = YYYY-MM-DD, ISO 8601 expected. * Required during settlement request with AMEX for integration with TSYS processor _UTC Date Format_
   *
   * @return returnDate
   */
  public String getReturnDate() {
    return returnDate;
  }

  public void setReturnDate(String returnDate) {
    this.returnDate = returnDate;
  }


  public CruiselineTravelDetails country(String country) {
    this.country = country;
    return this;
  }

  /**
   * This field contains the country code of the cruise location.  See [Country Codes](https://developer.paysafe.com/en/support/reference-information/codes/#country-codes).  * Required during settlement request with AMEX for integration with TSYS processor
   *
   * @return country
   */
  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }


  public CruiselineTravelDetails state(String state) {
    this.state = state;
    return this;
  }

  /**
   * The region code that corresponds to the state, province, or other country subdivision of the cruise location.  See [Province Codes](https://developer.paysafe.com/en/support/reference-information/codes/#province-codes) or [State Codes](https://developer.paysafe.com/en/support/reference-information/codes/#state-codes) for Canada or the United States.  * Required during settlement request with AMEX for integration with TSYS processor
   *
   * @return state
   */
  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }


  public CruiselineTravelDetails originCity(String originCity) {
    this.originCity = originCity;
    return this;
  }

  /**
   * Departure City where the trip originates.  * Required for AMEX in case of integration with TSYS processor
   *
   * @return originCity
   */
  public String getOriginCity() {
    return originCity;
  }

  public void setOriginCity(String originCity) {
    this.originCity = originCity;
  }


  public CruiselineTravelDetails roomRate(BigDecimal roomRate) {
    this.roomRate = roomRate;
    return this;
  }

  /**
   * Total cost of the cruise. For onboard purchases or transactions occurring during cruise travel, this field must be zero filled.  * Required during settlement request with AMEX for integration with TSYS processor
   *
   * @return roomRate
   */
  public BigDecimal getRoomRate() {
    return roomRate;
  }

  public void setRoomRate(BigDecimal roomRate) {
    this.roomRate = roomRate;
  }


  public CruiselineTravelDetails travelPackageApplication(TravelPackageApplication travelPackageApplication) {
    this.travelPackageApplication = travelPackageApplication;
    return this;
  }

  /**
   * Get travelPackageApplication
   *
   * @return travelPackageApplication
   */
  public TravelPackageApplication getTravelPackageApplication() {
    return travelPackageApplication;
  }

  public void setTravelPackageApplication(TravelPackageApplication travelPackageApplication) {
    this.travelPackageApplication = travelPackageApplication;
  }


  public CruiselineTravelDetails ticket(CruiselineTicket ticket) {
    this.ticket = ticket;
    return this;
  }

  /**
   * Get ticket
   *
   * @return ticket
   */
  public CruiselineTicket getTicket() {
    return ticket;
  }

  public void setTicket(CruiselineTicket ticket) {
    this.ticket = ticket;
  }


  public CruiselineTravelDetails passengers(Passengers passengers) {
    this.passengers = passengers;
    return this;
  }

  /**
   * Get passengers
   *
   * @return passengers
   */
  public Passengers getPassengers() {
    return passengers;
  }

  public void setPassengers(Passengers passengers) {
    this.passengers = passengers;
  }


  public CruiselineTravelDetails tripLegs(CruiselineTripLegs tripLegs) {
    this.tripLegs = tripLegs;
    return this;
  }

  /**
   * Get tripLegs
   *
   * @return tripLegs
   */
  public CruiselineTripLegs getTripLegs() {
    return tripLegs;
  }

  public void setTripLegs(CruiselineTripLegs tripLegs) {
    this.tripLegs = tripLegs;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CruiselineTravelDetails cruiselineTravelDetails = (CruiselineTravelDetails) o;
    return Objects.equals(this.cruiseShipName, cruiselineTravelDetails.cruiseShipName) &&
        Objects.equals(this.passengerName, cruiselineTravelDetails.passengerName) &&
        Objects.equals(this.departureDate, cruiselineTravelDetails.departureDate) &&
        Objects.equals(this.returnDate, cruiselineTravelDetails.returnDate) &&
        Objects.equals(this.country, cruiselineTravelDetails.country) &&
        Objects.equals(this.state, cruiselineTravelDetails.state) &&
        Objects.equals(this.originCity, cruiselineTravelDetails.originCity) &&
        Objects.equals(this.roomRate, cruiselineTravelDetails.roomRate) &&
        Objects.equals(this.travelPackageApplication, cruiselineTravelDetails.travelPackageApplication) &&
        Objects.equals(this.ticket, cruiselineTravelDetails.ticket) &&
        Objects.equals(this.passengers, cruiselineTravelDetails.passengers) &&
        Objects.equals(this.tripLegs, cruiselineTravelDetails.tripLegs);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cruiseShipName, passengerName, departureDate, returnDate, country, state, originCity, roomRate, travelPackageApplication, ticket, passengers, tripLegs);
  }

  @Override
  public String toString() {

    return "class CruiselineTravelDetails {\n"
        + "    cruiseShipName: " + toIndentedString(cruiseShipName) + "\n"
        + "    passengerName: " + toIndentedString(passengerName) + "\n"
        + "    departureDate: " + toIndentedString(departureDate) + "\n"
        + "    returnDate: " + toIndentedString(returnDate) + "\n"
        + "    country: " + toIndentedString(country) + "\n"
        + "    state: " + toIndentedString(state) + "\n"
        + "    originCity: " + toIndentedString(originCity) + "\n"
        + "    roomRate: " + toIndentedString(roomRate) + "\n"
        + "    travelPackageApplication: " + toIndentedString(travelPackageApplication) + "\n"
        + "    ticket: " + toIndentedString(ticket) + "\n"
        + "    passengers: " + toIndentedString(passengers) + "\n"
        + "    tripLegs: " + toIndentedString(tripLegs) + "\n"
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
   * Contains information about your cruise line travel. <br>**Note:** This object is only for Cruise line Merchants. <br>**Note:** This field has to be passed only in case of card transactions. builder static inner class.
   */
  public static final class Builder {
    private String cruiseShipName;
    private String passengerName;
    private String departureDate;
    private String returnDate;
    private String country;
    private String state;
    private String originCity;
    private BigDecimal roomRate;
    private TravelPackageApplication travelPackageApplication;
    private CruiselineTicket ticket;
    private Passengers passengers;
    private CruiselineTripLegs tripLegs;

    private Builder() {
    }

    /**
     * The ship name booked for the cruise. * Required during settlement request with AMEX for integration with TSYS processor
     * <p>
     * Sets the cruiseShipName and returns a reference to this Builder enabling method chaining.
     *
     * @param cruiseShipName the cruiseShipName to set
     * @return a reference to this Builder
     */
    public Builder cruiseShipName(String cruiseShipName) {
      this.cruiseShipName = cruiseShipName;
      return this;
    }

    /**
     * Name of the passenger to whom the ticket was issued. * Required during authorization request with AMEX for integration or TSYS processor * Required during settlement request with Visa or Mastercard for integration with TSYS processor
     * <p>
     * Sets the passengerName and returns a reference to this Builder enabling method chaining.
     *
     * @param passengerName the passengerName to set
     * @return a reference to this Builder
     */
    public Builder passengerName(String passengerName) {
      this.passengerName = passengerName;
      return this;
    }

    /**
     * Date of passenger's departure. Date format = YYYY-MM-DD, ISO 8601 expected. * Required during authorization request with AMEX for integration with TSYS processor * Required during settlement request for integration with TSYS processor _UTC Date Format_
     * <p>
     * Sets the departureDate and returns a reference to this Builder enabling method chaining.
     *
     * @param departureDate the departureDate to set
     * @return a reference to this Builder
     */
    public Builder departureDate(String departureDate) {
      this.departureDate = departureDate;
      return this;
    }

    /**
     * Date of passenger's return. Date format = YYYY-MM-DD, ISO 8601 expected. * Required during settlement request with AMEX for integration with TSYS processor _UTC Date Format_
     * <p>
     * Sets the returnDate and returns a reference to this Builder enabling method chaining.
     *
     * @param returnDate the returnDate to set
     * @return a reference to this Builder
     */
    public Builder returnDate(String returnDate) {
      this.returnDate = returnDate;
      return this;
    }

    /**
     * This field contains the country code of the cruise location.  See [Country Codes](https://developer.paysafe.com/en/support/reference-information/codes/#country-codes).  * Required during settlement request with AMEX for integration with TSYS processor
     * <p>
     * Sets the country and returns a reference to this Builder enabling method chaining.
     *
     * @param country the country to set
     * @return a reference to this Builder
     */
    public Builder country(String country) {
      this.country = country;
      return this;
    }

    /**
     * The region code that corresponds to the state, province, or other country subdivision of the cruise location.  See [Province Codes](https://developer.paysafe.com/en/support/reference-information/codes/#province-codes) or [State Codes](https://developer.paysafe.com/en/support/reference-information/codes/#state-codes) for Canada or the United States.  * Required during settlement request with AMEX for integration with TSYS processor
     * <p>
     * Sets the state and returns a reference to this Builder enabling method chaining.
     *
     * @param state the state to set
     * @return a reference to this Builder
     */
    public Builder state(String state) {
      this.state = state;
      return this;
    }

    /**
     * Departure City where the trip originates.  * Required for AMEX in case of integration with TSYS processor
     * <p>
     * Sets the originCity and returns a reference to this Builder enabling method chaining.
     *
     * @param originCity the originCity to set
     * @return a reference to this Builder
     */
    public Builder originCity(String originCity) {
      this.originCity = originCity;
      return this;
    }

    /**
     * Total cost of the cruise. For onboard purchases or transactions occurring during cruise travel, this field must be zero filled.  * Required during settlement request with AMEX for integration with TSYS processor
     * <p>
     * Sets the roomRate and returns a reference to this Builder enabling method chaining.
     *
     * @param roomRate the roomRate to set
     * @return a reference to this Builder
     */
    public Builder roomRate(BigDecimal roomRate) {
      this.roomRate = roomRate;
      return this;
    }

    /**
     * Sets the travelPackageApplication and returns a reference to this Builder enabling method chaining.
     *
     * @param travelPackageApplication the travelPackageApplication to set
     * @return a reference to this Builder
     */
    public Builder travelPackageApplication(TravelPackageApplication travelPackageApplication) {
      this.travelPackageApplication = travelPackageApplication;
      return this;
    }

    /**
     * Sets the ticket and returns a reference to this Builder enabling method chaining.
     *
     * @param ticket the ticket to set
     * @return a reference to this Builder
     */
    public Builder ticket(CruiselineTicket ticket) {
      this.ticket = ticket;
      return this;
    }

    /**
     * Sets the passengers and returns a reference to this Builder enabling method chaining.
     *
     * @param passengers the passengers to set
     * @return a reference to this Builder
     */
    public Builder passengers(Passengers passengers) {
      this.passengers = passengers;
      return this;
    }

    /**
     * Sets the tripLegs and returns a reference to this Builder enabling method chaining.
     *
     * @param tripLegs the tripLegs to set
     * @return a reference to this Builder
     */
    public Builder tripLegs(CruiselineTripLegs tripLegs) {
      this.tripLegs = tripLegs;
      return this;
    }

    /**
     * Returns a CruiselineTravelDetails built from the parameters previously set.
     *
     * @return a CruiselineTravelDetails built with parameters of this CruiselineTravelDetails.Builder
     */
    public CruiselineTravelDetails build() {
      return new CruiselineTravelDetails(this);
    }
  }
}
