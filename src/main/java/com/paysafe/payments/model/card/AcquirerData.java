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
 * Acquirer data is additional information about your card acquirer. This is applicable **only when** you are using Worldpay (VAN) as your acquirer for authorizations. Contact your account manager for more information.
 */
public class AcquirerData {

  @JsonProperty("code")
  private String code;
  @JsonProperty("discretionaryData")
  private DiscretionaryData discretionaryData;

  public AcquirerData() {
    super();
  }

  private AcquirerData(final Builder builder) {
    setCode(builder.code);
    setDiscretionaryData(builder.discretionaryData);
  }

  public static Builder builder() {
    return new Builder();
  }


  public AcquirerData code(String code) {
    this.code = code;
    return this;
  }

  /**
   * Code for your card acquirer
   *
   * @return code
   */
  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }


  public AcquirerData discretionaryData(DiscretionaryData discretionaryData) {
    this.discretionaryData = discretionaryData;
    return this;
  }

  /**
   * Get discretionaryData
   *
   * @return discretionaryData
   */
  public DiscretionaryData getDiscretionaryData() {
    return discretionaryData;
  }

  public void setDiscretionaryData(DiscretionaryData discretionaryData) {
    this.discretionaryData = discretionaryData;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AcquirerData acquirerData = (AcquirerData) o;
    return Objects.equals(this.code, acquirerData.code) &&
        Objects.equals(this.discretionaryData, acquirerData.discretionaryData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, discretionaryData);
  }

  @Override
  public String toString() {

    return "class AcquirerData {\n"
        + "    code: " + toIndentedString(code) + "\n"
        + "    discretionaryData: " + toIndentedString(discretionaryData) + "\n"
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
   * Acquirer data is additional information about your card acquirer. This is applicable **only when** you are using Worldpay (VAN) as your acquirer for authorizations. Contact your account manager for more information. builder static inner class.
   */
  public static final class Builder {
    private String code;
    private DiscretionaryData discretionaryData;

    private Builder() {
    }

    /**
     * Code for your card acquirer
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
     * Sets the discretionaryData and returns a reference to this Builder enabling method chaining.
     *
     * @param discretionaryData the discretionaryData to set
     * @return a reference to this Builder
     */
    public Builder discretionaryData(DiscretionaryData discretionaryData) {
      this.discretionaryData = discretionaryData;
      return this;
    }

    /**
     * Returns a AcquirerData built from the parameters previously set.
     *
     * @return a AcquirerData built with parameters of this AcquirerData.Builder
     */
    public AcquirerData build() {
      return new AcquirerData(this);
    }
  }
}
