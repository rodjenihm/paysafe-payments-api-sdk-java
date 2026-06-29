// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.api;

import java.util.HashMap;
import java.util.Map;

/**
 * Options for making a raw HTTP request, including custom headers and request options.
 * Extends {@link RequestOptions} with the ability to attach arbitrary HTTP headers to a request.
 *
 * <p>Custom headers can be used to pass additional metadata or authentication information
 * that is not covered by the standard {@link RequestOptions} fields.</p>
 */
public class DirectRequestOptions extends RequestOptions {
  private Map<String, String> customHeaders = new HashMap<>();

  /**
   * Creates a new {@code DirectRequestOptions} instance with no custom headers
   * and default values inherited from {@link RequestOptions}.
   */
  public DirectRequestOptions() {
    super();
  }

  /**
   * Creates a new {@code DirectRequestOptions} instance with the given custom headers
   * and default values inherited from {@link RequestOptions}.
   *
   * @param customHeaders a map of header names to header values to include in the request;
   *                      if null, no custom headers will be added
   */
  public DirectRequestOptions(Map<String, String> customHeaders) {
    super();
    if (customHeaders != null) {
      this.customHeaders.putAll(customHeaders);
    }
  }

  /**
   * Returns the custom headers that will be included in the request.
   *
   * @return a map of header names to header values
   */
  public Map<String, String> getCustomHeaders() {
    return customHeaders;
  }

  /**
   * Replaces all custom headers with the given map.
   *
   * @param customHeaders a map of header names to header values; replaces any previously set headers
   */
  public void setCustomHeaders(Map<String, String> customHeaders) {
    this.customHeaders = customHeaders;
  }

  /**
   * Adds a single custom header to this request options instance.
   * If a header with the same key already exists, its value will be overwritten.
   *
   * @param key   the header name
   * @param value the header value
   * @return this {@code DirectRequestOptions} instance, for method chaining
   */
  public DirectRequestOptions addHeader(String key, String value) {
    this.customHeaders.put(key, value);
    return this;
  }
}
