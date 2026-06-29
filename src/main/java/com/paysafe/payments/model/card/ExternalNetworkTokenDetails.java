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



/**
 * External network token information. Returned when the stored payment method is an external network token and token_type is NETWORK_TOKEN.
 */
public class ExternalNetworkTokenDetails {

  @JsonProperty("token")
  private String token;
  @JsonProperty("cryptogram")
  private String cryptogram;
  @JsonProperty("expiry")
  private CardExpiry expiry;

  public ExternalNetworkTokenDetails() {
    super();
  }

  private ExternalNetworkTokenDetails(final Builder builder) {
    setToken(builder.token);
    setCryptogram(builder.cryptogram);
    setExpiry(builder.expiry);
  }

  public static Builder builder() {
    return new Builder();
  }


  public ExternalNetworkTokenDetails token(String token) {
    this.token = token;
    return this;
  }

  /**
   * This is the actual network token.
   *
   * @return token
   */
  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }


  public ExternalNetworkTokenDetails cryptogram(String cryptogram) {
    this.cryptogram = cryptogram;
    return this;
  }

  /**
   * This is the cryptogram that will be used.
   *
   * @return cryptogram
   */
  public String getCryptogram() {
    return cryptogram;
  }

  public void setCryptogram(String cryptogram) {
    this.cryptogram = cryptogram;
  }


  public ExternalNetworkTokenDetails expiry(CardExpiry expiry) {
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
    ExternalNetworkTokenDetails externalNetworkTokenDetails = (ExternalNetworkTokenDetails) o;
    return Objects.equals(this.token, externalNetworkTokenDetails.token) &&
        Objects.equals(this.cryptogram, externalNetworkTokenDetails.cryptogram) &&
        Objects.equals(this.expiry, externalNetworkTokenDetails.expiry);
  }

  @Override
  public int hashCode() {
    return Objects.hash(token, cryptogram, expiry);
  }

  @Override
  public String toString() {

    return "class ExternalNetworkTokenDetails {\n"
        + "    token: " + toIndentedString(token) + "\n"
        + "    cryptogram: " + toIndentedString(cryptogram) + "\n"
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
   * External network token information. Returned when the stored payment method is an external network token and token_type is NETWORK_TOKEN. builder static inner class.
   */
  public static final class Builder {
    private String token;
    private String cryptogram;
    private CardExpiry expiry;

    private Builder() {
    }

    /**
     * This is the actual network token.
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
     * This is the cryptogram that will be used.
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
     * Returns a ExternalNetworkTokenDetails built from the parameters previously set.
     *
     * @return a ExternalNetworkTokenDetails built with parameters of this ExternalNetworkTokenDetails.Builder
     */
    public ExternalNetworkTokenDetails build() {
      return new ExternalNetworkTokenDetails(this);
    }
  }
}
