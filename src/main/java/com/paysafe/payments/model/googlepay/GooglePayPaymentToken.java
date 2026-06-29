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
 * Google Pay payment token
 */
public class GooglePayPaymentToken {

  @JsonProperty("apiVersion")
  private Integer apiVersion;
  @JsonProperty("apiVersionMinor")
  private Integer apiVersionMinor;
  @JsonProperty("paymentMethodData")
  private GooglePayPaymentMethodData paymentMethodData;

  public GooglePayPaymentToken() {
    super();
  }

  private GooglePayPaymentToken(final Builder builder) {
    setApiVersion(builder.apiVersion);
    setApiVersionMinor(builder.apiVersionMinor);
    setPaymentMethodData(builder.paymentMethodData);
  }

  public static Builder builder() {
    return new Builder();
  }


  public GooglePayPaymentToken apiVersion(Integer apiVersion) {
    this.apiVersion = apiVersion;
    return this;
  }

  /**
   * Major API version. The value is 2 for this specification
   *
   * @return apiVersion
   */
  public Integer getApiVersion() {
    return apiVersion;
  }

  public void setApiVersion(Integer apiVersion) {
    this.apiVersion = apiVersion;
  }


  public GooglePayPaymentToken apiVersionMinor(Integer apiVersionMinor) {
    this.apiVersionMinor = apiVersionMinor;
    return this;
  }

  /**
   * Minor API version. The value is 0 for this specification
   *
   * @return apiVersionMinor
   */
  public Integer getApiVersionMinor() {
    return apiVersionMinor;
  }

  public void setApiVersionMinor(Integer apiVersionMinor) {
    this.apiVersionMinor = apiVersionMinor;
  }


  public GooglePayPaymentToken paymentMethodData(GooglePayPaymentMethodData paymentMethodData) {
    this.paymentMethodData = paymentMethodData;
    return this;
  }

  /**
   * Get paymentMethodData
   *
   * @return paymentMethodData
   */
  public GooglePayPaymentMethodData getPaymentMethodData() {
    return paymentMethodData;
  }

  public void setPaymentMethodData(GooglePayPaymentMethodData paymentMethodData) {
    this.paymentMethodData = paymentMethodData;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GooglePayPaymentToken googlePayPaymentToken = (GooglePayPaymentToken) o;
    return Objects.equals(this.apiVersion, googlePayPaymentToken.apiVersion) &&
        Objects.equals(this.apiVersionMinor, googlePayPaymentToken.apiVersionMinor) &&
        Objects.equals(this.paymentMethodData, googlePayPaymentToken.paymentMethodData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(apiVersion, apiVersionMinor, paymentMethodData);
  }

  @Override
  public String toString() {

    return "class GooglePayPaymentToken {\n"
        + "    apiVersion: " + toIndentedString(apiVersion) + "\n"
        + "    apiVersionMinor: " + toIndentedString(apiVersionMinor) + "\n"
        + "    paymentMethodData: " + toIndentedString(paymentMethodData) + "\n"
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
   * Google Pay payment token builder static inner class.
   */
  public static final class Builder {
    private Integer apiVersion;
    private Integer apiVersionMinor;
    private GooglePayPaymentMethodData paymentMethodData;

    private Builder() {
    }

    /**
     * Major API version. The value is 2 for this specification
     * <p>
     * Sets the apiVersion and returns a reference to this Builder enabling method chaining.
     *
     * @param apiVersion the apiVersion to set
     * @return a reference to this Builder
     */
    public Builder apiVersion(Integer apiVersion) {
      this.apiVersion = apiVersion;
      return this;
    }

    /**
     * Minor API version. The value is 0 for this specification
     * <p>
     * Sets the apiVersionMinor and returns a reference to this Builder enabling method chaining.
     *
     * @param apiVersionMinor the apiVersionMinor to set
     * @return a reference to this Builder
     */
    public Builder apiVersionMinor(Integer apiVersionMinor) {
      this.apiVersionMinor = apiVersionMinor;
      return this;
    }

    /**
     * Sets the paymentMethodData and returns a reference to this Builder enabling method chaining.
     *
     * @param paymentMethodData the paymentMethodData to set
     * @return a reference to this Builder
     */
    public Builder paymentMethodData(GooglePayPaymentMethodData paymentMethodData) {
      this.paymentMethodData = paymentMethodData;
      return this;
    }

    /**
     * Returns a GooglePayPaymentToken built from the parameters previously set.
     *
     * @return a GooglePayPaymentToken built with parameters of this GooglePayPaymentToken.Builder
     */
    public GooglePayPaymentToken build() {
      return new GooglePayPaymentToken(this);
    }
  }
}
