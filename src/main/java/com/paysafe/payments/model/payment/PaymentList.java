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
import com.paysafe.payments.model.common.Meta;



/**
 * PaymentList
 */
public class PaymentList {

  @JsonProperty("payments")
  private List<Payment> payments;
  @JsonProperty("meta")
  private Meta meta;

  public PaymentList() {
    super();
  }

  private PaymentList(final Builder builder) {
    setPayments(builder.payments);
    setMeta(builder.meta);
  }

  public static Builder builder() {
    return new Builder();
  }


  public PaymentList payments(List<Payment> payments) {
    this.payments = payments;
    return this;
  }

  public PaymentList addPaymentsItem(Payment paymentsItem) {
    if (this.payments == null) {
      this.payments = new ArrayList<>();
    }
    this.payments.add(paymentsItem);
    return this;
  }

  public PaymentList removePaymentsItem(Payment paymentsItem) {
    if (paymentsItem != null && this.payments != null) {
      this.payments.remove(paymentsItem);
    }

    return this;
  }

  /**
   * Get payments
   *
   * @return payments
   */
  public List<Payment> getPayments() {
    return payments;
  }

  public void setPayments(List<Payment> payments) {
    this.payments = payments;
  }


  public PaymentList meta(Meta meta) {
    this.meta = meta;
    return this;
  }

  /**
   * Get meta
   *
   * @return meta
   */
  public Meta getMeta() {
    return meta;
  }

  public void setMeta(Meta meta) {
    this.meta = meta;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PaymentList paymentList = (PaymentList) o;
    return Objects.equals(this.payments, paymentList.payments) &&
        Objects.equals(this.meta, paymentList.meta);
  }

  @Override
  public int hashCode() {
    return Objects.hash(payments, meta);
  }

  @Override
  public String toString() {

    return "class PaymentList {\n"
        + "    payments: " + toIndentedString(payments) + "\n"
        + "    meta: " + toIndentedString(meta) + "\n"
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
   * PaymentList builder static inner class.
   */
  public static final class Builder {
    private List<Payment> payments;
    private Meta meta;

    private Builder() {
    }

    /**
     * Sets the payments and returns a reference to this Builder enabling method chaining.
     *
     * @param payments the payments to set
     * @return a reference to this Builder
     */
    public Builder payments(List<Payment> payments) {
      this.payments = payments;
      return this;
    }

    /**
     * Sets the meta and returns a reference to this Builder enabling method chaining.
     *
     * @param meta the meta to set
     * @return a reference to this Builder
     */
    public Builder meta(Meta meta) {
      this.meta = meta;
      return this;
    }

    /**
     * Returns a PaymentList built from the parameters previously set.
     *
     * @return a PaymentList built with parameters of this PaymentList.Builder
     */
    public PaymentList build() {
      return new PaymentList(this);
    }
  }
}
