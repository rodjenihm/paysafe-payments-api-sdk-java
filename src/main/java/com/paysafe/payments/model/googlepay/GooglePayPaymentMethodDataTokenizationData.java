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
 * The tokenization data for Google Pay
 */
public class GooglePayPaymentMethodDataTokenizationData {

  @JsonProperty("token")
  private String token;
  @JsonProperty("type")
  private String type;
  @JsonProperty("decryptedToken")
  private GooglePayDecryptedToken decryptedToken;

  public GooglePayPaymentMethodDataTokenizationData() {
    super();
  }

  private GooglePayPaymentMethodDataTokenizationData(final Builder builder) {
    setToken(builder.token);
    setType(builder.type);
    setDecryptedToken(builder.decryptedToken);
  }

  public static Builder builder() {
    return new Builder();
  }


  public GooglePayPaymentMethodDataTokenizationData token(String token) {
    this.token = token;
    return this;
  }

  /**
   * This object contains the user's payment credentials
   *
   * @return token
   */
  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }


  public GooglePayPaymentMethodDataTokenizationData type(String type) {
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


  public GooglePayPaymentMethodDataTokenizationData decryptedToken(GooglePayDecryptedToken decryptedToken) {
    this.decryptedToken = decryptedToken;
    return this;
  }

  /**
   * Get decryptedToken
   *
   * @return decryptedToken
   */
  public GooglePayDecryptedToken getDecryptedToken() {
    return decryptedToken;
  }

  public void setDecryptedToken(GooglePayDecryptedToken decryptedToken) {
    this.decryptedToken = decryptedToken;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GooglePayPaymentMethodDataTokenizationData googlePayPaymentMethodDataTokenizationData = (GooglePayPaymentMethodDataTokenizationData) o;
    return Objects.equals(this.token, googlePayPaymentMethodDataTokenizationData.token) &&
        Objects.equals(this.type, googlePayPaymentMethodDataTokenizationData.type) &&
        Objects.equals(this.decryptedToken, googlePayPaymentMethodDataTokenizationData.decryptedToken);
  }

  @Override
  public int hashCode() {
    return Objects.hash(token, type, decryptedToken);
  }

  @Override
  public String toString() {

    return "class GooglePayPaymentMethodDataTokenizationData {\n"
        + "    token: " + toIndentedString(token) + "\n"
        + "    type: " + toIndentedString(type) + "\n"
        + "    decryptedToken: " + toIndentedString(decryptedToken) + "\n"
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
   * The tokenization data for Google Pay builder static inner class.
   */
  public static final class Builder {
    private String token;
    private String type;
    private GooglePayDecryptedToken decryptedToken;

    private Builder() {
    }

    /**
     * This object contains the user's payment credentials
     * <p>
     * Sets the token and returns a reference to this Builder enabling method chaining.
     *
     * @param token the token to set
     * @return a reference to this Builder
     */
    public Builder token(String token) {
      this.token = token;
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
     * Sets the decryptedToken and returns a reference to this Builder enabling method chaining.
     *
     * @param decryptedToken the decryptedToken to set
     * @return a reference to this Builder
     */
    public Builder decryptedToken(GooglePayDecryptedToken decryptedToken) {
      this.decryptedToken = decryptedToken;
      return this;
    }

    /**
     * Returns a GooglePayPaymentMethodDataTokenizationData built from the parameters previously set.
     *
     * @return a GooglePayPaymentMethodDataTokenizationData built with parameters of this GooglePayPaymentMethodDataTokenizationData.Builder
     */
    public GooglePayPaymentMethodDataTokenizationData build() {
      return new GooglePayPaymentMethodDataTokenizationData(this);
    }
  }
}
