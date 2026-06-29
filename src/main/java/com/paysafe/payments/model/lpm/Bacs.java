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
import com.paysafe.payments.model.common.Mandate;



/**
 * Details of the bacs account to be used for the transaction.
 */
public class Bacs {

  @JsonProperty("nickName")
  private String nickName;
  @JsonProperty("accountHolderName")
  private String accountHolderName;
  @JsonProperty("accountNumber")
  private String accountNumber;
  @JsonProperty("sortCode")
  private String sortCode;
  @JsonProperty("mandate")
  private Mandate mandate;
  @JsonProperty("lastDigits")
  private String lastDigits;

  public Bacs() {
    super();
  }

  private Bacs(final Builder builder) {
    setNickName(builder.nickName);
    setAccountHolderName(builder.accountHolderName);
    setAccountNumber(builder.accountNumber);
    setSortCode(builder.sortCode);
    setMandate(builder.mandate);
    setLastDigits(builder.lastDigits);
  }

  public static Builder builder() {
    return new Builder();
  }


  public Bacs nickName(String nickName) {
    this.nickName = nickName;
    return this;
  }

  /**
   * This is an alias for this bank account.
   *
   * @return nickName
   */
  public String getNickName() {
    return nickName;
  }

  public void setNickName(String nickName) {
    this.nickName = nickName;
  }


  public Bacs accountHolderName(String accountHolderName) {
    this.accountHolderName = accountHolderName;
    return this;
  }

  /**
   * This is the name of the customer or company that owns the bank account.
   *
   * @return accountHolderName
   */
  public String getAccountHolderName() {
    return accountHolderName;
  }

  public void setAccountHolderName(String accountHolderName) {
    this.accountHolderName = accountHolderName;
  }


  public Bacs accountNumber(String accountNumber) {
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


  public Bacs sortCode(String sortCode) {
    this.sortCode = sortCode;
    return this;
  }

  /**
   * This is the 6-digit sort code that identifies the financial institution and branch of the customer's bank.
   *
   * @return sortCode
   */
  public String getSortCode() {
    return sortCode;
  }

  public void setSortCode(String sortCode) {
    this.sortCode = sortCode;
  }


  public Bacs mandate(Mandate mandate) {
    this.mandate = mandate;
    return this;
  }

  /**
   * Get mandate
   *
   * @return mandate
   */
  public Mandate getMandate() {
    return mandate;
  }

  public void setMandate(Mandate mandate) {
    this.mandate = mandate;
  }


  public Bacs lastDigits(String lastDigits) {
    this.lastDigits = lastDigits;
    return this;
  }

  /**
   * These are the last two digits of the account number.
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
    Bacs bacs = (Bacs) o;
    return Objects.equals(this.nickName, bacs.nickName) &&
        Objects.equals(this.accountHolderName, bacs.accountHolderName) &&
        Objects.equals(this.accountNumber, bacs.accountNumber) &&
        Objects.equals(this.sortCode, bacs.sortCode) &&
        Objects.equals(this.mandate, bacs.mandate) &&
        Objects.equals(this.lastDigits, bacs.lastDigits);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nickName, accountHolderName, accountNumber, sortCode, mandate, lastDigits);
  }

  @Override
  public String toString() {

    return "class Bacs {\n"
        + "    nickName: " + toIndentedString(nickName) + "\n"
        + "    accountHolderName: " + toIndentedString(accountHolderName) + "\n"
        + "    accountNumber: " + toIndentedString(accountNumber) + "\n"
        + "    sortCode: " + toIndentedString(sortCode) + "\n"
        + "    mandate: " + toIndentedString(mandate) + "\n"
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
   * Details of the bacs account to be used for the transaction. builder static inner class.
   */
  public static final class Builder {
    private String nickName;
    private String accountHolderName;
    private String accountNumber;
    private String sortCode;
    private Mandate mandate;
    private String lastDigits;

    private Builder() {
    }

    /**
     * This is an alias for this bank account.
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
     * This is the name of the customer or company that owns the bank account.
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
     * This is the 6-digit sort code that identifies the financial institution and branch of the customer's bank.
     * <p>
     * Sets the sortCode and returns a reference to this Builder enabling method chaining.
     *
     * @param sortCode the sortCode to set
     * @return a reference to this Builder
     */
    public Builder sortCode(String sortCode) {
      this.sortCode = sortCode;
      return this;
    }

    /**
     * Sets the mandate and returns a reference to this Builder enabling method chaining.
     *
     * @param mandate the mandate to set
     * @return a reference to this Builder
     */
    public Builder mandate(Mandate mandate) {
      this.mandate = mandate;
      return this;
    }

    /**
     * These are the last two digits of the account number.
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
     * Returns a Bacs built from the parameters previously set.
     *
     * @return a Bacs built with parameters of this Bacs.Builder
     */
    public Bacs build() {
      return new Bacs(this);
    }
  }
}
