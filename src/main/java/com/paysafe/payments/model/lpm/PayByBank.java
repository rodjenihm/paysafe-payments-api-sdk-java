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
import com.paysafe.payments.model.lpm.enums.PayByBankScheme;



/**
 * This object should be used only for pay by bank transactions.
 */
public class PayByBank {

  @JsonProperty("consumerId")
  private String consumerId;
  @JsonProperty("registrationId")
  private String registrationId;
  @JsonProperty("scheme")
  private PayByBankScheme scheme;
  @JsonProperty("ach")
  private PayByBankAch ach;

  public PayByBank() {
    super();
  }

  private PayByBank(final Builder builder) {
    setConsumerId(builder.consumerId);
    setRegistrationId(builder.registrationId);
    setScheme(builder.scheme);
    setAch(builder.ach);
  }

  public static Builder builder() {
    return new Builder();
  }


  public PayByBank consumerId(String consumerId) {
    this.consumerId = consumerId;
    return this;
  }

  /**
   * This is your identifier for your consumer and must be unique per consumer
   *
   * @return consumerId
   */
  public String getConsumerId() {
    return consumerId;
  }

  public void setConsumerId(String consumerId) {
    this.consumerId = consumerId;
  }


  public PayByBank registrationId(String registrationId) {
    this.registrationId = registrationId;
    return this;
  }

  /**
   * Paysafe's unique identifier for your consumer
   *
   * @return registrationId
   */
  public String getRegistrationId() {
    return registrationId;
  }

  public void setRegistrationId(String registrationId) {
    this.registrationId = registrationId;
  }


  public PayByBank scheme(PayByBankScheme scheme) {
    this.scheme = scheme;
    return this;
  }

  /**
   * Get scheme
   *
   * @return scheme
   */
  public PayByBankScheme getScheme() {
    return scheme;
  }

  public void setScheme(PayByBankScheme scheme) {
    this.scheme = scheme;
  }


  public PayByBank ach(PayByBankAch ach) {
    this.ach = ach;
    return this;
  }

  /**
   * Get ach
   *
   * @return ach
   */
  public PayByBankAch getAch() {
    return ach;
  }

  public void setAch(PayByBankAch ach) {
    this.ach = ach;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PayByBank payByBank = (PayByBank) o;
    return Objects.equals(this.consumerId, payByBank.consumerId) &&
        Objects.equals(this.registrationId, payByBank.registrationId) &&
        Objects.equals(this.scheme, payByBank.scheme) &&
        Objects.equals(this.ach, payByBank.ach);
  }

  @Override
  public int hashCode() {
    return Objects.hash(consumerId, registrationId, scheme, ach);
  }

  @Override
  public String toString() {

    return "class PayByBank {\n"
        + "    consumerId: " + toIndentedString(consumerId) + "\n"
        + "    registrationId: " + toIndentedString(registrationId) + "\n"
        + "    scheme: " + toIndentedString(scheme) + "\n"
        + "    ach: " + toIndentedString(ach) + "\n"
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
   * This object should be used only for pay by bank transactions. builder static inner class.
   */
  public static final class Builder {
    private String consumerId;
    private String registrationId;
    private PayByBankScheme scheme;
    private PayByBankAch ach;

    private Builder() {
    }

    /**
     * This is your identifier for your consumer and must be unique per consumer
     * <p>
     * Sets the consumerId and returns a reference to this Builder enabling method chaining.
     *
     * @param consumerId the consumerId to set
     * @return a reference to this Builder
     */
    public Builder consumerId(String consumerId) {
      this.consumerId = consumerId;
      return this;
    }

    /**
     * Paysafe's unique identifier for your consumer
     * <p>
     * Sets the registrationId and returns a reference to this Builder enabling method chaining.
     *
     * @param registrationId the registrationId to set
     * @return a reference to this Builder
     */
    public Builder registrationId(String registrationId) {
      this.registrationId = registrationId;
      return this;
    }

    /**
     * Sets the scheme and returns a reference to this Builder enabling method chaining.
     *
     * @param scheme the scheme to set
     * @return a reference to this Builder
     */
    public Builder scheme(PayByBankScheme scheme) {
      this.scheme = scheme;
      return this;
    }

    /**
     * Sets the ach and returns a reference to this Builder enabling method chaining.
     *
     * @param ach the ach to set
     * @return a reference to this Builder
     */
    public Builder ach(PayByBankAch ach) {
      this.ach = ach;
      return this;
    }

    /**
     * Returns a PayByBank built from the parameters previously set.
     *
     * @return a PayByBank built with parameters of this PayByBank.Builder
     */
    public PayByBank build() {
      return new PayByBank(this);
    }
  }
}
