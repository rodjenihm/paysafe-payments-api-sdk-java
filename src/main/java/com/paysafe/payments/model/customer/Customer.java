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
import com.paysafe.payments.model.BaseApiResponse;
import com.paysafe.payments.model.common.profile.DateOfBirth;
import com.paysafe.payments.model.customer.enums.CustomerGender;
import com.paysafe.payments.model.customer.enums.CustomerStatus;
import com.paysafe.payments.model.customer.enums.Locale;
import com.paysafe.payments.model.payment.Payment;



/**
 * Customer's details including saved addresses and payment handles.
 */
public class Customer extends BaseApiResponse {

  @JsonProperty("merchantCustomerId")
  private String merchantCustomerId;
  @JsonProperty("locale")
  private Locale locale;
  @JsonProperty("firstName")
  private String firstName;
  @JsonProperty("middleName")
  private String middleName;
  @JsonProperty("lastName")
  private String lastName;
  @JsonProperty("gender")
  private CustomerGender gender;
  @JsonProperty("dateOfBirth")
  private DateOfBirth dateOfBirth;
  @JsonProperty("email")
  private String email;
  @JsonProperty("phone")
  private String phone;
  @JsonProperty("cellPhone")
  private String cellPhone;
  @JsonProperty("nationality")
  private String nationality;
  @JsonProperty("ip")
  private String ip;
  @JsonProperty("paymentHandleTokenFrom")
  private String paymentHandleTokenFrom;
  @JsonProperty("id")
  private String id;
  @JsonProperty("accountId")
  private String accountId;
  @JsonProperty("status")
  private CustomerStatus status;
  @JsonProperty("paymentToken")
  private String paymentToken;
  @JsonProperty("addresses")
  private List<Address> addresses;
  @JsonProperty("paymentHandles")
  private List<CustomerPaymentHandle> paymentHandles;
  private Map<String, Object> additionalParameters;

  public Customer() {
    super();
  }

  private Customer(final Builder builder) {
    setMerchantCustomerId(builder.merchantCustomerId);
    setLocale(builder.locale);
    setFirstName(builder.firstName);
    setMiddleName(builder.middleName);
    setLastName(builder.lastName);
    setGender(builder.gender);
    setDateOfBirth(builder.dateOfBirth);
    setEmail(builder.email);
    setPhone(builder.phone);
    setCellPhone(builder.cellPhone);
    setNationality(builder.nationality);
    setIp(builder.ip);
    setPaymentHandleTokenFrom(builder.paymentHandleTokenFrom);
    setId(builder.id);
    setAccountId(builder.accountId);
    setStatus(builder.status);
    setPaymentToken(builder.paymentToken);
    setAddresses(builder.addresses);
    setPaymentHandles(builder.paymentHandles);
    this.additionalParameters = builder.additionalParameters;
  }

  public static Builder builder() {
    return new Builder();
  }


  public Customer merchantCustomerId(String merchantCustomerId) {
    this.merchantCustomerId = merchantCustomerId;
    return this;
  }

  /**
   * This is a customer ID that the merchant provides with the request for their own internal customer identification. This value must be unique for each customer belonging to a merchant.
   *
   * @return merchantCustomerId
   */
  public String getMerchantCustomerId() {
    return merchantCustomerId;
  }

  public void setMerchantCustomerId(String merchantCustomerId) {
    this.merchantCustomerId = merchantCustomerId;
  }


  public Customer locale(Locale locale) {
    this.locale = locale;
    return this;
  }

  /**
   * Get locale
   *
   * @return locale
   */
  public Locale getLocale() {
    return locale;
  }

  public void setLocale(Locale locale) {
    this.locale = locale;
  }


  public Customer firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  /**
   * This is the customer's first name
   *
   * @return firstName
   */
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }


  public Customer middleName(String middleName) {
    this.middleName = middleName;
    return this;
  }

  /**
   * This is the customer's middle name
   *
   * @return middleName
   */
  public String getMiddleName() {
    return middleName;
  }

  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }


  public Customer lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  /**
   * This is the customer's last name
   *
   * @return lastName
   */
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }


  public Customer gender(CustomerGender gender) {
    this.gender = gender;
    return this;
  }

  /**
   * Get gender
   *
   * @return gender
   */
  public CustomerGender getGender() {
    return gender;
  }

  public void setGender(CustomerGender gender) {
    this.gender = gender;
  }


  public Customer dateOfBirth(DateOfBirth dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
    return this;
  }

  /**
   * Get dateOfBirth
   *
   * @return dateOfBirth
   */
  public DateOfBirth getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(DateOfBirth dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }


  public Customer email(String email) {
    this.email = email;
    return this;
  }

  /**
   * This is the customer's email address
   *
   * @return email
   */
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  public Customer phone(String phone) {
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


  public Customer cellPhone(String cellPhone) {
    this.cellPhone = cellPhone;
    return this;
  }

  /**
   * This is the customer's cell phone number
   *
   * @return cellPhone
   */
  public String getCellPhone() {
    return cellPhone;
  }

  public void setCellPhone(String cellPhone) {
    this.cellPhone = cellPhone;
  }


  public Customer nationality(String nationality) {
    this.nationality = nationality;
    return this;
  }

  /**
   * This is the customer's nationality
   *
   * @return nationality
   */
  public String getNationality() {
    return nationality;
  }

  public void setNationality(String nationality) {
    this.nationality = nationality;
  }


  public Customer ip(String ip) {
    this.ip = ip;
    return this;
  }

  /**
   * This is the customer's IP address
   *
   * @return ip
   */
  public String getIp() {
    return ip;
  }

  public void setIp(String ip) {
    this.ip = ip;
  }


  public Customer paymentHandleTokenFrom(String paymentHandleTokenFrom) {
    this.paymentHandleTokenFrom = paymentHandleTokenFrom;
    return this;
  }

  /**
   * This is the paymentHandleToken that is present in the response to a single-use Payment Handle creation request. **Note:** It is a mandatory field only if we are trying to *Create a Customer Using a Single-Use Payment Handle Token*.
   *
   * @return paymentHandleTokenFrom
   */
  public String getPaymentHandleTokenFrom() {
    return paymentHandleTokenFrom;
  }

  public void setPaymentHandleTokenFrom(String paymentHandleTokenFrom) {
    this.paymentHandleTokenFrom = paymentHandleTokenFrom;
  }


  public Customer id(String id) {
    this.id = id;
    return this;
  }

  /**
   * This is the Customer ID at the Paysafe end.
   *
   * @return id
   */
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public Customer accountId(String accountId) {
    this.accountId = accountId;
    return this;
  }

  /**
   * Account Id in the paysafe system
   *
   * @return accountId
   */
  public String getAccountId() {
    return accountId;
  }

  public void setAccountId(String accountId) {
    this.accountId = accountId;
  }


  public Customer status(CustomerStatus status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   *
   * @return status
   */
  public CustomerStatus getStatus() {
    return status;
  }

  public void setStatus(CustomerStatus status) {
    this.status = status;
  }


  public Customer paymentToken(String paymentToken) {
    this.paymentToken = paymentToken;
    return this;
  }

  /**
   * It is the customer profile Identifier at the paysafe end.
   *
   * @return paymentToken
   */
  public String getPaymentToken() {
    return paymentToken;
  }

  public void setPaymentToken(String paymentToken) {
    this.paymentToken = paymentToken;
  }


  public Customer addresses(List<Address> addresses) {
    this.addresses = addresses;
    return this;
  }

  public Customer addAddressesItem(Address addressesItem) {
    if (this.addresses == null) {
      this.addresses = new ArrayList<>();
    }
    this.addresses.add(addressesItem);
    return this;
  }

  public Customer removeAddressesItem(Address addressesItem) {
    if (addressesItem != null && this.addresses != null) {
      this.addresses.remove(addressesItem);
    }

    return this;
  }

  /**
   * Get addresses
   *
   * @return addresses
   */
  public List<Address> getAddresses() {
    return addresses;
  }

  public void setAddresses(List<Address> addresses) {
    this.addresses = addresses;
  }


  public Customer paymentHandles(List<CustomerPaymentHandle> paymentHandles) {
    this.paymentHandles = paymentHandles;
    return this;
  }

  public Customer addPaymentHandlesItem(CustomerPaymentHandle paymentHandlesItem) {
    if (this.paymentHandles == null) {
      this.paymentHandles = new ArrayList<>();
    }
    this.paymentHandles.add(paymentHandlesItem);
    return this;
  }

  public Customer removePaymentHandlesItem(CustomerPaymentHandle paymentHandlesItem) {
    if (paymentHandlesItem != null && this.paymentHandles != null) {
      this.paymentHandles.remove(paymentHandlesItem);
    }

    return this;
  }

  /**
   * Get paymentHandles
   *
   * @return paymentHandles
   */
  public List<CustomerPaymentHandle> getPaymentHandles() {
    return paymentHandles;
  }

  public void setPaymentHandles(List<CustomerPaymentHandle> paymentHandles) {
    this.paymentHandles = paymentHandles;
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
    Customer customer = (Customer) o;
    return Objects.equals(this.merchantCustomerId, customer.merchantCustomerId) &&
        Objects.equals(this.locale, customer.locale) &&
        Objects.equals(this.firstName, customer.firstName) &&
        Objects.equals(this.middleName, customer.middleName) &&
        Objects.equals(this.lastName, customer.lastName) &&
        Objects.equals(this.gender, customer.gender) &&
        Objects.equals(this.dateOfBirth, customer.dateOfBirth) &&
        Objects.equals(this.email, customer.email) &&
        Objects.equals(this.phone, customer.phone) &&
        Objects.equals(this.cellPhone, customer.cellPhone) &&
        Objects.equals(this.nationality, customer.nationality) &&
        Objects.equals(this.ip, customer.ip) &&
        Objects.equals(this.paymentHandleTokenFrom, customer.paymentHandleTokenFrom) &&
        Objects.equals(this.id, customer.id) &&
        Objects.equals(this.accountId, customer.accountId) &&
        Objects.equals(this.status, customer.status) &&
        Objects.equals(this.paymentToken, customer.paymentToken) &&
        Objects.equals(this.addresses, customer.addresses) &&
        Objects.equals(this.paymentHandles, customer.paymentHandles);
  }

  @Override
  public int hashCode() {
    return Objects.hash(merchantCustomerId, locale, firstName, middleName, lastName, gender, dateOfBirth, email, phone, cellPhone, nationality, ip, paymentHandleTokenFrom, id, accountId, status, paymentToken, addresses, paymentHandles);
  }

  @Override
  public String toString() {

    return "class Customer {\n"
        + "    merchantCustomerId: " + toIndentedString(merchantCustomerId) + "\n"
        + "    locale: " + toIndentedString(locale) + "\n"
        + "    firstName: " + toIndentedString(firstName) + "\n"
        + "    middleName: " + toIndentedString(middleName) + "\n"
        + "    lastName: " + toIndentedString(lastName) + "\n"
        + "    gender: " + toIndentedString(gender) + "\n"
        + "    dateOfBirth: " + toIndentedString(dateOfBirth) + "\n"
        + "    email: " + toIndentedString(email) + "\n"
        + "    phone: " + toIndentedString(phone) + "\n"
        + "    cellPhone: " + toIndentedString(cellPhone) + "\n"
        + "    nationality: " + toIndentedString(nationality) + "\n"
        + "    ip: " + toIndentedString(ip) + "\n"
        + "    paymentHandleTokenFrom: " + toIndentedString(paymentHandleTokenFrom) + "\n"
        + "    id: " + toIndentedString(id) + "\n"
        + "    accountId: " + toIndentedString(accountId) + "\n"
        + "    status: " + toIndentedString(status) + "\n"
        + "    paymentToken: " + toIndentedString(paymentToken) + "\n"
        + "    addresses: " + toIndentedString(addresses) + "\n"
        + "    paymentHandles: " + toIndentedString(paymentHandles) + "\n"
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
   * Customer's details including saved addresses and payment handles. builder static inner class.
   */
  public static final class Builder {
    private String merchantCustomerId;
    private Locale locale;
    private String firstName;
    private String middleName;
    private String lastName;
    private CustomerGender gender;
    private DateOfBirth dateOfBirth;
    private String email;
    private String phone;
    private String cellPhone;
    private String nationality;
    private String ip;
    private String paymentHandleTokenFrom;
    private String id;
    private String accountId;
    private CustomerStatus status;
    private String paymentToken;
    private List<Address> addresses;
    private List<CustomerPaymentHandle> paymentHandles;
    private Map<String, Object> additionalParameters;

    private Builder() {
    }

    /**
     * This is a customer ID that the merchant provides with the request for their own internal customer identification. This value must be unique for each customer belonging to a merchant.
     * <p>
     * Sets the merchantCustomerId and returns a reference to this Builder enabling method chaining.
     *
     * @param merchantCustomerId the merchantCustomerId to set
     * @return a reference to this Builder
     */
    public Builder merchantCustomerId(String merchantCustomerId) {
      this.merchantCustomerId = merchantCustomerId;
      return this;
    }

    /**
     * Sets the locale and returns a reference to this Builder enabling method chaining.
     *
     * @param locale the locale to set
     * @return a reference to this Builder
     */
    public Builder locale(Locale locale) {
      this.locale = locale;
      return this;
    }

    /**
     * This is the customer's first name
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
     * This is the customer's middle name
     * <p>
     * Sets the middleName and returns a reference to this Builder enabling method chaining.
     *
     * @param middleName the middleName to set
     * @return a reference to this Builder
     */
    public Builder middleName(String middleName) {
      this.middleName = middleName;
      return this;
    }

    /**
     * This is the customer's last name
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
     * Sets the gender and returns a reference to this Builder enabling method chaining.
     *
     * @param gender the gender to set
     * @return a reference to this Builder
     */
    public Builder gender(CustomerGender gender) {
      this.gender = gender;
      return this;
    }

    /**
     * Sets the dateOfBirth and returns a reference to this Builder enabling method chaining.
     *
     * @param dateOfBirth the dateOfBirth to set
     * @return a reference to this Builder
     */
    public Builder dateOfBirth(DateOfBirth dateOfBirth) {
      this.dateOfBirth = dateOfBirth;
      return this;
    }

    /**
     * This is the customer's email address
     * <p>
     * Sets the email and returns a reference to this Builder enabling method chaining.
     *
     * @param email the email to set
     * @return a reference to this Builder
     */
    public Builder email(String email) {
      this.email = email;
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
     * This is the customer's cell phone number
     * <p>
     * Sets the cellPhone and returns a reference to this Builder enabling method chaining.
     *
     * @param cellPhone the cellPhone to set
     * @return a reference to this Builder
     */
    public Builder cellPhone(String cellPhone) {
      this.cellPhone = cellPhone;
      return this;
    }

    /**
     * This is the customer's nationality
     * <p>
     * Sets the nationality and returns a reference to this Builder enabling method chaining.
     *
     * @param nationality the nationality to set
     * @return a reference to this Builder
     */
    public Builder nationality(String nationality) {
      this.nationality = nationality;
      return this;
    }

    /**
     * This is the customer's IP address
     * <p>
     * Sets the ip and returns a reference to this Builder enabling method chaining.
     *
     * @param ip the ip to set
     * @return a reference to this Builder
     */
    public Builder ip(String ip) {
      this.ip = ip;
      return this;
    }

    /**
     * This is the paymentHandleToken that is present in the response to a single-use Payment Handle creation request. **Note:** It is a mandatory field only if we are trying to *Create a Customer Using a Single-Use Payment Handle Token*.
     * <p>
     * Sets the paymentHandleTokenFrom and returns a reference to this Builder enabling method chaining.
     *
     * @param paymentHandleTokenFrom the paymentHandleTokenFrom to set
     * @return a reference to this Builder
     */
    public Builder paymentHandleTokenFrom(String paymentHandleTokenFrom) {
      this.paymentHandleTokenFrom = paymentHandleTokenFrom;
      return this;
    }

    /**
     * This is the Customer ID at the Paysafe end.
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
     * Account Id in the paysafe system
     * <p>
     * Sets the accountId and returns a reference to this Builder enabling method chaining.
     *
     * @param accountId the accountId to set
     * @return a reference to this Builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Sets the status and returns a reference to this Builder enabling method chaining.
     *
     * @param status the status to set
     * @return a reference to this Builder
     */
    public Builder status(CustomerStatus status) {
      this.status = status;
      return this;
    }

    /**
     * It is the customer profile Identifier at the paysafe end.
     * <p>
     * Sets the paymentToken and returns a reference to this Builder enabling method chaining.
     *
     * @param paymentToken the paymentToken to set
     * @return a reference to this Builder
     */
    public Builder paymentToken(String paymentToken) {
      this.paymentToken = paymentToken;
      return this;
    }

    /**
     * Sets the addresses and returns a reference to this Builder enabling method chaining.
     *
     * @param addresses the addresses to set
     * @return a reference to this Builder
     */
    public Builder addresses(List<Address> addresses) {
      this.addresses = addresses;
      return this;
    }

    /**
     * Sets the paymentHandles and returns a reference to this Builder enabling method chaining.
     *
     * @param paymentHandles the paymentHandles to set
     * @return a reference to this Builder
     */
    public Builder paymentHandles(List<CustomerPaymentHandle> paymentHandles) {
      this.paymentHandles = paymentHandles;
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
     * Returns a Customer built from the parameters previously set.
     *
     * @return a Customer built with parameters of this Customer.Builder
     */
    public Customer build() {
      return new Customer(this);
    }
  }
}
