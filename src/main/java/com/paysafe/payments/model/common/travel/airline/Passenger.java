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
import com.paysafe.payments.model.common.travel.airline.enums.Gender;



/**
 * Passenger information.
 */
public class Passenger {

  @JsonProperty("ticketNumber")
  private String ticketNumber;
  @JsonProperty("firstName")
  private String firstName;
  @JsonProperty("lastName")
  private String lastName;
  @JsonProperty("phoneNumber")
  private String phoneNumber;
  @JsonProperty("passengerCode")
  private String passengerCode;
  @JsonProperty("gender")
  private Gender gender;

  public Passenger() {
    super();
  }

  private Passenger(final Builder builder) {
    setTicketNumber(builder.ticketNumber);
    setFirstName(builder.firstName);
    setLastName(builder.lastName);
    setPhoneNumber(builder.phoneNumber);
    setPassengerCode(builder.passengerCode);
    setGender(builder.gender);
  }

  public static Builder builder() {
    return new Builder();
  }


  public Passenger ticketNumber(String ticketNumber) {
    this.ticketNumber = ticketNumber;
    return this;
  }

  /**
   * Identifies the ticket for this passenger only
   *
   * @return ticketNumber
   */
  public String getTicketNumber() {
    return ticketNumber;
  }

  public void setTicketNumber(String ticketNumber) {
    this.ticketNumber = ticketNumber;
  }


  public Passenger firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  /**
   * Passenger's first name
   *
   * @return firstName
   */
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }


  public Passenger lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  /**
   * Passenger's last name
   *
   * @return lastName
   */
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }


  public Passenger phoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
    return this;
  }

  /**
   * Passenger's phone number
   *
   * @return phoneNumber
   */
  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }


  public Passenger passengerCode(String passengerCode) {
    this.passengerCode = passengerCode;
    return this;
  }

  /**
   * Code that identifies a type of passenger. For example 'INF' which indicates a child traveling on parent's lap
   *
   * @return passengerCode
   */
  public String getPassengerCode() {
    return passengerCode;
  }

  public void setPassengerCode(String passengerCode) {
    this.passengerCode = passengerCode;
  }


  public Passenger gender(Gender gender) {
    this.gender = gender;
    return this;
  }

  /**
   * Get gender
   *
   * @return gender
   */
  public Gender getGender() {
    return gender;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Passenger passenger = (Passenger) o;
    return Objects.equals(this.ticketNumber, passenger.ticketNumber) &&
        Objects.equals(this.firstName, passenger.firstName) &&
        Objects.equals(this.lastName, passenger.lastName) &&
        Objects.equals(this.phoneNumber, passenger.phoneNumber) &&
        Objects.equals(this.passengerCode, passenger.passengerCode) &&
        Objects.equals(this.gender, passenger.gender);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ticketNumber, firstName, lastName, phoneNumber, passengerCode, gender);
  }

  @Override
  public String toString() {

    return "class Passenger {\n"
        + "    ticketNumber: " + toIndentedString(ticketNumber) + "\n"
        + "    firstName: " + toIndentedString(firstName) + "\n"
        + "    lastName: " + toIndentedString(lastName) + "\n"
        + "    phoneNumber: " + toIndentedString(phoneNumber) + "\n"
        + "    passengerCode: " + toIndentedString(passengerCode) + "\n"
        + "    gender: " + toIndentedString(gender) + "\n"
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
   * Passenger information. builder static inner class.
   */
  public static final class Builder {
    private String ticketNumber;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String passengerCode;
    private Gender gender;

    private Builder() {
    }

    /**
     * Identifies the ticket for this passenger only
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
     * Passenger's first name
     * <p>
     * Sets the firstName and returns a reference to this Builder enabling method chaining.
     *
     * @param firstName the firstName to set
     * @return a reference to this Builder
     */
    public Builder firstName(String firstName) {
      this.firstName = firstName;
      return this;
    }

    /**
     * Passenger's last name
     * <p>
     * Sets the lastName and returns a reference to this Builder enabling method chaining.
     *
     * @param lastName the lastName to set
     * @return a reference to this Builder
     */
    public Builder lastName(String lastName) {
      this.lastName = lastName;
      return this;
    }

    /**
     * Passenger's phone number
     * <p>
     * Sets the phoneNumber and returns a reference to this Builder enabling method chaining.
     *
     * @param phoneNumber the phoneNumber to set
     * @return a reference to this Builder
     */
    public Builder phoneNumber(String phoneNumber) {
      this.phoneNumber = phoneNumber;
      return this;
    }

    /**
     * Code that identifies a type of passenger. For example 'INF' which indicates a child traveling on parent's lap
     * <p>
     * Sets the passengerCode and returns a reference to this Builder enabling method chaining.
     *
     * @param passengerCode the passengerCode to set
     * @return a reference to this Builder
     */
    public Builder passengerCode(String passengerCode) {
      this.passengerCode = passengerCode;
      return this;
    }

    /**
     * Sets the gender and returns a reference to this Builder enabling method chaining.
     *
     * @param gender the gender to set
     * @return a reference to this Builder
     */
    public Builder gender(Gender gender) {
      this.gender = gender;
      return this;
    }

    /**
     * Returns a Passenger built from the parameters previously set.
     *
     * @return a Passenger built with parameters of this Passenger.Builder
     */
    public Passenger build() {
      return new Passenger(this);
    }
  }
}
