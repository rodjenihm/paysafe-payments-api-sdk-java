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
import com.paysafe.payments.model.lpm.enums.KeyLevelRestriction;
import com.paysafe.payments.model.payment.Payment;



/**
 * These are the details of the paysafecard used for the transaction.
 */
public class Paysafecard {

  @JsonProperty("consumerId")
  private String consumerId;
  @JsonProperty("minAgeRestriction")
  private Integer minAgeRestriction;
  @JsonProperty("kycLevelRestriction")
  private KeyLevelRestriction kycLevelRestriction;
  @JsonProperty("countryRestriction")
  private String countryRestriction;
  @JsonProperty("submerchantId")
  private String submerchantId;

  public Paysafecard() {
    super();
  }

  private Paysafecard(final Builder builder) {
    setConsumerId(builder.consumerId);
    setMinAgeRestriction(builder.minAgeRestriction);
    setKycLevelRestriction(builder.kycLevelRestriction);
    setCountryRestriction(builder.countryRestriction);
    setSubmerchantId(builder.submerchantId);
  }

  public static Builder builder() {
    return new Builder();
  }


  public Paysafecard consumerId(String consumerId) {
    this.consumerId = consumerId;
    return this;
  }

  /**
   * This is the merchant's unique identifier of the customer. For security purposes, if any personal data is used (for example, customer's user name, email address, etc.), it has to be encrypted or hashed. **Mandatory.**
   *
   * @return consumerId
   */
  public String getConsumerId() {
    return consumerId;
  }

  public void setConsumerId(String consumerId) {
    this.consumerId = consumerId;
  }


  public Paysafecard minAgeRestriction(Integer minAgeRestriction) {
    this.minAgeRestriction = minAgeRestriction;
    return this;
  }

  /**
   * Payment can be restricted for a certain minimum consumer age (implicitly restricts payment to registered consumers only)
   *
   * @return minAgeRestriction
   */
  public Integer getMinAgeRestriction() {
    return minAgeRestriction;
  }

  public void setMinAgeRestriction(Integer minAgeRestriction) {
    this.minAgeRestriction = minAgeRestriction;
  }


  public Paysafecard kycLevelRestriction(KeyLevelRestriction kycLevelRestriction) {
    this.kycLevelRestriction = kycLevelRestriction;
    return this;
  }

  /**
   * Get kycLevelRestriction
   *
   * @return kycLevelRestriction
   */
  public KeyLevelRestriction getKycLevelRestriction() {
    return kycLevelRestriction;
  }

  public void setKycLevelRestriction(KeyLevelRestriction kycLevelRestriction) {
    this.kycLevelRestriction = kycLevelRestriction;
  }


  public Paysafecard countryRestriction(String countryRestriction) {
    this.countryRestriction = countryRestriction;
    return this;
  }

  /**
   * This is the code of the country to which the transaction will be restricted. Optional. See [Country codes](https://developer.paysafe.com/en/support/reference-information/codes/#country-codes)
   *
   * @return countryRestriction
   */
  public String getCountryRestriction() {
    return countryRestriction;
  }

  public void setCountryRestriction(String countryRestriction) {
    this.countryRestriction = countryRestriction;
  }


  public Paysafecard submerchantId(String submerchantId) {
    this.submerchantId = submerchantId;
    return this;
  }

  /**
   * The Submerchant Id (Reporting Criteria) is used to classify sub-merchants at PaysafeCard side
   *
   * @return submerchantId
   */
  public String getSubmerchantId() {
    return submerchantId;
  }

  public void setSubmerchantId(String submerchantId) {
    this.submerchantId = submerchantId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Paysafecard paysafecard = (Paysafecard) o;
    return Objects.equals(this.consumerId, paysafecard.consumerId) &&
        Objects.equals(this.minAgeRestriction, paysafecard.minAgeRestriction) &&
        Objects.equals(this.kycLevelRestriction, paysafecard.kycLevelRestriction) &&
        Objects.equals(this.countryRestriction, paysafecard.countryRestriction) &&
        Objects.equals(this.submerchantId, paysafecard.submerchantId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(consumerId, minAgeRestriction, kycLevelRestriction, countryRestriction, submerchantId);
  }

  @Override
  public String toString() {

    return "class Paysafecard {\n"
        + "    consumerId: " + toIndentedString(consumerId) + "\n"
        + "    minAgeRestriction: " + toIndentedString(minAgeRestriction) + "\n"
        + "    kycLevelRestriction: " + toIndentedString(kycLevelRestriction) + "\n"
        + "    countryRestriction: " + toIndentedString(countryRestriction) + "\n"
        + "    submerchantId: " + toIndentedString(submerchantId) + "\n"
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
   * These are the details of the paysafecard used for the transaction. builder static inner class.
   */
  public static final class Builder {
    private String consumerId;
    private Integer minAgeRestriction;
    private KeyLevelRestriction kycLevelRestriction;
    private String countryRestriction;
    private String submerchantId;

    private Builder() {
    }

    /**
     * This is the merchant's unique identifier of the customer. For security purposes, if any personal data is used (for example, customer's user name, email address, etc.), it has to be encrypted or hashed. **Mandatory.**
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
     * Payment can be restricted for a certain minimum consumer age (implicitly restricts payment to registered consumers only)
     * <p>
     * Sets the minAgeRestriction and returns a reference to this Builder enabling method chaining.
     *
     * @param minAgeRestriction the minAgeRestriction to set
     * @return a reference to this Builder
     */
    public Builder minAgeRestriction(Integer minAgeRestriction) {
      this.minAgeRestriction = minAgeRestriction;
      return this;
    }

    /**
     * Sets the kycLevelRestriction and returns a reference to this Builder enabling method chaining.
     *
     * @param kycLevelRestriction the kycLevelRestriction to set
     * @return a reference to this Builder
     */
    public Builder kycLevelRestriction(KeyLevelRestriction kycLevelRestriction) {
      this.kycLevelRestriction = kycLevelRestriction;
      return this;
    }

    /**
     * This is the code of the country to which the transaction will be restricted. Optional. See [Country codes](https://developer.paysafe.com/en/support/reference-information/codes/#country-codes)
     * <p>
     * Sets the countryRestriction and returns a reference to this Builder enabling method chaining.
     *
     * @param countryRestriction the countryRestriction to set
     * @return a reference to this Builder
     */
    public Builder countryRestriction(String countryRestriction) {
      this.countryRestriction = countryRestriction;
      return this;
    }

    /**
     * The Submerchant Id (Reporting Criteria) is used to classify sub-merchants at PaysafeCard side
     * <p>
     * Sets the submerchantId and returns a reference to this Builder enabling method chaining.
     *
     * @param submerchantId the submerchantId to set
     * @return a reference to this Builder
     */
    public Builder submerchantId(String submerchantId) {
      this.submerchantId = submerchantId;
      return this;
    }

    /**
     * Returns a Paysafecard built from the parameters previously set.
     *
     * @return a Paysafecard built with parameters of this Paysafecard.Builder
     */
    public Paysafecard build() {
      return new Paysafecard(this);
    }
  }
}
