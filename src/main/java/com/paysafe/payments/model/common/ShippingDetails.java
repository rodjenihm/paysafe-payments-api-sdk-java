// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.model.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.paysafe.payments.model.common.enums.ShipMethod;



/**
 * Shipping details for the transaction
 */
public class ShippingDetails {

  @JsonProperty("shipMethod")
  private ShipMethod shipMethod;
  @JsonProperty("recipientName")
  private String recipientName;
  @JsonProperty("street")
  private String street;
  @JsonProperty("street2")
  private String street2;
  @JsonProperty("city")
  private String city;
  @JsonProperty("state")
  private String state;
  @JsonProperty("country")
  private String country;
  @JsonProperty("zip")
  private String zip;
  @JsonProperty("phone")
  private String phone;

  public ShippingDetails() {
    super();
  }

  private ShippingDetails(final Builder builder) {
    setShipMethod(builder.shipMethod);
    setRecipientName(builder.recipientName);
    setStreet(builder.street);
    setStreet2(builder.street2);
    setCity(builder.city);
    setState(builder.state);
    setCountry(builder.country);
    setZip(builder.zip);
    setPhone(builder.phone);
  }

  public static Builder builder() {
    return new Builder();
  }


  public ShippingDetails shipMethod(ShipMethod shipMethod) {
    this.shipMethod = shipMethod;
    return this;
  }

  /**
   * Get shipMethod
   *
   * @return shipMethod
   */
  public ShipMethod getShipMethod() {
    return shipMethod;
  }

  public void setShipMethod(ShipMethod shipMethod) {
    this.shipMethod = shipMethod;
  }


  public ShippingDetails recipientName(String recipientName) {
    this.recipientName = recipientName;
    return this;
  }

  /**
   * Name of the recipient
   *
   * @return recipientName
   */
  public String getRecipientName() {
    return recipientName;
  }

  public void setRecipientName(String recipientName) {
    this.recipientName = recipientName;
  }


  public ShippingDetails street(String street) {
    this.street = street;
    return this;
  }

  /**
   * Street address
   *
   * @return street
   */
  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }


  public ShippingDetails street2(String street2) {
    this.street2 = street2;
    return this;
  }

  /**
   * Additional street address information
   *
   * @return street2
   */
  public String getStreet2() {
    return street2;
  }

  public void setStreet2(String street2) {
    this.street2 = street2;
  }


  public ShippingDetails city(String city) {
    this.city = city;
    return this;
  }

  /**
   * City
   *
   * @return city
   */
  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }


  public ShippingDetails state(String state) {
    this.state = state;
    return this;
  }

  /**
   * State or province
   *
   * @return state
   */
  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }


  public ShippingDetails country(String country) {
    this.country = country;
    return this;
  }

  /**
   * Two-letter ISO country code
   *
   * @return country
   */
  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }


  public ShippingDetails zip(String zip) {
    this.zip = zip;
    return this;
  }

  /**
   * Postal code
   *
   * @return zip
   */
  public String getZip() {
    return zip;
  }

  public void setZip(String zip) {
    this.zip = zip;
  }


  public ShippingDetails phone(String phone) {
    this.phone = phone;
    return this;
  }

  /**
   * Phone number
   *
   * @return phone
   */
  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ShippingDetails shippingDetails = (ShippingDetails) o;
    return Objects.equals(this.shipMethod, shippingDetails.shipMethod) &&
        Objects.equals(this.recipientName, shippingDetails.recipientName) &&
        Objects.equals(this.street, shippingDetails.street) &&
        Objects.equals(this.street2, shippingDetails.street2) &&
        Objects.equals(this.city, shippingDetails.city) &&
        Objects.equals(this.state, shippingDetails.state) &&
        Objects.equals(this.country, shippingDetails.country) &&
        Objects.equals(this.zip, shippingDetails.zip) &&
        Objects.equals(this.phone, shippingDetails.phone);
  }

  @Override
  public int hashCode() {
    return Objects.hash(shipMethod, recipientName, street, street2, city, state, country, zip, phone);
  }

  @Override
  public String toString() {

    return "class ShippingDetails {\n"
        + "    shipMethod: " + toIndentedString(shipMethod) + "\n"
        + "    recipientName: " + toIndentedString(recipientName) + "\n"
        + "    street: " + toIndentedString(street) + "\n"
        + "    street2: " + toIndentedString(street2) + "\n"
        + "    city: " + toIndentedString(city) + "\n"
        + "    state: " + toIndentedString(state) + "\n"
        + "    country: " + toIndentedString(country) + "\n"
        + "    zip: " + toIndentedString(zip) + "\n"
        + "    phone: " + toIndentedString(phone) + "\n"
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
   * Shipping details for the transaction builder static inner class.
   */
  public static final class Builder {
    private ShipMethod shipMethod;
    private String recipientName;
    private String street;
    private String street2;
    private String city;
    private String state;
    private String country;
    private String zip;
    private String phone;

    private Builder() {
    }

    /**
     * Sets the shipMethod and returns a reference to this Builder enabling method chaining.
     *
     * @param shipMethod the shipMethod to set
     * @return a reference to this Builder
     */
    public Builder shipMethod(ShipMethod shipMethod) {
      this.shipMethod = shipMethod;
      return this;
    }

    /**
     * Name of the recipient
     * <p>
     * Sets the recipientName and returns a reference to this Builder enabling method chaining.
     *
     * @param recipientName the recipientName to set
     * @return a reference to this Builder
     */
    public Builder recipientName(String recipientName) {
      this.recipientName = recipientName;
      return this;
    }

    /**
     * Street address
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
     * Additional street address information
     * <p>
     * Sets the street2 and returns a reference to this Builder enabling method chaining.
     *
     * @param street2 the street2 to set
     * @return a reference to this Builder
     */
    public Builder street2(String street2) {
      this.street2 = street2;
      return this;
    }

    /**
     * City
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
     * State or province
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
     * Two-letter ISO country code
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
     * Postal code
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
     * Phone number
     * <p>
     * Sets the phone and returns a reference to this Builder enabling method chaining.
     *
     * @param phone the phone to set
     * @return a reference to this Builder
     */
    public Builder phone(String phone) {
      this.phone = phone;
      return this;
    }

    /**
     * Returns a ShippingDetails built from the parameters previously set.
     *
     * @return a ShippingDetails built with parameters of this ShippingDetails.Builder
     */
    public ShippingDetails build() {
      return new ShippingDetails(this);
    }
  }
}
