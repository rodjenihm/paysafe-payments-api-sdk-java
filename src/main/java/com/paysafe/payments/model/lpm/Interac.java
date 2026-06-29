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
import com.paysafe.payments.model.customer.Customer;
import com.paysafe.payments.model.lpm.enums.InteracFraudStatus;
import com.paysafe.payments.model.lpm.enums.InteracFraudType;
import com.paysafe.payments.model.lpm.enums.InteracMethod;
import com.paysafe.payments.model.lpm.enums.InteracTransferType;
import com.paysafe.payments.model.payment.Payment;



/**
 * Details of the interac E-Transfer used for the transaction.
 */
public class Interac {

  @JsonProperty("consumerId")
  private String consumerId;
  @JsonProperty("type")
  private String type = "EMAIL";
  @JsonProperty("question")
  private String question;
  @JsonProperty("answer")
  private String answer;
  @JsonProperty("transferType")
  private InteracTransferType transferType;
  @JsonProperty("maxAmount")
  private Integer maxAmount;
  @JsonProperty("fraudStatus")
  private InteracFraudStatus fraudStatus;
  @JsonProperty("fraudType")
  private InteracFraudType fraudType;
  @JsonProperty("paymentReference")
  private String paymentReference;
  @JsonProperty("method")
  private InteracMethod method;
  @JsonProperty("paymentRefExpiryMinutes")
  private Integer paymentRefExpiryMinutes;

  public Interac() {
    super();
  }

  private Interac(final Builder builder) {
    setConsumerId(builder.consumerId);
    setType(builder.type);
    setQuestion(builder.question);
    setAnswer(builder.answer);
    setTransferType(builder.transferType);
    setMaxAmount(builder.maxAmount);
    setFraudStatus(builder.fraudStatus);
    setFraudType(builder.fraudType);
    setPaymentReference(builder.paymentReference);
    setMethod(builder.method);
    setPaymentRefExpiryMinutes(builder.paymentRefExpiryMinutes);
  }

  public static Builder builder() {
    return new Builder();
  }


  public Interac consumerId(String consumerId) {
    this.consumerId = consumerId;
    return this;
  }

  /**
   * This is the merchant's unique identifier of the customer. Customer/end user email id or phone number, from whom money has to be collected
   *
   * @return consumerId
   */
  public String getConsumerId() {
    return consumerId;
  }

  public void setConsumerId(String consumerId) {
    this.consumerId = consumerId;
  }


  public Interac type(String type) {
    this.type = type;
    return this;
  }

  /**
   * Default value is EMAIL. To pass mobile number we have to specify the type as PHONE. This is needed for deposit flow (not for withdrawal)
   *
   * @return type
   */
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }


  public Interac question(String question) {
    this.question = question;
    return this;
  }

  /**
   * When customer is not registered for auto-deposit at interac online then Merchant has to pass \"question\" parameter. Mandatory in non-autodeposit withdrawal Payment Handle request flow
   *
   * @return question
   */
  public String getQuestion() {
    return question;
  }

  public void setQuestion(String question) {
    this.question = question;
  }


  public Interac answer(String answer) {
    this.answer = answer;
    return this;
  }

  /**
   * When customer is not registered for auto-deposit at interac online then Merchant has to pass \"answer\" parameter. Mandatory in non-autodeposit withdrawal Payment Handle request flow\\
   *
   * @return answer
   */
  public String getAnswer() {
    return answer;
  }

  public void setAnswer(String answer) {
    this.answer = answer;
  }


  public Interac transferType(InteracTransferType transferType) {
    this.transferType = transferType;
    return this;
  }

  /**
   * Get transferType
   *
   * @return transferType
   */
  public InteracTransferType getTransferType() {
    return transferType;
  }

  public void setTransferType(InteracTransferType transferType) {
    this.transferType = transferType;
  }


  public Interac maxAmount(Integer maxAmount) {
    this.maxAmount = maxAmount;
    return this;
  }

  /**
   * Maximum amount that user can transfer
   *
   * @return maxAmount
   */
  public Integer getMaxAmount() {
    return maxAmount;
  }

  public void setMaxAmount(Integer maxAmount) {
    this.maxAmount = maxAmount;
  }


  public Interac fraudStatus(InteracFraudStatus fraudStatus) {
    this.fraudStatus = fraudStatus;
    return this;
  }

  /**
   * Get fraudStatus
   *
   * @return fraudStatus
   */
  public InteracFraudStatus getFraudStatus() {
    return fraudStatus;
  }

  public void setFraudStatus(InteracFraudStatus fraudStatus) {
    this.fraudStatus = fraudStatus;
  }


  public Interac fraudType(InteracFraudType fraudType) {
    this.fraudType = fraudType;
    return this;
  }

  /**
   * Get fraudType
   *
   * @return fraudType
   */
  public InteracFraudType getFraudType() {
    return fraudType;
  }

  public void setFraudType(InteracFraudType fraudType) {
    this.fraudType = fraudType;
  }


  public Interac paymentReference(String paymentReference) {
    this.paymentReference = paymentReference;
    return this;
  }

  /**
   * It is the Payment Reference Number at interac E-Transfer
   *
   * @return paymentReference
   */
  public String getPaymentReference() {
    return paymentReference;
  }

  public void setPaymentReference(String paymentReference) {
    this.paymentReference = paymentReference;
  }


  public Interac method(InteracMethod method) {
    this.method = method;
    return this;
  }

  /**
   * Get method
   *
   * @return method
   */
  public InteracMethod getMethod() {
    return method;
  }

  public void setMethod(InteracMethod method) {
    this.method = method;
  }


  public Interac paymentRefExpiryMinutes(Integer paymentRefExpiryMinutes) {
    this.paymentRefExpiryMinutes = paymentRefExpiryMinutes;
    return this;
  }

  /**
   * Interac E-Transfer transaction expiry time in minutes
   *
   * @return paymentRefExpiryMinutes
   */
  public Integer getPaymentRefExpiryMinutes() {
    return paymentRefExpiryMinutes;
  }

  public void setPaymentRefExpiryMinutes(Integer paymentRefExpiryMinutes) {
    this.paymentRefExpiryMinutes = paymentRefExpiryMinutes;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Interac interac = (Interac) o;
    return Objects.equals(this.consumerId, interac.consumerId) &&
        Objects.equals(this.type, interac.type) &&
        Objects.equals(this.question, interac.question) &&
        Objects.equals(this.answer, interac.answer) &&
        Objects.equals(this.transferType, interac.transferType) &&
        Objects.equals(this.maxAmount, interac.maxAmount) &&
        Objects.equals(this.fraudStatus, interac.fraudStatus) &&
        Objects.equals(this.fraudType, interac.fraudType) &&
        Objects.equals(this.paymentReference, interac.paymentReference) &&
        Objects.equals(this.method, interac.method) &&
        Objects.equals(this.paymentRefExpiryMinutes, interac.paymentRefExpiryMinutes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(consumerId, type, question, answer, transferType, maxAmount, fraudStatus, fraudType, paymentReference, method, paymentRefExpiryMinutes);
  }

  @Override
  public String toString() {

    return "class Interac {\n"
        + "    consumerId: " + toIndentedString(consumerId) + "\n"
        + "    type: " + toIndentedString(type) + "\n"
        + "    question: " + toIndentedString(question) + "\n"
        + "    answer: " + toIndentedString(answer) + "\n"
        + "    transferType: " + toIndentedString(transferType) + "\n"
        + "    maxAmount: " + toIndentedString(maxAmount) + "\n"
        + "    fraudStatus: " + toIndentedString(fraudStatus) + "\n"
        + "    fraudType: " + toIndentedString(fraudType) + "\n"
        + "    paymentReference: " + toIndentedString(paymentReference) + "\n"
        + "    method: " + toIndentedString(method) + "\n"
        + "    paymentRefExpiryMinutes: " + toIndentedString(paymentRefExpiryMinutes) + "\n"
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
   * Details of the interac E-Transfer used for the transaction. builder static inner class.
   */
  public static final class Builder {
    private String consumerId;
    private String type;
    private String question;
    private String answer;
    private InteracTransferType transferType;
    private Integer maxAmount;
    private InteracFraudStatus fraudStatus;
    private InteracFraudType fraudType;
    private String paymentReference;
    private InteracMethod method;
    private Integer paymentRefExpiryMinutes;

    private Builder() {
    }

    /**
     * This is the merchant's unique identifier of the customer. Customer/end user email id or phone number, from whom money has to be collected
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
     * Default value is EMAIL. To pass mobile number we have to specify the type as PHONE. This is needed for deposit flow (not for withdrawal)
     * <p>
     * Sets the type and returns a reference to this Builder enabling method chaining.
     *
     * @param type the type to set
     * @return a reference to this Builder
     */
    public Builder type(String type) {
      this.type = type;
      return this;
    }

    /**
     * When customer is not registered for auto-deposit at interac online then Merchant has to pass \"question\" parameter. Mandatory in non-autodeposit withdrawal Payment Handle request flow
     * <p>
     * Sets the question and returns a reference to this Builder enabling method chaining.
     *
     * @param question the question to set
     * @return a reference to this Builder
     */
    public Builder question(String question) {
      this.question = question;
      return this;
    }

    /**
     * When customer is not registered for auto-deposit at interac online then Merchant has to pass \"answer\" parameter. Mandatory in non-autodeposit withdrawal Payment Handle request flow\\
     * <p>
     * Sets the answer and returns a reference to this Builder enabling method chaining.
     *
     * @param answer the answer to set
     * @return a reference to this Builder
     */
    public Builder answer(String answer) {
      this.answer = answer;
      return this;
    }

    /**
     * Sets the transferType and returns a reference to this Builder enabling method chaining.
     *
     * @param transferType the transferType to set
     * @return a reference to this Builder
     */
    public Builder transferType(InteracTransferType transferType) {
      this.transferType = transferType;
      return this;
    }

    /**
     * Maximum amount that user can transfer
     * <p>
     * Sets the maxAmount and returns a reference to this Builder enabling method chaining.
     *
     * @param maxAmount the maxAmount to set
     * @return a reference to this Builder
     */
    public Builder maxAmount(Integer maxAmount) {
      this.maxAmount = maxAmount;
      return this;
    }

    /**
     * Sets the fraudStatus and returns a reference to this Builder enabling method chaining.
     *
     * @param fraudStatus the fraudStatus to set
     * @return a reference to this Builder
     */
    public Builder fraudStatus(InteracFraudStatus fraudStatus) {
      this.fraudStatus = fraudStatus;
      return this;
    }

    /**
     * Sets the fraudType and returns a reference to this Builder enabling method chaining.
     *
     * @param fraudType the fraudType to set
     * @return a reference to this Builder
     */
    public Builder fraudType(InteracFraudType fraudType) {
      this.fraudType = fraudType;
      return this;
    }

    /**
     * It is the Payment Reference Number at interac E-Transfer
     * <p>
     * Sets the paymentReference and returns a reference to this Builder enabling method chaining.
     *
     * @param paymentReference the paymentReference to set
     * @return a reference to this Builder
     */
    public Builder paymentReference(String paymentReference) {
      this.paymentReference = paymentReference;
      return this;
    }

    /**
     * Sets the method and returns a reference to this Builder enabling method chaining.
     *
     * @param method the method to set
     * @return a reference to this Builder
     */
    public Builder method(InteracMethod method) {
      this.method = method;
      return this;
    }

    /**
     * Interac E-Transfer transaction expiry time in minutes
     * <p>
     * Sets the paymentRefExpiryMinutes and returns a reference to this Builder enabling method chaining.
     *
     * @param paymentRefExpiryMinutes the paymentRefExpiryMinutes to set
     * @return a reference to this Builder
     */
    public Builder paymentRefExpiryMinutes(Integer paymentRefExpiryMinutes) {
      this.paymentRefExpiryMinutes = paymentRefExpiryMinutes;
      return this;
    }

    /**
     * Returns a Interac built from the parameters previously set.
     *
     * @return a Interac built with parameters of this Interac.Builder
     */
    public Interac build() {
      return new Interac(this);
    }
  }
}
