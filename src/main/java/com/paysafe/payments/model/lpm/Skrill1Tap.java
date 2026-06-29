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
 * These are the details of the skrill 1-Tap account used for the transaction.
 */
public class Skrill1Tap {

  @JsonProperty("consumerId")
  private String consumerId;
  @JsonProperty("recipientDescription")
  private String recipientDescription;
  @JsonProperty("maxAmount")
  private Integer maxAmount;

  public Skrill1Tap() {
    super();
  }

  private Skrill1Tap(final Builder builder) {
    setConsumerId(builder.consumerId);
    setRecipientDescription(builder.recipientDescription);
    setMaxAmount(builder.maxAmount);
  }

  public static Builder builder() {
    return new Builder();
  }


  public Skrill1Tap consumerId(String consumerId) {
    this.consumerId = consumerId;
    return this;
  }

  /**
   * Unique ID of the user which is used to identify to account and user in subsequent calls
   *
   * @return consumerId
   */
  public String getConsumerId() {
    return consumerId;
  }

  public void setConsumerId(String consumerId) {
    this.consumerId = consumerId;
  }


  public Skrill1Tap recipientDescription(String recipientDescription) {
    this.recipientDescription = recipientDescription;
    return this;
  }

  /**
   * This is a description to be shown on the Skrill payment page in the logo area if there is no logo url parameter. If no value is submitted and there is no logo, the pay_to_email value is shown as the recipient of the payment
   *
   * @return recipientDescription
   */
  public String getRecipientDescription() {
    return recipientDescription;
  }

  public void setRecipientDescription(String recipientDescription) {
    this.recipientDescription = recipientDescription;
  }


  public Skrill1Tap maxAmount(Integer maxAmount) {
    this.maxAmount = maxAmount;
    return this;
  }

  /**
   * This acts as an upper limit, any subsequent transactions for this subscription cannot be more than the maxAmount set
   *
   * @return maxAmount
   */
  public Integer getMaxAmount() {
    return maxAmount;
  }

  public void setMaxAmount(Integer maxAmount) {
    this.maxAmount = maxAmount;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Skrill1Tap skrill1Tap = (Skrill1Tap) o;
    return Objects.equals(this.consumerId, skrill1Tap.consumerId) &&
        Objects.equals(this.recipientDescription, skrill1Tap.recipientDescription) &&
        Objects.equals(this.maxAmount, skrill1Tap.maxAmount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(consumerId, recipientDescription, maxAmount);
  }

  @Override
  public String toString() {

    return "class Skrill1Tap {\n"
        + "    consumerId: " + toIndentedString(consumerId) + "\n"
        + "    recipientDescription: " + toIndentedString(recipientDescription) + "\n"
        + "    maxAmount: " + toIndentedString(maxAmount) + "\n"
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
   * These are the details of the skrill 1-Tap account used for the transaction. builder static inner class.
   */
  public static final class Builder {
    private String consumerId;
    private String recipientDescription;
    private Integer maxAmount;

    private Builder() {
    }

    /**
     * Unique ID of the user which is used to identify to account and user in subsequent calls
     * <p>
     * Sets the consumerId and returns a reference to this Builder enabling method chaining.
     *
     * @param consumerId the consumerId to set
     * @return a reference to this Builder
     */
    public Builder consumerId(String consumerId) {
      this.consumerId = consumerId;
      return this;
    }

    /**
     * This is a description to be shown on the Skrill payment page in the logo area if there is no logo url parameter. If no value is submitted and there is no logo, the pay_to_email value is shown as the recipient of the payment
     * <p>
     * Sets the recipientDescription and returns a reference to this Builder enabling method chaining.
     *
     * @param recipientDescription the recipientDescription to set
     * @return a reference to this Builder
     */
    public Builder recipientDescription(String recipientDescription) {
      this.recipientDescription = recipientDescription;
      return this;
    }

    /**
     * This acts as an upper limit, any subsequent transactions for this subscription cannot be more than the maxAmount set
     * <p>
     * Sets the maxAmount and returns a reference to this Builder enabling method chaining.
     *
     * @param maxAmount the maxAmount to set
     * @return a reference to this Builder
     */
    public Builder maxAmount(Integer maxAmount) {
      this.maxAmount = maxAmount;
      return this;
    }

    /**
     * Returns a Skrill1Tap built from the parameters previously set.
     *
     * @return a Skrill1Tap built with parameters of this Skrill1Tap.Builder
     */
    public Skrill1Tap build() {
      return new Skrill1Tap(this);
    }
  }
}
