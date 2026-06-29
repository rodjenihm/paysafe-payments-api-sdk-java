// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.model.card;

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
 * Details of the billing cycle information for recurring payments. |REQUIRED|CONDITION |-|- |Conditional|Mandatory if authenticationPurpose = INSTALMENT_TRANSACTION or RECURRING_TRANSACTION
 */
public class BillingCycle {

  @JsonProperty("frequency")
  private Integer frequency;
  @JsonProperty("endDate")
  private String endDate;

  public BillingCycle() {
    super();
  }

  private BillingCycle(final Builder builder) {
    setFrequency(builder.frequency);
    setEndDate(builder.endDate);
  }

  public static Builder builder() {
    return new Builder();
  }


  public BillingCycle frequency(Integer frequency) {
    this.frequency = frequency;
    return this;
  }

  /**
   * Frequency of the recurring payment
   *
   * @return frequency
   */
  public Integer getFrequency() {
    return frequency;
  }

  public void setFrequency(Integer frequency) {
    this.frequency = frequency;
  }


  public BillingCycle endDate(String endDate) {
    this.endDate = endDate;
    return this;
  }

  /**
   * Date when the recurring payment will end
   *
   * @return endDate
   */
  public String getEndDate() {
    return endDate;
  }

  public void setEndDate(String endDate) {
    this.endDate = endDate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BillingCycle billingCycle = (BillingCycle) o;
    return Objects.equals(this.frequency, billingCycle.frequency) &&
        Objects.equals(this.endDate, billingCycle.endDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(frequency, endDate);
  }

  @Override
  public String toString() {

    return "class BillingCycle {\n"
        + "    frequency: " + toIndentedString(frequency) + "\n"
        + "    endDate: " + toIndentedString(endDate) + "\n"
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
   * Details of the billing cycle information for recurring payments. |REQUIRED|CONDITION |-|- |Conditional|Mandatory if authenticationPurpose = INSTALMENT_TRANSACTION or RECURRING_TRANSACTION builder static inner class.
   */
  public static final class Builder {
    private Integer frequency;
    private String endDate;

    private Builder() {
    }

    /**
     * Frequency of the recurring payment
     * <p>
     * Sets the frequency and returns a reference to this Builder enabling method chaining.
     *
     * @param frequency the frequency to set
     * @return a reference to this Builder
     */
    public Builder frequency(Integer frequency) {
      this.frequency = frequency;
      return this;
    }

    /**
     * Date when the recurring payment will end
     * <p>
     * Sets the endDate and returns a reference to this Builder enabling method chaining.
     *
     * @param endDate the endDate to set
     * @return a reference to this Builder
     */
    public Builder endDate(String endDate) {
      this.endDate = endDate;
      return this;
    }

    /**
     * Returns a BillingCycle built from the parameters previously set.
     *
     * @return a BillingCycle built with parameters of this BillingCycle.Builder
     */
    public BillingCycle build() {
      return new BillingCycle(this);
    }
  }
}
