// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.model.card.threeds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.paysafe.payments.model.card.enums.AccountCreatedRange;



/**
 * Details of the current payment account of the cardholder
 */
public class PaymentAccountDetails {

  @JsonProperty("createdRange")
  private AccountCreatedRange createdRange;
  @JsonProperty("createdDate")
  private String createdDate;

  public PaymentAccountDetails() {
    super();
  }

  private PaymentAccountDetails(final Builder builder) {
    setCreatedRange(builder.createdRange);
    setCreatedDate(builder.createdDate);
  }

  public static Builder builder() {
    return new Builder();
  }


  public PaymentAccountDetails createdRange(AccountCreatedRange createdRange) {
    this.createdRange = createdRange;
    return this;
  }

  /**
   * Get createdRange
   *
   * @return createdRange
   */
  public AccountCreatedRange getCreatedRange() {
    return createdRange;
  }

  public void setCreatedRange(AccountCreatedRange createdRange) {
    this.createdRange = createdRange;
  }


  public PaymentAccountDetails createdDate(String createdDate) {
    this.createdDate = createdDate;
    return this;
  }

  /**
   * Date that the cardholder opened the account with the 3DS Requestor (ISO 8601 format)
   *
   * @return createdDate
   */
  public String getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(String createdDate) {
    this.createdDate = createdDate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PaymentAccountDetails paymentAccountDetails = (PaymentAccountDetails) o;
    return Objects.equals(this.createdRange, paymentAccountDetails.createdRange) &&
        Objects.equals(this.createdDate, paymentAccountDetails.createdDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(createdRange, createdDate);
  }

  @Override
  public String toString() {

    return "class PaymentAccountDetails {\n"
        + "    createdRange: " + toIndentedString(createdRange) + "\n"
        + "    createdDate: " + toIndentedString(createdDate) + "\n"
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
   * Details of the current payment account of the cardholder builder static inner class.
   */
  public static final class Builder {
    private AccountCreatedRange createdRange;
    private String createdDate;

    private Builder() {
    }

    /**
     * Sets the createdRange and returns a reference to this Builder enabling method chaining.
     *
     * @param createdRange the createdRange to set
     * @return a reference to this Builder
     */
    public Builder createdRange(AccountCreatedRange createdRange) {
      this.createdRange = createdRange;
      return this;
    }

    /**
     * Date that the cardholder opened the account with the 3DS Requestor (ISO 8601 format)
     * <p>
     * Sets the createdDate and returns a reference to this Builder enabling method chaining.
     *
     * @param createdDate the createdDate to set
     * @return a reference to this Builder
     */
    public Builder createdDate(String createdDate) {
      this.createdDate = createdDate;
      return this;
    }

    /**
     * Returns a PaymentAccountDetails built from the parameters previously set.
     *
     * @return a PaymentAccountDetails built with parameters of this PaymentAccountDetails.Builder
     */
    public PaymentAccountDetails build() {
      return new PaymentAccountDetails(this);
    }
  }
}
