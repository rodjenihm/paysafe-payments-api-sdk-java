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
import com.paysafe.payments.model.applepay.enums.ApplePayTokenSubtype;
import com.paysafe.payments.model.card.CardExpiry;
import com.paysafe.payments.model.card.enums.TokenStatus;



/**
 * Apple Pay token information. Returned when the stored payment method is an Apple Pay token and token_type is APPLE_PAY.
 */
public class ApplePayTokenDetails {

  @JsonProperty("bin")
  private String bin;
  @JsonProperty("lastDigits")
  private String lastDigits;
  @JsonProperty("expiry")
  private CardExpiry expiry;
  @JsonProperty("status")
  private TokenStatus status;
  @JsonProperty("subtype")
  private ApplePayTokenSubtype subtype;

  public ApplePayTokenDetails() {
    super();
  }

  private ApplePayTokenDetails(final Builder builder) {
    setBin(builder.bin);
    setLastDigits(builder.lastDigits);
    setExpiry(builder.expiry);
    setStatus(builder.status);
    setSubtype(builder.subtype);
  }

  public static Builder builder() {
    return new Builder();
  }


  public ApplePayTokenDetails bin(String bin) {
    this.bin = bin;
    return this;
  }

  /**
   * The first 6 digits of the Apple Pay's DPAN (Device Primary Account Number) - Bank Identification Number (BIN)
   *
   * @return bin
   */
  public String getBin() {
    return bin;
  }

  public void setBin(String bin) {
    this.bin = bin;
  }


  public ApplePayTokenDetails lastDigits(String lastDigits) {
    this.lastDigits = lastDigits;
    return this;
  }

  /**
   * This is the last digits of the Apple Pay's token
   *
   * @return lastDigits
   */
  public String getLastDigits() {
    return lastDigits;
  }

  public void setLastDigits(String lastDigits) {
    this.lastDigits = lastDigits;
  }


  public ApplePayTokenDetails expiry(CardExpiry expiry) {
    this.expiry = expiry;
    return this;
  }

  /**
   * Get expiry
   *
   * @return expiry
   */
  public CardExpiry getExpiry() {
    return expiry;
  }

  public void setExpiry(CardExpiry expiry) {
    this.expiry = expiry;
  }


  public ApplePayTokenDetails status(TokenStatus status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   *
   * @return status
   */
  public TokenStatus getStatus() {
    return status;
  }

  public void setStatus(TokenStatus status) {
    this.status = status;
  }


  public ApplePayTokenDetails subtype(ApplePayTokenSubtype subtype) {
    this.subtype = subtype;
    return this;
  }

  /**
   * Get subtype
   *
   * @return subtype
   */
  public ApplePayTokenSubtype getSubtype() {
    return subtype;
  }

  public void setSubtype(ApplePayTokenSubtype subtype) {
    this.subtype = subtype;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApplePayTokenDetails applePayTokenDetails = (ApplePayTokenDetails) o;
    return Objects.equals(this.bin, applePayTokenDetails.bin) &&
        Objects.equals(this.lastDigits, applePayTokenDetails.lastDigits) &&
        Objects.equals(this.expiry, applePayTokenDetails.expiry) &&
        Objects.equals(this.status, applePayTokenDetails.status) &&
        Objects.equals(this.subtype, applePayTokenDetails.subtype);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bin, lastDigits, expiry, status, subtype);
  }

  @Override
  public String toString() {

    return "class ApplePayTokenDetails {\n"
        + "    bin: " + toIndentedString(bin) + "\n"
        + "    lastDigits: " + toIndentedString(lastDigits) + "\n"
        + "    expiry: " + toIndentedString(expiry) + "\n"
        + "    status: " + toIndentedString(status) + "\n"
        + "    subtype: " + toIndentedString(subtype) + "\n"
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
   * Apple Pay token information. Returned when the stored payment method is an Apple Pay token and token_type is APPLE_PAY. builder static inner class.
   */
  public static final class Builder {
    private String bin;
    private String lastDigits;
    private CardExpiry expiry;
    private TokenStatus status;
    private ApplePayTokenSubtype subtype;

    private Builder() {
    }

    /**
     * The first 6 digits of the Apple Pay's DPAN (Device Primary Account Number) - Bank Identification Number (BIN)
     * <p>
     * Sets the bin and returns a reference to this Builder enabling method chaining.
     *
     * @param bin the bin to set
     * @return a reference to this Builder
     */
    public Builder bin(String bin) {
      this.bin = bin;
      return this;
    }

    /**
     * This is the last digits of the Apple Pay's token
     * <p>
     * Sets the lastDigits and returns a reference to this Builder enabling method chaining.
     *
     * @param lastDigits the lastDigits to set
     * @return a reference to this Builder
     */
    public Builder lastDigits(String lastDigits) {
      this.lastDigits = lastDigits;
      return this;
    }

    /**
     * Sets the expiry and returns a reference to this Builder enabling method chaining.
     *
     * @param expiry the expiry to set
     * @return a reference to this Builder
     */
    public Builder expiry(CardExpiry expiry) {
      this.expiry = expiry;
      return this;
    }

    /**
     * Sets the status and returns a reference to this Builder enabling method chaining.
     *
     * @param status the status to set
     * @return a reference to this Builder
     */
    public Builder status(TokenStatus status) {
      this.status = status;
      return this;
    }

    /**
     * Sets the subtype and returns a reference to this Builder enabling method chaining.
     *
     * @param subtype the subtype to set
     * @return a reference to this Builder
     */
    public Builder subtype(ApplePayTokenSubtype subtype) {
      this.subtype = subtype;
      return this;
    }

    /**
     * Returns a ApplePayTokenDetails built from the parameters previously set.
     *
     * @return a ApplePayTokenDetails built with parameters of this ApplePayTokenDetails.Builder
     */
    public ApplePayTokenDetails build() {
      return new ApplePayTokenDetails(this);
    }
  }
}
