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
import com.paysafe.payments.model.card.enums.BrowserColorDepth;



/**
 * Details about the customer's browser.
 */
public class BrowserDetails {

  @JsonProperty("acceptHeader")
  private String acceptHeader;
  @JsonProperty("colorDepthBits")
  private BrowserColorDepth colorDepthBits;
  @JsonProperty("javaEnabled")
  private Boolean javaEnabled;
  @JsonProperty("javaScriptEnabled")
  private Boolean javaScriptEnabled;
  @JsonProperty("language")
  private String language;
  @JsonProperty("screenHeight")
  private Integer screenHeight;
  @JsonProperty("screenWidth")
  private Integer screenWidth;
  @JsonProperty("timeZoneOffset")
  private Integer timeZoneOffset;
  @JsonProperty("userAgent")
  private String userAgent;

  public BrowserDetails() {
    super();
  }

  private BrowserDetails(final Builder builder) {
    setAcceptHeader(builder.acceptHeader);
    setColorDepthBits(builder.colorDepthBits);
    setJavaEnabled(builder.javaEnabled);
    setJavaScriptEnabled(builder.javaScriptEnabled);
    setLanguage(builder.language);
    setScreenHeight(builder.screenHeight);
    setScreenWidth(builder.screenWidth);
    setTimeZoneOffset(builder.timeZoneOffset);
    setUserAgent(builder.userAgent);
  }

  public static Builder builder() {
    return new Builder();
  }


  public BrowserDetails acceptHeader(String acceptHeader) {
    this.acceptHeader = acceptHeader;
    return this;
  }

  /**
   * This is the exact content of the HTTP accept header as sent to the 3DS Requestor from the cardholder’s browser.
   *
   * @return acceptHeader
   */
  public String getAcceptHeader() {
    return acceptHeader;
  }

  public void setAcceptHeader(String acceptHeader) {
    this.acceptHeader = acceptHeader;
  }


  public BrowserDetails colorDepthBits(BrowserColorDepth colorDepthBits) {
    this.colorDepthBits = colorDepthBits;
    return this;
  }

  /**
   * Get colorDepthBits
   *
   * @return colorDepthBits
   */
  public BrowserColorDepth getColorDepthBits() {
    return colorDepthBits;
  }

  public void setColorDepthBits(BrowserColorDepth colorDepthBits) {
    this.colorDepthBits = colorDepthBits;
  }


  public BrowserDetails javaEnabled(Boolean javaEnabled) {
    this.javaEnabled = javaEnabled;
    return this;
  }

  /**
   * Indicates if Java is enabled in the browser
   *
   * @return javaEnabled
   */
  public Boolean getJavaEnabled() {
    return javaEnabled;
  }

  public void setJavaEnabled(Boolean javaEnabled) {
    this.javaEnabled = javaEnabled;
  }


  public BrowserDetails javaScriptEnabled(Boolean javaScriptEnabled) {
    this.javaScriptEnabled = javaScriptEnabled;
    return this;
  }

  /**
   * Indicates if JavaScript is enabled in the browser
   *
   * @return javaScriptEnabled
   */
  public Boolean getJavaScriptEnabled() {
    return javaScriptEnabled;
  }

  public void setJavaScriptEnabled(Boolean javaScriptEnabled) {
    this.javaScriptEnabled = javaScriptEnabled;
  }


  public BrowserDetails language(String language) {
    this.language = language;
    return this;
  }

  /**
   * The browser language
   *
   * @return language
   */
  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }


  public BrowserDetails screenHeight(Integer screenHeight) {
    this.screenHeight = screenHeight;
    return this;
  }

  /**
   * The screen height in pixels
   *
   * @return screenHeight
   */
  public Integer getScreenHeight() {
    return screenHeight;
  }

  public void setScreenHeight(Integer screenHeight) {
    this.screenHeight = screenHeight;
  }


  public BrowserDetails screenWidth(Integer screenWidth) {
    this.screenWidth = screenWidth;
    return this;
  }

  /**
   * The screen width in pixels
   *
   * @return screenWidth
   */
  public Integer getScreenWidth() {
    return screenWidth;
  }

  public void setScreenWidth(Integer screenWidth) {
    this.screenWidth = screenWidth;
  }


  public BrowserDetails timeZoneOffset(Integer timeZoneOffset) {
    this.timeZoneOffset = timeZoneOffset;
    return this;
  }

  /**
   * This is the date and time the request was processed. The ISO 8601 date format is expected, i.e., YYYY-MM-DD-THH:MM:SSZ.
   *
   * @return timeZoneOffset
   */
  public Integer getTimeZoneOffset() {
    return timeZoneOffset;
  }

  public void setTimeZoneOffset(Integer timeZoneOffset) {
    this.timeZoneOffset = timeZoneOffset;
  }


  public BrowserDetails userAgent(String userAgent) {
    this.userAgent = userAgent;
    return this;
  }

  /**
   * The browser user agent string
   *
   * @return userAgent
   */
  public String getUserAgent() {
    return userAgent;
  }

  public void setUserAgent(String userAgent) {
    this.userAgent = userAgent;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BrowserDetails browserDetails = (BrowserDetails) o;
    return Objects.equals(this.acceptHeader, browserDetails.acceptHeader) &&
        Objects.equals(this.colorDepthBits, browserDetails.colorDepthBits) &&
        Objects.equals(this.javaEnabled, browserDetails.javaEnabled) &&
        Objects.equals(this.javaScriptEnabled, browserDetails.javaScriptEnabled) &&
        Objects.equals(this.language, browserDetails.language) &&
        Objects.equals(this.screenHeight, browserDetails.screenHeight) &&
        Objects.equals(this.screenWidth, browserDetails.screenWidth) &&
        Objects.equals(this.timeZoneOffset, browserDetails.timeZoneOffset) &&
        Objects.equals(this.userAgent, browserDetails.userAgent);
  }

  @Override
  public int hashCode() {
    return Objects.hash(acceptHeader, colorDepthBits, javaEnabled, javaScriptEnabled, language, screenHeight, screenWidth, timeZoneOffset, userAgent);
  }

  @Override
  public String toString() {

    return "class BrowserDetails {\n"
        + "    acceptHeader: " + toIndentedString(acceptHeader) + "\n"
        + "    colorDepthBits: " + toIndentedString(colorDepthBits) + "\n"
        + "    javaEnabled: " + toIndentedString(javaEnabled) + "\n"
        + "    javaScriptEnabled: " + toIndentedString(javaScriptEnabled) + "\n"
        + "    language: " + toIndentedString(language) + "\n"
        + "    screenHeight: " + toIndentedString(screenHeight) + "\n"
        + "    screenWidth: " + toIndentedString(screenWidth) + "\n"
        + "    timeZoneOffset: " + toIndentedString(timeZoneOffset) + "\n"
        + "    userAgent: " + toIndentedString(userAgent) + "\n"
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
   * Details about the customer's browser. builder static inner class.
   */
  public static final class Builder {
    private String acceptHeader;
    private BrowserColorDepth colorDepthBits;
    private Boolean javaEnabled;
    private Boolean javaScriptEnabled;
    private String language;
    private Integer screenHeight;
    private Integer screenWidth;
    private Integer timeZoneOffset;
    private String userAgent;

    private Builder() {
    }

    /**
     * This is the exact content of the HTTP accept header as sent to the 3DS Requestor from the cardholder’s browser.
     * <p>
     * Sets the acceptHeader and returns a reference to this Builder enabling method chaining.
     *
     * @param acceptHeader the acceptHeader to set
     * @return a reference to this Builder
     */
    public Builder acceptHeader(String acceptHeader) {
      this.acceptHeader = acceptHeader;
      return this;
    }

    /**
     * Sets the colorDepthBits and returns a reference to this Builder enabling method chaining.
     *
     * @param colorDepthBits the colorDepthBits to set
     * @return a reference to this Builder
     */
    public Builder colorDepthBits(BrowserColorDepth colorDepthBits) {
      this.colorDepthBits = colorDepthBits;
      return this;
    }

    /**
     * Indicates if Java is enabled in the browser
     * <p>
     * Sets the javaEnabled and returns a reference to this Builder enabling method chaining.
     *
     * @param javaEnabled the javaEnabled to set
     * @return a reference to this Builder
     */
    public Builder javaEnabled(Boolean javaEnabled) {
      this.javaEnabled = javaEnabled;
      return this;
    }

    /**
     * Indicates if JavaScript is enabled in the browser
     * <p>
     * Sets the javaScriptEnabled and returns a reference to this Builder enabling method chaining.
     *
     * @param javaScriptEnabled the javaScriptEnabled to set
     * @return a reference to this Builder
     */
    public Builder javaScriptEnabled(Boolean javaScriptEnabled) {
      this.javaScriptEnabled = javaScriptEnabled;
      return this;
    }

    /**
     * The browser language
     * <p>
     * Sets the language and returns a reference to this Builder enabling method chaining.
     *
     * @param language the language to set
     * @return a reference to this Builder
     */
    public Builder language(String language) {
      this.language = language;
      return this;
    }

    /**
     * The screen height in pixels
     * <p>
     * Sets the screenHeight and returns a reference to this Builder enabling method chaining.
     *
     * @param screenHeight the screenHeight to set
     * @return a reference to this Builder
     */
    public Builder screenHeight(Integer screenHeight) {
      this.screenHeight = screenHeight;
      return this;
    }

    /**
     * The screen width in pixels
     * <p>
     * Sets the screenWidth and returns a reference to this Builder enabling method chaining.
     *
     * @param screenWidth the screenWidth to set
     * @return a reference to this Builder
     */
    public Builder screenWidth(Integer screenWidth) {
      this.screenWidth = screenWidth;
      return this;
    }

    /**
     * This is the date and time the request was processed. The ISO 8601 date format is expected, i.e., YYYY-MM-DD-THH:MM:SSZ.
     * <p>
     * Sets the timeZoneOffset and returns a reference to this Builder enabling method chaining.
     *
     * @param timeZoneOffset the timeZoneOffset to set
     * @return a reference to this Builder
     */
    public Builder timeZoneOffset(Integer timeZoneOffset) {
      this.timeZoneOffset = timeZoneOffset;
      return this;
    }

    /**
     * The browser user agent string
     * <p>
     * Sets the userAgent and returns a reference to this Builder enabling method chaining.
     *
     * @param userAgent the userAgent to set
     * @return a reference to this Builder
     */
    public Builder userAgent(String userAgent) {
      this.userAgent = userAgent;
      return this;
    }

    /**
     * Returns a BrowserDetails built from the parameters previously set.
     *
     * @return a BrowserDetails built with parameters of this BrowserDetails.Builder
     */
    public BrowserDetails build() {
      return new BrowserDetails(this);
    }
  }
}
