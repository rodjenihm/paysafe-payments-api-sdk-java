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



/**
 * Merchant details for the transaction.
 */
public class MerchantDescriptor {

  @JsonProperty("dynamicDescriptor")
  private String dynamicDescriptor;
  @JsonProperty("phone")
  private String phone;

  public MerchantDescriptor() {
    super();
  }

  private MerchantDescriptor(final Builder builder) {
    setDynamicDescriptor(builder.dynamicDescriptor);
    setPhone(builder.phone);
  }

  public static Builder builder() {
    return new Builder();
  }


  public MerchantDescriptor dynamicDescriptor(String dynamicDescriptor) {
    this.dynamicDescriptor = dynamicDescriptor;
    return this;
  }

  /**
   * This is a merchant descriptor that will be displayed on a customer’s card statement.
   *
   * @return dynamicDescriptor
   */
  public String getDynamicDescriptor() {
    return dynamicDescriptor;
  }

  public void setDynamicDescriptor(String dynamicDescriptor) {
    this.dynamicDescriptor = dynamicDescriptor;
  }


  public MerchantDescriptor phone(String phone) {
    this.phone = phone;
    return this;
  }

  /**
   * This is the merchant's phone number, which is appended to the merchant descriptor on a customer's card statement. **Note:** This field is used only in case of payment.
   *
   * @return phone
   */
  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MerchantDescriptor merchantDescriptor = (MerchantDescriptor) o;
    return Objects.equals(this.dynamicDescriptor, merchantDescriptor.dynamicDescriptor) &&
        Objects.equals(this.phone, merchantDescriptor.phone);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dynamicDescriptor, phone);
  }

  @Override
  public String toString() {

    return "class MerchantDescriptor {\n"
        + "    dynamicDescriptor: " + toIndentedString(dynamicDescriptor) + "\n"
        + "    phone: " + toIndentedString(phone) + "\n"
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
   * Merchant details for the transaction. builder static inner class.
   */
  public static final class Builder {
    private String dynamicDescriptor;
    private String phone;

    private Builder() {
    }

    /**
     * This is a merchant descriptor that will be displayed on a customer’s card statement.
     * <p>
     * Sets the dynamicDescriptor and returns a reference to this Builder enabling method chaining.
     *
     * @param dynamicDescriptor the dynamicDescriptor to set
     * @return a reference to this Builder
     */
    public Builder dynamicDescriptor(String dynamicDescriptor) {
      this.dynamicDescriptor = dynamicDescriptor;
      return this;
    }

    /**
     * This is the merchant's phone number, which is appended to the merchant descriptor on a customer's card statement. **Note:** This field is used only in case of payment.
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
     * Returns a MerchantDescriptor built from the parameters previously set.
     *
     * @return a MerchantDescriptor built with parameters of this MerchantDescriptor.Builder
     */
    public MerchantDescriptor build() {
      return new MerchantDescriptor(this);
    }
  }
}
