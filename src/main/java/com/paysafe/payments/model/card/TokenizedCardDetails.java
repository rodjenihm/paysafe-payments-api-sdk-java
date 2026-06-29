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
import com.paysafe.payments.model.applepay.ApplePayTokenDetails;
import com.paysafe.payments.model.card.enums.CardCategory;
import com.paysafe.payments.model.card.enums.CardStatus;
import com.paysafe.payments.model.card.enums.CardType;
import com.paysafe.payments.model.card.enums.TokenType;
import com.paysafe.payments.model.googlepay.GooglePayTokenDetails;



/**
 * Card information with tokenized card details including optional network token or Apple Pay details.
 */
public class TokenizedCardDetails {

  @JsonProperty("cardId")
  private String cardId;
  @JsonProperty("cardExpiry")
  private CardExpiry cardExpiry;
  @JsonProperty("holderName")
  private String holderName;
  @JsonProperty("cardType")
  private CardType cardType;
  @JsonProperty("lastDigits")
  private String lastDigits;
  @JsonProperty("cardBin")
  private String cardBin;
  @JsonProperty("cardCategory")
  private CardCategory cardCategory;
  @JsonProperty("issuingCountry")
  private String issuingCountry;
  @JsonProperty("status")
  private CardStatus status;
  @JsonProperty("networkToken")
  private NetworkToken networkToken;
  @JsonProperty("tokenType")
  private TokenType tokenType;
  @JsonProperty("applePay")
  private ApplePayTokenDetails applePay;
  @JsonProperty("googlePay")
  private GooglePayTokenDetails googlePay;

  public TokenizedCardDetails() {
    super();
  }

  private TokenizedCardDetails(final Builder builder) {
    setCardId(builder.cardId);
    setCardExpiry(builder.cardExpiry);
    setHolderName(builder.holderName);
    setCardType(builder.cardType);
    setLastDigits(builder.lastDigits);
    setCardBin(builder.cardBin);
    setCardCategory(builder.cardCategory);
    setIssuingCountry(builder.issuingCountry);
    setStatus(builder.status);
    setNetworkToken(builder.networkToken);
    setTokenType(builder.tokenType);
    setApplePay(builder.applePay);
    setGooglePay(builder.googlePay);
  }

  public static Builder builder() {
    return new Builder();
  }


  public TokenizedCardDetails cardId(String cardId) {
    this.cardId = cardId;
    return this;
  }

  /**
   * The card id returned in the response during save card flow
   *
   * @return cardId
   */
  public String getCardId() {
    return cardId;
  }

  public void setCardId(String cardId) {
    this.cardId = cardId;
  }


  public TokenizedCardDetails cardExpiry(CardExpiry cardExpiry) {
    this.cardExpiry = cardExpiry;
    return this;
  }

  /**
   * Get cardExpiry
   *
   * @return cardExpiry
   */
  public CardExpiry getCardExpiry() {
    return cardExpiry;
  }

  public void setCardExpiry(CardExpiry cardExpiry) {
    this.cardExpiry = cardExpiry;
  }


  public TokenizedCardDetails holderName(String holderName) {
    this.holderName = holderName;
    return this;
  }

  /**
   * The name of the cardholder
   *
   * @return holderName
   */
  public String getHolderName() {
    return holderName;
  }

  public void setHolderName(String holderName) {
    this.holderName = holderName;
  }


  public TokenizedCardDetails cardType(CardType cardType) {
    this.cardType = cardType;
    return this;
  }

  /**
   * Get cardType
   *
   * @return cardType
   */
  public CardType getCardType() {
    return cardType;
  }

  public void setCardType(CardType cardType) {
    this.cardType = cardType;
  }


  public TokenizedCardDetails lastDigits(String lastDigits) {
    this.lastDigits = lastDigits;
    return this;
  }

  /**
   * The last four digits of the card used for the request
   *
   * @return lastDigits
   */
  public String getLastDigits() {
    return lastDigits;
  }

  public void setLastDigits(String lastDigits) {
    this.lastDigits = lastDigits;
  }


  public TokenizedCardDetails cardBin(String cardBin) {
    this.cardBin = cardBin;
    return this;
  }

  /**
   * The first 6 digits of the card Bank Identification Number (BIN)
   *
   * @return cardBin
   */
  public String getCardBin() {
    return cardBin;
  }

  public void setCardBin(String cardBin) {
    this.cardBin = cardBin;
  }


  public TokenizedCardDetails cardCategory(CardCategory cardCategory) {
    this.cardCategory = cardCategory;
    return this;
  }

  /**
   * Get cardCategory
   *
   * @return cardCategory
   */
  public CardCategory getCardCategory() {
    return cardCategory;
  }

  public void setCardCategory(CardCategory cardCategory) {
    this.cardCategory = cardCategory;
  }


  public TokenizedCardDetails issuingCountry(String issuingCountry) {
    this.issuingCountry = issuingCountry;
    return this;
  }

  /**
   * The card issuing country
   *
   * @return issuingCountry
   */
  public String getIssuingCountry() {
    return issuingCountry;
  }

  public void setIssuingCountry(String issuingCountry) {
    this.issuingCountry = issuingCountry;
  }


  public TokenizedCardDetails status(CardStatus status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   *
   * @return status
   */
  public CardStatus getStatus() {
    return status;
  }

  public void setStatus(CardStatus status) {
    this.status = status;
  }


  public TokenizedCardDetails networkToken(NetworkToken networkToken) {
    this.networkToken = networkToken;
    return this;
  }

  /**
   * Get networkToken
   *
   * @return networkToken
   */
  public NetworkToken getNetworkToken() {
    return networkToken;
  }

  public void setNetworkToken(NetworkToken networkToken) {
    this.networkToken = networkToken;
  }


  public TokenizedCardDetails tokenType(TokenType tokenType) {
    this.tokenType = tokenType;
    return this;
  }

  /**
   * Get tokenType
   *
   * @return tokenType
   */
  public TokenType getTokenType() {
    return tokenType;
  }

  public void setTokenType(TokenType tokenType) {
    this.tokenType = tokenType;
  }


  public TokenizedCardDetails applePay(ApplePayTokenDetails applePay) {
    this.applePay = applePay;
    return this;
  }

  /**
   * Get applePay
   *
   * @return applePay
   */
  public ApplePayTokenDetails getApplePay() {
    return applePay;
  }

  public void setApplePay(ApplePayTokenDetails applePay) {
    this.applePay = applePay;
  }


  public TokenizedCardDetails googlePay(GooglePayTokenDetails googlePay) {
    this.googlePay = googlePay;
    return this;
  }

  /**
   * Get googlePay
   *
   * @return googlePay
   */
  public GooglePayTokenDetails getGooglePay() {
    return googlePay;
  }

  public void setGooglePay(GooglePayTokenDetails googlePay) {
    this.googlePay = googlePay;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TokenizedCardDetails tokenizedCardDetails = (TokenizedCardDetails) o;
    return Objects.equals(this.cardId, tokenizedCardDetails.cardId) &&
        Objects.equals(this.cardExpiry, tokenizedCardDetails.cardExpiry) &&
        Objects.equals(this.holderName, tokenizedCardDetails.holderName) &&
        Objects.equals(this.cardType, tokenizedCardDetails.cardType) &&
        Objects.equals(this.lastDigits, tokenizedCardDetails.lastDigits) &&
        Objects.equals(this.cardBin, tokenizedCardDetails.cardBin) &&
        Objects.equals(this.cardCategory, tokenizedCardDetails.cardCategory) &&
        Objects.equals(this.issuingCountry, tokenizedCardDetails.issuingCountry) &&
        Objects.equals(this.status, tokenizedCardDetails.status) &&
        Objects.equals(this.networkToken, tokenizedCardDetails.networkToken) &&
        Objects.equals(this.tokenType, tokenizedCardDetails.tokenType) &&
        Objects.equals(this.applePay, tokenizedCardDetails.applePay) &&
        Objects.equals(this.googlePay, tokenizedCardDetails.googlePay);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cardId, cardExpiry, holderName, cardType, lastDigits, cardBin, cardCategory, issuingCountry, status, networkToken, tokenType, applePay, googlePay);
  }

  @Override
  public String toString() {

    return "class TokenizedCardDetails {\n"
        + "    cardId: " + toIndentedString(cardId) + "\n"
        + "    cardExpiry: " + toIndentedString(cardExpiry) + "\n"
        + "    holderName: " + toIndentedString(holderName) + "\n"
        + "    cardType: " + toIndentedString(cardType) + "\n"
        + "    lastDigits: " + toIndentedString(lastDigits) + "\n"
        + "    cardBin: " + toIndentedString(cardBin) + "\n"
        + "    cardCategory: " + toIndentedString(cardCategory) + "\n"
        + "    issuingCountry: " + toIndentedString(issuingCountry) + "\n"
        + "    status: " + toIndentedString(status) + "\n"
        + "    networkToken: " + toIndentedString(networkToken) + "\n"
        + "    tokenType: " + toIndentedString(tokenType) + "\n"
        + "    applePay: " + toIndentedString(applePay) + "\n"
        + "    googlePay: " + toIndentedString(googlePay) + "\n"
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
   * Card information with tokenized card details including optional network token or Apple Pay details. builder static inner class.
   */
  public static final class Builder {
    private String cardId;
    private CardExpiry cardExpiry;
    private String holderName;
    private CardType cardType;
    private String lastDigits;
    private String cardBin;
    private CardCategory cardCategory;
    private String issuingCountry;
    private CardStatus status;
    private NetworkToken networkToken;
    private TokenType tokenType;
    private ApplePayTokenDetails applePay;
    private GooglePayTokenDetails googlePay;

    private Builder() {
    }

    /**
     * The card id returned in the response during save card flow
     * <p>
     * Sets the cardId and returns a reference to this Builder enabling method chaining.
     *
     * @param cardId the cardId to set
     * @return a reference to this Builder
     */
    public Builder cardId(String cardId) {
      this.cardId = cardId;
      return this;
    }

    /**
     * Sets the cardExpiry and returns a reference to this Builder enabling method chaining.
     *
     * @param cardExpiry the cardExpiry to set
     * @return a reference to this Builder
     */
    public Builder cardExpiry(CardExpiry cardExpiry) {
      this.cardExpiry = cardExpiry;
      return this;
    }

    /**
     * The name of the cardholder
     * <p>
     * Sets the holderName and returns a reference to this Builder enabling method chaining.
     *
     * @param holderName the holderName to set
     * @return a reference to this Builder
     */
    public Builder holderName(String holderName) {
      this.holderName = holderName;
      return this;
    }

    /**
     * Sets the cardType and returns a reference to this Builder enabling method chaining.
     *
     * @param cardType the cardType to set
     * @return a reference to this Builder
     */
    public Builder cardType(CardType cardType) {
      this.cardType = cardType;
      return this;
    }

    /**
     * The last four digits of the card used for the request
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
     * The first 6 digits of the card Bank Identification Number (BIN)
     * <p>
     * Sets the cardBin and returns a reference to this Builder enabling method chaining.
     *
     * @param cardBin the cardBin to set
     * @return a reference to this Builder
     */
    public Builder cardBin(String cardBin) {
      this.cardBin = cardBin;
      return this;
    }

    /**
     * Sets the cardCategory and returns a reference to this Builder enabling method chaining.
     *
     * @param cardCategory the cardCategory to set
     * @return a reference to this Builder
     */
    public Builder cardCategory(CardCategory cardCategory) {
      this.cardCategory = cardCategory;
      return this;
    }

    /**
     * The card issuing country
     * <p>
     * Sets the issuingCountry and returns a reference to this Builder enabling method chaining.
     *
     * @param issuingCountry the issuingCountry to set
     * @return a reference to this Builder
     */
    public Builder issuingCountry(String issuingCountry) {
      this.issuingCountry = issuingCountry;
      return this;
    }

    /**
     * Sets the status and returns a reference to this Builder enabling method chaining.
     *
     * @param status the status to set
     * @return a reference to this Builder
     */
    public Builder status(CardStatus status) {
      this.status = status;
      return this;
    }

    /**
     * Sets the networkToken and returns a reference to this Builder enabling method chaining.
     *
     * @param networkToken the networkToken to set
     * @return a reference to this Builder
     */
    public Builder networkToken(NetworkToken networkToken) {
      this.networkToken = networkToken;
      return this;
    }

    /**
     * Sets the tokenType and returns a reference to this Builder enabling method chaining.
     *
     * @param tokenType the tokenType to set
     * @return a reference to this Builder
     */
    public Builder tokenType(TokenType tokenType) {
      this.tokenType = tokenType;
      return this;
    }

    /**
     * Sets the applePay and returns a reference to this Builder enabling method chaining.
     *
     * @param applePay the applePay to set
     * @return a reference to this Builder
     */
    public Builder applePay(ApplePayTokenDetails applePay) {
      this.applePay = applePay;
      return this;
    }

    /**
     * Sets the googlePay and returns a reference to this Builder enabling method chaining.
     *
     * @param googlePay the googlePay to set
     * @return a reference to this Builder
     */
    public Builder googlePay(GooglePayTokenDetails googlePay) {
      this.googlePay = googlePay;
      return this;
    }

    /**
     * Returns a TokenizedCardDetails built from the parameters previously set.
     *
     * @return a TokenizedCardDetails built with parameters of this TokenizedCardDetails.Builder
     */
    public TokenizedCardDetails build() {
      return new TokenizedCardDetails(this);
    }
  }
}
