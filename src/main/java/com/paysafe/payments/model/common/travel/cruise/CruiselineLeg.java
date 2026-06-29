// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.model.common.travel.cruise;

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
 * Contains detailed itinerary information for one of the cruise line trip legs. <br>**Note:** This object is only for Cruise line Merchants.
 */
public class CruiselineLeg {

  @JsonProperty("fare")
  private Integer fare;
  @JsonProperty("serviceClass")
  private String serviceClass;
  @JsonProperty("departureCity")
  private String departureCity;
  @JsonProperty("destinationCity")
  private String destinationCity;
  @JsonProperty("departureDate")
  private String departureDate;

  public CruiselineLeg() {
    super();
  }

  private CruiselineLeg(final Builder builder) {
    setFare(builder.fare);
    setServiceClass(builder.serviceClass);
    setDepartureCity(builder.departureCity);
    setDestinationCity(builder.destinationCity);
    setDepartureDate(builder.departureDate);
  }

  public static Builder builder() {
    return new Builder();
  }


  public CruiselineLeg fare(Integer fare) {
    this.fare = fare;
    return this;
  }

  /**
   * Indicates the total fare applied to a specific leg. Required during settlement request for integration with TSYS processor
   *
   * @return fare
   */
  public Integer getFare() {
    return fare;
  }

  public void setFare(Integer fare) {
    this.fare = fare;
  }


  public CruiselineLeg serviceClass(String serviceClass) {
    this.serviceClass = serviceClass;
    return this;
  }

  /**
   * Indicates service class (first class, business class, etc.). Example values (not limited to) F - first class, J - business class, W - premium economy class, Y - economy class. Required during settlement request for integration with TSYS processor
   *
   * @return serviceClass
   */
  public String getServiceClass() {
    return serviceClass;
  }

  public void setServiceClass(String serviceClass) {
    this.serviceClass = serviceClass;
  }


  public CruiselineLeg departureCity(String departureCity) {
    this.departureCity = departureCity;
    return this;
  }

  /**
   * Departure City where the trip originates.  [UN/LOCODE](https://unece.org/trade/cefact/unlocode-code-list-country-and-territory) expected.  * Required during settlement request for integration with TSYS processor
   *
   * @return departureCity
   */
  public String getDepartureCity() {
    return departureCity;
  }

  public void setDepartureCity(String departureCity) {
    this.departureCity = departureCity;
  }


  public CruiselineLeg destinationCity(String destinationCity) {
    this.destinationCity = destinationCity;
    return this;
  }

  /**
   * Destination City where the trip ends.  [UN/LOCODE](https://unece.org/trade/cefact/unlocode-code-list-country-and-territory) expected.  * Required during authorization request with AMEX for integration with TSYS processor * Required during settlement request with Visa or Mastercard for integration with TSYS processor
   *
   * @return destinationCity
   */
  public String getDestinationCity() {
    return destinationCity;
  }

  public void setDestinationCity(String destinationCity) {
    this.destinationCity = destinationCity;
  }


  public CruiselineLeg departureDate(String departureDate) {
    this.departureDate = departureDate;
    return this;
  }

  /**
   * Date of passenger's departure for this leg. Date format YYYY-MM-DD, ISO 8601 expected. For example, 2014-01-26
   *
   * @return departureDate
   */
  public String getDepartureDate() {
    return departureDate;
  }

  public void setDepartureDate(String departureDate) {
    this.departureDate = departureDate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CruiselineLeg cruiselineLeg = (CruiselineLeg) o;
    return Objects.equals(this.fare, cruiselineLeg.fare) &&
        Objects.equals(this.serviceClass, cruiselineLeg.serviceClass) &&
        Objects.equals(this.departureCity, cruiselineLeg.departureCity) &&
        Objects.equals(this.destinationCity, cruiselineLeg.destinationCity) &&
        Objects.equals(this.departureDate, cruiselineLeg.departureDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fare, serviceClass, departureCity, destinationCity, departureDate);
  }

  @Override
  public String toString() {

    return "class CruiselineLeg {\n"
        + "    fare: " + toIndentedString(fare) + "\n"
        + "    serviceClass: " + toIndentedString(serviceClass) + "\n"
        + "    departureCity: " + toIndentedString(departureCity) + "\n"
        + "    destinationCity: " + toIndentedString(destinationCity) + "\n"
        + "    departureDate: " + toIndentedString(departureDate) + "\n"
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
   * Contains detailed itinerary information for one of the cruise line trip legs. <br>**Note:** This object is only for Cruise line Merchants. builder static inner class.
   */
  public static final class Builder {
    private Integer fare;
    private String serviceClass;
    private String departureCity;
    private String destinationCity;
    private String departureDate;

    private Builder() {
    }

    /**
     * Indicates the total fare applied to a specific leg. Required during settlement request for integration with TSYS processor
     * <p>
     * Sets the fare and returns a reference to this Builder enabling method chaining.
     *
     * @param fare the fare to set
     * @return a reference to this Builder
     */
    public Builder fare(Integer fare) {
      this.fare = fare;
      return this;
    }

    /**
     * Indicates service class (first class, business class, etc.). Example values (not limited to) F - first class, J - business class, W - premium economy class, Y - economy class. Required during settlement request for integration with TSYS processor
     * <p>
     * Sets the serviceClass and returns a reference to this Builder enabling method chaining.
     *
     * @param serviceClass the serviceClass to set
     * @return a reference to this Builder
     */
    public Builder serviceClass(String serviceClass) {
      this.serviceClass = serviceClass;
      return this;
    }

    /**
     * Departure City where the trip originates.  [UN/LOCODE](https://unece.org/trade/cefact/unlocode-code-list-country-and-territory) expected.  * Required during settlement request for integration with TSYS processor
     * <p>
     * Sets the departureCity and returns a reference to this Builder enabling method chaining.
     *
     * @param departureCity the departureCity to set
     * @return a reference to this Builder
     */
    public Builder departureCity(String departureCity) {
      this.departureCity = departureCity;
      return this;
    }

    /**
     * Destination City where the trip ends.  [UN/LOCODE](https://unece.org/trade/cefact/unlocode-code-list-country-and-territory) expected.  * Required during authorization request with AMEX for integration with TSYS processor * Required during settlement request with Visa or Mastercard for integration with TSYS processor
     * <p>
     * Sets the destinationCity and returns a reference to this Builder enabling method chaining.
     *
     * @param destinationCity the destinationCity to set
     * @return a reference to this Builder
     */
    public Builder destinationCity(String destinationCity) {
      this.destinationCity = destinationCity;
      return this;
    }

    /**
     * Date of passenger's departure for this leg. Date format YYYY-MM-DD, ISO 8601 expected. For example, 2014-01-26
     * <p>
     * Sets the departureDate and returns a reference to this Builder enabling method chaining.
     *
     * @param departureDate the departureDate to set
     * @return a reference to this Builder
     */
    public Builder departureDate(String departureDate) {
      this.departureDate = departureDate;
      return this;
    }

    /**
     * Returns a CruiselineLeg built from the parameters previously set.
     *
     * @return a CruiselineLeg built with parameters of this CruiselineLeg.Builder
     */
    public CruiselineLeg build() {
      return new CruiselineLeg(this);
    }
  }
}
