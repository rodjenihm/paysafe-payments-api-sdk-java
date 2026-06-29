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
import com.paysafe.payments.model.card.enums.CardStatus;
import com.paysafe.payments.model.card.enums.CardType;



/**
 * Card information.
 */
public class Card {

  @JsonProperty("cardNum")
  private String cardNum;
  @JsonProperty("cardId")
  private String cardId;
  @JsonProperty("cardExpiry")
  private CardExpiry cardExpiry;
  @JsonProperty("cvv")
  private String cvv;
  @JsonProperty("holderName")
  private String holderName;
  @JsonProperty("cardType")
  private CardType cardType;
  @JsonProperty("lastDigits")
  private String lastDigits;
  @JsonProperty("cardBin")
  private String cardBin;
  @JsonProperty("issuingCountry")
  private String issuingCountry;
  @JsonProperty("status")
  private CardStatus status;

  public Card() {
    super();
  }

  private Card(final Builder builder) {
    setCardNum(builder.cardNum);
    setCardId(builder.cardId);
    setCardExpiry(builder.cardExpiry);
    setCvv(builder.cvv);
    setHolderName(builder.holderName);
    setCardType(builder.cardType);
    setLastDigits(builder.lastDigits);
    setCardBin(builder.cardBin);
    setIssuingCountry(builder.issuingCountry);
    setStatus(builder.status);
  }

  public static Builder builder() {
    return new Builder();
  }


  public Card cardNum(String cardNum) {
    this.cardNum = cardNum;
    return this;
  }

  /**
   * The card number used for the request
   *
   * @return cardNum
   */
  public String getCardNum() {
    return cardNum;
  }

  public void setCardNum(String cardNum) {
    this.cardNum = cardNum;
  }


  public Card cardId(String cardId) {
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


  public Card cardExpiry(CardExpiry cardExpiry) {
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


  public Card cvv(String cvv) {
    this.cvv = cvv;
    return this;
  }

  /**
   * The 3- or 4-digit security code that appears on the card following the card number
   *
   * @return cvv
   */
  public String getCvv() {
    return cvv;
  }

  public void setCvv(String cvv) {
    this.cvv = cvv;
  }


  public Card holderName(String holderName) {
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


  public Card cardType(CardType cardType) {
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


  public Card lastDigits(String lastDigits) {
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


  public Card cardBin(String cardBin) {
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


  public Card issuingCountry(String issuingCountry) {
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


  public Card status(CardStatus status) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Card card = (Card) o;
    return Objects.equals(this.cardNum, card.cardNum) &&
        Objects.equals(this.cardId, card.cardId) &&
        Objects.equals(this.cardExpiry, card.cardExpiry) &&
        Objects.equals(this.cvv, card.cvv) &&
        Objects.equals(this.holderName, card.holderName) &&
        Objects.equals(this.cardType, card.cardType) &&
        Objects.equals(this.lastDigits, card.lastDigits) &&
        Objects.equals(this.cardBin, card.cardBin) &&
        Objects.equals(this.issuingCountry, card.issuingCountry) &&
        Objects.equals(this.status, card.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cardNum, cardId, cardExpiry, cvv, holderName, cardType, lastDigits, cardBin, issuingCountry, status);
  }

  @Override
  public String toString() {

    return "class Card {\n"
        + "    cardNum: " + toIndentedString(cardNum) + "\n"
        + "    cardId: " + toIndentedString(cardId) + "\n"
        + "    cardExpiry: " + toIndentedString(cardExpiry) + "\n"
        + "    cvv: " + toIndentedString(cvv) + "\n"
        + "    holderName: " + toIndentedString(holderName) + "\n"
        + "    cardType: " + toIndentedString(cardType) + "\n"
        + "    lastDigits: " + toIndentedString(lastDigits) + "\n"
        + "    cardBin: " + toIndentedString(cardBin) + "\n"
        + "    issuingCountry: " + toIndentedString(issuingCountry) + "\n"
        + "    status: " + toIndentedString(status) + "\n"
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
   * Card information. builder static inner class.
   */
  public static final class Builder {
    private String cardNum;
    private String cardId;
    private CardExpiry cardExpiry;
    private String cvv;
    private String holderName;
    private CardType cardType;
    private String lastDigits;
    private String cardBin;
    private String issuingCountry;
    private CardStatus status;

    private Builder() {
    }

    /**
     * The card number used for the request
     * <p>
     * Sets the cardNum and returns a reference to this Builder enabling method chaining.
     *
     * @param cardNum the cardNum to set
     * @return a reference to this Builder
     */
    public Builder cardNum(String cardNum) {
      this.cardNum = cardNum;
      return this;
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
     * The 3- or 4-digit security code that appears on the card following the card number
     * <p>
     * Sets the cvv and returns a reference to this Builder enabling method chaining.
     *
     * @param cvv the cvv to set
     * @return a reference to this Builder
     */
    public Builder cvv(String cvv) {
      this.cvv = cvv;
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
     * Returns a Card built from the parameters previously set.
     *
     * @return a Card built with parameters of this Card.Builder
     */
    public Card build() {
      return new Card(this);
    }
  }
}
