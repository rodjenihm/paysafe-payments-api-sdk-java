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
import com.paysafe.payments.model.lpm.enums.BankNameCode;
import com.paysafe.payments.model.lpm.enums.SafetyPayCashCountryCode;



/**
 * SafetyPayCash.
 */
public class SafetyPayCash {

  @JsonProperty("countryCode")
  private SafetyPayCashCountryCode countryCode;
  @JsonProperty("bankNameCodes")
  private List<BankNameCode> bankNameCodes;

  public SafetyPayCash() {
    super();
  }

  private SafetyPayCash(final Builder builder) {
    setCountryCode(builder.countryCode);
    setBankNameCodes(builder.bankNameCodes);
  }

  public static Builder builder() {
    return new Builder();
  }


  public SafetyPayCash countryCode(SafetyPayCashCountryCode countryCode) {
    this.countryCode = countryCode;
    return this;
  }

  /**
   * Get countryCode
   *
   * @return countryCode
   */
  public SafetyPayCashCountryCode getCountryCode() {
    return countryCode;
  }

  public void setCountryCode(SafetyPayCashCountryCode countryCode) {
    this.countryCode = countryCode;
  }


  public SafetyPayCash bankNameCodes(List<BankNameCode> bankNameCodes) {
    this.bankNameCodes = bankNameCodes;
    return this;
  }

  public SafetyPayCash addBankNameCodesItem(BankNameCode bankNameCodesItem) {
    if (this.bankNameCodes == null) {
      this.bankNameCodes = new ArrayList<>();
    }
    this.bankNameCodes.add(bankNameCodesItem);
    return this;
  }

  public SafetyPayCash removeBankNameCodesItem(BankNameCode bankNameCodesItem) {
    if (bankNameCodesItem != null && this.bankNameCodes != null) {
      this.bankNameCodes.remove(bankNameCodesItem);
    }

    return this;
  }

  /**
   * Get bankNameCodes
   *
   * @return bankNameCodes
   */
  public List<BankNameCode> getBankNameCodes() {
    return bankNameCodes;
  }

  public void setBankNameCodes(List<BankNameCode> bankNameCodes) {
    this.bankNameCodes = bankNameCodes;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SafetyPayCash safetyPayCash = (SafetyPayCash) o;
    return Objects.equals(this.countryCode, safetyPayCash.countryCode) &&
        Objects.equals(this.bankNameCodes, safetyPayCash.bankNameCodes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(countryCode, bankNameCodes);
  }

  @Override
  public String toString() {

    return "class SafetyPayCash {\n"
        + "    countryCode: " + toIndentedString(countryCode) + "\n"
        + "    bankNameCodes: " + toIndentedString(bankNameCodes) + "\n"
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
   * SafetyPayCash. builder static inner class.
   */
  public static final class Builder {
    private SafetyPayCashCountryCode countryCode;
    private List<BankNameCode> bankNameCodes;

    private Builder() {
    }

    /**
     * Sets the countryCode and returns a reference to this Builder enabling method chaining.
     *
     * @param countryCode the countryCode to set
     * @return a reference to this Builder
     */
    public Builder countryCode(SafetyPayCashCountryCode countryCode) {
      this.countryCode = countryCode;
      return this;
    }

    /**
     * Get bankNameCodes
     * <p>
     * Sets the bankNameCodes and returns a reference to this Builder enabling method chaining.
     *
     * @param bankNameCodes the bankNameCodes to set
     * @return a reference to this Builder
     */
    public Builder bankNameCodes(List<BankNameCode> bankNameCodes) {
      this.bankNameCodes = bankNameCodes;
      return this;
    }

    /**
     * Returns a SafetyPayCash built from the parameters previously set.
     *
     * @return a SafetyPayCash built with parameters of this SafetyPayCash.Builder
     */
    public SafetyPayCash build() {
      return new SafetyPayCash(this);
    }
  }
}
