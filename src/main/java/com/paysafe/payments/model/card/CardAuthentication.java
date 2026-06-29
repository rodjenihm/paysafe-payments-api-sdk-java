// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.model.card;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.paysafe.payments.model.card.enums.AuthenticationStatus;
import com.paysafe.payments.model.card.enums.ThreeDResult;
import com.paysafe.payments.model.card.enums.ThreeDsExemptionIndicator;
import com.paysafe.payments.model.card.threeds.Authentication;
import com.paysafe.payments.model.common.error.Error;
import com.paysafe.payments.model.verification.Verification;



/**
 * 3D Secure authentication details for card transactions when using your own 3D Secure service provider
 */
public class CardAuthentication {

  @JsonProperty("id")
  private String id;
  @JsonProperty("eci")
  private String eci;
  @JsonProperty("cavv")
  private String cavv;
  @JsonProperty("xid")
  private String xid;
  @JsonProperty("status")
  private AuthenticationStatus status;
  @JsonProperty("threeDResult")
  private ThreeDResult threeDResult;
  @JsonProperty("directoryServerTransactionId")
  private String directoryServerTransactionId;
  @JsonProperty("threeDSecureVersion")
  private String threeDSecureVersion;
  @JsonProperty("exemptionIndicator")
  private ThreeDsExemptionIndicator exemptionIndicator;
  @JsonProperty("error")
  private Error error;

  public CardAuthentication() {
    super();
  }

  private CardAuthentication(final Builder builder) {
    setId(builder.id);
    setEci(builder.eci);
    setCavv(builder.cavv);
    setXid(builder.xid);
    setStatus(builder.status);
    setThreeDResult(builder.threeDResult);
    setDirectoryServerTransactionId(builder.directoryServerTransactionId);
    setThreeDSecureVersion(builder.threeDSecureVersion);
    setExemptionIndicator(builder.exemptionIndicator);
    setError(builder.error);
  }

  public static Builder builder() {
    return new Builder();
  }


  public CardAuthentication id(String id) {
    this.id = id;
    return this;
  }

  /**
   * This is the ID of authentication, returned in the response.
   *
   * @return id
   */
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public CardAuthentication eci(String eci) {
    this.eci = eci;
    return this;
  }

  /**
   * This is the Electronic Commerce Indicator code, which gets returned by the card issuer indicating whether the cardholder was successfully authenticated. Note that in some cases the eci value includes a leading zero, e.g., 01 or 02. **Visa** - 5 - Identifies a successfully authenticated transaction. - 6 - Identifies an attempts authenticated transaction. - 7 - Identifies a non-authenticated transaction. **Mastercard** - 2 - Identifies a successfully authenticated transaction. - 1 - Identifies an attempts authenticated transaction. - 0 - Identifies a non-authenticated transaction.
   *
   * @return eci
   */
  public String getEci() {
    return eci;
  }

  public void setEci(String eci) {
    this.eci = eci;
  }


  public CardAuthentication cavv(String cavv) {
    this.cavv = cavv;
    return this;
  }

  /**
   * Cardholder Authentication Verification Value
   *
   * @return cavv
   */
  public String getCavv() {
    return cavv;
  }

  public void setCavv(String cavv) {
    this.cavv = cavv;
  }


  public CardAuthentication xid(String xid) {
    this.xid = xid;
    return this;
  }

  /**
   * This is the transaction identifier returned by the card issuer.
   *
   * @return xid
   */
  public String getXid() {
    return xid;
  }

  public void setXid(String xid) {
    this.xid = xid;
  }


  public CardAuthentication status(AuthenticationStatus status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   *
   * @return status
   */
  public AuthenticationStatus getStatus() {
    return status;
  }

  public void setStatus(AuthenticationStatus status) {
    this.status = status;
  }


  public CardAuthentication threeDResult(ThreeDResult threeDResult) {
    this.threeDResult = threeDResult;
    return this;
  }

  /**
   * Get threeDResult
   *
   * @return threeDResult
   */
  public ThreeDResult getThreeDResult() {
    return threeDResult;
  }

  public void setThreeDResult(ThreeDResult threeDResult) {
    this.threeDResult = threeDResult;
  }


  public CardAuthentication directoryServerTransactionId(String directoryServerTransactionId) {
    this.directoryServerTransactionId = directoryServerTransactionId;
    return this;
  }

  /**
   * This is the unique directory server transaction ID required for Mastercard. <br> **Note:** This is field is required when the card brand is Mastercard. This exists only for 3D Secure 2. <br>
   *
   * @return directoryServerTransactionId
   */
  public String getDirectoryServerTransactionId() {
    return directoryServerTransactionId;
  }

  public void setDirectoryServerTransactionId(String directoryServerTransactionId) {
    this.directoryServerTransactionId = directoryServerTransactionId;
  }


  public CardAuthentication threeDSecureVersion(String threeDSecureVersion) {
    this.threeDSecureVersion = threeDSecureVersion;
    return this;
  }

  /**
   * This is the 3D secure protocol version.
   *
   * @return threeDSecureVersion
   */
  public String getThreeDSecureVersion() {
    return threeDSecureVersion;
  }

  public void setThreeDSecureVersion(String threeDSecureVersion) {
    this.threeDSecureVersion = threeDSecureVersion;
  }


  public CardAuthentication exemptionIndicator(ThreeDsExemptionIndicator exemptionIndicator) {
    this.exemptionIndicator = exemptionIndicator;
    return this;
  }

  /**
   * Get exemptionIndicator
   *
   * @return exemptionIndicator
   */
  public ThreeDsExemptionIndicator getExemptionIndicator() {
    return exemptionIndicator;
  }

  public void setExemptionIndicator(ThreeDsExemptionIndicator exemptionIndicator) {
    this.exemptionIndicator = exemptionIndicator;
  }


  public CardAuthentication error(Error error) {
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
    CardAuthentication cardAuthentication = (CardAuthentication) o;
    return Objects.equals(this.id, cardAuthentication.id) &&
        Objects.equals(this.eci, cardAuthentication.eci) &&
        Objects.equals(this.cavv, cardAuthentication.cavv) &&
        Objects.equals(this.xid, cardAuthentication.xid) &&
        Objects.equals(this.status, cardAuthentication.status) &&
        Objects.equals(this.threeDResult, cardAuthentication.threeDResult) &&
        Objects.equals(this.directoryServerTransactionId, cardAuthentication.directoryServerTransactionId) &&
        Objects.equals(this.threeDSecureVersion, cardAuthentication.threeDSecureVersion) &&
        Objects.equals(this.exemptionIndicator, cardAuthentication.exemptionIndicator) &&
        Objects.equals(this.error, cardAuthentication.error);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, eci, cavv, xid, status, threeDResult, directoryServerTransactionId, threeDSecureVersion, exemptionIndicator, error);
  }

  @Override
  public String toString() {

    return "class CardAuthentication {\n"
        + "    id: " + toIndentedString(id) + "\n"
        + "    eci: " + toIndentedString(eci) + "\n"
        + "    cavv: " + toIndentedString(cavv) + "\n"
        + "    xid: " + toIndentedString(xid) + "\n"
        + "    status: " + toIndentedString(status) + "\n"
        + "    threeDResult: " + toIndentedString(threeDResult) + "\n"
        + "    directoryServerTransactionId: " + toIndentedString(directoryServerTransactionId) + "\n"
        + "    threeDSecureVersion: " + toIndentedString(threeDSecureVersion) + "\n"
        + "    exemptionIndicator: " + toIndentedString(exemptionIndicator) + "\n"
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
   * 3D Secure authentication details for card transactions when using your own 3D Secure service provider builder static inner class.
   */
  public static final class Builder {
    private String id;
    private String eci;
    private String cavv;
    private String xid;
    private AuthenticationStatus status;
    private ThreeDResult threeDResult;
    private String directoryServerTransactionId;
    private String threeDSecureVersion;
    private ThreeDsExemptionIndicator exemptionIndicator;
    private Error error;

    private Builder() {
    }

    /**
     * This is the ID of authentication, returned in the response.
     * <p>
     * Sets the id and returns a reference to this Builder enabling method chaining.
     *
     * @param id the id to set
     * @return a reference to this Builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }

    /**
     * This is the Electronic Commerce Indicator code, which gets returned by the card issuer indicating whether the cardholder was successfully authenticated. Note that in some cases the eci value includes a leading zero, e.g., 01 or 02. **Visa** - 5 - Identifies a successfully authenticated transaction. - 6 - Identifies an attempts authenticated transaction. - 7 - Identifies a non-authenticated transaction. **Mastercard** - 2 - Identifies a successfully authenticated transaction. - 1 - Identifies an attempts authenticated transaction. - 0 - Identifies a non-authenticated transaction.
     * <p>
     * Sets the eci and returns a reference to this Builder enabling method chaining.
     *
     * @param eci the eci to set
     * @return a reference to this Builder
     */
    public Builder eci(String eci) {
      this.eci = eci;
      return this;
    }

    /**
     * Cardholder Authentication Verification Value
     * <p>
     * Sets the cavv and returns a reference to this Builder enabling method chaining.
     *
     * @param cavv the cavv to set
     * @return a reference to this Builder
     */
    public Builder cavv(String cavv) {
      this.cavv = cavv;
      return this;
    }

    /**
     * This is the transaction identifier returned by the card issuer.
     * <p>
     * Sets the xid and returns a reference to this Builder enabling method chaining.
     *
     * @param xid the xid to set
     * @return a reference to this Builder
     */
    public Builder xid(String xid) {
      this.xid = xid;
      return this;
    }

    /**
     * Sets the status and returns a reference to this Builder enabling method chaining.
     *
     * @param status the status to set
     * @return a reference to this Builder
     */
    public Builder status(AuthenticationStatus status) {
      this.status = status;
      return this;
    }

    /**
     * Sets the threeDResult and returns a reference to this Builder enabling method chaining.
     *
     * @param threeDResult the threeDResult to set
     * @return a reference to this Builder
     */
    public Builder threeDResult(ThreeDResult threeDResult) {
      this.threeDResult = threeDResult;
      return this;
    }

    /**
     * This is the unique directory server transaction ID required for Mastercard. <br> **Note:** This is field is required when the card brand is Mastercard. This exists only for 3D Secure 2. <br>
     * <p>
     * Sets the directoryServerTransactionId and returns a reference to this Builder enabling method chaining.
     *
     * @param directoryServerTransactionId the directoryServerTransactionId to set
     * @return a reference to this Builder
     */
    public Builder directoryServerTransactionId(String directoryServerTransactionId) {
      this.directoryServerTransactionId = directoryServerTransactionId;
      return this;
    }

    /**
     * This is the 3D secure protocol version.
     * <p>
     * Sets the threeDSecureVersion and returns a reference to this Builder enabling method chaining.
     *
     * @param threeDSecureVersion the threeDSecureVersion to set
     * @return a reference to this Builder
     */
    public Builder threeDSecureVersion(String threeDSecureVersion) {
      this.threeDSecureVersion = threeDSecureVersion;
      return this;
    }

    /**
     * Sets the exemptionIndicator and returns a reference to this Builder enabling method chaining.
     *
     * @param exemptionIndicator the exemptionIndicator to set
     * @return a reference to this Builder
     */
    public Builder exemptionIndicator(ThreeDsExemptionIndicator exemptionIndicator) {
      this.exemptionIndicator = exemptionIndicator;
      return this;
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
     * Returns a CardAuthentication built from the parameters previously set.
     *
     * @return a CardAuthentication built with parameters of this CardAuthentication.Builder
     */
    public CardAuthentication build() {
      return new CardAuthentication(this);
    }
  }
}
