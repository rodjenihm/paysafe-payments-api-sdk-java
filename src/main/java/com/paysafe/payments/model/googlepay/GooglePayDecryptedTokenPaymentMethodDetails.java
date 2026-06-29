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
import com.paysafe.payments.model.card.threeds.Authentication;
import com.paysafe.payments.model.payment.Payment;



/**
 * Payment method details from decrypted Google Pay token
 */
public class GooglePayDecryptedTokenPaymentMethodDetails {

  @JsonProperty("authMethod")
  private String authMethod;
  @JsonProperty("pan")
  private String pan;
  @JsonProperty("expirationMonth")
  private Integer expirationMonth;
  @JsonProperty("expirationYear")
  private Integer expirationYear;
  @JsonProperty("cryptogram")
  private String cryptogram;
  @JsonProperty("eciIndicator")
  private String eciIndicator;

  public GooglePayDecryptedTokenPaymentMethodDetails() {
    super();
  }

  private GooglePayDecryptedTokenPaymentMethodDetails(final Builder builder) {
    setAuthMethod(builder.authMethod);
    setPan(builder.pan);
    setExpirationMonth(builder.expirationMonth);
    setExpirationYear(builder.expirationYear);
    setCryptogram(builder.cryptogram);
    setEciIndicator(builder.eciIndicator);
  }

  public static Builder builder() {
    return new Builder();
  }


  public GooglePayDecryptedTokenPaymentMethodDetails authMethod(String authMethod) {
    this.authMethod = authMethod;
    return this;
  }

  /**
   * Authentication method used
   *
   * @return authMethod
   */
  public String getAuthMethod() {
    return authMethod;
  }

  public void setAuthMethod(String authMethod) {
    this.authMethod = authMethod;
  }


  public GooglePayDecryptedTokenPaymentMethodDetails pan(String pan) {
    this.pan = pan;
    return this;
  }

  /**
   * The DPAN number
   *
   * @return pan
   */
  public String getPan() {
    return pan;
  }

  public void setPan(String pan) {
    this.pan = pan;
  }


  public GooglePayDecryptedTokenPaymentMethodDetails expirationMonth(Integer expirationMonth) {
    this.expirationMonth = expirationMonth;
    return this;
  }

  /**
   * Expiration month
   *
   * @return expirationMonth
   */
  public Integer getExpirationMonth() {
    return expirationMonth;
  }

  public void setExpirationMonth(Integer expirationMonth) {
    this.expirationMonth = expirationMonth;
  }


  public GooglePayDecryptedTokenPaymentMethodDetails expirationYear(Integer expirationYear) {
    this.expirationYear = expirationYear;
    return this;
  }

  /**
   * Expiration year
   *
   * @return expirationYear
   */
  public Integer getExpirationYear() {
    return expirationYear;
  }

  public void setExpirationYear(Integer expirationYear) {
    this.expirationYear = expirationYear;
  }


  public GooglePayDecryptedTokenPaymentMethodDetails cryptogram(String cryptogram) {
    this.cryptogram = cryptogram;
    return this;
  }

  /**
   * This field is required when authMethod is CRYPTOGRAM_3DS
   *
   * @return cryptogram
   */
  public String getCryptogram() {
    return cryptogram;
  }

  public void setCryptogram(String cryptogram) {
    this.cryptogram = cryptogram;
  }


  public GooglePayDecryptedTokenPaymentMethodDetails eciIndicator(String eciIndicator) {
    this.eciIndicator = eciIndicator;
    return this;
  }

  /**
   * The ECI indicator
   *
   * @return eciIndicator
   */
  public String getEciIndicator() {
    return eciIndicator;
  }

  public void setEciIndicator(String eciIndicator) {
    this.eciIndicator = eciIndicator;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GooglePayDecryptedTokenPaymentMethodDetails googlePayDecryptedTokenPaymentMethodDetails = (GooglePayDecryptedTokenPaymentMethodDetails) o;
    return Objects.equals(this.authMethod, googlePayDecryptedTokenPaymentMethodDetails.authMethod) &&
        Objects.equals(this.pan, googlePayDecryptedTokenPaymentMethodDetails.pan) &&
        Objects.equals(this.expirationMonth, googlePayDecryptedTokenPaymentMethodDetails.expirationMonth) &&
        Objects.equals(this.expirationYear, googlePayDecryptedTokenPaymentMethodDetails.expirationYear) &&
        Objects.equals(this.cryptogram, googlePayDecryptedTokenPaymentMethodDetails.cryptogram) &&
        Objects.equals(this.eciIndicator, googlePayDecryptedTokenPaymentMethodDetails.eciIndicator);
  }

  @Override
  public int hashCode() {
    return Objects.hash(authMethod, pan, expirationMonth, expirationYear, cryptogram, eciIndicator);
  }

  @Override
  public String toString() {

    return "class GooglePayDecryptedTokenPaymentMethodDetails {\n"
        + "    authMethod: " + toIndentedString(authMethod) + "\n"
        + "    pan: " + toIndentedString(pan) + "\n"
        + "    expirationMonth: " + toIndentedString(expirationMonth) + "\n"
        + "    expirationYear: " + toIndentedString(expirationYear) + "\n"
        + "    cryptogram: " + toIndentedString(cryptogram) + "\n"
        + "    eciIndicator: " + toIndentedString(eciIndicator) + "\n"
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
   * Payment method details from decrypted Google Pay token builder static inner class.
   */
  public static final class Builder {
    private String authMethod;
    private String pan;
    private Integer expirationMonth;
    private Integer expirationYear;
    private String cryptogram;
    private String eciIndicator;

    private Builder() {
    }

    /**
     * Authentication method used
     * <p>
     * Sets the authMethod and returns a reference to this Builder enabling method chaining.
     *
     * @param authMethod the authMethod to set
     * @return a reference to this Builder
     */
    public Builder authMethod(String authMethod) {
      this.authMethod = authMethod;
      return this;
    }

    /**
     * The DPAN number
     * <p>
     * Sets the pan and returns a reference to this Builder enabling method chaining.
     *
     * @param pan the pan to set
     * @return a reference to this Builder
     */
    public Builder pan(String pan) {
      this.pan = pan;
      return this;
    }

    /**
     * Expiration month
     * <p>
     * Sets the expirationMonth and returns a reference to this Builder enabling method chaining.
     *
     * @param expirationMonth the expirationMonth to set
     * @return a reference to this Builder
     */
    public Builder expirationMonth(Integer expirationMonth) {
      this.expirationMonth = expirationMonth;
      return this;
    }

    /**
     * Expiration year
     * <p>
     * Sets the expirationYear and returns a reference to this Builder enabling method chaining.
     *
     * @param expirationYear the expirationYear to set
     * @return a reference to this Builder
     */
    public Builder expirationYear(Integer expirationYear) {
      this.expirationYear = expirationYear;
      return this;
    }

    /**
     * This field is required when authMethod is CRYPTOGRAM_3DS
     * <p>
     * Sets the cryptogram and returns a reference to this Builder enabling method chaining.
     *
     * @param cryptogram the cryptogram to set
     * @return a reference to this Builder
     */
    public Builder cryptogram(String cryptogram) {
      this.cryptogram = cryptogram;
      return this;
    }

    /**
     * The ECI indicator
     * <p>
     * Sets the eciIndicator and returns a reference to this Builder enabling method chaining.
     *
     * @param eciIndicator the eciIndicator to set
     * @return a reference to this Builder
     */
    public Builder eciIndicator(String eciIndicator) {
      this.eciIndicator = eciIndicator;
      return this;
    }

    /**
     * Returns a GooglePayDecryptedTokenPaymentMethodDetails built from the parameters previously set.
     *
     * @return a GooglePayDecryptedTokenPaymentMethodDetails built with parameters of this GooglePayDecryptedTokenPaymentMethodDetails.Builder
     */
    public GooglePayDecryptedTokenPaymentMethodDetails build() {
      return new GooglePayDecryptedTokenPaymentMethodDetails(this);
    }
  }
}
