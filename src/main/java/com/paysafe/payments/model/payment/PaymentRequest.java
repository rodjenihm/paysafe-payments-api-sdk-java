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
import com.paysafe.payments.model.card.AccordD;
import com.paysafe.payments.model.card.AcquirerData;
import com.paysafe.payments.model.card.FundingTransaction;
import com.paysafe.payments.model.card.Level2Level3;
import com.paysafe.payments.model.card.MerchantDescriptor;
import com.paysafe.payments.model.card.Recipient;
import com.paysafe.payments.model.common.StoredCredential;
import com.paysafe.payments.model.common.enums.CurrencyCode;
import com.paysafe.payments.model.common.paymentfacilitator.PaymentFacilitator;
import com.paysafe.payments.model.common.travel.airline.AirlineTravelDetails;
import com.paysafe.payments.model.common.travel.carrental.CarRentalDetails;
import com.paysafe.payments.model.common.travel.cruise.CruiselineTravelDetails;
import com.paysafe.payments.model.common.travel.lodging.LodgingDetails;
import com.paysafe.payments.model.lpm.Splitpay;
import com.paysafe.payments.model.settlement.Settlement;



/**
 * Represents the body of a payment request.
 */
public class PaymentRequest {

  @JsonProperty("merchantRefNum")
  private String merchantRefNum;
  @JsonProperty("amount")
  private Integer amount;
  @JsonProperty("dupCheck")
  private Boolean dupCheck = true;
  @JsonProperty("settleWithAuth")
  private Boolean settleWithAuth;
  @JsonProperty("paymentHandleToken")
  private String paymentHandleToken;
  @JsonProperty("customerIp")
  private String customerIp;
  @JsonProperty("currencyCode")
  private CurrencyCode currencyCode;
  @JsonProperty("preAuth")
  private Boolean preAuth;
  @JsonProperty("description")
  private String description;
  @JsonProperty("partialAuth")
  private PartialAuth partialAuth;
  @JsonProperty("level2level3")
  private Level2Level3 level2level3;
  @JsonProperty("accordD")
  private AccordD accordD;
  @JsonProperty("recipient")
  private Recipient recipient;
  @JsonProperty("splitpay")
  private Splitpay splitpay;
  @JsonProperty("storedCredentialDetails")
  private StoredCredential storedCredentialDetails;
  @JsonProperty("airlineTravelDetails")
  private AirlineTravelDetails airlineTravelDetails;
  @JsonProperty("fundingTransaction")
  private FundingTransaction fundingTransaction;
  @JsonProperty("cruiselineTravelDetails")
  private CruiselineTravelDetails cruiselineTravelDetails;
  @JsonProperty("lodgingDetails")
  private LodgingDetails lodgingDetails;
  @JsonProperty("carRentalDetails")
  private CarRentalDetails carRentalDetails;
  @JsonProperty("paymentFacilitator")
  private PaymentFacilitator paymentFacilitator;
  @JsonProperty("merchantDescriptor")
  private MerchantDescriptor merchantDescriptor;
  @JsonProperty("acquirerData")
  private AcquirerData acquirerData;
  @JsonProperty("keywords")
  private List<String> keywords;
  private Map<String, Object> additionalParameters;

  public PaymentRequest() {
    super();
  }

  private PaymentRequest(final Builder builder) {
    setMerchantRefNum(builder.merchantRefNum);
    setAmount(builder.amount);
    setDupCheck(builder.dupCheck);
    setSettleWithAuth(builder.settleWithAuth);
    setPaymentHandleToken(builder.paymentHandleToken);
    setCustomerIp(builder.customerIp);
    setCurrencyCode(builder.currencyCode);
    setPreAuth(builder.preAuth);
    setDescription(builder.description);
    setPartialAuth(builder.partialAuth);
    setLevel2level3(builder.level2level3);
    setAccordD(builder.accordD);
    setRecipient(builder.recipient);
    setSplitpay(builder.splitpay);
    setStoredCredentialDetails(builder.storedCredentialDetails);
    setAirlineTravelDetails(builder.airlineTravelDetails);
    setFundingTransaction(builder.fundingTransaction);
    setCruiselineTravelDetails(builder.cruiselineTravelDetails);
    setLodgingDetails(builder.lodgingDetails);
    setCarRentalDetails(builder.carRentalDetails);
    setPaymentFacilitator(builder.paymentFacilitator);
    setMerchantDescriptor(builder.merchantDescriptor);
    setAcquirerData(builder.acquirerData);
    setKeywords(builder.keywords);
    this.additionalParameters = builder.additionalParameters;
  }

  public static Builder builder() {
    return new Builder();
  }


  public PaymentRequest merchantRefNum(String merchantRefNum) {
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


  public PaymentRequest amount(Integer amount) {
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


  public PaymentRequest dupCheck(Boolean dupCheck) {
    this.dupCheck = dupCheck;
    return this;
  }

  /**
   * This validates that this request is not a duplicate.
   *
   * @return dupCheck
   */
  public Boolean getDupCheck() {
    return dupCheck;
  }

  public void setDupCheck(Boolean dupCheck) {
    this.dupCheck = dupCheck;
  }


  public PaymentRequest settleWithAuth(Boolean settleWithAuth) {
    this.settleWithAuth = settleWithAuth;
    return this;
  }

  /**
   * This indicates whether the request is an Authorization only (no Settlement), or a Purchase (Authorization and Settlement).
   *
   * @return settleWithAuth
   */
  public Boolean getSettleWithAuth() {
    return settleWithAuth;
  }

  public void setSettleWithAuth(Boolean settleWithAuth) {
    this.settleWithAuth = settleWithAuth;
  }


  public PaymentRequest paymentHandleToken(String paymentHandleToken) {
    this.paymentHandleToken = paymentHandleToken;
    return this;
  }

  /**
   * This is the payment token generated by Paysafe that will be used for the Payment request.
   *
   * @return paymentHandleToken
   */
  public String getPaymentHandleToken() {
    return paymentHandleToken;
  }

  public void setPaymentHandleToken(String paymentHandleToken) {
    this.paymentHandleToken = paymentHandleToken;
  }


  public PaymentRequest customerIp(String customerIp) {
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


  public PaymentRequest currencyCode(CurrencyCode currencyCode) {
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


  public PaymentRequest preAuth(Boolean preAuth) {
    this.preAuth = preAuth;
    return this;
  }

  /**
   * This indicates whether the Authorization request should be sent as a Pre-Authorization. <br> **Note:** You should use the preAuth element in cases where you are not sure that you can fully settle the Authorization within 4 days. Contact your account manager for more information.
   *
   * @return preAuth
   */
  public Boolean getPreAuth() {
    return preAuth;
  }

  public void setPreAuth(Boolean preAuth) {
    this.preAuth = preAuth;
  }


  public PaymentRequest description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Description of the transaction provided by the merchant.
   *
   * @return description
   */
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  public PaymentRequest partialAuth(PartialAuth partialAuth) {
    this.partialAuth = partialAuth;
    return this;
  }

  /**
   * Get partialAuth
   *
   * @return partialAuth
   */
  public PartialAuth getPartialAuth() {
    return partialAuth;
  }

  public void setPartialAuth(PartialAuth partialAuth) {
    this.partialAuth = partialAuth;
  }


  public PaymentRequest level2level3(Level2Level3 level2level3) {
    this.level2level3 = level2level3;
    return this;
  }

  /**
   * Get level2level3
   *
   * @return level2level3
   */
  public Level2Level3 getLevel2level3() {
    return level2level3;
  }

  public void setLevel2level3(Level2Level3 level2level3) {
    this.level2level3 = level2level3;
  }


  public PaymentRequest accordD(AccordD accordD) {
    this.accordD = accordD;
    return this;
  }

  /**
   * Get accordD
   *
   * @return accordD
   */
  public AccordD getAccordD() {
    return accordD;
  }

  public void setAccordD(AccordD accordD) {
    this.accordD = accordD;
  }


  public PaymentRequest recipient(Recipient recipient) {
    this.recipient = recipient;
    return this;
  }

  /**
   * Get recipient
   *
   * @return recipient
   */
  public Recipient getRecipient() {
    return recipient;
  }

  public void setRecipient(Recipient recipient) {
    this.recipient = recipient;
  }


  public PaymentRequest splitpay(Splitpay splitpay) {
    this.splitpay = splitpay;
    return this;
  }

  /**
   * Get splitpay
   *
   * @return splitpay
   */
  public Splitpay getSplitpay() {
    return splitpay;
  }

  public void setSplitpay(Splitpay splitpay) {
    this.splitpay = splitpay;
  }


  public PaymentRequest storedCredentialDetails(StoredCredential storedCredentialDetails) {
    this.storedCredentialDetails = storedCredentialDetails;
    return this;
  }

  /**
   * Get storedCredentialDetails
   *
   * @return storedCredentialDetails
   */
  public StoredCredential getStoredCredentialDetails() {
    return storedCredentialDetails;
  }

  public void setStoredCredentialDetails(StoredCredential storedCredentialDetails) {
    this.storedCredentialDetails = storedCredentialDetails;
  }


  public PaymentRequest airlineTravelDetails(AirlineTravelDetails airlineTravelDetails) {
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


  public PaymentRequest fundingTransaction(FundingTransaction fundingTransaction) {
    this.fundingTransaction = fundingTransaction;
    return this;
  }

  /**
   * Get fundingTransaction
   *
   * @return fundingTransaction
   */
  public FundingTransaction getFundingTransaction() {
    return fundingTransaction;
  }

  public void setFundingTransaction(FundingTransaction fundingTransaction) {
    this.fundingTransaction = fundingTransaction;
  }


  public PaymentRequest cruiselineTravelDetails(CruiselineTravelDetails cruiselineTravelDetails) {
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


  public PaymentRequest lodgingDetails(LodgingDetails lodgingDetails) {
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


  public PaymentRequest carRentalDetails(CarRentalDetails carRentalDetails) {
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


  public PaymentRequest paymentFacilitator(PaymentFacilitator paymentFacilitator) {
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


  public PaymentRequest merchantDescriptor(MerchantDescriptor merchantDescriptor) {
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


  public PaymentRequest acquirerData(AcquirerData acquirerData) {
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


  public PaymentRequest keywords(List<String> keywords) {
    this.keywords = keywords;
    return this;
  }

  public PaymentRequest addKeywordsItem(String keywordsItem) {
    if (this.keywords == null) {
      this.keywords = new ArrayList<>();
    }
    this.keywords.add(keywordsItem);
    return this;
  }

  public PaymentRequest removeKeywordsItem(String keywordsItem) {
    if (keywordsItem != null && this.keywords != null) {
      this.keywords.remove(keywordsItem);
    }

    return this;
  }

  /**
   * List of keywords associated with the payment.
   *
   * @return keywords
   */
  public List<String> getKeywords() {
    return keywords;
  }

  public void setKeywords(List<String> keywords) {
    this.keywords = keywords;
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
    PaymentRequest paymentRequest = (PaymentRequest) o;
    return Objects.equals(this.merchantRefNum, paymentRequest.merchantRefNum) &&
        Objects.equals(this.amount, paymentRequest.amount) &&
        Objects.equals(this.dupCheck, paymentRequest.dupCheck) &&
        Objects.equals(this.settleWithAuth, paymentRequest.settleWithAuth) &&
        Objects.equals(this.paymentHandleToken, paymentRequest.paymentHandleToken) &&
        Objects.equals(this.customerIp, paymentRequest.customerIp) &&
        Objects.equals(this.currencyCode, paymentRequest.currencyCode) &&
        Objects.equals(this.preAuth, paymentRequest.preAuth) &&
        Objects.equals(this.description, paymentRequest.description) &&
        Objects.equals(this.partialAuth, paymentRequest.partialAuth) &&
        Objects.equals(this.level2level3, paymentRequest.level2level3) &&
        Objects.equals(this.accordD, paymentRequest.accordD) &&
        Objects.equals(this.recipient, paymentRequest.recipient) &&
        Objects.equals(this.splitpay, paymentRequest.splitpay) &&
        Objects.equals(this.storedCredentialDetails, paymentRequest.storedCredentialDetails) &&
        Objects.equals(this.airlineTravelDetails, paymentRequest.airlineTravelDetails) &&
        Objects.equals(this.fundingTransaction, paymentRequest.fundingTransaction) &&
        Objects.equals(this.cruiselineTravelDetails, paymentRequest.cruiselineTravelDetails) &&
        Objects.equals(this.lodgingDetails, paymentRequest.lodgingDetails) &&
        Objects.equals(this.carRentalDetails, paymentRequest.carRentalDetails) &&
        Objects.equals(this.paymentFacilitator, paymentRequest.paymentFacilitator) &&
        Objects.equals(this.merchantDescriptor, paymentRequest.merchantDescriptor) &&
        Objects.equals(this.acquirerData, paymentRequest.acquirerData) &&
        Objects.equals(this.keywords, paymentRequest.keywords);
  }

  @Override
  public int hashCode() {
    return Objects.hash(merchantRefNum, amount, dupCheck, settleWithAuth, paymentHandleToken, customerIp, currencyCode, preAuth, description, partialAuth, level2level3, accordD, recipient, splitpay, storedCredentialDetails, airlineTravelDetails, fundingTransaction, cruiselineTravelDetails, lodgingDetails, carRentalDetails, paymentFacilitator, merchantDescriptor, acquirerData, keywords);
  }

  @Override
  public String toString() {

    return "class PaymentRequest {\n"
        + "    merchantRefNum: " + toIndentedString(merchantRefNum) + "\n"
        + "    amount: " + toIndentedString(amount) + "\n"
        + "    dupCheck: " + toIndentedString(dupCheck) + "\n"
        + "    settleWithAuth: " + toIndentedString(settleWithAuth) + "\n"
        + "    paymentHandleToken: " + toIndentedString(paymentHandleToken) + "\n"
        + "    customerIp: " + toIndentedString(customerIp) + "\n"
        + "    currencyCode: " + toIndentedString(currencyCode) + "\n"
        + "    preAuth: " + toIndentedString(preAuth) + "\n"
        + "    description: " + toIndentedString(description) + "\n"
        + "    partialAuth: " + toIndentedString(partialAuth) + "\n"
        + "    level2level3: " + toIndentedString(level2level3) + "\n"
        + "    accordD: " + toIndentedString(accordD) + "\n"
        + "    recipient: " + toIndentedString(recipient) + "\n"
        + "    splitpay: " + toIndentedString(splitpay) + "\n"
        + "    storedCredentialDetails: " + toIndentedString(storedCredentialDetails) + "\n"
        + "    airlineTravelDetails: " + toIndentedString(airlineTravelDetails) + "\n"
        + "    fundingTransaction: " + toIndentedString(fundingTransaction) + "\n"
        + "    cruiselineTravelDetails: " + toIndentedString(cruiselineTravelDetails) + "\n"
        + "    lodgingDetails: " + toIndentedString(lodgingDetails) + "\n"
        + "    carRentalDetails: " + toIndentedString(carRentalDetails) + "\n"
        + "    paymentFacilitator: " + toIndentedString(paymentFacilitator) + "\n"
        + "    merchantDescriptor: " + toIndentedString(merchantDescriptor) + "\n"
        + "    acquirerData: " + toIndentedString(acquirerData) + "\n"
        + "    keywords: " + toIndentedString(keywords) + "\n"
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
   * Represents the body of a payment request. builder static inner class.
   */
  public static final class Builder {
    private String merchantRefNum;
    private Integer amount;
    private Boolean dupCheck;
    private Boolean settleWithAuth;
    private String paymentHandleToken;
    private String customerIp;
    private CurrencyCode currencyCode;
    private Boolean preAuth;
    private String description;
    private PartialAuth partialAuth;
    private Level2Level3 level2level3;
    private AccordD accordD;
    private Recipient recipient;
    private Splitpay splitpay;
    private StoredCredential storedCredentialDetails;
    private AirlineTravelDetails airlineTravelDetails;
    private FundingTransaction fundingTransaction;
    private CruiselineTravelDetails cruiselineTravelDetails;
    private LodgingDetails lodgingDetails;
    private CarRentalDetails carRentalDetails;
    private PaymentFacilitator paymentFacilitator;
    private MerchantDescriptor merchantDescriptor;
    private AcquirerData acquirerData;
    private List<String> keywords;
    private Map<String, Object> additionalParameters;

    private Builder() {
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
     * This validates that this request is not a duplicate.
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
     * This indicates whether the request is an Authorization only (no Settlement), or a Purchase (Authorization and Settlement).
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
     * This is the payment token generated by Paysafe that will be used for the Payment request.
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
     * This indicates whether the Authorization request should be sent as a Pre-Authorization. <br> **Note:** You should use the preAuth element in cases where you are not sure that you can fully settle the Authorization within 4 days. Contact your account manager for more information.
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
     * Description of the transaction provided by the merchant.
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
     * Sets the partialAuth and returns a reference to this Builder enabling method chaining.
     *
     * @param partialAuth the partialAuth to set
     * @return a reference to this Builder
     */
    public Builder partialAuth(PartialAuth partialAuth) {
      this.partialAuth = partialAuth;
      return this;
    }

    /**
     * Sets the level2level3 and returns a reference to this Builder enabling method chaining.
     *
     * @param level2level3 the level2level3 to set
     * @return a reference to this Builder
     */
    public Builder level2level3(Level2Level3 level2level3) {
      this.level2level3 = level2level3;
      return this;
    }

    /**
     * Sets the accordD and returns a reference to this Builder enabling method chaining.
     *
     * @param accordD the accordD to set
     * @return a reference to this Builder
     */
    public Builder accordD(AccordD accordD) {
      this.accordD = accordD;
      return this;
    }

    /**
     * Sets the recipient and returns a reference to this Builder enabling method chaining.
     *
     * @param recipient the recipient to set
     * @return a reference to this Builder
     */
    public Builder recipient(Recipient recipient) {
      this.recipient = recipient;
      return this;
    }

    /**
     * Sets the splitpay and returns a reference to this Builder enabling method chaining.
     *
     * @param splitpay the splitpay to set
     * @return a reference to this Builder
     */
    public Builder splitpay(Splitpay splitpay) {
      this.splitpay = splitpay;
      return this;
    }

    /**
     * Sets the storedCredentialDetails and returns a reference to this Builder enabling method chaining.
     *
     * @param storedCredentialDetails the storedCredentialDetails to set
     * @return a reference to this Builder
     */
    public Builder storedCredentialDetails(StoredCredential storedCredentialDetails) {
      this.storedCredentialDetails = storedCredentialDetails;
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
     * Sets the fundingTransaction and returns a reference to this Builder enabling method chaining.
     *
     * @param fundingTransaction the fundingTransaction to set
     * @return a reference to this Builder
     */
    public Builder fundingTransaction(FundingTransaction fundingTransaction) {
      this.fundingTransaction = fundingTransaction;
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
     * List of keywords associated with the payment.
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
     * Returns a PaymentRequest built from the parameters previously set.
     *
     * @return a PaymentRequest built with parameters of this PaymentRequest.Builder
     */
    public PaymentRequest build() {
      return new PaymentRequest(this);
    }
  }
}
