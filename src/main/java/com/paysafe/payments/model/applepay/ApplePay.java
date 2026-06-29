// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.model.applepay;

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
 * Apple Pay payment method information for processing payments through the Paysafe platform. This contains all necessary information to process an Apple Pay transaction, including the payment token from Apple and optional billing information.
 */
public class ApplePay {

  @JsonProperty("label")
  private String label;
  @JsonProperty("requestBillingAddress")
  private Boolean requestBillingAddress;
  @JsonProperty("applePayPaymentToken")
  private ApplePayPaymentToken applePayPaymentToken;
  @JsonProperty("billingContact")
  private ApplePayBillingContact billingContact;

  public ApplePay() {
    super();
  }

  private ApplePay(final Builder builder) {
    setLabel(builder.label);
    setRequestBillingAddress(builder.requestBillingAddress);
    setApplePayPaymentToken(builder.applePayPaymentToken);
    setBillingContact(builder.billingContact);
  }

  public static Builder builder() {
    return new Builder();
  }


  public ApplePay label(String label) {
    this.label = label;
    return this;
  }

  /**
   * The label displayed on the Apple Pay button. This text influences what users see during the Apple Pay flow. Recommended values: \"Buy with Apple Pay\", \"Pay with Apple Pay\", \"Donate with Apple Pay\"
   *
   * @return label
   */
  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }


  public ApplePay requestBillingAddress(Boolean requestBillingAddress) {
    this.requestBillingAddress = requestBillingAddress;
    return this;
  }

  /**
   * Whether to request the billing address from the customer. Setting this to true will prompt the user to provide billing details during the Apple Pay checkout process.
   *
   * @return requestBillingAddress
   */
  public Boolean getRequestBillingAddress() {
    return requestBillingAddress;
  }

  public void setRequestBillingAddress(Boolean requestBillingAddress) {
    this.requestBillingAddress = requestBillingAddress;
  }


  public ApplePay applePayPaymentToken(ApplePayPaymentToken applePayPaymentToken) {
    this.applePayPaymentToken = applePayPaymentToken;
    return this;
  }

  /**
   * Get applePayPaymentToken
   *
   * @return applePayPaymentToken
   */
  public ApplePayPaymentToken getApplePayPaymentToken() {
    return applePayPaymentToken;
  }

  public void setApplePayPaymentToken(ApplePayPaymentToken applePayPaymentToken) {
    this.applePayPaymentToken = applePayPaymentToken;
  }


  public ApplePay billingContact(ApplePayBillingContact billingContact) {
    this.billingContact = billingContact;
    return this;
  }

  /**
   * Get billingContact
   *
   * @return billingContact
   */
  public ApplePayBillingContact getBillingContact() {
    return billingContact;
  }

  public void setBillingContact(ApplePayBillingContact billingContact) {
    this.billingContact = billingContact;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApplePay applePay = (ApplePay) o;
    return Objects.equals(this.label, applePay.label) &&
        Objects.equals(this.requestBillingAddress, applePay.requestBillingAddress) &&
        Objects.equals(this.applePayPaymentToken, applePay.applePayPaymentToken) &&
        Objects.equals(this.billingContact, applePay.billingContact);
  }

  @Override
  public int hashCode() {
    return Objects.hash(label, requestBillingAddress, applePayPaymentToken, billingContact);
  }

  @Override
  public String toString() {

    return "class ApplePay {\n"
        + "    label: " + toIndentedString(label) + "\n"
        + "    requestBillingAddress: " + toIndentedString(requestBillingAddress) + "\n"
        + "    applePayPaymentToken: " + toIndentedString(applePayPaymentToken) + "\n"
        + "    billingContact: " + toIndentedString(billingContact) + "\n"
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
   * Apple Pay payment method information for processing payments through the Paysafe platform. This contains all necessary information to process an Apple Pay transaction, including the payment token from Apple and optional billing information. builder static inner class.
   */
  public static final class Builder {
    private String label;
    private Boolean requestBillingAddress;
    private ApplePayPaymentToken applePayPaymentToken;
    private ApplePayBillingContact billingContact;

    private Builder() {
    }

    /**
     * The label displayed on the Apple Pay button. This text influences what users see during the Apple Pay flow. Recommended values: \"Buy with Apple Pay\", \"Pay with Apple Pay\", \"Donate with Apple Pay\"
     * <p>
     * Sets the label and returns a reference to this Builder enabling method chaining.
     *
     * @param label the label to set
     * @return a reference to this Builder
     */
    public Builder label(String label) {
      this.label = label;
      return this;
    }

    /**
     * Whether to request the billing address from the customer. Setting this to true will prompt the user to provide billing details during the Apple Pay checkout process.
     * <p>
     * Sets the requestBillingAddress and returns a reference to this Builder enabling method chaining.
     *
     * @param requestBillingAddress the requestBillingAddress to set
     * @return a reference to this Builder
     */
    public Builder requestBillingAddress(Boolean requestBillingAddress) {
      this.requestBillingAddress = requestBillingAddress;
      return this;
    }

    /**
     * Sets the applePayPaymentToken and returns a reference to this Builder enabling method chaining.
     *
     * @param applePayPaymentToken the applePayPaymentToken to set
     * @return a reference to this Builder
     */
    public Builder applePayPaymentToken(ApplePayPaymentToken applePayPaymentToken) {
      this.applePayPaymentToken = applePayPaymentToken;
      return this;
    }

    /**
     * Sets the billingContact and returns a reference to this Builder enabling method chaining.
     *
     * @param billingContact the billingContact to set
     * @return a reference to this Builder
     */
    public Builder billingContact(ApplePayBillingContact billingContact) {
      this.billingContact = billingContact;
      return this;
    }

    /**
     * Returns a ApplePay built from the parameters previously set.
     *
     * @return a ApplePay built with parameters of this ApplePay.Builder
     */
    public ApplePay build() {
      return new ApplePay(this);
    }
  }
}
