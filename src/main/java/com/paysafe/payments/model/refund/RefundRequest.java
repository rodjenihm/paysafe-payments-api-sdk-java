// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.model.refund;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.paysafe.payments.model.lpm.Splitpay;



/**
 * Represents a refund request.
 */
public class RefundRequest {

  @JsonProperty("merchantRefNum")
  private String merchantRefNum;
  @JsonProperty("amount")
  private Integer amount;
  @JsonProperty("dupCheck")
  private Boolean dupCheck = true;
  @JsonProperty("customerAccountId")
  private String customerAccountId;
  @JsonProperty("splitpay")
  private List<Splitpay> splitpay;
  private Map<String, Object> additionalParameters;

  public RefundRequest() {
    super();
  }

  private RefundRequest(final Builder builder) {
    setMerchantRefNum(builder.merchantRefNum);
    setAmount(builder.amount);
    setDupCheck(builder.dupCheck);
    setCustomerAccountId(builder.customerAccountId);
    setSplitpay(builder.splitpay);
    this.additionalParameters = builder.additionalParameters;
  }

  public static Builder builder() {
    return new Builder();
  }


  public RefundRequest merchantRefNum(String merchantRefNum) {
    this.merchantRefNum = merchantRefNum;
    return this;
  }

  /**
   * The merchant reference number created by the merchant and submitted as part of the request. It must be unique for each request
   *
   * @return merchantRefNum
   */
  public String getMerchantRefNum() {
    return merchantRefNum;
  }

  public void setMerchantRefNum(String merchantRefNum) {
    this.merchantRefNum = merchantRefNum;
  }


  public RefundRequest amount(Integer amount) {
    this.amount = amount;
    return this;
  }

  /**
   * The amount to refund in minor units (e.g., $10.99 = 1099)
   *
   * @return amount
   */
  public Integer getAmount() {
    return amount;
  }

  public void setAmount(Integer amount) {
    this.amount = amount;
  }


  public RefundRequest dupCheck(Boolean dupCheck) {
    this.dupCheck = dupCheck;
    return this;
  }

  /**
   * Validates that this request is not a duplicate
   *
   * @return dupCheck
   */
  public Boolean getDupCheck() {
    return dupCheck;
  }

  public void setDupCheck(Boolean dupCheck) {
    this.dupCheck = dupCheck;
  }


  public RefundRequest customerAccountId(String customerAccountId) {
    this.customerAccountId = customerAccountId;
    return this;
  }

  /**
   * This is the account identifier to which the refund will be sent. It is only used today for PaysafeCard. The merchant may pass either the PaysafeCard Account ID of the account to which the refund should be made, or the email address that is registered against the customer’s PaysafeCard account.
   *
   * @return customerAccountId
   */
  public String getCustomerAccountId() {
    return customerAccountId;
  }

  public void setCustomerAccountId(String customerAccountId) {
    this.customerAccountId = customerAccountId;
  }


  public RefundRequest splitpay(List<Splitpay> splitpay) {
    this.splitpay = splitpay;
    return this;
  }

  public RefundRequest addSplitpayItem(Splitpay splitpayItem) {
    if (this.splitpay == null) {
      this.splitpay = new ArrayList<>();
    }
    this.splitpay.add(splitpayItem);
    return this;
  }

  public RefundRequest removeSplitpayItem(Splitpay splitpayItem) {
    if (splitpayItem != null && this.splitpay != null) {
      this.splitpay.remove(splitpayItem);
    }

    return this;
  }

  /**
   * Split payment details for the refund
   *
   * @return splitpay
   */
  public List<Splitpay> getSplitpay() {
    return splitpay;
  }

  public void setSplitpay(List<Splitpay> splitpay) {
    this.splitpay = splitpay;
  }

  /**
   * This map holds additional parameters that can be used for features not available in this client library.
   * During serialization, each key-value pair is treated as if the key were a top-level field in the serialized object,
   * e.g. <code>{"merchantRefNum" : "uuid", "additionalParameter1" : 100, "additionalParameter2" : "string" }</code> .
   *
   * @return additionalParameters
   */
  @JsonAnyGetter
  public Map<String, Object> getAdditionalParameters() {
    return this.additionalParameters;
  }

  public void setAdditionalParameters(Map<String, Object> additionalParameters) {
    this.additionalParameters = additionalParameters;
  }

  public void addAdditionalParameter(String key, Object value) {
    if (this.additionalParameters == null) {
      this.additionalParameters = new HashMap<>();
    }
    this.additionalParameters.put(key, value);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RefundRequest refundRequest = (RefundRequest) o;
    return Objects.equals(this.merchantRefNum, refundRequest.merchantRefNum) &&
        Objects.equals(this.amount, refundRequest.amount) &&
        Objects.equals(this.dupCheck, refundRequest.dupCheck) &&
        Objects.equals(this.customerAccountId, refundRequest.customerAccountId) &&
        Objects.equals(this.splitpay, refundRequest.splitpay);
  }

  @Override
  public int hashCode() {
    return Objects.hash(merchantRefNum, amount, dupCheck, customerAccountId, splitpay);
  }

  @Override
  public String toString() {

    return "class RefundRequest {\n"
        + "    merchantRefNum: " + toIndentedString(merchantRefNum) + "\n"
        + "    amount: " + toIndentedString(amount) + "\n"
        + "    dupCheck: " + toIndentedString(dupCheck) + "\n"
        + "    customerAccountId: " + toIndentedString(customerAccountId) + "\n"
        + "    splitpay: " + toIndentedString(splitpay) + "\n"
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
   * Represents a refund request. builder static inner class.
   */
  public static final class Builder {
    private String merchantRefNum;
    private Integer amount;
    private Boolean dupCheck;
    private String customerAccountId;
    private List<Splitpay> splitpay;
    private Map<String, Object> additionalParameters;

    private Builder() {
    }

    /**
     * The merchant reference number created by the merchant and submitted as part of the request. It must be unique for each request
     * <p>
     * Sets the merchantRefNum and returns a reference to this Builder enabling method chaining.
     *
     * @param merchantRefNum the merchantRefNum to set
     * @return a reference to this Builder
     */
    public Builder merchantRefNum(String merchantRefNum) {
      this.merchantRefNum = merchantRefNum;
      return this;
    }

    /**
     * The amount to refund in minor units (e.g., $10.99 = 1099)
     * <p>
     * Sets the amount and returns a reference to this Builder enabling method chaining.
     *
     * @param amount the amount to set
     * @return a reference to this Builder
     */
    public Builder amount(Integer amount) {
      this.amount = amount;
      return this;
    }

    /**
     * Validates that this request is not a duplicate
     * <p>
     * Sets the dupCheck and returns a reference to this Builder enabling method chaining.
     *
     * @param dupCheck the dupCheck to set
     * @return a reference to this Builder
     */
    public Builder dupCheck(Boolean dupCheck) {
      this.dupCheck = dupCheck;
      return this;
    }

    /**
     * This is the account identifier to which the refund will be sent. It is only used today for PaysafeCard. The merchant may pass either the PaysafeCard Account ID of the account to which the refund should be made, or the email address that is registered against the customer’s PaysafeCard account.
     * <p>
     * Sets the customerAccountId and returns a reference to this Builder enabling method chaining.
     *
     * @param customerAccountId the customerAccountId to set
     * @return a reference to this Builder
     */
    public Builder customerAccountId(String customerAccountId) {
      this.customerAccountId = customerAccountId;
      return this;
    }

    /**
     * Split payment details for the refund
     * <p>
     * Sets the splitpay and returns a reference to this Builder enabling method chaining.
     *
     * @param splitpay the splitpay to set
     * @return a reference to this Builder
     */
    public Builder splitpay(List<Splitpay> splitpay) {
      this.splitpay = splitpay;
      return this;
    }

    /**
     * Sets the {@code additionalParameters} and returns a reference to this Builder enabling method chaining.
     *
     * @param additionalParameters the {@code additionalParameters} to set
     * @return a reference to this Builder
     */
    public Builder additionalParameters(Map<String, Object> additionalParameters) {
      this.additionalParameters = additionalParameters;
      return this;
    }

    /**
     * Inserts one key/value pair to additionalParameters and returns a reference to this Builder enabling method chaining.
     *
     * @param key the key to insert
     * @param value the value to insert
     * @return a reference to this Builder
     */
    public Builder addAdditionalParameter(String key, Object value) {
      if (this.additionalParameters == null) {
        this.additionalParameters = new HashMap<>();
      }
      this.additionalParameters.put(key, value);
      return this;
    }

    /**
     * Inserts provided key/value pairs to additionalParameters and returns a reference to this Builder enabling method chaining.
     *
     * @param additionalParameters the key/value pairs to insert
     * @return a reference to this Builder
     */
    public Builder addAllAdditionalParameters(Map<String, Object> additionalParameters) {
      if (this.additionalParameters == null) {
        this.additionalParameters = new HashMap<>();
      }
      this.additionalParameters.putAll(additionalParameters);
      return this;
    }

    /**
     * Returns a RefundRequest built from the parameters previously set.
     *
     * @return a RefundRequest built with parameters of this RefundRequest.Builder
     */
    public RefundRequest build() {
      return new RefundRequest(this);
    }
  }
}
