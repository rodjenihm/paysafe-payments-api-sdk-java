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
import com.paysafe.payments.model.card.Card;
import com.paysafe.payments.model.common.enums.StoredCredentialOccurrence;
import com.paysafe.payments.model.common.enums.StoredCredentialType;
import com.paysafe.payments.model.customer.Customer;
import com.paysafe.payments.model.payment.Payment;



/**
 * 'The storedCredential object is used to identify [authorization requests] that use stored credentials for a consumer, in order to improve authorization rates and reduce fraud. Stored credentials can be used in two cases: - Using a payment token : An authorization request that uses a paymentToken from the [Customer Vault API] - Using a card number : An authorization request that uses a credit card number stored by the merchant. **Notes:** - If you use a paymentToken in the authorization request but do not include the storedCredential object, Paysafe will provide default information taken from Customer Vault data. - You cannot include both the storedCredential object and the recurring parameter in the same authorization request. Paysafe recommends using the storedCredential object. - The cvv parameter of the [card object] is required when the occurrence parameteris set to INITIAL. However, cvv is not required when the occurrence parameter is set to SUBSEQUENT. - The storedCredential object cannot be used for Apple Pay or Google Pay transactions.'
 */
public class StoredCredential {

  @JsonProperty("type")
  private StoredCredentialType type;
  @JsonProperty("occurrence")
  private StoredCredentialOccurrence occurrence;
  @JsonProperty("initialTransactionId")
  private String initialTransactionId;
  @JsonProperty("externalInitialTransactionId")
  private String externalInitialTransactionId;

  public StoredCredential() {
    super();
  }

  private StoredCredential(final Builder builder) {
    setType(builder.type);
    setOccurrence(builder.occurrence);
    setInitialTransactionId(builder.initialTransactionId);
    setExternalInitialTransactionId(builder.externalInitialTransactionId);
  }

  public static Builder builder() {
    return new Builder();
  }


  public StoredCredential type(StoredCredentialType type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   *
   * @return type
   */
  public StoredCredentialType getType() {
    return type;
  }

  public void setType(StoredCredentialType type) {
    this.type = type;
  }


  public StoredCredential occurrence(StoredCredentialOccurrence occurrence) {
    this.occurrence = occurrence;
    return this;
  }

  /**
   * Get occurrence
   *
   * @return occurrence
   */
  public StoredCredentialOccurrence getOccurrence() {
    return occurrence;
  }

  public void setOccurrence(StoredCredentialOccurrence occurrence) {
    this.occurrence = occurrence;
  }


  public StoredCredential initialTransactionId(String initialTransactionId) {
    this.initialTransactionId = initialTransactionId;
    return this;
  }

  /**
   * 'Id of the initial Recurring Payment transaction. This id should be stored from the auth response of the transaction indicated as initial with the following: type=RECURRING/TOPUP/ADHOC, occurrence=INITIAL. This reference should be provided when:   - type = RECURRING and occurrence = SUBSEQUENT   - type = TOPUP and occurrence = SUBSEQUENT   - type = ADHOC and occurrence = SUBSEQUENT **Note:** This reference is a must to meet PSD 2 authentication process requirements for merchant initiated transactions successfully.'
   *
   * @return initialTransactionId
   */
  public String getInitialTransactionId() {
    return initialTransactionId;
  }

  public void setInitialTransactionId(String initialTransactionId) {
    this.initialTransactionId = initialTransactionId;
  }


  public StoredCredential externalInitialTransactionId(String externalInitialTransactionId) {
    this.externalInitialTransactionId = externalInitialTransactionId;
    return this;
  }

  /**
   * 'Card Scheme Transaction Id of the initial payment transaction in the recurring plan when it was processed through external service provider. This reference should be provided only when:   - type=RECURRING and occurrence=SUBSEQUENT   - type=TOPUP and occurrence=SUBSEQUENT **Note:** This reference cannot be provided along with initialTransactionId.  Expected format by scheme (examples):   - Amex: 15 digits (for example, 012345678901234)   - Mastercard: 9 characters + 4 digits + 2 spaces (for example, MCC9999991231 )   - Visa: 15 digits (for example, 306123456789012) '
   *
   * @return externalInitialTransactionId
   */
  public String getExternalInitialTransactionId() {
    return externalInitialTransactionId;
  }

  public void setExternalInitialTransactionId(String externalInitialTransactionId) {
    this.externalInitialTransactionId = externalInitialTransactionId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StoredCredential storedCredential = (StoredCredential) o;
    return Objects.equals(this.type, storedCredential.type) &&
        Objects.equals(this.occurrence, storedCredential.occurrence) &&
        Objects.equals(this.initialTransactionId, storedCredential.initialTransactionId) &&
        Objects.equals(this.externalInitialTransactionId, storedCredential.externalInitialTransactionId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, occurrence, initialTransactionId, externalInitialTransactionId);
  }

  @Override
  public String toString() {

    return "class StoredCredential {\n"
        + "    type: " + toIndentedString(type) + "\n"
        + "    occurrence: " + toIndentedString(occurrence) + "\n"
        + "    initialTransactionId: " + toIndentedString(initialTransactionId) + "\n"
        + "    externalInitialTransactionId: " + toIndentedString(externalInitialTransactionId) + "\n"
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
   * 'The storedCredential object is used to identify [authorization requests] that use stored credentials for a consumer, in order to improve authorization rates and reduce fraud. Stored credentials can be used in two cases: - Using a payment token : An authorization request that uses a paymentToken from the [Customer Vault API] - Using a card number : An authorization request that uses a credit card number stored by the merchant. **Notes:** - If you use a paymentToken in the authorization request but do not include the storedCredential object, Paysafe will provide default information taken from Customer Vault data. - You cannot include both the storedCredential object and the recurring parameter in the same authorization request. Paysafe recommends using the storedCredential object. - The cvv parameter of the [card object] is required when the occurrence parameteris set to INITIAL. However, cvv is not required when the occurrence parameter is set to SUBSEQUENT. - The storedCredential object cannot be used for Apple Pay or Google Pay transactions.' builder static inner class.
   */
  public static final class Builder {
    private StoredCredentialType type;
    private StoredCredentialOccurrence occurrence;
    private String initialTransactionId;
    private String externalInitialTransactionId;

    private Builder() {
    }

    /**
     * Sets the type and returns a reference to this Builder enabling method chaining.
     *
     * @param type the type to set
     * @return a reference to this Builder
     */
    public Builder type(StoredCredentialType type) {
      this.type = type;
      return this;
    }

    /**
     * Sets the occurrence and returns a reference to this Builder enabling method chaining.
     *
     * @param occurrence the occurrence to set
     * @return a reference to this Builder
     */
    public Builder occurrence(StoredCredentialOccurrence occurrence) {
      this.occurrence = occurrence;
      return this;
    }

    /**
     * 'Id of the initial Recurring Payment transaction. This id should be stored from the auth response of the transaction indicated as initial with the following: type=RECURRING/TOPUP/ADHOC, occurrence=INITIAL. This reference should be provided when:   - type = RECURRING and occurrence = SUBSEQUENT   - type = TOPUP and occurrence = SUBSEQUENT   - type = ADHOC and occurrence = SUBSEQUENT **Note:** This reference is a must to meet PSD 2 authentication process requirements for merchant initiated transactions successfully.'
     * <p>
     * Sets the initialTransactionId and returns a reference to this Builder enabling method chaining.
     *
     * @param initialTransactionId the initialTransactionId to set
     * @return a reference to this Builder
     */
    public Builder initialTransactionId(String initialTransactionId) {
      this.initialTransactionId = initialTransactionId;
      return this;
    }

    /**
     * 'Card Scheme Transaction Id of the initial payment transaction in the recurring plan when it was processed through external service provider. This reference should be provided only when:   - type=RECURRING and occurrence=SUBSEQUENT   - type=TOPUP and occurrence=SUBSEQUENT **Note:** This reference cannot be provided along with initialTransactionId.  Expected format by scheme (examples):   - Amex: 15 digits (for example, 012345678901234)   - Mastercard: 9 characters + 4 digits + 2 spaces (for example, MCC9999991231 )   - Visa: 15 digits (for example, 306123456789012) '
     * <p>
     * Sets the externalInitialTransactionId and returns a reference to this Builder enabling method chaining.
     *
     * @param externalInitialTransactionId the externalInitialTransactionId to set
     * @return a reference to this Builder
     */
    public Builder externalInitialTransactionId(String externalInitialTransactionId) {
      this.externalInitialTransactionId = externalInitialTransactionId;
      return this;
    }

    /**
     * Returns a StoredCredential built from the parameters previously set.
     *
     * @return a StoredCredential built with parameters of this StoredCredential.Builder
     */
    public StoredCredential build() {
      return new StoredCredential(this);
    }
  }
}
