// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.model.customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.paysafe.payments.model.customer.enums.AddressStatus;



/**
 * These are the address details associated with the customer
 */
public class Address {

  @JsonProperty("id")
  private String id;
  @JsonProperty("status")
  private AddressStatus status;
  @JsonProperty("nickName")
  private String nickName;
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
  @JsonProperty("defaultShippingAddressIndicator")
  private Boolean defaultShippingAddressIndicator;
  private Map<String, Object> additionalParameters;

  public Address() {
    super();
  }

  private Address(final Builder builder) {
    setId(builder.id);
    setStatus(builder.status);
    setNickName(builder.nickName);
    setStreet(builder.street);
    setStreet2(builder.street2);
    setCity(builder.city);
    setState(builder.state);
    setCountry(builder.country);
    setZip(builder.zip);
    setPhone(builder.phone);
    setDefaultShippingAddressIndicator(builder.defaultShippingAddressIndicator);
    this.additionalParameters = builder.additionalParameters;
  }

  public static Builder builder() {
    return new Builder();
  }


  public Address id(String id) {
    this.id = id;
    return this;
  }

  /**
   * This is the ID of request, returned in the response.
   *
   * @return id
   */
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public Address status(AddressStatus status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   *
   * @return status
   */
  public AddressStatus getStatus() {
    return status;
  }

  public void setStatus(AddressStatus status) {
    this.status = status;
  }


  public Address nickName(String nickName) {
    this.nickName = nickName;
    return this;
  }

  /**
   * This is an alias defined by the customer for this address (e.g., \"home address\").
   *
   * @return nickName
   */
  public String getNickName() {
    return nickName;
  }

  public void setNickName(String nickName) {
    this.nickName = nickName;
  }


  public Address street(String street) {
    this.street = street;
    return this;
  }

  /**
   * This is the first line of the customer's street address. **Note:** This is required only when the address is to be used in association with a bank account.
   *
   * @return street
   */
  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }


  public Address street2(String street2) {
    this.street2 = street2;
    return this;
  }

  /**
   * This is the second line of the customer's street address, if required.
   *
   * @return street2
   */
  public String getStreet2() {
    return street2;
  }

  public void setStreet2(String street2) {
    this.street2 = street2;
  }


  public Address city(String city) {
    this.city = city;
    return this;
  }

  /**
   * This is the city where the address is located.   **Note:** This is required only when the address is to be used in association with a bank account.
   *
   * @return city
   */
  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }


  public Address state(String state) {
    this.state = state;
    return this;
  }

  /**
   * This is the state/province/region in which the customer lives. See [Province Codes](https://developer.paysafe.com/en/support/reference-information/codes/#province-codes) or [State Codes](https://developer.paysafe.com/en/support/reference-information/codes/#state-codes) for Canada or the United States. Other countries have no restrictions.
   *
   * @return state
   */
  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }


  public Address country(String country) {
    this.country = country;
    return this;
  }

  /**
   * This is the country where the address is located. See [Country codes](https://developer.paysafe.com/en/support/reference-information/codes/#country-codes)
   *
   * @return country
   */
  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }


  public Address zip(String zip) {
    this.zip = zip;
    return this;
  }

  /**
   * This is the zip, postal, or post code of the customer's address.
   *
   * @return zip
   */
  public String getZip() {
    return zip;
  }

  public void setZip(String zip) {
    this.zip = zip;
  }


  public Address phone(String phone) {
    this.phone = phone;
    return this;
  }

  /**
   * This is the customer's phone number
   *
   * @return phone
   */
  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }


  public Address defaultShippingAddressIndicator(Boolean defaultShippingAddressIndicator) {
    this.defaultShippingAddressIndicator = defaultShippingAddressIndicator;
    return this;
  }

  /**
   * Flag to mark this address as the default shipping address
   *
   * @return defaultShippingAddressIndicator
   */
  public Boolean getDefaultShippingAddressIndicator() {
    return defaultShippingAddressIndicator;
  }

  public void setDefaultShippingAddressIndicator(Boolean defaultShippingAddressIndicator) {
    this.defaultShippingAddressIndicator = defaultShippingAddressIndicator;
  }

  /**
   * This map holds additional parameters that can be used for features not available in this client library.
   * During serialization, each key-value pair is treated as if the key were a top-level field in the serialized object,
   * e.g. <code>{"merchantRefNum" : "uuid", "additionalParameter1" : 100, "additionalParameter2" : "string" }</code> .
   *
   * @return additionalParameters
   */
  @JsonAnyGetter
  public Map<String, Object> getAdditionalParameters() {
    return this.additionalParameters;
  }

  public void setAdditionalParameters(Map<String, Object> additionalParameters) {
    this.additionalParameters = additionalParameters;
  }

  public void addAdditionalParameter(String key, Object value) {
    if (this.additionalParameters == null) {
      this.additionalParameters = new HashMap<>();
    }
    this.additionalParameters.put(key, value);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Address address = (Address) o;
    return Objects.equals(this.id, address.id) &&
        Objects.equals(this.status, address.status) &&
        Objects.equals(this.nickName, address.nickName) &&
        Objects.equals(this.street, address.street) &&
        Objects.equals(this.street2, address.street2) &&
        Objects.equals(this.city, address.city) &&
        Objects.equals(this.state, address.state) &&
        Objects.equals(this.country, address.country) &&
        Objects.equals(this.zip, address.zip) &&
        Objects.equals(this.phone, address.phone) &&
        Objects.equals(this.defaultShippingAddressIndicator, address.defaultShippingAddressIndicator);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, status, nickName, street, street2, city, state, country, zip, phone, defaultShippingAddressIndicator);
  }

  @Override
  public String toString() {

    return "class Address {\n"
        + "    id: " + toIndentedString(id) + "\n"
        + "    status: " + toIndentedString(status) + "\n"
        + "    nickName: " + toIndentedString(nickName) + "\n"
        + "    street: " + toIndentedString(street) + "\n"
        + "    street2: " + toIndentedString(street2) + "\n"
        + "    city: " + toIndentedString(city) + "\n"
        + "    state: " + toIndentedString(state) + "\n"
        + "    country: " + toIndentedString(country) + "\n"
        + "    zip: " + toIndentedString(zip) + "\n"
        + "    phone: " + toIndentedString(phone) + "\n"
        + "    defaultShippingAddressIndicator: " + toIndentedString(defaultShippingAddressIndicator) + "\n"
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
   * These are the address details associated with the customer builder static inner class.
   */
  public static final class Builder {
    private String id;
    private AddressStatus status;
    private String nickName;
    private String street;
    private String street2;
    private String city;
    private String state;
    private String country;
    private String zip;
    private String phone;
    private Boolean defaultShippingAddressIndicator;
    private Map<String, Object> additionalParameters;

    private Builder() {
    }

    /**
     * This is the ID of request, returned in the response.
     * <p>
     * Sets the id and returns a reference to this Builder enabling method chaining.
     *
     * @param id the id to set
     * @return a reference to this Builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }

    /**
     * Sets the status and returns a reference to this Builder enabling method chaining.
     *
     * @param status the status to set
     * @return a reference to this Builder
     */
    public Builder status(AddressStatus status) {
      this.status = status;
      return this;
    }

    /**
     * This is an alias defined by the customer for this address (e.g., \"home address\").
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
     * This is the first line of the customer's street address. **Note:** This is required only when the address is to be used in association with a bank account.
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
     * This is the second line of the customer's street address, if required.
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
     * This is the city where the address is located.   **Note:** This is required only when the address is to be used in association with a bank account.
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
     * This is the state/province/region in which the customer lives. See [Province Codes](https://developer.paysafe.com/en/support/reference-information/codes/#province-codes) or [State Codes](https://developer.paysafe.com/en/support/reference-information/codes/#state-codes) for Canada or the United States. Other countries have no restrictions.
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
     * This is the country where the address is located. See [Country codes](https://developer.paysafe.com/en/support/reference-information/codes/#country-codes)
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
     * This is the zip, postal, or post code of the customer's address.
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
     * This is the customer's phone number
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
     * Flag to mark this address as the default shipping address
     * <p>
     * Sets the defaultShippingAddressIndicator and returns a reference to this Builder enabling method chaining.
     *
     * @param defaultShippingAddressIndicator the defaultShippingAddressIndicator to set
     * @return a reference to this Builder
     */
    public Builder defaultShippingAddressIndicator(Boolean defaultShippingAddressIndicator) {
      this.defaultShippingAddressIndicator = defaultShippingAddressIndicator;
      return this;
    }

    /**
     * Sets the {@code additionalParameters} and returns a reference to this Builder enabling method chaining.
     *
     * @param additionalParameters the {@code additionalParameters} to set
     * @return a reference to this Builder
     */
    public Builder additionalParameters(Map<String, Object> additionalParameters) {
      this.additionalParameters = additionalParameters;
      return this;
    }

    /**
     * Inserts one key/value pair to additionalParameters and returns a reference to this Builder enabling method chaining.
     *
     * @param key the key to insert
     * @param value the value to insert
     * @return a reference to this Builder
     */
    public Builder addAdditionalParameter(String key, Object value) {
      if (this.additionalParameters == null) {
        this.additionalParameters = new HashMap<>();
      }
      this.additionalParameters.put(key, value);
      return this;
    }

    /**
     * Inserts provided key/value pairs to additionalParameters and returns a reference to this Builder enabling method chaining.
     *
     * @param additionalParameters the key/value pairs to insert
     * @return a reference to this Builder
     */
    public Builder addAllAdditionalParameters(Map<String, Object> additionalParameters) {
      if (this.additionalParameters == null) {
        this.additionalParameters = new HashMap<>();
      }
      this.additionalParameters.putAll(additionalParameters);
      return this;
    }

    /**
     * Returns a Address built from the parameters previously set.
     *
     * @return a Address built with parameters of this Address.Builder
     */
    public Address build() {
      return new Address(this);
    }
  }
}
