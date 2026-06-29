// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.model.customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.paysafe.payments.model.card.CardAuthentication;
import com.paysafe.payments.model.card.MerchantDescriptor;
import com.paysafe.payments.model.card.TokenizedCardDetails;
import com.paysafe.payments.model.card.threeds.ThreeDs;
import com.paysafe.payments.model.common.BillingDetails;
import com.paysafe.payments.model.common.GatewayResponse;
import com.paysafe.payments.model.common.Mandate;
import com.paysafe.payments.model.common.ShippingDetails;
import com.paysafe.payments.model.common.enums.CurrencyCode;
import com.paysafe.payments.model.common.profile.Profile;
import com.paysafe.payments.model.lpm.Ach;
import com.paysafe.payments.model.lpm.Bacs;
import com.paysafe.payments.model.lpm.Eft;
import com.paysafe.payments.model.lpm.Sepa;
import com.paysafe.payments.model.payment.Payment;
import com.paysafe.payments.model.paymenthandle.enums.Action;
import com.paysafe.payments.model.paymenthandle.enums.PaymentHandleStatus;
import com.paysafe.payments.model.paymenthandle.enums.PaymentHandleUsage;
import com.paysafe.payments.model.paymenthandle.enums.PaymentType;



/**
 * CustomerPaymentHandle
 */
public class CustomerPaymentHandle {

  @JsonProperty("id")
  private String id;
  @JsonProperty("status")
  private PaymentHandleStatus status;
  @JsonProperty("usage")
  private PaymentHandleUsage usage;
  @JsonProperty("action")
  private Action action;
  @JsonProperty("currencyCode")
  private CurrencyCode currencyCode;
  @JsonProperty("paymentHandleToken")
  private String paymentHandleToken;
  @JsonProperty("customerId")
  private String customerId;
  @JsonProperty("merchantRefNum")
  private String merchantRefNum;
  @JsonProperty("paymentType")
  private PaymentType paymentType;
  @JsonProperty("amount")
  private Integer amount;
  @JsonProperty("customerIp")
  private String customerIp;
  @JsonProperty("billingDetails")
  private BillingDetails billingDetails;
  @JsonProperty("merchantDescriptor")
  private MerchantDescriptor merchantDescriptor;
  @JsonProperty("billingDetailsId")
  private String billingDetailsId;
  @JsonProperty("paymentHandleTokenFrom")
  private String paymentHandleTokenFrom;
  @JsonProperty("card")
  private TokenizedCardDetails card;
  @JsonProperty("profile")
  private Profile profile;
  @JsonProperty("threeDs")
  private ThreeDs threeDs;
  @JsonProperty("authentication")
  private CardAuthentication authentication;
  @JsonProperty("transactionIntent")
  private String transactionIntent;
  @JsonProperty("gatewayResponse")
  private GatewayResponse gatewayResponse;
  @JsonProperty("shippingDetails")
  private ShippingDetails shippingDetails;
  @JsonProperty("eft")
  private Eft eft;
  @JsonProperty("dupCheck")
  private Boolean dupCheck;
  @JsonProperty("ach")
  private Ach ach;
  @JsonProperty("bacs")
  private Bacs bacs;
  @JsonProperty("mandates")
  private List<Mandate> mandates;
  @JsonProperty("sepa")
  private Sepa sepa;

  public CustomerPaymentHandle() {
    super();
  }

  private CustomerPaymentHandle(final Builder builder) {
    setId(builder.id);
    setStatus(builder.status);
    setUsage(builder.usage);
    setAction(builder.action);
    setCurrencyCode(builder.currencyCode);
    setPaymentHandleToken(builder.paymentHandleToken);
    setCustomerId(builder.customerId);
    setMerchantRefNum(builder.merchantRefNum);
    setPaymentType(builder.paymentType);
    setAmount(builder.amount);
    setCustomerIp(builder.customerIp);
    setBillingDetails(builder.billingDetails);
    setMerchantDescriptor(builder.merchantDescriptor);
    setBillingDetailsId(builder.billingDetailsId);
    setPaymentHandleTokenFrom(builder.paymentHandleTokenFrom);
    setCard(builder.card);
    setProfile(builder.profile);
    setThreeDs(builder.threeDs);
    setAuthentication(builder.authentication);
    setTransactionIntent(builder.transactionIntent);
    setGatewayResponse(builder.gatewayResponse);
    setShippingDetails(builder.shippingDetails);
    setEft(builder.eft);
    setDupCheck(builder.dupCheck);
    setAch(builder.ach);
    setBacs(builder.bacs);
    setMandates(builder.mandates);
    setSepa(builder.sepa);
  }

  public static Builder builder() {
    return new Builder();
  }


  public CustomerPaymentHandle id(String id) {
    this.id = id;
    return this;
  }

  /**
   * This is the ID returned in the response. This ID can be used for future associated requests, for example, to look up the Payment Handle.
   *
   * @return id
   */
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public CustomerPaymentHandle status(PaymentHandleStatus status) {
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


  public CustomerPaymentHandle usage(PaymentHandleUsage usage) {
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


  public CustomerPaymentHandle action(Action action) {
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


  public CustomerPaymentHandle currencyCode(CurrencyCode currencyCode) {
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


  public CustomerPaymentHandle paymentHandleToken(String paymentHandleToken) {
    this.paymentHandleToken = paymentHandleToken;
    return this;
  }

  /**
   * This is the payment token generated by Paysafe
   *
   * @return paymentHandleToken
   */
  public String getPaymentHandleToken() {
    return paymentHandleToken;
  }

  public void setPaymentHandleToken(String paymentHandleToken) {
    this.paymentHandleToken = paymentHandleToken;
  }


  public CustomerPaymentHandle customerId(String customerId) {
    this.customerId = customerId;
    return this;
  }

  /**
   * This is the customer ID
   *
   * @return customerId
   */
  public String getCustomerId() {
    return customerId;
  }

  public void setCustomerId(String customerId) {
    this.customerId = customerId;
  }


  public CustomerPaymentHandle merchantRefNum(String merchantRefNum) {
    this.merchantRefNum = merchantRefNum;
    return this;
  }

  /**
   * The merchant reference number
   *
   * @return merchantRefNum
   */
  public String getMerchantRefNum() {
    return merchantRefNum;
  }

  public void setMerchantRefNum(String merchantRefNum) {
    this.merchantRefNum = merchantRefNum;
  }


  public CustomerPaymentHandle paymentType(PaymentType paymentType) {
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


  public CustomerPaymentHandle amount(Integer amount) {
    this.amount = amount;
    return this;
  }

  /**
   * The amount in minor units
   *
   * @return amount
   */
  public Integer getAmount() {
    return amount;
  }

  public void setAmount(Integer amount) {
    this.amount = amount;
  }


  public CustomerPaymentHandle customerIp(String customerIp) {
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


  public CustomerPaymentHandle billingDetails(BillingDetails billingDetails) {
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


  public CustomerPaymentHandle merchantDescriptor(MerchantDescriptor merchantDescriptor) {
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


  public CustomerPaymentHandle billingDetailsId(String billingDetailsId) {
    this.billingDetailsId = billingDetailsId;
    return this;
  }

  /**
   * Billing details ID
   *
   * @return billingDetailsId
   */
  public String getBillingDetailsId() {
    return billingDetailsId;
  }

  public void setBillingDetailsId(String billingDetailsId) {
    this.billingDetailsId = billingDetailsId;
  }


  public CustomerPaymentHandle paymentHandleTokenFrom(String paymentHandleTokenFrom) {
    this.paymentHandleTokenFrom = paymentHandleTokenFrom;
    return this;
  }

  /**
   * Payment handle token from
   *
   * @return paymentHandleTokenFrom
   */
  public String getPaymentHandleTokenFrom() {
    return paymentHandleTokenFrom;
  }

  public void setPaymentHandleTokenFrom(String paymentHandleTokenFrom) {
    this.paymentHandleTokenFrom = paymentHandleTokenFrom;
  }


  public CustomerPaymentHandle card(TokenizedCardDetails card) {
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


  public CustomerPaymentHandle profile(Profile profile) {
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


  public CustomerPaymentHandle threeDs(ThreeDs threeDs) {
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


  public CustomerPaymentHandle authentication(CardAuthentication authentication) {
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


  public CustomerPaymentHandle transactionIntent(String transactionIntent) {
    this.transactionIntent = transactionIntent;
    return this;
  }

  /**
   * Transaction intent
   *
   * @return transactionIntent
   */
  public String getTransactionIntent() {
    return transactionIntent;
  }

  public void setTransactionIntent(String transactionIntent) {
    this.transactionIntent = transactionIntent;
  }


  public CustomerPaymentHandle gatewayResponse(GatewayResponse gatewayResponse) {
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


  public CustomerPaymentHandle shippingDetails(ShippingDetails shippingDetails) {
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


  public CustomerPaymentHandle eft(Eft eft) {
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


  public CustomerPaymentHandle dupCheck(Boolean dupCheck) {
    this.dupCheck = dupCheck;
    return this;
  }

  /**
   * Duplicate check flag
   *
   * @return dupCheck
   */
  public Boolean getDupCheck() {
    return dupCheck;
  }

  public void setDupCheck(Boolean dupCheck) {
    this.dupCheck = dupCheck;
  }


  public CustomerPaymentHandle ach(Ach ach) {
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


  public CustomerPaymentHandle bacs(Bacs bacs) {
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


  public CustomerPaymentHandle mandates(List<Mandate> mandates) {
    this.mandates = mandates;
    return this;
  }

  public CustomerPaymentHandle addMandatesItem(Mandate mandatesItem) {
    if (this.mandates == null) {
      this.mandates = new ArrayList<>();
    }
    this.mandates.add(mandatesItem);
    return this;
  }

  public CustomerPaymentHandle removeMandatesItem(Mandate mandatesItem) {
    if (mandatesItem != null && this.mandates != null) {
      this.mandates.remove(mandatesItem);
    }

    return this;
  }

  /**
   * Get mandates
   *
   * @return mandates
   */
  public List<Mandate> getMandates() {
    return mandates;
  }

  public void setMandates(List<Mandate> mandates) {
    this.mandates = mandates;
  }


  public CustomerPaymentHandle sepa(Sepa sepa) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CustomerPaymentHandle customerPaymentHandle = (CustomerPaymentHandle) o;
    return Objects.equals(this.id, customerPaymentHandle.id) &&
        Objects.equals(this.status, customerPaymentHandle.status) &&
        Objects.equals(this.usage, customerPaymentHandle.usage) &&
        Objects.equals(this.action, customerPaymentHandle.action) &&
        Objects.equals(this.currencyCode, customerPaymentHandle.currencyCode) &&
        Objects.equals(this.paymentHandleToken, customerPaymentHandle.paymentHandleToken) &&
        Objects.equals(this.customerId, customerPaymentHandle.customerId) &&
        Objects.equals(this.merchantRefNum, customerPaymentHandle.merchantRefNum) &&
        Objects.equals(this.paymentType, customerPaymentHandle.paymentType) &&
        Objects.equals(this.amount, customerPaymentHandle.amount) &&
        Objects.equals(this.customerIp, customerPaymentHandle.customerIp) &&
        Objects.equals(this.billingDetails, customerPaymentHandle.billingDetails) &&
        Objects.equals(this.merchantDescriptor, customerPaymentHandle.merchantDescriptor) &&
        Objects.equals(this.billingDetailsId, customerPaymentHandle.billingDetailsId) &&
        Objects.equals(this.paymentHandleTokenFrom, customerPaymentHandle.paymentHandleTokenFrom) &&
        Objects.equals(this.card, customerPaymentHandle.card) &&
        Objects.equals(this.profile, customerPaymentHandle.profile) &&
        Objects.equals(this.threeDs, customerPaymentHandle.threeDs) &&
        Objects.equals(this.authentication, customerPaymentHandle.authentication) &&
        Objects.equals(this.transactionIntent, customerPaymentHandle.transactionIntent) &&
        Objects.equals(this.gatewayResponse, customerPaymentHandle.gatewayResponse) &&
        Objects.equals(this.shippingDetails, customerPaymentHandle.shippingDetails) &&
        Objects.equals(this.eft, customerPaymentHandle.eft) &&
        Objects.equals(this.dupCheck, customerPaymentHandle.dupCheck) &&
        Objects.equals(this.ach, customerPaymentHandle.ach) &&
        Objects.equals(this.bacs, customerPaymentHandle.bacs) &&
        Objects.equals(this.mandates, customerPaymentHandle.mandates) &&
        Objects.equals(this.sepa, customerPaymentHandle.sepa);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, status, usage, action, currencyCode, paymentHandleToken, customerId, merchantRefNum, paymentType, amount, customerIp, billingDetails, merchantDescriptor, billingDetailsId, paymentHandleTokenFrom, card, profile, threeDs, authentication, transactionIntent, gatewayResponse, shippingDetails, eft, dupCheck, ach, bacs, mandates, sepa);
  }

  @Override
  public String toString() {

    return "class CustomerPaymentHandle {\n"
        + "    id: " + toIndentedString(id) + "\n"
        + "    status: " + toIndentedString(status) + "\n"
        + "    usage: " + toIndentedString(usage) + "\n"
        + "    action: " + toIndentedString(action) + "\n"
        + "    currencyCode: " + toIndentedString(currencyCode) + "\n"
        + "    paymentHandleToken: " + toIndentedString(paymentHandleToken) + "\n"
        + "    customerId: " + toIndentedString(customerId) + "\n"
        + "    merchantRefNum: " + toIndentedString(merchantRefNum) + "\n"
        + "    paymentType: " + toIndentedString(paymentType) + "\n"
        + "    amount: " + toIndentedString(amount) + "\n"
        + "    customerIp: " + toIndentedString(customerIp) + "\n"
        + "    billingDetails: " + toIndentedString(billingDetails) + "\n"
        + "    merchantDescriptor: " + toIndentedString(merchantDescriptor) + "\n"
        + "    billingDetailsId: " + toIndentedString(billingDetailsId) + "\n"
        + "    paymentHandleTokenFrom: " + toIndentedString(paymentHandleTokenFrom) + "\n"
        + "    card: " + toIndentedString(card) + "\n"
        + "    profile: " + toIndentedString(profile) + "\n"
        + "    threeDs: " + toIndentedString(threeDs) + "\n"
        + "    authentication: " + toIndentedString(authentication) + "\n"
        + "    transactionIntent: " + toIndentedString(transactionIntent) + "\n"
        + "    gatewayResponse: " + toIndentedString(gatewayResponse) + "\n"
        + "    shippingDetails: " + toIndentedString(shippingDetails) + "\n"
        + "    eft: " + toIndentedString(eft) + "\n"
        + "    dupCheck: " + toIndentedString(dupCheck) + "\n"
        + "    ach: " + toIndentedString(ach) + "\n"
        + "    bacs: " + toIndentedString(bacs) + "\n"
        + "    mandates: " + toIndentedString(mandates) + "\n"
        + "    sepa: " + toIndentedString(sepa) + "\n"
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
   * CustomerPaymentHandle builder static inner class.
   */
  public static final class Builder {
    private String id;
    private PaymentHandleStatus status;
    private PaymentHandleUsage usage;
    private Action action;
    private CurrencyCode currencyCode;
    private String paymentHandleToken;
    private String customerId;
    private String merchantRefNum;
    private PaymentType paymentType;
    private Integer amount;
    private String customerIp;
    private BillingDetails billingDetails;
    private MerchantDescriptor merchantDescriptor;
    private String billingDetailsId;
    private String paymentHandleTokenFrom;
    private TokenizedCardDetails card;
    private Profile profile;
    private ThreeDs threeDs;
    private CardAuthentication authentication;
    private String transactionIntent;
    private GatewayResponse gatewayResponse;
    private ShippingDetails shippingDetails;
    private Eft eft;
    private Boolean dupCheck;
    private Ach ach;
    private Bacs bacs;
    private List<Mandate> mandates;
    private Sepa sepa;

    private Builder() {
    }

    /**
     * This is the ID returned in the response. This ID can be used for future associated requests, for example, to look up the Payment Handle.
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
     * This is the payment token generated by Paysafe
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
     * This is the customer ID
     * <p>
     * Sets the customerId and returns a reference to this Builder enabling method chaining.
     *
     * @param customerId the customerId to set
     * @return a reference to this Builder
     */
    public Builder customerId(String customerId) {
      this.customerId = customerId;
      return this;
    }

    /**
     * The merchant reference number
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
     * The amount in minor units
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
     * Billing details ID
     * <p>
     * Sets the billingDetailsId and returns a reference to this Builder enabling method chaining.
     *
     * @param billingDetailsId the billingDetailsId to set
     * @return a reference to this Builder
     */
    public Builder billingDetailsId(String billingDetailsId) {
      this.billingDetailsId = billingDetailsId;
      return this;
    }

    /**
     * Payment handle token from
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
    public Builder authentication(CardAuthentication authentication) {
      this.authentication = authentication;
      return this;
    }

    /**
     * Transaction intent
     * <p>
     * Sets the transactionIntent and returns a reference to this Builder enabling method chaining.
     *
     * @param transactionIntent the transactionIntent to set
     * @return a reference to this Builder
     */
    public Builder transactionIntent(String transactionIntent) {
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
     * Duplicate check flag
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
     * Returns a CustomerPaymentHandle built from the parameters previously set.
     *
     * @return a CustomerPaymentHandle built with parameters of this CustomerPaymentHandle.Builder
     */
    public CustomerPaymentHandle build() {
      return new CustomerPaymentHandle(this);
    }
  }
}
