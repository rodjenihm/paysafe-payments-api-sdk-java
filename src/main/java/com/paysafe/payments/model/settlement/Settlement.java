// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.model.settlement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.paysafe.payments.model.common.GatewayResponse;
import com.paysafe.payments.model.common.error.Error;
import com.paysafe.payments.model.common.travel.airline.AirlineTravelDetails;
import com.paysafe.payments.model.common.travel.carrental.CarRentalDetails;
import com.paysafe.payments.model.common.travel.cruise.CruiselineTravelDetails;
import com.paysafe.payments.model.common.travel.lodging.LodgingDetails;
import com.paysafe.payments.model.lpm.Splitpay;
import com.paysafe.payments.model.settlement.enums.SettlementPaymentType;
import com.paysafe.payments.model.settlement.enums.SettlementStatus;



/**
 * Represents the details of a settlement transaction, including payment type, amount available for refund, transaction time, status and other related fields.
 */
public class Settlement {

  @JsonProperty("id")
  private String id;
  @JsonProperty("merchantRefNum")
  private String merchantRefNum;
  @JsonProperty("amount")
  private Integer amount;
  @JsonProperty("dupCheck")
  private Boolean dupCheck;
  @JsonProperty("splitpay")
  private List<Splitpay> splitpay;
  @JsonProperty("airlineTravelDetails")
  private AirlineTravelDetails airlineTravelDetails;
  @JsonProperty("cruiselineTravelDetails")
  private CruiselineTravelDetails cruiselineTravelDetails;
  @JsonProperty("lodgingDetails")
  private LodgingDetails lodgingDetails;
  @JsonProperty("carRentalDetails")
  private CarRentalDetails carRentalDetails;
  @JsonProperty("paymentType")
  private SettlementPaymentType paymentType;
  @JsonProperty("availableToRefund")
  private Integer availableToRefund;
  @JsonProperty("childAccountNum")
  private String childAccountNum;
  @JsonProperty("txnTime")
  private String txnTime;
  @JsonProperty("status")
  private SettlementStatus status;
  @JsonProperty("riskReasonCode")
  private List<Integer> riskReasonCode;
  @JsonProperty("gatewayResponse")
  private GatewayResponse gatewayResponse;
  @JsonProperty("gatewayReconciliationId")
  private String gatewayReconciliationId;
  @JsonProperty("liveMode")
  private Boolean liveMode;
  @JsonProperty("updatedTime")
  private String updatedTime;
  @JsonProperty("statusTime")
  private String statusTime;
  @JsonProperty("error")
  private Error error;

  public Settlement() {
    super();
  }

  private Settlement(final Builder builder) {
    setId(builder.id);
    setMerchantRefNum(builder.merchantRefNum);
    setAmount(builder.amount);
    setDupCheck(builder.dupCheck);
    setSplitpay(builder.splitpay);
    setAirlineTravelDetails(builder.airlineTravelDetails);
    setCruiselineTravelDetails(builder.cruiselineTravelDetails);
    setLodgingDetails(builder.lodgingDetails);
    setCarRentalDetails(builder.carRentalDetails);
    setPaymentType(builder.paymentType);
    setAvailableToRefund(builder.availableToRefund);
    setChildAccountNum(builder.childAccountNum);
    setTxnTime(builder.txnTime);
    setStatus(builder.status);
    setRiskReasonCode(builder.riskReasonCode);
    setGatewayResponse(builder.gatewayResponse);
    setGatewayReconciliationId(builder.gatewayReconciliationId);
    setLiveMode(builder.liveMode);
    setUpdatedTime(builder.updatedTime);
    setStatusTime(builder.statusTime);
    setError(builder.error);
  }

  public static Builder builder() {
    return new Builder();
  }


  public Settlement id(String id) {
    this.id = id;
    return this;
  }

  /**
   * This is the ID returned in the response. This ID can be used for future associated request.
   *
   * @return id
   */
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public Settlement merchantRefNum(String merchantRefNum) {
    this.merchantRefNum = merchantRefNum;
    return this;
  }

  /**
   * This is the merchant reference number created by the merchant and submitted as part of the request. It must be unique for each request.
   *
   * @return merchantRefNum
   */
  public String getMerchantRefNum() {
    return merchantRefNum;
  }

  public void setMerchantRefNum(String merchantRefNum) {
    this.merchantRefNum = merchantRefNum;
  }


  public Settlement amount(Integer amount) {
    this.amount = amount;
    return this;
  }

  /**
   * This is the amount of the request, in minor units.For example, to process US $10.99, this value should be 1099. Maximum: 99999999999
   *
   * @return amount
   */
  public Integer getAmount() {
    return amount;
  }

  public void setAmount(Integer amount) {
    this.amount = amount;
  }


  public Settlement dupCheck(Boolean dupCheck) {
    this.dupCheck = dupCheck;
    return this;
  }

  /**
   * This validates that this request is not a duplicate. A request is considered a duplicate if the merchantRefNum has already been used in a previous request within the past 90 days. **Note:** This value defaults to true
   *
   * @return dupCheck
   */
  public Boolean getDupCheck() {
    return dupCheck;
  }

  public void setDupCheck(Boolean dupCheck) {
    this.dupCheck = dupCheck;
  }


  public Settlement splitpay(List<Splitpay> splitpay) {
    this.splitpay = splitpay;
    return this;
  }

  public Settlement addSplitpayItem(Splitpay splitpayItem) {
    if (this.splitpay == null) {
      this.splitpay = new ArrayList<>();
    }
    this.splitpay.add(splitpayItem);
    return this;
  }

  public Settlement removeSplitpayItem(Splitpay splitpayItem) {
    if (splitpayItem != null && this.splitpay != null) {
      this.splitpay.remove(splitpayItem);
    }

    return this;
  }

  /**
   * Get splitpay
   *
   * @return splitpay
   */
  public List<Splitpay> getSplitpay() {
    return splitpay;
  }

  public void setSplitpay(List<Splitpay> splitpay) {
    this.splitpay = splitpay;
  }


  public Settlement airlineTravelDetails(AirlineTravelDetails airlineTravelDetails) {
    this.airlineTravelDetails = airlineTravelDetails;
    return this;
  }

  /**
   * Get airlineTravelDetails
   *
   * @return airlineTravelDetails
   */
  public AirlineTravelDetails getAirlineTravelDetails() {
    return airlineTravelDetails;
  }

  public void setAirlineTravelDetails(AirlineTravelDetails airlineTravelDetails) {
    this.airlineTravelDetails = airlineTravelDetails;
  }


  public Settlement cruiselineTravelDetails(CruiselineTravelDetails cruiselineTravelDetails) {
    this.cruiselineTravelDetails = cruiselineTravelDetails;
    return this;
  }

  /**
   * Get cruiselineTravelDetails
   *
   * @return cruiselineTravelDetails
   */
  public CruiselineTravelDetails getCruiselineTravelDetails() {
    return cruiselineTravelDetails;
  }

  public void setCruiselineTravelDetails(CruiselineTravelDetails cruiselineTravelDetails) {
    this.cruiselineTravelDetails = cruiselineTravelDetails;
  }


  public Settlement lodgingDetails(LodgingDetails lodgingDetails) {
    this.lodgingDetails = lodgingDetails;
    return this;
  }

  /**
   * Get lodgingDetails
   *
   * @return lodgingDetails
   */
  public LodgingDetails getLodgingDetails() {
    return lodgingDetails;
  }

  public void setLodgingDetails(LodgingDetails lodgingDetails) {
    this.lodgingDetails = lodgingDetails;
  }


  public Settlement carRentalDetails(CarRentalDetails carRentalDetails) {
    this.carRentalDetails = carRentalDetails;
    return this;
  }

  /**
   * Get carRentalDetails
   *
   * @return carRentalDetails
   */
  public CarRentalDetails getCarRentalDetails() {
    return carRentalDetails;
  }

  public void setCarRentalDetails(CarRentalDetails carRentalDetails) {
    this.carRentalDetails = carRentalDetails;
  }


  public Settlement paymentType(SettlementPaymentType paymentType) {
    this.paymentType = paymentType;
    return this;
  }

  /**
   * Get paymentType
   *
   * @return paymentType
   */
  public SettlementPaymentType getPaymentType() {
    return paymentType;
  }

  public void setPaymentType(SettlementPaymentType paymentType) {
    this.paymentType = paymentType;
  }


  public Settlement availableToRefund(Integer availableToRefund) {
    this.availableToRefund = availableToRefund;
    return this;
  }

  /**
   * This is the remaining amount of the refund, in minor units.99. Maximum: 99999999999
   *
   * @return availableToRefund
   */
  public Integer getAvailableToRefund() {
    return availableToRefund;
  }

  public void setAvailableToRefund(Integer availableToRefund) {
    this.availableToRefund = availableToRefund;
  }


  public Settlement childAccountNum(String childAccountNum) {
    this.childAccountNum = childAccountNum;
    return this;
  }

  /**
   * This is the child merchant account number. It is returned only if the transaction was processed via a master account.
   *
   * @return childAccountNum
   */
  public String getChildAccountNum() {
    return childAccountNum;
  }

  public void setChildAccountNum(String childAccountNum) {
    this.childAccountNum = childAccountNum;
  }


  public Settlement txnTime(String txnTime) {
    this.txnTime = txnTime;
    return this;
  }

  /**
   * This is the date and time the request was processed. For example: 2014-01-26T10:32:28Z
   *
   * @return txnTime
   */
  public String getTxnTime() {
    return txnTime;
  }

  public void setTxnTime(String txnTime) {
    this.txnTime = txnTime;
  }


  public Settlement status(SettlementStatus status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   *
   * @return status
   */
  public SettlementStatus getStatus() {
    return status;
  }

  public void setStatus(SettlementStatus status) {
    this.status = status;
  }


  public Settlement riskReasonCode(List<Integer> riskReasonCode) {
    this.riskReasonCode = riskReasonCode;
    return this;
  }

  public Settlement addRiskReasonCodeItem(Integer riskReasonCodeItem) {
    if (this.riskReasonCode == null) {
      this.riskReasonCode = new ArrayList<>();
    }
    this.riskReasonCode.add(riskReasonCodeItem);
    return this;
  }

  public Settlement removeRiskReasonCodeItem(Integer riskReasonCodeItem) {
    if (riskReasonCodeItem != null && this.riskReasonCode != null) {
      this.riskReasonCode.remove(riskReasonCodeItem);
    }

    return this;
  }

  /**
   * An array of integers is returned, displaying the detailed Risk reason codes if your transaction was declined. It is returned only if your account is configured accordingly.
   *
   * @return riskReasonCode
   */
  public List<Integer> getRiskReasonCode() {
    return riskReasonCode;
  }

  public void setRiskReasonCode(List<Integer> riskReasonCode) {
    this.riskReasonCode = riskReasonCode;
  }


  public Settlement gatewayResponse(GatewayResponse gatewayResponse) {
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


  public Settlement gatewayReconciliationId(String gatewayReconciliationId) {
    this.gatewayReconciliationId = gatewayReconciliationId;
    return this;
  }

  /**
   * It is the id which is common between paysafe and payment serivce provider.
   *
   * @return gatewayReconciliationId
   */
  public String getGatewayReconciliationId() {
    return gatewayReconciliationId;
  }

  public void setGatewayReconciliationId(String gatewayReconciliationId) {
    this.gatewayReconciliationId = gatewayReconciliationId;
  }


  public Settlement liveMode(Boolean liveMode) {
    this.liveMode = liveMode;
    return this;
  }

  /**
   * This flag indicates the envrionment.  - true - Production - false - Non-Production
   *
   * @return liveMode
   */
  public Boolean getLiveMode() {
    return liveMode;
  }

  public void setLiveMode(Boolean liveMode) {
    this.liveMode = liveMode;
  }


  public Settlement updatedTime(String updatedTime) {
    this.updatedTime = updatedTime;
    return this;
  }

  /**
   * ISO 8601 format (UTC). This is the date and time the resource was last updated.
   *
   * @return updatedTime
   */
  public String getUpdatedTime() {
    return updatedTime;
  }

  public void setUpdatedTime(String updatedTime) {
    this.updatedTime = updatedTime;
  }


  public Settlement statusTime(String statusTime) {
    this.statusTime = statusTime;
    return this;
  }

  /**
   * ISO 8601 format (UTC). This is the date and time the resource was last updated.
   *
   * @return statusTime
   */
  public String getStatusTime() {
    return statusTime;
  }

  public void setStatusTime(String statusTime) {
    this.statusTime = statusTime;
  }


  public Settlement error(Error error) {
    this.error = error;
    return this;
  }

  /**
   * Get error
   *
   * @return error
   */
  public Error getError() {
    return error;
  }

  public void setError(Error error) {
    this.error = error;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Settlement settlement = (Settlement) o;
    return Objects.equals(this.id, settlement.id) &&
        Objects.equals(this.merchantRefNum, settlement.merchantRefNum) &&
        Objects.equals(this.amount, settlement.amount) &&
        Objects.equals(this.dupCheck, settlement.dupCheck) &&
        Objects.equals(this.splitpay, settlement.splitpay) &&
        Objects.equals(this.airlineTravelDetails, settlement.airlineTravelDetails) &&
        Objects.equals(this.cruiselineTravelDetails, settlement.cruiselineTravelDetails) &&
        Objects.equals(this.lodgingDetails, settlement.lodgingDetails) &&
        Objects.equals(this.carRentalDetails, settlement.carRentalDetails) &&
        Objects.equals(this.paymentType, settlement.paymentType) &&
        Objects.equals(this.availableToRefund, settlement.availableToRefund) &&
        Objects.equals(this.childAccountNum, settlement.childAccountNum) &&
        Objects.equals(this.txnTime, settlement.txnTime) &&
        Objects.equals(this.status, settlement.status) &&
        Objects.equals(this.riskReasonCode, settlement.riskReasonCode) &&
        Objects.equals(this.gatewayResponse, settlement.gatewayResponse) &&
        Objects.equals(this.gatewayReconciliationId, settlement.gatewayReconciliationId) &&
        Objects.equals(this.liveMode, settlement.liveMode) &&
        Objects.equals(this.updatedTime, settlement.updatedTime) &&
        Objects.equals(this.statusTime, settlement.statusTime) &&
        Objects.equals(this.error, settlement.error);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, merchantRefNum, amount, dupCheck, splitpay, airlineTravelDetails, cruiselineTravelDetails, lodgingDetails, carRentalDetails, paymentType, availableToRefund, childAccountNum, txnTime, status, riskReasonCode, gatewayResponse, gatewayReconciliationId, liveMode, updatedTime, statusTime, error);
  }

  @Override
  public String toString() {

    return "class Settlement {\n"
        + "    id: " + toIndentedString(id) + "\n"
        + "    merchantRefNum: " + toIndentedString(merchantRefNum) + "\n"
        + "    amount: " + toIndentedString(amount) + "\n"
        + "    dupCheck: " + toIndentedString(dupCheck) + "\n"
        + "    splitpay: " + toIndentedString(splitpay) + "\n"
        + "    airlineTravelDetails: " + toIndentedString(airlineTravelDetails) + "\n"
        + "    cruiselineTravelDetails: " + toIndentedString(cruiselineTravelDetails) + "\n"
        + "    lodgingDetails: " + toIndentedString(lodgingDetails) + "\n"
        + "    carRentalDetails: " + toIndentedString(carRentalDetails) + "\n"
        + "    paymentType: " + toIndentedString(paymentType) + "\n"
        + "    availableToRefund: " + toIndentedString(availableToRefund) + "\n"
        + "    childAccountNum: " + toIndentedString(childAccountNum) + "\n"
        + "    txnTime: " + toIndentedString(txnTime) + "\n"
        + "    status: " + toIndentedString(status) + "\n"
        + "    riskReasonCode: " + toIndentedString(riskReasonCode) + "\n"
        + "    gatewayResponse: " + toIndentedString(gatewayResponse) + "\n"
        + "    gatewayReconciliationId: " + toIndentedString(gatewayReconciliationId) + "\n"
        + "    liveMode: " + toIndentedString(liveMode) + "\n"
        + "    updatedTime: " + toIndentedString(updatedTime) + "\n"
        + "    statusTime: " + toIndentedString(statusTime) + "\n"
        + "    error: " + toIndentedString(error) + "\n"
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
   * Represents the details of a settlement transaction, including payment type, amount available for refund, transaction time, status and other related fields. builder static inner class.
   */
  public static final class Builder {
    private String id;
    private String merchantRefNum;
    private Integer amount;
    private Boolean dupCheck;
    private List<Splitpay> splitpay;
    private AirlineTravelDetails airlineTravelDetails;
    private CruiselineTravelDetails cruiselineTravelDetails;
    private LodgingDetails lodgingDetails;
    private CarRentalDetails carRentalDetails;
    private SettlementPaymentType paymentType;
    private Integer availableToRefund;
    private String childAccountNum;
    private String txnTime;
    private SettlementStatus status;
    private List<Integer> riskReasonCode;
    private GatewayResponse gatewayResponse;
    private String gatewayReconciliationId;
    private Boolean liveMode;
    private String updatedTime;
    private String statusTime;
    private Error error;

    private Builder() {
    }

    /**
     * This is the ID returned in the response. This ID can be used for future associated request.
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
     * This is the merchant reference number created by the merchant and submitted as part of the request. It must be unique for each request.
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
     * This is the amount of the request, in minor units.For example, to process US $10.99, this value should be 1099. Maximum: 99999999999
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
     * This validates that this request is not a duplicate. A request is considered a duplicate if the merchantRefNum has already been used in a previous request within the past 90 days. **Note:** This value defaults to true
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
     * Get splitpay
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
     * Sets the airlineTravelDetails and returns a reference to this Builder enabling method chaining.
     *
     * @param airlineTravelDetails the airlineTravelDetails to set
     * @return a reference to this Builder
     */
    public Builder airlineTravelDetails(AirlineTravelDetails airlineTravelDetails) {
      this.airlineTravelDetails = airlineTravelDetails;
      return this;
    }

    /**
     * Sets the cruiselineTravelDetails and returns a reference to this Builder enabling method chaining.
     *
     * @param cruiselineTravelDetails the cruiselineTravelDetails to set
     * @return a reference to this Builder
     */
    public Builder cruiselineTravelDetails(CruiselineTravelDetails cruiselineTravelDetails) {
      this.cruiselineTravelDetails = cruiselineTravelDetails;
      return this;
    }

    /**
     * Sets the lodgingDetails and returns a reference to this Builder enabling method chaining.
     *
     * @param lodgingDetails the lodgingDetails to set
     * @return a reference to this Builder
     */
    public Builder lodgingDetails(LodgingDetails lodgingDetails) {
      this.lodgingDetails = lodgingDetails;
      return this;
    }

    /**
     * Sets the carRentalDetails and returns a reference to this Builder enabling method chaining.
     *
     * @param carRentalDetails the carRentalDetails to set
     * @return a reference to this Builder
     */
    public Builder carRentalDetails(CarRentalDetails carRentalDetails) {
      this.carRentalDetails = carRentalDetails;
      return this;
    }

    /**
     * Sets the paymentType and returns a reference to this Builder enabling method chaining.
     *
     * @param paymentType the paymentType to set
     * @return a reference to this Builder
     */
    public Builder paymentType(SettlementPaymentType paymentType) {
      this.paymentType = paymentType;
      return this;
    }

    /**
     * This is the remaining amount of the refund, in minor units.99. Maximum: 99999999999
     * <p>
     * Sets the availableToRefund and returns a reference to this Builder enabling method chaining.
     *
     * @param availableToRefund the availableToRefund to set
     * @return a reference to this Builder
     */
    public Builder availableToRefund(Integer availableToRefund) {
      this.availableToRefund = availableToRefund;
      return this;
    }

    /**
     * This is the child merchant account number. It is returned only if the transaction was processed via a master account.
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
     * This is the date and time the request was processed. For example: 2014-01-26T10:32:28Z
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
    public Builder status(SettlementStatus status) {
      this.status = status;
      return this;
    }

    /**
     * An array of integers is returned, displaying the detailed Risk reason codes if your transaction was declined. It is returned only if your account is configured accordingly.
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
     * It is the id which is common between paysafe and payment serivce provider.
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
     * This flag indicates the envrionment.  - true - Production - false - Non-Production
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
     * ISO 8601 format (UTC). This is the date and time the resource was last updated.
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
     * ISO 8601 format (UTC). This is the date and time the resource was last updated.
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
     * Sets the error and returns a reference to this Builder enabling method chaining.
     *
     * @param error the error to set
     * @return a reference to this Builder
     */
    public Builder error(Error error) {
      this.error = error;
      return this;
    }

    /**
     * Returns a Settlement built from the parameters previously set.
     *
     * @return a Settlement built with parameters of this Settlement.Builder
     */
    public Settlement build() {
      return new Settlement(this);
    }
  }
}
