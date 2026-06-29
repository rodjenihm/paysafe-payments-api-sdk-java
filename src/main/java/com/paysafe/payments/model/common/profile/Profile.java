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
import com.paysafe.payments.model.common.enums.KycStatus;
import com.paysafe.payments.model.common.profile.enums.VerifiedStatus;
import com.paysafe.payments.model.common.travel.airline.enums.Gender;
import com.paysafe.payments.model.customer.Customer;
import com.paysafe.payments.model.customer.enums.Locale;



/**
 * Customer profile information - required for fundingTransaction in CARD payments, VIP Preferred, Play+ Registration, and paysafecard Payout
 */
public class Profile {

  @JsonProperty("id")
  private String id;
  @JsonProperty("status")
  private String status;
  @JsonProperty("merchantCustomerId")
  private String merchantCustomerId;
  @JsonProperty("locale")
  private Locale locale;
  @JsonProperty("firstName")
  private String firstName;
  @JsonProperty("lastName")
  private String lastName;
  @JsonProperty("email")
  private String email;
  @JsonProperty("phone")
  private String phone;
  @JsonProperty("emailVerified")
  private VerifiedStatus emailVerified = VerifiedStatus.NOT_VERIFIED;
  @JsonProperty("phoneVerified")
  private VerifiedStatus phoneVerified = VerifiedStatus.NOT_VERIFIED;
  @JsonProperty("dateOfBirth")
  private DateOfBirth dateOfBirth;
  @JsonProperty("gender")
  private Gender gender;
  @JsonProperty("nationality")
  private String nationality;
  @JsonProperty("identityDocuments")
  private List<IdentityDocument> identityDocuments;
  @JsonProperty("kycStatus")
  private KycStatus kycStatus;

  public Profile() {
    super();
  }

  private Profile(final Builder builder) {
    setId(builder.id);
    setStatus(builder.status);
    setMerchantCustomerId(builder.merchantCustomerId);
    setLocale(builder.locale);
    setFirstName(builder.firstName);
    setLastName(builder.lastName);
    setEmail(builder.email);
    setPhone(builder.phone);
    setEmailVerified(builder.emailVerified);
    setPhoneVerified(builder.phoneVerified);
    setDateOfBirth(builder.dateOfBirth);
    setGender(builder.gender);
    setNationality(builder.nationality);
    setIdentityDocuments(builder.identityDocuments);
    setKycStatus(builder.kycStatus);
  }

  public static Builder builder() {
    return new Builder();
  }


  public Profile id(String id) {
    this.id = id;
    return this;
  }

  /**
   * The customer's profile ID in the system. If this is present, other fields are not required
   *
   * @return id
   */
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public Profile status(String status) {
    this.status = status;
    return this;
  }

  /**
   * The status of customer in the system, returned in the response
   *
   * @return status
   */
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }


  public Profile merchantCustomerId(String merchantCustomerId) {
    this.merchantCustomerId = merchantCustomerId;
    return this;
  }

  /**
   * Reference number for the customer created by the merchant. Must be unique for each customer
   *
   * @return merchantCustomerId
   */
  public String getMerchantCustomerId() {
    return merchantCustomerId;
  }

  public void setMerchantCustomerId(String merchantCustomerId) {
    this.merchantCustomerId = merchantCustomerId;
  }


  public Profile locale(Locale locale) {
    this.locale = locale;
    return this;
  }

  /**
   * Get locale
   *
   * @return locale
   */
  public Locale getLocale() {
    return locale;
  }

  public void setLocale(Locale locale) {
    this.locale = locale;
  }


  public Profile firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  /**
   * The customer's first name
   *
   * @return firstName
   */
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }


  public Profile lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  /**
   * The customer's last name
   *
   * @return lastName
   */
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }


  public Profile email(String email) {
    this.email = email;
    return this;
  }

  /**
   * The customer's email address
   *
   * @return email
   */
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  public Profile phone(String phone) {
    this.phone = phone;
    return this;
  }

  /**
   * The customer's phone number
   *
   * @return phone
   */
  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }


  public Profile emailVerified(VerifiedStatus emailVerified) {
    this.emailVerified = emailVerified;
    return this;
  }

  /**
   * Get emailVerified
   *
   * @return emailVerified
   */
  public VerifiedStatus getEmailVerified() {
    return emailVerified;
  }

  public void setEmailVerified(VerifiedStatus emailVerified) {
    this.emailVerified = emailVerified;
  }


  public Profile phoneVerified(VerifiedStatus phoneVerified) {
    this.phoneVerified = phoneVerified;
    return this;
  }

  /**
   * Get phoneVerified
   *
   * @return phoneVerified
   */
  public VerifiedStatus getPhoneVerified() {
    return phoneVerified;
  }

  public void setPhoneVerified(VerifiedStatus phoneVerified) {
    this.phoneVerified = phoneVerified;
  }


  public Profile dateOfBirth(DateOfBirth dateOfBirth) {
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


  public Profile gender(Gender gender) {
    this.gender = gender;
    return this;
  }

  /**
   * Get gender
   *
   * @return gender
   */
  public Gender getGender() {
    return gender;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }


  public Profile nationality(String nationality) {
    this.nationality = nationality;
    return this;
  }

  /**
   * The customer's nationality
   *
   * @return nationality
   */
  public String getNationality() {
    return nationality;
  }

  public void setNationality(String nationality) {
    this.nationality = nationality;
  }


  public Profile identityDocuments(List<IdentityDocument> identityDocuments) {
    this.identityDocuments = identityDocuments;
    return this;
  }

  public Profile addIdentityDocumentsItem(IdentityDocument identityDocumentsItem) {
    if (this.identityDocuments == null) {
      this.identityDocuments = new ArrayList<>();
    }
    this.identityDocuments.add(identityDocumentsItem);
    return this;
  }

  public Profile removeIdentityDocumentsItem(IdentityDocument identityDocumentsItem) {
    if (identityDocumentsItem != null && this.identityDocuments != null) {
      this.identityDocuments.remove(identityDocumentsItem);
    }

    return this;
  }

  /**
   * Customer's identity documents
   *
   * @return identityDocuments
   */
  public List<IdentityDocument> getIdentityDocuments() {
    return identityDocuments;
  }

  public void setIdentityDocuments(List<IdentityDocument> identityDocuments) {
    this.identityDocuments = identityDocuments;
  }


  public Profile kycStatus(KycStatus kycStatus) {
    this.kycStatus = kycStatus;
    return this;
  }

  /**
   * Get kycStatus
   *
   * @return kycStatus
   */
  public KycStatus getKycStatus() {
    return kycStatus;
  }

  public void setKycStatus(KycStatus kycStatus) {
    this.kycStatus = kycStatus;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Profile profile = (Profile) o;
    return Objects.equals(this.id, profile.id) &&
        Objects.equals(this.status, profile.status) &&
        Objects.equals(this.merchantCustomerId, profile.merchantCustomerId) &&
        Objects.equals(this.locale, profile.locale) &&
        Objects.equals(this.firstName, profile.firstName) &&
        Objects.equals(this.lastName, profile.lastName) &&
        Objects.equals(this.email, profile.email) &&
        Objects.equals(this.phone, profile.phone) &&
        Objects.equals(this.emailVerified, profile.emailVerified) &&
        Objects.equals(this.phoneVerified, profile.phoneVerified) &&
        Objects.equals(this.dateOfBirth, profile.dateOfBirth) &&
        Objects.equals(this.gender, profile.gender) &&
        Objects.equals(this.nationality, profile.nationality) &&
        Objects.equals(this.identityDocuments, profile.identityDocuments) &&
        Objects.equals(this.kycStatus, profile.kycStatus);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, status, merchantCustomerId, locale, firstName, lastName, email, phone, emailVerified, phoneVerified, dateOfBirth, gender, nationality, identityDocuments, kycStatus);
  }

  @Override
  public String toString() {

    return "class Profile {\n"
        + "    id: " + toIndentedString(id) + "\n"
        + "    status: " + toIndentedString(status) + "\n"
        + "    merchantCustomerId: " + toIndentedString(merchantCustomerId) + "\n"
        + "    locale: " + toIndentedString(locale) + "\n"
        + "    firstName: " + toIndentedString(firstName) + "\n"
        + "    lastName: " + toIndentedString(lastName) + "\n"
        + "    email: " + toIndentedString(email) + "\n"
        + "    phone: " + toIndentedString(phone) + "\n"
        + "    emailVerified: " + toIndentedString(emailVerified) + "\n"
        + "    phoneVerified: " + toIndentedString(phoneVerified) + "\n"
        + "    dateOfBirth: " + toIndentedString(dateOfBirth) + "\n"
        + "    gender: " + toIndentedString(gender) + "\n"
        + "    nationality: " + toIndentedString(nationality) + "\n"
        + "    identityDocuments: " + toIndentedString(identityDocuments) + "\n"
        + "    kycStatus: " + toIndentedString(kycStatus) + "\n"
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
   * Customer profile information - required for fundingTransaction in CARD payments, VIP Preferred, Play+ Registration, and paysafecard Payout builder static inner class.
   */
  public static final class Builder {
    private String id;
    private String status;
    private String merchantCustomerId;
    private Locale locale;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private VerifiedStatus emailVerified;
    private VerifiedStatus phoneVerified;
    private DateOfBirth dateOfBirth;
    private Gender gender;
    private String nationality;
    private List<IdentityDocument> identityDocuments;
    private KycStatus kycStatus;

    private Builder() {
    }

    /**
     * The customer's profile ID in the system. If this is present, other fields are not required
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
     * The status of customer in the system, returned in the response
     * <p>
     * Sets the status and returns a reference to this Builder enabling method chaining.
     *
     * @param status the status to set
     * @return a reference to this Builder
     */
    public Builder status(String status) {
      this.status = status;
      return this;
    }

    /**
     * Reference number for the customer created by the merchant. Must be unique for each customer
     * <p>
     * Sets the merchantCustomerId and returns a reference to this Builder enabling method chaining.
     *
     * @param merchantCustomerId the merchantCustomerId to set
     * @return a reference to this Builder
     */
    public Builder merchantCustomerId(String merchantCustomerId) {
      this.merchantCustomerId = merchantCustomerId;
      return this;
    }

    /**
     * Sets the locale and returns a reference to this Builder enabling method chaining.
     *
     * @param locale the locale to set
     * @return a reference to this Builder
     */
    public Builder locale(Locale locale) {
      this.locale = locale;
      return this;
    }

    /**
     * The customer's first name
     * <p>
     * Sets the firstName and returns a reference to this Builder enabling method chaining.
     *
     * @param firstName the firstName to set
     * @return a reference to this Builder
     */
    public Builder firstName(String firstName) {
      this.firstName = firstName;
      return this;
    }

    /**
     * The customer's last name
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
     * The customer's email address
     * <p>
     * Sets the email and returns a reference to this Builder enabling method chaining.
     *
     * @param email the email to set
     * @return a reference to this Builder
     */
    public Builder email(String email) {
      this.email = email;
      return this;
    }

    /**
     * The customer's phone number
     * <p>
     * Sets the phone and returns a reference to this Builder enabling method chaining.
     *
     * @param phone the phone to set
     * @return a reference to this Builder
     */
    public Builder phone(String phone) {
      this.phone = phone;
      return this;
    }

    /**
     * Sets the emailVerified and returns a reference to this Builder enabling method chaining.
     *
     * @param emailVerified the emailVerified to set
     * @return a reference to this Builder
     */
    public Builder emailVerified(VerifiedStatus emailVerified) {
      this.emailVerified = emailVerified;
      return this;
    }

    /**
     * Sets the phoneVerified and returns a reference to this Builder enabling method chaining.
     *
     * @param phoneVerified the phoneVerified to set
     * @return a reference to this Builder
     */
    public Builder phoneVerified(VerifiedStatus phoneVerified) {
      this.phoneVerified = phoneVerified;
      return this;
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
     * Sets the gender and returns a reference to this Builder enabling method chaining.
     *
     * @param gender the gender to set
     * @return a reference to this Builder
     */
    public Builder gender(Gender gender) {
      this.gender = gender;
      return this;
    }

    /**
     * The customer's nationality
     * <p>
     * Sets the nationality and returns a reference to this Builder enabling method chaining.
     *
     * @param nationality the nationality to set
     * @return a reference to this Builder
     */
    public Builder nationality(String nationality) {
      this.nationality = nationality;
      return this;
    }

    /**
     * Customer's identity documents
     * <p>
     * Sets the identityDocuments and returns a reference to this Builder enabling method chaining.
     *
     * @param identityDocuments the identityDocuments to set
     * @return a reference to this Builder
     */
    public Builder identityDocuments(List<IdentityDocument> identityDocuments) {
      this.identityDocuments = identityDocuments;
      return this;
    }

    /**
     * Sets the kycStatus and returns a reference to this Builder enabling method chaining.
     *
     * @param kycStatus the kycStatus to set
     * @return a reference to this Builder
     */
    public Builder kycStatus(KycStatus kycStatus) {
      this.kycStatus = kycStatus;
      return this;
    }

    /**
     * Returns a Profile built from the parameters previously set.
     *
     * @return a Profile built with parameters of this Profile.Builder
     */
    public Profile build() {
      return new Profile(this);
    }
  }
}
