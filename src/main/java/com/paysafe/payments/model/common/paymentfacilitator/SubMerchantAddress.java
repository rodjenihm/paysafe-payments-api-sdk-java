// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.model.common.paymentfacilitator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.paysafe.payments.model.payment.Payment;



/**
 * Contains information for Payment facilitator sub-merchant address.
 */
public class SubMerchantAddress {

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

  public SubMerchantAddress() {
    super();
  }

  private SubMerchantAddress(final Builder builder) {
    setStreet(builder.street);
    setCity(builder.city);
    setState(builder.state);
    setCountry(builder.country);
    setZip(builder.zip);
  }

  public static Builder builder() {
    return new Builder();
  }


  public SubMerchantAddress street(String street) {
    this.street = street;
    return this;
  }

  /**
   * Field contains the street address of the actual merchant
   *
   * @return street
   */
  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }


  public SubMerchantAddress city(String city) {
    this.city = city;
    return this;
  }

  /**
   * Field contains the city of the actual merchant
   *
   * @return city
   */
  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }


  public SubMerchantAddress state(String state) {
    this.state = state;
    return this;
  }

  /**
   * See [Province Codes](https://developer.paysafe.com/en/support/reference-information/codes/#province-codes) or [State Codes](https://developer.paysafe.com/en/support/reference-information/codes/#state-codes) for Canada or the United States. For other countries, see [ISO 3166-2](https://en.wikipedia.org/wiki/ISO_3166-2). For transactions with American Express cards, the state/province/region is mandatory.
   *
   * @return state
   */
  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }


  public SubMerchantAddress country(String country) {
    this.country = country;
    return this;
  }

  /**
   * This is the country where the address is located. See [Country Codes](https://developer.paysafe.com/en/support/reference-information/codes/#country-codes).
   *
   * @return country
   */
  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }


  public SubMerchantAddress zip(String zip) {
    this.zip = zip;
    return this;
  }

  /**
   * Field containing the postal code of the actual merchant
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
    SubMerchantAddress subMerchantAddress = (SubMerchantAddress) o;
    return Objects.equals(this.street, subMerchantAddress.street) &&
        Objects.equals(this.city, subMerchantAddress.city) &&
        Objects.equals(this.state, subMerchantAddress.state) &&
        Objects.equals(this.country, subMerchantAddress.country) &&
        Objects.equals(this.zip, subMerchantAddress.zip);
  }

  @Override
  public int hashCode() {
    return Objects.hash(street, city, state, country, zip);
  }

  @Override
  public String toString() {

    return "class SubMerchantAddress {\n"
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
   * Contains information for Payment facilitator sub-merchant address. builder static inner class.
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
     * Field contains the street address of the actual merchant
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
     * Field contains the city of the actual merchant
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
     * See [Province Codes](https://developer.paysafe.com/en/support/reference-information/codes/#province-codes) or [State Codes](https://developer.paysafe.com/en/support/reference-information/codes/#state-codes) for Canada or the United States. For other countries, see [ISO 3166-2](https://en.wikipedia.org/wiki/ISO_3166-2). For transactions with American Express cards, the state/province/region is mandatory.
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
     * This is the country where the address is located. See [Country Codes](https://developer.paysafe.com/en/support/reference-information/codes/#country-codes).
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
     * Field containing the postal code of the actual merchant
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
     * Returns a SubMerchantAddress built from the parameters previously set.
     *
     * @return a SubMerchantAddress built with parameters of this SubMerchantAddress.Builder
     */
    public SubMerchantAddress build() {
      return new SubMerchantAddress(this);
    }
  }
}
