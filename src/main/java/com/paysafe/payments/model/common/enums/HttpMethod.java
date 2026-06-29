// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.model.common.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * HTTP method for the redirect.
 */
public enum HttpMethod {

  GET("GET"),

  POST("POST");

  private final String value;

  HttpMethod(String value) {
    this.value = value;
  }

  @JsonCreator
  public static HttpMethod fromValue(String value) {
    for (HttpMethod b : HttpMethod.values()) {
      if (b.value.equalsIgnoreCase(value)) {
        return b;
      }
    }
    return null;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }
}
