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



/**
 * Details of the device used for the transaction.
 */
public class SdkDeviceDetails {

  @JsonProperty("sdkTransReference")
  private String sdkTransReference;
  @JsonProperty("sdkVersion")
  private String sdkVersion;
  @JsonProperty("sdkReferenceNumber")
  private String sdkReferenceNumber;
  @JsonProperty("applicationId")
  private String applicationId;
  @JsonProperty("deviceIp")
  private String deviceIp;
  @JsonProperty("deviceFingerprint")
  private String deviceFingerprint;
  @JsonProperty("deviceLocation")
  private String deviceLocation;

  public SdkDeviceDetails() {
    super();
  }

  private SdkDeviceDetails(final Builder builder) {
    setSdkTransReference(builder.sdkTransReference);
    setSdkVersion(builder.sdkVersion);
    setSdkReferenceNumber(builder.sdkReferenceNumber);
    setApplicationId(builder.applicationId);
    setDeviceIp(builder.deviceIp);
    setDeviceFingerprint(builder.deviceFingerprint);
    setDeviceLocation(builder.deviceLocation);
  }

  public static Builder builder() {
    return new Builder();
  }


  public SdkDeviceDetails sdkTransReference(String sdkTransReference) {
    this.sdkTransReference = sdkTransReference;
    return this;
  }

  /**
   * The SDK transaction reference
   *
   * @return sdkTransReference
   */
  public String getSdkTransReference() {
    return sdkTransReference;
  }

  public void setSdkTransReference(String sdkTransReference) {
    this.sdkTransReference = sdkTransReference;
  }


  public SdkDeviceDetails sdkVersion(String sdkVersion) {
    this.sdkVersion = sdkVersion;
    return this;
  }

  /**
   * The version of the SDK being used
   *
   * @return sdkVersion
   */
  public String getSdkVersion() {
    return sdkVersion;
  }

  public void setSdkVersion(String sdkVersion) {
    this.sdkVersion = sdkVersion;
  }


  public SdkDeviceDetails sdkReferenceNumber(String sdkReferenceNumber) {
    this.sdkReferenceNumber = sdkReferenceNumber;
    return this;
  }

  /**
   * The SDK reference number
   *
   * @return sdkReferenceNumber
   */
  public String getSdkReferenceNumber() {
    return sdkReferenceNumber;
  }

  public void setSdkReferenceNumber(String sdkReferenceNumber) {
    this.sdkReferenceNumber = sdkReferenceNumber;
  }


  public SdkDeviceDetails applicationId(String applicationId) {
    this.applicationId = applicationId;
    return this;
  }

  /**
   * The identifier for the application making the request
   *
   * @return applicationId
   */
  public String getApplicationId() {
    return applicationId;
  }

  public void setApplicationId(String applicationId) {
    this.applicationId = applicationId;
  }


  public SdkDeviceDetails deviceIp(String deviceIp) {
    this.deviceIp = deviceIp;
    return this;
  }

  /**
   * The IP address of the device
   *
   * @return deviceIp
   */
  public String getDeviceIp() {
    return deviceIp;
  }

  public void setDeviceIp(String deviceIp) {
    this.deviceIp = deviceIp;
  }


  public SdkDeviceDetails deviceFingerprint(String deviceFingerprint) {
    this.deviceFingerprint = deviceFingerprint;
    return this;
  }

  /**
   * The fingerprint of the device
   *
   * @return deviceFingerprint
   */
  public String getDeviceFingerprint() {
    return deviceFingerprint;
  }

  public void setDeviceFingerprint(String deviceFingerprint) {
    this.deviceFingerprint = deviceFingerprint;
  }


  public SdkDeviceDetails deviceLocation(String deviceLocation) {
    this.deviceLocation = deviceLocation;
    return this;
  }

  /**
   * The location of the device
   *
   * @return deviceLocation
   */
  public String getDeviceLocation() {
    return deviceLocation;
  }

  public void setDeviceLocation(String deviceLocation) {
    this.deviceLocation = deviceLocation;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SdkDeviceDetails sdkDeviceDetails = (SdkDeviceDetails) o;
    return Objects.equals(this.sdkTransReference, sdkDeviceDetails.sdkTransReference) &&
        Objects.equals(this.sdkVersion, sdkDeviceDetails.sdkVersion) &&
        Objects.equals(this.sdkReferenceNumber, sdkDeviceDetails.sdkReferenceNumber) &&
        Objects.equals(this.applicationId, sdkDeviceDetails.applicationId) &&
        Objects.equals(this.deviceIp, sdkDeviceDetails.deviceIp) &&
        Objects.equals(this.deviceFingerprint, sdkDeviceDetails.deviceFingerprint) &&
        Objects.equals(this.deviceLocation, sdkDeviceDetails.deviceLocation);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sdkTransReference, sdkVersion, sdkReferenceNumber, applicationId, deviceIp, deviceFingerprint, deviceLocation);
  }

  @Override
  public String toString() {

    return "class SdkDeviceDetails {\n"
        + "    sdkTransReference: " + toIndentedString(sdkTransReference) + "\n"
        + "    sdkVersion: " + toIndentedString(sdkVersion) + "\n"
        + "    sdkReferenceNumber: " + toIndentedString(sdkReferenceNumber) + "\n"
        + "    applicationId: " + toIndentedString(applicationId) + "\n"
        + "    deviceIp: " + toIndentedString(deviceIp) + "\n"
        + "    deviceFingerprint: " + toIndentedString(deviceFingerprint) + "\n"
        + "    deviceLocation: " + toIndentedString(deviceLocation) + "\n"
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
   * Details of the device used for the transaction. builder static inner class.
   */
  public static final class Builder {
    private String sdkTransReference;
    private String sdkVersion;
    private String sdkReferenceNumber;
    private String applicationId;
    private String deviceIp;
    private String deviceFingerprint;
    private String deviceLocation;

    private Builder() {
    }

    /**
     * The SDK transaction reference
     * <p>
     * Sets the sdkTransReference and returns a reference to this Builder enabling method chaining.
     *
     * @param sdkTransReference the sdkTransReference to set
     * @return a reference to this Builder
     */
    public Builder sdkTransReference(String sdkTransReference) {
      this.sdkTransReference = sdkTransReference;
      return this;
    }

    /**
     * The version of the SDK being used
     * <p>
     * Sets the sdkVersion and returns a reference to this Builder enabling method chaining.
     *
     * @param sdkVersion the sdkVersion to set
     * @return a reference to this Builder
     */
    public Builder sdkVersion(String sdkVersion) {
      this.sdkVersion = sdkVersion;
      return this;
    }

    /**
     * The SDK reference number
     * <p>
     * Sets the sdkReferenceNumber and returns a reference to this Builder enabling method chaining.
     *
     * @param sdkReferenceNumber the sdkReferenceNumber to set
     * @return a reference to this Builder
     */
    public Builder sdkReferenceNumber(String sdkReferenceNumber) {
      this.sdkReferenceNumber = sdkReferenceNumber;
      return this;
    }

    /**
     * The identifier for the application making the request
     * <p>
     * Sets the applicationId and returns a reference to this Builder enabling method chaining.
     *
     * @param applicationId the applicationId to set
     * @return a reference to this Builder
     */
    public Builder applicationId(String applicationId) {
      this.applicationId = applicationId;
      return this;
    }

    /**
     * The IP address of the device
     * <p>
     * Sets the deviceIp and returns a reference to this Builder enabling method chaining.
     *
     * @param deviceIp the deviceIp to set
     * @return a reference to this Builder
     */
    public Builder deviceIp(String deviceIp) {
      this.deviceIp = deviceIp;
      return this;
    }

    /**
     * The fingerprint of the device
     * <p>
     * Sets the deviceFingerprint and returns a reference to this Builder enabling method chaining.
     *
     * @param deviceFingerprint the deviceFingerprint to set
     * @return a reference to this Builder
     */
    public Builder deviceFingerprint(String deviceFingerprint) {
      this.deviceFingerprint = deviceFingerprint;
      return this;
    }

    /**
     * The location of the device
     * <p>
     * Sets the deviceLocation and returns a reference to this Builder enabling method chaining.
     *
     * @param deviceLocation the deviceLocation to set
     * @return a reference to this Builder
     */
    public Builder deviceLocation(String deviceLocation) {
      this.deviceLocation = deviceLocation;
      return this;
    }

    /**
     * Returns a SdkDeviceDetails built from the parameters previously set.
     *
     * @return a SdkDeviceDetails built with parameters of this SdkDeviceDetails.Builder
     */
    public SdkDeviceDetails build() {
      return new SdkDeviceDetails(this);
    }
  }
}
