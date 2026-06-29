// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.model.card.threeds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.paysafe.payments.model.card.enums.PriorThreeDsAuthenticationMethod;



/**
 * Previous authentication information used with current merchant, cardholder and card
 */
public class PriorThreedsAuthentication {

  @JsonProperty("id")
  private String id;
  @JsonProperty("data")
  private String data;
  @JsonProperty("method")
  private PriorThreeDsAuthenticationMethod method;
  @JsonProperty("time")
  private String time;

  public PriorThreedsAuthentication() {
    super();
  }

  private PriorThreedsAuthentication(final Builder builder) {
    setId(builder.id);
    setData(builder.data);
    setMethod(builder.method);
    setTime(builder.time);
  }

  public static Builder builder() {
    return new Builder();
  }


  public PriorThreedsAuthentication id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Previous authentication ID for the cardholder. For recurring payments, this is the authenticationId of the first authentication
   *
   * @return id
   */
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public PriorThreedsAuthentication data(String data) {
    this.data = data;
    return this;
  }

  /**
   * Field reserved for future iterations of 3D Secure 2
   *
   * @return data
   */
  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }


  public PriorThreedsAuthentication method(PriorThreeDsAuthenticationMethod method) {
    this.method = method;
    return this;
  }

  /**
   * Get method
   *
   * @return method
   */
  public PriorThreeDsAuthenticationMethod getMethod() {
    return method;
  }

  public void setMethod(PriorThreeDsAuthenticationMethod method) {
    this.method = method;
  }


  public PriorThreedsAuthentication time(String time) {
    this.time = time;
    return this;
  }

  /**
   * Date and time of the cardholder authentication in ISO 8601 format (YYYY-MM-DD-THH:MM:SSZ)
   *
   * @return time
   */
  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PriorThreedsAuthentication priorThreedsAuthentication = (PriorThreedsAuthentication) o;
    return Objects.equals(this.id, priorThreedsAuthentication.id) &&
        Objects.equals(this.data, priorThreedsAuthentication.data) &&
        Objects.equals(this.method, priorThreedsAuthentication.method) &&
        Objects.equals(this.time, priorThreedsAuthentication.time);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, data, method, time);
  }

  @Override
  public String toString() {

    return "class PriorThreedsAuthentication {\n"
        + "    id: " + toIndentedString(id) + "\n"
        + "    data: " + toIndentedString(data) + "\n"
        + "    method: " + toIndentedString(method) + "\n"
        + "    time: " + toIndentedString(time) + "\n"
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
   * Previous authentication information used with current merchant, cardholder and card builder static inner class.
   */
  public static final class Builder {
    private String id;
    private String data;
    private PriorThreeDsAuthenticationMethod method;
    private String time;

    private Builder() {
    }

    /**
     * Previous authentication ID for the cardholder. For recurring payments, this is the authenticationId of the first authentication
     * <p>
     * Sets the id and returns a reference to this Builder enabling method chaining.
     *
     * @param id the id to set
     * @return a reference to this Builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }

    /**
     * Field reserved for future iterations of 3D Secure 2
     * <p>
     * Sets the data and returns a reference to this Builder enabling method chaining.
     *
     * @param data the data to set
     * @return a reference to this Builder
     */
    public Builder data(String data) {
      this.data = data;
      return this;
    }

    /**
     * Sets the method and returns a reference to this Builder enabling method chaining.
     *
     * @param method the method to set
     * @return a reference to this Builder
     */
    public Builder method(PriorThreeDsAuthenticationMethod method) {
      this.method = method;
      return this;
    }

    /**
     * Date and time of the cardholder authentication in ISO 8601 format (YYYY-MM-DD-THH:MM:SSZ)
     * <p>
     * Sets the time and returns a reference to this Builder enabling method chaining.
     *
     * @param time the time to set
     * @return a reference to this Builder
     */
    public Builder time(String time) {
      this.time = time;
      return this;
    }

    /**
     * Returns a PriorThreedsAuthentication built from the parameters previously set.
     *
     * @return a PriorThreedsAuthentication built with parameters of this PriorThreedsAuthentication.Builder
     */
    public PriorThreedsAuthentication build() {
      return new PriorThreedsAuthentication(this);
    }
  }
}
