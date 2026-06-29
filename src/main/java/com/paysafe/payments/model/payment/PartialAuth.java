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



/**
 * [Partial Authorization](https://developer.paysafe.com/en/payments-api/#/schemas/partialAuth) service is a feature where a card issuer approves only a part of the amount requested by the merchant during a transaction. Instead of declining a transaction outright due to insufficient funds for example, the card issuer authorizes a lesser amount than what the merchant requested. This is an optional field and is only applicable for CARD transactions.
 */
public class PartialAuth {

  @JsonProperty("allowPartialAuth")
  private Boolean allowPartialAuth;
  @JsonProperty("groupId")
  private String groupId;
  @JsonProperty("requestedAmount")
  private Integer requestedAmount;
  @JsonProperty("processedAsPartialAuth")
  private Boolean processedAsPartialAuth;

  public PartialAuth() {
    super();
  }

  private PartialAuth(final Builder builder) {
    setAllowPartialAuth(builder.allowPartialAuth);
    setGroupId(builder.groupId);
    setRequestedAmount(builder.requestedAmount);
    setProcessedAsPartialAuth(builder.processedAsPartialAuth);
  }

  public static Builder builder() {
    return new Builder();
  }


  public PartialAuth allowPartialAuth(Boolean allowPartialAuth) {
    this.allowPartialAuth = allowPartialAuth;
    return this;
  }

  /**
   * This indicates whether the merchant requests the transaction to be processed as Partial Authorization.
   *
   * @return allowPartialAuth
   */
  public Boolean getAllowPartialAuth() {
    return allowPartialAuth;
  }

  public void setAllowPartialAuth(Boolean allowPartialAuth) {
    this.allowPartialAuth = allowPartialAuth;
  }


  public PartialAuth groupId(String groupId) {
    this.groupId = groupId;
    return this;
  }

  /**
   * This is the id of the Partial Authorization group identifying a single sale, which is returned in the initial Partial Auth response. The ID should be provided by the merchants in subsequent Partial Auth requests, in order to associate it to the Initial partially authorized transaction.
   *
   * @return groupId
   */
  public String getGroupId() {
    return groupId;
  }

  public void setGroupId(String groupId) {
    this.groupId = groupId;
  }


  public PartialAuth requestedAmount(Integer requestedAmount) {
    this.requestedAmount = requestedAmount;
    return this;
  }

  /**
   * 'This is the amount of the request, in minor units. This value will contain the requested amount by the merchant. **Note:** Its value may differ from the amount value inside the payment object - in the case issuer partially authorized the required amount.'
   *
   * @return requestedAmount
   */
  public Integer getRequestedAmount() {
    return requestedAmount;
  }

  public void setRequestedAmount(Integer requestedAmount) {
    this.requestedAmount = requestedAmount;
  }


  public PartialAuth processedAsPartialAuth(Boolean processedAsPartialAuth) {
    this.processedAsPartialAuth = processedAsPartialAuth;
    return this;
  }

  /**
   * 'This indicates whether the transaction was actually processed by the issuer as Partial Authorization. - true - The transaction was processed as Partial Authorization. - false - The transaction was not processed as Partial Authorization even though it was requested by the merchant as such.'
   *
   * @return processedAsPartialAuth
   */
  public Boolean getProcessedAsPartialAuth() {
    return processedAsPartialAuth;
  }

  public void setProcessedAsPartialAuth(Boolean processedAsPartialAuth) {
    this.processedAsPartialAuth = processedAsPartialAuth;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PartialAuth partialAuth = (PartialAuth) o;
    return Objects.equals(this.allowPartialAuth, partialAuth.allowPartialAuth) &&
        Objects.equals(this.groupId, partialAuth.groupId) &&
        Objects.equals(this.requestedAmount, partialAuth.requestedAmount) &&
        Objects.equals(this.processedAsPartialAuth, partialAuth.processedAsPartialAuth);
  }

  @Override
  public int hashCode() {
    return Objects.hash(allowPartialAuth, groupId, requestedAmount, processedAsPartialAuth);
  }

  @Override
  public String toString() {

    return "class PartialAuth {\n"
        + "    allowPartialAuth: " + toIndentedString(allowPartialAuth) + "\n"
        + "    groupId: " + toIndentedString(groupId) + "\n"
        + "    requestedAmount: " + toIndentedString(requestedAmount) + "\n"
        + "    processedAsPartialAuth: " + toIndentedString(processedAsPartialAuth) + "\n"
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
   * [Partial Authorization](https://developer.paysafe.com/en/payments-api/#/schemas/partialAuth) service is a feature where a card issuer approves only a part of the amount requested by the merchant during a transaction. Instead of declining a transaction outright due to insufficient funds for example, the card issuer authorizes a lesser amount than what the merchant requested. This is an optional field and is only applicable for CARD transactions. builder static inner class.
   */
  public static final class Builder {
    private Boolean allowPartialAuth;
    private String groupId;
    private Integer requestedAmount;
    private Boolean processedAsPartialAuth;

    private Builder() {
    }

    /**
     * This indicates whether the merchant requests the transaction to be processed as Partial Authorization.
     * <p>
     * Sets the allowPartialAuth and returns a reference to this Builder enabling method chaining.
     *
     * @param allowPartialAuth the allowPartialAuth to set
     * @return a reference to this Builder
     */
    public Builder allowPartialAuth(Boolean allowPartialAuth) {
      this.allowPartialAuth = allowPartialAuth;
      return this;
    }

    /**
     * This is the id of the Partial Authorization group identifying a single sale, which is returned in the initial Partial Auth response. The ID should be provided by the merchants in subsequent Partial Auth requests, in order to associate it to the Initial partially authorized transaction.
     * <p>
     * Sets the groupId and returns a reference to this Builder enabling method chaining.
     *
     * @param groupId the groupId to set
     * @return a reference to this Builder
     */
    public Builder groupId(String groupId) {
      this.groupId = groupId;
      return this;
    }

    /**
     * 'This is the amount of the request, in minor units. This value will contain the requested amount by the merchant. **Note:** Its value may differ from the amount value inside the payment object - in the case issuer partially authorized the required amount.'
     * <p>
     * Sets the requestedAmount and returns a reference to this Builder enabling method chaining.
     *
     * @param requestedAmount the requestedAmount to set
     * @return a reference to this Builder
     */
    public Builder requestedAmount(Integer requestedAmount) {
      this.requestedAmount = requestedAmount;
      return this;
    }

    /**
     * 'This indicates whether the transaction was actually processed by the issuer as Partial Authorization. - true - The transaction was processed as Partial Authorization. - false - The transaction was not processed as Partial Authorization even though it was requested by the merchant as such.'
     * <p>
     * Sets the processedAsPartialAuth and returns a reference to this Builder enabling method chaining.
     *
     * @param processedAsPartialAuth the processedAsPartialAuth to set
     * @return a reference to this Builder
     */
    public Builder processedAsPartialAuth(Boolean processedAsPartialAuth) {
      this.processedAsPartialAuth = processedAsPartialAuth;
      return this;
    }

    /**
     * Returns a PartialAuth built from the parameters previously set.
     *
     * @return a PartialAuth built with parameters of this PartialAuth.Builder
     */
    public PartialAuth build() {
      return new PartialAuth(this);
    }
  }
}
