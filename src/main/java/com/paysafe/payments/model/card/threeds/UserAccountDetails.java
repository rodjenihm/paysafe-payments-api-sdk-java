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
import com.paysafe.payments.model.card.enums.AccountChangedRange;
import com.paysafe.payments.model.card.enums.AccountCreatedRange;
import com.paysafe.payments.model.card.enums.PasswordChangedRange;



/**
 * User account details from the merchant website for 3DS authentication
 */
public class UserAccountDetails {

  @JsonProperty("addCardAttemptsForLastDay")
  private Integer addCardAttemptsForLastDay;
  @JsonProperty("changedDate")
  private String changedDate;
  @JsonProperty("changedRange")
  private AccountChangedRange changedRange;
  @JsonProperty("createdDate")
  private String createdDate;
  @JsonProperty("createdRange")
  private AccountCreatedRange createdRange;
  @JsonProperty("passwordChangedDate")
  private String passwordChangedDate;
  @JsonProperty("passwordChangedRange")
  private PasswordChangedRange passwordChangedRange;
  @JsonProperty("suspiciousAccountActivity")
  private Boolean suspiciousAccountActivity;
  @JsonProperty("totalPurchasesSixMonthCount")
  private Integer totalPurchasesSixMonthCount;
  @JsonProperty("transactionCountForPreviousDay")
  private Integer transactionCountForPreviousDay;
  @JsonProperty("transactionCountForPreviousYear")
  private Integer transactionCountForPreviousYear;
  @JsonProperty("shippingDetailsUsage")
  private ShippingDetailsUsage shippingDetailsUsage;
  @JsonProperty("userLogin")
  private UserLogin userLogin;
  @JsonProperty("paymentAccountDetails")
  private PaymentAccountDetails paymentAccountDetails;
  @JsonProperty("priorThreeDSAuthentication")
  private PriorThreedsAuthentication priorThreeDSAuthentication;
  @JsonProperty("travelDetails")
  private TravelDetails travelDetails;

  public UserAccountDetails() {
    super();
  }

  private UserAccountDetails(final Builder builder) {
    setAddCardAttemptsForLastDay(builder.addCardAttemptsForLastDay);
    setChangedDate(builder.changedDate);
    setChangedRange(builder.changedRange);
    setCreatedDate(builder.createdDate);
    setCreatedRange(builder.createdRange);
    setPasswordChangedDate(builder.passwordChangedDate);
    setPasswordChangedRange(builder.passwordChangedRange);
    setSuspiciousAccountActivity(builder.suspiciousAccountActivity);
    setTotalPurchasesSixMonthCount(builder.totalPurchasesSixMonthCount);
    setTransactionCountForPreviousDay(builder.transactionCountForPreviousDay);
    setTransactionCountForPreviousYear(builder.transactionCountForPreviousYear);
    setShippingDetailsUsage(builder.shippingDetailsUsage);
    setUserLogin(builder.userLogin);
    setPaymentAccountDetails(builder.paymentAccountDetails);
    setPriorThreeDSAuthentication(builder.priorThreeDSAuthentication);
    setTravelDetails(builder.travelDetails);
  }

  public static Builder builder() {
    return new Builder();
  }


  public UserAccountDetails addCardAttemptsForLastDay(Integer addCardAttemptsForLastDay) {
    this.addCardAttemptsForLastDay = addCardAttemptsForLastDay;
    return this;
  }

  /**
   * Number of attempts to add a card in the last 24 hours
   *
   * @return addCardAttemptsForLastDay
   */
  public Integer getAddCardAttemptsForLastDay() {
    return addCardAttemptsForLastDay;
  }

  public void setAddCardAttemptsForLastDay(Integer addCardAttemptsForLastDay) {
    this.addCardAttemptsForLastDay = addCardAttemptsForLastDay;
  }


  public UserAccountDetails changedDate(String changedDate) {
    this.changedDate = changedDate;
    return this;
  }

  /**
   * This is the date that the cardholder’s account with the 3DS Requestor was last changed. The ISO 8601 date format is expected, i.e., YYYY-MM-DD.
   *
   * @return changedDate
   */
  public String getChangedDate() {
    return changedDate;
  }

  public void setChangedDate(String changedDate) {
    this.changedDate = changedDate;
  }


  public UserAccountDetails changedRange(AccountChangedRange changedRange) {
    this.changedRange = changedRange;
    return this;
  }

  /**
   * Get changedRange
   *
   * @return changedRange
   */
  public AccountChangedRange getChangedRange() {
    return changedRange;
  }

  public void setChangedRange(AccountChangedRange changedRange) {
    this.changedRange = changedRange;
  }


  public UserAccountDetails createdDate(String createdDate) {
    this.createdDate = createdDate;
    return this;
  }

  /**
   * This is the date when the cardholder opened the account with the 3DS Requestor. The ISO 8601 date format is expected, i.e., YYYY-MM-DD
   *
   * @return createdDate
   */
  public String getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(String createdDate) {
    this.createdDate = createdDate;
  }


  public UserAccountDetails createdRange(AccountCreatedRange createdRange) {
    this.createdRange = createdRange;
    return this;
  }

  /**
   * Get createdRange
   *
   * @return createdRange
   */
  public AccountCreatedRange getCreatedRange() {
    return createdRange;
  }

  public void setCreatedRange(AccountCreatedRange createdRange) {
    this.createdRange = createdRange;
  }


  public UserAccountDetails passwordChangedDate(String passwordChangedDate) {
    this.passwordChangedDate = passwordChangedDate;
    return this;
  }

  /**
   * This is the date when the cardholder’s account was reset or the password was changed. The ISO 8601 date format is expected, i.e., YYYY-MM-DD.
   *
   * @return passwordChangedDate
   */
  public String getPasswordChangedDate() {
    return passwordChangedDate;
  }

  public void setPasswordChangedDate(String passwordChangedDate) {
    this.passwordChangedDate = passwordChangedDate;
  }


  public UserAccountDetails passwordChangedRange(PasswordChangedRange passwordChangedRange) {
    this.passwordChangedRange = passwordChangedRange;
    return this;
  }

  /**
   * Get passwordChangedRange
   *
   * @return passwordChangedRange
   */
  public PasswordChangedRange getPasswordChangedRange() {
    return passwordChangedRange;
  }

  public void setPasswordChangedRange(PasswordChangedRange passwordChangedRange) {
    this.passwordChangedRange = passwordChangedRange;
  }


  public UserAccountDetails suspiciousAccountActivity(Boolean suspiciousAccountActivity) {
    this.suspiciousAccountActivity = suspiciousAccountActivity;
    return this;
  }

  /**
   * Whether the 3DS Requestor has experienced suspicious activity on the cardholder account
   *
   * @return suspiciousAccountActivity
   */
  public Boolean getSuspiciousAccountActivity() {
    return suspiciousAccountActivity;
  }

  public void setSuspiciousAccountActivity(Boolean suspiciousAccountActivity) {
    this.suspiciousAccountActivity = suspiciousAccountActivity;
  }


  public UserAccountDetails totalPurchasesSixMonthCount(Integer totalPurchasesSixMonthCount) {
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


  public UserAccountDetails transactionCountForPreviousDay(Integer transactionCountForPreviousDay) {
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


  public UserAccountDetails transactionCountForPreviousYear(Integer transactionCountForPreviousYear) {
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


  public UserAccountDetails shippingDetailsUsage(ShippingDetailsUsage shippingDetailsUsage) {
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


  public UserAccountDetails userLogin(UserLogin userLogin) {
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


  public UserAccountDetails paymentAccountDetails(PaymentAccountDetails paymentAccountDetails) {
    this.paymentAccountDetails = paymentAccountDetails;
    return this;
  }

  /**
   * Get paymentAccountDetails
   *
   * @return paymentAccountDetails
   */
  public PaymentAccountDetails getPaymentAccountDetails() {
    return paymentAccountDetails;
  }

  public void setPaymentAccountDetails(PaymentAccountDetails paymentAccountDetails) {
    this.paymentAccountDetails = paymentAccountDetails;
  }


  public UserAccountDetails priorThreeDSAuthentication(PriorThreedsAuthentication priorThreeDSAuthentication) {
    this.priorThreeDSAuthentication = priorThreeDSAuthentication;
    return this;
  }

  /**
   * Get priorThreeDSAuthentication
   *
   * @return priorThreeDSAuthentication
   */
  public PriorThreedsAuthentication getPriorThreeDSAuthentication() {
    return priorThreeDSAuthentication;
  }

  public void setPriorThreeDSAuthentication(PriorThreedsAuthentication priorThreeDSAuthentication) {
    this.priorThreeDSAuthentication = priorThreeDSAuthentication;
  }


  public UserAccountDetails travelDetails(TravelDetails travelDetails) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserAccountDetails userAccountDetails = (UserAccountDetails) o;
    return Objects.equals(this.addCardAttemptsForLastDay, userAccountDetails.addCardAttemptsForLastDay) &&
        Objects.equals(this.changedDate, userAccountDetails.changedDate) &&
        Objects.equals(this.changedRange, userAccountDetails.changedRange) &&
        Objects.equals(this.createdDate, userAccountDetails.createdDate) &&
        Objects.equals(this.createdRange, userAccountDetails.createdRange) &&
        Objects.equals(this.passwordChangedDate, userAccountDetails.passwordChangedDate) &&
        Objects.equals(this.passwordChangedRange, userAccountDetails.passwordChangedRange) &&
        Objects.equals(this.suspiciousAccountActivity, userAccountDetails.suspiciousAccountActivity) &&
        Objects.equals(this.totalPurchasesSixMonthCount, userAccountDetails.totalPurchasesSixMonthCount) &&
        Objects.equals(this.transactionCountForPreviousDay, userAccountDetails.transactionCountForPreviousDay) &&
        Objects.equals(this.transactionCountForPreviousYear, userAccountDetails.transactionCountForPreviousYear) &&
        Objects.equals(this.shippingDetailsUsage, userAccountDetails.shippingDetailsUsage) &&
        Objects.equals(this.userLogin, userAccountDetails.userLogin) &&
        Objects.equals(this.paymentAccountDetails, userAccountDetails.paymentAccountDetails) &&
        Objects.equals(this.priorThreeDSAuthentication, userAccountDetails.priorThreeDSAuthentication) &&
        Objects.equals(this.travelDetails, userAccountDetails.travelDetails);
  }

  @Override
  public int hashCode() {
    return Objects.hash(addCardAttemptsForLastDay, changedDate, changedRange, createdDate, createdRange, passwordChangedDate, passwordChangedRange, suspiciousAccountActivity, totalPurchasesSixMonthCount, transactionCountForPreviousDay, transactionCountForPreviousYear, shippingDetailsUsage, userLogin, paymentAccountDetails, priorThreeDSAuthentication, travelDetails);
  }

  @Override
  public String toString() {

    return "class UserAccountDetails {\n"
        + "    addCardAttemptsForLastDay: " + toIndentedString(addCardAttemptsForLastDay) + "\n"
        + "    changedDate: " + toIndentedString(changedDate) + "\n"
        + "    changedRange: " + toIndentedString(changedRange) + "\n"
        + "    createdDate: " + toIndentedString(createdDate) + "\n"
        + "    createdRange: " + toIndentedString(createdRange) + "\n"
        + "    passwordChangedDate: " + toIndentedString(passwordChangedDate) + "\n"
        + "    passwordChangedRange: " + toIndentedString(passwordChangedRange) + "\n"
        + "    suspiciousAccountActivity: " + toIndentedString(suspiciousAccountActivity) + "\n"
        + "    totalPurchasesSixMonthCount: " + toIndentedString(totalPurchasesSixMonthCount) + "\n"
        + "    transactionCountForPreviousDay: " + toIndentedString(transactionCountForPreviousDay) + "\n"
        + "    transactionCountForPreviousYear: " + toIndentedString(transactionCountForPreviousYear) + "\n"
        + "    shippingDetailsUsage: " + toIndentedString(shippingDetailsUsage) + "\n"
        + "    userLogin: " + toIndentedString(userLogin) + "\n"
        + "    paymentAccountDetails: " + toIndentedString(paymentAccountDetails) + "\n"
        + "    priorThreeDSAuthentication: " + toIndentedString(priorThreeDSAuthentication) + "\n"
        + "    travelDetails: " + toIndentedString(travelDetails) + "\n"
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
   * User account details from the merchant website for 3DS authentication builder static inner class.
   */
  public static final class Builder {
    private Integer addCardAttemptsForLastDay;
    private String changedDate;
    private AccountChangedRange changedRange;
    private String createdDate;
    private AccountCreatedRange createdRange;
    private String passwordChangedDate;
    private PasswordChangedRange passwordChangedRange;
    private Boolean suspiciousAccountActivity;
    private Integer totalPurchasesSixMonthCount;
    private Integer transactionCountForPreviousDay;
    private Integer transactionCountForPreviousYear;
    private ShippingDetailsUsage shippingDetailsUsage;
    private UserLogin userLogin;
    private PaymentAccountDetails paymentAccountDetails;
    private PriorThreedsAuthentication priorThreeDSAuthentication;
    private TravelDetails travelDetails;

    private Builder() {
    }

    /**
     * Number of attempts to add a card in the last 24 hours
     * <p>
     * Sets the addCardAttemptsForLastDay and returns a reference to this Builder enabling method chaining.
     *
     * @param addCardAttemptsForLastDay the addCardAttemptsForLastDay to set
     * @return a reference to this Builder
     */
    public Builder addCardAttemptsForLastDay(Integer addCardAttemptsForLastDay) {
      this.addCardAttemptsForLastDay = addCardAttemptsForLastDay;
      return this;
    }

    /**
     * This is the date that the cardholder’s account with the 3DS Requestor was last changed. The ISO 8601 date format is expected, i.e., YYYY-MM-DD.
     * <p>
     * Sets the changedDate and returns a reference to this Builder enabling method chaining.
     *
     * @param changedDate the changedDate to set
     * @return a reference to this Builder
     */
    public Builder changedDate(String changedDate) {
      this.changedDate = changedDate;
      return this;
    }

    /**
     * Sets the changedRange and returns a reference to this Builder enabling method chaining.
     *
     * @param changedRange the changedRange to set
     * @return a reference to this Builder
     */
    public Builder changedRange(AccountChangedRange changedRange) {
      this.changedRange = changedRange;
      return this;
    }

    /**
     * This is the date when the cardholder opened the account with the 3DS Requestor. The ISO 8601 date format is expected, i.e., YYYY-MM-DD
     * <p>
     * Sets the createdDate and returns a reference to this Builder enabling method chaining.
     *
     * @param createdDate the createdDate to set
     * @return a reference to this Builder
     */
    public Builder createdDate(String createdDate) {
      this.createdDate = createdDate;
      return this;
    }

    /**
     * Sets the createdRange and returns a reference to this Builder enabling method chaining.
     *
     * @param createdRange the createdRange to set
     * @return a reference to this Builder
     */
    public Builder createdRange(AccountCreatedRange createdRange) {
      this.createdRange = createdRange;
      return this;
    }

    /**
     * This is the date when the cardholder’s account was reset or the password was changed. The ISO 8601 date format is expected, i.e., YYYY-MM-DD.
     * <p>
     * Sets the passwordChangedDate and returns a reference to this Builder enabling method chaining.
     *
     * @param passwordChangedDate the passwordChangedDate to set
     * @return a reference to this Builder
     */
    public Builder passwordChangedDate(String passwordChangedDate) {
      this.passwordChangedDate = passwordChangedDate;
      return this;
    }

    /**
     * Sets the passwordChangedRange and returns a reference to this Builder enabling method chaining.
     *
     * @param passwordChangedRange the passwordChangedRange to set
     * @return a reference to this Builder
     */
    public Builder passwordChangedRange(PasswordChangedRange passwordChangedRange) {
      this.passwordChangedRange = passwordChangedRange;
      return this;
    }

    /**
     * Whether the 3DS Requestor has experienced suspicious activity on the cardholder account
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
     * Sets the paymentAccountDetails and returns a reference to this Builder enabling method chaining.
     *
     * @param paymentAccountDetails the paymentAccountDetails to set
     * @return a reference to this Builder
     */
    public Builder paymentAccountDetails(PaymentAccountDetails paymentAccountDetails) {
      this.paymentAccountDetails = paymentAccountDetails;
      return this;
    }

    /**
     * Sets the priorThreeDSAuthentication and returns a reference to this Builder enabling method chaining.
     *
     * @param priorThreeDSAuthentication the priorThreeDSAuthentication to set
     * @return a reference to this Builder
     */
    public Builder priorThreeDSAuthentication(PriorThreedsAuthentication priorThreeDSAuthentication) {
      this.priorThreeDSAuthentication = priorThreeDSAuthentication;
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
     * Returns a UserAccountDetails built from the parameters previously set.
     *
     * @return a UserAccountDetails built with parameters of this UserAccountDetails.Builder
     */
    public UserAccountDetails build() {
      return new UserAccountDetails(this);
    }
  }
}
