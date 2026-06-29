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
 * This class contains the internal details required for processing a cancel request. This object represents the request body for following operations: - Cancel Payment - Cancel Settlement - Cancel Refund - Cancel Standalone Credit - Cancel Original Credit - Cancel Mandate  Allowed value for status: CANCELLED
 */
public class CancelRequest {

  @JsonProperty("status")
  private TransactionRequestStatus status;

  public CancelRequest() {
    super();
  }

  private CancelRequest(final Builder builder) {
    setStatus(builder.status);
  }

  public static Builder builder() {
    return new Builder();
  }


  public CancelRequest status(TransactionRequestStatus status) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CancelRequest cancelRequest = (CancelRequest) o;
    return Objects.equals(this.status, cancelRequest.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status);
  }

  @Override
  public String toString() {

    return "class CancelRequest {\n"
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
   * This class contains the internal details required for processing a cancel request. This object represents the request body for following operations: - Cancel Payment - Cancel Settlement - Cancel Refund - Cancel Standalone Credit - Cancel Original Credit - Cancel Mandate  Allowed value for status: CANCELLED builder static inner class.
   */
  public static final class Builder {
    private TransactionRequestStatus status;

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
     * Returns a CancelRequest built from the parameters previously set.
     *
     * @return a CancelRequest built with parameters of this CancelRequest.Builder
     */
    public CancelRequest build() {
      return new CancelRequest(this);
    }
  }
}
