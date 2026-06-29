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
import com.paysafe.payments.model.card.enums.AccordDFinancingType;



/**
 * Parameters for financing plans supported for certain merchant configurations. Include this element only when instructed to do so by your account manager.  **Note:** Not all processing gateways support this parameter.
 */
public class AccordD {

  @JsonProperty("financingType")
  private AccordDFinancingType financingType;
  @JsonProperty("plan")
  private String plan;
  @JsonProperty("gracePeriod")
  private Integer gracePeriod;
  @JsonProperty("term")
  private Integer term;

  public AccordD() {
    super();
  }

  private AccordD(final Builder builder) {
    setFinancingType(builder.financingType);
    setPlan(builder.plan);
    setGracePeriod(builder.gracePeriod);
    setTerm(builder.term);
  }

  public static Builder builder() {
    return new Builder();
  }


  public AccordD financingType(AccordDFinancingType financingType) {
    this.financingType = financingType;
    return this;
  }

  /**
   * Get financingType
   *
   * @return financingType
   */
  public AccordDFinancingType getFinancingType() {
    return financingType;
  }

  public void setFinancingType(AccordDFinancingType financingType) {
    this.financingType = financingType;
  }


  public AccordD plan(String plan) {
    this.plan = plan;
    return this;
  }

  /**
   * This is the plan number for this financing transaction.
   *
   * @return plan
   */
  public String getPlan() {
    return plan;
  }

  public void setPlan(String plan) {
    this.plan = plan;
  }


  public AccordD gracePeriod(Integer gracePeriod) {
    this.gracePeriod = gracePeriod;
    return this;
  }

  /**
   * This is the grace period, in months, associated with deferred payment transactions.
   *
   * @return gracePeriod
   */
  public Integer getGracePeriod() {
    return gracePeriod;
  }

  public void setGracePeriod(Integer gracePeriod) {
    this.gracePeriod = gracePeriod;
  }


  public AccordD term(Integer term) {
    this.term = term;
    return this;
  }

  /**
   * This is the number of payments, in months, for equal payment transactions.
   *
   * @return term
   */
  public Integer getTerm() {
    return term;
  }

  public void setTerm(Integer term) {
    this.term = term;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AccordD accordD = (AccordD) o;
    return Objects.equals(this.financingType, accordD.financingType) &&
        Objects.equals(this.plan, accordD.plan) &&
        Objects.equals(this.gracePeriod, accordD.gracePeriod) &&
        Objects.equals(this.term, accordD.term);
  }

  @Override
  public int hashCode() {
    return Objects.hash(financingType, plan, gracePeriod, term);
  }

  @Override
  public String toString() {

    return "class AccordD {\n"
        + "    financingType: " + toIndentedString(financingType) + "\n"
        + "    plan: " + toIndentedString(plan) + "\n"
        + "    gracePeriod: " + toIndentedString(gracePeriod) + "\n"
        + "    term: " + toIndentedString(term) + "\n"
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
   * Parameters for financing plans supported for certain merchant configurations. Include this element only when instructed to do so by your account manager.  **Note:** Not all processing gateways support this parameter. builder static inner class.
   */
  public static final class Builder {
    private AccordDFinancingType financingType;
    private String plan;
    private Integer gracePeriod;
    private Integer term;

    private Builder() {
    }

    /**
     * Sets the financingType and returns a reference to this Builder enabling method chaining.
     *
     * @param financingType the financingType to set
     * @return a reference to this Builder
     */
    public Builder financingType(AccordDFinancingType financingType) {
      this.financingType = financingType;
      return this;
    }

    /**
     * This is the plan number for this financing transaction.
     * <p>
     * Sets the plan and returns a reference to this Builder enabling method chaining.
     *
     * @param plan the plan to set
     * @return a reference to this Builder
     */
    public Builder plan(String plan) {
      this.plan = plan;
      return this;
    }

    /**
     * This is the grace period, in months, associated with deferred payment transactions.
     * <p>
     * Sets the gracePeriod and returns a reference to this Builder enabling method chaining.
     *
     * @param gracePeriod the gracePeriod to set
     * @return a reference to this Builder
     */
    public Builder gracePeriod(Integer gracePeriod) {
      this.gracePeriod = gracePeriod;
      return this;
    }

    /**
     * This is the number of payments, in months, for equal payment transactions.
     * <p>
     * Sets the term and returns a reference to this Builder enabling method chaining.
     *
     * @param term the term to set
     * @return a reference to this Builder
     */
    public Builder term(Integer term) {
      this.term = term;
      return this;
    }

    /**
     * Returns a AccordD built from the parameters previously set.
     *
     * @return a AccordD built with parameters of this AccordD.Builder
     */
    public AccordD build() {
      return new AccordD(this);
    }
  }
}
