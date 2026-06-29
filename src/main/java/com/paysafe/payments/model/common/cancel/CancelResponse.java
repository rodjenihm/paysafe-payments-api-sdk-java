// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.model.common.cancel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.paysafe.payments.model.common.Mandate;
import com.paysafe.payments.model.common.enums.TransactionRequestStatus;
import com.paysafe.payments.model.payment.Payment;
import com.paysafe.payments.model.refund.Refund;
import com.paysafe.payments.model.settlement.Settlement;



/**
 * This class represents the response of the following operations: - Cancel Payment - Cancel Settlement - Cancel Refund - Cancel Standalone Credit - Cancel Original Credit - Cancel Mandate  Allowed value for status: CANCELLED
 */
public class CancelResponse {

  @JsonProperty("status")
  private TransactionRequestStatus status;
  @JsonProperty("id")
  private String id;
  @JsonProperty("txnTime")
  private String txnTime;

  public CancelResponse() {
    super();
  }

  private CancelResponse(final Builder builder) {
    setStatus(builder.status);
    setId(builder.id);
    setTxnTime(builder.txnTime);
  }

  public static Builder builder() {
    return new Builder();
  }


  public CancelResponse status(TransactionRequestStatus status) {
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


  public CancelResponse id(String id) {
    this.id = id;
    return this;
  }

  /**
   * This is the ID returned in the response. This ID can be used for future associated requests, for example, to look up the Payment.
   *
   * @return id
   */
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public CancelResponse txnTime(String txnTime) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CancelResponse cancelResponse = (CancelResponse) o;
    return Objects.equals(this.status, cancelResponse.status) &&
        Objects.equals(this.id, cancelResponse.id) &&
        Objects.equals(this.txnTime, cancelResponse.txnTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status, id, txnTime);
  }

  @Override
  public String toString() {

    return "class CancelResponse {\n"
        + "    status: " + toIndentedString(status) + "\n"
        + "    id: " + toIndentedString(id) + "\n"
        + "    txnTime: " + toIndentedString(txnTime) + "\n"
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
   * This class represents the response of the following operations: - Cancel Payment - Cancel Settlement - Cancel Refund - Cancel Standalone Credit - Cancel Original Credit - Cancel Mandate  Allowed value for status: CANCELLED builder static inner class.
   */
  public static final class Builder {
    private TransactionRequestStatus status;
    private String id;
    private String txnTime;

    private Builder() {
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
     * This is the ID returned in the response. This ID can be used for future associated requests, for example, to look up the Payment.
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
     * Returns a CancelResponse built from the parameters previously set.
     *
     * @return a CancelResponse built with parameters of this CancelResponse.Builder
     */
    public CancelResponse build() {
      return new CancelResponse(this);
    }
  }
}
