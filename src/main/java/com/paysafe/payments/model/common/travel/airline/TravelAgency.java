// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.model.common.travel.airline;

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
 * Information about the travel agency if the ticket was issued by a travel agency.
 */
public class TravelAgency {

  @JsonProperty("code")
  private String code;
  @JsonProperty("name")
  private String name;
  @JsonProperty("agencyAddress")
  private AgencyAddress agencyAddress;

  public TravelAgency() {
    super();
  }

  private TravelAgency(final Builder builder) {
    setCode(builder.code);
    setName(builder.name);
    setAgencyAddress(builder.agencyAddress);
  }

  public static Builder builder() {
    return new Builder();
  }


  public TravelAgency code(String code) {
    this.code = code;
    return this;
  }

  /**
   * Code identifying travel agency if the ticket was issued by a travel agency
   *
   * @return code
   */
  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }


  public TravelAgency name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the travel agency
   *
   * @return name
   */
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public TravelAgency agencyAddress(AgencyAddress agencyAddress) {
    this.agencyAddress = agencyAddress;
    return this;
  }

  /**
   * Get agencyAddress
   *
   * @return agencyAddress
   */
  public AgencyAddress getAgencyAddress() {
    return agencyAddress;
  }

  public void setAgencyAddress(AgencyAddress agencyAddress) {
    this.agencyAddress = agencyAddress;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TravelAgency travelAgency = (TravelAgency) o;
    return Objects.equals(this.code, travelAgency.code) &&
        Objects.equals(this.name, travelAgency.name) &&
        Objects.equals(this.agencyAddress, travelAgency.agencyAddress);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, name, agencyAddress);
  }

  @Override
  public String toString() {

    return "class TravelAgency {\n"
        + "    code: " + toIndentedString(code) + "\n"
        + "    name: " + toIndentedString(name) + "\n"
        + "    agencyAddress: " + toIndentedString(agencyAddress) + "\n"
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
   * Information about the travel agency if the ticket was issued by a travel agency. builder static inner class.
   */
  public static final class Builder {
    private String code;
    private String name;
    private AgencyAddress agencyAddress;

    private Builder() {
    }

    /**
     * Code identifying travel agency if the ticket was issued by a travel agency
     * <p>
     * Sets the code and returns a reference to this Builder enabling method chaining.
     *
     * @param code the code to set
     * @return a reference to this Builder
     */
    public Builder code(String code) {
      this.code = code;
      return this;
    }

    /**
     * Name of the travel agency
     * <p>
     * Sets the name and returns a reference to this Builder enabling method chaining.
     *
     * @param name the name to set
     * @return a reference to this Builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Sets the agencyAddress and returns a reference to this Builder enabling method chaining.
     *
     * @param agencyAddress the agencyAddress to set
     * @return a reference to this Builder
     */
    public Builder agencyAddress(AgencyAddress agencyAddress) {
      this.agencyAddress = agencyAddress;
      return this;
    }

    /**
     * Returns a TravelAgency built from the parameters previously set.
     *
     * @return a TravelAgency built with parameters of this TravelAgency.Builder
     */
    public TravelAgency build() {
      return new TravelAgency(this);
    }
  }
}
