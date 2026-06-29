// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.model.card.threeds;

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
 * Travel-related details for the transaction
 */
public class TravelDetails {

  @JsonProperty("isAirTravel")
  private Boolean isAirTravel;
  @JsonProperty("airlineCarrier")
  private String airlineCarrier;
  @JsonProperty("departureDate")
  private String departureDate;
  @JsonProperty("destination")
  private String destination;
  @JsonProperty("origin")
  private String origin;
  @JsonProperty("passengerFirstName")
  private String passengerFirstName;
  @JsonProperty("passengerLastName")
  private String passengerLastName;

  public TravelDetails() {
    super();
  }

  private TravelDetails(final Builder builder) {
    setIsAirTravel(builder.isAirTravel);
    setAirlineCarrier(builder.airlineCarrier);
    setDepartureDate(builder.departureDate);
    setDestination(builder.destination);
    setOrigin(builder.origin);
    setPassengerFirstName(builder.passengerFirstName);
    setPassengerLastName(builder.passengerLastName);
  }

  public static Builder builder() {
    return new Builder();
  }


  public TravelDetails isAirTravel(Boolean isAirTravel) {
    this.isAirTravel = isAirTravel;
    return this;
  }

  /**
   * Whether the travel involves air travel
   *
   * @return isAirTravel
   */
  public Boolean getIsAirTravel() {
    return isAirTravel;
  }

  public void setIsAirTravel(Boolean isAirTravel) {
    this.isAirTravel = isAirTravel;
  }


  public TravelDetails airlineCarrier(String airlineCarrier) {
    this.airlineCarrier = airlineCarrier;
    return this;
  }

  /**
   * Airline carrier
   *
   * @return airlineCarrier
   */
  public String getAirlineCarrier() {
    return airlineCarrier;
  }

  public void setAirlineCarrier(String airlineCarrier) {
    this.airlineCarrier = airlineCarrier;
  }


  public TravelDetails departureDate(String departureDate) {
    this.departureDate = departureDate;
    return this;
  }

  /**
   * Date of departure in the time zone of the departure location. The ISO 8601 date format is expected, i.e., YYYY-MM-DD.
   *
   * @return departureDate
   */
  public String getDepartureDate() {
    return departureDate;
  }

  public void setDepartureDate(String departureDate) {
    this.departureDate = departureDate;
  }


  public TravelDetails destination(String destination) {
    this.destination = destination;
    return this;
  }

  /**
   * Travel destination Airport Code
   *
   * @return destination
   */
  public String getDestination() {
    return destination;
  }

  public void setDestination(String destination) {
    this.destination = destination;
  }


  public TravelDetails origin(String origin) {
    this.origin = origin;
    return this;
  }

  /**
   * Travel origin Airport Code
   *
   * @return origin
   */
  public String getOrigin() {
    return origin;
  }

  public void setOrigin(String origin) {
    this.origin = origin;
  }


  public TravelDetails passengerFirstName(String passengerFirstName) {
    this.passengerFirstName = passengerFirstName;
    return this;
  }

  /**
   * First name of the passenger
   *
   * @return passengerFirstName
   */
  public String getPassengerFirstName() {
    return passengerFirstName;
  }

  public void setPassengerFirstName(String passengerFirstName) {
    this.passengerFirstName = passengerFirstName;
  }


  public TravelDetails passengerLastName(String passengerLastName) {
    this.passengerLastName = passengerLastName;
    return this;
  }

  /**
   * Last name of the passenger
   *
   * @return passengerLastName
   */
  public String getPassengerLastName() {
    return passengerLastName;
  }

  public void setPassengerLastName(String passengerLastName) {
    this.passengerLastName = passengerLastName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TravelDetails travelDetails = (TravelDetails) o;
    return Objects.equals(this.isAirTravel, travelDetails.isAirTravel) &&
        Objects.equals(this.airlineCarrier, travelDetails.airlineCarrier) &&
        Objects.equals(this.departureDate, travelDetails.departureDate) &&
        Objects.equals(this.destination, travelDetails.destination) &&
        Objects.equals(this.origin, travelDetails.origin) &&
        Objects.equals(this.passengerFirstName, travelDetails.passengerFirstName) &&
        Objects.equals(this.passengerLastName, travelDetails.passengerLastName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(isAirTravel, airlineCarrier, departureDate, destination, origin, passengerFirstName, passengerLastName);
  }

  @Override
  public String toString() {

    return "class TravelDetails {\n"
        + "    isAirTravel: " + toIndentedString(isAirTravel) + "\n"
        + "    airlineCarrier: " + toIndentedString(airlineCarrier) + "\n"
        + "    departureDate: " + toIndentedString(departureDate) + "\n"
        + "    destination: " + toIndentedString(destination) + "\n"
        + "    origin: " + toIndentedString(origin) + "\n"
        + "    passengerFirstName: " + toIndentedString(passengerFirstName) + "\n"
        + "    passengerLastName: " + toIndentedString(passengerLastName) + "\n"
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
   * Travel-related details for the transaction builder static inner class.
   */
  public static final class Builder {
    private Boolean isAirTravel;
    private String airlineCarrier;
    private String departureDate;
    private String destination;
    private String origin;
    private String passengerFirstName;
    private String passengerLastName;

    private Builder() {
    }

    /**
     * Whether the travel involves air travel
     * <p>
     * Sets the isAirTravel and returns a reference to this Builder enabling method chaining.
     *
     * @param isAirTravel the isAirTravel to set
     * @return a reference to this Builder
     */
    public Builder isAirTravel(Boolean isAirTravel) {
      this.isAirTravel = isAirTravel;
      return this;
    }

    /**
     * Airline carrier
     * <p>
     * Sets the airlineCarrier and returns a reference to this Builder enabling method chaining.
     *
     * @param airlineCarrier the airlineCarrier to set
     * @return a reference to this Builder
     */
    public Builder airlineCarrier(String airlineCarrier) {
      this.airlineCarrier = airlineCarrier;
      return this;
    }

    /**
     * Date of departure in the time zone of the departure location. The ISO 8601 date format is expected, i.e., YYYY-MM-DD.
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
     * Travel destination Airport Code
     * <p>
     * Sets the destination and returns a reference to this Builder enabling method chaining.
     *
     * @param destination the destination to set
     * @return a reference to this Builder
     */
    public Builder destination(String destination) {
      this.destination = destination;
      return this;
    }

    /**
     * Travel origin Airport Code
     * <p>
     * Sets the origin and returns a reference to this Builder enabling method chaining.
     *
     * @param origin the origin to set
     * @return a reference to this Builder
     */
    public Builder origin(String origin) {
      this.origin = origin;
      return this;
    }

    /**
     * First name of the passenger
     * <p>
     * Sets the passengerFirstName and returns a reference to this Builder enabling method chaining.
     *
     * @param passengerFirstName the passengerFirstName to set
     * @return a reference to this Builder
     */
    public Builder passengerFirstName(String passengerFirstName) {
      this.passengerFirstName = passengerFirstName;
      return this;
    }

    /**
     * Last name of the passenger
     * <p>
     * Sets the passengerLastName and returns a reference to this Builder enabling method chaining.
     *
     * @param passengerLastName the passengerLastName to set
     * @return a reference to this Builder
     */
    public Builder passengerLastName(String passengerLastName) {
      this.passengerLastName = passengerLastName;
      return this;
    }

    /**
     * Returns a TravelDetails built from the parameters previously set.
     *
     * @return a TravelDetails built with parameters of this TravelDetails.Builder
     */
    public TravelDetails build() {
      return new TravelDetails(this);
    }
  }
}
