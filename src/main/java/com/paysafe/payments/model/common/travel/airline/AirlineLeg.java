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
import com.paysafe.payments.model.common.travel.airline.enums.ServiceClass;



/**
 * Contains detailed itinerary information for one of the trip legs.
 */
public class AirlineLeg {

  @JsonProperty("fare")
  private String fare;
  @JsonProperty("serviceClass")
  private ServiceClass serviceClass;
  @JsonProperty("serviceClassFee")
  private String serviceClassFee;
  @JsonProperty("isStopOverAllowed")
  private Boolean isStopOverAllowed;
  @JsonProperty("departureAirport")
  private String departureAirport;
  @JsonProperty("destination")
  private String destination;
  @JsonProperty("fareBasis")
  private String fareBasis;
  @JsonProperty("departureDate")
  private String departureDate;
  @JsonProperty("departureTime")
  private String departureTime;
  @JsonProperty("arrivalTime")
  private String arrivalTime;
  @JsonProperty("conjunctionTicket")
  private String conjunctionTicket;
  @JsonProperty("couponNumber")
  private String couponNumber;
  @JsonProperty("notation")
  private String notation;
  @JsonProperty("taxes")
  private String taxes;
  @JsonProperty("flight")
  private Flight flight;

  public AirlineLeg() {
    super();
  }

  private AirlineLeg(final Builder builder) {
    setFare(builder.fare);
    setServiceClass(builder.serviceClass);
    setServiceClassFee(builder.serviceClassFee);
    setIsStopOverAllowed(builder.isStopOverAllowed);
    setDepartureAirport(builder.departureAirport);
    setDestination(builder.destination);
    setFareBasis(builder.fareBasis);
    setDepartureDate(builder.departureDate);
    setDepartureTime(builder.departureTime);
    setArrivalTime(builder.arrivalTime);
    setConjunctionTicket(builder.conjunctionTicket);
    setCouponNumber(builder.couponNumber);
    setNotation(builder.notation);
    setTaxes(builder.taxes);
    setFlight(builder.flight);
  }

  public static Builder builder() {
    return new Builder();
  }


  public AirlineLeg fare(String fare) {
    this.fare = fare;
    return this;
  }

  /**
   * Indicates the total fare applied to a specific leg
   *
   * @return fare
   */
  public String getFare() {
    return fare;
  }

  public void setFare(String fare) {
    this.fare = fare;
  }


  public AirlineLeg serviceClass(ServiceClass serviceClass) {
    this.serviceClass = serviceClass;
    return this;
  }

  /**
   * Get serviceClass
   *
   * @return serviceClass
   */
  public ServiceClass getServiceClass() {
    return serviceClass;
  }

  public void setServiceClass(ServiceClass serviceClass) {
    this.serviceClass = serviceClass;
  }


  public AirlineLeg serviceClassFee(String serviceClassFee) {
    this.serviceClassFee = serviceClassFee;
    return this;
  }

  /**
   * Fee applied to a specific leg
   *
   * @return serviceClassFee
   */
  public String getServiceClassFee() {
    return serviceClassFee;
  }

  public void setServiceClassFee(String serviceClassFee) {
    this.serviceClassFee = serviceClassFee;
  }


  public AirlineLeg isStopOverAllowed(Boolean isStopOverAllowed) {
    this.isStopOverAllowed = isStopOverAllowed;
    return this;
  }

  /**
   * Indicates whether a stopover is allowed on this ticket. false - not allowed, true - allowed
   *
   * @return isStopOverAllowed
   */
  public Boolean getIsStopOverAllowed() {
    return isStopOverAllowed;
  }

  public void setIsStopOverAllowed(Boolean isStopOverAllowed) {
    this.isStopOverAllowed = isStopOverAllowed;
  }


  public AirlineLeg departureAirport(String departureAirport) {
    this.departureAirport = departureAirport;
    return this;
  }

  /**
   * Departure airport
   *
   * @return departureAirport
   */
  public String getDepartureAirport() {
    return departureAirport;
  }

  public void setDepartureAirport(String departureAirport) {
    this.departureAirport = departureAirport;
  }


  public AirlineLeg destination(String destination) {
    this.destination = destination;
    return this;
  }

  /**
   * Destination Airport Code (IATA Airport Code)
   *
   * @return destination
   */
  public String getDestination() {
    return destination;
  }

  public void setDestination(String destination) {
    this.destination = destination;
  }


  public AirlineLeg fareBasis(String fareBasis) {
    this.fareBasis = fareBasis;
    return this;
  }

  /**
   * Contains a Fare Basis Code for Leg that carriers assign to a particular ticket type, such as business class or discounted/nonrefundable
   *
   * @return fareBasis
   */
  public String getFareBasis() {
    return fareBasis;
  }

  public void setFareBasis(String fareBasis) {
    this.fareBasis = fareBasis;
  }


  public AirlineLeg departureDate(String departureDate) {
    this.departureDate = departureDate;
    return this;
  }

  /**
   * Date of passenger's departure for this leg. Date format YYYY-MM-DD, ISO 8601 expected. For example, 2014-01-26
   *
   * @return departureDate
   */
  public String getDepartureDate() {
    return departureDate;
  }

  public void setDepartureDate(String departureDate) {
    this.departureDate = departureDate;
  }


  public AirlineLeg departureTime(String departureTime) {
    this.departureTime = departureTime;
    return this;
  }

  /**
   * Departure time
   *
   * @return departureTime
   */
  public String getDepartureTime() {
    return departureTime;
  }

  public void setDepartureTime(String departureTime) {
    this.departureTime = departureTime;
  }


  public AirlineLeg arrivalTime(String arrivalTime) {
    this.arrivalTime = arrivalTime;
    return this;
  }

  /**
   * Arrival time
   *
   * @return arrivalTime
   */
  public String getArrivalTime() {
    return arrivalTime;
  }

  public void setArrivalTime(String arrivalTime) {
    this.arrivalTime = arrivalTime;
  }


  public AirlineLeg conjunctionTicket(String conjunctionTicket) {
    this.conjunctionTicket = conjunctionTicket;
    return this;
  }

  /**
   * Conjunction ticket information
   *
   * @return conjunctionTicket
   */
  public String getConjunctionTicket() {
    return conjunctionTicket;
  }

  public void setConjunctionTicket(String conjunctionTicket) {
    this.conjunctionTicket = conjunctionTicket;
  }


  public AirlineLeg couponNumber(String couponNumber) {
    this.couponNumber = couponNumber;
    return this;
  }

  /**
   * Coupon number
   *
   * @return couponNumber
   */
  public String getCouponNumber() {
    return couponNumber;
  }

  public void setCouponNumber(String couponNumber) {
    this.couponNumber = couponNumber;
  }


  public AirlineLeg notation(String notation) {
    this.notation = notation;
    return this;
  }

  /**
   * Notation information
   *
   * @return notation
   */
  public String getNotation() {
    return notation;
  }

  public void setNotation(String notation) {
    this.notation = notation;
  }


  public AirlineLeg taxes(String taxes) {
    this.taxes = taxes;
    return this;
  }

  /**
   * Taxes for this leg
   *
   * @return taxes
   */
  public String getTaxes() {
    return taxes;
  }

  public void setTaxes(String taxes) {
    this.taxes = taxes;
  }


  public AirlineLeg flight(Flight flight) {
    this.flight = flight;
    return this;
  }

  /**
   * Get flight
   *
   * @return flight
   */
  public Flight getFlight() {
    return flight;
  }

  public void setFlight(Flight flight) {
    this.flight = flight;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AirlineLeg airlineLeg = (AirlineLeg) o;
    return Objects.equals(this.fare, airlineLeg.fare) &&
        Objects.equals(this.serviceClass, airlineLeg.serviceClass) &&
        Objects.equals(this.serviceClassFee, airlineLeg.serviceClassFee) &&
        Objects.equals(this.isStopOverAllowed, airlineLeg.isStopOverAllowed) &&
        Objects.equals(this.departureAirport, airlineLeg.departureAirport) &&
        Objects.equals(this.destination, airlineLeg.destination) &&
        Objects.equals(this.fareBasis, airlineLeg.fareBasis) &&
        Objects.equals(this.departureDate, airlineLeg.departureDate) &&
        Objects.equals(this.departureTime, airlineLeg.departureTime) &&
        Objects.equals(this.arrivalTime, airlineLeg.arrivalTime) &&
        Objects.equals(this.conjunctionTicket, airlineLeg.conjunctionTicket) &&
        Objects.equals(this.couponNumber, airlineLeg.couponNumber) &&
        Objects.equals(this.notation, airlineLeg.notation) &&
        Objects.equals(this.taxes, airlineLeg.taxes) &&
        Objects.equals(this.flight, airlineLeg.flight);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fare, serviceClass, serviceClassFee, isStopOverAllowed, departureAirport, destination, fareBasis, departureDate, departureTime, arrivalTime, conjunctionTicket, couponNumber, notation, taxes, flight);
  }

  @Override
  public String toString() {

    return "class AirlineLeg {\n"
        + "    fare: " + toIndentedString(fare) + "\n"
        + "    serviceClass: " + toIndentedString(serviceClass) + "\n"
        + "    serviceClassFee: " + toIndentedString(serviceClassFee) + "\n"
        + "    isStopOverAllowed: " + toIndentedString(isStopOverAllowed) + "\n"
        + "    departureAirport: " + toIndentedString(departureAirport) + "\n"
        + "    destination: " + toIndentedString(destination) + "\n"
        + "    fareBasis: " + toIndentedString(fareBasis) + "\n"
        + "    departureDate: " + toIndentedString(departureDate) + "\n"
        + "    departureTime: " + toIndentedString(departureTime) + "\n"
        + "    arrivalTime: " + toIndentedString(arrivalTime) + "\n"
        + "    conjunctionTicket: " + toIndentedString(conjunctionTicket) + "\n"
        + "    couponNumber: " + toIndentedString(couponNumber) + "\n"
        + "    notation: " + toIndentedString(notation) + "\n"
        + "    taxes: " + toIndentedString(taxes) + "\n"
        + "    flight: " + toIndentedString(flight) + "\n"
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
   * Contains detailed itinerary information for one of the trip legs. builder static inner class.
   */
  public static final class Builder {
    private String fare;
    private ServiceClass serviceClass;
    private String serviceClassFee;
    private Boolean isStopOverAllowed;
    private String departureAirport;
    private String destination;
    private String fareBasis;
    private String departureDate;
    private String departureTime;
    private String arrivalTime;
    private String conjunctionTicket;
    private String couponNumber;
    private String notation;
    private String taxes;
    private Flight flight;

    private Builder() {
    }

    /**
     * Indicates the total fare applied to a specific leg
     * <p>
     * Sets the fare and returns a reference to this Builder enabling method chaining.
     *
     * @param fare the fare to set
     * @return a reference to this Builder
     */
    public Builder fare(String fare) {
      this.fare = fare;
      return this;
    }

    /**
     * Sets the serviceClass and returns a reference to this Builder enabling method chaining.
     *
     * @param serviceClass the serviceClass to set
     * @return a reference to this Builder
     */
    public Builder serviceClass(ServiceClass serviceClass) {
      this.serviceClass = serviceClass;
      return this;
    }

    /**
     * Fee applied to a specific leg
     * <p>
     * Sets the serviceClassFee and returns a reference to this Builder enabling method chaining.
     *
     * @param serviceClassFee the serviceClassFee to set
     * @return a reference to this Builder
     */
    public Builder serviceClassFee(String serviceClassFee) {
      this.serviceClassFee = serviceClassFee;
      return this;
    }

    /**
     * Indicates whether a stopover is allowed on this ticket. false - not allowed, true - allowed
     * <p>
     * Sets the isStopOverAllowed and returns a reference to this Builder enabling method chaining.
     *
     * @param isStopOverAllowed the isStopOverAllowed to set
     * @return a reference to this Builder
     */
    public Builder isStopOverAllowed(Boolean isStopOverAllowed) {
      this.isStopOverAllowed = isStopOverAllowed;
      return this;
    }

    /**
     * Departure airport
     * <p>
     * Sets the departureAirport and returns a reference to this Builder enabling method chaining.
     *
     * @param departureAirport the departureAirport to set
     * @return a reference to this Builder
     */
    public Builder departureAirport(String departureAirport) {
      this.departureAirport = departureAirport;
      return this;
    }

    /**
     * Destination Airport Code (IATA Airport Code)
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
     * Contains a Fare Basis Code for Leg that carriers assign to a particular ticket type, such as business class or discounted/nonrefundable
     * <p>
     * Sets the fareBasis and returns a reference to this Builder enabling method chaining.
     *
     * @param fareBasis the fareBasis to set
     * @return a reference to this Builder
     */
    public Builder fareBasis(String fareBasis) {
      this.fareBasis = fareBasis;
      return this;
    }

    /**
     * Date of passenger's departure for this leg. Date format YYYY-MM-DD, ISO 8601 expected. For example, 2014-01-26
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
     * Departure time
     * <p>
     * Sets the departureTime and returns a reference to this Builder enabling method chaining.
     *
     * @param departureTime the departureTime to set
     * @return a reference to this Builder
     */
    public Builder departureTime(String departureTime) {
      this.departureTime = departureTime;
      return this;
    }

    /**
     * Arrival time
     * <p>
     * Sets the arrivalTime and returns a reference to this Builder enabling method chaining.
     *
     * @param arrivalTime the arrivalTime to set
     * @return a reference to this Builder
     */
    public Builder arrivalTime(String arrivalTime) {
      this.arrivalTime = arrivalTime;
      return this;
    }

    /**
     * Conjunction ticket information
     * <p>
     * Sets the conjunctionTicket and returns a reference to this Builder enabling method chaining.
     *
     * @param conjunctionTicket the conjunctionTicket to set
     * @return a reference to this Builder
     */
    public Builder conjunctionTicket(String conjunctionTicket) {
      this.conjunctionTicket = conjunctionTicket;
      return this;
    }

    /**
     * Coupon number
     * <p>
     * Sets the couponNumber and returns a reference to this Builder enabling method chaining.
     *
     * @param couponNumber the couponNumber to set
     * @return a reference to this Builder
     */
    public Builder couponNumber(String couponNumber) {
      this.couponNumber = couponNumber;
      return this;
    }

    /**
     * Notation information
     * <p>
     * Sets the notation and returns a reference to this Builder enabling method chaining.
     *
     * @param notation the notation to set
     * @return a reference to this Builder
     */
    public Builder notation(String notation) {
      this.notation = notation;
      return this;
    }

    /**
     * Taxes for this leg
     * <p>
     * Sets the taxes and returns a reference to this Builder enabling method chaining.
     *
     * @param taxes the taxes to set
     * @return a reference to this Builder
     */
    public Builder taxes(String taxes) {
      this.taxes = taxes;
      return this;
    }

    /**
     * Sets the flight and returns a reference to this Builder enabling method chaining.
     *
     * @param flight the flight to set
     * @return a reference to this Builder
     */
    public Builder flight(Flight flight) {
      this.flight = flight;
      return this;
    }

    /**
     * Returns a AirlineLeg built from the parameters previously set.
     *
     * @return a AirlineLeg built with parameters of this AirlineLeg.Builder
     */
    public AirlineLeg build() {
      return new AirlineLeg(this);
    }
  }
}
