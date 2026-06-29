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
import com.paysafe.payments.model.card.enums.AuthenticationStatus;
import com.paysafe.payments.model.card.enums.ThreeDEnrollment;
import com.paysafe.payments.model.card.enums.ThreeDResult;
import com.paysafe.payments.model.card.enums.ThreeDSignatureStatus;
import com.paysafe.payments.model.card.enums.ThreeDsExemptionIndicator;
import com.paysafe.payments.model.verification.Verification;



/**
 * Authentication details for a payment.
 */
public class Authentication {

  @JsonProperty("id")
  private String id;
  @JsonProperty("eci")
  private Integer eci;
  @JsonProperty("cavv")
  private String cavv;
  @JsonProperty("xid")
  private String xid;
  @JsonProperty("status")
  private AuthenticationStatus status;
  @JsonProperty("merchantRefNum")
  private String merchantRefNum;
  @JsonProperty("threeDEnrollment")
  private ThreeDEnrollment threeDEnrollment;
  @JsonProperty("directoryServerTransactionId")
  private String directoryServerTransactionId;
  @JsonProperty("threeDSecureVersion")
  private String threeDSecureVersion;
  @JsonProperty("threeDResult")
  private ThreeDResult threeDResult;
  @JsonProperty("signatureStatus")
  private ThreeDSignatureStatus signatureStatus;
  @JsonProperty("exemptionIndicator")
  private ThreeDsExemptionIndicator exemptionIndicator;

  public Authentication() {
    super();
  }

  private Authentication(final Builder builder) {
    setId(builder.id);
    setEci(builder.eci);
    setCavv(builder.cavv);
    setXid(builder.xid);
    setStatus(builder.status);
    setMerchantRefNum(builder.merchantRefNum);
    setThreeDEnrollment(builder.threeDEnrollment);
    setDirectoryServerTransactionId(builder.directoryServerTransactionId);
    setThreeDSecureVersion(builder.threeDSecureVersion);
    setThreeDResult(builder.threeDResult);
    setSignatureStatus(builder.signatureStatus);
    setExemptionIndicator(builder.exemptionIndicator);
  }

  public static Builder builder() {
    return new Builder();
  }


  public Authentication id(String id) {
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


  public Authentication eci(Integer eci) {
    this.eci = eci;
    return this;
  }

  /**
   * This is the Electronic Commerce Indicator code, which gets returned by the card issuer indicating whether the cardholder was successfully authenticated. Note that in some cases the eci value includes a leading zero, e.g., 01 or 02. **Visa**   - 5 - Identifies a successfully authenticated transaction.   - 6 - Identifies an attempts authenticated transaction.   - 7 - Identifies a non-authenticated transaction. **Mastercard**   - 2 - Identifies a successfully authenticated transaction.   - 1 - Identifies an attempts authenticated transaction.   - 0 - Identifies a non-authenticated transaction.
   *
   * @return eci
   */
  public Integer getEci() {
    return eci;
  }

  public void setEci(Integer eci) {
    this.eci = eci;
  }


  public Authentication cavv(String cavv) {
    this.cavv = cavv;
    return this;
  }

  /**
   * This is the Cardholder Authentication Verification Value, which gets returned by the card issuer, indicating that the transaction has been authenticated.
   *
   * @return cavv
   */
  public String getCavv() {
    return cavv;
  }

  public void setCavv(String cavv) {
    this.cavv = cavv;
  }


  public Authentication xid(String xid) {
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


  public Authentication status(AuthenticationStatus status) {
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


  public Authentication merchantRefNum(String merchantRefNum) {
    this.merchantRefNum = merchantRefNum;
    return this;
  }

  /**
   * This is the merchant reference number created by  the merchant and submitted as part of the request. It must be unique for each request.
   *
   * @return merchantRefNum
   */
  public String getMerchantRefNum() {
    return merchantRefNum;
  }

  public void setMerchantRefNum(String merchantRefNum) {
    this.merchantRefNum = merchantRefNum;
  }


  public Authentication threeDEnrollment(ThreeDEnrollment threeDEnrollment) {
    this.threeDEnrollment = threeDEnrollment;
    return this;
  }

  /**
   * Get threeDEnrollment
   *
   * @return threeDEnrollment
   */
  public ThreeDEnrollment getThreeDEnrollment() {
    return threeDEnrollment;
  }

  public void setThreeDEnrollment(ThreeDEnrollment threeDEnrollment) {
    this.threeDEnrollment = threeDEnrollment;
  }


  public Authentication directoryServerTransactionId(String directoryServerTransactionId) {
    this.directoryServerTransactionId = directoryServerTransactionId;
    return this;
  }

  /**
   * This is the unique directory server transaction ID required for Mastercard. <br>  **Note:** This is field is required when the card brand is Mastercard. This exists only for 3D Secure 2.
   *
   * @return directoryServerTransactionId
   */
  public String getDirectoryServerTransactionId() {
    return directoryServerTransactionId;
  }

  public void setDirectoryServerTransactionId(String directoryServerTransactionId) {
    this.directoryServerTransactionId = directoryServerTransactionId;
  }


  public Authentication threeDSecureVersion(String threeDSecureVersion) {
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


  public Authentication threeDResult(ThreeDResult threeDResult) {
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


  public Authentication signatureStatus(ThreeDSignatureStatus signatureStatus) {
    this.signatureStatus = signatureStatus;
    return this;
  }

  /**
   * Get signatureStatus
   *
   * @return signatureStatus
   */
  public ThreeDSignatureStatus getSignatureStatus() {
    return signatureStatus;
  }

  public void setSignatureStatus(ThreeDSignatureStatus signatureStatus) {
    this.signatureStatus = signatureStatus;
  }


  public Authentication exemptionIndicator(ThreeDsExemptionIndicator exemptionIndicator) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Authentication authentication = (Authentication) o;
    return Objects.equals(this.id, authentication.id) &&
        Objects.equals(this.eci, authentication.eci) &&
        Objects.equals(this.cavv, authentication.cavv) &&
        Objects.equals(this.xid, authentication.xid) &&
        Objects.equals(this.status, authentication.status) &&
        Objects.equals(this.merchantRefNum, authentication.merchantRefNum) &&
        Objects.equals(this.threeDEnrollment, authentication.threeDEnrollment) &&
        Objects.equals(this.directoryServerTransactionId, authentication.directoryServerTransactionId) &&
        Objects.equals(this.threeDSecureVersion, authentication.threeDSecureVersion) &&
        Objects.equals(this.threeDResult, authentication.threeDResult) &&
        Objects.equals(this.signatureStatus, authentication.signatureStatus) &&
        Objects.equals(this.exemptionIndicator, authentication.exemptionIndicator);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, eci, cavv, xid, status, merchantRefNum, threeDEnrollment, directoryServerTransactionId, threeDSecureVersion, threeDResult, signatureStatus, exemptionIndicator);
  }

  @Override
  public String toString() {

    return "class Authentication {\n"
        + "    id: " + toIndentedString(id) + "\n"
        + "    eci: " + toIndentedString(eci) + "\n"
        + "    cavv: " + toIndentedString(cavv) + "\n"
        + "    xid: " + toIndentedString(xid) + "\n"
        + "    status: " + toIndentedString(status) + "\n"
        + "    merchantRefNum: " + toIndentedString(merchantRefNum) + "\n"
        + "    threeDEnrollment: " + toIndentedString(threeDEnrollment) + "\n"
        + "    directoryServerTransactionId: " + toIndentedString(directoryServerTransactionId) + "\n"
        + "    threeDSecureVersion: " + toIndentedString(threeDSecureVersion) + "\n"
        + "    threeDResult: " + toIndentedString(threeDResult) + "\n"
        + "    signatureStatus: " + toIndentedString(signatureStatus) + "\n"
        + "    exemptionIndicator: " + toIndentedString(exemptionIndicator) + "\n"
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
   * Authentication details for a payment. builder static inner class.
   */
  public static final class Builder {
    private String id;
    private Integer eci;
    private String cavv;
    private String xid;
    private AuthenticationStatus status;
    private String merchantRefNum;
    private ThreeDEnrollment threeDEnrollment;
    private String directoryServerTransactionId;
    private String threeDSecureVersion;
    private ThreeDResult threeDResult;
    private ThreeDSignatureStatus signatureStatus;
    private ThreeDsExemptionIndicator exemptionIndicator;

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
     * This is the Electronic Commerce Indicator code, which gets returned by the card issuer indicating whether the cardholder was successfully authenticated. Note that in some cases the eci value includes a leading zero, e.g., 01 or 02. **Visa**   - 5 - Identifies a successfully authenticated transaction.   - 6 - Identifies an attempts authenticated transaction.   - 7 - Identifies a non-authenticated transaction. **Mastercard**   - 2 - Identifies a successfully authenticated transaction.   - 1 - Identifies an attempts authenticated transaction.   - 0 - Identifies a non-authenticated transaction.
     * <p>
     * Sets the eci and returns a reference to this Builder enabling method chaining.
     *
     * @param eci the eci to set
     * @return a reference to this Builder
     */
    public Builder eci(Integer eci) {
      this.eci = eci;
      return this;
    }

    /**
     * This is the Cardholder Authentication Verification Value, which gets returned by the card issuer, indicating that the transaction has been authenticated.
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
     * This is the merchant reference number created by  the merchant and submitted as part of the request. It must be unique for each request.
     * <p>
     * Sets the merchantRefNum and returns a reference to this Builder enabling method chaining.
     *
     * @param merchantRefNum the merchantRefNum to set
     * @return a reference to this Builder
     */
    public Builder merchantRefNum(String merchantRefNum) {
      this.merchantRefNum = merchantRefNum;
      return this;
    }

    /**
     * Sets the threeDEnrollment and returns a reference to this Builder enabling method chaining.
     *
     * @param threeDEnrollment the threeDEnrollment to set
     * @return a reference to this Builder
     */
    public Builder threeDEnrollment(ThreeDEnrollment threeDEnrollment) {
      this.threeDEnrollment = threeDEnrollment;
      return this;
    }

    /**
     * This is the unique directory server transaction ID required for Mastercard. <br>  **Note:** This is field is required when the card brand is Mastercard. This exists only for 3D Secure 2.
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
     * Sets the signatureStatus and returns a reference to this Builder enabling method chaining.
     *
     * @param signatureStatus the signatureStatus to set
     * @return a reference to this Builder
     */
    public Builder signatureStatus(ThreeDSignatureStatus signatureStatus) {
      this.signatureStatus = signatureStatus;
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
     * Returns a Authentication built from the parameters previously set.
     *
     * @return a Authentication built with parameters of this Authentication.Builder
     */
    public Authentication build() {
      return new Authentication(this);
    }
  }
}
