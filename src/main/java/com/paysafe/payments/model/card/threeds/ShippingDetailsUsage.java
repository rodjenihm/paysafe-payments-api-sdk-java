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
import com.paysafe.payments.model.card.enums.ShippingAddressUsageRange;



/**
 * Shipping usage information
 */
public class ShippingDetailsUsage {

  @JsonProperty("cardHolderNameMatch")
  private Boolean cardHolderNameMatch;
  @JsonProperty("initialUsageDate")
  private String initialUsageDate;
  @JsonProperty("initialUsageRange")
  private ShippingAddressUsageRange initialUsageRange;

  public ShippingDetailsUsage() {
    super();
  }

  private ShippingDetailsUsage(final Builder builder) {
    setCardHolderNameMatch(builder.cardHolderNameMatch);
    setInitialUsageDate(builder.initialUsageDate);
    setInitialUsageRange(builder.initialUsageRange);
  }

  public static Builder builder() {
    return new Builder();
  }


  public ShippingDetailsUsage cardHolderNameMatch(Boolean cardHolderNameMatch) {
    this.cardHolderNameMatch = cardHolderNameMatch;
    return this;
  }

  /**
   * Whether the shipping name matches the cardholder name
   *
   * @return cardHolderNameMatch
   */
  public Boolean getCardHolderNameMatch() {
    return cardHolderNameMatch;
  }

  public void setCardHolderNameMatch(Boolean cardHolderNameMatch) {
    this.cardHolderNameMatch = cardHolderNameMatch;
  }


  public ShippingDetailsUsage initialUsageDate(String initialUsageDate) {
    this.initialUsageDate = initialUsageDate;
    return this;
  }

  /**
   * Date when the shipping address was first used the 3DS Requestor
   *
   * @return initialUsageDate
   */
  public String getInitialUsageDate() {
    return initialUsageDate;
  }

  public void setInitialUsageDate(String initialUsageDate) {
    this.initialUsageDate = initialUsageDate;
  }


  public ShippingDetailsUsage initialUsageRange(ShippingAddressUsageRange initialUsageRange) {
    this.initialUsageRange = initialUsageRange;
    return this;
  }

  /**
   * Get initialUsageRange
   *
   * @return initialUsageRange
   */
  public ShippingAddressUsageRange getInitialUsageRange() {
    return initialUsageRange;
  }

  public void setInitialUsageRange(ShippingAddressUsageRange initialUsageRange) {
    this.initialUsageRange = initialUsageRange;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ShippingDetailsUsage shippingDetailsUsage = (ShippingDetailsUsage) o;
    return Objects.equals(this.cardHolderNameMatch, shippingDetailsUsage.cardHolderNameMatch) &&
        Objects.equals(this.initialUsageDate, shippingDetailsUsage.initialUsageDate) &&
        Objects.equals(this.initialUsageRange, shippingDetailsUsage.initialUsageRange);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cardHolderNameMatch, initialUsageDate, initialUsageRange);
  }

  @Override
  public String toString() {

    return "class ShippingDetailsUsage {\n"
        + "    cardHolderNameMatch: " + toIndentedString(cardHolderNameMatch) + "\n"
        + "    initialUsageDate: " + toIndentedString(initialUsageDate) + "\n"
        + "    initialUsageRange: " + toIndentedString(initialUsageRange) + "\n"
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
   * Shipping usage information builder static inner class.
   */
  public static final class Builder {
    private Boolean cardHolderNameMatch;
    private String initialUsageDate;
    private ShippingAddressUsageRange initialUsageRange;

    private Builder() {
    }

    /**
     * Whether the shipping name matches the cardholder name
     * <p>
     * Sets the cardHolderNameMatch and returns a reference to this Builder enabling method chaining.
     *
     * @param cardHolderNameMatch the cardHolderNameMatch to set
     * @return a reference to this Builder
     */
    public Builder cardHolderNameMatch(Boolean cardHolderNameMatch) {
      this.cardHolderNameMatch = cardHolderNameMatch;
      return this;
    }

    /**
     * Date when the shipping address was first used the 3DS Requestor
     * <p>
     * Sets the initialUsageDate and returns a reference to this Builder enabling method chaining.
     *
     * @param initialUsageDate the initialUsageDate to set
     * @return a reference to this Builder
     */
    public Builder initialUsageDate(String initialUsageDate) {
      this.initialUsageDate = initialUsageDate;
      return this;
    }

    /**
     * Sets the initialUsageRange and returns a reference to this Builder enabling method chaining.
     *
     * @param initialUsageRange the initialUsageRange to set
     * @return a reference to this Builder
     */
    public Builder initialUsageRange(ShippingAddressUsageRange initialUsageRange) {
      this.initialUsageRange = initialUsageRange;
      return this;
    }

    /**
     * Returns a ShippingDetailsUsage built from the parameters previously set.
     *
     * @return a ShippingDetailsUsage built with parameters of this ShippingDetailsUsage.Builder
     */
    public ShippingDetailsUsage build() {
      return new ShippingDetailsUsage(this);
    }
  }
}
