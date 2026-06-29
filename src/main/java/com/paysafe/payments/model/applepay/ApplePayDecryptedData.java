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
import com.paysafe.payments.model.applepay.enums.PaymentDataType;
import com.paysafe.payments.model.common.enums.CurrencyCode;
import com.paysafe.payments.model.payment.Payment;



/**
 * Details of ApplePay Payment token returned by Apple Pay JS
 */
public class ApplePayDecryptedData {

  @JsonProperty("applicationPrimaryAccountNumber")
  private String applicationPrimaryAccountNumber;
  @JsonProperty("applicationExpirationDate")
  private String applicationExpirationDate;
  @JsonProperty("currencyCode")
  private CurrencyCode currencyCode;
  @JsonProperty("transactionAmount")
  private String transactionAmount;
  @JsonProperty("cardholderName")
  private String cardholderName;
  @JsonProperty("deviceManufacturerIdentifier")
  private String deviceManufacturerIdentifier;
  @JsonProperty("paymentDataType")
  private PaymentDataType paymentDataType;
  @JsonProperty("paymentData")
  private ApplePayDecryptedTokenPaymentData paymentData;

  public ApplePayDecryptedData() {
    super();
  }

  private ApplePayDecryptedData(final Builder builder) {
    setApplicationPrimaryAccountNumber(builder.applicationPrimaryAccountNumber);
    setApplicationExpirationDate(builder.applicationExpirationDate);
    setCurrencyCode(builder.currencyCode);
    setTransactionAmount(builder.transactionAmount);
    setCardholderName(builder.cardholderName);
    setDeviceManufacturerIdentifier(builder.deviceManufacturerIdentifier);
    setPaymentDataType(builder.paymentDataType);
    setPaymentData(builder.paymentData);
  }

  public static Builder builder() {
    return new Builder();
  }


  public ApplePayDecryptedData applicationPrimaryAccountNumber(String applicationPrimaryAccountNumber) {
    this.applicationPrimaryAccountNumber = applicationPrimaryAccountNumber;
    return this;
  }

  /**
   * The Device PAN of the ApplePay card
   *
   * @return applicationPrimaryAccountNumber
   */
  public String getApplicationPrimaryAccountNumber() {
    return applicationPrimaryAccountNumber;
  }

  public void setApplicationPrimaryAccountNumber(String applicationPrimaryAccountNumber) {
    this.applicationPrimaryAccountNumber = applicationPrimaryAccountNumber;
  }


  public ApplePayDecryptedData applicationExpirationDate(String applicationExpirationDate) {
    this.applicationExpirationDate = applicationExpirationDate;
    return this;
  }

  /**
   * The expiration date
   *
   * @return applicationExpirationDate
   */
  public String getApplicationExpirationDate() {
    return applicationExpirationDate;
  }

  public void setApplicationExpirationDate(String applicationExpirationDate) {
    this.applicationExpirationDate = applicationExpirationDate;
  }


  public ApplePayDecryptedData currencyCode(CurrencyCode currencyCode) {
    this.currencyCode = currencyCode;
    return this;
  }

  /**
   * Get currencyCode
   *
   * @return currencyCode
   */
  public CurrencyCode getCurrencyCode() {
    return currencyCode;
  }

  public void setCurrencyCode(CurrencyCode currencyCode) {
    this.currencyCode = currencyCode;
  }


  public ApplePayDecryptedData transactionAmount(String transactionAmount) {
    this.transactionAmount = transactionAmount;
    return this;
  }

  /**
   * The transaction amount
   *
   * @return transactionAmount
   */
  public String getTransactionAmount() {
    return transactionAmount;
  }

  public void setTransactionAmount(String transactionAmount) {
    this.transactionAmount = transactionAmount;
  }


  public ApplePayDecryptedData cardholderName(String cardholderName) {
    this.cardholderName = cardholderName;
    return this;
  }

  /**
   * The cardholder's name
   *
   * @return cardholderName
   */
  public String getCardholderName() {
    return cardholderName;
  }

  public void setCardholderName(String cardholderName) {
    this.cardholderName = cardholderName;
  }


  public ApplePayDecryptedData deviceManufacturerIdentifier(String deviceManufacturerIdentifier) {
    this.deviceManufacturerIdentifier = deviceManufacturerIdentifier;
    return this;
  }

  /**
   * The device manufacturer identifier
   *
   * @return deviceManufacturerIdentifier
   */
  public String getDeviceManufacturerIdentifier() {
    return deviceManufacturerIdentifier;
  }

  public void setDeviceManufacturerIdentifier(String deviceManufacturerIdentifier) {
    this.deviceManufacturerIdentifier = deviceManufacturerIdentifier;
  }


  public ApplePayDecryptedData paymentDataType(PaymentDataType paymentDataType) {
    this.paymentDataType = paymentDataType;
    return this;
  }

  /**
   * Get paymentDataType
   *
   * @return paymentDataType
   */
  public PaymentDataType getPaymentDataType() {
    return paymentDataType;
  }

  public void setPaymentDataType(PaymentDataType paymentDataType) {
    this.paymentDataType = paymentDataType;
  }


  public ApplePayDecryptedData paymentData(ApplePayDecryptedTokenPaymentData paymentData) {
    this.paymentData = paymentData;
    return this;
  }

  /**
   * Get paymentData
   *
   * @return paymentData
   */
  public ApplePayDecryptedTokenPaymentData getPaymentData() {
    return paymentData;
  }

  public void setPaymentData(ApplePayDecryptedTokenPaymentData paymentData) {
    this.paymentData = paymentData;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApplePayDecryptedData applePayDecryptedData = (ApplePayDecryptedData) o;
    return Objects.equals(this.applicationPrimaryAccountNumber, applePayDecryptedData.applicationPrimaryAccountNumber) &&
        Objects.equals(this.applicationExpirationDate, applePayDecryptedData.applicationExpirationDate) &&
        Objects.equals(this.currencyCode, applePayDecryptedData.currencyCode) &&
        Objects.equals(this.transactionAmount, applePayDecryptedData.transactionAmount) &&
        Objects.equals(this.cardholderName, applePayDecryptedData.cardholderName) &&
        Objects.equals(this.deviceManufacturerIdentifier, applePayDecryptedData.deviceManufacturerIdentifier) &&
        Objects.equals(this.paymentDataType, applePayDecryptedData.paymentDataType) &&
        Objects.equals(this.paymentData, applePayDecryptedData.paymentData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(applicationPrimaryAccountNumber, applicationExpirationDate, currencyCode, transactionAmount, cardholderName, deviceManufacturerIdentifier, paymentDataType, paymentData);
  }

  @Override
  public String toString() {

    return "class ApplePayDecryptedData {\n"
        + "    applicationPrimaryAccountNumber: " + toIndentedString(applicationPrimaryAccountNumber) + "\n"
        + "    applicationExpirationDate: " + toIndentedString(applicationExpirationDate) + "\n"
        + "    currencyCode: " + toIndentedString(currencyCode) + "\n"
        + "    transactionAmount: " + toIndentedString(transactionAmount) + "\n"
        + "    cardholderName: " + toIndentedString(cardholderName) + "\n"
        + "    deviceManufacturerIdentifier: " + toIndentedString(deviceManufacturerIdentifier) + "\n"
        + "    paymentDataType: " + toIndentedString(paymentDataType) + "\n"
        + "    paymentData: " + toIndentedString(paymentData) + "\n"
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
   * Details of ApplePay Payment token returned by Apple Pay JS builder static inner class.
   */
  public static final class Builder {
    private String applicationPrimaryAccountNumber;
    private String applicationExpirationDate;
    private CurrencyCode currencyCode;
    private String transactionAmount;
    private String cardholderName;
    private String deviceManufacturerIdentifier;
    private PaymentDataType paymentDataType;
    private ApplePayDecryptedTokenPaymentData paymentData;

    private Builder() {
    }

    /**
     * The Device PAN of the ApplePay card
     * <p>
     * Sets the applicationPrimaryAccountNumber and returns a reference to this Builder enabling method chaining.
     *
     * @param applicationPrimaryAccountNumber the applicationPrimaryAccountNumber to set
     * @return a reference to this Builder
     */
    public Builder applicationPrimaryAccountNumber(String applicationPrimaryAccountNumber) {
      this.applicationPrimaryAccountNumber = applicationPrimaryAccountNumber;
      return this;
    }

    /**
     * The expiration date
     * <p>
     * Sets the applicationExpirationDate and returns a reference to this Builder enabling method chaining.
     *
     * @param applicationExpirationDate the applicationExpirationDate to set
     * @return a reference to this Builder
     */
    public Builder applicationExpirationDate(String applicationExpirationDate) {
      this.applicationExpirationDate = applicationExpirationDate;
      return this;
    }

    /**
     * Sets the currencyCode and returns a reference to this Builder enabling method chaining.
     *
     * @param currencyCode the currencyCode to set
     * @return a reference to this Builder
     */
    public Builder currencyCode(CurrencyCode currencyCode) {
      this.currencyCode = currencyCode;
      return this;
    }

    /**
     * The transaction amount
     * <p>
     * Sets the transactionAmount and returns a reference to this Builder enabling method chaining.
     *
     * @param transactionAmount the transactionAmount to set
     * @return a reference to this Builder
     */
    public Builder transactionAmount(String transactionAmount) {
      this.transactionAmount = transactionAmount;
      return this;
    }

    /**
     * The cardholder's name
     * <p>
     * Sets the cardholderName and returns a reference to this Builder enabling method chaining.
     *
     * @param cardholderName the cardholderName to set
     * @return a reference to this Builder
     */
    public Builder cardholderName(String cardholderName) {
      this.cardholderName = cardholderName;
      return this;
    }

    /**
     * The device manufacturer identifier
     * <p>
     * Sets the deviceManufacturerIdentifier and returns a reference to this Builder enabling method chaining.
     *
     * @param deviceManufacturerIdentifier the deviceManufacturerIdentifier to set
     * @return a reference to this Builder
     */
    public Builder deviceManufacturerIdentifier(String deviceManufacturerIdentifier) {
      this.deviceManufacturerIdentifier = deviceManufacturerIdentifier;
      return this;
    }

    /**
     * Sets the paymentDataType and returns a reference to this Builder enabling method chaining.
     *
     * @param paymentDataType the paymentDataType to set
     * @return a reference to this Builder
     */
    public Builder paymentDataType(PaymentDataType paymentDataType) {
      this.paymentDataType = paymentDataType;
      return this;
    }

    /**
     * Sets the paymentData and returns a reference to this Builder enabling method chaining.
     *
     * @param paymentData the paymentData to set
     * @return a reference to this Builder
     */
    public Builder paymentData(ApplePayDecryptedTokenPaymentData paymentData) {
      this.paymentData = paymentData;
      return this;
    }

    /**
     * Returns a ApplePayDecryptedData built from the parameters previously set.
     *
     * @return a ApplePayDecryptedData built with parameters of this ApplePayDecryptedData.Builder
     */
    public ApplePayDecryptedData build() {
      return new ApplePayDecryptedData(this);
    }
  }
}
