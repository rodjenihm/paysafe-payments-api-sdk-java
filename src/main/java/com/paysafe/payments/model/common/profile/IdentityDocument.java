// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.model.common.profile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.paysafe.payments.model.card.CardExpiry;
import com.paysafe.payments.model.common.enums.IdentityDocumentType;
import com.paysafe.payments.model.customer.Customer;



/**
 * Customer identity document information
 */
public class IdentityDocument {

  @JsonProperty("type")
  private IdentityDocumentType type;
  @JsonProperty("documentNumber")
  private String documentNumber;
  @JsonProperty("issuingCountry")
  private String issuingCountry;
  @JsonProperty("expiryDate")
  private CardExpiry expiryDate;
  @JsonProperty("issueDate")
  private CardExpiry issueDate;

  public IdentityDocument() {
    super();
  }

  private IdentityDocument(final Builder builder) {
    setType(builder.type);
    setDocumentNumber(builder.documentNumber);
    setIssuingCountry(builder.issuingCountry);
    setExpiryDate(builder.expiryDate);
    setIssueDate(builder.issueDate);
  }

  public static Builder builder() {
    return new Builder();
  }


  public IdentityDocument type(IdentityDocumentType type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   *
   * @return type
   */
  public IdentityDocumentType getType() {
    return type;
  }

  public void setType(IdentityDocumentType type) {
    this.type = type;
  }


  public IdentityDocument documentNumber(String documentNumber) {
    this.documentNumber = documentNumber;
    return this;
  }

  /**
   * The number associated with ID.
   *
   * @return documentNumber
   */
  public String getDocumentNumber() {
    return documentNumber;
  }

  public void setDocumentNumber(String documentNumber) {
    this.documentNumber = documentNumber;
  }


  public IdentityDocument issuingCountry(String issuingCountry) {
    this.issuingCountry = issuingCountry;
    return this;
  }

  /**
   * Value will always be \"US\".
   *
   * @return issuingCountry
   */
  public String getIssuingCountry() {
    return issuingCountry;
  }

  public void setIssuingCountry(String issuingCountry) {
    this.issuingCountry = issuingCountry;
  }


  public IdentityDocument expiryDate(CardExpiry expiryDate) {
    this.expiryDate = expiryDate;
    return this;
  }

  /**
   * Get expiryDate
   *
   * @return expiryDate
   */
  public CardExpiry getExpiryDate() {
    return expiryDate;
  }

  public void setExpiryDate(CardExpiry expiryDate) {
    this.expiryDate = expiryDate;
  }


  public IdentityDocument issueDate(CardExpiry issueDate) {
    this.issueDate = issueDate;
    return this;
  }

  /**
   * Get issueDate
   *
   * @return issueDate
   */
  public CardExpiry getIssueDate() {
    return issueDate;
  }

  public void setIssueDate(CardExpiry issueDate) {
    this.issueDate = issueDate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IdentityDocument identityDocument = (IdentityDocument) o;
    return Objects.equals(this.type, identityDocument.type) &&
        Objects.equals(this.documentNumber, identityDocument.documentNumber) &&
        Objects.equals(this.issuingCountry, identityDocument.issuingCountry) &&
        Objects.equals(this.expiryDate, identityDocument.expiryDate) &&
        Objects.equals(this.issueDate, identityDocument.issueDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, documentNumber, issuingCountry, expiryDate, issueDate);
  }

  @Override
  public String toString() {

    return "class IdentityDocument {\n"
        + "    type: " + toIndentedString(type) + "\n"
        + "    documentNumber: " + toIndentedString(documentNumber) + "\n"
        + "    issuingCountry: " + toIndentedString(issuingCountry) + "\n"
        + "    expiryDate: " + toIndentedString(expiryDate) + "\n"
        + "    issueDate: " + toIndentedString(issueDate) + "\n"
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
   * Customer identity document information builder static inner class.
   */
  public static final class Builder {
    private IdentityDocumentType type;
    private String documentNumber;
    private String issuingCountry;
    private CardExpiry expiryDate;
    private CardExpiry issueDate;

    private Builder() {
    }

    /**
     * Sets the type and returns a reference to this Builder enabling method chaining.
     *
     * @param type the type to set
     * @return a reference to this Builder
     */
    public Builder type(IdentityDocumentType type) {
      this.type = type;
      return this;
    }

    /**
     * The number associated with ID.
     * <p>
     * Sets the documentNumber and returns a reference to this Builder enabling method chaining.
     *
     * @param documentNumber the documentNumber to set
     * @return a reference to this Builder
     */
    public Builder documentNumber(String documentNumber) {
      this.documentNumber = documentNumber;
      return this;
    }

    /**
     * Value will always be \"US\".
     * <p>
     * Sets the issuingCountry and returns a reference to this Builder enabling method chaining.
     *
     * @param issuingCountry the issuingCountry to set
     * @return a reference to this Builder
     */
    public Builder issuingCountry(String issuingCountry) {
      this.issuingCountry = issuingCountry;
      return this;
    }

    /**
     * Sets the expiryDate and returns a reference to this Builder enabling method chaining.
     *
     * @param expiryDate the expiryDate to set
     * @return a reference to this Builder
     */
    public Builder expiryDate(CardExpiry expiryDate) {
      this.expiryDate = expiryDate;
      return this;
    }

    /**
     * Sets the issueDate and returns a reference to this Builder enabling method chaining.
     *
     * @param issueDate the issueDate to set
     * @return a reference to this Builder
     */
    public Builder issueDate(CardExpiry issueDate) {
      this.issueDate = issueDate;
      return this;
    }

    /**
     * Returns a IdentityDocument built from the parameters previously set.
     *
     * @return a IdentityDocument built with parameters of this IdentityDocument.Builder
     */
    public IdentityDocument build() {
      return new IdentityDocument(this);
    }
  }
}
