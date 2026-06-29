// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.model.settlement;

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
 * SettlementList
 */
public class SettlementList {

  @JsonProperty("settlements")
  private List<Settlement> settlements;
  @JsonProperty("meta")
  private Meta meta;

  public SettlementList() {
    super();
  }

  private SettlementList(final Builder builder) {
    setSettlements(builder.settlements);
    setMeta(builder.meta);
  }

  public static Builder builder() {
    return new Builder();
  }


  public SettlementList settlements(List<Settlement> settlements) {
    this.settlements = settlements;
    return this;
  }

  public SettlementList addSettlementsItem(Settlement settlementsItem) {
    if (this.settlements == null) {
      this.settlements = new ArrayList<>();
    }
    this.settlements.add(settlementsItem);
    return this;
  }

  public SettlementList removeSettlementsItem(Settlement settlementsItem) {
    if (settlementsItem != null && this.settlements != null) {
      this.settlements.remove(settlementsItem);
    }

    return this;
  }

  /**
   * Get settlements
   *
   * @return settlements
   */
  public List<Settlement> getSettlements() {
    return settlements;
  }

  public void setSettlements(List<Settlement> settlements) {
    this.settlements = settlements;
  }


  public SettlementList meta(Meta meta) {
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
    SettlementList settlementList = (SettlementList) o;
    return Objects.equals(this.settlements, settlementList.settlements) &&
        Objects.equals(this.meta, settlementList.meta);
  }

  @Override
  public int hashCode() {
    return Objects.hash(settlements, meta);
  }

  @Override
  public String toString() {

    return "class SettlementList {\n"
        + "    settlements: " + toIndentedString(settlements) + "\n"
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
   * SettlementList builder static inner class.
   */
  public static final class Builder {
    private List<Settlement> settlements;
    private Meta meta;

    private Builder() {
    }

    /**
     * Sets the settlements and returns a reference to this Builder enabling method chaining.
     *
     * @param settlements the settlements to set
     * @return a reference to this Builder
     */
    public Builder settlements(List<Settlement> settlements) {
      this.settlements = settlements;
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
     * Returns a SettlementList built from the parameters previously set.
     *
     * @return a SettlementList built with parameters of this SettlementList.Builder
     */
    public SettlementList build() {
      return new SettlementList(this);
    }
  }
}
