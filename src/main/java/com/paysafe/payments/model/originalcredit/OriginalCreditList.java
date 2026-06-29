// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.model.originalcredit;

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
 * OriginalCreditList
 */
public class OriginalCreditList {

  @JsonProperty("originalCredits")
  private List<OriginalCredit> originalCredits;
  @JsonProperty("meta")
  private Meta meta;

  public OriginalCreditList() {
    super();
  }

  private OriginalCreditList(final Builder builder) {
    setOriginalCredits(builder.originalCredits);
    setMeta(builder.meta);
  }

  public static Builder builder() {
    return new Builder();
  }


  public OriginalCreditList originalCredits(List<OriginalCredit> originalCredits) {
    this.originalCredits = originalCredits;
    return this;
  }

  public OriginalCreditList addOriginalCreditsItem(OriginalCredit originalCreditsItem) {
    if (this.originalCredits == null) {
      this.originalCredits = new ArrayList<>();
    }
    this.originalCredits.add(originalCreditsItem);
    return this;
  }

  public OriginalCreditList removeOriginalCreditsItem(OriginalCredit originalCreditsItem) {
    if (originalCreditsItem != null && this.originalCredits != null) {
      this.originalCredits.remove(originalCreditsItem);
    }

    return this;
  }

  /**
   * Get originalCredits
   *
   * @return originalCredits
   */
  public List<OriginalCredit> getOriginalCredits() {
    return originalCredits;
  }

  public void setOriginalCredits(List<OriginalCredit> originalCredits) {
    this.originalCredits = originalCredits;
  }


  public OriginalCreditList meta(Meta meta) {
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
    OriginalCreditList originalCreditList = (OriginalCreditList) o;
    return Objects.equals(this.originalCredits, originalCreditList.originalCredits) &&
        Objects.equals(this.meta, originalCreditList.meta);
  }

  @Override
  public int hashCode() {
    return Objects.hash(originalCredits, meta);
  }

  @Override
  public String toString() {

    return "class OriginalCreditList {\n"
        + "    originalCredits: " + toIndentedString(originalCredits) + "\n"
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
   * OriginalCreditList builder static inner class.
   */
  public static final class Builder {
    private List<OriginalCredit> originalCredits;
    private Meta meta;

    private Builder() {
    }

    /**
     * Sets the originalCredits and returns a reference to this Builder enabling method chaining.
     *
     * @param originalCredits the originalCredits to set
     * @return a reference to this Builder
     */
    public Builder originalCredits(List<OriginalCredit> originalCredits) {
      this.originalCredits = originalCredits;
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
     * Returns a OriginalCreditList built from the parameters previously set.
     *
     * @return a OriginalCreditList built with parameters of this OriginalCreditList.Builder
     */
    public OriginalCreditList build() {
      return new OriginalCreditList(this);
    }
  }
}
