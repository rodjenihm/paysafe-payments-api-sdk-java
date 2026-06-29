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
import com.paysafe.payments.model.card.enums.UserLoginAuthenticationMethod;



/**
 * Cardholder login information for 3DS authentication
 */
public class UserLogin {

  @JsonProperty("authenticationMethod")
  private UserLoginAuthenticationMethod authenticationMethod;
  @JsonProperty("data")
  private String data;
  @JsonProperty("time")
  private String time;

  public UserLogin() {
    super();
  }

  private UserLogin(final Builder builder) {
    setAuthenticationMethod(builder.authenticationMethod);
    setData(builder.data);
    setTime(builder.time);
  }

  public static Builder builder() {
    return new Builder();
  }


  public UserLogin authenticationMethod(UserLoginAuthenticationMethod authenticationMethod) {
    this.authenticationMethod = authenticationMethod;
    return this;
  }

  /**
   * Get authenticationMethod
   *
   * @return authenticationMethod
   */
  public UserLoginAuthenticationMethod getAuthenticationMethod() {
    return authenticationMethod;
  }

  public void setAuthenticationMethod(UserLoginAuthenticationMethod authenticationMethod) {
    this.authenticationMethod = authenticationMethod;
  }


  public UserLogin data(String data) {
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


  public UserLogin time(String time) {
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
    UserLogin userLogin = (UserLogin) o;
    return Objects.equals(this.authenticationMethod, userLogin.authenticationMethod) &&
        Objects.equals(this.data, userLogin.data) &&
        Objects.equals(this.time, userLogin.time);
  }

  @Override
  public int hashCode() {
    return Objects.hash(authenticationMethod, data, time);
  }

  @Override
  public String toString() {

    return "class UserLogin {\n"
        + "    authenticationMethod: " + toIndentedString(authenticationMethod) + "\n"
        + "    data: " + toIndentedString(data) + "\n"
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
   * Cardholder login information for 3DS authentication builder static inner class.
   */
  public static final class Builder {
    private UserLoginAuthenticationMethod authenticationMethod;
    private String data;
    private String time;

    private Builder() {
    }

    /**
     * Sets the authenticationMethod and returns a reference to this Builder enabling method chaining.
     *
     * @param authenticationMethod the authenticationMethod to set
     * @return a reference to this Builder
     */
    public Builder authenticationMethod(UserLoginAuthenticationMethod authenticationMethod) {
      this.authenticationMethod = authenticationMethod;
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
     * Returns a UserLogin built from the parameters previously set.
     *
     * @return a UserLogin built with parameters of this UserLogin.Builder
     */
    public UserLogin build() {
      return new UserLogin(this);
    }
  }
}
