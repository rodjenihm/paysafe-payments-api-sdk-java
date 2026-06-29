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



/**
 * Google Pay payment details
 */
public class GooglePay {

  @JsonProperty("googlePayPaymentToken")
  private GooglePayPaymentToken googlePayPaymentToken;

  public GooglePay() {
    super();
  }

  private GooglePay(final Builder builder) {
    setGooglePayPaymentToken(builder.googlePayPaymentToken);
  }

  public static Builder builder() {
    return new Builder();
  }


  public GooglePay googlePayPaymentToken(GooglePayPaymentToken googlePayPaymentToken) {
    this.googlePayPaymentToken = googlePayPaymentToken;
    return this;
  }

  /**
   * Get googlePayPaymentToken
   *
   * @return googlePayPaymentToken
   */
  public GooglePayPaymentToken getGooglePayPaymentToken() {
    return googlePayPaymentToken;
  }

  public void setGooglePayPaymentToken(GooglePayPaymentToken googlePayPaymentToken) {
    this.googlePayPaymentToken = googlePayPaymentToken;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GooglePay googlePay = (GooglePay) o;
    return Objects.equals(this.googlePayPaymentToken, googlePay.googlePayPaymentToken);
  }

  @Override
  public int hashCode() {
    return Objects.hash(googlePayPaymentToken);
  }

  @Override
  public String toString() {

    return "class GooglePay {\n"
        + "    googlePayPaymentToken: " + toIndentedString(googlePayPaymentToken) + "\n"
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
   * Google Pay payment details builder static inner class.
   */
  public static final class Builder {
    private GooglePayPaymentToken googlePayPaymentToken;

    private Builder() {
    }

    /**
     * Sets the googlePayPaymentToken and returns a reference to this Builder enabling method chaining.
     *
     * @param googlePayPaymentToken the googlePayPaymentToken to set
     * @return a reference to this Builder
     */
    public Builder googlePayPaymentToken(GooglePayPaymentToken googlePayPaymentToken) {
      this.googlePayPaymentToken = googlePayPaymentToken;
      return this;
    }

    /**
     * Returns a GooglePay built from the parameters previously set.
     *
     * @return a GooglePay built with parameters of this GooglePay.Builder
     */
    public GooglePay build() {
      return new GooglePay(this);
    }
  }
}
