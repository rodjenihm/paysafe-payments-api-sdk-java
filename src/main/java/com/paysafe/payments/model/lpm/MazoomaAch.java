// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.model.lpm;

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
 * MazoomaAch.
 */
public class MazoomaAch {

  @JsonProperty("paymentHandleToken")
  private String paymentHandleToken;

  public MazoomaAch() {
    super();
  }

  private MazoomaAch(final Builder builder) {
    setPaymentHandleToken(builder.paymentHandleToken);
  }

  public static Builder builder() {
    return new Builder();
  }


  public MazoomaAch paymentHandleToken(String paymentHandleToken) {
    this.paymentHandleToken = paymentHandleToken;
    return this;
  }

  /**
   * This is a unique identifier for each user bank account which is saved at Mazooma end
   *
   * @return paymentHandleToken
   */
  public String getPaymentHandleToken() {
    return paymentHandleToken;
  }

  public void setPaymentHandleToken(String paymentHandleToken) {
    this.paymentHandleToken = paymentHandleToken;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MazoomaAch mazoomaAch = (MazoomaAch) o;
    return Objects.equals(this.paymentHandleToken, mazoomaAch.paymentHandleToken);
  }

  @Override
  public int hashCode() {
    return Objects.hash(paymentHandleToken);
  }

  @Override
  public String toString() {

    return "class MazoomaAch {\n"
        + "    paymentHandleToken: " + toIndentedString(paymentHandleToken) + "\n"
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
   * MazoomaAch. builder static inner class.
   */
  public static final class Builder {
    private String paymentHandleToken;

    private Builder() {
    }

    /**
     * This is a unique identifier for each user bank account which is saved at Mazooma end
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
     * Returns a MazoomaAch built from the parameters previously set.
     *
     * @return a MazoomaAch built with parameters of this MazoomaAch.Builder
     */
    public MazoomaAch build() {
      return new MazoomaAch(this);
    }
  }
}
