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
import com.paysafe.payments.model.paymenthandle.enums.ReturnLinkRel;



/**
 * URL link to redirect customer during transaction flow.
 */
public class Link {

  @JsonProperty("rel")
  private ReturnLinkRel rel;
  @JsonProperty("href")
  private String href;
  @JsonProperty("method")
  private String method;

  public Link() {
    super();
  }

  private Link(final Builder builder) {
    setRel(builder.rel);
    setHref(builder.href);
    setMethod(builder.method);
  }

  public static Builder builder() {
    return new Builder();
  }


  public Link rel(ReturnLinkRel rel) {
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


  public Link href(String href) {
    this.href = href;
    return this;
  }

  /**
   * The url to be used for further actions
   *
   * @return href
   */
  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }


  public Link method(String method) {
    this.method = method;
    return this;
  }

  /**
   * The corresponding HTTP request method to be invoked on url
   *
   * @return method
   */
  public String getMethod() {
    return method;
  }

  public void setMethod(String method) {
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
    Link link = (Link) o;
    return Objects.equals(this.rel, link.rel) &&
        Objects.equals(this.href, link.href) &&
        Objects.equals(this.method, link.method);
  }

  @Override
  public int hashCode() {
    return Objects.hash(rel, href, method);
  }

  @Override
  public String toString() {

    return "class Link {\n"
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
   * URL link to redirect customer during transaction flow. builder static inner class.
   */
  public static final class Builder {
    private ReturnLinkRel rel;
    private String href;
    private String method;

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
     * The url to be used for further actions
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
     * The corresponding HTTP request method to be invoked on url
     * <p>
     * Sets the method and returns a reference to this Builder enabling method chaining.
     *
     * @param method the method to set
     * @return a reference to this Builder
     */
    public Builder method(String method) {
      this.method = method;
      return this;
    }

    /**
     * Returns a Link built from the parameters previously set.
     *
     * @return a Link built with parameters of this Link.Builder
     */
    public Link build() {
      return new Link(this);
    }
  }
}
