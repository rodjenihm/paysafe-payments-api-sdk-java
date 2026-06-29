// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.model.customer.singleusecustomertoken;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.paysafe.payments.model.common.profile.DateOfBirth;
import com.paysafe.payments.model.customer.Address;
import com.paysafe.payments.model.customer.CustomerPaymentHandle;
import com.paysafe.payments.model.customer.enums.Locale;
import com.paysafe.payments.model.customer.enums.SingleUseCustomerTokenStatus;
import com.paysafe.payments.model.customer.enums.SingleUseTokenPaymentType;
import com.paysafe.payments.model.payment.Payment;



/**
 * SingleUseCustomerToken
 */
public class SingleUseCustomerToken {

  @JsonProperty("merchantRefNum")
  private String merchantRefNum;
  @JsonProperty("paymentType")
  private List<SingleUseTokenPaymentType> paymentType;
  @JsonProperty("id")
  private String id;
  @JsonProperty("timeToLiveSeconds")
  private Integer timeToLiveSeconds;
  @JsonProperty("status")
  private SingleUseCustomerTokenStatus status;
  @JsonProperty("singleUseCustomerToken")
  private String singleUseCustomerToken;
  @JsonProperty("locale")
  private Locale locale;
  @JsonProperty("firstName")
  private String firstName;
  @JsonProperty("middleName")
  private String middleName;
  @JsonProperty("lastname")
  private String lastname;
  @JsonProperty("dateOfBirth")
  private DateOfBirth dateOfBirth;
  @JsonProperty("email")
  private String email;
  @JsonProperty("phone")
  private String phone;
  @JsonProperty("ip")
  private String ip;
  @JsonProperty("nationality")
  private String nationality;
  @JsonProperty("addresses")
  private List<Address> addresses;
  @JsonProperty("paymentHandles")
  private List<CustomerPaymentHandle> paymentHandles;
  @JsonProperty("customerId")
  private String customerId;

  public SingleUseCustomerToken() {
    super();
  }

  private SingleUseCustomerToken(final Builder builder) {
    setMerchantRefNum(builder.merchantRefNum);
    setPaymentType(builder.paymentType);
    setId(builder.id);
    setTimeToLiveSeconds(builder.timeToLiveSeconds);
    setStatus(builder.status);
    setSingleUseCustomerToken(builder.singleUseCustomerToken);
    setLocale(builder.locale);
    setFirstName(builder.firstName);
    setMiddleName(builder.middleName);
    setLastname(builder.lastname);
    setDateOfBirth(builder.dateOfBirth);
    setEmail(builder.email);
    setPhone(builder.phone);
    setIp(builder.ip);
    setNationality(builder.nationality);
    setAddresses(builder.addresses);
    setPaymentHandles(builder.paymentHandles);
    setCustomerId(builder.customerId);
  }

  public static Builder builder() {
    return new Builder();
  }


  public SingleUseCustomerToken merchantRefNum(String merchantRefNum) {
    this.merchantRefNum = merchantRefNum;
    return this;
  }

  /**
   * This is the merchant reference number created by the merchant and submitted as part of the request. It must be unique for each request.
   *
   * @return merchantRefNum
   */
  public String getMerchantRefNum() {
    return merchantRefNum;
  }

  public void setMerchantRefNum(String merchantRefNum) {
    this.merchantRefNum = merchantRefNum;
  }


  public SingleUseCustomerToken paymentType(List<SingleUseTokenPaymentType> paymentType) {
    this.paymentType = paymentType;
    return this;
  }

  public SingleUseCustomerToken addPaymentTypeItem(SingleUseTokenPaymentType paymentTypeItem) {
    if (this.paymentType == null) {
      this.paymentType = new ArrayList<>();
    }
    this.paymentType.add(paymentTypeItem);
    return this;
  }

  public SingleUseCustomerToken removePaymentTypeItem(SingleUseTokenPaymentType paymentTypeItem) {
    if (paymentTypeItem != null && this.paymentType != null) {
      this.paymentType.remove(paymentTypeItem);
    }

    return this;
  }

  /**
   * This specifies the payment type for which you are creating the single-use token.
   *
   * @return paymentType
   */
  public List<SingleUseTokenPaymentType> getPaymentType() {
    return paymentType;
  }

  public void setPaymentType(List<SingleUseTokenPaymentType> paymentType) {
    this.paymentType = paymentType;
  }


  public SingleUseCustomerToken id(String id) {
    this.id = id;
    return this;
  }

  /**
   * This is the ID returned in the response. This ID can be used for future associated requests, e.g., to look up the Payment Handle.
   *
   * @return id
   */
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public SingleUseCustomerToken timeToLiveSeconds(Integer timeToLiveSeconds) {
    this.timeToLiveSeconds = timeToLiveSeconds;
    return this;
  }

  /**
   * This is the period of time, in seconds, the singleUseCustomerToken is valid before expiration.
   *
   * @return timeToLiveSeconds
   */
  public Integer getTimeToLiveSeconds() {
    return timeToLiveSeconds;
  }

  public void setTimeToLiveSeconds(Integer timeToLiveSeconds) {
    this.timeToLiveSeconds = timeToLiveSeconds;
  }


  public SingleUseCustomerToken status(SingleUseCustomerTokenStatus status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   *
   * @return status
   */
  public SingleUseCustomerTokenStatus getStatus() {
    return status;
  }

  public void setStatus(SingleUseCustomerTokenStatus status) {
    this.status = status;
  }


  public SingleUseCustomerToken singleUseCustomerToken(String singleUseCustomerToken) {
    this.singleUseCustomerToken = singleUseCustomerToken;
    return this;
  }

  /**
   * This token can be used in the Payments Checkout to populate the checkout with customer information.
   *
   * @return singleUseCustomerToken
   */
  public String getSingleUseCustomerToken() {
    return singleUseCustomerToken;
  }

  public void setSingleUseCustomerToken(String singleUseCustomerToken) {
    this.singleUseCustomerToken = singleUseCustomerToken;
  }


  public SingleUseCustomerToken locale(Locale locale) {
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


  public SingleUseCustomerToken firstName(String firstName) {
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


  public SingleUseCustomerToken middleName(String middleName) {
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


  public SingleUseCustomerToken lastname(String lastname) {
    this.lastname = lastname;
    return this;
  }

  /**
   * This is the customer's last name
   *
   * @return lastname
   */
  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }


  public SingleUseCustomerToken dateOfBirth(DateOfBirth dateOfBirth) {
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


  public SingleUseCustomerToken email(String email) {
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


  public SingleUseCustomerToken phone(String phone) {
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


  public SingleUseCustomerToken ip(String ip) {
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


  public SingleUseCustomerToken nationality(String nationality) {
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


  public SingleUseCustomerToken addresses(List<Address> addresses) {
    this.addresses = addresses;
    return this;
  }

  public SingleUseCustomerToken addAddressesItem(Address addressesItem) {
    if (this.addresses == null) {
      this.addresses = new ArrayList<>();
    }
    this.addresses.add(addressesItem);
    return this;
  }

  public SingleUseCustomerToken removeAddressesItem(Address addressesItem) {
    if (addressesItem != null && this.addresses != null) {
      this.addresses.remove(addressesItem);
    }

    return this;
  }

  /**
   * This is an array of addresses associated with the customer
   *
   * @return addresses
   */
  public List<Address> getAddresses() {
    return addresses;
  }

  public void setAddresses(List<Address> addresses) {
    this.addresses = addresses;
  }


  public SingleUseCustomerToken paymentHandles(List<CustomerPaymentHandle> paymentHandles) {
    this.paymentHandles = paymentHandles;
    return this;
  }

  public SingleUseCustomerToken addPaymentHandlesItem(CustomerPaymentHandle paymentHandlesItem) {
    if (this.paymentHandles == null) {
      this.paymentHandles = new ArrayList<>();
    }
    this.paymentHandles.add(paymentHandlesItem);
    return this;
  }

  public SingleUseCustomerToken removePaymentHandlesItem(CustomerPaymentHandle paymentHandlesItem) {
    if (paymentHandlesItem != null && this.paymentHandles != null) {
      this.paymentHandles.remove(paymentHandlesItem);
    }

    return this;
  }

  /**
   * This is an array of payment handles associated with the customer
   *
   * @return paymentHandles
   */
  public List<CustomerPaymentHandle> getPaymentHandles() {
    return paymentHandles;
  }

  public void setPaymentHandles(List<CustomerPaymentHandle> paymentHandles) {
    this.paymentHandles = paymentHandles;
  }


  public SingleUseCustomerToken customerId(String customerId) {
    this.customerId = customerId;
    return this;
  }

  /**
   * This is the ID of the customer profile used for this request.
   *
   * @return customerId
   */
  public String getCustomerId() {
    return customerId;
  }

  public void setCustomerId(String customerId) {
    this.customerId = customerId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SingleUseCustomerToken singleUseCustomerToken = (SingleUseCustomerToken) o;
    return Objects.equals(this.merchantRefNum, singleUseCustomerToken.merchantRefNum) &&
        Objects.equals(this.paymentType, singleUseCustomerToken.paymentType) &&
        Objects.equals(this.id, singleUseCustomerToken.id) &&
        Objects.equals(this.timeToLiveSeconds, singleUseCustomerToken.timeToLiveSeconds) &&
        Objects.equals(this.status, singleUseCustomerToken.status) &&
        Objects.equals(this.singleUseCustomerToken, singleUseCustomerToken.singleUseCustomerToken) &&
        Objects.equals(this.locale, singleUseCustomerToken.locale) &&
        Objects.equals(this.firstName, singleUseCustomerToken.firstName) &&
        Objects.equals(this.middleName, singleUseCustomerToken.middleName) &&
        Objects.equals(this.lastname, singleUseCustomerToken.lastname) &&
        Objects.equals(this.dateOfBirth, singleUseCustomerToken.dateOfBirth) &&
        Objects.equals(this.email, singleUseCustomerToken.email) &&
        Objects.equals(this.phone, singleUseCustomerToken.phone) &&
        Objects.equals(this.ip, singleUseCustomerToken.ip) &&
        Objects.equals(this.nationality, singleUseCustomerToken.nationality) &&
        Objects.equals(this.addresses, singleUseCustomerToken.addresses) &&
        Objects.equals(this.paymentHandles, singleUseCustomerToken.paymentHandles) &&
        Objects.equals(this.customerId, singleUseCustomerToken.customerId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(merchantRefNum, paymentType, id, timeToLiveSeconds, status, singleUseCustomerToken, locale, firstName, middleName, lastname, dateOfBirth, email, phone, ip, nationality, addresses, paymentHandles, customerId);
  }

  @Override
  public String toString() {

    return "class SingleUseCustomerToken {\n"
        + "    merchantRefNum: " + toIndentedString(merchantRefNum) + "\n"
        + "    paymentType: " + toIndentedString(paymentType) + "\n"
        + "    id: " + toIndentedString(id) + "\n"
        + "    timeToLiveSeconds: " + toIndentedString(timeToLiveSeconds) + "\n"
        + "    status: " + toIndentedString(status) + "\n"
        + "    singleUseCustomerToken: " + toIndentedString(singleUseCustomerToken) + "\n"
        + "    locale: " + toIndentedString(locale) + "\n"
        + "    firstName: " + toIndentedString(firstName) + "\n"
        + "    middleName: " + toIndentedString(middleName) + "\n"
        + "    lastname: " + toIndentedString(lastname) + "\n"
        + "    dateOfBirth: " + toIndentedString(dateOfBirth) + "\n"
        + "    email: " + toIndentedString(email) + "\n"
        + "    phone: " + toIndentedString(phone) + "\n"
        + "    ip: " + toIndentedString(ip) + "\n"
        + "    nationality: " + toIndentedString(nationality) + "\n"
        + "    addresses: " + toIndentedString(addresses) + "\n"
        + "    paymentHandles: " + toIndentedString(paymentHandles) + "\n"
        + "    customerId: " + toIndentedString(customerId) + "\n"
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
   * SingleUseCustomerToken builder static inner class.
   */
  public static final class Builder {
    private String merchantRefNum;
    private List<SingleUseTokenPaymentType> paymentType;
    private String id;
    private Integer timeToLiveSeconds;
    private SingleUseCustomerTokenStatus status;
    private String singleUseCustomerToken;
    private Locale locale;
    private String firstName;
    private String middleName;
    private String lastname;
    private DateOfBirth dateOfBirth;
    private String email;
    private String phone;
    private String ip;
    private String nationality;
    private List<Address> addresses;
    private List<CustomerPaymentHandle> paymentHandles;
    private String customerId;

    private Builder() {
    }

    /**
     * This is the merchant reference number created by the merchant and submitted as part of the request. It must be unique for each request.
     * <p>
     * Sets the merchantRefNum and returns a reference to this Builder enabling method chaining.
     *
     * @param merchantRefNum the merchantRefNum to set
     * @return a reference to this Builder
     */
    public Builder merchantRefNum(String merchantRefNum) {
      this.merchantRefNum = merchantRefNum;
      return this;
    }

    /**
     * This specifies the payment type for which you are creating the single-use token.
     * <p>
     * Sets the paymentType and returns a reference to this Builder enabling method chaining.
     *
     * @param paymentType the paymentType to set
     * @return a reference to this Builder
     */
    public Builder paymentType(List<SingleUseTokenPaymentType> paymentType) {
      this.paymentType = paymentType;
      return this;
    }

    /**
     * This is the ID returned in the response. This ID can be used for future associated requests, e.g., to look up the Payment Handle.
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
     * This is the period of time, in seconds, the singleUseCustomerToken is valid before expiration.
     * <p>
     * Sets the timeToLiveSeconds and returns a reference to this Builder enabling method chaining.
     *
     * @param timeToLiveSeconds the timeToLiveSeconds to set
     * @return a reference to this Builder
     */
    public Builder timeToLiveSeconds(Integer timeToLiveSeconds) {
      this.timeToLiveSeconds = timeToLiveSeconds;
      return this;
    }

    /**
     * Sets the status and returns a reference to this Builder enabling method chaining.
     *
     * @param status the status to set
     * @return a reference to this Builder
     */
    public Builder status(SingleUseCustomerTokenStatus status) {
      this.status = status;
      return this;
    }

    /**
     * This token can be used in the Payments Checkout to populate the checkout with customer information.
     * <p>
     * Sets the singleUseCustomerToken and returns a reference to this Builder enabling method chaining.
     *
     * @param singleUseCustomerToken the singleUseCustomerToken to set
     * @return a reference to this Builder
     */
    public Builder singleUseCustomerToken(String singleUseCustomerToken) {
      this.singleUseCustomerToken = singleUseCustomerToken;
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
     * Sets the lastname and returns a reference to this Builder enabling method chaining.
     *
     * @param lastname the lastname to set
     * @return a reference to this Builder
     */
    public Builder lastname(String lastname) {
      this.lastname = lastname;
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
     * This is an array of addresses associated with the customer
     * <p>
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
     * This is an array of payment handles associated with the customer
     * <p>
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
     * This is the ID of the customer profile used for this request.
     * <p>
     * Sets the customerId and returns a reference to this Builder enabling method chaining.
     *
     * @param customerId the customerId to set
     * @return a reference to this Builder
     */
    public Builder customerId(String customerId) {
      this.customerId = customerId;
      return this;
    }

    /**
     * Returns a SingleUseCustomerToken built from the parameters previously set.
     *
     * @return a SingleUseCustomerToken built with parameters of this SingleUseCustomerToken.Builder
     */
    public SingleUseCustomerToken build() {
      return new SingleUseCustomerToken(this);
    }
  }
}
