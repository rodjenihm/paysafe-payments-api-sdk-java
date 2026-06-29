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
 * Discretionary Data consists of three user-defined data fields containing additional information about your card acquirer.
 */
public class DiscretionaryData {

  @JsonProperty("field1")
  private String field1;
  @JsonProperty("field2")
  private String field2;
  @JsonProperty("field3")
  private String field3;

  public DiscretionaryData() {
    super();
  }

  private DiscretionaryData(final Builder builder) {
    setField1(builder.field1);
    setField2(builder.field2);
    setField3(builder.field3);
  }

  public static Builder builder() {
    return new Builder();
  }


  public DiscretionaryData field1(String field1) {
    this.field1 = field1;
    return this;
  }

  /**
   * Field 1 of the discretionary data
   *
   * @return field1
   */
  public String getField1() {
    return field1;
  }

  public void setField1(String field1) {
    this.field1 = field1;
  }


  public DiscretionaryData field2(String field2) {
    this.field2 = field2;
    return this;
  }

  /**
   * Field 2 of the discretionary data
   *
   * @return field2
   */
  public String getField2() {
    return field2;
  }

  public void setField2(String field2) {
    this.field2 = field2;
  }


  public DiscretionaryData field3(String field3) {
    this.field3 = field3;
    return this;
  }

  /**
   * Field 3 of the discretionary data
   *
   * @return field3
   */
  public String getField3() {
    return field3;
  }

  public void setField3(String field3) {
    this.field3 = field3;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DiscretionaryData discretionaryData = (DiscretionaryData) o;
    return Objects.equals(this.field1, discretionaryData.field1) &&
        Objects.equals(this.field2, discretionaryData.field2) &&
        Objects.equals(this.field3, discretionaryData.field3);
  }

  @Override
  public int hashCode() {
    return Objects.hash(field1, field2, field3);
  }

  @Override
  public String toString() {

    return "class DiscretionaryData {\n"
        + "    field1: " + toIndentedString(field1) + "\n"
        + "    field2: " + toIndentedString(field2) + "\n"
        + "    field3: " + toIndentedString(field3) + "\n"
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
   * Discretionary Data consists of three user-defined data fields containing additional information about your card acquirer. builder static inner class.
   */
  public static final class Builder {
    private String field1;
    private String field2;
    private String field3;

    private Builder() {
    }

    /**
     * Field 1 of the discretionary data
     * <p>
     * Sets the field1 and returns a reference to this Builder enabling method chaining.
     *
     * @param field1 the field1 to set
     * @return a reference to this Builder
     */
    public Builder field1(String field1) {
      this.field1 = field1;
      return this;
    }

    /**
     * Field 2 of the discretionary data
     * <p>
     * Sets the field2 and returns a reference to this Builder enabling method chaining.
     *
     * @param field2 the field2 to set
     * @return a reference to this Builder
     */
    public Builder field2(String field2) {
      this.field2 = field2;
      return this;
    }

    /**
     * Field 3 of the discretionary data
     * <p>
     * Sets the field3 and returns a reference to this Builder enabling method chaining.
     *
     * @param field3 the field3 to set
     * @return a reference to this Builder
     */
    public Builder field3(String field3) {
      this.field3 = field3;
      return this;
    }

    /**
     * Returns a DiscretionaryData built from the parameters previously set.
     *
     * @return a DiscretionaryData built with parameters of this DiscretionaryData.Builder
     */
    public DiscretionaryData build() {
      return new DiscretionaryData(this);
    }
  }
}
