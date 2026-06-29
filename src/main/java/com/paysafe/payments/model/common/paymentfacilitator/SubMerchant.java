// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.model.common.paymentfacilitator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.paysafe.payments.model.payment.Payment;



/**
 * Contains information for Payment facilitator sub-merchant.
 */
public class SubMerchant {

  @JsonProperty("id")
  private String id;
  @JsonProperty("name")
  private String name;
  @JsonProperty("phone")
  private String phone;
  @JsonProperty("email")
  private String email;
  @JsonProperty("url")
  private String url;
  @JsonProperty("address")
  private SubMerchantAddress address;

  public SubMerchant() {
    super();
  }

  private SubMerchant(final Builder builder) {
    setId(builder.id);
    setName(builder.name);
    setPhone(builder.phone);
    setEmail(builder.email);
    setUrl(builder.url);
    setAddress(builder.address);
  }

  public static Builder builder() {
    return new Builder();
  }


  public SubMerchant id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Field contains an identifier of the actual merchant
   *
   * @return id
   */
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public SubMerchant name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Field contains the name of the actual merchant
   *
   * @return name
   */
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public SubMerchant phone(String phone) {
    this.phone = phone;
    return this;
  }

  /**
   * Field contains the phone number of the actual merchant
   *
   * @return phone
   */
  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }


  public SubMerchant email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Field contains the email address of the actual merchant
   *
   * @return email
   */
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  public SubMerchant url(String url) {
    this.url = url;
    return this;
  }

  /**
   * Field contains the url address of the actual merchant
   *
   * @return url
   */
  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }


  public SubMerchant address(SubMerchantAddress address) {
    this.address = address;
    return this;
  }

  /**
   * Get address
   *
   * @return address
   */
  public SubMerchantAddress getAddress() {
    return address;
  }

  public void setAddress(SubMerchantAddress address) {
    this.address = address;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SubMerchant subMerchant = (SubMerchant) o;
    return Objects.equals(this.id, subMerchant.id) &&
        Objects.equals(this.name, subMerchant.name) &&
        Objects.equals(this.phone, subMerchant.phone) &&
        Objects.equals(this.email, subMerchant.email) &&
        Objects.equals(this.url, subMerchant.url) &&
        Objects.equals(this.address, subMerchant.address);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, phone, email, url, address);
  }

  @Override
  public String toString() {

    return "class SubMerchant {\n"
        + "    id: " + toIndentedString(id) + "\n"
        + "    name: " + toIndentedString(name) + "\n"
        + "    phone: " + toIndentedString(phone) + "\n"
        + "    email: " + toIndentedString(email) + "\n"
        + "    url: " + toIndentedString(url) + "\n"
        + "    address: " + toIndentedString(address) + "\n"
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
   * Contains information for Payment facilitator sub-merchant. builder static inner class.
   */
  public static final class Builder {
    private String id;
    private String name;
    private String phone;
    private String email;
    private String url;
    private SubMerchantAddress address;

    private Builder() {
    }

    /**
     * Field contains an identifier of the actual merchant
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
     * Field contains the name of the actual merchant
     * <p>
     * Sets the name and returns a reference to this Builder enabling method chaining.
     *
     * @param name the name to set
     * @return a reference to this Builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Field contains the phone number of the actual merchant
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
     * Field contains the email address of the actual merchant
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
     * Field contains the url address of the actual merchant
     * <p>
     * Sets the url and returns a reference to this Builder enabling method chaining.
     *
     * @param url the url to set
     * @return a reference to this Builder
     */
    public Builder url(String url) {
      this.url = url;
      return this;
    }

    /**
     * Sets the address and returns a reference to this Builder enabling method chaining.
     *
     * @param address the address to set
     * @return a reference to this Builder
     */
    public Builder address(SubMerchantAddress address) {
      this.address = address;
      return this;
    }

    /**
     * Returns a SubMerchant built from the parameters previously set.
     *
     * @return a SubMerchant built with parameters of this SubMerchant.Builder
     */
    public SubMerchant build() {
      return new SubMerchant(this);
    }
  }
}
