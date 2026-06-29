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
 * Holds network token card art fields.
 */
public class NetworkTokenCardArt {

  @JsonProperty("cardArtUrl")
  private String cardArtUrl;
  @JsonProperty("isCobranded")
  private Boolean isCobranded;
  @JsonProperty("cobrandName")
  private String cobrandName;

  public NetworkTokenCardArt() {
    super();
  }

  private NetworkTokenCardArt(final Builder builder) {
    setCardArtUrl(builder.cardArtUrl);
    setIsCobranded(builder.isCobranded);
    setCobrandName(builder.cobrandName);
  }

  public static Builder builder() {
    return new Builder();
  }


  public NetworkTokenCardArt cardArtUrl(String cardArtUrl) {
    this.cardArtUrl = cardArtUrl;
    return this;
  }

  /**
   * The url for loading the card art url
   *
   * @return cardArtUrl
   */
  public String getCardArtUrl() {
    return cardArtUrl;
  }

  public void setCardArtUrl(String cardArtUrl) {
    this.cardArtUrl = cardArtUrl;
  }


  public NetworkTokenCardArt isCobranded(Boolean isCobranded) {
    this.isCobranded = isCobranded;
    return this;
  }

  /**
   * Boolean value whether the card is cobranded
   *
   * @return isCobranded
   */
  public Boolean getIsCobranded() {
    return isCobranded;
  }

  public void setIsCobranded(Boolean isCobranded) {
    this.isCobranded = isCobranded;
  }


  public NetworkTokenCardArt cobrandName(String cobrandName) {
    this.cobrandName = cobrandName;
    return this;
  }

  /**
   * The name of the cobrand
   *
   * @return cobrandName
   */
  public String getCobrandName() {
    return cobrandName;
  }

  public void setCobrandName(String cobrandName) {
    this.cobrandName = cobrandName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NetworkTokenCardArt networkTokenCardArt = (NetworkTokenCardArt) o;
    return Objects.equals(this.cardArtUrl, networkTokenCardArt.cardArtUrl) &&
        Objects.equals(this.isCobranded, networkTokenCardArt.isCobranded) &&
        Objects.equals(this.cobrandName, networkTokenCardArt.cobrandName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cardArtUrl, isCobranded, cobrandName);
  }

  @Override
  public String toString() {

    return "class NetworkTokenCardArt {\n"
        + "    cardArtUrl: " + toIndentedString(cardArtUrl) + "\n"
        + "    isCobranded: " + toIndentedString(isCobranded) + "\n"
        + "    cobrandName: " + toIndentedString(cobrandName) + "\n"
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
   * Holds network token card art fields. builder static inner class.
   */
  public static final class Builder {
    private String cardArtUrl;
    private Boolean isCobranded;
    private String cobrandName;

    private Builder() {
    }

    /**
     * The url for loading the card art url
     * <p>
     * Sets the cardArtUrl and returns a reference to this Builder enabling method chaining.
     *
     * @param cardArtUrl the cardArtUrl to set
     * @return a reference to this Builder
     */
    public Builder cardArtUrl(String cardArtUrl) {
      this.cardArtUrl = cardArtUrl;
      return this;
    }

    /**
     * Boolean value whether the card is cobranded
     * <p>
     * Sets the isCobranded and returns a reference to this Builder enabling method chaining.
     *
     * @param isCobranded the isCobranded to set
     * @return a reference to this Builder
     */
    public Builder isCobranded(Boolean isCobranded) {
      this.isCobranded = isCobranded;
      return this;
    }

    /**
     * The name of the cobrand
     * <p>
     * Sets the cobrandName and returns a reference to this Builder enabling method chaining.
     *
     * @param cobrandName the cobrandName to set
     * @return a reference to this Builder
     */
    public Builder cobrandName(String cobrandName) {
      this.cobrandName = cobrandName;
      return this;
    }

    /**
     * Returns a NetworkTokenCardArt built from the parameters previously set.
     *
     * @return a NetworkTokenCardArt built with parameters of this NetworkTokenCardArt.Builder
     */
    public NetworkTokenCardArt build() {
      return new NetworkTokenCardArt(this);
    }
  }
}
