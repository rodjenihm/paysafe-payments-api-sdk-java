// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.api;

import com.paysafe.payments.model.common.enums.PaymentSimulator;

/**
 * This class is used to define configuration for each request. Fields that may be modified per request: <ul>
 * <li>connectTimeout: maximum time allowed to establish connection to Paysafe API, in milliseconds. Default: 30000</li>
 * <li>responseTimeout: maximum time allowed to read the data from established connection, in milliseconds. Default: 6000</li>
 * <li>maxAutomaticRetries: the number of times that the request will be automatically retried in case of ApiConnectionException.
 * In case of other exceptions, the request will not be retried.  <br>
 * Default: 0  <br>
 * Maximum allowed value: 5</li>
 * <li>simulator: The simulator is only applicable in the test environment and its default value is set as EXTERNAL.
 * In the production environment, the simulator value is disregarded, even if provided, and the experience will be the same as
 * if the simulator value were set as EXTERNAL.</li>
 * </ul>
 *
 * <p>Any field left unset will fall back to the corresponding default value.</p>
 *
 * <p>The recommended way to create instances is via the fluent builder:</p>
 * <pre>{@code
 * RequestOptions options = RequestOptions.builder()
 *     .connectTimeout(5000)
 *     .responseTimeout(10000)
 *     .automaticRetries(3)
 *     .simulator(PaymentSimulator.INTERNAL)
 *     .build();
 * }</pre>
 */
public class RequestOptions {

  private Integer connectTimeout;
  private Integer responseTimeout;
  private Integer maxAutomaticRetries;
  private PaymentSimulator simulator = PaymentSimulator.EXTERNAL;

  /**
   * Creates a new {@code RequestOptions} instance with all fields unset.
   * Default values will be applied when the request is executed.
   */
  public RequestOptions() {
  }

  private RequestOptions(Builder builder) {
    connectTimeout = builder.connectionTimeout;
    responseTimeout = builder.responseTimeout;
    maxAutomaticRetries = builder.maxAutomaticRetries;
    simulator = builder.simulator;
  }

  /**
   * Returns a new {@link Builder} for constructing a {@code RequestOptions} instance.
   *
   * @return a new {@code Builder}
   */
  public static Builder builder() {
    return new Builder();
  }

  /**
   * Returns the maximum time allowed to establish a connection, in milliseconds.
   *
   * @return the connect timeout, or {@code null} if not set (default will be used)
   */
  public Integer getConnectTimeout() {
    return connectTimeout;
  }

  /**
   * Sets the maximum time allowed to establish a connection, in milliseconds.
   *
   * @param connectTimeout the connect timeout in milliseconds
   */
  public void setConnectTimeout(Integer connectTimeout) {
    this.connectTimeout = connectTimeout;
  }

  /**
   * Returns the maximum time allowed to read data from an established connection, in milliseconds.
   *
   * @return the response timeout, or {@code null} if not set (default will be used)
   */
  public Integer getResponseTimeout() {
    return responseTimeout;
  }

  /**
   * Sets the maximum time allowed to read data from an established connection, in milliseconds.
   *
   * @param responseTimeout the response timeout in milliseconds
   */
  public void setResponseTimeout(Integer responseTimeout) {
    this.responseTimeout = responseTimeout;
  }

  /**
   * Returns the maximum number of automatic retries on connection failure.
   *
   * @return the max automatic retries, or {@code null} if not set (default will be used)
   */
  public Integer getMaxAutomaticRetries() {
    return maxAutomaticRetries;
  }

  /**
   * Sets the maximum number of automatic retries on {@code ApiConnectionException}.
   * Other exception types will not trigger a retry. Maximum allowed value is {@code 5}.
   *
   * @param maxAutomaticRetries the number of retries; must be between {@code 0} and {@code 5}
   */
  public void setMaxAutomaticRetries(Integer maxAutomaticRetries) {
    this.maxAutomaticRetries = maxAutomaticRetries;
  }

  /**
   * Returns the simulator setting for this request.
   *
   * @return the {@link PaymentSimulator} value, or {@code null} if not set
   */
  public PaymentSimulator getSimulator() {
    return simulator;
  }

  /**
   * Sets the simulator for this request. Only applicable in the test environment.
   * In production, this value is ignored.
   *
   * @param simulator the {@link PaymentSimulator} to use
   */
  public void setSimulator(final PaymentSimulator simulator) {
    this.simulator = simulator;
  }

  /**
   * Builder for constructing {@link RequestOptions} instances using a fluent API.
   */
  public static final class Builder {
    private Integer connectionTimeout;
    private Integer responseTimeout;
    private Integer maxAutomaticRetries;
    private PaymentSimulator simulator;

    private Builder() {
    }

    /**
     * Sets the connect timeout and returns this builder for chaining.
     *
     * @param connectionTimeout maximum time to establish a connection, in milliseconds
     * @return this builder
     */
    public Builder connectTimeout(Integer connectionTimeout) {
      this.connectionTimeout = connectionTimeout;
      return this;
    }

    /**
     * Sets the response timeout and returns this builder for chaining.
     *
     * @param responseTimeout maximum time to read data from an established connection, in milliseconds
     * @return this builder
     */
    public Builder responseTimeout(Integer responseTimeout) {
      this.responseTimeout = responseTimeout;
      return this;
    }

    /**
     * Sets the maximum number of automatic retries on {@code ApiConnectionException} and returns this builder for chaining.
     * Maximum allowed value is {@code 5}.
     *
     * @param maxAutomaticRetries the number of retries; must be between {@code 0} and {@code 5}
     * @return this builder
     */
    public Builder automaticRetries(Integer maxAutomaticRetries) {
      this.maxAutomaticRetries = maxAutomaticRetries;
      return this;
    }

    /**
     * Sets the simulator and returns this builder for chaining.
     * Only applicable in the test environment; ignored in production.
     *
     * @param simulator the {@link PaymentSimulator} to use
     * @return this builder
     */
    public Builder simulator(PaymentSimulator simulator) {
      this.simulator = simulator;
      return this;
    }

    /**
     * Builds and returns a {@link RequestOptions} instance with the configured values.
     *
     * @return a new {@code RequestOptions} instance
     */
    public RequestOptions build() {
      return new RequestOptions(this);
    }
  }
}
