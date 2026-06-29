// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.model.lpm;

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
 * This are the bank details which requires in case of enrollment/payments/payouts.
 */
public class AchBankAccount {

  @JsonProperty("id")
  private String id;
  @JsonProperty("bankName")
  private String bankName;
  @JsonProperty("registrationId")
  private String registrationId;
  @JsonProperty("routingNumber")
  private String routingNumber;
  @JsonProperty("accountNumber")
  private String accountNumber;
  @JsonProperty("lastDigits")
  private String lastDigits;
  @JsonProperty("paymentToken")
  private String paymentToken;
  @JsonProperty("paymentHandleToken")
  private String paymentHandleToken;

  public AchBankAccount() {
    super();
  }

  private AchBankAccount(final Builder builder) {
    setId(builder.id);
    setBankName(builder.bankName);
    setRegistrationId(builder.registrationId);
    setRoutingNumber(builder.routingNumber);
    setAccountNumber(builder.accountNumber);
    setLastDigits(builder.lastDigits);
    setPaymentToken(builder.paymentToken);
    setPaymentHandleToken(builder.paymentHandleToken);
  }

  public static Builder builder() {
    return new Builder();
  }


  public AchBankAccount id(String id) {
    this.id = id;
    return this;
  }

  /**
   * The id of this bank resource
   *
   * @return id
   */
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public AchBankAccount bankName(String bankName) {
    this.bankName = bankName;
    return this;
  }

  /**
   * The customers bank account name
   *
   * @return bankName
   */
  public String getBankName() {
    return bankName;
  }

  public void setBankName(String bankName) {
    this.bankName = bankName;
  }


  public AchBankAccount registrationId(String registrationId) {
    this.registrationId = registrationId;
    return this;
  }

  /**
   * The corresponding registrationId associated with this bank account
   *
   * @return registrationId
   */
  public String getRegistrationId() {
    return registrationId;
  }

  public void setRegistrationId(String registrationId) {
    this.registrationId = registrationId;
  }


  public AchBankAccount routingNumber(String routingNumber) {
    this.routingNumber = routingNumber;
    return this;
  }

  /**
   * The routing number of the bank
   *
   * @return routingNumber
   */
  public String getRoutingNumber() {
    return routingNumber;
  }

  public void setRoutingNumber(String routingNumber) {
    this.routingNumber = routingNumber;
  }


  public AchBankAccount accountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
    return this;
  }

  /**
   * The customers bank account number
   *
   * @return accountNumber
   */
  public String getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
  }


  public AchBankAccount lastDigits(String lastDigits) {
    this.lastDigits = lastDigits;
    return this;
  }

  /**
   * The last digits of bank account number
   *
   * @return lastDigits
   */
  public String getLastDigits() {
    return lastDigits;
  }

  public void setLastDigits(String lastDigits) {
    this.lastDigits = lastDigits;
  }


  public AchBankAccount paymentToken(String paymentToken) {
    this.paymentToken = paymentToken;
    return this;
  }

  /**
   * The unique token associated with this bank account
   *
   * @return paymentToken
   */
  public String getPaymentToken() {
    return paymentToken;
  }

  public void setPaymentToken(String paymentToken) {
    this.paymentToken = paymentToken;
  }


  public AchBankAccount paymentHandleToken(String paymentHandleToken) {
    this.paymentHandleToken = paymentHandleToken;
    return this;
  }

  /**
   * The unique token associated with this bank account
   *
   * @return paymentHandleToken
   */
  public String getPaymentHandleToken() {
    return paymentHandleToken;
  }

  public void setPaymentHandleToken(String paymentHandleToken) {
    this.paymentHandleToken = paymentHandleToken;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AchBankAccount achBankAccount = (AchBankAccount) o;
    return Objects.equals(this.id, achBankAccount.id) &&
        Objects.equals(this.bankName, achBankAccount.bankName) &&
        Objects.equals(this.registrationId, achBankAccount.registrationId) &&
        Objects.equals(this.routingNumber, achBankAccount.routingNumber) &&
        Objects.equals(this.accountNumber, achBankAccount.accountNumber) &&
        Objects.equals(this.lastDigits, achBankAccount.lastDigits) &&
        Objects.equals(this.paymentToken, achBankAccount.paymentToken) &&
        Objects.equals(this.paymentHandleToken, achBankAccount.paymentHandleToken);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, bankName, registrationId, routingNumber, accountNumber, lastDigits, paymentToken, paymentHandleToken);
  }

  @Override
  public String toString() {

    return "class AchBankAccount {\n"
        + "    id: " + toIndentedString(id) + "\n"
        + "    bankName: " + toIndentedString(bankName) + "\n"
        + "    registrationId: " + toIndentedString(registrationId) + "\n"
        + "    routingNumber: " + toIndentedString(routingNumber) + "\n"
        + "    accountNumber: " + toIndentedString(accountNumber) + "\n"
        + "    lastDigits: " + toIndentedString(lastDigits) + "\n"
        + "    paymentToken: " + toIndentedString(paymentToken) + "\n"
        + "    paymentHandleToken: " + toIndentedString(paymentHandleToken) + "\n"
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
   * This are the bank details which requires in case of enrollment/payments/payouts. builder static inner class.
   */
  public static final class Builder {
    private String id;
    private String bankName;
    private String registrationId;
    private String routingNumber;
    private String accountNumber;
    private String lastDigits;
    private String paymentToken;
    private String paymentHandleToken;

    private Builder() {
    }

    /**
     * The id of this bank resource
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
     * The customers bank account name
     * <p>
     * Sets the bankName and returns a reference to this Builder enabling method chaining.
     *
     * @param bankName the bankName to set
     * @return a reference to this Builder
     */
    public Builder bankName(String bankName) {
      this.bankName = bankName;
      return this;
    }

    /**
     * The corresponding registrationId associated with this bank account
     * <p>
     * Sets the registrationId and returns a reference to this Builder enabling method chaining.
     *
     * @param registrationId the registrationId to set
     * @return a reference to this Builder
     */
    public Builder registrationId(String registrationId) {
      this.registrationId = registrationId;
      return this;
    }

    /**
     * The routing number of the bank
     * <p>
     * Sets the routingNumber and returns a reference to this Builder enabling method chaining.
     *
     * @param routingNumber the routingNumber to set
     * @return a reference to this Builder
     */
    public Builder routingNumber(String routingNumber) {
      this.routingNumber = routingNumber;
      return this;
    }

    /**
     * The customers bank account number
     * <p>
     * Sets the accountNumber and returns a reference to this Builder enabling method chaining.
     *
     * @param accountNumber the accountNumber to set
     * @return a reference to this Builder
     */
    public Builder accountNumber(String accountNumber) {
      this.accountNumber = accountNumber;
      return this;
    }

    /**
     * The last digits of bank account number
     * <p>
     * Sets the lastDigits and returns a reference to this Builder enabling method chaining.
     *
     * @param lastDigits the lastDigits to set
     * @return a reference to this Builder
     */
    public Builder lastDigits(String lastDigits) {
      this.lastDigits = lastDigits;
      return this;
    }

    /**
     * The unique token associated with this bank account
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
     * The unique token associated with this bank account
     * <p>
     * Sets the paymentHandleToken and returns a reference to this Builder enabling method chaining.
     *
     * @param paymentHandleToken the paymentHandleToken to set
     * @return a reference to this Builder
     */
    public Builder paymentHandleToken(String paymentHandleToken) {
      this.paymentHandleToken = paymentHandleToken;
      return this;
    }

    /**
     * Returns a AchBankAccount built from the parameters previously set.
     *
     * @return a AchBankAccount built with parameters of this AchBankAccount.Builder
     */
    public AchBankAccount build() {
      return new AchBankAccount(this);
    }
  }
}
