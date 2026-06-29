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
import com.paysafe.payments.model.common.profile.DateOfBirth;



/**
 * 'The recipient is deemed to be the person or party who has the contractual relationship with the merchant / financial institution. This may be different from the cardholder, e.g., in the case of a parent topping up a child's savings account. Therefore, the fields should not be collected on the same page as cardholder information, but instead be passed in the background from the merchant's records.  **Note:** You can include recipient elements in your [authorization request](https://developer.paysafe.com/en/cards-api/#/operations/authorization) **only if** your Merchant Category Code is **6012** and your registered trading address is in the United Kingdom. All fields are optional. However, scheme fines may apply if data is consistently not supplied and chargebacks persist. If you have any questions, contact your account manager. If you are using a payment token for an  Authorization request and there is already recipient data for the consumer profile associated with the payment token, then if you include the recipient object in the Authorization, this data will override the recipient data already in the profile.  If you [look up an authorization request](https://developer.paysafe.com/en/cards-api/#/operations/get-authorization) that used the visaAdditionalAuthData parameter (now deprecated), the response will contain the relevant data in both the recipient and the visaAdditionalAuthData objects.'
 */
public class Recipient {

  @JsonProperty("dateOfBirth")
  private DateOfBirth dateOfBirth;
  @JsonProperty("lastName")
  private String lastName;
  @JsonProperty("accountNumber")
  private String accountNumber;
  @JsonProperty("zip")
  private String zip;

  public Recipient() {
    super();
  }

  private Recipient(final Builder builder) {
    setDateOfBirth(builder.dateOfBirth);
    setLastName(builder.lastName);
    setAccountNumber(builder.accountNumber);
    setZip(builder.zip);
  }

  public static Builder builder() {
    return new Builder();
  }


  public Recipient dateOfBirth(DateOfBirth dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
    return this;
  }

  /**
   * Get dateOfBirth
   *
   * @return dateOfBirth
   */
  public DateOfBirth getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(DateOfBirth dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }


  public Recipient lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  /**
   * 'This is the recipient's last name. **Note:** Only the first 6 characters are sent to the banking network.'
   *
   * @return lastName
   */
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }


  public Recipient accountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
    return this;
  }

  /**
   * 'This is the recipient's account number, e.g., a loan agreement number or customer ID. In the case where the recipient account is a prepaid card, the card number may be sent in full. **Note:** Only the first 6 and last 4 characters are sent to the banking network and will be masked accordingly within the back office and any other reports, to comply with PCI regulations.'
   *
   * @return accountNumber
   */
  public String getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
  }


  public Recipient zip(String zip) {
    this.zip = zip;
    return this;
  }

  /**
   * Postal/ZIP code of the recipient
   *
   * @return zip
   */
  public String getZip() {
    return zip;
  }

  public void setZip(String zip) {
    this.zip = zip;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Recipient recipient = (Recipient) o;
    return Objects.equals(this.dateOfBirth, recipient.dateOfBirth) &&
        Objects.equals(this.lastName, recipient.lastName) &&
        Objects.equals(this.accountNumber, recipient.accountNumber) &&
        Objects.equals(this.zip, recipient.zip);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dateOfBirth, lastName, accountNumber, zip);
  }

  @Override
  public String toString() {

    return "class Recipient {\n"
        + "    dateOfBirth: " + toIndentedString(dateOfBirth) + "\n"
        + "    lastName: " + toIndentedString(lastName) + "\n"
        + "    accountNumber: " + toIndentedString(accountNumber) + "\n"
        + "    zip: " + toIndentedString(zip) + "\n"
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
   * 'The recipient is deemed to be the person or party who has the contractual relationship with the merchant / financial institution. This may be different from the cardholder, e.g., in the case of a parent topping up a child's savings account. Therefore, the fields should not be collected on the same page as cardholder information, but instead be passed in the background from the merchant's records.  **Note:** You can include recipient elements in your [authorization request](https://developer.paysafe.com/en/cards-api/#/operations/authorization) **only if** your Merchant Category Code is **6012** and your registered trading address is in the United Kingdom. All fields are optional. However, scheme fines may apply if data is consistently not supplied and chargebacks persist. If you have any questions, contact your account manager. If you are using a payment token for an  Authorization request and there is already recipient data for the consumer profile associated with the payment token, then if you include the recipient object in the Authorization, this data will override the recipient data already in the profile.  If you [look up an authorization request](https://developer.paysafe.com/en/cards-api/#/operations/get-authorization) that used the visaAdditionalAuthData parameter (now deprecated), the response will contain the relevant data in both the recipient and the visaAdditionalAuthData objects.' builder static inner class.
   */
  public static final class Builder {
    private DateOfBirth dateOfBirth;
    private String lastName;
    private String accountNumber;
    private String zip;

    private Builder() {
    }

    /**
     * Sets the dateOfBirth and returns a reference to this Builder enabling method chaining.
     *
     * @param dateOfBirth the dateOfBirth to set
     * @return a reference to this Builder
     */
    public Builder dateOfBirth(DateOfBirth dateOfBirth) {
      this.dateOfBirth = dateOfBirth;
      return this;
    }

    /**
     * 'This is the recipient's last name. **Note:** Only the first 6 characters are sent to the banking network.'
     * <p>
     * Sets the lastName and returns a reference to this Builder enabling method chaining.
     *
     * @param lastName the lastName to set
     * @return a reference to this Builder
     */
    public Builder lastName(String lastName) {
      this.lastName = lastName;
      return this;
    }

    /**
     * 'This is the recipient's account number, e.g., a loan agreement number or customer ID. In the case where the recipient account is a prepaid card, the card number may be sent in full. **Note:** Only the first 6 and last 4 characters are sent to the banking network and will be masked accordingly within the back office and any other reports, to comply with PCI regulations.'
     * <p>
     * Sets the accountNumber and returns a reference to this Builder enabling method chaining.
     *
     * @param accountNumber the accountNumber to set
     * @return a reference to this Builder
     */
    public Builder accountNumber(String accountNumber) {
      this.accountNumber = accountNumber;
      return this;
    }

    /**
     * Postal/ZIP code of the recipient
     * <p>
     * Sets the zip and returns a reference to this Builder enabling method chaining.
     *
     * @param zip the zip to set
     * @return a reference to this Builder
     */
    public Builder zip(String zip) {
      this.zip = zip;
      return this;
    }

    /**
     * Returns a Recipient built from the parameters previously set.
     *
     * @return a Recipient built with parameters of this Recipient.Builder
     */
    public Recipient build() {
      return new Recipient(this);
    }
  }
}
