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
import com.paysafe.payments.model.common.BillingDetails;
import com.paysafe.payments.model.common.Mandate;
import com.paysafe.payments.model.common.enums.CurrencyCode;
import com.paysafe.payments.model.lpm.Ach;
import com.paysafe.payments.model.lpm.Bacs;
import com.paysafe.payments.model.lpm.Eft;
import com.paysafe.payments.model.lpm.Sepa;
import com.paysafe.payments.model.payment.Payment;
import com.paysafe.payments.model.paymenthandle.enums.PaymentType;



/**
 * Payload required for creating Payment Handle for a customer.
 */
public class CustomerPaymentHandleRequest {

  @JsonProperty("merchantRefNum")
  private String merchantRefNum;
  @JsonProperty("customerIp")
  private String customerIp;
  @JsonProperty("billingDetails")
  private BillingDetails billingDetails;
  @JsonProperty("billingDetailsId")
  private String billingDetailsId;
  @JsonProperty("card")
  private UpdateCustomerRequestCard card;
  @JsonProperty("amount")
  private Integer amount;
  @JsonProperty("currencyCode")
  private CurrencyCode currencyCode;
  @JsonProperty("paymentHandleTokenFrom")
  private String paymentHandleTokenFrom;
  @JsonProperty("eft")
  private Eft eft;
  @JsonProperty("dupCheck")
  private Boolean dupCheck = true;
  @JsonProperty("ach")
  private Ach ach;
  @JsonProperty("bacs")
  private Bacs bacs;
  @JsonProperty("mandates")
  private List<Mandate> mandates;
  @JsonProperty("sepa")
  private Sepa sepa;
  @JsonProperty("paymentType")
  private PaymentType paymentType;
  private Map<String, Object> additionalParameters;

  public CustomerPaymentHandleRequest() {
    super();
  }

  private CustomerPaymentHandleRequest(final Builder builder) {
    setMerchantRefNum(builder.merchantRefNum);
    setCustomerIp(builder.customerIp);
    setBillingDetails(builder.billingDetails);
    setBillingDetailsId(builder.billingDetailsId);
    setCard(builder.card);
    setAmount(builder.amount);
    setCurrencyCode(builder.currencyCode);
    setPaymentHandleTokenFrom(builder.paymentHandleTokenFrom);
    setEft(builder.eft);
    setDupCheck(builder.dupCheck);
    setAch(builder.ach);
    setBacs(builder.bacs);
    setMandates(builder.mandates);
    setSepa(builder.sepa);
    setPaymentType(builder.paymentType);
    this.additionalParameters = builder.additionalParameters;
  }

  public static Builder builder() {
    return new Builder();
  }


  public CustomerPaymentHandleRequest merchantRefNum(String merchantRefNum) {
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


  public CustomerPaymentHandleRequest customerIp(String customerIp) {
    this.customerIp = customerIp;
    return this;
  }

  /**
   * This is the customer's IP address
   *
   * @return customerIp
   */
  public String getCustomerIp() {
    return customerIp;
  }

  public void setCustomerIp(String customerIp) {
    this.customerIp = customerIp;
  }


  public CustomerPaymentHandleRequest billingDetails(BillingDetails billingDetails) {
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


  public CustomerPaymentHandleRequest billingDetailsId(String billingDetailsId) {
    this.billingDetailsId = billingDetailsId;
    return this;
  }

  /**
   * This is the ID returned in the response to the address creation request.
   *
   * @return billingDetailsId
   */
  public String getBillingDetailsId() {
    return billingDetailsId;
  }

  public void setBillingDetailsId(String billingDetailsId) {
    this.billingDetailsId = billingDetailsId;
  }


  public CustomerPaymentHandleRequest card(UpdateCustomerRequestCard card) {
    this.card = card;
    return this;
  }

  /**
   * Get card
   *
   * @return card
   */
  public UpdateCustomerRequestCard getCard() {
    return card;
  }

  public void setCard(UpdateCustomerRequestCard card) {
    this.card = card;
  }


  public CustomerPaymentHandleRequest amount(Integer amount) {
    this.amount = amount;
    return this;
  }

  /**
   * This is the amount of the request, in minor units. For example, to process US $10.99, this value should be 1099. **Note:** The amount specified in the Payment request must match the amount specified in the Payment Handle request from which the paymentHandleToken is taken.
   *
   * @return amount
   */
  public Integer getAmount() {
    return amount;
  }

  public void setAmount(Integer amount) {
    this.amount = amount;
  }


  public CustomerPaymentHandleRequest currencyCode(CurrencyCode currencyCode) {
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


  public CustomerPaymentHandleRequest paymentHandleTokenFrom(String paymentHandleTokenFrom) {
    this.paymentHandleTokenFrom = paymentHandleTokenFrom;
    return this;
  }

  /**
   * This is an existing Customer Payment Handle, from which the payment instrument and profile details are retrieved. If this parameter is included you can omit the billingDetails object.
   *
   * @return paymentHandleTokenFrom
   */
  public String getPaymentHandleTokenFrom() {
    return paymentHandleTokenFrom;
  }

  public void setPaymentHandleTokenFrom(String paymentHandleTokenFrom) {
    this.paymentHandleTokenFrom = paymentHandleTokenFrom;
  }


  public CustomerPaymentHandleRequest eft(Eft eft) {
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


  public CustomerPaymentHandleRequest dupCheck(Boolean dupCheck) {
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


  public CustomerPaymentHandleRequest ach(Ach ach) {
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


  public CustomerPaymentHandleRequest bacs(Bacs bacs) {
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


  public CustomerPaymentHandleRequest mandates(List<Mandate> mandates) {
    this.mandates = mandates;
    return this;
  }

  public CustomerPaymentHandleRequest addMandatesItem(Mandate mandatesItem) {
    if (this.mandates == null) {
      this.mandates = new ArrayList<>();
    }
    this.mandates.add(mandatesItem);
    return this;
  }

  public CustomerPaymentHandleRequest removeMandatesItem(Mandate mandatesItem) {
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


  public CustomerPaymentHandleRequest sepa(Sepa sepa) {
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


  public CustomerPaymentHandleRequest paymentType(PaymentType paymentType) {
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
    CustomerPaymentHandleRequest customerPaymentHandleRequest = (CustomerPaymentHandleRequest) o;
    return Objects.equals(this.merchantRefNum, customerPaymentHandleRequest.merchantRefNum) &&
        Objects.equals(this.customerIp, customerPaymentHandleRequest.customerIp) &&
        Objects.equals(this.billingDetails, customerPaymentHandleRequest.billingDetails) &&
        Objects.equals(this.billingDetailsId, customerPaymentHandleRequest.billingDetailsId) &&
        Objects.equals(this.card, customerPaymentHandleRequest.card) &&
        Objects.equals(this.amount, customerPaymentHandleRequest.amount) &&
        Objects.equals(this.currencyCode, customerPaymentHandleRequest.currencyCode) &&
        Objects.equals(this.paymentHandleTokenFrom, customerPaymentHandleRequest.paymentHandleTokenFrom) &&
        Objects.equals(this.eft, customerPaymentHandleRequest.eft) &&
        Objects.equals(this.dupCheck, customerPaymentHandleRequest.dupCheck) &&
        Objects.equals(this.ach, customerPaymentHandleRequest.ach) &&
        Objects.equals(this.bacs, customerPaymentHandleRequest.bacs) &&
        Objects.equals(this.mandates, customerPaymentHandleRequest.mandates) &&
        Objects.equals(this.sepa, customerPaymentHandleRequest.sepa) &&
        Objects.equals(this.paymentType, customerPaymentHandleRequest.paymentType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(merchantRefNum, customerIp, billingDetails, billingDetailsId, card, amount, currencyCode, paymentHandleTokenFrom, eft, dupCheck, ach, bacs, mandates, sepa, paymentType);
  }

  @Override
  public String toString() {

    return "class CustomerPaymentHandleRequest {\n"
        + "    merchantRefNum: " + toIndentedString(merchantRefNum) + "\n"
        + "    customerIp: " + toIndentedString(customerIp) + "\n"
        + "    billingDetails: " + toIndentedString(billingDetails) + "\n"
        + "    billingDetailsId: " + toIndentedString(billingDetailsId) + "\n"
        + "    card: " + toIndentedString(card) + "\n"
        + "    amount: " + toIndentedString(amount) + "\n"
        + "    currencyCode: " + toIndentedString(currencyCode) + "\n"
        + "    paymentHandleTokenFrom: " + toIndentedString(paymentHandleTokenFrom) + "\n"
        + "    eft: " + toIndentedString(eft) + "\n"
        + "    dupCheck: " + toIndentedString(dupCheck) + "\n"
        + "    ach: " + toIndentedString(ach) + "\n"
        + "    bacs: " + toIndentedString(bacs) + "\n"
        + "    mandates: " + toIndentedString(mandates) + "\n"
        + "    sepa: " + toIndentedString(sepa) + "\n"
        + "    paymentType: " + toIndentedString(paymentType) + "\n"
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
   * Payload required for creating Payment Handle for a customer. builder static inner class.
   */
  public static final class Builder {
    private String merchantRefNum;
    private String customerIp;
    private BillingDetails billingDetails;
    private String billingDetailsId;
    private UpdateCustomerRequestCard card;
    private Integer amount;
    private CurrencyCode currencyCode;
    private String paymentHandleTokenFrom;
    private Eft eft;
    private Boolean dupCheck;
    private Ach ach;
    private Bacs bacs;
    private List<Mandate> mandates;
    private Sepa sepa;
    private PaymentType paymentType;
    private Map<String, Object> additionalParameters;

    private Builder() {
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
     * This is the customer's IP address
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
     * This is the ID returned in the response to the address creation request.
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
     * Sets the card and returns a reference to this Builder enabling method chaining.
     *
     * @param card the card to set
     * @return a reference to this Builder
     */
    public Builder card(UpdateCustomerRequestCard card) {
      this.card = card;
      return this;
    }

    /**
     * This is the amount of the request, in minor units. For example, to process US $10.99, this value should be 1099. **Note:** The amount specified in the Payment request must match the amount specified in the Payment Handle request from which the paymentHandleToken is taken.
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
     * This is an existing Customer Payment Handle, from which the payment instrument and profile details are retrieved. If this parameter is included you can omit the billingDetails object.
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
     * Returns a CustomerPaymentHandleRequest built from the parameters previously set.
     *
     * @return a CustomerPaymentHandleRequest built with parameters of this CustomerPaymentHandleRequest.Builder
     */
    public CustomerPaymentHandleRequest build() {
      return new CustomerPaymentHandleRequest(this);
    }
  }
}
