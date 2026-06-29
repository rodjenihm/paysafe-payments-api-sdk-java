// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.model.common.profile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.paysafe.payments.model.customer.Customer;



/**
 * Customer's date of birth information
 */
public class DateOfBirth {

  @JsonProperty("day")
  private Integer day;
  @JsonProperty("month")
  private Integer month;
  @JsonProperty("year")
  private Integer year;

  public DateOfBirth() {
    super();
  }

  private DateOfBirth(final Builder builder) {
    setDay(builder.day);
    setMonth(builder.month);
    setYear(builder.year);
  }

  public static Builder builder() {
    return new Builder();
  }


  public DateOfBirth day(Integer day) {
    this.day = day;
    return this;
  }

  /**
   * Day of birth
   *
   * @return day
   */
  public Integer getDay() {
    return day;
  }

  public void setDay(Integer day) {
    this.day = day;
  }


  public DateOfBirth month(Integer month) {
    this.month = month;
    return this;
  }

  /**
   * Month of birth
   *
   * @return month
   */
  public Integer getMonth() {
    return month;
  }

  public void setMonth(Integer month) {
    this.month = month;
  }


  public DateOfBirth year(Integer year) {
    this.year = year;
    return this;
  }

  /**
   * Year of birth
   *
   * @return year
   */
  public Integer getYear() {
    return year;
  }

  public void setYear(Integer year) {
    this.year = year;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DateOfBirth dateOfBirth = (DateOfBirth) o;
    return Objects.equals(this.day, dateOfBirth.day) &&
        Objects.equals(this.month, dateOfBirth.month) &&
        Objects.equals(this.year, dateOfBirth.year);
  }

  @Override
  public int hashCode() {
    return Objects.hash(day, month, year);
  }

  @Override
  public String toString() {

    return "class DateOfBirth {\n"
        + "    day: " + toIndentedString(day) + "\n"
        + "    month: " + toIndentedString(month) + "\n"
        + "    year: " + toIndentedString(year) + "\n"
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
   * Customer's date of birth information builder static inner class.
   */
  public static final class Builder {
    private Integer day;
    private Integer month;
    private Integer year;

    private Builder() {
    }

    /**
     * Day of birth
     * <p>
     * Sets the day and returns a reference to this Builder enabling method chaining.
     *
     * @param day the day to set
     * @return a reference to this Builder
     */
    public Builder day(Integer day) {
      this.day = day;
      return this;
    }

    /**
     * Month of birth
     * <p>
     * Sets the month and returns a reference to this Builder enabling method chaining.
     *
     * @param month the month to set
     * @return a reference to this Builder
     */
    public Builder month(Integer month) {
      this.month = month;
      return this;
    }

    /**
     * Year of birth
     * <p>
     * Sets the year and returns a reference to this Builder enabling method chaining.
     *
     * @param year the year to set
     * @return a reference to this Builder
     */
    public Builder year(Integer year) {
      this.year = year;
      return this;
    }

    /**
     * Returns a DateOfBirth built from the parameters previously set.
     *
     * @return a DateOfBirth built with parameters of this DateOfBirth.Builder
     */
    public DateOfBirth build() {
      return new DateOfBirth(this);
    }
  }
}
