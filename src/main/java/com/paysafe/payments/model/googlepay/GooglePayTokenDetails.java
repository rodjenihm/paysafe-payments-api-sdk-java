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
import com.paysafe.payments.model.card.CardExpiry;



/**
 * Google Pay token information. Returned when the stored payment method is a Google Pay token and token_type is GOOGLE_PAY.
 */
public class GooglePayTokenDetails {

  @JsonProperty("bin")
  private String bin;
  @JsonProperty("lastDigits")
  private String lastDigits;
  @JsonProperty("expiry")
  private CardExpiry expiry;

  public GooglePayTokenDetails() {
    super();
  }

  private GooglePayTokenDetails(final Builder builder) {
    setBin(builder.bin);
    setLastDigits(builder.lastDigits);
    setExpiry(builder.expiry);
  }

  public static Builder builder() {
    return new Builder();
  }


  public GooglePayTokenDetails bin(String bin) {
    this.bin = bin;
    return this;
  }

  /**
   * The first 6 digits of the Google Pay's DPAN (Device Primary Account Number) - Bank Identification Number (BIN)
   *
   * @return bin
   */
  public String getBin() {
    return bin;
  }

  public void setBin(String bin) {
    this.bin = bin;
  }


  public GooglePayTokenDetails lastDigits(String lastDigits) {
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


  public GooglePayTokenDetails expiry(CardExpiry expiry) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GooglePayTokenDetails googlePayTokenDetails = (GooglePayTokenDetails) o;
    return Objects.equals(this.bin, googlePayTokenDetails.bin) &&
        Objects.equals(this.lastDigits, googlePayTokenDetails.lastDigits) &&
        Objects.equals(this.expiry, googlePayTokenDetails.expiry);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bin, lastDigits, expiry);
  }

  @Override
  public String toString() {

    return "class GooglePayTokenDetails {\n"
        + "    bin: " + toIndentedString(bin) + "\n"
        + "    lastDigits: " + toIndentedString(lastDigits) + "\n"
        + "    expiry: " + toIndentedString(expiry) + "\n"
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
   * Google Pay token information. Returned when the stored payment method is a Google Pay token and token_type is GOOGLE_PAY. builder static inner class.
   */
  public static final class Builder {
    private String bin;
    private String lastDigits;
    private CardExpiry expiry;

    private Builder() {
    }

    /**
     * The first 6 digits of the Google Pay's DPAN (Device Primary Account Number) - Bank Identification Number (BIN)
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
     * Returns a GooglePayTokenDetails built from the parameters previously set.
     *
     * @return a GooglePayTokenDetails built with parameters of this GooglePayTokenDetails.Builder
     */
    public GooglePayTokenDetails build() {
      return new GooglePayTokenDetails(this);
    }
  }
}
