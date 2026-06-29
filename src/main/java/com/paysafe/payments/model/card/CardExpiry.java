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
 * Card expiration details.
 */
public class CardExpiry {

  @JsonProperty("month")
  private Integer month;
  @JsonProperty("year")
  private Integer year;

  public CardExpiry() {
    super();
  }

  private CardExpiry(final Builder builder) {
    setMonth(builder.month);
    setYear(builder.year);
  }

  public static Builder builder() {
    return new Builder();
  }


  public CardExpiry month(Integer month) {
    this.month = month;
    return this;
  }

  /**
   * The expiry month of the card (1-12)
   *
   * @return month
   */
  public Integer getMonth() {
    return month;
  }

  public void setMonth(Integer month) {
    this.month = month;
  }


  public CardExpiry year(Integer year) {
    this.year = year;
    return this;
  }

  /**
   * The expiry year of the card (e.g., 2025)
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
    CardExpiry cardExpiry = (CardExpiry) o;
    return Objects.equals(this.month, cardExpiry.month) &&
        Objects.equals(this.year, cardExpiry.year);
  }

  @Override
  public int hashCode() {
    return Objects.hash(month, year);
  }

  @Override
  public String toString() {

    return "class CardExpiry {\n"
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
   * Card expiration details. builder static inner class.
   */
  public static final class Builder {
    private Integer month;
    private Integer year;

    private Builder() {
    }

    /**
     * The expiry month of the card (1-12)
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
     * The expiry year of the card (e.g., 2025)
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
     * Returns a CardExpiry built from the parameters previously set.
     *
     * @return a CardExpiry built with parameters of this CardExpiry.Builder
     */
    public CardExpiry build() {
      return new CardExpiry(this);
    }
  }
}
