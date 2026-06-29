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
import com.paysafe.payments.model.payment.Payment;



/**
 * Payment method parameter of Google Pay Token
 */
public class GooglePayPaymentMethodData {

  @JsonProperty("description")
  private String description;
  @JsonProperty("info")
  private GooglePayPaymentMethodDataInfo info;
  @JsonProperty("tokenizationData")
  private GooglePayPaymentMethodDataTokenizationData tokenizationData;
  @JsonProperty("type")
  private String type;

  public GooglePayPaymentMethodData() {
    super();
  }

  private GooglePayPaymentMethodData(final Builder builder) {
    setDescription(builder.description);
    setInfo(builder.info);
    setTokenizationData(builder.tokenizationData);
    setType(builder.type);
  }

  public static Builder builder() {
    return new Builder();
  }


  public GooglePayPaymentMethodData description(String description) {
    this.description = description;
    return this;
  }

  /**
   * A descriptive text
   *
   * @return description
   */
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  public GooglePayPaymentMethodData info(GooglePayPaymentMethodDataInfo info) {
    this.info = info;
    return this;
  }

  /**
   * Get info
   *
   * @return info
   */
  public GooglePayPaymentMethodDataInfo getInfo() {
    return info;
  }

  public void setInfo(GooglePayPaymentMethodDataInfo info) {
    this.info = info;
  }


  public GooglePayPaymentMethodData tokenizationData(GooglePayPaymentMethodDataTokenizationData tokenizationData) {
    this.tokenizationData = tokenizationData;
    return this;
  }

  /**
   * Get tokenizationData
   *
   * @return tokenizationData
   */
  public GooglePayPaymentMethodDataTokenizationData getTokenizationData() {
    return tokenizationData;
  }

  public void setTokenizationData(GooglePayPaymentMethodDataTokenizationData tokenizationData) {
    this.tokenizationData = tokenizationData;
  }


  public GooglePayPaymentMethodData type(String type) {
    this.type = type;
    return this;
  }

  /**
   * Type property of Google Pay Payment Method
   *
   * @return type
   */
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GooglePayPaymentMethodData googlePayPaymentMethodData = (GooglePayPaymentMethodData) o;
    return Objects.equals(this.description, googlePayPaymentMethodData.description) &&
        Objects.equals(this.info, googlePayPaymentMethodData.info) &&
        Objects.equals(this.tokenizationData, googlePayPaymentMethodData.tokenizationData) &&
        Objects.equals(this.type, googlePayPaymentMethodData.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, info, tokenizationData, type);
  }

  @Override
  public String toString() {

    return "class GooglePayPaymentMethodData {\n"
        + "    description: " + toIndentedString(description) + "\n"
        + "    info: " + toIndentedString(info) + "\n"
        + "    tokenizationData: " + toIndentedString(tokenizationData) + "\n"
        + "    type: " + toIndentedString(type) + "\n"
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
   * Payment method parameter of Google Pay Token builder static inner class.
   */
  public static final class Builder {
    private String description;
    private GooglePayPaymentMethodDataInfo info;
    private GooglePayPaymentMethodDataTokenizationData tokenizationData;
    private String type;

    private Builder() {
    }

    /**
     * A descriptive text
     * <p>
     * Sets the description and returns a reference to this Builder enabling method chaining.
     *
     * @param description the description to set
     * @return a reference to this Builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Sets the info and returns a reference to this Builder enabling method chaining.
     *
     * @param info the info to set
     * @return a reference to this Builder
     */
    public Builder info(GooglePayPaymentMethodDataInfo info) {
      this.info = info;
      return this;
    }

    /**
     * Sets the tokenizationData and returns a reference to this Builder enabling method chaining.
     *
     * @param tokenizationData the tokenizationData to set
     * @return a reference to this Builder
     */
    public Builder tokenizationData(GooglePayPaymentMethodDataTokenizationData tokenizationData) {
      this.tokenizationData = tokenizationData;
      return this;
    }

    /**
     * Type property of Google Pay Payment Method
     * <p>
     * Sets the type and returns a reference to this Builder enabling method chaining.
     *
     * @param type the type to set
     * @return a reference to this Builder
     */
    public Builder type(String type) {
      this.type = type;
      return this;
    }

    /**
     * Returns a GooglePayPaymentMethodData built from the parameters previously set.
     *
     * @return a GooglePayPaymentMethodData built with parameters of this GooglePayPaymentMethodData.Builder
     */
    public GooglePayPaymentMethodData build() {
      return new GooglePayPaymentMethodData(this);
    }
  }
}
