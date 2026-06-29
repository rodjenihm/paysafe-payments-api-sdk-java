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
import com.paysafe.payments.model.BaseApiResponse;
import com.paysafe.payments.model.common.GatewayResponse;
import com.paysafe.payments.model.common.enums.CurrencyCode;
import com.paysafe.payments.model.lpm.Splitpay;
import com.paysafe.payments.model.paymenthandle.enums.PaymentType;
import com.paysafe.payments.model.refund.enums.RefundStatus;



/**
 * Represents the details of a refund.
 */
public class Refund extends BaseApiResponse {

  @JsonProperty("id")
  private String id;
  @JsonProperty("merchantRefNum")
  private String merchantRefNum;
  @JsonProperty("amount")
  private Integer amount;
  @JsonProperty("dupCheck")
  private Boolean dupCheck = true;
  @JsonProperty("splitpay")
  private List<Splitpay> splitpay;
  @JsonProperty("paymentType")
  private PaymentType paymentType;
  @JsonProperty("currencyCode")
  private CurrencyCode currencyCode;
  @JsonProperty("txnTime")
  private String txnTime;
  @JsonProperty("status")
  private RefundStatus status;
  @JsonProperty("gatewayReconciliationId")
  private String gatewayReconciliationId;
  @JsonProperty("updatedTime")
  private String updatedTime;
  @JsonProperty("statusTime")
  private String statusTime;
  @JsonProperty("liveMode")
  private Boolean liveMode;
  @JsonProperty("gatewayResponse")
  private GatewayResponse gatewayResponse;
  @JsonProperty("source")
  private String source;
  @JsonProperty("childAccountNum")
  private String childAccountNum;
  @JsonProperty("riskReasonCode")
  private List<Integer> riskReasonCode;

  public Refund() {
    super();
  }

  private Refund(final Builder builder) {
    setId(builder.id);
    setMerchantRefNum(builder.merchantRefNum);
    setAmount(builder.amount);
    setDupCheck(builder.dupCheck);
    setSplitpay(builder.splitpay);
    setPaymentType(builder.paymentType);
    setCurrencyCode(builder.currencyCode);
    setTxnTime(builder.txnTime);
    setStatus(builder.status);
    setGatewayReconciliationId(builder.gatewayReconciliationId);
    setUpdatedTime(builder.updatedTime);
    setStatusTime(builder.statusTime);
    setLiveMode(builder.liveMode);
    setGatewayResponse(builder.gatewayResponse);
    setSource(builder.source);
    setChildAccountNum(builder.childAccountNum);
    setRiskReasonCode(builder.riskReasonCode);
  }

  public static Builder builder() {
    return new Builder();
  }


  public Refund id(String id) {
    this.id = id;
    return this;
  }

  /**
   * The unique identifier for the refund transaction
   *
   * @return id
   */
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public Refund merchantRefNum(String merchantRefNum) {
    this.merchantRefNum = merchantRefNum;
    return this;
  }

  /**
   * The merchant reference number created by the merchant and submitted as part of the request
   *
   * @return merchantRefNum
   */
  public String getMerchantRefNum() {
    return merchantRefNum;
  }

  public void setMerchantRefNum(String merchantRefNum) {
    this.merchantRefNum = merchantRefNum;
  }


  public Refund amount(Integer amount) {
    this.amount = amount;
    return this;
  }

  /**
   * The amount of the request, in minor units
   *
   * @return amount
   */
  public Integer getAmount() {
    return amount;
  }

  public void setAmount(Integer amount) {
    this.amount = amount;
  }


  public Refund dupCheck(Boolean dupCheck) {
    this.dupCheck = dupCheck;
    return this;
  }

  /**
   * Indicates whether duplicate transaction checking was applied
   *
   * @return dupCheck
   */
  public Boolean getDupCheck() {
    return dupCheck;
  }

  public void setDupCheck(Boolean dupCheck) {
    this.dupCheck = dupCheck;
  }


  public Refund splitpay(List<Splitpay> splitpay) {
    this.splitpay = splitpay;
    return this;
  }

  public Refund addSplitpayItem(Splitpay splitpayItem) {
    if (this.splitpay == null) {
      this.splitpay = new ArrayList<>();
    }
    this.splitpay.add(splitpayItem);
    return this;
  }

  public Refund removeSplitpayItem(Splitpay splitpayItem) {
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


  public Refund paymentType(PaymentType paymentType) {
    this.paymentType = paymentType;
    return this;
  }

  /**
   * Get paymentType
   *
   * @return paymentType
   */
  public PaymentType getPaymentType() {
    return paymentType;
  }

  public void setPaymentType(PaymentType paymentType) {
    this.paymentType = paymentType;
  }


  public Refund currencyCode(CurrencyCode currencyCode) {
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


  public Refund txnTime(String txnTime) {
    this.txnTime = txnTime;
    return this;
  }

  /**
   * The date and time of the transaction
   *
   * @return txnTime
   */
  public String getTxnTime() {
    return txnTime;
  }

  public void setTxnTime(String txnTime) {
    this.txnTime = txnTime;
  }


  public Refund status(RefundStatus status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   *
   * @return status
   */
  public RefundStatus getStatus() {
    return status;
  }

  public void setStatus(RefundStatus status) {
    this.status = status;
  }


  public Refund gatewayReconciliationId(String gatewayReconciliationId) {
    this.gatewayReconciliationId = gatewayReconciliationId;
    return this;
  }

  /**
   * The reconciliation ID returned by the gateway
   *
   * @return gatewayReconciliationId
   */
  public String getGatewayReconciliationId() {
    return gatewayReconciliationId;
  }

  public void setGatewayReconciliationId(String gatewayReconciliationId) {
    this.gatewayReconciliationId = gatewayReconciliationId;
  }


  public Refund updatedTime(String updatedTime) {
    this.updatedTime = updatedTime;
    return this;
  }

  /**
   * The date and time the refund response was last updated
   *
   * @return updatedTime
   */
  public String getUpdatedTime() {
    return updatedTime;
  }

  public void setUpdatedTime(String updatedTime) {
    this.updatedTime = updatedTime;
  }


  public Refund statusTime(String statusTime) {
    this.statusTime = statusTime;
    return this;
  }

  /**
   * The date and time of the last status change
   *
   * @return statusTime
   */
  public String getStatusTime() {
    return statusTime;
  }

  public void setStatusTime(String statusTime) {
    this.statusTime = statusTime;
  }


  public Refund liveMode(Boolean liveMode) {
    this.liveMode = liveMode;
    return this;
  }

  /**
   * Indicates whether the refund was processed in live mode
   *
   * @return liveMode
   */
  public Boolean getLiveMode() {
    return liveMode;
  }

  public void setLiveMode(Boolean liveMode) {
    this.liveMode = liveMode;
  }


  public Refund gatewayResponse(GatewayResponse gatewayResponse) {
    this.gatewayResponse = gatewayResponse;
    return this;
  }

  /**
   * Get gatewayResponse
   *
   * @return gatewayResponse
   */
  public GatewayResponse getGatewayResponse() {
    return gatewayResponse;
  }

  public void setGatewayResponse(GatewayResponse gatewayResponse) {
    this.gatewayResponse = gatewayResponse;
  }


  public Refund source(String source) {
    this.source = source;
    return this;
  }

  /**
   * The source of the refund
   *
   * @return source
   */
  public String getSource() {
    return source;
  }

  public void setSource(String source) {
    this.source = source;
  }


  public Refund childAccountNum(String childAccountNum) {
    this.childAccountNum = childAccountNum;
    return this;
  }

  /**
   * The child account number if the transaction is processed via a master account
   *
   * @return childAccountNum
   */
  public String getChildAccountNum() {
    return childAccountNum;
  }

  public void setChildAccountNum(String childAccountNum) {
    this.childAccountNum = childAccountNum;
  }


  public Refund riskReasonCode(List<Integer> riskReasonCode) {
    this.riskReasonCode = riskReasonCode;
    return this;
  }

  public Refund addRiskReasonCodeItem(Integer riskReasonCodeItem) {
    if (this.riskReasonCode == null) {
      this.riskReasonCode = new ArrayList<>();
    }
    this.riskReasonCode.add(riskReasonCodeItem);
    return this;
  }

  public Refund removeRiskReasonCodeItem(Integer riskReasonCodeItem) {
    if (riskReasonCodeItem != null && this.riskReasonCode != null) {
      this.riskReasonCode.remove(riskReasonCodeItem);
    }

    return this;
  }

  /**
   * List of risk-related reason codes
   *
   * @return riskReasonCode
   */
  public List<Integer> getRiskReasonCode() {
    return riskReasonCode;
  }

  public void setRiskReasonCode(List<Integer> riskReasonCode) {
    this.riskReasonCode = riskReasonCode;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Refund refund = (Refund) o;
    return Objects.equals(this.id, refund.id) &&
        Objects.equals(this.merchantRefNum, refund.merchantRefNum) &&
        Objects.equals(this.amount, refund.amount) &&
        Objects.equals(this.dupCheck, refund.dupCheck) &&
        Objects.equals(this.splitpay, refund.splitpay) &&
        Objects.equals(this.paymentType, refund.paymentType) &&
        Objects.equals(this.currencyCode, refund.currencyCode) &&
        Objects.equals(this.txnTime, refund.txnTime) &&
        Objects.equals(this.status, refund.status) &&
        Objects.equals(this.gatewayReconciliationId, refund.gatewayReconciliationId) &&
        Objects.equals(this.updatedTime, refund.updatedTime) &&
        Objects.equals(this.statusTime, refund.statusTime) &&
        Objects.equals(this.liveMode, refund.liveMode) &&
        Objects.equals(this.gatewayResponse, refund.gatewayResponse) &&
        Objects.equals(this.source, refund.source) &&
        Objects.equals(this.childAccountNum, refund.childAccountNum) &&
        Objects.equals(this.riskReasonCode, refund.riskReasonCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, merchantRefNum, amount, dupCheck, splitpay, paymentType, currencyCode, txnTime, status, gatewayReconciliationId, updatedTime, statusTime, liveMode, gatewayResponse, source, childAccountNum, riskReasonCode);
  }

  @Override
  public String toString() {

    return "class Refund {\n"
        + "    id: " + toIndentedString(id) + "\n"
        + "    merchantRefNum: " + toIndentedString(merchantRefNum) + "\n"
        + "    amount: " + toIndentedString(amount) + "\n"
        + "    dupCheck: " + toIndentedString(dupCheck) + "\n"
        + "    splitpay: " + toIndentedString(splitpay) + "\n"
        + "    paymentType: " + toIndentedString(paymentType) + "\n"
        + "    currencyCode: " + toIndentedString(currencyCode) + "\n"
        + "    txnTime: " + toIndentedString(txnTime) + "\n"
        + "    status: " + toIndentedString(status) + "\n"
        + "    gatewayReconciliationId: " + toIndentedString(gatewayReconciliationId) + "\n"
        + "    updatedTime: " + toIndentedString(updatedTime) + "\n"
        + "    statusTime: " + toIndentedString(statusTime) + "\n"
        + "    liveMode: " + toIndentedString(liveMode) + "\n"
        + "    gatewayResponse: " + toIndentedString(gatewayResponse) + "\n"
        + "    source: " + toIndentedString(source) + "\n"
        + "    childAccountNum: " + toIndentedString(childAccountNum) + "\n"
        + "    riskReasonCode: " + toIndentedString(riskReasonCode) + "\n"
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
   * Represents the details of a refund. builder static inner class.
   */
  public static final class Builder {
    private String id;
    private String merchantRefNum;
    private Integer amount;
    private Boolean dupCheck;
    private List<Splitpay> splitpay;
    private PaymentType paymentType;
    private CurrencyCode currencyCode;
    private String txnTime;
    private RefundStatus status;
    private String gatewayReconciliationId;
    private String updatedTime;
    private String statusTime;
    private Boolean liveMode;
    private GatewayResponse gatewayResponse;
    private String source;
    private String childAccountNum;
    private List<Integer> riskReasonCode;

    private Builder() {
    }

    /**
     * The unique identifier for the refund transaction
     * <p>
     * Sets the id and returns a reference to this Builder enabling method chaining.
     *
     * @param id the id to set
     * @return a reference to this Builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }

    /**
     * The merchant reference number created by the merchant and submitted as part of the request
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
     * The amount of the request, in minor units
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
     * Indicates whether duplicate transaction checking was applied
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
     * Sets the paymentType and returns a reference to this Builder enabling method chaining.
     *
     * @param paymentType the paymentType to set
     * @return a reference to this Builder
     */
    public Builder paymentType(PaymentType paymentType) {
      this.paymentType = paymentType;
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
     * The date and time of the transaction
     * <p>
     * Sets the txnTime and returns a reference to this Builder enabling method chaining.
     *
     * @param txnTime the txnTime to set
     * @return a reference to this Builder
     */
    public Builder txnTime(String txnTime) {
      this.txnTime = txnTime;
      return this;
    }

    /**
     * Sets the status and returns a reference to this Builder enabling method chaining.
     *
     * @param status the status to set
     * @return a reference to this Builder
     */
    public Builder status(RefundStatus status) {
      this.status = status;
      return this;
    }

    /**
     * The reconciliation ID returned by the gateway
     * <p>
     * Sets the gatewayReconciliationId and returns a reference to this Builder enabling method chaining.
     *
     * @param gatewayReconciliationId the gatewayReconciliationId to set
     * @return a reference to this Builder
     */
    public Builder gatewayReconciliationId(String gatewayReconciliationId) {
      this.gatewayReconciliationId = gatewayReconciliationId;
      return this;
    }

    /**
     * The date and time the refund response was last updated
     * <p>
     * Sets the updatedTime and returns a reference to this Builder enabling method chaining.
     *
     * @param updatedTime the updatedTime to set
     * @return a reference to this Builder
     */
    public Builder updatedTime(String updatedTime) {
      this.updatedTime = updatedTime;
      return this;
    }

    /**
     * The date and time of the last status change
     * <p>
     * Sets the statusTime and returns a reference to this Builder enabling method chaining.
     *
     * @param statusTime the statusTime to set
     * @return a reference to this Builder
     */
    public Builder statusTime(String statusTime) {
      this.statusTime = statusTime;
      return this;
    }

    /**
     * Indicates whether the refund was processed in live mode
     * <p>
     * Sets the liveMode and returns a reference to this Builder enabling method chaining.
     *
     * @param liveMode the liveMode to set
     * @return a reference to this Builder
     */
    public Builder liveMode(Boolean liveMode) {
      this.liveMode = liveMode;
      return this;
    }

    /**
     * Sets the gatewayResponse and returns a reference to this Builder enabling method chaining.
     *
     * @param gatewayResponse the gatewayResponse to set
     * @return a reference to this Builder
     */
    public Builder gatewayResponse(GatewayResponse gatewayResponse) {
      this.gatewayResponse = gatewayResponse;
      return this;
    }

    /**
     * The source of the refund
     * <p>
     * Sets the source and returns a reference to this Builder enabling method chaining.
     *
     * @param source the source to set
     * @return a reference to this Builder
     */
    public Builder source(String source) {
      this.source = source;
      return this;
    }

    /**
     * The child account number if the transaction is processed via a master account
     * <p>
     * Sets the childAccountNum and returns a reference to this Builder enabling method chaining.
     *
     * @param childAccountNum the childAccountNum to set
     * @return a reference to this Builder
     */
    public Builder childAccountNum(String childAccountNum) {
      this.childAccountNum = childAccountNum;
      return this;
    }

    /**
     * List of risk-related reason codes
     * <p>
     * Sets the riskReasonCode and returns a reference to this Builder enabling method chaining.
     *
     * @param riskReasonCode the riskReasonCode to set
     * @return a reference to this Builder
     */
    public Builder riskReasonCode(List<Integer> riskReasonCode) {
      this.riskReasonCode = riskReasonCode;
      return this;
    }

    /**
     * Returns a Refund built from the parameters previously set.
     *
     * @return a Refund built with parameters of this Refund.Builder
     */
    public Refund build() {
      return new Refund(this);
    }
  }
}
