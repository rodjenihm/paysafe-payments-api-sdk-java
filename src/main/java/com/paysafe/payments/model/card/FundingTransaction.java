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
import com.paysafe.payments.model.card.enums.FundingTransactionType;
import com.paysafe.payments.model.common.profile.Profile;



/**
 * The fundingTransaction object is used to identify authorization requests that are categorized as funding transactions by the merchant in order to provide additional information for the purpose of a transaction. It can be used by merchants registered with MCC 4722, 4829, 6012, 6051, 6211, 6540, 7800, 7801, 7802, 7994, 7995 or 9406. The relevant value will be assigned automatically by the Payments API as per the merchant registration with card schemes and his applicable MCC.  **Funding Transaction Type Mappings:**  | Funding Transaction Type | Visa | Mastercard | |--------------------------|------|------------| | SVDW_FUNDS_TRANSFER | Applicable for 4722, 4829, 6012, 6051, 6211 and 6540 | Applicable for 4829, 6540, 6051, 6211, 7800, 7801, 7802, 7994, 7995, 9406 | | SDW_WALLET_TRANSFER | Applicable for 4829, 6012 and 6051 | Applicable for 6540, 6051, 6211, 7800, 7801, 7802, 7994, 7995, 9406 | | ACCOUNT_TO_ACCOUNT | Applicable for 4829, 6012 and 6211 | Not applicable | | PERSON_TO_PERSON | Applicable for 4829 and 6012 | Applicable for 6540, 4829 |  **Notes:**  - The transactionIntent property is used to identify the intent of the authorization requests. This field is mandatory for Visa card - cross-border fundingTransactions where the recipient is from any of the following countries: India, Bangladesh, Argentina, and Egypt.  - If you want to support Visa AFT and Mastercard Funding, you should perform registration with the Card schemes in advance. Please contact Paysafe's operational support or your account manager in order to receive more information and to begin with the registration process. Please note also that not every processor supports funding transactions for all MCCs listed here.  - If you send fundingTransaction type value in the authorization request, you must also send profile and billingDetails, as described below: Profile: firstName, lastName, merchantCustomerId; Billing Details: street, city, state (If US or Canada), country, zip. If not, the funding transaction will be declined due to missing data.  - If you send fundingTransaction type value in the authorization request, but your acquirer doesn't support funding transactions, or your account is not configured (you have not performed the registration process), the transaction will be declined with error: 5040.  - If you send fundingTransaction type in the authorization request with a value not applicable for your MCC, the transaction will be declined with error: 3068.  - If you send fundingTransaction type in the authorization request with a value applicable for your MCC, but not for your VISA direct configuration, the transaction will be declined with error 3069.  - If you send fundingTransaction type in the authorization request with a value not part of the list, the transaction will be declined with error: 5068.  - If you send fundingTransaction type value in the authorization request and your account is configured to process funding transactions, but you are not registered to process funding transactions to a specific card brand, the transaction will be successfully processed and processorAppliedType in the response will be 'NOT_APPLIED'.  - Suppose you send fundingTransaction type value in the authorization request, and your account is configured to process funding transactions. You are registered to process funding transactions to the respective card brand. In that case, the transaction will be successfully processed, and the processorAppliedType will be equal to the fundingTransaction type provided in the request.
 */
public class FundingTransaction {

  @JsonProperty("type")
  private FundingTransactionType type;
  @JsonProperty("processorAppliedType")
  private FundingTransactionType processorAppliedType;

  public FundingTransaction() {
    super();
  }

  private FundingTransaction(final Builder builder) {
    setType(builder.type);
    setProcessorAppliedType(builder.processorAppliedType);
  }

  public static Builder builder() {
    return new Builder();
  }


  public FundingTransaction type(FundingTransactionType type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   *
   * @return type
   */
  public FundingTransactionType getType() {
    return type;
  }

  public void setType(FundingTransactionType type) {
    this.type = type;
  }


  public FundingTransaction processorAppliedType(FundingTransactionType processorAppliedType) {
    this.processorAppliedType = processorAppliedType;
    return this;
  }

  /**
   * Get processorAppliedType
   *
   * @return processorAppliedType
   */
  public FundingTransactionType getProcessorAppliedType() {
    return processorAppliedType;
  }

  public void setProcessorAppliedType(FundingTransactionType processorAppliedType) {
    this.processorAppliedType = processorAppliedType;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FundingTransaction fundingTransaction = (FundingTransaction) o;
    return Objects.equals(this.type, fundingTransaction.type) &&
        Objects.equals(this.processorAppliedType, fundingTransaction.processorAppliedType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, processorAppliedType);
  }

  @Override
  public String toString() {

    return "class FundingTransaction {\n"
        + "    type: " + toIndentedString(type) + "\n"
        + "    processorAppliedType: " + toIndentedString(processorAppliedType) + "\n"
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
   * The fundingTransaction object is used to identify authorization requests that are categorized as funding transactions by the merchant in order to provide additional information for the purpose of a transaction. It can be used by merchants registered with MCC 4722, 4829, 6012, 6051, 6211, 6540, 7800, 7801, 7802, 7994, 7995 or 9406. The relevant value will be assigned automatically by the Payments API as per the merchant registration with card schemes and his applicable MCC.  **Funding Transaction Type Mappings:**  | Funding Transaction Type | Visa | Mastercard | |--------------------------|------|------------| | SVDW_FUNDS_TRANSFER | Applicable for 4722, 4829, 6012, 6051, 6211 and 6540 | Applicable for 4829, 6540, 6051, 6211, 7800, 7801, 7802, 7994, 7995, 9406 | | SDW_WALLET_TRANSFER | Applicable for 4829, 6012 and 6051 | Applicable for 6540, 6051, 6211, 7800, 7801, 7802, 7994, 7995, 9406 | | ACCOUNT_TO_ACCOUNT | Applicable for 4829, 6012 and 6211 | Not applicable | | PERSON_TO_PERSON | Applicable for 4829 and 6012 | Applicable for 6540, 4829 |  **Notes:**  - The transactionIntent property is used to identify the intent of the authorization requests. This field is mandatory for Visa card - cross-border fundingTransactions where the recipient is from any of the following countries: India, Bangladesh, Argentina, and Egypt.  - If you want to support Visa AFT and Mastercard Funding, you should perform registration with the Card schemes in advance. Please contact Paysafe's operational support or your account manager in order to receive more information and to begin with the registration process. Please note also that not every processor supports funding transactions for all MCCs listed here.  - If you send fundingTransaction type value in the authorization request, you must also send profile and billingDetails, as described below: Profile: firstName, lastName, merchantCustomerId; Billing Details: street, city, state (If US or Canada), country, zip. If not, the funding transaction will be declined due to missing data.  - If you send fundingTransaction type value in the authorization request, but your acquirer doesn't support funding transactions, or your account is not configured (you have not performed the registration process), the transaction will be declined with error: 5040.  - If you send fundingTransaction type in the authorization request with a value not applicable for your MCC, the transaction will be declined with error: 3068.  - If you send fundingTransaction type in the authorization request with a value applicable for your MCC, but not for your VISA direct configuration, the transaction will be declined with error 3069.  - If you send fundingTransaction type in the authorization request with a value not part of the list, the transaction will be declined with error: 5068.  - If you send fundingTransaction type value in the authorization request and your account is configured to process funding transactions, but you are not registered to process funding transactions to a specific card brand, the transaction will be successfully processed and processorAppliedType in the response will be 'NOT_APPLIED'.  - Suppose you send fundingTransaction type value in the authorization request, and your account is configured to process funding transactions. You are registered to process funding transactions to the respective card brand. In that case, the transaction will be successfully processed, and the processorAppliedType will be equal to the fundingTransaction type provided in the request. builder static inner class.
   */
  public static final class Builder {
    private FundingTransactionType type;
    private FundingTransactionType processorAppliedType;

    private Builder() {
    }

    /**
     * Sets the type and returns a reference to this Builder enabling method chaining.
     *
     * @param type the type to set
     * @return a reference to this Builder
     */
    public Builder type(FundingTransactionType type) {
      this.type = type;
      return this;
    }

    /**
     * Sets the processorAppliedType and returns a reference to this Builder enabling method chaining.
     *
     * @param processorAppliedType the processorAppliedType to set
     * @return a reference to this Builder
     */
    public Builder processorAppliedType(FundingTransactionType processorAppliedType) {
      this.processorAppliedType = processorAppliedType;
      return this;
    }

    /**
     * Returns a FundingTransaction built from the parameters previously set.
     *
     * @return a FundingTransaction built with parameters of this FundingTransaction.Builder
     */
    public FundingTransaction build() {
      return new FundingTransaction(this);
    }
  }
}
