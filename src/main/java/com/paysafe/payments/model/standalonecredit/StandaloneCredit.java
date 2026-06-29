// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.model.standalonecredit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.paysafe.payments.model.card.Card;
import com.paysafe.payments.model.card.MerchantDescriptor;
import com.paysafe.payments.model.common.BillingDetails;
import com.paysafe.payments.model.common.ReturnLink;
import com.paysafe.payments.model.common.enums.CurrencyCode;
import com.paysafe.payments.model.common.enums.TransactionRequestStatus;
import com.paysafe.payments.model.common.paymentfacilitator.PaymentFacilitator;
import com.paysafe.payments.model.common.profile.Profile;
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
import com.paysafe.payments.model.payment.Payment;
import com.paysafe.payments.model.paymenthandle.enums.PaymentType;
import com.paysafe.payments.model.standalonecredit.enums.SourceOfFunds;
import com.paysafe.payments.model.standalonecredit.enums.TransactionIntentCredit;



/**
 * StandaloneCredit.
 */
public class StandaloneCredit {

  @JsonProperty("id")
  private String id;
  @JsonProperty("merchantRefNum")
  private String merchantRefNum;
  @JsonProperty("paymentHandleToken")
  private String paymentHandleToken;
  @JsonProperty("amount")
  private Integer amount;
  @JsonProperty("currencyCode")
  private CurrencyCode currencyCode;
  @JsonProperty("customerIp")
  private String customerIp;
  @JsonProperty("onHold")
  private Boolean onHold = true;
  @JsonProperty("description")
  private String description;
  @JsonProperty("dupCheck")
  private Boolean dupCheck;
  @JsonProperty("merchantDescriptor")
  private MerchantDescriptor merchantDescriptor;
  @JsonProperty("paymentFacilitator")
  private PaymentFacilitator paymentFacilitator;
  @JsonProperty("sender")
  private Sender sender;
  @JsonProperty("sourceOfFunds")
  private SourceOfFunds sourceOfFunds;
  @JsonProperty("cardSchemeTransactionId")
  private String cardSchemeTransactionId;
  @JsonProperty("paymentType")
  private PaymentType paymentType;
  @JsonProperty("txnTime")
  private String txnTime;
  @JsonProperty("billingDetails")
  private BillingDetails billingDetails;
  @JsonProperty("status")
  private TransactionRequestStatus status;
  @JsonProperty("returnLinks")
  private List<ReturnLink> returnLinks;
  @JsonProperty("liveMode")
  private Boolean liveMode;
  @JsonProperty("updatedTime")
  private String updatedTime;
  @JsonProperty("statusTime")
  private String statusTime;
  @JsonProperty("profile")
  private Profile profile;
  @JsonProperty("transactionIntent")
  private TransactionIntentCredit transactionIntent;
  @JsonProperty("gatewayReconciliationId")
  private String gatewayReconciliationId;
  @JsonProperty("card")
  private Card card;
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

  public StandaloneCredit() {
    super();
  }

  private StandaloneCredit(final Builder builder) {
    setId(builder.id);
    setMerchantRefNum(builder.merchantRefNum);
    setPaymentHandleToken(builder.paymentHandleToken);
    setAmount(builder.amount);
    setCurrencyCode(builder.currencyCode);
    setCustomerIp(builder.customerIp);
    setOnHold(builder.onHold);
    setDescription(builder.description);
    setDupCheck(builder.dupCheck);
    setMerchantDescriptor(builder.merchantDescriptor);
    setPaymentFacilitator(builder.paymentFacilitator);
    setSender(builder.sender);
    setSourceOfFunds(builder.sourceOfFunds);
    setCardSchemeTransactionId(builder.cardSchemeTransactionId);
    setPaymentType(builder.paymentType);
    setTxnTime(builder.txnTime);
    setBillingDetails(builder.billingDetails);
    setStatus(builder.status);
    setReturnLinks(builder.returnLinks);
    setLiveMode(builder.liveMode);
    setUpdatedTime(builder.updatedTime);
    setStatusTime(builder.statusTime);
    setProfile(builder.profile);
    setTransactionIntent(builder.transactionIntent);
    setGatewayReconciliationId(builder.gatewayReconciliationId);
    setCard(builder.card);
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
  }

  public static Builder builder() {
    return new Builder();
  }


  public StandaloneCredit id(String id) {
    this.id = id;
    return this;
  }

  /**
   * This is the ID returned in the response. This ID can be used for future associated requests.
   *
   * @return id
   */
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public StandaloneCredit merchantRefNum(String merchantRefNum) {
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


  public StandaloneCredit paymentHandleToken(String paymentHandleToken) {
    this.paymentHandleToken = paymentHandleToken;
    return this;
  }

  /**
   * This is the payment token generated by Paysafe that will be used for the request.
   *
   * @return paymentHandleToken
   */
  public String getPaymentHandleToken() {
    return paymentHandleToken;
  }

  public void setPaymentHandleToken(String paymentHandleToken) {
    this.paymentHandleToken = paymentHandleToken;
  }


  public StandaloneCredit amount(Integer amount) {
    this.amount = amount;
    return this;
  }

  /**
   * This is the amount of the request, in minor units. For example, to process US $10.99, this value should be 1099. **Note:** The amount specified in the Credit request must match the amount specified in the Payment Handle request from which the paymentHandleToken is taken.
   *
   * @return amount
   */
  public Integer getAmount() {
    return amount;
  }

  public void setAmount(Integer amount) {
    this.amount = amount;
  }


  public StandaloneCredit currencyCode(CurrencyCode currencyCode) {
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


  public StandaloneCredit customerIp(String customerIp) {
    this.customerIp = customerIp;
    return this;
  }

  /**
   * This is the customer's IP address.
   *
   * @return customerIp
   */
  public String getCustomerIp() {
    return customerIp;
  }

  public void setCustomerIp(String customerIp) {
    this.customerIp = customerIp;
  }


  public StandaloneCredit onHold(Boolean onHold) {
    this.onHold = onHold;
    return this;
  }

  /**
   * This parameter can be used by merchants to hold the SCT for additional checks on their end.
   *
   * @return onHold
   */
  public Boolean getOnHold() {
    return onHold;
  }

  public void setOnHold(Boolean onHold) {
    this.onHold = onHold;
  }


  public StandaloneCredit description(String description) {
    this.description = description;
    return this;
  }

  /**
   * This is a description of the transaction, provided by the merchant.
   *
   * @return description
   */
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  public StandaloneCredit dupCheck(Boolean dupCheck) {
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


  public StandaloneCredit merchantDescriptor(MerchantDescriptor merchantDescriptor) {
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


  public StandaloneCredit paymentFacilitator(PaymentFacilitator paymentFacilitator) {
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


  public StandaloneCredit sender(Sender sender) {
    this.sender = sender;
    return this;
  }

  /**
   * Get sender
   *
   * @return sender
   */
  public Sender getSender() {
    return sender;
  }

  public void setSender(Sender sender) {
    this.sender = sender;
  }


  public StandaloneCredit sourceOfFunds(SourceOfFunds sourceOfFunds) {
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


  public StandaloneCredit cardSchemeTransactionId(String cardSchemeTransactionId) {
    this.cardSchemeTransactionId = cardSchemeTransactionId;
    return this;
  }

  /**
   * Card scheme transaction identifier
   *
   * @return cardSchemeTransactionId
   */
  public String getCardSchemeTransactionId() {
    return cardSchemeTransactionId;
  }

  public void setCardSchemeTransactionId(String cardSchemeTransactionId) {
    this.cardSchemeTransactionId = cardSchemeTransactionId;
  }


  public StandaloneCredit paymentType(PaymentType paymentType) {
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


  public StandaloneCredit txnTime(String txnTime) {
    this.txnTime = txnTime;
    return this;
  }

  /**
   * This is the date and time the transaction was processed.
   *
   * @return txnTime
   */
  public String getTxnTime() {
    return txnTime;
  }

  public void setTxnTime(String txnTime) {
    this.txnTime = txnTime;
  }


  public StandaloneCredit billingDetails(BillingDetails billingDetails) {
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


  public StandaloneCredit status(TransactionRequestStatus status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   *
   * @return status
   */
  public TransactionRequestStatus getStatus() {
    return status;
  }

  public void setStatus(TransactionRequestStatus status) {
    this.status = status;
  }


  public StandaloneCredit returnLinks(List<ReturnLink> returnLinks) {
    this.returnLinks = returnLinks;
    return this;
  }

  public StandaloneCredit addReturnLinksItem(ReturnLink returnLinksItem) {
    if (this.returnLinks == null) {
      this.returnLinks = new ArrayList<>();
    }
    this.returnLinks.add(returnLinksItem);
    return this;
  }

  public StandaloneCredit removeReturnLinksItem(ReturnLink returnLinksItem) {
    if (returnLinksItem != null && this.returnLinks != null) {
      this.returnLinks.remove(returnLinksItem);
    }

    return this;
  }

  /**
   * The URL endpoints to redirect the customer to after a redirection to an alternative payment or 3D Secure site. You can customize the return URL based on the transaction status.
   *
   * @return returnLinks
   */
  public List<ReturnLink> getReturnLinks() {
    return returnLinks;
  }

  public void setReturnLinks(List<ReturnLink> returnLinks) {
    this.returnLinks = returnLinks;
  }


  public StandaloneCredit liveMode(Boolean liveMode) {
    this.liveMode = liveMode;
    return this;
  }

  /**
   * This flag indicates the environment. - true - Production - false - Non-Production
   *
   * @return liveMode
   */
  public Boolean getLiveMode() {
    return liveMode;
  }

  public void setLiveMode(Boolean liveMode) {
    this.liveMode = liveMode;
  }


  public StandaloneCredit updatedTime(String updatedTime) {
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


  public StandaloneCredit statusTime(String statusTime) {
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


  public StandaloneCredit profile(Profile profile) {
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


  public StandaloneCredit transactionIntent(TransactionIntentCredit transactionIntent) {
    this.transactionIntent = transactionIntent;
    return this;
  }

  /**
   * Get transactionIntent
   *
   * @return transactionIntent
   */
  public TransactionIntentCredit getTransactionIntent() {
    return transactionIntent;
  }

  public void setTransactionIntent(TransactionIntentCredit transactionIntent) {
    this.transactionIntent = transactionIntent;
  }


  public StandaloneCredit gatewayReconciliationId(String gatewayReconciliationId) {
    this.gatewayReconciliationId = gatewayReconciliationId;
    return this;
  }

  /**
   * Transaction identifier that can be used to reconcile this transaction with the provider gateway.
   *
   * @return gatewayReconciliationId
   */
  public String getGatewayReconciliationId() {
    return gatewayReconciliationId;
  }

  public void setGatewayReconciliationId(String gatewayReconciliationId) {
    this.gatewayReconciliationId = gatewayReconciliationId;
  }


  public StandaloneCredit card(Card card) {
    this.card = card;
    return this;
  }

  /**
   * Get card
   *
   * @return card
   */
  public Card getCard() {
    return card;
  }

  public void setCard(Card card) {
    this.card = card;
  }


  public StandaloneCredit skrill(Skrill skrill) {
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


  public StandaloneCredit neteller(Neteller neteller) {
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


  public StandaloneCredit paysafecash(Paysafecash paysafecash) {
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


  public StandaloneCredit paysafecard(Paysafecard paysafecard) {
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


  public StandaloneCredit payPal(Paypal payPal) {
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


  public StandaloneCredit venmo(Venmo venmo) {
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


  public StandaloneCredit vippreferred(Vippreferred vippreferred) {
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


  public StandaloneCredit mazooma(Mazooma mazooma) {
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


  public StandaloneCredit sightline(Sightline sightline) {
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


  public StandaloneCredit payByBank(PayByBank payByBank) {
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


  public StandaloneCredit interacETransfer(Interac interacETransfer) {
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


  public StandaloneCredit rapidTransfer(RapidTransfer rapidTransfer) {
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


  public StandaloneCredit skrill1Tap(Skrill1Tap skrill1Tap) {
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


  public StandaloneCredit ach(Ach ach) {
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


  public StandaloneCredit eft(Eft eft) {
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


  public StandaloneCredit bacs(Bacs bacs) {
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


  public StandaloneCredit sepa(Sepa sepa) {
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


  public StandaloneCredit safetyPayCash(SafetyPayCash safetyPayCash) {
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


  public StandaloneCredit mybank(MyBank mybank) {
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


  public StandaloneCredit eps(Eps eps) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StandaloneCredit standaloneCredit = (StandaloneCredit) o;
    return Objects.equals(this.id, standaloneCredit.id) &&
        Objects.equals(this.merchantRefNum, standaloneCredit.merchantRefNum) &&
        Objects.equals(this.paymentHandleToken, standaloneCredit.paymentHandleToken) &&
        Objects.equals(this.amount, standaloneCredit.amount) &&
        Objects.equals(this.currencyCode, standaloneCredit.currencyCode) &&
        Objects.equals(this.customerIp, standaloneCredit.customerIp) &&
        Objects.equals(this.onHold, standaloneCredit.onHold) &&
        Objects.equals(this.description, standaloneCredit.description) &&
        Objects.equals(this.dupCheck, standaloneCredit.dupCheck) &&
        Objects.equals(this.merchantDescriptor, standaloneCredit.merchantDescriptor) &&
        Objects.equals(this.paymentFacilitator, standaloneCredit.paymentFacilitator) &&
        Objects.equals(this.sender, standaloneCredit.sender) &&
        Objects.equals(this.sourceOfFunds, standaloneCredit.sourceOfFunds) &&
        Objects.equals(this.cardSchemeTransactionId, standaloneCredit.cardSchemeTransactionId) &&
        Objects.equals(this.paymentType, standaloneCredit.paymentType) &&
        Objects.equals(this.txnTime, standaloneCredit.txnTime) &&
        Objects.equals(this.billingDetails, standaloneCredit.billingDetails) &&
        Objects.equals(this.status, standaloneCredit.status) &&
        Objects.equals(this.returnLinks, standaloneCredit.returnLinks) &&
        Objects.equals(this.liveMode, standaloneCredit.liveMode) &&
        Objects.equals(this.updatedTime, standaloneCredit.updatedTime) &&
        Objects.equals(this.statusTime, standaloneCredit.statusTime) &&
        Objects.equals(this.profile, standaloneCredit.profile) &&
        Objects.equals(this.transactionIntent, standaloneCredit.transactionIntent) &&
        Objects.equals(this.gatewayReconciliationId, standaloneCredit.gatewayReconciliationId) &&
        Objects.equals(this.card, standaloneCredit.card) &&
        Objects.equals(this.skrill, standaloneCredit.skrill) &&
        Objects.equals(this.neteller, standaloneCredit.neteller) &&
        Objects.equals(this.paysafecash, standaloneCredit.paysafecash) &&
        Objects.equals(this.paysafecard, standaloneCredit.paysafecard) &&
        Objects.equals(this.payPal, standaloneCredit.payPal) &&
        Objects.equals(this.venmo, standaloneCredit.venmo) &&
        Objects.equals(this.vippreferred, standaloneCredit.vippreferred) &&
        Objects.equals(this.mazooma, standaloneCredit.mazooma) &&
        Objects.equals(this.sightline, standaloneCredit.sightline) &&
        Objects.equals(this.payByBank, standaloneCredit.payByBank) &&
        Objects.equals(this.interacETransfer, standaloneCredit.interacETransfer) &&
        Objects.equals(this.rapidTransfer, standaloneCredit.rapidTransfer) &&
        Objects.equals(this.skrill1Tap, standaloneCredit.skrill1Tap) &&
        Objects.equals(this.ach, standaloneCredit.ach) &&
        Objects.equals(this.eft, standaloneCredit.eft) &&
        Objects.equals(this.bacs, standaloneCredit.bacs) &&
        Objects.equals(this.sepa, standaloneCredit.sepa) &&
        Objects.equals(this.safetyPayCash, standaloneCredit.safetyPayCash) &&
        Objects.equals(this.mybank, standaloneCredit.mybank) &&
        Objects.equals(this.eps, standaloneCredit.eps);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, merchantRefNum, paymentHandleToken, amount, currencyCode, customerIp, onHold, description, dupCheck, merchantDescriptor, paymentFacilitator, sender, sourceOfFunds, cardSchemeTransactionId, paymentType, txnTime, billingDetails, status, returnLinks, liveMode, updatedTime, statusTime, profile, transactionIntent, gatewayReconciliationId, card, skrill, neteller, paysafecash, paysafecard, payPal, venmo, vippreferred, mazooma, sightline, payByBank, interacETransfer, rapidTransfer, skrill1Tap, ach, eft, bacs, sepa, safetyPayCash, mybank, eps);
  }

  @Override
  public String toString() {

    return "class StandaloneCredit {\n"
        + "    id: " + toIndentedString(id) + "\n"
        + "    merchantRefNum: " + toIndentedString(merchantRefNum) + "\n"
        + "    paymentHandleToken: " + toIndentedString(paymentHandleToken) + "\n"
        + "    amount: " + toIndentedString(amount) + "\n"
        + "    currencyCode: " + toIndentedString(currencyCode) + "\n"
        + "    customerIp: " + toIndentedString(customerIp) + "\n"
        + "    onHold: " + toIndentedString(onHold) + "\n"
        + "    description: " + toIndentedString(description) + "\n"
        + "    dupCheck: " + toIndentedString(dupCheck) + "\n"
        + "    merchantDescriptor: " + toIndentedString(merchantDescriptor) + "\n"
        + "    paymentFacilitator: " + toIndentedString(paymentFacilitator) + "\n"
        + "    sender: " + toIndentedString(sender) + "\n"
        + "    sourceOfFunds: " + toIndentedString(sourceOfFunds) + "\n"
        + "    cardSchemeTransactionId: " + toIndentedString(cardSchemeTransactionId) + "\n"
        + "    paymentType: " + toIndentedString(paymentType) + "\n"
        + "    txnTime: " + toIndentedString(txnTime) + "\n"
        + "    billingDetails: " + toIndentedString(billingDetails) + "\n"
        + "    status: " + toIndentedString(status) + "\n"
        + "    returnLinks: " + toIndentedString(returnLinks) + "\n"
        + "    liveMode: " + toIndentedString(liveMode) + "\n"
        + "    updatedTime: " + toIndentedString(updatedTime) + "\n"
        + "    statusTime: " + toIndentedString(statusTime) + "\n"
        + "    profile: " + toIndentedString(profile) + "\n"
        + "    transactionIntent: " + toIndentedString(transactionIntent) + "\n"
        + "    gatewayReconciliationId: " + toIndentedString(gatewayReconciliationId) + "\n"
        + "    card: " + toIndentedString(card) + "\n"
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
   * StandaloneCredit. builder static inner class.
   */
  public static final class Builder {
    private String id;
    private String merchantRefNum;
    private String paymentHandleToken;
    private Integer amount;
    private CurrencyCode currencyCode;
    private String customerIp;
    private Boolean onHold;
    private String description;
    private Boolean dupCheck;
    private MerchantDescriptor merchantDescriptor;
    private PaymentFacilitator paymentFacilitator;
    private Sender sender;
    private SourceOfFunds sourceOfFunds;
    private String cardSchemeTransactionId;
    private PaymentType paymentType;
    private String txnTime;
    private BillingDetails billingDetails;
    private TransactionRequestStatus status;
    private List<ReturnLink> returnLinks;
    private Boolean liveMode;
    private String updatedTime;
    private String statusTime;
    private Profile profile;
    private TransactionIntentCredit transactionIntent;
    private String gatewayReconciliationId;
    private Card card;
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

    private Builder() {
    }

    /**
     * This is the ID returned in the response. This ID can be used for future associated requests.
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
     * This is the payment token generated by Paysafe that will be used for the request.
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
     * This is the amount of the request, in minor units. For example, to process US $10.99, this value should be 1099. **Note:** The amount specified in the Credit request must match the amount specified in the Payment Handle request from which the paymentHandleToken is taken.
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
     * This is the customer's IP address.
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
     * This parameter can be used by merchants to hold the SCT for additional checks on their end.
     * <p>
     * Sets the onHold and returns a reference to this Builder enabling method chaining.
     *
     * @param onHold the onHold to set
     * @return a reference to this Builder
     */
    public Builder onHold(Boolean onHold) {
      this.onHold = onHold;
      return this;
    }

    /**
     * This is a description of the transaction, provided by the merchant.
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
     * Sets the sender and returns a reference to this Builder enabling method chaining.
     *
     * @param sender the sender to set
     * @return a reference to this Builder
     */
    public Builder sender(Sender sender) {
      this.sender = sender;
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
     * Card scheme transaction identifier
     * <p>
     * Sets the cardSchemeTransactionId and returns a reference to this Builder enabling method chaining.
     *
     * @param cardSchemeTransactionId the cardSchemeTransactionId to set
     * @return a reference to this Builder
     */
    public Builder cardSchemeTransactionId(String cardSchemeTransactionId) {
      this.cardSchemeTransactionId = cardSchemeTransactionId;
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
     * This is the date and time the transaction was processed.
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
     * Sets the status and returns a reference to this Builder enabling method chaining.
     *
     * @param status the status to set
     * @return a reference to this Builder
     */
    public Builder status(TransactionRequestStatus status) {
      this.status = status;
      return this;
    }

    /**
     * The URL endpoints to redirect the customer to after a redirection to an alternative payment or 3D Secure site. You can customize the return URL based on the transaction status.
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
     * This flag indicates the environment. - true - Production - false - Non-Production
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
     * Sets the transactionIntent and returns a reference to this Builder enabling method chaining.
     *
     * @param transactionIntent the transactionIntent to set
     * @return a reference to this Builder
     */
    public Builder transactionIntent(TransactionIntentCredit transactionIntent) {
      this.transactionIntent = transactionIntent;
      return this;
    }

    /**
     * Transaction identifier that can be used to reconcile this transaction with the provider gateway.
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
     * Sets the card and returns a reference to this Builder enabling method chaining.
     *
     * @param card the card to set
     * @return a reference to this Builder
     */
    public Builder card(Card card) {
      this.card = card;
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
     * Returns a StandaloneCredit built from the parameters previously set.
     *
     * @return a StandaloneCredit built with parameters of this StandaloneCredit.Builder
     */
    public StandaloneCredit build() {
      return new StandaloneCredit(this);
    }
  }
}
