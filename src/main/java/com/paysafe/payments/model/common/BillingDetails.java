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
import com.paysafe.payments.model.customer.Address;
import com.paysafe.payments.model.customer.Customer;



/**
 * Customer's billing details. You must send billingDetails if AVS (Address verification) is enabled. In 3DS flow, it is recommended to send billingDetails to improve acceptance rate.
 */
public class BillingDetails {

  @JsonProperty("nickName")
  private String nickName;
  @JsonProperty("street")
  private String street;
  @JsonProperty("street1")
  private String street1;
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

  public BillingDetails() {
    super();
  }

  private BillingDetails(final Builder builder) {
    setNickName(builder.nickName);
    setStreet(builder.street);
    setStreet1(builder.street1);
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


  public BillingDetails nickName(String nickName) {
    this.nickName = nickName;
    return this;
  }

  /**
   * This is the nickname the merchant has for the billing address.
   *
   * @return nickName
   */
  public String getNickName() {
    return nickName;
  }

  public void setNickName(String nickName) {
    this.nickName = nickName;
  }


  public BillingDetails street(String street) {
    this.street = street;
    return this;
  }

  /**
   * This is the first line of the customer's street address.
   *
   * @return street
   */
  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }


  public BillingDetails street1(String street1) {
    this.street1 = street1;
    return this;
  }

  /**
   * This is the first line of the street address.
   *
   * @return street1
   */
  public String getStreet1() {
    return street1;
  }

  public void setStreet1(String street1) {
    this.street1 = street1;
  }


  public BillingDetails street2(String street2) {
    this.street2 = street2;
    return this;
  }

  /**
   * This is the second line of the street address, if required (e.g., apartment number).
   *
   * @return street2
   */
  public String getStreet2() {
    return street2;
  }

  public void setStreet2(String street2) {
    this.street2 = street2;
  }


  public BillingDetails city(String city) {
    this.city = city;
    return this;
  }

  /**
   * The city of the billing address.
   *
   * @return city
   */
  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }


  public BillingDetails state(String state) {
    this.state = state;
    return this;
  }

  /**
   * The state or province of the billing address. - For Canada see [Province Codes](https://developer.paysafe.com/en/support/reference-information/codes/#province-codes) - For the United States see [State Code](https://developer.paysafe.com/en/support/reference-information/codes/#state-codes)
   *
   * @return state
   */
  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }


  public BillingDetails country(String country) {
    this.country = country;
    return this;
  }

  /**
   * The country of the billing address, in ISO 3166-1 alpha-2 format. See See [Country Codes](https://developer.paysafe.com/en/support/reference-information/codes/#country-codes).
   *
   * @return country
   */
  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }


  public BillingDetails zip(String zip) {
    this.zip = zip;
    return this;
  }

  /**
   * The zip or postal code of the billing address
   *
   * @return zip
   */
  public String getZip() {
    return zip;
  }

  public void setZip(String zip) {
    this.zip = zip;
  }


  public BillingDetails phone(String phone) {
    this.phone = phone;
    return this;
  }

  /**
   * The phone number associated with the billing address
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
    BillingDetails billingDetails = (BillingDetails) o;
    return Objects.equals(this.nickName, billingDetails.nickName) &&
        Objects.equals(this.street, billingDetails.street) &&
        Objects.equals(this.street1, billingDetails.street1) &&
        Objects.equals(this.street2, billingDetails.street2) &&
        Objects.equals(this.city, billingDetails.city) &&
        Objects.equals(this.state, billingDetails.state) &&
        Objects.equals(this.country, billingDetails.country) &&
        Objects.equals(this.zip, billingDetails.zip) &&
        Objects.equals(this.phone, billingDetails.phone);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nickName, street, street1, street2, city, state, country, zip, phone);
  }

  @Override
  public String toString() {

    return "class BillingDetails {\n"
        + "    nickName: " + toIndentedString(nickName) + "\n"
        + "    street: " + toIndentedString(street) + "\n"
        + "    street1: " + toIndentedString(street1) + "\n"
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
   * Customer's billing details. You must send billingDetails if AVS (Address verification) is enabled. In 3DS flow, it is recommended to send billingDetails to improve acceptance rate. builder static inner class.
   */
  public static final class Builder {
    private String nickName;
    private String street;
    private String street1;
    private String street2;
    private String city;
    private String state;
    private String country;
    private String zip;
    private String phone;

    private Builder() {
    }

    /**
     * This is the nickname the merchant has for the billing address.
     * <p>
     * Sets the nickName and returns a reference to this Builder enabling method chaining.
     *
     * @param nickName the nickName to set
     * @return a reference to this Builder
     */
    public Builder nickName(String nickName) {
      this.nickName = nickName;
      return this;
    }

    /**
     * This is the first line of the customer's street address.
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
     * This is the first line of the street address.
     * <p>
     * Sets the street1 and returns a reference to this Builder enabling method chaining.
     *
     * @param street1 the street1 to set
     * @return a reference to this Builder
     */
    public Builder street1(String street1) {
      this.street1 = street1;
      return this;
    }

    /**
     * This is the second line of the street address, if required (e.g., apartment number).
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
     * The city of the billing address.
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
     * The state or province of the billing address. - For Canada see [Province Codes](https://developer.paysafe.com/en/support/reference-information/codes/#province-codes) - For the United States see [State Code](https://developer.paysafe.com/en/support/reference-information/codes/#state-codes)
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
     * The country of the billing address, in ISO 3166-1 alpha-2 format. See See [Country Codes](https://developer.paysafe.com/en/support/reference-information/codes/#country-codes).
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
     * The zip or postal code of the billing address
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
     * The phone number associated with the billing address
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
     * Returns a BillingDetails built from the parameters previously set.
     *
     * @return a BillingDetails built with parameters of this BillingDetails.Builder
     */
    public BillingDetails build() {
      return new BillingDetails(this);
    }
  }
}
