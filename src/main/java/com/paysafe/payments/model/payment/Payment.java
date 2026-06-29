// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.model.payment;

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
import com.paysafe.payments.model.card.AcquirerData;
import com.paysafe.payments.model.card.MerchantDescriptor;
import com.paysafe.payments.model.card.TokenizedCardDetails;
import com.paysafe.payments.model.card.enums.ProcessingRails;
import com.paysafe.payments.model.card.enums.TransactionIntent;
import com.paysafe.payments.model.card.threeds.Authentication;
import com.paysafe.payments.model.card.threeds.ThreeDs;
import com.paysafe.payments.model.common.BillingDetails;
import com.paysafe.payments.model.common.GatewayResponse;
import com.paysafe.payments.model.common.Mandate;
import com.paysafe.payments.model.common.enums.CurrencyCode;
import com.paysafe.payments.model.common.paymentfacilitator.PaymentFacilitator;
import com.paysafe.payments.model.common.profile.Profile;
import com.paysafe.payments.model.common.travel.airline.AirlineTravelDetails;
import com.paysafe.payments.model.common.travel.carrental.CarRentalDetails;
import com.paysafe.payments.model.common.travel.cruise.CruiselineTravelDetails;
import com.paysafe.payments.model.common.travel.lodging.LodgingDetails;
import com.paysafe.payments.model.customer.Customer;
import com.paysafe.payments.model.lpm.Ach;
import com.paysafe.payments.model.lpm.Bacs;
import com.paysafe.payments.model.lpm.Eft;
import com.paysafe.payments.model.lpm.Eps;
import com.paysafe.payments.model.lpm.Interac;
import com.paysafe.payments.model.lpm.Mazooma;
import com.paysafe.payments.model.lpm.MyBank;
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
import com.paysafe.payments.model.payment.enums.PaymentStatus;
import com.paysafe.payments.model.paymenthandle.enums.PaymentType;
import com.paysafe.payments.model.settlement.Settlement;
import com.paysafe.payments.model.standalonecredit.enums.SourceOfFunds;
import com.paysafe.payments.serialization.SettlementListOrObjectDeserializer;



/**
 * Represents the response of a payment transaction.
 */
public class Payment extends BaseApiResponse {

  @JsonProperty("id")
  private String id;
  @JsonProperty("merchantRefNum")
  private String merchantRefNum;
  @JsonProperty("amount")
  private Integer amount;
  @JsonProperty("dupCheck")
  private Boolean dupCheck;
  @JsonProperty("settleWithAuth")
  private Boolean settleWithAuth;
  @JsonProperty("paymentHandleToken")
  private String paymentHandleToken;
  @JsonProperty("customerIp")
  private String customerIp;
  @JsonProperty("currencyCode")
  private CurrencyCode currencyCode;
  @JsonProperty("card")
  private TokenizedCardDetails card;
  @JsonProperty("threeDs")
  private ThreeDs threeDs;
  @JsonProperty("authentication")
  private Authentication authentication;
  @JsonProperty("preAuth")
  private Boolean preAuth;
  @JsonProperty("paymentHandleTokenFrom")
  private String paymentHandleTokenFrom;
  @JsonProperty("transactionIntent")
  private TransactionIntent transactionIntent;
  @JsonProperty("gatewayResponse")
  private GatewayResponse gatewayResponse;
  @JsonProperty("sourceOfFunds")
  private SourceOfFunds sourceOfFunds;
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
  @JsonProperty("mybank")
  private MyBank mybank;
  @JsonProperty("eps")
  private Eps eps;
  @JsonProperty("mandates")
  private List<Mandate> mandates;
  @JsonProperty("availableToSettle")
  private Integer availableToSettle;
  @JsonProperty("childAccountNum")
  private String childAccountNum;
  @JsonProperty("txnTime")
  private String txnTime;
  @JsonProperty("paymentType")
  private PaymentType paymentType;
  @JsonProperty("status")
  private PaymentStatus status;
  @JsonProperty("statusReason")
  private String statusReason;
  @JsonProperty("riskReasonCode")
  private List<Integer> riskReasonCode;
  @JsonProperty("settlements")
  @JsonDeserialize(using = SettlementListOrObjectDeserializer.class)
  private List<Settlement> settlements;
  @JsonProperty("gatewayReconciliationId")
  private String gatewayReconciliationId;
  @JsonProperty("updatedTime")
  private String updatedTime;
  @JsonProperty("statusTime")
  private String statusTime;
  @JsonProperty("availableToRefund")
  private Integer availableToRefund;
  @JsonProperty("processingRails")
  private ProcessingRails processingRails;
  @JsonProperty("liveMode")
  private Boolean liveMode;
  @JsonProperty("billingDetails")
  private BillingDetails billingDetails;
  @JsonProperty("profile")
  private Profile profile;
  @JsonProperty("acquirerData")
  private AcquirerData acquirerData;
  @JsonProperty("paymentFacilitator")
  private PaymentFacilitator paymentFacilitator;
  @JsonProperty("airlineTravelDetails")
  private AirlineTravelDetails airlineTravelDetails;
  @JsonProperty("lodgingDetails")
  private LodgingDetails lodgingDetails;
  @JsonProperty("carRentalDetails")
  private CarRentalDetails carRentalDetails;
  @JsonProperty("cruiselineTravelDetails")
  private CruiselineTravelDetails cruiselineTravelDetails;
  @JsonProperty("merchantDescriptor")
  private MerchantDescriptor merchantDescriptor;
  @JsonProperty("keywords")
  private List<String> keywords;
  @JsonProperty("description")
  private String description;

  public Payment() {
    super();
  }

  private Payment(final Builder builder) {
    setId(builder.id);
    setMerchantRefNum(builder.merchantRefNum);
    setAmount(builder.amount);
    setDupCheck(builder.dupCheck);
    setSettleWithAuth(builder.settleWithAuth);
    setPaymentHandleToken(builder.paymentHandleToken);
    setCustomerIp(builder.customerIp);
    setCurrencyCode(builder.currencyCode);
    setCard(builder.card);
    setThreeDs(builder.threeDs);
    setAuthentication(builder.authentication);
    setPreAuth(builder.preAuth);
    setPaymentHandleTokenFrom(builder.paymentHandleTokenFrom);
    setTransactionIntent(builder.transactionIntent);
    setGatewayResponse(builder.gatewayResponse);
    setSourceOfFunds(builder.sourceOfFunds);
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
    setMybank(builder.mybank);
    setEps(builder.eps);
    setMandates(builder.mandates);
    setAvailableToSettle(builder.availableToSettle);
    setChildAccountNum(builder.childAccountNum);
    setTxnTime(builder.txnTime);
    setPaymentType(builder.paymentType);
    setStatus(builder.status);
    setStatusReason(builder.statusReason);
    setRiskReasonCode(builder.riskReasonCode);
    setSettlements(builder.settlements);
    setGatewayReconciliationId(builder.gatewayReconciliationId);
    setUpdatedTime(builder.updatedTime);
    setStatusTime(builder.statusTime);
    setAvailableToRefund(builder.availableToRefund);
    setProcessingRails(builder.processingRails);
    setLiveMode(builder.liveMode);
    setBillingDetails(builder.billingDetails);
    setProfile(builder.profile);
    setAcquirerData(builder.acquirerData);
    setPaymentFacilitator(builder.paymentFacilitator);
    setAirlineTravelDetails(builder.airlineTravelDetails);
    setLodgingDetails(builder.lodgingDetails);
    setCarRentalDetails(builder.carRentalDetails);
    setCruiselineTravelDetails(builder.cruiselineTravelDetails);
    setMerchantDescriptor(builder.merchantDescriptor);
    setKeywords(builder.keywords);
    setDescription(builder.description);
  }

  public static Builder builder() {
    return new Builder();
  }


  public Payment id(String id) {
    this.id = id;
    return this;
  }

  /**
   * The unique identifier for the payment transaction, can be used to retrieve the payment details using the Get Payment API.
   *
   * @return id
   */
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public Payment merchantRefNum(String merchantRefNum) {
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


  public Payment amount(Integer amount) {
    this.amount = amount;
    return this;
  }

  /**
   * The amount of the request, in minor units (e.g., $10.99 = 1099)
   *
   * @return amount
   */
  public Integer getAmount() {
    return amount;
  }

  public void setAmount(Integer amount) {
    this.amount = amount;
  }


  public Payment dupCheck(Boolean dupCheck) {
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


  public Payment settleWithAuth(Boolean settleWithAuth) {
    this.settleWithAuth = settleWithAuth;
    return this;
  }

  /**
   * This indicates whether the request is an Authorization only (no Settlement), or a Purchase (Authorization and Settlement). <ul> <li>false - The request is not settled </li> <li>true - The request is settled </li> </ul> <b>Note:</b> Defaults to false for cards and true for APMs.
   *
   * @return settleWithAuth
   */
  public Boolean getSettleWithAuth() {
    return settleWithAuth;
  }

  public void setSettleWithAuth(Boolean settleWithAuth) {
    this.settleWithAuth = settleWithAuth;
  }


  public Payment paymentHandleToken(String paymentHandleToken) {
    this.paymentHandleToken = paymentHandleToken;
    return this;
  }

  /**
   * This is the payment token generated by Paysafe that will be used for the Payment request. For Payment, Payment handle must be in PAYABLE state.
   *
   * @return paymentHandleToken
   */
  public String getPaymentHandleToken() {
    return paymentHandleToken;
  }

  public void setPaymentHandleToken(String paymentHandleToken) {
    this.paymentHandleToken = paymentHandleToken;
  }


  public Payment customerIp(String customerIp) {
    this.customerIp = customerIp;
    return this;
  }

  /**
   * The IP address of the customer making the payment
   *
   * @return customerIp
   */
  public String getCustomerIp() {
    return customerIp;
  }

  public void setCustomerIp(String customerIp) {
    this.customerIp = customerIp;
  }


  public Payment currencyCode(CurrencyCode currencyCode) {
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


  public Payment card(TokenizedCardDetails card) {
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


  public Payment threeDs(ThreeDs threeDs) {
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


  public Payment authentication(Authentication authentication) {
    this.authentication = authentication;
    return this;
  }

  /**
   * Get authentication
   *
   * @return authentication
   */
  public Authentication getAuthentication() {
    return authentication;
  }

  public void setAuthentication(Authentication authentication) {
    this.authentication = authentication;
  }


  public Payment preAuth(Boolean preAuth) {
    this.preAuth = preAuth;
    return this;
  }

  /**
   * Flag indicating whether this is a pre-authorization transaction
   *
   * @return preAuth
   */
  public Boolean getPreAuth() {
    return preAuth;
  }

  public void setPreAuth(Boolean preAuth) {
    this.preAuth = preAuth;
  }


  public Payment paymentHandleTokenFrom(String paymentHandleTokenFrom) {
    this.paymentHandleTokenFrom = paymentHandleTokenFrom;
    return this;
  }

  /**
   * This is used in Saved card flow. You will pass this parameter when you want to create single use payment handle using the Saved-card (card-on-file) present in Paysafe customer vault. <br> This is an existing multi-use [Customer Payment Handle](/operations/create-payment-handle-for-customer), from which the payment instrument details and profile details are retrieved. <br> If this parameter is included then you can omit the billingDetails object. If you send a new billingDetails along with \"paymentHandleTokenFrom\" then new billingDetails will be considered for the transaction, however no change will be made in the billingDetails present against the Saved-card in customer vault.
   *
   * @return paymentHandleTokenFrom
   */
  public String getPaymentHandleTokenFrom() {
    return paymentHandleTokenFrom;
  }

  public void setPaymentHandleTokenFrom(String paymentHandleTokenFrom) {
    this.paymentHandleTokenFrom = paymentHandleTokenFrom;
  }


  public Payment transactionIntent(TransactionIntent transactionIntent) {
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


  public Payment gatewayResponse(GatewayResponse gatewayResponse) {
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


  public Payment sourceOfFunds(SourceOfFunds sourceOfFunds) {
    this.sourceOfFunds = sourceOfFunds;
    return this;
  }

  /**
   * Get sourceOfFunds
   *
   * @return sourceOfFunds
   */
  public SourceOfFunds getSourceOfFunds() {
    return sourceOfFunds;
  }

  public void setSourceOfFunds(SourceOfFunds sourceOfFunds) {
    this.sourceOfFunds = sourceOfFunds;
  }


  public Payment skrill(Skrill skrill) {
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


  public Payment neteller(Neteller neteller) {
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


  public Payment paysafecash(Paysafecash paysafecash) {
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


  public Payment paysafecard(Paysafecard paysafecard) {
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


  public Payment payPal(Paypal payPal) {
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


  public Payment venmo(Venmo venmo) {
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


  public Payment vippreferred(Vippreferred vippreferred) {
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


  public Payment mazooma(Mazooma mazooma) {
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


  public Payment sightline(Sightline sightline) {
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


  public Payment payByBank(PayByBank payByBank) {
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


  public Payment interacETransfer(Interac interacETransfer) {
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


  public Payment rapidTransfer(RapidTransfer rapidTransfer) {
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


  public Payment skrill1Tap(Skrill1Tap skrill1Tap) {
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


  public Payment ach(Ach ach) {
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


  public Payment eft(Eft eft) {
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


  public Payment bacs(Bacs bacs) {
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


  public Payment sepa(Sepa sepa) {
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


  public Payment safetyPayCash(SafetyPayCash safetyPayCash) {
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


  public Payment mybank(MyBank mybank) {
    this.mybank = mybank;
    return this;
  }

  /**
   * Get mybank
   *
   * @return mybank
   */
  public MyBank getMybank() {
    return mybank;
  }

  public void setMybank(MyBank mybank) {
    this.mybank = mybank;
  }


  public Payment eps(Eps eps) {
    this.eps = eps;
    return this;
  }

  /**
   * Get eps
   *
   * @return eps
   */
  public Eps getEps() {
    return eps;
  }

  public void setEps(Eps eps) {
    this.eps = eps;
  }


  public Payment mandates(List<Mandate> mandates) {
    this.mandates = mandates;
    return this;
  }

  public Payment addMandatesItem(Mandate mandatesItem) {
    if (this.mandates == null) {
      this.mandates = new ArrayList<>();
    }
    this.mandates.add(mandatesItem);
    return this;
  }

  public Payment removeMandatesItem(Mandate mandatesItem) {
    if (mandatesItem != null && this.mandates != null) {
      this.mandates.remove(mandatesItem);
    }

    return this;
  }

  /**
   * List of mandates associated with the payment
   *
   * @return mandates
   */
  public List<Mandate> getMandates() {
    return mandates;
  }

  public void setMandates(List<Mandate> mandates) {
    this.mandates = mandates;
  }


  public Payment availableToSettle(Integer availableToSettle) {
    this.availableToSettle = availableToSettle;
    return this;
  }

  /**
   * Remaining authorization amount available to settle
   *
   * @return availableToSettle
   */
  public Integer getAvailableToSettle() {
    return availableToSettle;
  }

  public void setAvailableToSettle(Integer availableToSettle) {
    this.availableToSettle = availableToSettle;
  }


  public Payment childAccountNum(String childAccountNum) {
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


  public Payment txnTime(String txnTime) {
    this.txnTime = txnTime;
    return this;
  }

  /**
   * The date and time when the payment was processed
   *
   * @return txnTime
   */
  public String getTxnTime() {
    return txnTime;
  }

  public void setTxnTime(String txnTime) {
    this.txnTime = txnTime;
  }


  public Payment paymentType(PaymentType paymentType) {
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


  public Payment status(PaymentStatus status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   *
   * @return status
   */
  public PaymentStatus getStatus() {
    return status;
  }

  public void setStatus(PaymentStatus status) {
    this.status = status;
  }


  public Payment statusReason(String statusReason) {
    this.statusReason = statusReason;
    return this;
  }

  /**
   * A description of the reason for the current status. This is present in the case where status is ERROR, FAILURE, or HELD.
   *
   * @return statusReason
   */
  public String getStatusReason() {
    return statusReason;
  }

  public void setStatusReason(String statusReason) {
    this.statusReason = statusReason;
  }


  public Payment riskReasonCode(List<Integer> riskReasonCode) {
    this.riskReasonCode = riskReasonCode;
    return this;
  }

  public Payment addRiskReasonCodeItem(Integer riskReasonCodeItem) {
    if (this.riskReasonCode == null) {
      this.riskReasonCode = new ArrayList<>();
    }
    this.riskReasonCode.add(riskReasonCodeItem);
    return this;
  }

  public Payment removeRiskReasonCodeItem(Integer riskReasonCodeItem) {
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


  public Payment settlements(List<Settlement> settlements) {
    this.settlements = settlements;
    return this;
  }

  public Payment addSettlementsItem(Settlement settlementsItem) {
    if (this.settlements == null) {
      this.settlements = new ArrayList<>();
    }
    this.settlements.add(settlementsItem);
    return this;
  }

  public Payment removeSettlementsItem(Settlement settlementsItem) {
    if (settlementsItem != null && this.settlements != null) {
      this.settlements.remove(settlementsItem);
    }

    return this;
  }

  /**
   * List of settlement objects associated with the payment
   *
   * @return settlements
   */
  public List<Settlement> getSettlements() {
    return settlements;
  }

  public void setSettlements(List<Settlement> settlements) {
    this.settlements = settlements;
  }


  public Payment gatewayReconciliationId(String gatewayReconciliationId) {
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


  public Payment updatedTime(String updatedTime) {
    this.updatedTime = updatedTime;
    return this;
  }

  /**
   * The date and time the payment payment was last updated
   *
   * @return updatedTime
   */
  public String getUpdatedTime() {
    return updatedTime;
  }

  public void setUpdatedTime(String updatedTime) {
    this.updatedTime = updatedTime;
  }


  public Payment statusTime(String statusTime) {
    this.statusTime = statusTime;
    return this;
  }

  /**
   * The date and time of the payment last status change
   *
   * @return statusTime
   */
  public String getStatusTime() {
    return statusTime;
  }

  public void setStatusTime(String statusTime) {
    this.statusTime = statusTime;
  }


  public Payment availableToRefund(Integer availableToRefund) {
    this.availableToRefund = availableToRefund;
    return this;
  }

  /**
   * The amount available to refund from the payment
   *
   * @return availableToRefund
   */
  public Integer getAvailableToRefund() {
    return availableToRefund;
  }

  public void setAvailableToRefund(Integer availableToRefund) {
    this.availableToRefund = availableToRefund;
  }


  public Payment processingRails(ProcessingRails processingRails) {
    this.processingRails = processingRails;
    return this;
  }

  /**
   * Get processingRails
   *
   * @return processingRails
   */
  public ProcessingRails getProcessingRails() {
    return processingRails;
  }

  public void setProcessingRails(ProcessingRails processingRails) {
    this.processingRails = processingRails;
  }


  public Payment liveMode(Boolean liveMode) {
    this.liveMode = liveMode;
    return this;
  }

  /**
   * Indicates whether the payment was processed in live mode
   *
   * @return liveMode
   */
  public Boolean getLiveMode() {
    return liveMode;
  }

  public void setLiveMode(Boolean liveMode) {
    this.liveMode = liveMode;
  }


  public Payment billingDetails(BillingDetails billingDetails) {
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


  public Payment profile(Profile profile) {
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


  public Payment acquirerData(AcquirerData acquirerData) {
    this.acquirerData = acquirerData;
    return this;
  }

  /**
   * Get acquirerData
   *
   * @return acquirerData
   */
  public AcquirerData getAcquirerData() {
    return acquirerData;
  }

  public void setAcquirerData(AcquirerData acquirerData) {
    this.acquirerData = acquirerData;
  }


  public Payment paymentFacilitator(PaymentFacilitator paymentFacilitator) {
    this.paymentFacilitator = paymentFacilitator;
    return this;
  }

  /**
   * Get paymentFacilitator
   *
   * @return paymentFacilitator
   */
  public PaymentFacilitator getPaymentFacilitator() {
    return paymentFacilitator;
  }

  public void setPaymentFacilitator(PaymentFacilitator paymentFacilitator) {
    this.paymentFacilitator = paymentFacilitator;
  }


  public Payment airlineTravelDetails(AirlineTravelDetails airlineTravelDetails) {
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


  public Payment lodgingDetails(LodgingDetails lodgingDetails) {
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


  public Payment carRentalDetails(CarRentalDetails carRentalDetails) {
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


  public Payment cruiselineTravelDetails(CruiselineTravelDetails cruiselineTravelDetails) {
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


  public Payment merchantDescriptor(MerchantDescriptor merchantDescriptor) {
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


  public Payment keywords(List<String> keywords) {
    this.keywords = keywords;
    return this;
  }

  public Payment addKeywordsItem(String keywordsItem) {
    if (this.keywords == null) {
      this.keywords = new ArrayList<>();
    }
    this.keywords.add(keywordsItem);
    return this;
  }

  public Payment removeKeywordsItem(String keywordsItem) {
    if (keywordsItem != null && this.keywords != null) {
      this.keywords.remove(keywordsItem);
    }

    return this;
  }

  /**
   * List of keywords associated with the payment
   *
   * @return keywords
   */
  public List<String> getKeywords() {
    return keywords;
  }

  public void setKeywords(List<String> keywords) {
    this.keywords = keywords;
  }


  public Payment description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Description of the payment transaction
   *
   * @return description
   */
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Payment payment = (Payment) o;
    return Objects.equals(this.id, payment.id) &&
        Objects.equals(this.merchantRefNum, payment.merchantRefNum) &&
        Objects.equals(this.amount, payment.amount) &&
        Objects.equals(this.dupCheck, payment.dupCheck) &&
        Objects.equals(this.settleWithAuth, payment.settleWithAuth) &&
        Objects.equals(this.paymentHandleToken, payment.paymentHandleToken) &&
        Objects.equals(this.customerIp, payment.customerIp) &&
        Objects.equals(this.currencyCode, payment.currencyCode) &&
        Objects.equals(this.card, payment.card) &&
        Objects.equals(this.threeDs, payment.threeDs) &&
        Objects.equals(this.authentication, payment.authentication) &&
        Objects.equals(this.preAuth, payment.preAuth) &&
        Objects.equals(this.paymentHandleTokenFrom, payment.paymentHandleTokenFrom) &&
        Objects.equals(this.transactionIntent, payment.transactionIntent) &&
        Objects.equals(this.gatewayResponse, payment.gatewayResponse) &&
        Objects.equals(this.sourceOfFunds, payment.sourceOfFunds) &&
        Objects.equals(this.skrill, payment.skrill) &&
        Objects.equals(this.neteller, payment.neteller) &&
        Objects.equals(this.paysafecash, payment.paysafecash) &&
        Objects.equals(this.paysafecard, payment.paysafecard) &&
        Objects.equals(this.payPal, payment.payPal) &&
        Objects.equals(this.venmo, payment.venmo) &&
        Objects.equals(this.vippreferred, payment.vippreferred) &&
        Objects.equals(this.mazooma, payment.mazooma) &&
        Objects.equals(this.sightline, payment.sightline) &&
        Objects.equals(this.payByBank, payment.payByBank) &&
        Objects.equals(this.interacETransfer, payment.interacETransfer) &&
        Objects.equals(this.rapidTransfer, payment.rapidTransfer) &&
        Objects.equals(this.skrill1Tap, payment.skrill1Tap) &&
        Objects.equals(this.ach, payment.ach) &&
        Objects.equals(this.eft, payment.eft) &&
        Objects.equals(this.bacs, payment.bacs) &&
        Objects.equals(this.sepa, payment.sepa) &&
        Objects.equals(this.safetyPayCash, payment.safetyPayCash) &&
        Objects.equals(this.mybank, payment.mybank) &&
        Objects.equals(this.eps, payment.eps) &&
        Objects.equals(this.mandates, payment.mandates) &&
        Objects.equals(this.availableToSettle, payment.availableToSettle) &&
        Objects.equals(this.childAccountNum, payment.childAccountNum) &&
        Objects.equals(this.txnTime, payment.txnTime) &&
        Objects.equals(this.paymentType, payment.paymentType) &&
        Objects.equals(this.status, payment.status) &&
        Objects.equals(this.statusReason, payment.statusReason) &&
        Objects.equals(this.riskReasonCode, payment.riskReasonCode) &&
        Objects.equals(this.settlements, payment.settlements) &&
        Objects.equals(this.gatewayReconciliationId, payment.gatewayReconciliationId) &&
        Objects.equals(this.updatedTime, payment.updatedTime) &&
        Objects.equals(this.statusTime, payment.statusTime) &&
        Objects.equals(this.availableToRefund, payment.availableToRefund) &&
        Objects.equals(this.processingRails, payment.processingRails) &&
        Objects.equals(this.liveMode, payment.liveMode) &&
        Objects.equals(this.billingDetails, payment.billingDetails) &&
        Objects.equals(this.profile, payment.profile) &&
        Objects.equals(this.acquirerData, payment.acquirerData) &&
        Objects.equals(this.paymentFacilitator, payment.paymentFacilitator) &&
        Objects.equals(this.airlineTravelDetails, payment.airlineTravelDetails) &&
        Objects.equals(this.lodgingDetails, payment.lodgingDetails) &&
        Objects.equals(this.carRentalDetails, payment.carRentalDetails) &&
        Objects.equals(this.cruiselineTravelDetails, payment.cruiselineTravelDetails) &&
        Objects.equals(this.merchantDescriptor, payment.merchantDescriptor) &&
        Objects.equals(this.keywords, payment.keywords) &&
        Objects.equals(this.description, payment.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, merchantRefNum, amount, dupCheck, settleWithAuth, paymentHandleToken, customerIp, currencyCode, card, threeDs, authentication, preAuth, paymentHandleTokenFrom, transactionIntent, gatewayResponse, sourceOfFunds, skrill, neteller, paysafecash, paysafecard, payPal, venmo, vippreferred, mazooma, sightline, payByBank, interacETransfer, rapidTransfer, skrill1Tap, ach, eft, bacs, sepa, safetyPayCash, mybank, eps, mandates, availableToSettle, childAccountNum, txnTime, paymentType, status, statusReason, riskReasonCode, settlements, gatewayReconciliationId, updatedTime, statusTime, availableToRefund, processingRails, liveMode, billingDetails, profile, acquirerData, paymentFacilitator, airlineTravelDetails, lodgingDetails, carRentalDetails, cruiselineTravelDetails, merchantDescriptor, keywords, description);
  }

  @Override
  public String toString() {

    return "class Payment {\n"
        + "    id: " + toIndentedString(id) + "\n"
        + "    merchantRefNum: " + toIndentedString(merchantRefNum) + "\n"
        + "    amount: " + toIndentedString(amount) + "\n"
        + "    dupCheck: " + toIndentedString(dupCheck) + "\n"
        + "    settleWithAuth: " + toIndentedString(settleWithAuth) + "\n"
        + "    paymentHandleToken: " + toIndentedString(paymentHandleToken) + "\n"
        + "    customerIp: " + toIndentedString(customerIp) + "\n"
        + "    currencyCode: " + toIndentedString(currencyCode) + "\n"
        + "    card: " + toIndentedString(card) + "\n"
        + "    threeDs: " + toIndentedString(threeDs) + "\n"
        + "    authentication: " + toIndentedString(authentication) + "\n"
        + "    preAuth: " + toIndentedString(preAuth) + "\n"
        + "    paymentHandleTokenFrom: " + toIndentedString(paymentHandleTokenFrom) + "\n"
        + "    transactionIntent: " + toIndentedString(transactionIntent) + "\n"
        + "    gatewayResponse: " + toIndentedString(gatewayResponse) + "\n"
        + "    sourceOfFunds: " + toIndentedString(sourceOfFunds) + "\n"
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
        + "    mybank: " + toIndentedString(mybank) + "\n"
        + "    eps: " + toIndentedString(eps) + "\n"
        + "    mandates: " + toIndentedString(mandates) + "\n"
        + "    availableToSettle: " + toIndentedString(availableToSettle) + "\n"
        + "    childAccountNum: " + toIndentedString(childAccountNum) + "\n"
        + "    txnTime: " + toIndentedString(txnTime) + "\n"
        + "    paymentType: " + toIndentedString(paymentType) + "\n"
        + "    status: " + toIndentedString(status) + "\n"
        + "    statusReason: " + toIndentedString(statusReason) + "\n"
        + "    riskReasonCode: " + toIndentedString(riskReasonCode) + "\n"
        + "    settlements: " + toIndentedString(settlements) + "\n"
        + "    gatewayReconciliationId: " + toIndentedString(gatewayReconciliationId) + "\n"
        + "    updatedTime: " + toIndentedString(updatedTime) + "\n"
        + "    statusTime: " + toIndentedString(statusTime) + "\n"
        + "    availableToRefund: " + toIndentedString(availableToRefund) + "\n"
        + "    processingRails: " + toIndentedString(processingRails) + "\n"
        + "    liveMode: " + toIndentedString(liveMode) + "\n"
        + "    billingDetails: " + toIndentedString(billingDetails) + "\n"
        + "    profile: " + toIndentedString(profile) + "\n"
        + "    acquirerData: " + toIndentedString(acquirerData) + "\n"
        + "    paymentFacilitator: " + toIndentedString(paymentFacilitator) + "\n"
        + "    airlineTravelDetails: " + toIndentedString(airlineTravelDetails) + "\n"
        + "    lodgingDetails: " + toIndentedString(lodgingDetails) + "\n"
        + "    carRentalDetails: " + toIndentedString(carRentalDetails) + "\n"
        + "    cruiselineTravelDetails: " + toIndentedString(cruiselineTravelDetails) + "\n"
        + "    merchantDescriptor: " + toIndentedString(merchantDescriptor) + "\n"
        + "    keywords: " + toIndentedString(keywords) + "\n"
        + "    description: " + toIndentedString(description) + "\n"
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
   * Represents the response of a payment transaction. builder static inner class.
   */
  public static final class Builder {
    private String id;
    private String merchantRefNum;
    private Integer amount;
    private Boolean dupCheck;
    private Boolean settleWithAuth;
    private String paymentHandleToken;
    private String customerIp;
    private CurrencyCode currencyCode;
    private TokenizedCardDetails card;
    private ThreeDs threeDs;
    private Authentication authentication;
    private Boolean preAuth;
    private String paymentHandleTokenFrom;
    private TransactionIntent transactionIntent;
    private GatewayResponse gatewayResponse;
    private SourceOfFunds sourceOfFunds;
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
    private MyBank mybank;
    private Eps eps;
    private List<Mandate> mandates;
    private Integer availableToSettle;
    private String childAccountNum;
    private String txnTime;
    private PaymentType paymentType;
    private PaymentStatus status;
    private String statusReason;
    private List<Integer> riskReasonCode;
    private List<Settlement> settlements;
    private String gatewayReconciliationId;
    private String updatedTime;
    private String statusTime;
    private Integer availableToRefund;
    private ProcessingRails processingRails;
    private Boolean liveMode;
    private BillingDetails billingDetails;
    private Profile profile;
    private AcquirerData acquirerData;
    private PaymentFacilitator paymentFacilitator;
    private AirlineTravelDetails airlineTravelDetails;
    private LodgingDetails lodgingDetails;
    private CarRentalDetails carRentalDetails;
    private CruiselineTravelDetails cruiselineTravelDetails;
    private MerchantDescriptor merchantDescriptor;
    private List<String> keywords;
    private String description;

    private Builder() {
    }

    /**
     * The unique identifier for the payment transaction, can be used to retrieve the payment details using the Get Payment API.
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
     * The amount of the request, in minor units (e.g., $10.99 = 1099)
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
     * This indicates whether the request is an Authorization only (no Settlement), or a Purchase (Authorization and Settlement). <ul> <li>false - The request is not settled </li> <li>true - The request is settled </li> </ul> <b>Note:</b> Defaults to false for cards and true for APMs.
     * <p>
     * Sets the settleWithAuth and returns a reference to this Builder enabling method chaining.
     *
     * @param settleWithAuth the settleWithAuth to set
     * @return a reference to this Builder
     */
    public Builder settleWithAuth(Boolean settleWithAuth) {
      this.settleWithAuth = settleWithAuth;
      return this;
    }

    /**
     * This is the payment token generated by Paysafe that will be used for the Payment request. For Payment, Payment handle must be in PAYABLE state.
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
     * The IP address of the customer making the payment
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
     * Sets the authentication and returns a reference to this Builder enabling method chaining.
     *
     * @param authentication the authentication to set
     * @return a reference to this Builder
     */
    public Builder authentication(Authentication authentication) {
      this.authentication = authentication;
      return this;
    }

    /**
     * Flag indicating whether this is a pre-authorization transaction
     * <p>
     * Sets the preAuth and returns a reference to this Builder enabling method chaining.
     *
     * @param preAuth the preAuth to set
     * @return a reference to this Builder
     */
    public Builder preAuth(Boolean preAuth) {
      this.preAuth = preAuth;
      return this;
    }

    /**
     * This is used in Saved card flow. You will pass this parameter when you want to create single use payment handle using the Saved-card (card-on-file) present in Paysafe customer vault. <br> This is an existing multi-use [Customer Payment Handle](/operations/create-payment-handle-for-customer), from which the payment instrument details and profile details are retrieved. <br> If this parameter is included then you can omit the billingDetails object. If you send a new billingDetails along with \"paymentHandleTokenFrom\" then new billingDetails will be considered for the transaction, however no change will be made in the billingDetails present against the Saved-card in customer vault.
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
     * Sets the sourceOfFunds and returns a reference to this Builder enabling method chaining.
     *
     * @param sourceOfFunds the sourceOfFunds to set
     * @return a reference to this Builder
     */
    public Builder sourceOfFunds(SourceOfFunds sourceOfFunds) {
      this.sourceOfFunds = sourceOfFunds;
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
     * Sets the mybank and returns a reference to this Builder enabling method chaining.
     *
     * @param mybank the mybank to set
     * @return a reference to this Builder
     */
    public Builder mybank(MyBank mybank) {
      this.mybank = mybank;
      return this;
    }

    /**
     * Sets the eps and returns a reference to this Builder enabling method chaining.
     *
     * @param eps the eps to set
     * @return a reference to this Builder
     */
    public Builder eps(Eps eps) {
      this.eps = eps;
      return this;
    }

    /**
     * List of mandates associated with the payment
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
     * Remaining authorization amount available to settle
     * <p>
     * Sets the availableToSettle and returns a reference to this Builder enabling method chaining.
     *
     * @param availableToSettle the availableToSettle to set
     * @return a reference to this Builder
     */
    public Builder availableToSettle(Integer availableToSettle) {
      this.availableToSettle = availableToSettle;
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
     * The date and time when the payment was processed
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
     * Sets the status and returns a reference to this Builder enabling method chaining.
     *
     * @param status the status to set
     * @return a reference to this Builder
     */
    public Builder status(PaymentStatus status) {
      this.status = status;
      return this;
    }

    /**
     * A description of the reason for the current status. This is present in the case where status is ERROR, FAILURE, or HELD.
     * <p>
     * Sets the statusReason and returns a reference to this Builder enabling method chaining.
     *
     * @param statusReason the statusReason to set
     * @return a reference to this Builder
     */
    public Builder statusReason(String statusReason) {
      this.statusReason = statusReason;
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
     * List of settlement objects associated with the payment
     * <p>
     * Sets the settlements and returns a reference to this Builder enabling method chaining.
     *
     * @param settlements the settlements to set
     * @return a reference to this Builder
     */
    public Builder settlements(List<Settlement> settlements) {
      this.settlements = settlements;
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
     * The date and time the payment payment was last updated
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
     * The date and time of the payment last status change
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
     * The amount available to refund from the payment
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
     * Sets the processingRails and returns a reference to this Builder enabling method chaining.
     *
     * @param processingRails the processingRails to set
     * @return a reference to this Builder
     */
    public Builder processingRails(ProcessingRails processingRails) {
      this.processingRails = processingRails;
      return this;
    }

    /**
     * Indicates whether the payment was processed in live mode
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
     * Sets the acquirerData and returns a reference to this Builder enabling method chaining.
     *
     * @param acquirerData the acquirerData to set
     * @return a reference to this Builder
     */
    public Builder acquirerData(AcquirerData acquirerData) {
      this.acquirerData = acquirerData;
      return this;
    }

    /**
     * Sets the paymentFacilitator and returns a reference to this Builder enabling method chaining.
     *
     * @param paymentFacilitator the paymentFacilitator to set
     * @return a reference to this Builder
     */
    public Builder paymentFacilitator(PaymentFacilitator paymentFacilitator) {
      this.paymentFacilitator = paymentFacilitator;
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
     * List of keywords associated with the payment
     * <p>
     * Sets the keywords and returns a reference to this Builder enabling method chaining.
     *
     * @param keywords the keywords to set
     * @return a reference to this Builder
     */
    public Builder keywords(List<String> keywords) {
      this.keywords = keywords;
      return this;
    }

    /**
     * Description of the payment transaction
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
     * Returns a Payment built from the parameters previously set.
     *
     * @return a Payment built with parameters of this Payment.Builder
     */
    public Payment build() {
      return new Payment(this);
    }
  }
}
