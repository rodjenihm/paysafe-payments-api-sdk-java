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
import com.paysafe.payments.model.common.travel.airline.enums.ComputerizedReservationSystem;



/**
 * Contains information about your airline travel. <br>**Note:** This object is only for Airline Merchants. <br>**Note:** This field has to be passed only in case of card transactions.
 */
public class AirlineTravelDetails {

  @JsonProperty("passengerNameRecord")
  private String passengerNameRecord;
  @JsonProperty("passengerName")
  private String passengerName;
  @JsonProperty("departureDate")
  private String departureDate;
  @JsonProperty("origin")
  private String origin;
  @JsonProperty("computerizedReservationSystem")
  private ComputerizedReservationSystem computerizedReservationSystem;
  @JsonProperty("additionalBookingReference")
  private String additionalBookingReference;
  @JsonProperty("totalFare")
  private Integer totalFare;
  @JsonProperty("totalFee")
  private Integer totalFee;
  @JsonProperty("totalTaxes")
  private Integer totalTaxes;
  @JsonProperty("ticket")
  private AirlineTicket ticket;
  @JsonProperty("passengers")
  private Passengers passengers;
  @JsonProperty("customerReferenceNumber")
  private String customerReferenceNumber;
  @JsonProperty("travelAgency")
  private TravelAgency travelAgency;
  @JsonProperty("tripLegs")
  private AirlineTripLegs tripLegs;

  public AirlineTravelDetails() {
    super();
  }

  private AirlineTravelDetails(final Builder builder) {
    setPassengerNameRecord(builder.passengerNameRecord);
    setPassengerName(builder.passengerName);
    setDepartureDate(builder.departureDate);
    setOrigin(builder.origin);
    setComputerizedReservationSystem(builder.computerizedReservationSystem);
    setAdditionalBookingReference(builder.additionalBookingReference);
    setTotalFare(builder.totalFare);
    setTotalFee(builder.totalFee);
    setTotalTaxes(builder.totalTaxes);
    setTicket(builder.ticket);
    setPassengers(builder.passengers);
    setCustomerReferenceNumber(builder.customerReferenceNumber);
    setTravelAgency(builder.travelAgency);
    setTripLegs(builder.tripLegs);
  }

  public static Builder builder() {
    return new Builder();
  }


  public AirlineTravelDetails passengerNameRecord(String passengerNameRecord) {
    this.passengerNameRecord = passengerNameRecord;
    return this;
  }

  /**
   * The airline company uses the passengerNameRecord as a reservation number
   *
   * @return passengerNameRecord
   */
  public String getPassengerNameRecord() {
    return passengerNameRecord;
  }

  public void setPassengerNameRecord(String passengerNameRecord) {
    this.passengerNameRecord = passengerNameRecord;
  }


  public AirlineTravelDetails passengerName(String passengerName) {
    this.passengerName = passengerName;
    return this;
  }

  /**
   * Name of the passenger to whom the ticket was issued
   *
   * @return passengerName
   */
  public String getPassengerName() {
    return passengerName;
  }

  public void setPassengerName(String passengerName) {
    this.passengerName = passengerName;
  }


  public AirlineTravelDetails departureDate(String departureDate) {
    this.departureDate = departureDate;
    return this;
  }

  /**
   * Date of passenger's departure. Date format YYYY-MM-DD, ISO 8601 expected. For example 2022-12-20
   *
   * @return departureDate
   */
  public String getDepartureDate() {
    return departureDate;
  }

  public void setDepartureDate(String departureDate) {
    this.departureDate = departureDate;
  }


  public AirlineTravelDetails origin(String origin) {
    this.origin = origin;
    return this;
  }

  /**
   * Origin airport code (IATA Airport Code)
   *
   * @return origin
   */
  public String getOrigin() {
    return origin;
  }

  public void setOrigin(String origin) {
    this.origin = origin;
  }


  public AirlineTravelDetails computerizedReservationSystem(ComputerizedReservationSystem computerizedReservationSystem) {
    this.computerizedReservationSystem = computerizedReservationSystem;
    return this;
  }

  /**
   * Get computerizedReservationSystem
   *
   * @return computerizedReservationSystem
   */
  public ComputerizedReservationSystem getComputerizedReservationSystem() {
    return computerizedReservationSystem;
  }

  public void setComputerizedReservationSystem(ComputerizedReservationSystem computerizedReservationSystem) {
    this.computerizedReservationSystem = computerizedReservationSystem;
  }


  public AirlineTravelDetails additionalBookingReference(String additionalBookingReference) {
    this.additionalBookingReference = additionalBookingReference;
    return this;
  }

  /**
   * Additional booking reference information
   *
   * @return additionalBookingReference
   */
  public String getAdditionalBookingReference() {
    return additionalBookingReference;
  }

  public void setAdditionalBookingReference(String additionalBookingReference) {
    this.additionalBookingReference = additionalBookingReference;
  }


  public AirlineTravelDetails totalFare(Integer totalFare) {
    this.totalFare = totalFare;
    return this;
  }

  /**
   * Total fare amount in minor units
   *
   * @return totalFare
   */
  public Integer getTotalFare() {
    return totalFare;
  }

  public void setTotalFare(Integer totalFare) {
    this.totalFare = totalFare;
  }


  public AirlineTravelDetails totalFee(Integer totalFee) {
    this.totalFee = totalFee;
    return this;
  }

  /**
   * Total fee amount in minor units
   *
   * @return totalFee
   */
  public Integer getTotalFee() {
    return totalFee;
  }

  public void setTotalFee(Integer totalFee) {
    this.totalFee = totalFee;
  }


  public AirlineTravelDetails totalTaxes(Integer totalTaxes) {
    this.totalTaxes = totalTaxes;
    return this;
  }

  /**
   * Total taxes amount in minor units
   *
   * @return totalTaxes
   */
  public Integer getTotalTaxes() {
    return totalTaxes;
  }

  public void setTotalTaxes(Integer totalTaxes) {
    this.totalTaxes = totalTaxes;
  }


  public AirlineTravelDetails ticket(AirlineTicket ticket) {
    this.ticket = ticket;
    return this;
  }

  /**
   * Get ticket
   *
   * @return ticket
   */
  public AirlineTicket getTicket() {
    return ticket;
  }

  public void setTicket(AirlineTicket ticket) {
    this.ticket = ticket;
  }


  public AirlineTravelDetails passengers(Passengers passengers) {
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


  public AirlineTravelDetails customerReferenceNumber(String customerReferenceNumber) {
    this.customerReferenceNumber = customerReferenceNumber;
    return this;
  }

  /**
   * Contains the code that the cardholder supplied to the card acceptor
   *
   * @return customerReferenceNumber
   */
  public String getCustomerReferenceNumber() {
    return customerReferenceNumber;
  }

  public void setCustomerReferenceNumber(String customerReferenceNumber) {
    this.customerReferenceNumber = customerReferenceNumber;
  }


  public AirlineTravelDetails travelAgency(TravelAgency travelAgency) {
    this.travelAgency = travelAgency;
    return this;
  }

  /**
   * Get travelAgency
   *
   * @return travelAgency
   */
  public TravelAgency getTravelAgency() {
    return travelAgency;
  }

  public void setTravelAgency(TravelAgency travelAgency) {
    this.travelAgency = travelAgency;
  }


  public AirlineTravelDetails tripLegs(AirlineTripLegs tripLegs) {
    this.tripLegs = tripLegs;
    return this;
  }

  /**
   * Get tripLegs
   *
   * @return tripLegs
   */
  public AirlineTripLegs getTripLegs() {
    return tripLegs;
  }

  public void setTripLegs(AirlineTripLegs tripLegs) {
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
    AirlineTravelDetails airlineTravelDetails = (AirlineTravelDetails) o;
    return Objects.equals(this.passengerNameRecord, airlineTravelDetails.passengerNameRecord) &&
        Objects.equals(this.passengerName, airlineTravelDetails.passengerName) &&
        Objects.equals(this.departureDate, airlineTravelDetails.departureDate) &&
        Objects.equals(this.origin, airlineTravelDetails.origin) &&
        Objects.equals(this.computerizedReservationSystem, airlineTravelDetails.computerizedReservationSystem) &&
        Objects.equals(this.additionalBookingReference, airlineTravelDetails.additionalBookingReference) &&
        Objects.equals(this.totalFare, airlineTravelDetails.totalFare) &&
        Objects.equals(this.totalFee, airlineTravelDetails.totalFee) &&
        Objects.equals(this.totalTaxes, airlineTravelDetails.totalTaxes) &&
        Objects.equals(this.ticket, airlineTravelDetails.ticket) &&
        Objects.equals(this.passengers, airlineTravelDetails.passengers) &&
        Objects.equals(this.customerReferenceNumber, airlineTravelDetails.customerReferenceNumber) &&
        Objects.equals(this.travelAgency, airlineTravelDetails.travelAgency) &&
        Objects.equals(this.tripLegs, airlineTravelDetails.tripLegs);
  }

  @Override
  public int hashCode() {
    return Objects.hash(passengerNameRecord, passengerName, departureDate, origin, computerizedReservationSystem, additionalBookingReference, totalFare, totalFee, totalTaxes, ticket, passengers, customerReferenceNumber, travelAgency, tripLegs);
  }

  @Override
  public String toString() {

    return "class AirlineTravelDetails {\n"
        + "    passengerNameRecord: " + toIndentedString(passengerNameRecord) + "\n"
        + "    passengerName: " + toIndentedString(passengerName) + "\n"
        + "    departureDate: " + toIndentedString(departureDate) + "\n"
        + "    origin: " + toIndentedString(origin) + "\n"
        + "    computerizedReservationSystem: " + toIndentedString(computerizedReservationSystem) + "\n"
        + "    additionalBookingReference: " + toIndentedString(additionalBookingReference) + "\n"
        + "    totalFare: " + toIndentedString(totalFare) + "\n"
        + "    totalFee: " + toIndentedString(totalFee) + "\n"
        + "    totalTaxes: " + toIndentedString(totalTaxes) + "\n"
        + "    ticket: " + toIndentedString(ticket) + "\n"
        + "    passengers: " + toIndentedString(passengers) + "\n"
        + "    customerReferenceNumber: " + toIndentedString(customerReferenceNumber) + "\n"
        + "    travelAgency: " + toIndentedString(travelAgency) + "\n"
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
   * Contains information about your airline travel. <br>**Note:** This object is only for Airline Merchants. <br>**Note:** This field has to be passed only in case of card transactions. builder static inner class.
   */
  public static final class Builder {
    private String passengerNameRecord;
    private String passengerName;
    private String departureDate;
    private String origin;
    private ComputerizedReservationSystem computerizedReservationSystem;
    private String additionalBookingReference;
    private Integer totalFare;
    private Integer totalFee;
    private Integer totalTaxes;
    private AirlineTicket ticket;
    private Passengers passengers;
    private String customerReferenceNumber;
    private TravelAgency travelAgency;
    private AirlineTripLegs tripLegs;

    private Builder() {
    }

    /**
     * The airline company uses the passengerNameRecord as a reservation number
     * <p>
     * Sets the passengerNameRecord and returns a reference to this Builder enabling method chaining.
     *
     * @param passengerNameRecord the passengerNameRecord to set
     * @return a reference to this Builder
     */
    public Builder passengerNameRecord(String passengerNameRecord) {
      this.passengerNameRecord = passengerNameRecord;
      return this;
    }

    /**
     * Name of the passenger to whom the ticket was issued
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
     * Date of passenger's departure. Date format YYYY-MM-DD, ISO 8601 expected. For example 2022-12-20
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
     * Origin airport code (IATA Airport Code)
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
     * Sets the computerizedReservationSystem and returns a reference to this Builder enabling method chaining.
     *
     * @param computerizedReservationSystem the computerizedReservationSystem to set
     * @return a reference to this Builder
     */
    public Builder computerizedReservationSystem(ComputerizedReservationSystem computerizedReservationSystem) {
      this.computerizedReservationSystem = computerizedReservationSystem;
      return this;
    }

    /**
     * Additional booking reference information
     * <p>
     * Sets the additionalBookingReference and returns a reference to this Builder enabling method chaining.
     *
     * @param additionalBookingReference the additionalBookingReference to set
     * @return a reference to this Builder
     */
    public Builder additionalBookingReference(String additionalBookingReference) {
      this.additionalBookingReference = additionalBookingReference;
      return this;
    }

    /**
     * Total fare amount in minor units
     * <p>
     * Sets the totalFare and returns a reference to this Builder enabling method chaining.
     *
     * @param totalFare the totalFare to set
     * @return a reference to this Builder
     */
    public Builder totalFare(Integer totalFare) {
      this.totalFare = totalFare;
      return this;
    }

    /**
     * Total fee amount in minor units
     * <p>
     * Sets the totalFee and returns a reference to this Builder enabling method chaining.
     *
     * @param totalFee the totalFee to set
     * @return a reference to this Builder
     */
    public Builder totalFee(Integer totalFee) {
      this.totalFee = totalFee;
      return this;
    }

    /**
     * Total taxes amount in minor units
     * <p>
     * Sets the totalTaxes and returns a reference to this Builder enabling method chaining.
     *
     * @param totalTaxes the totalTaxes to set
     * @return a reference to this Builder
     */
    public Builder totalTaxes(Integer totalTaxes) {
      this.totalTaxes = totalTaxes;
      return this;
    }

    /**
     * Sets the ticket and returns a reference to this Builder enabling method chaining.
     *
     * @param ticket the ticket to set
     * @return a reference to this Builder
     */
    public Builder ticket(AirlineTicket ticket) {
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
     * Contains the code that the cardholder supplied to the card acceptor
     * <p>
     * Sets the customerReferenceNumber and returns a reference to this Builder enabling method chaining.
     *
     * @param customerReferenceNumber the customerReferenceNumber to set
     * @return a reference to this Builder
     */
    public Builder customerReferenceNumber(String customerReferenceNumber) {
      this.customerReferenceNumber = customerReferenceNumber;
      return this;
    }

    /**
     * Sets the travelAgency and returns a reference to this Builder enabling method chaining.
     *
     * @param travelAgency the travelAgency to set
     * @return a reference to this Builder
     */
    public Builder travelAgency(TravelAgency travelAgency) {
      this.travelAgency = travelAgency;
      return this;
    }

    /**
     * Sets the tripLegs and returns a reference to this Builder enabling method chaining.
     *
     * @param tripLegs the tripLegs to set
     * @return a reference to this Builder
     */
    public Builder tripLegs(AirlineTripLegs tripLegs) {
      this.tripLegs = tripLegs;
      return this;
    }

    /**
     * Returns a AirlineTravelDetails built from the parameters previously set.
     *
     * @return a AirlineTravelDetails built with parameters of this AirlineTravelDetails.Builder
     */
    public AirlineTravelDetails build() {
      return new AirlineTravelDetails(this);
    }
  }
}
