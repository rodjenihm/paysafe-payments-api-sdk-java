// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.model.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.paysafe.payments.model.card.enums.AvsResponse;
import com.paysafe.payments.model.common.enums.CvvVerification;
import com.paysafe.payments.model.common.enums.FirstNameVerification;
import com.paysafe.payments.model.common.enums.LastNameVerification;
import com.paysafe.payments.model.common.enums.NameVerification;
import com.paysafe.payments.model.customer.Customer;
import com.paysafe.payments.model.lpm.Skrill;
import com.paysafe.payments.model.payment.Payment;



/**
 * Read only raw response from the acquirer or PSP.
 */
public class GatewayResponse {

  @JsonProperty("id")
  private String id;
  @JsonProperty("processor")
  private String processor;
  @JsonProperty("code")
  private String code;
  @JsonProperty("responseCode")
  private String responseCode;
  @JsonProperty("responseCodeDescription")
  private String responseCodeDescription;
  @JsonProperty("avsCode")
  private String avsCode;
  @JsonProperty("avsResponse")
  private AvsResponse avsResponse;
  @JsonProperty("nameVerification")
  private NameVerification nameVerification;
  @JsonProperty("firstNameVerification")
  private FirstNameVerification firstNameVerification;
  @JsonProperty("lastNameVerification")
  private LastNameVerification lastNameVerification;
  @JsonProperty("balanceResponse")
  private String balanceResponse;
  @JsonProperty("mid")
  private String mid;
  @JsonProperty("terminalId")
  private String terminalId;
  @JsonProperty("batchNumber")
  private String batchNumber;
  @JsonProperty("seqNumber")
  private String seqNumber;
  @JsonProperty("effectiveDate")
  private String effectiveDate;
  @JsonProperty("financingType")
  private String financingType;
  @JsonProperty("plan")
  private String plan;
  @JsonProperty("gracePeriod")
  private String gracePeriod;
  @JsonProperty("term")
  private String term;
  @JsonProperty("responseId")
  private String responseId;
  @JsonProperty("requestId")
  private String requestId;
  @JsonProperty("description")
  private String description;
  @JsonProperty("authCode")
  private String authCode;
  @JsonProperty("txnDateTime")
  private String txnDateTime;
  @JsonProperty("referenceNbr")
  private String referenceNbr;
  @JsonProperty("responseReasonCode")
  private String responseReasonCode;
  @JsonProperty("cvvVerification")
  private CvvVerification cvvVerification;
  @JsonProperty("cvv2Result")
  private String cvv2Result;
  @JsonProperty("status")
  private String status;
  @JsonProperty("orderId")
  private String orderId;
  @JsonProperty("operationId")
  private String operationId;
  @JsonProperty("transaction_id")
  private String transactionId;
  @JsonProperty("amount")
  private String amount;
  @JsonProperty("mb_transaction_id")
  private String mbTransactionId;
  @JsonProperty("pay_from_email")
  private String payFromEmail;
  @JsonProperty("pay_to_email")
  private String payToEmail;
  @JsonProperty("currency")
  private String currency;
  @JsonProperty("merchant_id")
  private String merchantId;
  @JsonProperty("payerName")
  private String payerName;
  @JsonProperty("payerIban")
  private String payerIban;
  @JsonProperty("sid")
  private String sid;

  public GatewayResponse() {
    super();
  }

  private GatewayResponse(final Builder builder) {
    setId(builder.id);
    setProcessor(builder.processor);
    setCode(builder.code);
    setResponseCode(builder.responseCode);
    setResponseCodeDescription(builder.responseCodeDescription);
    setAvsCode(builder.avsCode);
    setAvsResponse(builder.avsResponse);
    setNameVerification(builder.nameVerification);
    setFirstNameVerification(builder.firstNameVerification);
    setLastNameVerification(builder.lastNameVerification);
    setBalanceResponse(builder.balanceResponse);
    setMid(builder.mid);
    setTerminalId(builder.terminalId);
    setBatchNumber(builder.batchNumber);
    setSeqNumber(builder.seqNumber);
    setEffectiveDate(builder.effectiveDate);
    setFinancingType(builder.financingType);
    setPlan(builder.plan);
    setGracePeriod(builder.gracePeriod);
    setTerm(builder.term);
    setResponseId(builder.responseId);
    setRequestId(builder.requestId);
    setDescription(builder.description);
    setAuthCode(builder.authCode);
    setTxnDateTime(builder.txnDateTime);
    setReferenceNbr(builder.referenceNbr);
    setResponseReasonCode(builder.responseReasonCode);
    setCvvVerification(builder.cvvVerification);
    setCvv2Result(builder.cvv2Result);
    setStatus(builder.status);
    setOrderId(builder.orderId);
    setOperationId(builder.operationId);
    setTransactionId(builder.transactionId);
    setAmount(builder.amount);
    setMbTransactionId(builder.mbTransactionId);
    setPayFromEmail(builder.payFromEmail);
    setPayToEmail(builder.payToEmail);
    setCurrency(builder.currency);
    setMerchantId(builder.merchantId);
    setPayerName(builder.payerName);
    setPayerIban(builder.payerIban);
    setSid(builder.sid);
  }

  public static Builder builder() {
    return new Builder();
  }


  public GatewayResponse id(String id) {
    this.id = id;
    return this;
  }

  /**
   * The response id returned by the processor
   *
   * @return id
   */
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public GatewayResponse processor(String processor) {
    this.processor = processor;
    return this;
  }

  /**
   * The processor code of the transaction at Paysafe side
   *
   * @return processor
   */
  public String getProcessor() {
    return processor;
  }

  public void setProcessor(String processor) {
    this.processor = processor;
  }


  public GatewayResponse code(String code) {
    this.code = code;
    return this;
  }

  /**
   * Acquirer identification code, such as VPS, GPS, etc.
   *
   * @return code
   */
  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }


  public GatewayResponse responseCode(String responseCode) {
    this.responseCode = responseCode;
    return this;
  }

  /**
   * The raw response returned by the acquirer
   *
   * @return responseCode
   */
  public String getResponseCode() {
    return responseCode;
  }

  public void setResponseCode(String responseCode) {
    this.responseCode = responseCode;
  }


  public GatewayResponse responseCodeDescription(String responseCodeDescription) {
    this.responseCodeDescription = responseCodeDescription;
    return this;
  }

  /**
   * The raw response code description returned by the acquirer
   *
   * @return responseCodeDescription
   */
  public String getResponseCodeDescription() {
    return responseCodeDescription;
  }

  public void setResponseCodeDescription(String responseCodeDescription) {
    this.responseCodeDescription = responseCodeDescription;
  }


  public GatewayResponse avsCode(String avsCode) {
    this.avsCode = avsCode;
    return this;
  }

  /**
   * The raw AVS code returned by the acquirer
   *
   * @return avsCode
   */
  public String getAvsCode() {
    return avsCode;
  }

  public void setAvsCode(String avsCode) {
    this.avsCode = avsCode;
  }


  public GatewayResponse avsResponse(AvsResponse avsResponse) {
    this.avsResponse = avsResponse;
    return this;
  }

  /**
   * Get avsResponse
   *
   * @return avsResponse
   */
  public AvsResponse getAvsResponse() {
    return avsResponse;
  }

  public void setAvsResponse(AvsResponse avsResponse) {
    this.avsResponse = avsResponse;
  }


  public GatewayResponse nameVerification(NameVerification nameVerification) {
    this.nameVerification = nameVerification;
    return this;
  }

  /**
   * Get nameVerification
   *
   * @return nameVerification
   */
  public NameVerification getNameVerification() {
    return nameVerification;
  }

  public void setNameVerification(NameVerification nameVerification) {
    this.nameVerification = nameVerification;
  }


  public GatewayResponse firstNameVerification(FirstNameVerification firstNameVerification) {
    this.firstNameVerification = firstNameVerification;
    return this;
  }

  /**
   * Get firstNameVerification
   *
   * @return firstNameVerification
   */
  public FirstNameVerification getFirstNameVerification() {
    return firstNameVerification;
  }

  public void setFirstNameVerification(FirstNameVerification firstNameVerification) {
    this.firstNameVerification = firstNameVerification;
  }


  public GatewayResponse lastNameVerification(LastNameVerification lastNameVerification) {
    this.lastNameVerification = lastNameVerification;
    return this;
  }

  /**
   * Get lastNameVerification
   *
   * @return lastNameVerification
   */
  public LastNameVerification getLastNameVerification() {
    return lastNameVerification;
  }

  public void setLastNameVerification(LastNameVerification lastNameVerification) {
    this.lastNameVerification = lastNameVerification;
  }


  public GatewayResponse balanceResponse(String balanceResponse) {
    this.balanceResponse = balanceResponse;
    return this;
  }

  /**
   * The balance response from the acquirer
   *
   * @return balanceResponse
   */
  public String getBalanceResponse() {
    return balanceResponse;
  }

  public void setBalanceResponse(String balanceResponse) {
    this.balanceResponse = balanceResponse;
  }


  public GatewayResponse mid(String mid) {
    this.mid = mid;
    return this;
  }

  /**
   * Acquirer MID that was sent to the clearing house.
   *
   * @return mid
   */
  public String getMid() {
    return mid;
  }

  public void setMid(String mid) {
    this.mid = mid;
  }


  public GatewayResponse terminalId(String terminalId) {
    this.terminalId = terminalId;
    return this;
  }

  /**
   * Merchant's Terminal identification number
   *
   * @return terminalId
   */
  public String getTerminalId() {
    return terminalId;
  }

  public void setTerminalId(String terminalId) {
    this.terminalId = terminalId;
  }


  public GatewayResponse batchNumber(String batchNumber) {
    this.batchNumber = batchNumber;
    return this;
  }

  /**
   * Batch number for the transaction
   *
   * @return batchNumber
   */
  public String getBatchNumber() {
    return batchNumber;
  }

  public void setBatchNumber(String batchNumber) {
    this.batchNumber = batchNumber;
  }


  public GatewayResponse seqNumber(String seqNumber) {
    this.seqNumber = seqNumber;
    return this;
  }

  /**
   * Merchant's Sequence number for the transaction
   *
   * @return seqNumber
   */
  public String getSeqNumber() {
    return seqNumber;
  }

  public void setSeqNumber(String seqNumber) {
    this.seqNumber = seqNumber;
  }


  public GatewayResponse effectiveDate(String effectiveDate) {
    this.effectiveDate = effectiveDate;
    return this;
  }

  /**
   * Date of the bank deposit associated with the transaction.
   *
   * @return effectiveDate
   */
  public String getEffectiveDate() {
    return effectiveDate;
  }

  public void setEffectiveDate(String effectiveDate) {
    this.effectiveDate = effectiveDate;
  }


  public GatewayResponse financingType(String financingType) {
    this.financingType = financingType;
    return this;
  }

  /**
   * Type of financing offered
   *
   * @return financingType
   */
  public String getFinancingType() {
    return financingType;
  }

  public void setFinancingType(String financingType) {
    this.financingType = financingType;
  }


  public GatewayResponse plan(String plan) {
    this.plan = plan;
    return this;
  }

  /**
   * Plan number for this financing transaction
   *
   * @return plan
   */
  public String getPlan() {
    return plan;
  }

  public void setPlan(String plan) {
    this.plan = plan;
  }


  public GatewayResponse gracePeriod(String gracePeriod) {
    this.gracePeriod = gracePeriod;
    return this;
  }

  /**
   * Grace period, in months, associated with deferred payment transactions
   *
   * @return gracePeriod
   */
  public String getGracePeriod() {
    return gracePeriod;
  }

  public void setGracePeriod(String gracePeriod) {
    this.gracePeriod = gracePeriod;
  }


  public GatewayResponse term(String term) {
    this.term = term;
    return this;
  }

  /**
   * Number of payments, in months, for equal payment transactions
   *
   * @return term
   */
  public String getTerm() {
    return term;
  }

  public void setTerm(String term) {
    this.term = term;
  }


  public GatewayResponse responseId(String responseId) {
    this.responseId = responseId;
    return this;
  }

  /**
   * Response ID assigned by Credorax.
   *
   * @return responseId
   */
  public String getResponseId() {
    return responseId;
  }

  public void setResponseId(String responseId) {
    this.responseId = responseId;
  }


  public GatewayResponse requestId(String requestId) {
    this.requestId = requestId;
    return this;
  }

  /**
   * Request ID assigned by Paysafe.
   *
   * @return requestId
   */
  public String getRequestId() {
    return requestId;
  }

  public void setRequestId(String requestId) {
    this.requestId = requestId;
  }


  public GatewayResponse description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Description of the response
   *
   * @return description
   */
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  public GatewayResponse authCode(String authCode) {
    this.authCode = authCode;
    return this;
  }

  /**
   * Authorization code assigned by the acquirer
   *
   * @return authCode
   */
  public String getAuthCode() {
    return authCode;
  }

  public void setAuthCode(String authCode) {
    this.authCode = authCode;
  }


  public GatewayResponse txnDateTime(String txnDateTime) {
    this.txnDateTime = txnDateTime;
    return this;
  }

  /**
   * Date and time of the transaction
   *
   * @return txnDateTime
   */
  public String getTxnDateTime() {
    return txnDateTime;
  }

  public void setTxnDateTime(String txnDateTime) {
    this.txnDateTime = txnDateTime;
  }


  public GatewayResponse referenceNbr(String referenceNbr) {
    this.referenceNbr = referenceNbr;
    return this;
  }

  /**
   * Bank net transaction ID/Merch Tran Ref
   *
   * @return referenceNbr
   */
  public String getReferenceNbr() {
    return referenceNbr;
  }

  public void setReferenceNbr(String referenceNbr) {
    this.referenceNbr = referenceNbr;
  }


  public GatewayResponse responseReasonCode(String responseReasonCode) {
    this.responseReasonCode = responseReasonCode;
    return this;
  }

  /**
   * raw response reason code returned by Acquirer
   *
   * @return responseReasonCode
   */
  public String getResponseReasonCode() {
    return responseReasonCode;
  }

  public void setResponseReasonCode(String responseReasonCode) {
    this.responseReasonCode = responseReasonCode;
  }


  public GatewayResponse cvvVerification(CvvVerification cvvVerification) {
    this.cvvVerification = cvvVerification;
    return this;
  }

  /**
   * Get cvvVerification
   *
   * @return cvvVerification
   */
  public CvvVerification getCvvVerification() {
    return cvvVerification;
  }

  public void setCvvVerification(CvvVerification cvvVerification) {
    this.cvvVerification = cvvVerification;
  }


  public GatewayResponse cvv2Result(String cvv2Result) {
    this.cvv2Result = cvv2Result;
    return this;
  }

  /**
   * Raw CVV2 result code
   *
   * @return cvv2Result
   */
  public String getCvv2Result() {
    return cvv2Result;
  }

  public void setCvv2Result(String cvv2Result) {
    this.cvv2Result = cvv2Result;
  }


  public GatewayResponse status(String status) {
    this.status = status;
    return this;
  }

  /**
   * Status of the transaction at the processor side
   *
   * @return status
   */
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }


  public GatewayResponse orderId(String orderId) {
    this.orderId = orderId;
    return this;
  }

  /**
   * Unique NETELLER reference for the order
   *
   * @return orderId
   */
  public String getOrderId() {
    return orderId;
  }

  public void setOrderId(String orderId) {
    this.orderId = orderId;
  }


  public GatewayResponse operationId(String operationId) {
    this.operationId = operationId;
    return this;
  }

  /**
   * Transaction identifier at Safetypay
   *
   * @return operationId
   */
  public String getOperationId() {
    return operationId;
  }

  public void setOperationId(String operationId) {
    this.operationId = operationId;
  }


  public GatewayResponse transactionId(String transactionId) {
    this.transactionId = transactionId;
    return this;
  }

  /**
   * This transaction id is generated by Paysafe Gateway
   *
   * @return transactionId
   */
  public String getTransactionId() {
    return transactionId;
  }

  public void setTransactionId(String transactionId) {
    this.transactionId = transactionId;
  }


  public GatewayResponse amount(String amount) {
    this.amount = amount;
    return this;
  }

  /**
   * Transaction amount
   *
   * @return amount
   */
  public String getAmount() {
    return amount;
  }

  public void setAmount(String amount) {
    this.amount = amount;
  }


  public GatewayResponse mbTransactionId(String mbTransactionId) {
    this.mbTransactionId = mbTransactionId;
    return this;
  }

  /**
   * Unique transaction id at Skrill end
   *
   * @return mbTransactionId
   */
  public String getMbTransactionId() {
    return mbTransactionId;
  }

  public void setMbTransactionId(String mbTransactionId) {
    this.mbTransactionId = mbTransactionId;
  }


  public GatewayResponse payFromEmail(String payFromEmail) {
    this.payFromEmail = payFromEmail;
    return this;
  }

  /**
   * Customer email using which Payment has been completed. This is same as \"skrill.consumerId\" sent in the paymentHandle request.
   *
   * @return payFromEmail
   */
  public String getPayFromEmail() {
    return payFromEmail;
  }

  public void setPayFromEmail(String payFromEmail) {
    this.payFromEmail = payFromEmail;
  }


  public GatewayResponse payToEmail(String payToEmail) {
    this.payToEmail = payToEmail;
    return this;
  }

  /**
   * Merchant's email
   *
   * @return payToEmail
   */
  public String getPayToEmail() {
    return payToEmail;
  }

  public void setPayToEmail(String payToEmail) {
    this.payToEmail = payToEmail;
  }


  public GatewayResponse currency(String currency) {
    this.currency = currency;
    return this;
  }

  /**
   * Transaction currency
   *
   * @return currency
   */
  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }


  public GatewayResponse merchantId(String merchantId) {
    this.merchantId = merchantId;
    return this;
  }

  /**
   * Skrill Merchant ID
   *
   * @return merchantId
   */
  public String getMerchantId() {
    return merchantId;
  }

  public void setMerchantId(String merchantId) {
    this.merchantId = merchantId;
  }


  public GatewayResponse payerName(String payerName) {
    this.payerName = payerName;
    return this;
  }

  /**
   * The customer's account name after successful payment. **Note:** Supported Payment Method: EPS
   *
   * @return payerName
   */
  public String getPayerName() {
    return payerName;
  }

  public void setPayerName(String payerName) {
    this.payerName = payerName;
  }


  public GatewayResponse payerIban(String payerIban) {
    this.payerIban = payerIban;
    return this;
  }

  /**
   * The customer's IBAN after successful payment. **Note:** Supported Payment Method: EPS
   *
   * @return payerIban
   */
  public String getPayerIban() {
    return payerIban;
  }

  public void setPayerIban(String payerIban) {
    this.payerIban = payerIban;
  }


  public GatewayResponse sid(String sid) {
    this.sid = sid;
    return this;
  }

  /**
   * Skrll session id during which transaction is completed
   *
   * @return sid
   */
  public String getSid() {
    return sid;
  }

  public void setSid(String sid) {
    this.sid = sid;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GatewayResponse gatewayResponse = (GatewayResponse) o;
    return Objects.equals(this.id, gatewayResponse.id) &&
        Objects.equals(this.processor, gatewayResponse.processor) &&
        Objects.equals(this.code, gatewayResponse.code) &&
        Objects.equals(this.responseCode, gatewayResponse.responseCode) &&
        Objects.equals(this.responseCodeDescription, gatewayResponse.responseCodeDescription) &&
        Objects.equals(this.avsCode, gatewayResponse.avsCode) &&
        Objects.equals(this.avsResponse, gatewayResponse.avsResponse) &&
        Objects.equals(this.nameVerification, gatewayResponse.nameVerification) &&
        Objects.equals(this.firstNameVerification, gatewayResponse.firstNameVerification) &&
        Objects.equals(this.lastNameVerification, gatewayResponse.lastNameVerification) &&
        Objects.equals(this.balanceResponse, gatewayResponse.balanceResponse) &&
        Objects.equals(this.mid, gatewayResponse.mid) &&
        Objects.equals(this.terminalId, gatewayResponse.terminalId) &&
        Objects.equals(this.batchNumber, gatewayResponse.batchNumber) &&
        Objects.equals(this.seqNumber, gatewayResponse.seqNumber) &&
        Objects.equals(this.effectiveDate, gatewayResponse.effectiveDate) &&
        Objects.equals(this.financingType, gatewayResponse.financingType) &&
        Objects.equals(this.plan, gatewayResponse.plan) &&
        Objects.equals(this.gracePeriod, gatewayResponse.gracePeriod) &&
        Objects.equals(this.term, gatewayResponse.term) &&
        Objects.equals(this.responseId, gatewayResponse.responseId) &&
        Objects.equals(this.requestId, gatewayResponse.requestId) &&
        Objects.equals(this.description, gatewayResponse.description) &&
        Objects.equals(this.authCode, gatewayResponse.authCode) &&
        Objects.equals(this.txnDateTime, gatewayResponse.txnDateTime) &&
        Objects.equals(this.referenceNbr, gatewayResponse.referenceNbr) &&
        Objects.equals(this.responseReasonCode, gatewayResponse.responseReasonCode) &&
        Objects.equals(this.cvvVerification, gatewayResponse.cvvVerification) &&
        Objects.equals(this.cvv2Result, gatewayResponse.cvv2Result) &&
        Objects.equals(this.status, gatewayResponse.status) &&
        Objects.equals(this.orderId, gatewayResponse.orderId) &&
        Objects.equals(this.operationId, gatewayResponse.operationId) &&
        Objects.equals(this.transactionId, gatewayResponse.transactionId) &&
        Objects.equals(this.amount, gatewayResponse.amount) &&
        Objects.equals(this.mbTransactionId, gatewayResponse.mbTransactionId) &&
        Objects.equals(this.payFromEmail, gatewayResponse.payFromEmail) &&
        Objects.equals(this.payToEmail, gatewayResponse.payToEmail) &&
        Objects.equals(this.currency, gatewayResponse.currency) &&
        Objects.equals(this.merchantId, gatewayResponse.merchantId) &&
        Objects.equals(this.payerName, gatewayResponse.payerName) &&
        Objects.equals(this.payerIban, gatewayResponse.payerIban) &&
        Objects.equals(this.sid, gatewayResponse.sid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, processor, code, responseCode, responseCodeDescription, avsCode, avsResponse, nameVerification, firstNameVerification, lastNameVerification, balanceResponse, mid, terminalId, batchNumber, seqNumber, effectiveDate, financingType, plan, gracePeriod, term, responseId, requestId, description, authCode, txnDateTime, referenceNbr, responseReasonCode, cvvVerification, cvv2Result, status, orderId, operationId, transactionId, amount, mbTransactionId, payFromEmail, payToEmail, currency, merchantId, payerName, payerIban, sid);
  }

  @Override
  public String toString() {

    return "class GatewayResponse {\n"
        + "    id: " + toIndentedString(id) + "\n"
        + "    processor: " + toIndentedString(processor) + "\n"
        + "    code: " + toIndentedString(code) + "\n"
        + "    responseCode: " + toIndentedString(responseCode) + "\n"
        + "    responseCodeDescription: " + toIndentedString(responseCodeDescription) + "\n"
        + "    avsCode: " + toIndentedString(avsCode) + "\n"
        + "    avsResponse: " + toIndentedString(avsResponse) + "\n"
        + "    nameVerification: " + toIndentedString(nameVerification) + "\n"
        + "    firstNameVerification: " + toIndentedString(firstNameVerification) + "\n"
        + "    lastNameVerification: " + toIndentedString(lastNameVerification) + "\n"
        + "    balanceResponse: " + toIndentedString(balanceResponse) + "\n"
        + "    mid: " + toIndentedString(mid) + "\n"
        + "    terminalId: " + toIndentedString(terminalId) + "\n"
        + "    batchNumber: " + toIndentedString(batchNumber) + "\n"
        + "    seqNumber: " + toIndentedString(seqNumber) + "\n"
        + "    effectiveDate: " + toIndentedString(effectiveDate) + "\n"
        + "    financingType: " + toIndentedString(financingType) + "\n"
        + "    plan: " + toIndentedString(plan) + "\n"
        + "    gracePeriod: " + toIndentedString(gracePeriod) + "\n"
        + "    term: " + toIndentedString(term) + "\n"
        + "    responseId: " + toIndentedString(responseId) + "\n"
        + "    requestId: " + toIndentedString(requestId) + "\n"
        + "    description: " + toIndentedString(description) + "\n"
        + "    authCode: " + toIndentedString(authCode) + "\n"
        + "    txnDateTime: " + toIndentedString(txnDateTime) + "\n"
        + "    referenceNbr: " + toIndentedString(referenceNbr) + "\n"
        + "    responseReasonCode: " + toIndentedString(responseReasonCode) + "\n"
        + "    cvvVerification: " + toIndentedString(cvvVerification) + "\n"
        + "    cvv2Result: " + toIndentedString(cvv2Result) + "\n"
        + "    status: " + toIndentedString(status) + "\n"
        + "    orderId: " + toIndentedString(orderId) + "\n"
        + "    operationId: " + toIndentedString(operationId) + "\n"
        + "    transactionId: " + toIndentedString(transactionId) + "\n"
        + "    amount: " + toIndentedString(amount) + "\n"
        + "    mbTransactionId: " + toIndentedString(mbTransactionId) + "\n"
        + "    payFromEmail: " + toIndentedString(payFromEmail) + "\n"
        + "    payToEmail: " + toIndentedString(payToEmail) + "\n"
        + "    currency: " + toIndentedString(currency) + "\n"
        + "    merchantId: " + toIndentedString(merchantId) + "\n"
        + "    payerName: " + toIndentedString(payerName) + "\n"
        + "    payerIban: " + toIndentedString(payerIban) + "\n"
        + "    sid: " + toIndentedString(sid) + "\n"
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
   * Read only raw response from the acquirer or PSP. builder static inner class.
   */
  public static final class Builder {
    private String id;
    private String processor;
    private String code;
    private String responseCode;
    private String responseCodeDescription;
    private String avsCode;
    private AvsResponse avsResponse;
    private NameVerification nameVerification;
    private FirstNameVerification firstNameVerification;
    private LastNameVerification lastNameVerification;
    private String balanceResponse;
    private String mid;
    private String terminalId;
    private String batchNumber;
    private String seqNumber;
    private String effectiveDate;
    private String financingType;
    private String plan;
    private String gracePeriod;
    private String term;
    private String responseId;
    private String requestId;
    private String description;
    private String authCode;
    private String txnDateTime;
    private String referenceNbr;
    private String responseReasonCode;
    private CvvVerification cvvVerification;
    private String cvv2Result;
    private String status;
    private String orderId;
    private String operationId;
    private String transactionId;
    private String amount;
    private String mbTransactionId;
    private String payFromEmail;
    private String payToEmail;
    private String currency;
    private String merchantId;
    private String payerName;
    private String payerIban;
    private String sid;

    private Builder() {
    }

    /**
     * The response id returned by the processor
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
     * The processor code of the transaction at Paysafe side
     * <p>
     * Sets the processor and returns a reference to this Builder enabling method chaining.
     *
     * @param processor the processor to set
     * @return a reference to this Builder
     */
    public Builder processor(String processor) {
      this.processor = processor;
      return this;
    }

    /**
     * Acquirer identification code, such as VPS, GPS, etc.
     * <p>
     * Sets the code and returns a reference to this Builder enabling method chaining.
     *
     * @param code the code to set
     * @return a reference to this Builder
     */
    public Builder code(String code) {
      this.code = code;
      return this;
    }

    /**
     * The raw response returned by the acquirer
     * <p>
     * Sets the responseCode and returns a reference to this Builder enabling method chaining.
     *
     * @param responseCode the responseCode to set
     * @return a reference to this Builder
     */
    public Builder responseCode(String responseCode) {
      this.responseCode = responseCode;
      return this;
    }

    /**
     * The raw response code description returned by the acquirer
     * <p>
     * Sets the responseCodeDescription and returns a reference to this Builder enabling method chaining.
     *
     * @param responseCodeDescription the responseCodeDescription to set
     * @return a reference to this Builder
     */
    public Builder responseCodeDescription(String responseCodeDescription) {
      this.responseCodeDescription = responseCodeDescription;
      return this;
    }

    /**
     * The raw AVS code returned by the acquirer
     * <p>
     * Sets the avsCode and returns a reference to this Builder enabling method chaining.
     *
     * @param avsCode the avsCode to set
     * @return a reference to this Builder
     */
    public Builder avsCode(String avsCode) {
      this.avsCode = avsCode;
      return this;
    }

    /**
     * Sets the avsResponse and returns a reference to this Builder enabling method chaining.
     *
     * @param avsResponse the avsResponse to set
     * @return a reference to this Builder
     */
    public Builder avsResponse(AvsResponse avsResponse) {
      this.avsResponse = avsResponse;
      return this;
    }

    /**
     * Sets the nameVerification and returns a reference to this Builder enabling method chaining.
     *
     * @param nameVerification the nameVerification to set
     * @return a reference to this Builder
     */
    public Builder nameVerification(NameVerification nameVerification) {
      this.nameVerification = nameVerification;
      return this;
    }

    /**
     * Sets the firstNameVerification and returns a reference to this Builder enabling method chaining.
     *
     * @param firstNameVerification the firstNameVerification to set
     * @return a reference to this Builder
     */
    public Builder firstNameVerification(FirstNameVerification firstNameVerification) {
      this.firstNameVerification = firstNameVerification;
      return this;
    }

    /**
     * Sets the lastNameVerification and returns a reference to this Builder enabling method chaining.
     *
     * @param lastNameVerification the lastNameVerification to set
     * @return a reference to this Builder
     */
    public Builder lastNameVerification(LastNameVerification lastNameVerification) {
      this.lastNameVerification = lastNameVerification;
      return this;
    }

    /**
     * The balance response from the acquirer
     * <p>
     * Sets the balanceResponse and returns a reference to this Builder enabling method chaining.
     *
     * @param balanceResponse the balanceResponse to set
     * @return a reference to this Builder
     */
    public Builder balanceResponse(String balanceResponse) {
      this.balanceResponse = balanceResponse;
      return this;
    }

    /**
     * Acquirer MID that was sent to the clearing house.
     * <p>
     * Sets the mid and returns a reference to this Builder enabling method chaining.
     *
     * @param mid the mid to set
     * @return a reference to this Builder
     */
    public Builder mid(String mid) {
      this.mid = mid;
      return this;
    }

    /**
     * Merchant's Terminal identification number
     * <p>
     * Sets the terminalId and returns a reference to this Builder enabling method chaining.
     *
     * @param terminalId the terminalId to set
     * @return a reference to this Builder
     */
    public Builder terminalId(String terminalId) {
      this.terminalId = terminalId;
      return this;
    }

    /**
     * Batch number for the transaction
     * <p>
     * Sets the batchNumber and returns a reference to this Builder enabling method chaining.
     *
     * @param batchNumber the batchNumber to set
     * @return a reference to this Builder
     */
    public Builder batchNumber(String batchNumber) {
      this.batchNumber = batchNumber;
      return this;
    }

    /**
     * Merchant's Sequence number for the transaction
     * <p>
     * Sets the seqNumber and returns a reference to this Builder enabling method chaining.
     *
     * @param seqNumber the seqNumber to set
     * @return a reference to this Builder
     */
    public Builder seqNumber(String seqNumber) {
      this.seqNumber = seqNumber;
      return this;
    }

    /**
     * Date of the bank deposit associated with the transaction.
     * <p>
     * Sets the effectiveDate and returns a reference to this Builder enabling method chaining.
     *
     * @param effectiveDate the effectiveDate to set
     * @return a reference to this Builder
     */
    public Builder effectiveDate(String effectiveDate) {
      this.effectiveDate = effectiveDate;
      return this;
    }

    /**
     * Type of financing offered
     * <p>
     * Sets the financingType and returns a reference to this Builder enabling method chaining.
     *
     * @param financingType the financingType to set
     * @return a reference to this Builder
     */
    public Builder financingType(String financingType) {
      this.financingType = financingType;
      return this;
    }

    /**
     * Plan number for this financing transaction
     * <p>
     * Sets the plan and returns a reference to this Builder enabling method chaining.
     *
     * @param plan the plan to set
     * @return a reference to this Builder
     */
    public Builder plan(String plan) {
      this.plan = plan;
      return this;
    }

    /**
     * Grace period, in months, associated with deferred payment transactions
     * <p>
     * Sets the gracePeriod and returns a reference to this Builder enabling method chaining.
     *
     * @param gracePeriod the gracePeriod to set
     * @return a reference to this Builder
     */
    public Builder gracePeriod(String gracePeriod) {
      this.gracePeriod = gracePeriod;
      return this;
    }

    /**
     * Number of payments, in months, for equal payment transactions
     * <p>
     * Sets the term and returns a reference to this Builder enabling method chaining.
     *
     * @param term the term to set
     * @return a reference to this Builder
     */
    public Builder term(String term) {
      this.term = term;
      return this;
    }

    /**
     * Response ID assigned by Credorax.
     * <p>
     * Sets the responseId and returns a reference to this Builder enabling method chaining.
     *
     * @param responseId the responseId to set
     * @return a reference to this Builder
     */
    public Builder responseId(String responseId) {
      this.responseId = responseId;
      return this;
    }

    /**
     * Request ID assigned by Paysafe.
     * <p>
     * Sets the requestId and returns a reference to this Builder enabling method chaining.
     *
     * @param requestId the requestId to set
     * @return a reference to this Builder
     */
    public Builder requestId(String requestId) {
      this.requestId = requestId;
      return this;
    }

    /**
     * Description of the response
     * <p>
     * Sets the description and returns a reference to this Builder enabling method chaining.
     *
     * @param description the description to set
     * @return a reference to this Builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Authorization code assigned by the acquirer
     * <p>
     * Sets the authCode and returns a reference to this Builder enabling method chaining.
     *
     * @param authCode the authCode to set
     * @return a reference to this Builder
     */
    public Builder authCode(String authCode) {
      this.authCode = authCode;
      return this;
    }

    /**
     * Date and time of the transaction
     * <p>
     * Sets the txnDateTime and returns a reference to this Builder enabling method chaining.
     *
     * @param txnDateTime the txnDateTime to set
     * @return a reference to this Builder
     */
    public Builder txnDateTime(String txnDateTime) {
      this.txnDateTime = txnDateTime;
      return this;
    }

    /**
     * Bank net transaction ID/Merch Tran Ref
     * <p>
     * Sets the referenceNbr and returns a reference to this Builder enabling method chaining.
     *
     * @param referenceNbr the referenceNbr to set
     * @return a reference to this Builder
     */
    public Builder referenceNbr(String referenceNbr) {
      this.referenceNbr = referenceNbr;
      return this;
    }

    /**
     * raw response reason code returned by Acquirer
     * <p>
     * Sets the responseReasonCode and returns a reference to this Builder enabling method chaining.
     *
     * @param responseReasonCode the responseReasonCode to set
     * @return a reference to this Builder
     */
    public Builder responseReasonCode(String responseReasonCode) {
      this.responseReasonCode = responseReasonCode;
      return this;
    }

    /**
     * Sets the cvvVerification and returns a reference to this Builder enabling method chaining.
     *
     * @param cvvVerification the cvvVerification to set
     * @return a reference to this Builder
     */
    public Builder cvvVerification(CvvVerification cvvVerification) {
      this.cvvVerification = cvvVerification;
      return this;
    }

    /**
     * Raw CVV2 result code
     * <p>
     * Sets the cvv2Result and returns a reference to this Builder enabling method chaining.
     *
     * @param cvv2Result the cvv2Result to set
     * @return a reference to this Builder
     */
    public Builder cvv2Result(String cvv2Result) {
      this.cvv2Result = cvv2Result;
      return this;
    }

    /**
     * Status of the transaction at the processor side
     * <p>
     * Sets the status and returns a reference to this Builder enabling method chaining.
     *
     * @param status the status to set
     * @return a reference to this Builder
     */
    public Builder status(String status) {
      this.status = status;
      return this;
    }

    /**
     * Unique NETELLER reference for the order
     * <p>
     * Sets the orderId and returns a reference to this Builder enabling method chaining.
     *
     * @param orderId the orderId to set
     * @return a reference to this Builder
     */
    public Builder orderId(String orderId) {
      this.orderId = orderId;
      return this;
    }

    /**
     * Transaction identifier at Safetypay
     * <p>
     * Sets the operationId and returns a reference to this Builder enabling method chaining.
     *
     * @param operationId the operationId to set
     * @return a reference to this Builder
     */
    public Builder operationId(String operationId) {
      this.operationId = operationId;
      return this;
    }

    /**
     * This transaction id is generated by Paysafe Gateway
     * <p>
     * Sets the transactionId and returns a reference to this Builder enabling method chaining.
     *
     * @param transactionId the transactionId to set
     * @return a reference to this Builder
     */
    public Builder transactionId(String transactionId) {
      this.transactionId = transactionId;
      return this;
    }

    /**
     * Transaction amount
     * <p>
     * Sets the amount and returns a reference to this Builder enabling method chaining.
     *
     * @param amount the amount to set
     * @return a reference to this Builder
     */
    public Builder amount(String amount) {
      this.amount = amount;
      return this;
    }

    /**
     * Unique transaction id at Skrill end
     * <p>
     * Sets the mbTransactionId and returns a reference to this Builder enabling method chaining.
     *
     * @param mbTransactionId the mbTransactionId to set
     * @return a reference to this Builder
     */
    public Builder mbTransactionId(String mbTransactionId) {
      this.mbTransactionId = mbTransactionId;
      return this;
    }

    /**
     * Customer email using which Payment has been completed. This is same as \"skrill.consumerId\" sent in the paymentHandle request.
     * <p>
     * Sets the payFromEmail and returns a reference to this Builder enabling method chaining.
     *
     * @param payFromEmail the payFromEmail to set
     * @return a reference to this Builder
     */
    public Builder payFromEmail(String payFromEmail) {
      this.payFromEmail = payFromEmail;
      return this;
    }

    /**
     * Merchant's email
     * <p>
     * Sets the payToEmail and returns a reference to this Builder enabling method chaining.
     *
     * @param payToEmail the payToEmail to set
     * @return a reference to this Builder
     */
    public Builder payToEmail(String payToEmail) {
      this.payToEmail = payToEmail;
      return this;
    }

    /**
     * Transaction currency
     * <p>
     * Sets the currency and returns a reference to this Builder enabling method chaining.
     *
     * @param currency the currency to set
     * @return a reference to this Builder
     */
    public Builder currency(String currency) {
      this.currency = currency;
      return this;
    }

    /**
     * Skrill Merchant ID
     * <p>
     * Sets the merchantId and returns a reference to this Builder enabling method chaining.
     *
     * @param merchantId the merchantId to set
     * @return a reference to this Builder
     */
    public Builder merchantId(String merchantId) {
      this.merchantId = merchantId;
      return this;
    }

    /**
     * The customer's account name after successful payment. **Note:** Supported Payment Method: EPS
     * <p>
     * Sets the payerName and returns a reference to this Builder enabling method chaining.
     *
     * @param payerName the payerName to set
     * @return a reference to this Builder
     */
    public Builder payerName(String payerName) {
      this.payerName = payerName;
      return this;
    }

    /**
     * The customer's IBAN after successful payment. **Note:** Supported Payment Method: EPS
     * <p>
     * Sets the payerIban and returns a reference to this Builder enabling method chaining.
     *
     * @param payerIban the payerIban to set
     * @return a reference to this Builder
     */
    public Builder payerIban(String payerIban) {
      this.payerIban = payerIban;
      return this;
    }

    /**
     * Skrll session id during which transaction is completed
     * <p>
     * Sets the sid and returns a reference to this Builder enabling method chaining.
     *
     * @param sid the sid to set
     * @return a reference to this Builder
     */
    public Builder sid(String sid) {
      this.sid = sid;
      return this;
    }

    /**
     * Returns a GatewayResponse built from the parameters previously set.
     *
     * @return a GatewayResponse built with parameters of this GatewayResponse.Builder
     */
    public GatewayResponse build() {
      return new GatewayResponse(this);
    }
  }
}
