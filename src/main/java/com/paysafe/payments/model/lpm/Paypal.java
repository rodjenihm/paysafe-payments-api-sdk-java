// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.model.lpm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.paysafe.payments.model.lpm.enums.LanguageCode;
import com.paysafe.payments.model.lpm.enums.PaypalShippingReference;
import com.paysafe.payments.model.lpm.enums.RecipientType;
import com.paysafe.payments.model.payment.Payment;



/**
 * These are the details of the PayPal account used for the transaction.
 */
public class Paypal {

  @JsonProperty("consumerId")
  private String consumerId;
  @JsonProperty("recipientDescription")
  private String recipientDescription;
  @JsonProperty("language")
  private LanguageCode language;
  @JsonProperty("shippingPreference")
  private PaypalShippingReference shippingPreference;
  @JsonProperty("consumerMessage")
  private String consumerMessage;
  @JsonProperty("orderDescription")
  private String orderDescription;
  @JsonProperty("recipientType")
  private RecipientType recipientType;

  public Paypal() {
    super();
  }

  private Paypal(final Builder builder) {
    setConsumerId(builder.consumerId);
    setRecipientDescription(builder.recipientDescription);
    setLanguage(builder.language);
    setShippingPreference(builder.shippingPreference);
    setConsumerMessage(builder.consumerMessage);
    setOrderDescription(builder.orderDescription);
    setRecipientType(builder.recipientType);
  }

  public static Builder builder() {
    return new Builder();
  }


  public Paypal consumerId(String consumerId) {
    this.consumerId = consumerId;
    return this;
  }

  /**
   * The email address of the consumer or payer
   *
   * @return consumerId
   */
  public String getConsumerId() {
    return consumerId;
  }

  public void setConsumerId(String consumerId) {
    this.consumerId = consumerId;
  }


  public Paypal recipientDescription(String recipientDescription) {
    this.recipientDescription = recipientDescription;
    return this;
  }

  /**
   * A label that overrides the business name in the merchant's PayPal account on the PayPal checkout pages
   *
   * @return recipientDescription
   */
  public String getRecipientDescription() {
    return recipientDescription;
  }

  public void setRecipientDescription(String recipientDescription) {
    this.recipientDescription = recipientDescription;
  }


  public Paypal language(LanguageCode language) {
    this.language = language;
    return this;
  }

  /**
   * Get language
   *
   * @return language
   */
  public LanguageCode getLanguage() {
    return language;
  }

  public void setLanguage(LanguageCode language) {
    this.language = language;
  }


  public Paypal shippingPreference(PaypalShippingReference shippingPreference) {
    this.shippingPreference = shippingPreference;
    return this;
  }

  /**
   * Get shippingPreference
   *
   * @return shippingPreference
   */
  public PaypalShippingReference getShippingPreference() {
    return shippingPreference;
  }

  public void setShippingPreference(PaypalShippingReference shippingPreference) {
    this.shippingPreference = shippingPreference;
  }


  public Paypal consumerMessage(String consumerMessage) {
    this.consumerMessage = consumerMessage;
    return this;
  }

  /**
   * Note to be displayed on the PayPal page
   *
   * @return consumerMessage
   */
  public String getConsumerMessage() {
    return consumerMessage;
  }

  public void setConsumerMessage(String consumerMessage) {
    this.consumerMessage = consumerMessage;
  }


  public Paypal orderDescription(String orderDescription) {
    this.orderDescription = orderDescription;
    return this;
  }

  /**
   * Order description to display on PayPal page. If merchant does not set this field it defaults to 'Payment for order'
   *
   * @return orderDescription
   */
  public String getOrderDescription() {
    return orderDescription;
  }

  public void setOrderDescription(String orderDescription) {
    this.orderDescription = orderDescription;
  }


  public Paypal recipientType(RecipientType recipientType) {
    this.recipientType = recipientType;
    return this;
  }

  /**
   * Get recipientType
   *
   * @return recipientType
   */
  public RecipientType getRecipientType() {
    return recipientType;
  }

  public void setRecipientType(RecipientType recipientType) {
    this.recipientType = recipientType;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Paypal paypal = (Paypal) o;
    return Objects.equals(this.consumerId, paypal.consumerId) &&
        Objects.equals(this.recipientDescription, paypal.recipientDescription) &&
        Objects.equals(this.language, paypal.language) &&
        Objects.equals(this.shippingPreference, paypal.shippingPreference) &&
        Objects.equals(this.consumerMessage, paypal.consumerMessage) &&
        Objects.equals(this.orderDescription, paypal.orderDescription) &&
        Objects.equals(this.recipientType, paypal.recipientType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(consumerId, recipientDescription, language, shippingPreference, consumerMessage, orderDescription, recipientType);
  }

  @Override
  public String toString() {

    return "class Paypal {\n"
        + "    consumerId: " + toIndentedString(consumerId) + "\n"
        + "    recipientDescription: " + toIndentedString(recipientDescription) + "\n"
        + "    language: " + toIndentedString(language) + "\n"
        + "    shippingPreference: " + toIndentedString(shippingPreference) + "\n"
        + "    consumerMessage: " + toIndentedString(consumerMessage) + "\n"
        + "    orderDescription: " + toIndentedString(orderDescription) + "\n"
        + "    recipientType: " + toIndentedString(recipientType) + "\n"
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
   * These are the details of the PayPal account used for the transaction. builder static inner class.
   */
  public static final class Builder {
    private String consumerId;
    private String recipientDescription;
    private LanguageCode language;
    private PaypalShippingReference shippingPreference;
    private String consumerMessage;
    private String orderDescription;
    private RecipientType recipientType;

    private Builder() {
    }

    /**
     * The email address of the consumer or payer
     * <p>
     * Sets the consumerId and returns a reference to this Builder enabling method chaining.
     *
     * @param consumerId the consumerId to set
     * @return a reference to this Builder
     */
    public Builder consumerId(String consumerId) {
      this.consumerId = consumerId;
      return this;
    }

    /**
     * A label that overrides the business name in the merchant's PayPal account on the PayPal checkout pages
     * <p>
     * Sets the recipientDescription and returns a reference to this Builder enabling method chaining.
     *
     * @param recipientDescription the recipientDescription to set
     * @return a reference to this Builder
     */
    public Builder recipientDescription(String recipientDescription) {
      this.recipientDescription = recipientDescription;
      return this;
    }

    /**
     * Sets the language and returns a reference to this Builder enabling method chaining.
     *
     * @param language the language to set
     * @return a reference to this Builder
     */
    public Builder language(LanguageCode language) {
      this.language = language;
      return this;
    }

    /**
     * Sets the shippingPreference and returns a reference to this Builder enabling method chaining.
     *
     * @param shippingPreference the shippingPreference to set
     * @return a reference to this Builder
     */
    public Builder shippingPreference(PaypalShippingReference shippingPreference) {
      this.shippingPreference = shippingPreference;
      return this;
    }

    /**
     * Note to be displayed on the PayPal page
     * <p>
     * Sets the consumerMessage and returns a reference to this Builder enabling method chaining.
     *
     * @param consumerMessage the consumerMessage to set
     * @return a reference to this Builder
     */
    public Builder consumerMessage(String consumerMessage) {
      this.consumerMessage = consumerMessage;
      return this;
    }

    /**
     * Order description to display on PayPal page. If merchant does not set this field it defaults to 'Payment for order'
     * <p>
     * Sets the orderDescription and returns a reference to this Builder enabling method chaining.
     *
     * @param orderDescription the orderDescription to set
     * @return a reference to this Builder
     */
    public Builder orderDescription(String orderDescription) {
      this.orderDescription = orderDescription;
      return this;
    }

    /**
     * Sets the recipientType and returns a reference to this Builder enabling method chaining.
     *
     * @param recipientType the recipientType to set
     * @return a reference to this Builder
     */
    public Builder recipientType(RecipientType recipientType) {
      this.recipientType = recipientType;
      return this;
    }

    /**
     * Returns a Paypal built from the parameters previously set.
     *
     * @return a Paypal built with parameters of this Paypal.Builder
     */
    public Paypal build() {
      return new Paypal(this);
    }
  }
}
