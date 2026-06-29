// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.model.googlepay;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.paysafe.payments.model.card.Card;
import com.paysafe.payments.model.payment.Payment;



/**
 * Payment method information for Google Pay
 */
public class GooglePayPaymentMethodDataInfo {

  @JsonProperty("billingAddress")
  private GooglePayBillingAddress billingAddress;
  @JsonProperty("cardDetails")
  private Integer cardDetails;
  @JsonProperty("cardNetwork")
  private String cardNetwork;

  public GooglePayPaymentMethodDataInfo() {
    super();
  }

  private GooglePayPaymentMethodDataInfo(final Builder builder) {
    setBillingAddress(builder.billingAddress);
    setCardDetails(builder.cardDetails);
    setCardNetwork(builder.cardNetwork);
  }

  public static Builder builder() {
    return new Builder();
  }


  public GooglePayPaymentMethodDataInfo billingAddress(GooglePayBillingAddress billingAddress) {
    this.billingAddress = billingAddress;
    return this;
  }

  /**
   * Get billingAddress
   *
   * @return billingAddress
   */
  public GooglePayBillingAddress getBillingAddress() {
    return billingAddress;
  }

  public void setBillingAddress(GooglePayBillingAddress billingAddress) {
    this.billingAddress = billingAddress;
  }


  public GooglePayPaymentMethodDataInfo cardDetails(Integer cardDetails) {
    this.cardDetails = cardDetails;
    return this;
  }

  /**
   * Card details
   *
   * @return cardDetails
   */
  public Integer getCardDetails() {
    return cardDetails;
  }

  public void setCardDetails(Integer cardDetails) {
    this.cardDetails = cardDetails;
  }


  public GooglePayPaymentMethodDataInfo cardNetwork(String cardNetwork) {
    this.cardNetwork = cardNetwork;
    return this;
  }

  /**
   * This describes the type of card used for the request
   *
   * @return cardNetwork
   */
  public String getCardNetwork() {
    return cardNetwork;
  }

  public void setCardNetwork(String cardNetwork) {
    this.cardNetwork = cardNetwork;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GooglePayPaymentMethodDataInfo googlePayPaymentMethodDataInfo = (GooglePayPaymentMethodDataInfo) o;
    return Objects.equals(this.billingAddress, googlePayPaymentMethodDataInfo.billingAddress) &&
        Objects.equals(this.cardDetails, googlePayPaymentMethodDataInfo.cardDetails) &&
        Objects.equals(this.cardNetwork, googlePayPaymentMethodDataInfo.cardNetwork);
  }

  @Override
  public int hashCode() {
    return Objects.hash(billingAddress, cardDetails, cardNetwork);
  }

  @Override
  public String toString() {

    return "class GooglePayPaymentMethodDataInfo {\n"
        + "    billingAddress: " + toIndentedString(billingAddress) + "\n"
        + "    cardDetails: " + toIndentedString(cardDetails) + "\n"
        + "    cardNetwork: " + toIndentedString(cardNetwork) + "\n"
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
   * Payment method information for Google Pay builder static inner class.
   */
  public static final class Builder {
    private GooglePayBillingAddress billingAddress;
    private Integer cardDetails;
    private String cardNetwork;

    private Builder() {
    }

    /**
     * Sets the billingAddress and returns a reference to this Builder enabling method chaining.
     *
     * @param billingAddress the billingAddress to set
     * @return a reference to this Builder
     */
    public Builder billingAddress(GooglePayBillingAddress billingAddress) {
      this.billingAddress = billingAddress;
      return this;
    }

    /**
     * Card details
     * <p>
     * Sets the cardDetails and returns a reference to this Builder enabling method chaining.
     *
     * @param cardDetails the cardDetails to set
     * @return a reference to this Builder
     */
    public Builder cardDetails(Integer cardDetails) {
      this.cardDetails = cardDetails;
      return this;
    }

    /**
     * This describes the type of card used for the request
     * <p>
     * Sets the cardNetwork and returns a reference to this Builder enabling method chaining.
     *
     * @param cardNetwork the cardNetwork to set
     * @return a reference to this Builder
     */
    public Builder cardNetwork(String cardNetwork) {
      this.cardNetwork = cardNetwork;
      return this;
    }

    /**
     * Returns a GooglePayPaymentMethodDataInfo built from the parameters previously set.
     *
     * @return a GooglePayPaymentMethodDataInfo built with parameters of this GooglePayPaymentMethodDataInfo.Builder
     */
    public GooglePayPaymentMethodDataInfo build() {
      return new GooglePayPaymentMethodDataInfo(this);
    }
  }
}
