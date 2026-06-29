// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.model.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.paysafe.payments.model.common.enums.HttpMethod;
import com.paysafe.payments.model.paymenthandle.enums.ReturnLinkRel;



/**
 * Link for returning from external payment flows.
 */
public class ReturnLink {

  @JsonProperty("rel")
  private ReturnLinkRel rel;
  @JsonProperty("href")
  private String href;
  @JsonProperty("method")
  private HttpMethod method;

  public ReturnLink() {
    super();
  }

  private ReturnLink(final Builder builder) {
    setRel(builder.rel);
    setHref(builder.href);
    setMethod(builder.method);
  }

  public static Builder builder() {
    return new Builder();
  }


  public ReturnLink rel(ReturnLinkRel rel) {
    this.rel = rel;
    return this;
  }

  /**
   * Get rel
   *
   * @return rel
   */
  public ReturnLinkRel getRel() {
    return rel;
  }

  public void setRel(ReturnLinkRel rel) {
    this.rel = rel;
  }


  public ReturnLink href(String href) {
    this.href = href;
    return this;
  }

  /**
   * URL to redirect the user
   *
   * @return href
   */
  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }


  public ReturnLink method(HttpMethod method) {
    this.method = method;
    return this;
  }

  /**
   * Get method
   *
   * @return method
   */
  public HttpMethod getMethod() {
    return method;
  }

  public void setMethod(HttpMethod method) {
    this.method = method;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ReturnLink returnLink = (ReturnLink) o;
    return Objects.equals(this.rel, returnLink.rel) &&
        Objects.equals(this.href, returnLink.href) &&
        Objects.equals(this.method, returnLink.method);
  }

  @Override
  public int hashCode() {
    return Objects.hash(rel, href, method);
  }

  @Override
  public String toString() {

    return "class ReturnLink {\n"
        + "    rel: " + toIndentedString(rel) + "\n"
        + "    href: " + toIndentedString(href) + "\n"
        + "    method: " + toIndentedString(method) + "\n"
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
   * Link for returning from external payment flows. builder static inner class.
   */
  public static final class Builder {
    private ReturnLinkRel rel;
    private String href;
    private HttpMethod method;

    private Builder() {
    }

    /**
     * Sets the rel and returns a reference to this Builder enabling method chaining.
     *
     * @param rel the rel to set
     * @return a reference to this Builder
     */
    public Builder rel(ReturnLinkRel rel) {
      this.rel = rel;
      return this;
    }

    /**
     * URL to redirect the user
     * <p>
     * Sets the href and returns a reference to this Builder enabling method chaining.
     *
     * @param href the href to set
     * @return a reference to this Builder
     */
    public Builder href(String href) {
      this.href = href;
      return this;
    }

    /**
     * Sets the method and returns a reference to this Builder enabling method chaining.
     *
     * @param method the method to set
     * @return a reference to this Builder
     */
    public Builder method(HttpMethod method) {
      this.method = method;
      return this;
    }

    /**
     * Returns a ReturnLink built from the parameters previously set.
     *
     * @return a ReturnLink built with parameters of this ReturnLink.Builder
     */
    public ReturnLink build() {
      return new ReturnLink(this);
    }
  }
}
