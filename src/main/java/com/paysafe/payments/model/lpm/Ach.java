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
import com.paysafe.payments.model.lpm.enums.AchPayMethod;
import com.paysafe.payments.model.lpm.enums.BankAccountType;



/**
 * Details of the ach account to be used for the transaction.
 */
public class Ach {

  @JsonProperty("accountHolderName")
  private String accountHolderName;
  @JsonProperty("payMethod")
  private AchPayMethod payMethod;
  @JsonProperty("accountType")
  private BankAccountType accountType;
  @JsonProperty("accountNumber")
  private String accountNumber;
  @JsonProperty("routingNumber")
  private String routingNumber;
  @JsonProperty("lastDigits")
  private String lastDigits;

  public Ach() {
    super();
  }

  private Ach(final Builder builder) {
    setAccountHolderName(builder.accountHolderName);
    setPayMethod(builder.payMethod);
    setAccountType(builder.accountType);
    setAccountNumber(builder.accountNumber);
    setRoutingNumber(builder.routingNumber);
    setLastDigits(builder.lastDigits);
  }

  public static Builder builder() {
    return new Builder();
  }


  public Ach accountHolderName(String accountHolderName) {
    this.accountHolderName = accountHolderName;
    return this;
  }

  /**
   * This is the name of the customer or company.
   *
   * @return accountHolderName
   */
  public String getAccountHolderName() {
    return accountHolderName;
  }

  public void setAccountHolderName(String accountHolderName) {
    this.accountHolderName = accountHolderName;
  }


  public Ach payMethod(AchPayMethod payMethod) {
    this.payMethod = payMethod;
    return this;
  }

  /**
   * Get payMethod
   *
   * @return payMethod
   */
  public AchPayMethod getPayMethod() {
    return payMethod;
  }

  public void setPayMethod(AchPayMethod payMethod) {
    this.payMethod = payMethod;
  }


  public Ach accountType(BankAccountType accountType) {
    this.accountType = accountType;
    return this;
  }

  /**
   * Get accountType
   *
   * @return accountType
   */
  public BankAccountType getAccountType() {
    return accountType;
  }

  public void setAccountType(BankAccountType accountType) {
    this.accountType = accountType;
  }


  public Ach accountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
    return this;
  }

  /**
   * This is the bank account number.
   *
   * @return accountNumber
   */
  public String getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
  }


  public Ach routingNumber(String routingNumber) {
    this.routingNumber = routingNumber;
    return this;
  }

  /**
   * For USD accounts, this is the 9-digit routing number of the bank.
   *
   * @return routingNumber
   */
  public String getRoutingNumber() {
    return routingNumber;
  }

  public void setRoutingNumber(String routingNumber) {
    this.routingNumber = routingNumber;
  }


  public Ach lastDigits(String lastDigits) {
    this.lastDigits = lastDigits;
    return this;
  }

  /**
   * This is returned in response. It contains only last 2 digits of bank account.
   *
   * @return lastDigits
   */
  public String getLastDigits() {
    return lastDigits;
  }

  public void setLastDigits(String lastDigits) {
    this.lastDigits = lastDigits;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Ach ach = (Ach) o;
    return Objects.equals(this.accountHolderName, ach.accountHolderName) &&
        Objects.equals(this.payMethod, ach.payMethod) &&
        Objects.equals(this.accountType, ach.accountType) &&
        Objects.equals(this.accountNumber, ach.accountNumber) &&
        Objects.equals(this.routingNumber, ach.routingNumber) &&
        Objects.equals(this.lastDigits, ach.lastDigits);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountHolderName, payMethod, accountType, accountNumber, routingNumber, lastDigits);
  }

  @Override
  public String toString() {

    return "class Ach {\n"
        + "    accountHolderName: " + toIndentedString(accountHolderName) + "\n"
        + "    payMethod: " + toIndentedString(payMethod) + "\n"
        + "    accountType: " + toIndentedString(accountType) + "\n"
        + "    accountNumber: " + toIndentedString(accountNumber) + "\n"
        + "    routingNumber: " + toIndentedString(routingNumber) + "\n"
        + "    lastDigits: " + toIndentedString(lastDigits) + "\n"
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
   * Details of the ach account to be used for the transaction. builder static inner class.
   */
  public static final class Builder {
    private String accountHolderName;
    private AchPayMethod payMethod;
    private BankAccountType accountType;
    private String accountNumber;
    private String routingNumber;
    private String lastDigits;

    private Builder() {
    }

    /**
     * This is the name of the customer or company.
     * <p>
     * Sets the accountHolderName and returns a reference to this Builder enabling method chaining.
     *
     * @param accountHolderName the accountHolderName to set
     * @return a reference to this Builder
     */
    public Builder accountHolderName(String accountHolderName) {
      this.accountHolderName = accountHolderName;
      return this;
    }

    /**
     * Sets the payMethod and returns a reference to this Builder enabling method chaining.
     *
     * @param payMethod the payMethod to set
     * @return a reference to this Builder
     */
    public Builder payMethod(AchPayMethod payMethod) {
      this.payMethod = payMethod;
      return this;
    }

    /**
     * Sets the accountType and returns a reference to this Builder enabling method chaining.
     *
     * @param accountType the accountType to set
     * @return a reference to this Builder
     */
    public Builder accountType(BankAccountType accountType) {
      this.accountType = accountType;
      return this;
    }

    /**
     * This is the bank account number.
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
     * For USD accounts, this is the 9-digit routing number of the bank.
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
     * This is returned in response. It contains only last 2 digits of bank account.
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
     * Returns a Ach built from the parameters previously set.
     *
     * @return a Ach built with parameters of this Ach.Builder
     */
    public Ach build() {
      return new Ach(this);
    }
  }
}
