// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.model.monitor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.paysafe.payments.model.monitor.enums.ServiceStatus;



/**
 * The response returned by /v1/monitor endpoint.
 */
public class MonitorResponse {

  @JsonProperty("status")
  private ServiceStatus status;

  public MonitorResponse() {
    super();
  }

  private MonitorResponse(final Builder builder) {
    setStatus(builder.status);
  }

  public static Builder builder() {
    return new Builder();
  }


  public MonitorResponse status(ServiceStatus status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   *
   * @return status
   */
  public ServiceStatus getStatus() {
    return status;
  }

  public void setStatus(ServiceStatus status) {
    this.status = status;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MonitorResponse monitorResponse = (MonitorResponse) o;
    return Objects.equals(this.status, monitorResponse.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status);
  }

  @Override
  public String toString() {

    return "class MonitorResponse {\n"
        + "    status: " + toIndentedString(status) + "\n"
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
   * The response returned by /v1/monitor endpoint. builder static inner class.
   */
  public static final class Builder {
    private ServiceStatus status;

    private Builder() {
    }

    /**
     * Sets the status and returns a reference to this Builder enabling method chaining.
     *
     * @param status the status to set
     * @return a reference to this Builder
     */
    public Builder status(ServiceStatus status) {
      this.status = status;
      return this;
    }

    /**
     * Returns a MonitorResponse built from the parameters previously set.
     *
     * @return a MonitorResponse built with parameters of this MonitorResponse.Builder
     */
    public MonitorResponse build() {
      return new MonitorResponse(this);
    }
  }
}
