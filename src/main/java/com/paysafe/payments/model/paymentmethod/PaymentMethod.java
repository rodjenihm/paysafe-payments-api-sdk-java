// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.model.paymentmethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.paysafe.payments.model.common.enums.CurrencyCode;
import com.paysafe.payments.model.paymenthandle.enums.PaymentType;



/**
 * Represents a payment method used for processing transactions. <p> This class includes details such as the type of payment method, the currency code associated with the payment, and the account Id linked to the payment method. </p>
 */
public class PaymentMethod {

  @JsonProperty("paymentMethod")
  private PaymentType paymentMethod;
  @JsonProperty("currencyCode")
  private CurrencyCode currencyCode;
  @JsonProperty("accountId")
  private String accountId;

  public PaymentMethod() {
    super();
  }

  private PaymentMethod(final Builder builder) {
    setPaymentMethod(builder.paymentMethod);
    setCurrencyCode(builder.currencyCode);
    setAccountId(builder.accountId);
  }

  public static Builder builder() {
    return new Builder();
  }


  public PaymentMethod paymentMethod(PaymentType paymentMethod) {
    this.paymentMethod = paymentMethod;
    return this;
  }

  /**
   * Get paymentMethod
   *
   * @return paymentMethod
   */
  public PaymentType getPaymentMethod() {
    return paymentMethod;
  }

  public void setPaymentMethod(PaymentType paymentMethod) {
    this.paymentMethod = paymentMethod;
  }


  public PaymentMethod currencyCode(CurrencyCode currencyCode) {
    this.currencyCode = currencyCode;
    return this;
  }

  /**
   * Get currencyCode
   *
   * @return currencyCode
   */
  public CurrencyCode getCurrencyCode() {
    return currencyCode;
  }

  public void setCurrencyCode(CurrencyCode currencyCode) {
    this.currencyCode = currencyCode;
  }


  public PaymentMethod accountId(String accountId) {
    this.accountId = accountId;
    return this;
  }

  /**
   * Account Id in the Paysafe system
   *
   * @return accountId
   */
  public String getAccountId() {
    return accountId;
  }

  public void setAccountId(String accountId) {
    this.accountId = accountId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PaymentMethod paymentMethod = (PaymentMethod) o;
    return Objects.equals(this.paymentMethod, paymentMethod.paymentMethod) &&
        Objects.equals(this.currencyCode, paymentMethod.currencyCode) &&
        Objects.equals(this.accountId, paymentMethod.accountId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(paymentMethod, currencyCode, accountId);
  }

  @Override
  public String toString() {

    return "class PaymentMethod {\n"
        + "    paymentMethod: " + toIndentedString(paymentMethod) + "\n"
        + "    currencyCode: " + toIndentedString(currencyCode) + "\n"
        + "    accountId: " + toIndentedString(accountId) + "\n"
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
   * Represents a payment method used for processing transactions. <p> This class includes details such as the type of payment method, the currency code associated with the payment, and the account Id linked to the payment method. </p> builder static inner class.
   */
  public static final class Builder {
    private PaymentType paymentMethod;
    private CurrencyCode currencyCode;
    private String accountId;

    private Builder() {
    }

    /**
     * Sets the paymentMethod and returns a reference to this Builder enabling method chaining.
     *
     * @param paymentMethod the paymentMethod to set
     * @return a reference to this Builder
     */
    public Builder paymentMethod(PaymentType paymentMethod) {
      this.paymentMethod = paymentMethod;
      return this;
    }

    /**
     * Sets the currencyCode and returns a reference to this Builder enabling method chaining.
     *
     * @param currencyCode the currencyCode to set
     * @return a reference to this Builder
     */
    public Builder currencyCode(CurrencyCode currencyCode) {
      this.currencyCode = currencyCode;
      return this;
    }

    /**
     * Account Id in the Paysafe system
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
     * Returns a PaymentMethod built from the parameters previously set.
     *
     * @return a PaymentMethod built with parameters of this PaymentMethod.Builder
     */
    public PaymentMethod build() {
      return new PaymentMethod(this);
    }
  }
}
