// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.model.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.paysafe.payments.model.common.enums.MandateStatus;
import com.paysafe.payments.model.common.enums.MandateStatusReason;
import com.paysafe.payments.model.customer.Customer;



/**
 * Customer bank's mandate details for recurring payments
 */
public class Mandate {

  @JsonProperty("id")
  private String id;
  @JsonProperty("reference")
  private String reference;
  @JsonProperty("status")
  private MandateStatus status;
  @JsonProperty("statusReason")
  private MandateStatusReason statusReason;

  public Mandate() {
    super();
  }

  private Mandate(final Builder builder) {
    setId(builder.id);
    setReference(builder.reference);
    setStatus(builder.status);
    setStatusReason(builder.statusReason);
  }

  public static Builder builder() {
    return new Builder();
  }


  public Mandate id(String id) {
    this.id = id;
    return this;
  }

  /**
   * The id of the mandate that got created
   *
   * @return id
   */
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public Mandate reference(String reference) {
    this.reference = reference;
    return this;
  }

  /**
   * The identifier of the mandate in the banking system
   *
   * @return reference
   */
  public String getReference() {
    return reference;
  }

  public void setReference(String reference) {
    this.reference = reference;
  }


  public Mandate status(MandateStatus status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   *
   * @return status
   */
  public MandateStatus getStatus() {
    return status;
  }

  public void setStatus(MandateStatus status) {
    this.status = status;
  }


  public Mandate statusReason(MandateStatusReason statusReason) {
    this.statusReason = statusReason;
    return this;
  }

  /**
   * Get statusReason
   *
   * @return statusReason
   */
  public MandateStatusReason getStatusReason() {
    return statusReason;
  }

  public void setStatusReason(MandateStatusReason statusReason) {
    this.statusReason = statusReason;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Mandate mandate = (Mandate) o;
    return Objects.equals(this.id, mandate.id) &&
        Objects.equals(this.reference, mandate.reference) &&
        Objects.equals(this.status, mandate.status) &&
        Objects.equals(this.statusReason, mandate.statusReason);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, reference, status, statusReason);
  }

  @Override
  public String toString() {

    return "class Mandate {\n"
        + "    id: " + toIndentedString(id) + "\n"
        + "    reference: " + toIndentedString(reference) + "\n"
        + "    status: " + toIndentedString(status) + "\n"
        + "    statusReason: " + toIndentedString(statusReason) + "\n"
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
   * Customer bank's mandate details for recurring payments builder static inner class.
   */
  public static final class Builder {
    private String id;
    private String reference;
    private MandateStatus status;
    private MandateStatusReason statusReason;

    private Builder() {
    }

    /**
     * The id of the mandate that got created
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
     * The identifier of the mandate in the banking system
     * <p>
     * Sets the reference and returns a reference to this Builder enabling method chaining.
     *
     * @param reference the reference to set
     * @return a reference to this Builder
     */
    public Builder reference(String reference) {
      this.reference = reference;
      return this;
    }

    /**
     * Sets the status and returns a reference to this Builder enabling method chaining.
     *
     * @param status the status to set
     * @return a reference to this Builder
     */
    public Builder status(MandateStatus status) {
      this.status = status;
      return this;
    }

    /**
     * Sets the statusReason and returns a reference to this Builder enabling method chaining.
     *
     * @param statusReason the statusReason to set
     * @return a reference to this Builder
     */
    public Builder statusReason(MandateStatusReason statusReason) {
      this.statusReason = statusReason;
      return this;
    }

    /**
     * Returns a Mandate built from the parameters previously set.
     *
     * @return a Mandate built with parameters of this Mandate.Builder
     */
    public Mandate build() {
      return new Mandate(this);
    }
  }
}
