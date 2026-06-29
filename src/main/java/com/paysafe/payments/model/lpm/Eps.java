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



/**
 * These are the details of the customer used for the transaction. 
 */
public class Eps {

  @JsonProperty("bankId")
  private String bankId;
  @JsonProperty("paymentId")
  private String paymentId;
  @JsonProperty("emailSubject")
  private String emailSubject;
  @JsonProperty("emailMessage")
  private String emailMessage;

  public Eps() {
    super();
  }

  private Eps(final Builder builder) {
    setBankId(builder.bankId);
    setPaymentId(builder.paymentId);
    setEmailSubject(builder.emailSubject);
    setEmailMessage(builder.emailMessage);
  }

  public static Builder builder() {
    return new Builder();
  }


  public Eps bankId(String bankId) {
    this.bankId = bankId;
    return this;
  }

  /**
   * This is the bank identifier used by the PSP. This is to be provided by merchant.
   *
   * @return bankId
   */
  public String getBankId() {
    return bankId;
  }

  public void setBankId(String bankId) {
    this.bankId = bankId;
  }


  public Eps paymentId(String paymentId) {
    this.paymentId = paymentId;
    return this;
  }

  /**
   * This is the ID returned in the response of the [Payments](/operations/process-payment) request. This is to be provided by merchant.
   *
   * @return paymentId
   */
  public String getPaymentId() {
    return paymentId;
  }

  public void setPaymentId(String paymentId) {
    this.paymentId = paymentId;
  }


  public Eps emailSubject(String emailSubject) {
    this.emailSubject = emailSubject;
    return this;
  }

  /**
   * This is the Subject line to use in the customer email. This is to be provided by merchant while making a payout.
   *
   * @return emailSubject
   */
  public String getEmailSubject() {
    return emailSubject;
  }

  public void setEmailSubject(String emailSubject) {
    this.emailSubject = emailSubject;
  }


  public Eps emailMessage(String emailMessage) {
    this.emailMessage = emailMessage;
    return this;
  }

  /**
   * This is the message to use in the customer email. This is to be provided by merchant while making a payout.
   *
   * @return emailMessage
   */
  public String getEmailMessage() {
    return emailMessage;
  }

  public void setEmailMessage(String emailMessage) {
    this.emailMessage = emailMessage;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Eps eps = (Eps) o;
    return Objects.equals(this.bankId, eps.bankId) &&
        Objects.equals(this.paymentId, eps.paymentId) &&
        Objects.equals(this.emailSubject, eps.emailSubject) &&
        Objects.equals(this.emailMessage, eps.emailMessage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bankId, paymentId, emailSubject, emailMessage);
  }

  @Override
  public String toString() {

    return "class Eps {\n"
        + "    bankId: " + toIndentedString(bankId) + "\n"
        + "    paymentId: " + toIndentedString(paymentId) + "\n"
        + "    emailSubject: " + toIndentedString(emailSubject) + "\n"
        + "    emailMessage: " + toIndentedString(emailMessage) + "\n"
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
   * These are the details of the customer used for the transaction.  builder static inner class.
   */
  public static final class Builder {
    private String bankId;
    private String paymentId;
    private String emailSubject;
    private String emailMessage;

    private Builder() {
    }

    /**
     * This is the bank identifier used by the PSP. This is to be provided by merchant.
     * <p>
     * Sets the bankId and returns a reference to this Builder enabling method chaining.
     *
     * @param bankId the bankId to set
     * @return a reference to this Builder
     */
    public Builder bankId(String bankId) {
      this.bankId = bankId;
      return this;
    }

    /**
     * This is the ID returned in the response of the [Payments](/operations/process-payment) request. This is to be provided by merchant.
     * <p>
     * Sets the paymentId and returns a reference to this Builder enabling method chaining.
     *
     * @param paymentId the paymentId to set
     * @return a reference to this Builder
     */
    public Builder paymentId(String paymentId) {
      this.paymentId = paymentId;
      return this;
    }

    /**
     * This is the Subject line to use in the customer email. This is to be provided by merchant while making a payout.
     * <p>
     * Sets the emailSubject and returns a reference to this Builder enabling method chaining.
     *
     * @param emailSubject the emailSubject to set
     * @return a reference to this Builder
     */
    public Builder emailSubject(String emailSubject) {
      this.emailSubject = emailSubject;
      return this;
    }

    /**
     * This is the message to use in the customer email. This is to be provided by merchant while making a payout.
     * <p>
     * Sets the emailMessage and returns a reference to this Builder enabling method chaining.
     *
     * @param emailMessage the emailMessage to set
     * @return a reference to this Builder
     */
    public Builder emailMessage(String emailMessage) {
      this.emailMessage = emailMessage;
      return this;
    }

    /**
     * Returns a Eps built from the parameters previously set.
     *
     * @return a Eps built with parameters of this Eps.Builder
     */
    public Eps build() {
      return new Eps(this);
    }
  }
}
