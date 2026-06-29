// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.model.paymenthandle;

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
import com.paysafe.payments.model.applepay.ApplePay;
import com.paysafe.payments.model.card.CardAuthentication;
import com.paysafe.payments.model.card.MerchantDescriptor;
import com.paysafe.payments.model.card.TokenizedCardDetails;
import com.paysafe.payments.model.card.enums.TransactionIntent;
import com.paysafe.payments.model.card.threeds.ThreeDs;
import com.paysafe.payments.model.common.BillingDetails;
import com.paysafe.payments.model.common.GatewayResponse;
import com.paysafe.payments.model.common.Link;
import com.paysafe.payments.model.common.Mandate;
import com.paysafe.payments.model.common.ReturnLink;
import com.paysafe.payments.model.common.ShippingDetails;
import com.paysafe.payments.model.common.enums.CurrencyCode;
import com.paysafe.payments.model.common.profile.Profile;
import com.paysafe.payments.model.customer.Customer;
import com.paysafe.payments.model.googlepay.GooglePay;
import com.paysafe.payments.model.lpm.Ach;
import com.paysafe.payments.model.lpm.Bacs;
import com.paysafe.payments.model.lpm.Eft;
import com.paysafe.payments.model.lpm.Interac;
import com.paysafe.payments.model.lpm.Mazooma;
import com.paysafe.payments.model.lpm.Neteller;
import com.paysafe.payments.model.lpm.PayByBank;
import com.paysafe.payments.model.lpm.Paypal;
import com.paysafe.payments.model.lpm.Paysafecard;
import com.paysafe.payments.model.lpm.Paysafecash;
import com.paysafe.payments.model.lpm.RapidTransfer;
import com.paysafe.payments.model.lpm.SafetyPayCash;
import com.paysafe.payments.model.lpm.Sepa;
import com.paysafe.payments.model.lpm.Sightline;
import com.paysafe.payments.model.lpm.Skrill1Tap;
import com.paysafe.payments.model.lpm.Skrill;
import com.paysafe.payments.model.lpm.Venmo;
import com.paysafe.payments.model.lpm.Vippreferred;
import com.paysafe.payments.model.payment.Payment;
import com.paysafe.payments.model.paymenthandle.enums.Action;
import com.paysafe.payments.model.paymenthandle.enums.ExecutionMode;
import com.paysafe.payments.model.paymenthandle.enums.PaymentHandleStatus;
import com.paysafe.payments.model.paymenthandle.enums.PaymentHandleUsage;
import com.paysafe.payments.model.paymenthandle.enums.PaymentType;
import com.paysafe.payments.model.paymenthandle.enums.TransactionType;



/**
 * Response containing payment handle information
 */
public class PaymentHandle extends BaseApiResponse {

  @JsonProperty("id")
  private String id;
  @JsonProperty("paymentHandleToken")
  private String paymentHandleToken;
  @JsonProperty("txnTime")
  private String txnTime;
  @JsonProperty("status")
  private PaymentHandleStatus status;
  @JsonProperty("liveMode")
  private Boolean liveMode;
  @JsonProperty("usage")
  private PaymentHandleUsage usage;
  @JsonProperty("updatedTime")
  private String updatedTime;
  @JsonProperty("statusTime")
  private String statusTime;
  @JsonProperty("links")
  private List<Link> links;
  @JsonProperty("timeToLiveSeconds")
  private Integer timeToLiveSeconds;
  @JsonProperty("action")
  private Action action;
  @JsonProperty("executionMode")
  private ExecutionMode executionMode;
  @JsonProperty("gatewayReconciliationId")
  private String gatewayReconciliationId;
  @JsonProperty("gatewayResponse")
  private GatewayResponse gatewayResponse;
  @JsonProperty("merchantRefNum")
  private String merchantRefNum;
  @JsonProperty("transactionType")
  private TransactionType transactionType;
  @JsonProperty("dupCheck")
  private Boolean dupCheck = true;
  @JsonProperty("accountId")
  private String accountId;
  @JsonProperty("paymentType")
  private PaymentType paymentType;
  @JsonProperty("amount")
  private Integer amount;
  @JsonProperty("merchantAccountId")
  private String merchantAccountId;
  @JsonProperty("currencyCode")
  private CurrencyCode currencyCode;
  @JsonProperty("card")
  private TokenizedCardDetails card;
  @JsonProperty("applePay")
  private ApplePay applePay;
  @JsonProperty("googlePay")
  private GooglePay googlePay;
  @JsonProperty("billingDetails")
  private BillingDetails billingDetails;
  @JsonProperty("shippingDetails")
  private ShippingDetails shippingDetails;
  @JsonProperty("profile")
  private Profile profile;
  @JsonProperty("merchantDescriptor")
  private MerchantDescriptor merchantDescriptor;
  @JsonProperty("customerIp")
  private String customerIp;
  @JsonProperty("returnLinks")
  private List<ReturnLink> returnLinks;
  @JsonProperty("threeDs")
  private ThreeDs threeDs;
  @JsonProperty("mandates")
  private List<Mandate> mandates;
  @JsonProperty("authentication")
  private CardAuthentication authentication;
  @JsonProperty("paymentHandleTokenFrom")
  private String paymentHandleTokenFrom;
  @JsonProperty("transactionIntent")
  private TransactionIntent transactionIntent;
  @JsonProperty("skrill")
  private Skrill skrill;
  @JsonProperty("neteller")
  private Neteller neteller;
  @JsonProperty("paysafecash")
  private Paysafecash paysafecash;
  @JsonProperty("paysafecard")
  private Paysafecard paysafecard;
  @JsonProperty("payPal")
  private Paypal payPal;
  @JsonProperty("venmo")
  private Venmo venmo;
  @JsonProperty("vippreferred")
  private Vippreferred vippreferred;
  @JsonProperty("mazooma")
  private Mazooma mazooma;
  @JsonProperty("sightline")
  private Sightline sightline;
  @JsonProperty("payByBank")
  private PayByBank payByBank;
  @JsonProperty("interacETransfer")
  private Interac interacETransfer;
  @JsonProperty("rapidTransfer")
  private RapidTransfer rapidTransfer;
  @JsonProperty("skrill1Tap")
  private Skrill1Tap skrill1Tap;
  @JsonProperty("ach")
  private Ach ach;
  @JsonProperty("eft")
  private Eft eft;
  @JsonProperty("bacs")
  private Bacs bacs;
  @JsonProperty("sepa")
  private Sepa sepa;
  @JsonProperty("safetyPayCash")
  private SafetyPayCash safetyPayCash;

  public PaymentHandle() {
    super();
  }

  private PaymentHandle(final Builder builder) {
    setId(builder.id);
    setPaymentHandleToken(builder.paymentHandleToken);
    setTxnTime(builder.txnTime);
    setStatus(builder.status);
    setLiveMode(builder.liveMode);
    setUsage(builder.usage);
    setUpdatedTime(builder.updatedTime);
    setStatusTime(builder.statusTime);
    setLinks(builder.links);
    setTimeToLiveSeconds(builder.timeToLiveSeconds);
    setAction(builder.action);
    setExecutionMode(builder.executionMode);
    setGatewayReconciliationId(builder.gatewayReconciliationId);
    setGatewayResponse(builder.gatewayResponse);
    setMerchantRefNum(builder.merchantRefNum);
    setTransactionType(builder.transactionType);
    setDupCheck(builder.dupCheck);
    setAccountId(builder.accountId);
    setPaymentType(builder.paymentType);
    setAmount(builder.amount);
    setMerchantAccountId(builder.merchantAccountId);
    setCurrencyCode(builder.currencyCode);
    setCard(builder.card);
    setApplePay(builder.applePay);
    setGooglePay(builder.googlePay);
    setBillingDetails(builder.billingDetails);
    setShippingDetails(builder.shippingDetails);
    setProfile(builder.profile);
    setMerchantDescriptor(builder.merchantDescriptor);
    setCustomerIp(builder.customerIp);
    setReturnLinks(builder.returnLinks);
    setThreeDs(builder.threeDs);
    setMandates(builder.mandates);
    setAuthentication(builder.authentication);
    setPaymentHandleTokenFrom(builder.paymentHandleTokenFrom);
    setTransactionIntent(builder.transactionIntent);
    setSkrill(builder.skrill);
    setNeteller(builder.neteller);
    setPaysafecash(builder.paysafecash);
    setPaysafecard(builder.paysafecard);
    setPayPal(builder.payPal);
    setVenmo(builder.venmo);
    setVippreferred(builder.vippreferred);
    setMazooma(builder.mazooma);
    setSightline(builder.sightline);
    setPayByBank(builder.payByBank);
    setInteracETransfer(builder.interacETransfer);
    setRapidTransfer(builder.rapidTransfer);
    setSkrill1Tap(builder.skrill1Tap);
    setAch(builder.ach);
    setEft(builder.eft);
    setBacs(builder.bacs);
    setSepa(builder.sepa);
    setSafetyPayCash(builder.safetyPayCash);
  }

  public static Builder builder() {
    return new Builder();
  }


  public PaymentHandle id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier for the payment handle
   *
   * @return id
   */
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public PaymentHandle paymentHandleToken(String paymentHandleToken) {
    this.paymentHandleToken = paymentHandleToken;
    return this;
  }

  /**
   * The payment token generated by Paysafe that will be used for Payment API requests
   *
   * @return paymentHandleToken
   */
  public String getPaymentHandleToken() {
    return paymentHandleToken;
  }

  public void setPaymentHandleToken(String paymentHandleToken) {
    this.paymentHandleToken = paymentHandleToken;
  }


  public PaymentHandle txnTime(String txnTime) {
    this.txnTime = txnTime;
    return this;
  }

  /**
   * Date and time the transaction was processed
   *
   * @return txnTime
   */
  public String getTxnTime() {
    return txnTime;
  }

  public void setTxnTime(String txnTime) {
    this.txnTime = txnTime;
  }


  public PaymentHandle status(PaymentHandleStatus status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   *
   * @return status
   */
  public PaymentHandleStatus getStatus() {
    return status;
  }

  public void setStatus(PaymentHandleStatus status) {
    this.status = status;
  }


  public PaymentHandle liveMode(Boolean liveMode) {
    this.liveMode = liveMode;
    return this;
  }

  /**
   * Indicates the environmenPaymentHandleUsage - true for Production, false for Non-Production
   *
   * @return liveMode
   */
  public Boolean getLiveMode() {
    return liveMode;
  }

  public void setLiveMode(Boolean liveMode) {
    this.liveMode = liveMode;
  }


  public PaymentHandle usage(PaymentHandleUsage usage) {
    this.usage = usage;
    return this;
  }

  /**
   * Get usage
   *
   * @return usage
   */
  public PaymentHandleUsage getUsage() {
    return usage;
  }

  public void setUsage(PaymentHandleUsage usage) {
    this.usage = usage;
  }


  public PaymentHandle updatedTime(String updatedTime) {
    this.updatedTime = updatedTime;
    return this;
  }

  /**
   * Date and time the transaction was last updated
   *
   * @return updatedTime
   */
  public String getUpdatedTime() {
    return updatedTime;
  }

  public void setUpdatedTime(String updatedTime) {
    this.updatedTime = updatedTime;
  }


  public PaymentHandle statusTime(String statusTime) {
    this.statusTime = statusTime;
    return this;
  }

  /**
   * Date and time when the status was last updated
   *
   * @return statusTime
   */
  public String getStatusTime() {
    return statusTime;
  }

  public void setStatusTime(String statusTime) {
    this.statusTime = statusTime;
  }


  public PaymentHandle links(List<Link> links) {
    this.links = links;
    return this;
  }

  public PaymentHandle addLinksItem(Link linksItem) {
    if (this.links == null) {
      this.links = new ArrayList<>();
    }
    this.links.add(linksItem);
    return this;
  }

  public PaymentHandle removeLinksItem(Link linksItem) {
    if (linksItem != null && this.links != null) {
      this.links.remove(linksItem);
    }

    return this;
  }

  /**
   * URL links to redirect customer during transaction flow
   *
   * @return links
   */
  public List<Link> getLinks() {
    return links;
  }

  public void setLinks(List<Link> links) {
    this.links = links;
  }


  public PaymentHandle timeToLiveSeconds(Integer timeToLiveSeconds) {
    this.timeToLiveSeconds = timeToLiveSeconds;
    return this;
  }

  /**
   * The time in seconds the payment handle is valid
   *
   * @return timeToLiveSeconds
   */
  public Integer getTimeToLiveSeconds() {
    return timeToLiveSeconds;
  }

  public void setTimeToLiveSeconds(Integer timeToLiveSeconds) {
    this.timeToLiveSeconds = timeToLiveSeconds;
  }


  public PaymentHandle action(Action action) {
    this.action = action;
    return this;
  }

  /**
   * Get action
   *
   * @return action
   */
  public Action getAction() {
    return action;
  }

  public void setAction(Action action) {
    this.action = action;
  }


  public PaymentHandle executionMode(ExecutionMode executionMode) {
    this.executionMode = executionMode;
    return this;
  }

  /**
   * Get executionMode
   *
   * @return executionMode
   */
  public ExecutionMode getExecutionMode() {
    return executionMode;
  }

  public void setExecutionMode(ExecutionMode executionMode) {
    this.executionMode = executionMode;
  }


  public PaymentHandle gatewayReconciliationId(String gatewayReconciliationId) {
    this.gatewayReconciliationId = gatewayReconciliationId;
    return this;
  }

  /**
   * Gateway reconciliation identifier
   *
   * @return gatewayReconciliationId
   */
  public String getGatewayReconciliationId() {
    return gatewayReconciliationId;
  }

  public void setGatewayReconciliationId(String gatewayReconciliationId) {
    this.gatewayReconciliationId = gatewayReconciliationId;
  }


  public PaymentHandle gatewayResponse(GatewayResponse gatewayResponse) {
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


  public PaymentHandle merchantRefNum(String merchantRefNum) {
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


  public PaymentHandle transactionType(TransactionType transactionType) {
    this.transactionType = transactionType;
    return this;
  }

  /**
   * Get transactionType
   *
   * @return transactionType
   */
  public TransactionType getTransactionType() {
    return transactionType;
  }

  public void setTransactionType(TransactionType transactionType) {
    this.transactionType = transactionType;
  }


  public PaymentHandle dupCheck(Boolean dupCheck) {
    this.dupCheck = dupCheck;
    return this;
  }

  /**
   * This validates that this request is not a duplicate. A duplicate request is when the merchantRefNum has already been used in a previous request within the past 90 days.
   *
   * @return dupCheck
   */
  public Boolean getDupCheck() {
    return dupCheck;
  }

  public void setDupCheck(Boolean dupCheck) {
    this.dupCheck = dupCheck;
  }


  public PaymentHandle accountId(String accountId) {
    this.accountId = accountId;
    return this;
  }

  /**
   * Required if you have more than one account configured for the same payment method and currency
   *
   * @return accountId
   */
  public String getAccountId() {
    return accountId;
  }

  public void setAccountId(String accountId) {
    this.accountId = accountId;
  }


  public PaymentHandle paymentType(PaymentType paymentType) {
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


  public PaymentHandle amount(Integer amount) {
    this.amount = amount;
    return this;
  }

  /**
   * The amount of the request in minor units (e.g., $10.99 = 1099)
   *
   * @return amount
   */
  public Integer getAmount() {
    return amount;
  }

  public void setAmount(Integer amount) {
    this.amount = amount;
  }


  public PaymentHandle merchantAccountId(String merchantAccountId) {
    this.merchantAccountId = merchantAccountId;
    return this;
  }

  /**
   * merchantAccountId determines which of your accounts with Paysafe should be debited or credited for this transaction. It gives you greater control over how you manage your Paysafe balances. Currently, this field is conditional; it should be left null in all cases, except when all the following conditions are met: - You are executing a payout to a Skrill wallet that might not be registered (i.e. the payee may not already have a Skrill wallet ). - You must populate this field if these conditions are met. **Note:** Only applicable for SKRILL SCT.
   *
   * @return merchantAccountId
   */
  public String getMerchantAccountId() {
    return merchantAccountId;
  }

  public void setMerchantAccountId(String merchantAccountId) {
    this.merchantAccountId = merchantAccountId;
  }


  public PaymentHandle currencyCode(CurrencyCode currencyCode) {
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


  public PaymentHandle card(TokenizedCardDetails card) {
    this.card = card;
    return this;
  }

  /**
   * Get card
   *
   * @return card
   */
  public TokenizedCardDetails getCard() {
    return card;
  }

  public void setCard(TokenizedCardDetails card) {
    this.card = card;
  }


  public PaymentHandle applePay(ApplePay applePay) {
    this.applePay = applePay;
    return this;
  }

  /**
   * Get applePay
   *
   * @return applePay
   */
  public ApplePay getApplePay() {
    return applePay;
  }

  public void setApplePay(ApplePay applePay) {
    this.applePay = applePay;
  }


  public PaymentHandle googlePay(GooglePay googlePay) {
    this.googlePay = googlePay;
    return this;
  }

  /**
   * Get googlePay
   *
   * @return googlePay
   */
  public GooglePay getGooglePay() {
    return googlePay;
  }

  public void setGooglePay(GooglePay googlePay) {
    this.googlePay = googlePay;
  }


  public PaymentHandle billingDetails(BillingDetails billingDetails) {
    this.billingDetails = billingDetails;
    return this;
  }

  /**
   * Get billingDetails
   *
   * @return billingDetails
   */
  public BillingDetails getBillingDetails() {
    return billingDetails;
  }

  public void setBillingDetails(BillingDetails billingDetails) {
    this.billingDetails = billingDetails;
  }


  public PaymentHandle shippingDetails(ShippingDetails shippingDetails) {
    this.shippingDetails = shippingDetails;
    return this;
  }

  /**
   * Get shippingDetails
   *
   * @return shippingDetails
   */
  public ShippingDetails getShippingDetails() {
    return shippingDetails;
  }

  public void setShippingDetails(ShippingDetails shippingDetails) {
    this.shippingDetails = shippingDetails;
  }


  public PaymentHandle profile(Profile profile) {
    this.profile = profile;
    return this;
  }

  /**
   * Get profile
   *
   * @return profile
   */
  public Profile getProfile() {
    return profile;
  }

  public void setProfile(Profile profile) {
    this.profile = profile;
  }


  public PaymentHandle merchantDescriptor(MerchantDescriptor merchantDescriptor) {
    this.merchantDescriptor = merchantDescriptor;
    return this;
  }

  /**
   * Get merchantDescriptor
   *
   * @return merchantDescriptor
   */
  public MerchantDescriptor getMerchantDescriptor() {
    return merchantDescriptor;
  }

  public void setMerchantDescriptor(MerchantDescriptor merchantDescriptor) {
    this.merchantDescriptor = merchantDescriptor;
  }


  public PaymentHandle customerIp(String customerIp) {
    this.customerIp = customerIp;
    return this;
  }

  /**
   * The customer's IP address
   *
   * @return customerIp
   */
  public String getCustomerIp() {
    return customerIp;
  }

  public void setCustomerIp(String customerIp) {
    this.customerIp = customerIp;
  }


  public PaymentHandle returnLinks(List<ReturnLink> returnLinks) {
    this.returnLinks = returnLinks;
    return this;
  }

  public PaymentHandle addReturnLinksItem(ReturnLink returnLinksItem) {
    if (this.returnLinks == null) {
      this.returnLinks = new ArrayList<>();
    }
    this.returnLinks.add(returnLinksItem);
    return this;
  }

  public PaymentHandle removeReturnLinksItem(ReturnLink returnLinksItem) {
    if (returnLinksItem != null && this.returnLinks != null) {
      this.returnLinks.remove(returnLinksItem);
    }

    return this;
  }

  /**
   * URL endpoints to redirect the customer after a redirection to an alternative payment or 3D Secure site
   *
   * @return returnLinks
   */
  public List<ReturnLink> getReturnLinks() {
    return returnLinks;
  }

  public void setReturnLinks(List<ReturnLink> returnLinks) {
    this.returnLinks = returnLinks;
  }


  public PaymentHandle threeDs(ThreeDs threeDs) {
    this.threeDs = threeDs;
    return this;
  }

  /**
   * Get threeDs
   *
   * @return threeDs
   */
  public ThreeDs getThreeDs() {
    return threeDs;
  }

  public void setThreeDs(ThreeDs threeDs) {
    this.threeDs = threeDs;
  }


  public PaymentHandle mandates(List<Mandate> mandates) {
    this.mandates = mandates;
    return this;
  }

  public PaymentHandle addMandatesItem(Mandate mandatesItem) {
    if (this.mandates == null) {
      this.mandates = new ArrayList<>();
    }
    this.mandates.add(mandatesItem);
    return this;
  }

  public PaymentHandle removeMandatesItem(Mandate mandatesItem) {
    if (mandatesItem != null && this.mandates != null) {
      this.mandates.remove(mandatesItem);
    }

    return this;
  }

  /**
   * List of mandates associated with the payment handle. This is the identifier of the mandate in the banking system.
   *
   * @return mandates
   */
  public List<Mandate> getMandates() {
    return mandates;
  }

  public void setMandates(List<Mandate> mandates) {
    this.mandates = mandates;
  }


  public PaymentHandle authentication(CardAuthentication authentication) {
    this.authentication = authentication;
    return this;
  }

  /**
   * Get authentication
   *
   * @return authentication
   */
  public CardAuthentication getAuthentication() {
    return authentication;
  }

  public void setAuthentication(CardAuthentication authentication) {
    this.authentication = authentication;
  }


  public PaymentHandle paymentHandleTokenFrom(String paymentHandleTokenFrom) {
    this.paymentHandleTokenFrom = paymentHandleTokenFrom;
    return this;
  }

  /**
   * An existing Customer Payment Handle from which the payment instrument and profile details are retrieved
   *
   * @return paymentHandleTokenFrom
   */
  public String getPaymentHandleTokenFrom() {
    return paymentHandleTokenFrom;
  }

  public void setPaymentHandleTokenFrom(String paymentHandleTokenFrom) {
    this.paymentHandleTokenFrom = paymentHandleTokenFrom;
  }


  public PaymentHandle transactionIntent(TransactionIntent transactionIntent) {
    this.transactionIntent = transactionIntent;
    return this;
  }

  /**
   * Get transactionIntent
   *
   * @return transactionIntent
   */
  public TransactionIntent getTransactionIntent() {
    return transactionIntent;
  }

  public void setTransactionIntent(TransactionIntent transactionIntent) {
    this.transactionIntent = transactionIntent;
  }


  public PaymentHandle skrill(Skrill skrill) {
    this.skrill = skrill;
    return this;
  }

  /**
   * Get skrill
   *
   * @return skrill
   */
  public Skrill getSkrill() {
    return skrill;
  }

  public void setSkrill(Skrill skrill) {
    this.skrill = skrill;
  }


  public PaymentHandle neteller(Neteller neteller) {
    this.neteller = neteller;
    return this;
  }

  /**
   * Get neteller
   *
   * @return neteller
   */
  public Neteller getNeteller() {
    return neteller;
  }

  public void setNeteller(Neteller neteller) {
    this.neteller = neteller;
  }


  public PaymentHandle paysafecash(Paysafecash paysafecash) {
    this.paysafecash = paysafecash;
    return this;
  }

  /**
   * Get paysafecash
   *
   * @return paysafecash
   */
  public Paysafecash getPaysafecash() {
    return paysafecash;
  }

  public void setPaysafecash(Paysafecash paysafecash) {
    this.paysafecash = paysafecash;
  }


  public PaymentHandle paysafecard(Paysafecard paysafecard) {
    this.paysafecard = paysafecard;
    return this;
  }

  /**
   * Get paysafecard
   *
   * @return paysafecard
   */
  public Paysafecard getPaysafecard() {
    return paysafecard;
  }

  public void setPaysafecard(Paysafecard paysafecard) {
    this.paysafecard = paysafecard;
  }


  public PaymentHandle payPal(Paypal payPal) {
    this.payPal = payPal;
    return this;
  }

  /**
   * Get payPal
   *
   * @return payPal
   */
  public Paypal getPayPal() {
    return payPal;
  }

  public void setPayPal(Paypal payPal) {
    this.payPal = payPal;
  }


  public PaymentHandle venmo(Venmo venmo) {
    this.venmo = venmo;
    return this;
  }

  /**
   * Get venmo
   *
   * @return venmo
   */
  public Venmo getVenmo() {
    return venmo;
  }

  public void setVenmo(Venmo venmo) {
    this.venmo = venmo;
  }


  public PaymentHandle vippreferred(Vippreferred vippreferred) {
    this.vippreferred = vippreferred;
    return this;
  }

  /**
   * Get vippreferred
   *
   * @return vippreferred
   */
  public Vippreferred getVippreferred() {
    return vippreferred;
  }

  public void setVippreferred(Vippreferred vippreferred) {
    this.vippreferred = vippreferred;
  }


  public PaymentHandle mazooma(Mazooma mazooma) {
    this.mazooma = mazooma;
    return this;
  }

  /**
   * Get mazooma
   *
   * @return mazooma
   */
  public Mazooma getMazooma() {
    return mazooma;
  }

  public void setMazooma(Mazooma mazooma) {
    this.mazooma = mazooma;
  }


  public PaymentHandle sightline(Sightline sightline) {
    this.sightline = sightline;
    return this;
  }

  /**
   * Get sightline
   *
   * @return sightline
   */
  public Sightline getSightline() {
    return sightline;
  }

  public void setSightline(Sightline sightline) {
    this.sightline = sightline;
  }


  public PaymentHandle payByBank(PayByBank payByBank) {
    this.payByBank = payByBank;
    return this;
  }

  /**
   * Get payByBank
   *
   * @return payByBank
   */
  public PayByBank getPayByBank() {
    return payByBank;
  }

  public void setPayByBank(PayByBank payByBank) {
    this.payByBank = payByBank;
  }


  public PaymentHandle interacETransfer(Interac interacETransfer) {
    this.interacETransfer = interacETransfer;
    return this;
  }

  /**
   * Get interacETransfer
   *
   * @return interacETransfer
   */
  public Interac getInteracETransfer() {
    return interacETransfer;
  }

  public void setInteracETransfer(Interac interacETransfer) {
    this.interacETransfer = interacETransfer;
  }


  public PaymentHandle rapidTransfer(RapidTransfer rapidTransfer) {
    this.rapidTransfer = rapidTransfer;
    return this;
  }

  /**
   * Get rapidTransfer
   *
   * @return rapidTransfer
   */
  public RapidTransfer getRapidTransfer() {
    return rapidTransfer;
  }

  public void setRapidTransfer(RapidTransfer rapidTransfer) {
    this.rapidTransfer = rapidTransfer;
  }


  public PaymentHandle skrill1Tap(Skrill1Tap skrill1Tap) {
    this.skrill1Tap = skrill1Tap;
    return this;
  }

  /**
   * Get skrill1Tap
   *
   * @return skrill1Tap
   */
  public Skrill1Tap getSkrill1Tap() {
    return skrill1Tap;
  }

  public void setSkrill1Tap(Skrill1Tap skrill1Tap) {
    this.skrill1Tap = skrill1Tap;
  }


  public PaymentHandle ach(Ach ach) {
    this.ach = ach;
    return this;
  }

  /**
   * Get ach
   *
   * @return ach
   */
  public Ach getAch() {
    return ach;
  }

  public void setAch(Ach ach) {
    this.ach = ach;
  }


  public PaymentHandle eft(Eft eft) {
    this.eft = eft;
    return this;
  }

  /**
   * Get eft
   *
   * @return eft
   */
  public Eft getEft() {
    return eft;
  }

  public void setEft(Eft eft) {
    this.eft = eft;
  }


  public PaymentHandle bacs(Bacs bacs) {
    this.bacs = bacs;
    return this;
  }

  /**
   * Get bacs
   *
   * @return bacs
   */
  public Bacs getBacs() {
    return bacs;
  }

  public void setBacs(Bacs bacs) {
    this.bacs = bacs;
  }


  public PaymentHandle sepa(Sepa sepa) {
    this.sepa = sepa;
    return this;
  }

  /**
   * Get sepa
   *
   * @return sepa
   */
  public Sepa getSepa() {
    return sepa;
  }

  public void setSepa(Sepa sepa) {
    this.sepa = sepa;
  }


  public PaymentHandle safetyPayCash(SafetyPayCash safetyPayCash) {
    this.safetyPayCash = safetyPayCash;
    return this;
  }

  /**
   * Get safetyPayCash
   *
   * @return safetyPayCash
   */
  public SafetyPayCash getSafetyPayCash() {
    return safetyPayCash;
  }

  public void setSafetyPayCash(SafetyPayCash safetyPayCash) {
    this.safetyPayCash = safetyPayCash;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PaymentHandle paymentHandle = (PaymentHandle) o;
    return Objects.equals(this.id, paymentHandle.id) &&
        Objects.equals(this.paymentHandleToken, paymentHandle.paymentHandleToken) &&
        Objects.equals(this.txnTime, paymentHandle.txnTime) &&
        Objects.equals(this.status, paymentHandle.status) &&
        Objects.equals(this.liveMode, paymentHandle.liveMode) &&
        Objects.equals(this.usage, paymentHandle.usage) &&
        Objects.equals(this.updatedTime, paymentHandle.updatedTime) &&
        Objects.equals(this.statusTime, paymentHandle.statusTime) &&
        Objects.equals(this.links, paymentHandle.links) &&
        Objects.equals(this.timeToLiveSeconds, paymentHandle.timeToLiveSeconds) &&
        Objects.equals(this.action, paymentHandle.action) &&
        Objects.equals(this.executionMode, paymentHandle.executionMode) &&
        Objects.equals(this.gatewayReconciliationId, paymentHandle.gatewayReconciliationId) &&
        Objects.equals(this.gatewayResponse, paymentHandle.gatewayResponse) &&
        Objects.equals(this.merchantRefNum, paymentHandle.merchantRefNum) &&
        Objects.equals(this.transactionType, paymentHandle.transactionType) &&
        Objects.equals(this.dupCheck, paymentHandle.dupCheck) &&
        Objects.equals(this.accountId, paymentHandle.accountId) &&
        Objects.equals(this.paymentType, paymentHandle.paymentType) &&
        Objects.equals(this.amount, paymentHandle.amount) &&
        Objects.equals(this.merchantAccountId, paymentHandle.merchantAccountId) &&
        Objects.equals(this.currencyCode, paymentHandle.currencyCode) &&
        Objects.equals(this.card, paymentHandle.card) &&
        Objects.equals(this.applePay, paymentHandle.applePay) &&
        Objects.equals(this.googlePay, paymentHandle.googlePay) &&
        Objects.equals(this.billingDetails, paymentHandle.billingDetails) &&
        Objects.equals(this.shippingDetails, paymentHandle.shippingDetails) &&
        Objects.equals(this.profile, paymentHandle.profile) &&
        Objects.equals(this.merchantDescriptor, paymentHandle.merchantDescriptor) &&
        Objects.equals(this.customerIp, paymentHandle.customerIp) &&
        Objects.equals(this.returnLinks, paymentHandle.returnLinks) &&
        Objects.equals(this.threeDs, paymentHandle.threeDs) &&
        Objects.equals(this.mandates, paymentHandle.mandates) &&
        Objects.equals(this.authentication, paymentHandle.authentication) &&
        Objects.equals(this.paymentHandleTokenFrom, paymentHandle.paymentHandleTokenFrom) &&
        Objects.equals(this.transactionIntent, paymentHandle.transactionIntent) &&
        Objects.equals(this.skrill, paymentHandle.skrill) &&
        Objects.equals(this.neteller, paymentHandle.neteller) &&
        Objects.equals(this.paysafecash, paymentHandle.paysafecash) &&
        Objects.equals(this.paysafecard, paymentHandle.paysafecard) &&
        Objects.equals(this.payPal, paymentHandle.payPal) &&
        Objects.equals(this.venmo, paymentHandle.venmo) &&
        Objects.equals(this.vippreferred, paymentHandle.vippreferred) &&
        Objects.equals(this.mazooma, paymentHandle.mazooma) &&
        Objects.equals(this.sightline, paymentHandle.sightline) &&
        Objects.equals(this.payByBank, paymentHandle.payByBank) &&
        Objects.equals(this.interacETransfer, paymentHandle.interacETransfer) &&
        Objects.equals(this.rapidTransfer, paymentHandle.rapidTransfer) &&
        Objects.equals(this.skrill1Tap, paymentHandle.skrill1Tap) &&
        Objects.equals(this.ach, paymentHandle.ach) &&
        Objects.equals(this.eft, paymentHandle.eft) &&
        Objects.equals(this.bacs, paymentHandle.bacs) &&
        Objects.equals(this.sepa, paymentHandle.sepa) &&
        Objects.equals(this.safetyPayCash, paymentHandle.safetyPayCash);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, paymentHandleToken, txnTime, status, liveMode, usage, updatedTime, statusTime, links, timeToLiveSeconds, action, executionMode, gatewayReconciliationId, gatewayResponse, merchantRefNum, transactionType, dupCheck, accountId, paymentType, amount, merchantAccountId, currencyCode, card, applePay, googlePay, billingDetails, shippingDetails, profile, merchantDescriptor, customerIp, returnLinks, threeDs, mandates, authentication, paymentHandleTokenFrom, transactionIntent, skrill, neteller, paysafecash, paysafecard, payPal, venmo, vippreferred, mazooma, sightline, payByBank, interacETransfer, rapidTransfer, skrill1Tap, ach, eft, bacs, sepa, safetyPayCash);
  }

  @Override
  public String toString() {

    return "class PaymentHandle {\n"
        + "    id: " + toIndentedString(id) + "\n"
        + "    paymentHandleToken: " + toIndentedString(paymentHandleToken) + "\n"
        + "    txnTime: " + toIndentedString(txnTime) + "\n"
        + "    status: " + toIndentedString(status) + "\n"
        + "    liveMode: " + toIndentedString(liveMode) + "\n"
        + "    usage: " + toIndentedString(usage) + "\n"
        + "    updatedTime: " + toIndentedString(updatedTime) + "\n"
        + "    statusTime: " + toIndentedString(statusTime) + "\n"
        + "    links: " + toIndentedString(links) + "\n"
        + "    timeToLiveSeconds: " + toIndentedString(timeToLiveSeconds) + "\n"
        + "    action: " + toIndentedString(action) + "\n"
        + "    executionMode: " + toIndentedString(executionMode) + "\n"
        + "    gatewayReconciliationId: " + toIndentedString(gatewayReconciliationId) + "\n"
        + "    gatewayResponse: " + toIndentedString(gatewayResponse) + "\n"
        + "    merchantRefNum: " + toIndentedString(merchantRefNum) + "\n"
        + "    transactionType: " + toIndentedString(transactionType) + "\n"
        + "    dupCheck: " + toIndentedString(dupCheck) + "\n"
        + "    accountId: " + toIndentedString(accountId) + "\n"
        + "    paymentType: " + toIndentedString(paymentType) + "\n"
        + "    amount: " + toIndentedString(amount) + "\n"
        + "    merchantAccountId: " + toIndentedString(merchantAccountId) + "\n"
        + "    currencyCode: " + toIndentedString(currencyCode) + "\n"
        + "    card: " + toIndentedString(card) + "\n"
        + "    applePay: " + toIndentedString(applePay) + "\n"
        + "    googlePay: " + toIndentedString(googlePay) + "\n"
        + "    billingDetails: " + toIndentedString(billingDetails) + "\n"
        + "    shippingDetails: " + toIndentedString(shippingDetails) + "\n"
        + "    profile: " + toIndentedString(profile) + "\n"
        + "    merchantDescriptor: " + toIndentedString(merchantDescriptor) + "\n"
        + "    customerIp: " + toIndentedString(customerIp) + "\n"
        + "    returnLinks: " + toIndentedString(returnLinks) + "\n"
        + "    threeDs: " + toIndentedString(threeDs) + "\n"
        + "    mandates: " + toIndentedString(mandates) + "\n"
        + "    authentication: " + toIndentedString(authentication) + "\n"
        + "    paymentHandleTokenFrom: " + toIndentedString(paymentHandleTokenFrom) + "\n"
        + "    transactionIntent: " + toIndentedString(transactionIntent) + "\n"
        + "    skrill: " + toIndentedString(skrill) + "\n"
        + "    neteller: " + toIndentedString(neteller) + "\n"
        + "    paysafecash: " + toIndentedString(paysafecash) + "\n"
        + "    paysafecard: " + toIndentedString(paysafecard) + "\n"
        + "    payPal: " + toIndentedString(payPal) + "\n"
        + "    venmo: " + toIndentedString(venmo) + "\n"
        + "    vippreferred: " + toIndentedString(vippreferred) + "\n"
        + "    mazooma: " + toIndentedString(mazooma) + "\n"
        + "    sightline: " + toIndentedString(sightline) + "\n"
        + "    payByBank: " + toIndentedString(payByBank) + "\n"
        + "    interacETransfer: " + toIndentedString(interacETransfer) + "\n"
        + "    rapidTransfer: " + toIndentedString(rapidTransfer) + "\n"
        + "    skrill1Tap: " + toIndentedString(skrill1Tap) + "\n"
        + "    ach: " + toIndentedString(ach) + "\n"
        + "    eft: " + toIndentedString(eft) + "\n"
        + "    bacs: " + toIndentedString(bacs) + "\n"
        + "    sepa: " + toIndentedString(sepa) + "\n"
        + "    safetyPayCash: " + toIndentedString(safetyPayCash) + "\n"
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
   * Response containing payment handle information builder static inner class.
   */
  public static final class Builder {
    private String id;
    private String paymentHandleToken;
    private String txnTime;
    private PaymentHandleStatus status;
    private Boolean liveMode;
    private PaymentHandleUsage usage;
    private String updatedTime;
    private String statusTime;
    private List<Link> links;
    private Integer timeToLiveSeconds;
    private Action action;
    private ExecutionMode executionMode;
    private String gatewayReconciliationId;
    private GatewayResponse gatewayResponse;
    private String merchantRefNum;
    private TransactionType transactionType;
    private Boolean dupCheck;
    private String accountId;
    private PaymentType paymentType;
    private Integer amount;
    private String merchantAccountId;
    private CurrencyCode currencyCode;
    private TokenizedCardDetails card;
    private ApplePay applePay;
    private GooglePay googlePay;
    private BillingDetails billingDetails;
    private ShippingDetails shippingDetails;
    private Profile profile;
    private MerchantDescriptor merchantDescriptor;
    private String customerIp;
    private List<ReturnLink> returnLinks;
    private ThreeDs threeDs;
    private List<Mandate> mandates;
    private CardAuthentication authentication;
    private String paymentHandleTokenFrom;
    private TransactionIntent transactionIntent;
    private Skrill skrill;
    private Neteller neteller;
    private Paysafecash paysafecash;
    private Paysafecard paysafecard;
    private Paypal payPal;
    private Venmo venmo;
    private Vippreferred vippreferred;
    private Mazooma mazooma;
    private Sightline sightline;
    private PayByBank payByBank;
    private Interac interacETransfer;
    private RapidTransfer rapidTransfer;
    private Skrill1Tap skrill1Tap;
    private Ach ach;
    private Eft eft;
    private Bacs bacs;
    private Sepa sepa;
    private SafetyPayCash safetyPayCash;

    private Builder() {
    }

    /**
     * Unique identifier for the payment handle
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
     * The payment token generated by Paysafe that will be used for Payment API requests
     * <p>
     * Sets the paymentHandleToken and returns a reference to this Builder enabling method chaining.
     *
     * @param paymentHandleToken the paymentHandleToken to set
     * @return a reference to this Builder
     */
    public Builder paymentHandleToken(String paymentHandleToken) {
      this.paymentHandleToken = paymentHandleToken;
      return this;
    }

    /**
     * Date and time the transaction was processed
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
    public Builder status(PaymentHandleStatus status) {
      this.status = status;
      return this;
    }

    /**
     * Indicates the environmenPaymentHandleUsage - true for Production, false for Non-Production
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
     * Sets the usage and returns a reference to this Builder enabling method chaining.
     *
     * @param usage the usage to set
     * @return a reference to this Builder
     */
    public Builder usage(PaymentHandleUsage usage) {
      this.usage = usage;
      return this;
    }

    /**
     * Date and time the transaction was last updated
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
     * Date and time when the status was last updated
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
     * URL links to redirect customer during transaction flow
     * <p>
     * Sets the links and returns a reference to this Builder enabling method chaining.
     *
     * @param links the links to set
     * @return a reference to this Builder
     */
    public Builder links(List<Link> links) {
      this.links = links;
      return this;
    }

    /**
     * The time in seconds the payment handle is valid
     * <p>
     * Sets the timeToLiveSeconds and returns a reference to this Builder enabling method chaining.
     *
     * @param timeToLiveSeconds the timeToLiveSeconds to set
     * @return a reference to this Builder
     */
    public Builder timeToLiveSeconds(Integer timeToLiveSeconds) {
      this.timeToLiveSeconds = timeToLiveSeconds;
      return this;
    }

    /**
     * Sets the action and returns a reference to this Builder enabling method chaining.
     *
     * @param action the action to set
     * @return a reference to this Builder
     */
    public Builder action(Action action) {
      this.action = action;
      return this;
    }

    /**
     * Sets the executionMode and returns a reference to this Builder enabling method chaining.
     *
     * @param executionMode the executionMode to set
     * @return a reference to this Builder
     */
    public Builder executionMode(ExecutionMode executionMode) {
      this.executionMode = executionMode;
      return this;
    }

    /**
     * Gateway reconciliation identifier
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
     * Sets the transactionType and returns a reference to this Builder enabling method chaining.
     *
     * @param transactionType the transactionType to set
     * @return a reference to this Builder
     */
    public Builder transactionType(TransactionType transactionType) {
      this.transactionType = transactionType;
      return this;
    }

    /**
     * This validates that this request is not a duplicate. A duplicate request is when the merchantRefNum has already been used in a previous request within the past 90 days.
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
     * Required if you have more than one account configured for the same payment method and currency
     * <p>
     * Sets the accountId and returns a reference to this Builder enabling method chaining.
     *
     * @param accountId the accountId to set
     * @return a reference to this Builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
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
     * The amount of the request in minor units (e.g., $10.99 = 1099)
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
     * merchantAccountId determines which of your accounts with Paysafe should be debited or credited for this transaction. It gives you greater control over how you manage your Paysafe balances. Currently, this field is conditional; it should be left null in all cases, except when all the following conditions are met: - You are executing a payout to a Skrill wallet that might not be registered (i.e. the payee may not already have a Skrill wallet ). - You must populate this field if these conditions are met. **Note:** Only applicable for SKRILL SCT.
     * <p>
     * Sets the merchantAccountId and returns a reference to this Builder enabling method chaining.
     *
     * @param merchantAccountId the merchantAccountId to set
     * @return a reference to this Builder
     */
    public Builder merchantAccountId(String merchantAccountId) {
      this.merchantAccountId = merchantAccountId;
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
     * Sets the card and returns a reference to this Builder enabling method chaining.
     *
     * @param card the card to set
     * @return a reference to this Builder
     */
    public Builder card(TokenizedCardDetails card) {
      this.card = card;
      return this;
    }

    /**
     * Sets the applePay and returns a reference to this Builder enabling method chaining.
     *
     * @param applePay the applePay to set
     * @return a reference to this Builder
     */
    public Builder applePay(ApplePay applePay) {
      this.applePay = applePay;
      return this;
    }

    /**
     * Sets the googlePay and returns a reference to this Builder enabling method chaining.
     *
     * @param googlePay the googlePay to set
     * @return a reference to this Builder
     */
    public Builder googlePay(GooglePay googlePay) {
      this.googlePay = googlePay;
      return this;
    }

    /**
     * Sets the billingDetails and returns a reference to this Builder enabling method chaining.
     *
     * @param billingDetails the billingDetails to set
     * @return a reference to this Builder
     */
    public Builder billingDetails(BillingDetails billingDetails) {
      this.billingDetails = billingDetails;
      return this;
    }

    /**
     * Sets the shippingDetails and returns a reference to this Builder enabling method chaining.
     *
     * @param shippingDetails the shippingDetails to set
     * @return a reference to this Builder
     */
    public Builder shippingDetails(ShippingDetails shippingDetails) {
      this.shippingDetails = shippingDetails;
      return this;
    }

    /**
     * Sets the profile and returns a reference to this Builder enabling method chaining.
     *
     * @param profile the profile to set
     * @return a reference to this Builder
     */
    public Builder profile(Profile profile) {
      this.profile = profile;
      return this;
    }

    /**
     * Sets the merchantDescriptor and returns a reference to this Builder enabling method chaining.
     *
     * @param merchantDescriptor the merchantDescriptor to set
     * @return a reference to this Builder
     */
    public Builder merchantDescriptor(MerchantDescriptor merchantDescriptor) {
      this.merchantDescriptor = merchantDescriptor;
      return this;
    }

    /**
     * The customer's IP address
     * <p>
     * Sets the customerIp and returns a reference to this Builder enabling method chaining.
     *
     * @param customerIp the customerIp to set
     * @return a reference to this Builder
     */
    public Builder customerIp(String customerIp) {
      this.customerIp = customerIp;
      return this;
    }

    /**
     * URL endpoints to redirect the customer after a redirection to an alternative payment or 3D Secure site
     * <p>
     * Sets the returnLinks and returns a reference to this Builder enabling method chaining.
     *
     * @param returnLinks the returnLinks to set
     * @return a reference to this Builder
     */
    public Builder returnLinks(List<ReturnLink> returnLinks) {
      this.returnLinks = returnLinks;
      return this;
    }

    /**
     * Sets the threeDs and returns a reference to this Builder enabling method chaining.
     *
     * @param threeDs the threeDs to set
     * @return a reference to this Builder
     */
    public Builder threeDs(ThreeDs threeDs) {
      this.threeDs = threeDs;
      return this;
    }

    /**
     * List of mandates associated with the payment handle. This is the identifier of the mandate in the banking system.
     * <p>
     * Sets the mandates and returns a reference to this Builder enabling method chaining.
     *
     * @param mandates the mandates to set
     * @return a reference to this Builder
     */
    public Builder mandates(List<Mandate> mandates) {
      this.mandates = mandates;
      return this;
    }

    /**
     * Sets the authentication and returns a reference to this Builder enabling method chaining.
     *
     * @param authentication the authentication to set
     * @return a reference to this Builder
     */
    public Builder authentication(CardAuthentication authentication) {
      this.authentication = authentication;
      return this;
    }

    /**
     * An existing Customer Payment Handle from which the payment instrument and profile details are retrieved
     * <p>
     * Sets the paymentHandleTokenFrom and returns a reference to this Builder enabling method chaining.
     *
     * @param paymentHandleTokenFrom the paymentHandleTokenFrom to set
     * @return a reference to this Builder
     */
    public Builder paymentHandleTokenFrom(String paymentHandleTokenFrom) {
      this.paymentHandleTokenFrom = paymentHandleTokenFrom;
      return this;
    }

    /**
     * Sets the transactionIntent and returns a reference to this Builder enabling method chaining.
     *
     * @param transactionIntent the transactionIntent to set
     * @return a reference to this Builder
     */
    public Builder transactionIntent(TransactionIntent transactionIntent) {
      this.transactionIntent = transactionIntent;
      return this;
    }

    /**
     * Sets the skrill and returns a reference to this Builder enabling method chaining.
     *
     * @param skrill the skrill to set
     * @return a reference to this Builder
     */
    public Builder skrill(Skrill skrill) {
      this.skrill = skrill;
      return this;
    }

    /**
     * Sets the neteller and returns a reference to this Builder enabling method chaining.
     *
     * @param neteller the neteller to set
     * @return a reference to this Builder
     */
    public Builder neteller(Neteller neteller) {
      this.neteller = neteller;
      return this;
    }

    /**
     * Sets the paysafecash and returns a reference to this Builder enabling method chaining.
     *
     * @param paysafecash the paysafecash to set
     * @return a reference to this Builder
     */
    public Builder paysafecash(Paysafecash paysafecash) {
      this.paysafecash = paysafecash;
      return this;
    }

    /**
     * Sets the paysafecard and returns a reference to this Builder enabling method chaining.
     *
     * @param paysafecard the paysafecard to set
     * @return a reference to this Builder
     */
    public Builder paysafecard(Paysafecard paysafecard) {
      this.paysafecard = paysafecard;
      return this;
    }

    /**
     * Sets the payPal and returns a reference to this Builder enabling method chaining.
     *
     * @param payPal the payPal to set
     * @return a reference to this Builder
     */
    public Builder payPal(Paypal payPal) {
      this.payPal = payPal;
      return this;
    }

    /**
     * Sets the venmo and returns a reference to this Builder enabling method chaining.
     *
     * @param venmo the venmo to set
     * @return a reference to this Builder
     */
    public Builder venmo(Venmo venmo) {
      this.venmo = venmo;
      return this;
    }

    /**
     * Sets the vippreferred and returns a reference to this Builder enabling method chaining.
     *
     * @param vippreferred the vippreferred to set
     * @return a reference to this Builder
     */
    public Builder vippreferred(Vippreferred vippreferred) {
      this.vippreferred = vippreferred;
      return this;
    }

    /**
     * Sets the mazooma and returns a reference to this Builder enabling method chaining.
     *
     * @param mazooma the mazooma to set
     * @return a reference to this Builder
     */
    public Builder mazooma(Mazooma mazooma) {
      this.mazooma = mazooma;
      return this;
    }

    /**
     * Sets the sightline and returns a reference to this Builder enabling method chaining.
     *
     * @param sightline the sightline to set
     * @return a reference to this Builder
     */
    public Builder sightline(Sightline sightline) {
      this.sightline = sightline;
      return this;
    }

    /**
     * Sets the payByBank and returns a reference to this Builder enabling method chaining.
     *
     * @param payByBank the payByBank to set
     * @return a reference to this Builder
     */
    public Builder payByBank(PayByBank payByBank) {
      this.payByBank = payByBank;
      return this;
    }

    /**
     * Sets the interacETransfer and returns a reference to this Builder enabling method chaining.
     *
     * @param interacETransfer the interacETransfer to set
     * @return a reference to this Builder
     */
    public Builder interacETransfer(Interac interacETransfer) {
      this.interacETransfer = interacETransfer;
      return this;
    }

    /**
     * Sets the rapidTransfer and returns a reference to this Builder enabling method chaining.
     *
     * @param rapidTransfer the rapidTransfer to set
     * @return a reference to this Builder
     */
    public Builder rapidTransfer(RapidTransfer rapidTransfer) {
      this.rapidTransfer = rapidTransfer;
      return this;
    }

    /**
     * Sets the skrill1Tap and returns a reference to this Builder enabling method chaining.
     *
     * @param skrill1Tap the skrill1Tap to set
     * @return a reference to this Builder
     */
    public Builder skrill1Tap(Skrill1Tap skrill1Tap) {
      this.skrill1Tap = skrill1Tap;
      return this;
    }

    /**
     * Sets the ach and returns a reference to this Builder enabling method chaining.
     *
     * @param ach the ach to set
     * @return a reference to this Builder
     */
    public Builder ach(Ach ach) {
      this.ach = ach;
      return this;
    }

    /**
     * Sets the eft and returns a reference to this Builder enabling method chaining.
     *
     * @param eft the eft to set
     * @return a reference to this Builder
     */
    public Builder eft(Eft eft) {
      this.eft = eft;
      return this;
    }

    /**
     * Sets the bacs and returns a reference to this Builder enabling method chaining.
     *
     * @param bacs the bacs to set
     * @return a reference to this Builder
     */
    public Builder bacs(Bacs bacs) {
      this.bacs = bacs;
      return this;
    }

    /**
     * Sets the sepa and returns a reference to this Builder enabling method chaining.
     *
     * @param sepa the sepa to set
     * @return a reference to this Builder
     */
    public Builder sepa(Sepa sepa) {
      this.sepa = sepa;
      return this;
    }

    /**
     * Sets the safetyPayCash and returns a reference to this Builder enabling method chaining.
     *
     * @param safetyPayCash the safetyPayCash to set
     * @return a reference to this Builder
     */
    public Builder safetyPayCash(SafetyPayCash safetyPayCash) {
      this.safetyPayCash = safetyPayCash;
      return this;
    }

    /**
     * Returns a PaymentHandle built from the parameters previously set.
     *
     * @return a PaymentHandle built with parameters of this PaymentHandle.Builder
     */
    public PaymentHandle build() {
      return new PaymentHandle(this);
    }
  }
}
