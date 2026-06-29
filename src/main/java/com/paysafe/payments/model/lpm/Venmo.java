// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.model.lpm;

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
 * Venmo.
 */
public class Venmo {

  @JsonProperty("consumerId")
  private String consumerId;
  @JsonProperty("merchantAccountId")
  private String merchantAccountId;
  @JsonProperty("profileId")
  private String profileId;

  public Venmo() {
    super();
  }

  private Venmo(final Builder builder) {
    setConsumerId(builder.consumerId);
    setMerchantAccountId(builder.merchantAccountId);
    setProfileId(builder.profileId);
  }

  public static Builder builder() {
    return new Builder();
  }


  public Venmo consumerId(String consumerId) {
    this.consumerId = consumerId;
    return this;
  }

  /**
   * This is your identifier for your consumer and must be unique per consumer. We store this after your first successful Venmo transaction for a given consumer (during this first transaction the consumer agrees to link their Venmo wallet for future transactions). When you subsequently send in the same consumerId, we debit the consumer's wallet directly without the consumer having to agree to each transaction
   *
   * @return consumerId
   */
  public String getConsumerId() {
    return consumerId;
  }

  public void setConsumerId(String consumerId) {
    this.consumerId = consumerId;
  }


  public Venmo merchantAccountId(String merchantAccountId) {
    this.merchantAccountId = merchantAccountId;
    return this;
  }

  /**
   * You can set up multiple accounts with Braintree, and each account can settle funds into a different bank account. This parameter therefore allows you to control which of your bank accounts is used to receive settlement. This only applies to pay-ins and not payouts. If you pass it for payouts the value will be ignored. If not supplied for pay-ins, your default Braintree account will be used
   *
   * @return merchantAccountId
   */
  public String getMerchantAccountId() {
    return merchantAccountId;
  }

  public void setMerchantAccountId(String merchantAccountId) {
    this.merchantAccountId = merchantAccountId;
  }


  public Venmo profileId(String profileId) {
    this.profileId = profileId;
    return this;
  }

  /**
   * You can set up multiple profiles with Braintree, where each profile shows the consumer a different logo and description during checkout on the Venmo app, and on the Venmo statement. This parameter therefore allows you to vary the consumer experience (for example, if you have multiple brands, you can display a different logo for each). This only applies to pay-ins and not payouts. If you pass it for payouts the value will be ignored. If not supplied for pay-ins, your default profile will be used
   *
   * @return profileId
   */
  public String getProfileId() {
    return profileId;
  }

  public void setProfileId(String profileId) {
    this.profileId = profileId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Venmo venmo = (Venmo) o;
    return Objects.equals(this.consumerId, venmo.consumerId) &&
        Objects.equals(this.merchantAccountId, venmo.merchantAccountId) &&
        Objects.equals(this.profileId, venmo.profileId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(consumerId, merchantAccountId, profileId);
  }

  @Override
  public String toString() {

    return "class Venmo {\n"
        + "    consumerId: " + toIndentedString(consumerId) + "\n"
        + "    merchantAccountId: " + toIndentedString(merchantAccountId) + "\n"
        + "    profileId: " + toIndentedString(profileId) + "\n"
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
   * Venmo. builder static inner class.
   */
  public static final class Builder {
    private String consumerId;
    private String merchantAccountId;
    private String profileId;

    private Builder() {
    }

    /**
     * This is your identifier for your consumer and must be unique per consumer. We store this after your first successful Venmo transaction for a given consumer (during this first transaction the consumer agrees to link their Venmo wallet for future transactions). When you subsequently send in the same consumerId, we debit the consumer's wallet directly without the consumer having to agree to each transaction
     * <p>
     * Sets the consumerId and returns a reference to this Builder enabling method chaining.
     *
     * @param consumerId the consumerId to set
     * @return a reference to this Builder
     */
    public Builder consumerId(String consumerId) {
      this.consumerId = consumerId;
      return this;
    }

    /**
     * You can set up multiple accounts with Braintree, and each account can settle funds into a different bank account. This parameter therefore allows you to control which of your bank accounts is used to receive settlement. This only applies to pay-ins and not payouts. If you pass it for payouts the value will be ignored. If not supplied for pay-ins, your default Braintree account will be used
     * <p>
     * Sets the merchantAccountId and returns a reference to this Builder enabling method chaining.
     *
     * @param merchantAccountId the merchantAccountId to set
     * @return a reference to this Builder
     */
    public Builder merchantAccountId(String merchantAccountId) {
      this.merchantAccountId = merchantAccountId;
      return this;
    }

    /**
     * You can set up multiple profiles with Braintree, where each profile shows the consumer a different logo and description during checkout on the Venmo app, and on the Venmo statement. This parameter therefore allows you to vary the consumer experience (for example, if you have multiple brands, you can display a different logo for each). This only applies to pay-ins and not payouts. If you pass it for payouts the value will be ignored. If not supplied for pay-ins, your default profile will be used
     * <p>
     * Sets the profileId and returns a reference to this Builder enabling method chaining.
     *
     * @param profileId the profileId to set
     * @return a reference to this Builder
     */
    public Builder profileId(String profileId) {
      this.profileId = profileId;
      return this;
    }

    /**
     * Returns a Venmo built from the parameters previously set.
     *
     * @return a Venmo built with parameters of this Venmo.Builder
     */
    public Venmo build() {
      return new Venmo(this);
    }
  }
}
