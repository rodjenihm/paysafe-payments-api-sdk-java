// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.model.card.threeds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.paysafe.payments.model.card.BillingCycle;
import com.paysafe.payments.model.card.enums.ThreeDsAuthenticationPurpose;
import com.paysafe.payments.model.card.enums.ThreeDsDeviceChannel;
import com.paysafe.payments.model.card.enums.ThreeDsMessageCategory;
import com.paysafe.payments.model.card.enums.ThreeDsRequestorChallengePreference;
import com.paysafe.payments.model.card.enums.ThreeDsTransactionIntent;



/**
 * 3D Secure authentication details. You need to send this object when you want to process CARD transaction with 3DS. Required if account is enabled for 3DS.
 */
public class ThreeDs {

  @JsonProperty("id")
  private String id;
  @JsonProperty("merchantUrl")
  private String merchantUrl;
  @JsonProperty("deviceChannel")
  private ThreeDsDeviceChannel deviceChannel;
  @JsonProperty("requestorChallengePreference")
  private ThreeDsRequestorChallengePreference requestorChallengePreference;
  @JsonProperty("messageCategory")
  private ThreeDsMessageCategory messageCategory;
  @JsonProperty("authenticationPurpose")
  private ThreeDsAuthenticationPurpose authenticationPurpose;
  @JsonProperty("transactionIntent")
  private ThreeDsTransactionIntent transactionIntent;
  @JsonProperty("process")
  private Boolean process;
  @JsonProperty("deviceFingerprintingId")
  private String deviceFingerprintingId;
  @JsonProperty("maxAuthorizationsForInstalmentPayment")
  private Integer maxAuthorizationsForInstalmentPayment;
  @JsonProperty("suspiciousAccountActivity")
  private Boolean suspiciousAccountActivity;
  @JsonProperty("totalPurchasesSixMonthCount")
  private Integer totalPurchasesSixMonthCount;
  @JsonProperty("transactionCountForPreviousDay")
  private Integer transactionCountForPreviousDay;
  @JsonProperty("transactionCountForPreviousYear")
  private Integer transactionCountForPreviousYear;
  @JsonProperty("txnTime")
  private String txnTime;
  @JsonProperty("initialPurchaseTime")
  private String initialPurchaseTime;
  @JsonProperty("billingCycle")
  private BillingCycle billingCycle;
  @JsonProperty("browserDetails")
  private BrowserDetails browserDetails;
  @JsonProperty("orderItemDetails")
  private OrderItemDetails orderItemDetails;
  @JsonProperty("purchasedGiftCardDetails")
  private PurchasedGiftCardDetails purchasedGiftCardDetails;
  @JsonProperty("userAccountDetails")
  private UserAccountDetails userAccountDetails;
  @JsonProperty("shippingDetailsUsage")
  private ShippingDetailsUsage shippingDetailsUsage;
  @JsonProperty("travelDetails")
  private TravelDetails travelDetails;
  @JsonProperty("userLogin")
  private UserLogin userLogin;
  @JsonProperty("electronicDelivery")
  private ElectronicDelivery electronicDelivery;

  public ThreeDs() {
    super();
  }

  private ThreeDs(final Builder builder) {
    setId(builder.id);
    setMerchantUrl(builder.merchantUrl);
    setDeviceChannel(builder.deviceChannel);
    setRequestorChallengePreference(builder.requestorChallengePreference);
    setMessageCategory(builder.messageCategory);
    setAuthenticationPurpose(builder.authenticationPurpose);
    setTransactionIntent(builder.transactionIntent);
    setProcess(builder.process);
    setDeviceFingerprintingId(builder.deviceFingerprintingId);
    setMaxAuthorizationsForInstalmentPayment(builder.maxAuthorizationsForInstalmentPayment);
    setSuspiciousAccountActivity(builder.suspiciousAccountActivity);
    setTotalPurchasesSixMonthCount(builder.totalPurchasesSixMonthCount);
    setTransactionCountForPreviousDay(builder.transactionCountForPreviousDay);
    setTransactionCountForPreviousYear(builder.transactionCountForPreviousYear);
    setTxnTime(builder.txnTime);
    setInitialPurchaseTime(builder.initialPurchaseTime);
    setBillingCycle(builder.billingCycle);
    setBrowserDetails(builder.browserDetails);
    setOrderItemDetails(builder.orderItemDetails);
    setPurchasedGiftCardDetails(builder.purchasedGiftCardDetails);
    setUserAccountDetails(builder.userAccountDetails);
    setShippingDetailsUsage(builder.shippingDetailsUsage);
    setTravelDetails(builder.travelDetails);
    setUserLogin(builder.userLogin);
    setElectronicDelivery(builder.electronicDelivery);
  }

  public static Builder builder() {
    return new Builder();
  }


  public ThreeDs id(String id) {
    this.id = id;
    return this;
  }

  /**
   * The unique ID returned in the response
   *
   * @return id
   */
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public ThreeDs merchantUrl(String merchantUrl) {
    this.merchantUrl = merchantUrl;
    return this;
  }

  /**
   * Fully qualified URL of the merchant's commercial or customer care website
   *
   * @return merchantUrl
   */
  public String getMerchantUrl() {
    return merchantUrl;
  }

  public void setMerchantUrl(String merchantUrl) {
    this.merchantUrl = merchantUrl;
  }


  public ThreeDs deviceChannel(ThreeDsDeviceChannel deviceChannel) {
    this.deviceChannel = deviceChannel;
    return this;
  }

  /**
   * Get deviceChannel
   *
   * @return deviceChannel
   */
  public ThreeDsDeviceChannel getDeviceChannel() {
    return deviceChannel;
  }

  public void setDeviceChannel(ThreeDsDeviceChannel deviceChannel) {
    this.deviceChannel = deviceChannel;
  }


  public ThreeDs requestorChallengePreference(ThreeDsRequestorChallengePreference requestorChallengePreference) {
    this.requestorChallengePreference = requestorChallengePreference;
    return this;
  }

  /**
   * Get requestorChallengePreference
   *
   * @return requestorChallengePreference
   */
  public ThreeDsRequestorChallengePreference getRequestorChallengePreference() {
    return requestorChallengePreference;
  }

  public void setRequestorChallengePreference(ThreeDsRequestorChallengePreference requestorChallengePreference) {
    this.requestorChallengePreference = requestorChallengePreference;
  }


  public ThreeDs messageCategory(ThreeDsMessageCategory messageCategory) {
    this.messageCategory = messageCategory;
    return this;
  }

  /**
   * Get messageCategory
   *
   * @return messageCategory
   */
  public ThreeDsMessageCategory getMessageCategory() {
    return messageCategory;
  }

  public void setMessageCategory(ThreeDsMessageCategory messageCategory) {
    this.messageCategory = messageCategory;
  }


  public ThreeDs authenticationPurpose(ThreeDsAuthenticationPurpose authenticationPurpose) {
    this.authenticationPurpose = authenticationPurpose;
    return this;
  }

  /**
   * Get authenticationPurpose
   *
   * @return authenticationPurpose
   */
  public ThreeDsAuthenticationPurpose getAuthenticationPurpose() {
    return authenticationPurpose;
  }

  public void setAuthenticationPurpose(ThreeDsAuthenticationPurpose authenticationPurpose) {
    this.authenticationPurpose = authenticationPurpose;
  }


  public ThreeDs transactionIntent(ThreeDsTransactionIntent transactionIntent) {
    this.transactionIntent = transactionIntent;
    return this;
  }

  /**
   * Get transactionIntent
   *
   * @return transactionIntent
   */
  public ThreeDsTransactionIntent getTransactionIntent() {
    return transactionIntent;
  }

  public void setTransactionIntent(ThreeDsTransactionIntent transactionIntent) {
    this.transactionIntent = transactionIntent;
  }


  public ThreeDs process(Boolean process) {
    this.process = process;
    return this;
  }

  /**
   * Indicator representing whether to call authenticate endpoint or not
   *
   * @return process
   */
  public Boolean getProcess() {
    return process;
  }

  public void setProcess(Boolean process) {
    this.process = process;
  }


  public ThreeDs deviceFingerprintingId(String deviceFingerprintingId) {
    this.deviceFingerprintingId = deviceFingerprintingId;
    return this;
  }

  /**
   * UUID used with device fingerprinting
   *
   * @return deviceFingerprintingId
   */
  public String getDeviceFingerprintingId() {
    return deviceFingerprintingId;
  }

  public void setDeviceFingerprintingId(String deviceFingerprintingId) {
    this.deviceFingerprintingId = deviceFingerprintingId;
  }


  public ThreeDs maxAuthorizationsForInstalmentPayment(Integer maxAuthorizationsForInstalmentPayment) {
    this.maxAuthorizationsForInstalmentPayment = maxAuthorizationsForInstalmentPayment;
    return this;
  }

  /**
   * Maximum number of authorizations for instalment payment
   *
   * @return maxAuthorizationsForInstalmentPayment
   */
  public Integer getMaxAuthorizationsForInstalmentPayment() {
    return maxAuthorizationsForInstalmentPayment;
  }

  public void setMaxAuthorizationsForInstalmentPayment(Integer maxAuthorizationsForInstalmentPayment) {
    this.maxAuthorizationsForInstalmentPayment = maxAuthorizationsForInstalmentPayment;
  }


  public ThreeDs suspiciousAccountActivity(Boolean suspiciousAccountActivity) {
    this.suspiciousAccountActivity = suspiciousAccountActivity;
    return this;
  }

  /**
   * Indicates whether the 3DS Requestor has experienced suspicious activity on the cardholder account
   *
   * @return suspiciousAccountActivity
   */
  public Boolean getSuspiciousAccountActivity() {
    return suspiciousAccountActivity;
  }

  public void setSuspiciousAccountActivity(Boolean suspiciousAccountActivity) {
    this.suspiciousAccountActivity = suspiciousAccountActivity;
  }


  public ThreeDs totalPurchasesSixMonthCount(Integer totalPurchasesSixMonthCount) {
    this.totalPurchasesSixMonthCount = totalPurchasesSixMonthCount;
    return this;
  }

  /**
   * Transaction count for last 6 months
   *
   * @return totalPurchasesSixMonthCount
   */
  public Integer getTotalPurchasesSixMonthCount() {
    return totalPurchasesSixMonthCount;
  }

  public void setTotalPurchasesSixMonthCount(Integer totalPurchasesSixMonthCount) {
    this.totalPurchasesSixMonthCount = totalPurchasesSixMonthCount;
  }


  public ThreeDs transactionCountForPreviousDay(Integer transactionCountForPreviousDay) {
    this.transactionCountForPreviousDay = transactionCountForPreviousDay;
    return this;
  }

  /**
   * Number of transactions in the previous day
   *
   * @return transactionCountForPreviousDay
   */
  public Integer getTransactionCountForPreviousDay() {
    return transactionCountForPreviousDay;
  }

  public void setTransactionCountForPreviousDay(Integer transactionCountForPreviousDay) {
    this.transactionCountForPreviousDay = transactionCountForPreviousDay;
  }


  public ThreeDs transactionCountForPreviousYear(Integer transactionCountForPreviousYear) {
    this.transactionCountForPreviousYear = transactionCountForPreviousYear;
    return this;
  }

  /**
   * Number of transactions in the previous year
   *
   * @return transactionCountForPreviousYear
   */
  public Integer getTransactionCountForPreviousYear() {
    return transactionCountForPreviousYear;
  }

  public void setTransactionCountForPreviousYear(Integer transactionCountForPreviousYear) {
    this.transactionCountForPreviousYear = transactionCountForPreviousYear;
  }


  public ThreeDs txnTime(String txnTime) {
    this.txnTime = txnTime;
    return this;
  }

  /**
   * Date and time of the transaction
   *
   * @return txnTime
   */
  public String getTxnTime() {
    return txnTime;
  }

  public void setTxnTime(String txnTime) {
    this.txnTime = txnTime;
  }


  public ThreeDs initialPurchaseTime(String initialPurchaseTime) {
    this.initialPurchaseTime = initialPurchaseTime;
    return this;
  }

  /**
   * Date and time of the initial purchase. <b>Note:</b> This element is required only if messageCategory=NON_PAYMENT and authenticationPurpose=INSTALMENT_TRANSACTION or RECURRING_TRANSACTION
   *
   * @return initialPurchaseTime
   */
  public String getInitialPurchaseTime() {
    return initialPurchaseTime;
  }

  public void setInitialPurchaseTime(String initialPurchaseTime) {
    this.initialPurchaseTime = initialPurchaseTime;
  }


  public ThreeDs billingCycle(BillingCycle billingCycle) {
    this.billingCycle = billingCycle;
    return this;
  }

  /**
   * Get billingCycle
   *
   * @return billingCycle
   */
  public BillingCycle getBillingCycle() {
    return billingCycle;
  }

  public void setBillingCycle(BillingCycle billingCycle) {
    this.billingCycle = billingCycle;
  }


  public ThreeDs browserDetails(BrowserDetails browserDetails) {
    this.browserDetails = browserDetails;
    return this;
  }

  /**
   * Get browserDetails
   *
   * @return browserDetails
   */
  public BrowserDetails getBrowserDetails() {
    return browserDetails;
  }

  public void setBrowserDetails(BrowserDetails browserDetails) {
    this.browserDetails = browserDetails;
  }


  public ThreeDs orderItemDetails(OrderItemDetails orderItemDetails) {
    this.orderItemDetails = orderItemDetails;
    return this;
  }

  /**
   * Get orderItemDetails
   *
   * @return orderItemDetails
   */
  public OrderItemDetails getOrderItemDetails() {
    return orderItemDetails;
  }

  public void setOrderItemDetails(OrderItemDetails orderItemDetails) {
    this.orderItemDetails = orderItemDetails;
  }


  public ThreeDs purchasedGiftCardDetails(PurchasedGiftCardDetails purchasedGiftCardDetails) {
    this.purchasedGiftCardDetails = purchasedGiftCardDetails;
    return this;
  }

  /**
   * Get purchasedGiftCardDetails
   *
   * @return purchasedGiftCardDetails
   */
  public PurchasedGiftCardDetails getPurchasedGiftCardDetails() {
    return purchasedGiftCardDetails;
  }

  public void setPurchasedGiftCardDetails(PurchasedGiftCardDetails purchasedGiftCardDetails) {
    this.purchasedGiftCardDetails = purchasedGiftCardDetails;
  }


  public ThreeDs userAccountDetails(UserAccountDetails userAccountDetails) {
    this.userAccountDetails = userAccountDetails;
    return this;
  }

  /**
   * Get userAccountDetails
   *
   * @return userAccountDetails
   */
  public UserAccountDetails getUserAccountDetails() {
    return userAccountDetails;
  }

  public void setUserAccountDetails(UserAccountDetails userAccountDetails) {
    this.userAccountDetails = userAccountDetails;
  }


  public ThreeDs shippingDetailsUsage(ShippingDetailsUsage shippingDetailsUsage) {
    this.shippingDetailsUsage = shippingDetailsUsage;
    return this;
  }

  /**
   * Get shippingDetailsUsage
   *
   * @return shippingDetailsUsage
   */
  public ShippingDetailsUsage getShippingDetailsUsage() {
    return shippingDetailsUsage;
  }

  public void setShippingDetailsUsage(ShippingDetailsUsage shippingDetailsUsage) {
    this.shippingDetailsUsage = shippingDetailsUsage;
  }


  public ThreeDs travelDetails(TravelDetails travelDetails) {
    this.travelDetails = travelDetails;
    return this;
  }

  /**
   * Get travelDetails
   *
   * @return travelDetails
   */
  public TravelDetails getTravelDetails() {
    return travelDetails;
  }

  public void setTravelDetails(TravelDetails travelDetails) {
    this.travelDetails = travelDetails;
  }


  public ThreeDs userLogin(UserLogin userLogin) {
    this.userLogin = userLogin;
    return this;
  }

  /**
   * Get userLogin
   *
   * @return userLogin
   */
  public UserLogin getUserLogin() {
    return userLogin;
  }

  public void setUserLogin(UserLogin userLogin) {
    this.userLogin = userLogin;
  }


  public ThreeDs electronicDelivery(ElectronicDelivery electronicDelivery) {
    this.electronicDelivery = electronicDelivery;
    return this;
  }

  /**
   * Get electronicDelivery
   *
   * @return electronicDelivery
   */
  public ElectronicDelivery getElectronicDelivery() {
    return electronicDelivery;
  }

  public void setElectronicDelivery(ElectronicDelivery electronicDelivery) {
    this.electronicDelivery = electronicDelivery;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ThreeDs threeDs = (ThreeDs) o;
    return Objects.equals(this.id, threeDs.id) &&
        Objects.equals(this.merchantUrl, threeDs.merchantUrl) &&
        Objects.equals(this.deviceChannel, threeDs.deviceChannel) &&
        Objects.equals(this.requestorChallengePreference, threeDs.requestorChallengePreference) &&
        Objects.equals(this.messageCategory, threeDs.messageCategory) &&
        Objects.equals(this.authenticationPurpose, threeDs.authenticationPurpose) &&
        Objects.equals(this.transactionIntent, threeDs.transactionIntent) &&
        Objects.equals(this.process, threeDs.process) &&
        Objects.equals(this.deviceFingerprintingId, threeDs.deviceFingerprintingId) &&
        Objects.equals(this.maxAuthorizationsForInstalmentPayment, threeDs.maxAuthorizationsForInstalmentPayment) &&
        Objects.equals(this.suspiciousAccountActivity, threeDs.suspiciousAccountActivity) &&
        Objects.equals(this.totalPurchasesSixMonthCount, threeDs.totalPurchasesSixMonthCount) &&
        Objects.equals(this.transactionCountForPreviousDay, threeDs.transactionCountForPreviousDay) &&
        Objects.equals(this.transactionCountForPreviousYear, threeDs.transactionCountForPreviousYear) &&
        Objects.equals(this.txnTime, threeDs.txnTime) &&
        Objects.equals(this.initialPurchaseTime, threeDs.initialPurchaseTime) &&
        Objects.equals(this.billingCycle, threeDs.billingCycle) &&
        Objects.equals(this.browserDetails, threeDs.browserDetails) &&
        Objects.equals(this.orderItemDetails, threeDs.orderItemDetails) &&
        Objects.equals(this.purchasedGiftCardDetails, threeDs.purchasedGiftCardDetails) &&
        Objects.equals(this.userAccountDetails, threeDs.userAccountDetails) &&
        Objects.equals(this.shippingDetailsUsage, threeDs.shippingDetailsUsage) &&
        Objects.equals(this.travelDetails, threeDs.travelDetails) &&
        Objects.equals(this.userLogin, threeDs.userLogin) &&
        Objects.equals(this.electronicDelivery, threeDs.electronicDelivery);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, merchantUrl, deviceChannel, requestorChallengePreference, messageCategory, authenticationPurpose, transactionIntent, process, deviceFingerprintingId, maxAuthorizationsForInstalmentPayment, suspiciousAccountActivity, totalPurchasesSixMonthCount, transactionCountForPreviousDay, transactionCountForPreviousYear, txnTime, initialPurchaseTime, billingCycle, browserDetails, orderItemDetails, purchasedGiftCardDetails, userAccountDetails, shippingDetailsUsage, travelDetails, userLogin, electronicDelivery);
  }

  @Override
  public String toString() {

    return "class ThreeDs {\n"
        + "    id: " + toIndentedString(id) + "\n"
        + "    merchantUrl: " + toIndentedString(merchantUrl) + "\n"
        + "    deviceChannel: " + toIndentedString(deviceChannel) + "\n"
        + "    requestorChallengePreference: " + toIndentedString(requestorChallengePreference) + "\n"
        + "    messageCategory: " + toIndentedString(messageCategory) + "\n"
        + "    authenticationPurpose: " + toIndentedString(authenticationPurpose) + "\n"
        + "    transactionIntent: " + toIndentedString(transactionIntent) + "\n"
        + "    process: " + toIndentedString(process) + "\n"
        + "    deviceFingerprintingId: " + toIndentedString(deviceFingerprintingId) + "\n"
        + "    maxAuthorizationsForInstalmentPayment: " + toIndentedString(maxAuthorizationsForInstalmentPayment) + "\n"
        + "    suspiciousAccountActivity: " + toIndentedString(suspiciousAccountActivity) + "\n"
        + "    totalPurchasesSixMonthCount: " + toIndentedString(totalPurchasesSixMonthCount) + "\n"
        + "    transactionCountForPreviousDay: " + toIndentedString(transactionCountForPreviousDay) + "\n"
        + "    transactionCountForPreviousYear: " + toIndentedString(transactionCountForPreviousYear) + "\n"
        + "    txnTime: " + toIndentedString(txnTime) + "\n"
        + "    initialPurchaseTime: " + toIndentedString(initialPurchaseTime) + "\n"
        + "    billingCycle: " + toIndentedString(billingCycle) + "\n"
        + "    browserDetails: " + toIndentedString(browserDetails) + "\n"
        + "    orderItemDetails: " + toIndentedString(orderItemDetails) + "\n"
        + "    purchasedGiftCardDetails: " + toIndentedString(purchasedGiftCardDetails) + "\n"
        + "    userAccountDetails: " + toIndentedString(userAccountDetails) + "\n"
        + "    shippingDetailsUsage: " + toIndentedString(shippingDetailsUsage) + "\n"
        + "    travelDetails: " + toIndentedString(travelDetails) + "\n"
        + "    userLogin: " + toIndentedString(userLogin) + "\n"
        + "    electronicDelivery: " + toIndentedString(electronicDelivery) + "\n"
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
   * 3D Secure authentication details. You need to send this object when you want to process CARD transaction with 3DS. Required if account is enabled for 3DS. builder static inner class.
   */
  public static final class Builder {
    private String id;
    private String merchantUrl;
    private ThreeDsDeviceChannel deviceChannel;
    private ThreeDsRequestorChallengePreference requestorChallengePreference;
    private ThreeDsMessageCategory messageCategory;
    private ThreeDsAuthenticationPurpose authenticationPurpose;
    private ThreeDsTransactionIntent transactionIntent;
    private Boolean process;
    private String deviceFingerprintingId;
    private Integer maxAuthorizationsForInstalmentPayment;
    private Boolean suspiciousAccountActivity;
    private Integer totalPurchasesSixMonthCount;
    private Integer transactionCountForPreviousDay;
    private Integer transactionCountForPreviousYear;
    private String txnTime;
    private String initialPurchaseTime;
    private BillingCycle billingCycle;
    private BrowserDetails browserDetails;
    private OrderItemDetails orderItemDetails;
    private PurchasedGiftCardDetails purchasedGiftCardDetails;
    private UserAccountDetails userAccountDetails;
    private ShippingDetailsUsage shippingDetailsUsage;
    private TravelDetails travelDetails;
    private UserLogin userLogin;
    private ElectronicDelivery electronicDelivery;

    private Builder() {
    }

    /**
     * The unique ID returned in the response
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
     * Fully qualified URL of the merchant's commercial or customer care website
     * <p>
     * Sets the merchantUrl and returns a reference to this Builder enabling method chaining.
     *
     * @param merchantUrl the merchantUrl to set
     * @return a reference to this Builder
     */
    public Builder merchantUrl(String merchantUrl) {
      this.merchantUrl = merchantUrl;
      return this;
    }

    /**
     * Sets the deviceChannel and returns a reference to this Builder enabling method chaining.
     *
     * @param deviceChannel the deviceChannel to set
     * @return a reference to this Builder
     */
    public Builder deviceChannel(ThreeDsDeviceChannel deviceChannel) {
      this.deviceChannel = deviceChannel;
      return this;
    }

    /**
     * Sets the requestorChallengePreference and returns a reference to this Builder enabling method chaining.
     *
     * @param requestorChallengePreference the requestorChallengePreference to set
     * @return a reference to this Builder
     */
    public Builder requestorChallengePreference(ThreeDsRequestorChallengePreference requestorChallengePreference) {
      this.requestorChallengePreference = requestorChallengePreference;
      return this;
    }

    /**
     * Sets the messageCategory and returns a reference to this Builder enabling method chaining.
     *
     * @param messageCategory the messageCategory to set
     * @return a reference to this Builder
     */
    public Builder messageCategory(ThreeDsMessageCategory messageCategory) {
      this.messageCategory = messageCategory;
      return this;
    }

    /**
     * Sets the authenticationPurpose and returns a reference to this Builder enabling method chaining.
     *
     * @param authenticationPurpose the authenticationPurpose to set
     * @return a reference to this Builder
     */
    public Builder authenticationPurpose(ThreeDsAuthenticationPurpose authenticationPurpose) {
      this.authenticationPurpose = authenticationPurpose;
      return this;
    }

    /**
     * Sets the transactionIntent and returns a reference to this Builder enabling method chaining.
     *
     * @param transactionIntent the transactionIntent to set
     * @return a reference to this Builder
     */
    public Builder transactionIntent(ThreeDsTransactionIntent transactionIntent) {
      this.transactionIntent = transactionIntent;
      return this;
    }

    /**
     * Indicator representing whether to call authenticate endpoint or not
     * <p>
     * Sets the process and returns a reference to this Builder enabling method chaining.
     *
     * @param process the process to set
     * @return a reference to this Builder
     */
    public Builder process(Boolean process) {
      this.process = process;
      return this;
    }

    /**
     * UUID used with device fingerprinting
     * <p>
     * Sets the deviceFingerprintingId and returns a reference to this Builder enabling method chaining.
     *
     * @param deviceFingerprintingId the deviceFingerprintingId to set
     * @return a reference to this Builder
     */
    public Builder deviceFingerprintingId(String deviceFingerprintingId) {
      this.deviceFingerprintingId = deviceFingerprintingId;
      return this;
    }

    /**
     * Maximum number of authorizations for instalment payment
     * <p>
     * Sets the maxAuthorizationsForInstalmentPayment and returns a reference to this Builder enabling method chaining.
     *
     * @param maxAuthorizationsForInstalmentPayment the maxAuthorizationsForInstalmentPayment to set
     * @return a reference to this Builder
     */
    public Builder maxAuthorizationsForInstalmentPayment(Integer maxAuthorizationsForInstalmentPayment) {
      this.maxAuthorizationsForInstalmentPayment = maxAuthorizationsForInstalmentPayment;
      return this;
    }

    /**
     * Indicates whether the 3DS Requestor has experienced suspicious activity on the cardholder account
     * <p>
     * Sets the suspiciousAccountActivity and returns a reference to this Builder enabling method chaining.
     *
     * @param suspiciousAccountActivity the suspiciousAccountActivity to set
     * @return a reference to this Builder
     */
    public Builder suspiciousAccountActivity(Boolean suspiciousAccountActivity) {
      this.suspiciousAccountActivity = suspiciousAccountActivity;
      return this;
    }

    /**
     * Transaction count for last 6 months
     * <p>
     * Sets the totalPurchasesSixMonthCount and returns a reference to this Builder enabling method chaining.
     *
     * @param totalPurchasesSixMonthCount the totalPurchasesSixMonthCount to set
     * @return a reference to this Builder
     */
    public Builder totalPurchasesSixMonthCount(Integer totalPurchasesSixMonthCount) {
      this.totalPurchasesSixMonthCount = totalPurchasesSixMonthCount;
      return this;
    }

    /**
     * Number of transactions in the previous day
     * <p>
     * Sets the transactionCountForPreviousDay and returns a reference to this Builder enabling method chaining.
     *
     * @param transactionCountForPreviousDay the transactionCountForPreviousDay to set
     * @return a reference to this Builder
     */
    public Builder transactionCountForPreviousDay(Integer transactionCountForPreviousDay) {
      this.transactionCountForPreviousDay = transactionCountForPreviousDay;
      return this;
    }

    /**
     * Number of transactions in the previous year
     * <p>
     * Sets the transactionCountForPreviousYear and returns a reference to this Builder enabling method chaining.
     *
     * @param transactionCountForPreviousYear the transactionCountForPreviousYear to set
     * @return a reference to this Builder
     */
    public Builder transactionCountForPreviousYear(Integer transactionCountForPreviousYear) {
      this.transactionCountForPreviousYear = transactionCountForPreviousYear;
      return this;
    }

    /**
     * Date and time of the transaction
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
     * Date and time of the initial purchase. <b>Note:</b> This element is required only if messageCategory=NON_PAYMENT and authenticationPurpose=INSTALMENT_TRANSACTION or RECURRING_TRANSACTION
     * <p>
     * Sets the initialPurchaseTime and returns a reference to this Builder enabling method chaining.
     *
     * @param initialPurchaseTime the initialPurchaseTime to set
     * @return a reference to this Builder
     */
    public Builder initialPurchaseTime(String initialPurchaseTime) {
      this.initialPurchaseTime = initialPurchaseTime;
      return this;
    }

    /**
     * Sets the billingCycle and returns a reference to this Builder enabling method chaining.
     *
     * @param billingCycle the billingCycle to set
     * @return a reference to this Builder
     */
    public Builder billingCycle(BillingCycle billingCycle) {
      this.billingCycle = billingCycle;
      return this;
    }

    /**
     * Sets the browserDetails and returns a reference to this Builder enabling method chaining.
     *
     * @param browserDetails the browserDetails to set
     * @return a reference to this Builder
     */
    public Builder browserDetails(BrowserDetails browserDetails) {
      this.browserDetails = browserDetails;
      return this;
    }

    /**
     * Sets the orderItemDetails and returns a reference to this Builder enabling method chaining.
     *
     * @param orderItemDetails the orderItemDetails to set
     * @return a reference to this Builder
     */
    public Builder orderItemDetails(OrderItemDetails orderItemDetails) {
      this.orderItemDetails = orderItemDetails;
      return this;
    }

    /**
     * Sets the purchasedGiftCardDetails and returns a reference to this Builder enabling method chaining.
     *
     * @param purchasedGiftCardDetails the purchasedGiftCardDetails to set
     * @return a reference to this Builder
     */
    public Builder purchasedGiftCardDetails(PurchasedGiftCardDetails purchasedGiftCardDetails) {
      this.purchasedGiftCardDetails = purchasedGiftCardDetails;
      return this;
    }

    /**
     * Sets the userAccountDetails and returns a reference to this Builder enabling method chaining.
     *
     * @param userAccountDetails the userAccountDetails to set
     * @return a reference to this Builder
     */
    public Builder userAccountDetails(UserAccountDetails userAccountDetails) {
      this.userAccountDetails = userAccountDetails;
      return this;
    }

    /**
     * Sets the shippingDetailsUsage and returns a reference to this Builder enabling method chaining.
     *
     * @param shippingDetailsUsage the shippingDetailsUsage to set
     * @return a reference to this Builder
     */
    public Builder shippingDetailsUsage(ShippingDetailsUsage shippingDetailsUsage) {
      this.shippingDetailsUsage = shippingDetailsUsage;
      return this;
    }

    /**
     * Sets the travelDetails and returns a reference to this Builder enabling method chaining.
     *
     * @param travelDetails the travelDetails to set
     * @return a reference to this Builder
     */
    public Builder travelDetails(TravelDetails travelDetails) {
      this.travelDetails = travelDetails;
      return this;
    }

    /**
     * Sets the userLogin and returns a reference to this Builder enabling method chaining.
     *
     * @param userLogin the userLogin to set
     * @return a reference to this Builder
     */
    public Builder userLogin(UserLogin userLogin) {
      this.userLogin = userLogin;
      return this;
    }

    /**
     * Sets the electronicDelivery and returns a reference to this Builder enabling method chaining.
     *
     * @param electronicDelivery the electronicDelivery to set
     * @return a reference to this Builder
     */
    public Builder electronicDelivery(ElectronicDelivery electronicDelivery) {
      this.electronicDelivery = electronicDelivery;
      return this;
    }

    /**
     * Returns a ThreeDs built from the parameters previously set.
     *
     * @return a ThreeDs built with parameters of this ThreeDs.Builder
     */
    public ThreeDs build() {
      return new ThreeDs(this);
    }
  }
}
