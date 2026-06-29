// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.model.voidauthorization;

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
import com.paysafe.payments.model.voidauthorization.enums.VoidAuthorizationStatus;



/**
 * Represents the details of a Void Authorization. A Void Authorization allows you to cancel an authorization request, provided the authorization has not yet been settled. If the authorization has already been settled, voiding is not allowed.
 */
public class VoidAuthorization extends BaseApiResponse {

  @JsonProperty("id")
  private String id;
  @JsonProperty("merchantRefNum")
  private String merchantRefNum;
  @JsonProperty("amount")
  private Integer amount;
  @JsonProperty("txnTime")
  private String txnTime;
  @JsonProperty("status")
  private VoidAuthorizationStatus status;

  public VoidAuthorization() {
    super();
  }

  private VoidAuthorization(final Builder builder) {
    setId(builder.id);
    setMerchantRefNum(builder.merchantRefNum);
    setAmount(builder.amount);
    setTxnTime(builder.txnTime);
    setStatus(builder.status);
  }

  public static Builder builder() {
    return new Builder();
  }


  public VoidAuthorization id(String id) {
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


  public VoidAuthorization merchantRefNum(String merchantRefNum) {
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


  public VoidAuthorization amount(Integer amount) {
    this.amount = amount;
    return this;
  }

  /**
   * This is the amount of the request, in minor units. For example, to process US $10.99, this value should be 1099. Maximum: 99999999999
   *
   * @return amount
   */
  public Integer getAmount() {
    return amount;
  }

  public void setAmount(Integer amount) {
    this.amount = amount;
  }


  public VoidAuthorization txnTime(String txnTime) {
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


  public VoidAuthorization status(VoidAuthorizationStatus status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   *
   * @return status
   */
  public VoidAuthorizationStatus getStatus() {
    return status;
  }

  public void setStatus(VoidAuthorizationStatus status) {
    this.status = status;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VoidAuthorization voidAuthorization = (VoidAuthorization) o;
    return Objects.equals(this.id, voidAuthorization.id) &&
        Objects.equals(this.merchantRefNum, voidAuthorization.merchantRefNum) &&
        Objects.equals(this.amount, voidAuthorization.amount) &&
        Objects.equals(this.txnTime, voidAuthorization.txnTime) &&
        Objects.equals(this.status, voidAuthorization.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, merchantRefNum, amount, txnTime, status);
  }

  @Override
  public String toString() {

    return "class VoidAuthorization {\n"
        + "    id: " + toIndentedString(id) + "\n"
        + "    merchantRefNum: " + toIndentedString(merchantRefNum) + "\n"
        + "    amount: " + toIndentedString(amount) + "\n"
        + "    txnTime: " + toIndentedString(txnTime) + "\n"
        + "    status: " + toIndentedString(status) + "\n"
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
   * Represents the details of a Void Authorization. A Void Authorization allows you to cancel an authorization request, provided the authorization has not yet been settled. If the authorization has already been settled, voiding is not allowed. builder static inner class.
   */
  public static final class Builder {
    private String id;
    private String merchantRefNum;
    private Integer amount;
    private String txnTime;
    private VoidAuthorizationStatus status;

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
     * This is the amount of the request, in minor units. For example, to process US $10.99, this value should be 1099. Maximum: 99999999999
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
     * Sets the status and returns a reference to this Builder enabling method chaining.
     *
     * @param status the status to set
     * @return a reference to this Builder
     */
    public Builder status(VoidAuthorizationStatus status) {
      this.status = status;
      return this;
    }

    /**
     * Returns a VoidAuthorization built from the parameters previously set.
     *
     * @return a VoidAuthorization built with parameters of this VoidAuthorization.Builder
     */
    public VoidAuthorization build() {
      return new VoidAuthorization(this);
    }
  }
}
