// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.model.standalonecredit;

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
 * This is the sender's address.
 */
public class SenderAddress {

  @JsonProperty("street")
  private String street;
  @JsonProperty("city")
  private String city;
  @JsonProperty("state")
  private String state;
  @JsonProperty("country")
  private String country;
  @JsonProperty("zip")
  private String zip;

  public SenderAddress() {
    super();
  }

  private SenderAddress(final Builder builder) {
    setStreet(builder.street);
    setCity(builder.city);
    setState(builder.state);
    setCountry(builder.country);
    setZip(builder.zip);
  }

  public static Builder builder() {
    return new Builder();
  }


  public SenderAddress street(String street) {
    this.street = street;
    return this;
  }

  /**
   * Sender's street address.
   *
   * @return street
   */
  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }


  public SenderAddress city(String city) {
    this.city = city;
    return this;
  }

  /**
   * Sender's city.
   *
   * @return city
   */
  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }


  public SenderAddress state(String state) {
    this.state = state;
    return this;
  }

  /**
   * Sender's state.
   *
   * @return state
   */
  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }


  public SenderAddress country(String country) {
    this.country = country;
    return this;
  }

  /**
   * Sender's country.
   *
   * @return country
   */
  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }


  public SenderAddress zip(String zip) {
    this.zip = zip;
    return this;
  }

  /**
   * Sender's postal code.
   *
   * @return zip
   */
  public String getZip() {
    return zip;
  }

  public void setZip(String zip) {
    this.zip = zip;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SenderAddress senderAddress = (SenderAddress) o;
    return Objects.equals(this.street, senderAddress.street) &&
        Objects.equals(this.city, senderAddress.city) &&
        Objects.equals(this.state, senderAddress.state) &&
        Objects.equals(this.country, senderAddress.country) &&
        Objects.equals(this.zip, senderAddress.zip);
  }

  @Override
  public int hashCode() {
    return Objects.hash(street, city, state, country, zip);
  }

  @Override
  public String toString() {

    return "class SenderAddress {\n"
        + "    street: " + toIndentedString(street) + "\n"
        + "    city: " + toIndentedString(city) + "\n"
        + "    state: " + toIndentedString(state) + "\n"
        + "    country: " + toIndentedString(country) + "\n"
        + "    zip: " + toIndentedString(zip) + "\n"
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
   * This is the sender's address. builder static inner class.
   */
  public static final class Builder {
    private String street;
    private String city;
    private String state;
    private String country;
    private String zip;

    private Builder() {
    }

    /**
     * Sender's street address.
     * <p>
     * Sets the street and returns a reference to this Builder enabling method chaining.
     *
     * @param street the street to set
     * @return a reference to this Builder
     */
    public Builder street(String street) {
      this.street = street;
      return this;
    }

    /**
     * Sender's city.
     * <p>
     * Sets the city and returns a reference to this Builder enabling method chaining.
     *
     * @param city the city to set
     * @return a reference to this Builder
     */
    public Builder city(String city) {
      this.city = city;
      return this;
    }

    /**
     * Sender's state.
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
     * Sender's country.
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
     * Sender's postal code.
     * <p>
     * Sets the zip and returns a reference to this Builder enabling method chaining.
     *
     * @param zip the zip to set
     * @return a reference to this Builder
     */
    public Builder zip(String zip) {
      this.zip = zip;
      return this;
    }

    /**
     * Returns a SenderAddress built from the parameters previously set.
     *
     * @return a SenderAddress built with parameters of this SenderAddress.Builder
     */
    public SenderAddress build() {
      return new SenderAddress(this);
    }
  }
}
