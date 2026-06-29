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
import com.paysafe.payments.model.common.enums.CurrencyCode;



/**
 * Details about purchased gift cards
 */
public class PurchasedGiftCardDetails {

  @JsonProperty("amount")
  private Integer amount;
  @JsonProperty("count")
  private Integer count;
  @JsonProperty("currency")
  private CurrencyCode currency;

  public PurchasedGiftCardDetails() {
    super();
  }

  private PurchasedGiftCardDetails(final Builder builder) {
    setAmount(builder.amount);
    setCount(builder.count);
    setCurrency(builder.currency);
  }

  public static Builder builder() {
    return new Builder();
  }


  public PurchasedGiftCardDetails amount(Integer amount) {
    this.amount = amount;
    return this;
  }

  /**
   * Amount of the gift card in minor units\\
   *
   * @return amount
   */
  public Integer getAmount() {
    return amount;
  }

  public void setAmount(Integer amount) {
    this.amount = amount;
  }


  public PurchasedGiftCardDetails count(Integer count) {
    this.count = count;
    return this;
  }

  /**
   * Number of gift cards purchased
   *
   * @return count
   */
  public Integer getCount() {
    return count;
  }

  public void setCount(Integer count) {
    this.count = count;
  }


  public PurchasedGiftCardDetails currency(CurrencyCode currency) {
    this.currency = currency;
    return this;
  }

  /**
   * Get currency
   *
   * @return currency
   */
  public CurrencyCode getCurrency() {
    return currency;
  }

  public void setCurrency(CurrencyCode currency) {
    this.currency = currency;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PurchasedGiftCardDetails purchasedGiftCardDetails = (PurchasedGiftCardDetails) o;
    return Objects.equals(this.amount, purchasedGiftCardDetails.amount) &&
        Objects.equals(this.count, purchasedGiftCardDetails.count) &&
        Objects.equals(this.currency, purchasedGiftCardDetails.currency);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount, count, currency);
  }

  @Override
  public String toString() {

    return "class PurchasedGiftCardDetails {\n"
        + "    amount: " + toIndentedString(amount) + "\n"
        + "    count: " + toIndentedString(count) + "\n"
        + "    currency: " + toIndentedString(currency) + "\n"
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
   * Details about purchased gift cards builder static inner class.
   */
  public static final class Builder {
    private Integer amount;
    private Integer count;
    private CurrencyCode currency;

    private Builder() {
    }

    /**
     * Amount of the gift card in minor units\\
     * <p>
     * Sets the amount and returns a reference to this Builder enabling method chaining.
     *
     * @param amount the amount to set
     * @return a reference to this Builder
     */
    public Builder amount(Integer amount) {
      this.amount = amount;
      return this;
    }

    /**
     * Number of gift cards purchased
     * <p>
     * Sets the count and returns a reference to this Builder enabling method chaining.
     *
     * @param count the count to set
     * @return a reference to this Builder
     */
    public Builder count(Integer count) {
      this.count = count;
      return this;
    }

    /**
     * Sets the currency and returns a reference to this Builder enabling method chaining.
     *
     * @param currency the currency to set
     * @return a reference to this Builder
     */
    public Builder currency(CurrencyCode currency) {
      this.currency = currency;
      return this;
    }

    /**
     * Returns a PurchasedGiftCardDetails built from the parameters previously set.
     *
     * @return a PurchasedGiftCardDetails built with parameters of this PurchasedGiftCardDetails.Builder
     */
    public PurchasedGiftCardDetails build() {
      return new PurchasedGiftCardDetails(this);
    }
  }
}
