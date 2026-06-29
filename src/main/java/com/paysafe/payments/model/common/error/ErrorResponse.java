// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.model.common.error;

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
 * Error returned as json.
 */
public class ErrorResponse {

  @JsonProperty("error")
  private Error error;

  public ErrorResponse() {
    super();
  }

  private ErrorResponse(final Builder builder) {
    setError(builder.error);
  }

  public static Builder builder() {
    return new Builder();
  }


  public ErrorResponse error(Error error) {
    this.error = error;
    return this;
  }

  /**
   * Get error
   *
   * @return error
   */
  public Error getError() {
    return error;
  }

  public void setError(Error error) {
    this.error = error;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ErrorResponse errorResponse = (ErrorResponse) o;
    return Objects.equals(this.error, errorResponse.error);
  }

  @Override
  public int hashCode() {
    return Objects.hash(error);
  }

  @Override
  public String toString() {

    return "class ErrorResponse {\n"
        + "    error: " + toIndentedString(error) + "\n"
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
   * Error returned as json. builder static inner class.
   */
  public static final class Builder {
    private Error error;

    private Builder() {
    }

    /**
     * Sets the error and returns a reference to this Builder enabling method chaining.
     *
     * @param error the error to set
     * @return a reference to this Builder
     */
    public Builder error(Error error) {
      this.error = error;
      return this;
    }

    /**
     * Returns a ErrorResponse built from the parameters previously set.
     *
     * @return a ErrorResponse built with parameters of this ErrorResponse.Builder
     */
    public ErrorResponse build() {
      return new ErrorResponse(this);
    }
  }
}
