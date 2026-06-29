// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.model.card;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.paysafe.payments.model.common.enums.NetworkTokenStatus;



/**
 * Holds network token fields.
 */
public class NetworkToken {

  @JsonProperty("bin")
  private String bin;
  @JsonProperty("lastDigits")
  private String lastDigits;
  @JsonProperty("status")
  private NetworkTokenStatus status;
  @JsonProperty("expiry")
  private CardExpiry expiry;
  @JsonProperty("cardArt")
  private NetworkTokenCardArt cardArt;

  public NetworkToken() {
    super();
  }

  private NetworkToken(final Builder builder) {
    setBin(builder.bin);
    setLastDigits(builder.lastDigits);
    setStatus(builder.status);
    setExpiry(builder.expiry);
    setCardArt(builder.cardArt);
  }

  public static Builder builder() {
    return new Builder();
  }


  public NetworkToken bin(String bin) {
    this.bin = bin;
    return this;
  }

  /**
   * These are the first 6 digits of the network token. Example: 411111
   *
   * @return bin
   */
  public String getBin() {
    return bin;
  }

  public void setBin(String bin) {
    this.bin = bin;
  }


  public NetworkToken lastDigits(String lastDigits) {
    this.lastDigits = lastDigits;
    return this;
  }

  /**
   * These are the last four digits of the network token. Example: 6585
   *
   * @return lastDigits
   */
  public String getLastDigits() {
    return lastDigits;
  }

  public void setLastDigits(String lastDigits) {
    this.lastDigits = lastDigits;
  }


  public NetworkToken status(NetworkTokenStatus status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   *
   * @return status
   */
  public NetworkTokenStatus getStatus() {
    return status;
  }

  public void setStatus(NetworkTokenStatus status) {
    this.status = status;
  }


  public NetworkToken expiry(CardExpiry expiry) {
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


  public NetworkToken cardArt(NetworkTokenCardArt cardArt) {
    this.cardArt = cardArt;
    return this;
  }

  /**
   * Get cardArt
   *
   * @return cardArt
   */
  public NetworkTokenCardArt getCardArt() {
    return cardArt;
  }

  public void setCardArt(NetworkTokenCardArt cardArt) {
    this.cardArt = cardArt;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NetworkToken networkToken = (NetworkToken) o;
    return Objects.equals(this.bin, networkToken.bin) &&
        Objects.equals(this.lastDigits, networkToken.lastDigits) &&
        Objects.equals(this.status, networkToken.status) &&
        Objects.equals(this.expiry, networkToken.expiry) &&
        Objects.equals(this.cardArt, networkToken.cardArt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bin, lastDigits, status, expiry, cardArt);
  }

  @Override
  public String toString() {

    return "class NetworkToken {\n"
        + "    bin: " + toIndentedString(bin) + "\n"
        + "    lastDigits: " + toIndentedString(lastDigits) + "\n"
        + "    status: " + toIndentedString(status) + "\n"
        + "    expiry: " + toIndentedString(expiry) + "\n"
        + "    cardArt: " + toIndentedString(cardArt) + "\n"
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
   * Holds network token fields. builder static inner class.
   */
  public static final class Builder {
    private String bin;
    private String lastDigits;
    private NetworkTokenStatus status;
    private CardExpiry expiry;
    private NetworkTokenCardArt cardArt;

    private Builder() {
    }

    /**
     * These are the first 6 digits of the network token. Example: 411111
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
     * These are the last four digits of the network token. Example: 6585
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
     * Sets the status and returns a reference to this Builder enabling method chaining.
     *
     * @param status the status to set
     * @return a reference to this Builder
     */
    public Builder status(NetworkTokenStatus status) {
      this.status = status;
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
     * Sets the cardArt and returns a reference to this Builder enabling method chaining.
     *
     * @param cardArt the cardArt to set
     * @return a reference to this Builder
     */
    public Builder cardArt(NetworkTokenCardArt cardArt) {
      this.cardArt = cardArt;
      return this;
    }

    /**
     * Returns a NetworkToken built from the parameters previously set.
     *
     * @return a NetworkToken built with parameters of this NetworkToken.Builder
     */
    public NetworkToken build() {
      return new NetworkToken(this);
    }
  }
}
