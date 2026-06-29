// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.model.paymentmethod;

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
 * The response returned by /v1/paymentmethods endpoint.
 */
public class LookUpPaymentMethodsResponse {

  @JsonProperty("paymentMethods")
  private List<PaymentMethod> paymentMethods;

  public LookUpPaymentMethodsResponse() {
    super();
  }

  private LookUpPaymentMethodsResponse(final Builder builder) {
    setPaymentMethods(builder.paymentMethods);
  }

  public static Builder builder() {
    return new Builder();
  }


  public LookUpPaymentMethodsResponse paymentMethods(List<PaymentMethod> paymentMethods) {
    this.paymentMethods = paymentMethods;
    return this;
  }

  public LookUpPaymentMethodsResponse addPaymentMethodsItem(PaymentMethod paymentMethodsItem) {
    if (this.paymentMethods == null) {
      this.paymentMethods = new ArrayList<>();
    }
    this.paymentMethods.add(paymentMethodsItem);
    return this;
  }

  public LookUpPaymentMethodsResponse removePaymentMethodsItem(PaymentMethod paymentMethodsItem) {
    if (paymentMethodsItem != null && this.paymentMethods != null) {
      this.paymentMethods.remove(paymentMethodsItem);
    }

    return this;
  }

  /**
   * Get paymentMethods
   *
   * @return paymentMethods
   */
  public List<PaymentMethod> getPaymentMethods() {
    return paymentMethods;
  }

  public void setPaymentMethods(List<PaymentMethod> paymentMethods) {
    this.paymentMethods = paymentMethods;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LookUpPaymentMethodsResponse lookUpPaymentMethodsResponse = (LookUpPaymentMethodsResponse) o;
    return Objects.equals(this.paymentMethods, lookUpPaymentMethodsResponse.paymentMethods);
  }

  @Override
  public int hashCode() {
    return Objects.hash(paymentMethods);
  }

  @Override
  public String toString() {

    return "class LookUpPaymentMethodsResponse {\n"
        + "    paymentMethods: " + toIndentedString(paymentMethods) + "\n"
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
   * The response returned by /v1/paymentmethods endpoint. builder static inner class.
   */
  public static final class Builder {
    private List<PaymentMethod> paymentMethods;

    private Builder() {
    }

    /**
     * Sets the paymentMethods and returns a reference to this Builder enabling method chaining.
     *
     * @param paymentMethods the paymentMethods to set
     * @return a reference to this Builder
     */
    public Builder paymentMethods(List<PaymentMethod> paymentMethods) {
      this.paymentMethods = paymentMethods;
      return this;
    }

    /**
     * Returns a LookUpPaymentMethodsResponse built from the parameters previously set.
     *
     * @return a LookUpPaymentMethodsResponse built with parameters of this LookUpPaymentMethodsResponse.Builder
     */
    public LookUpPaymentMethodsResponse build() {
      return new LookUpPaymentMethodsResponse(this);
    }
  }
}
