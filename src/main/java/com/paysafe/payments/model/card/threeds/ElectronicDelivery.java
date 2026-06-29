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



/**
 * Information about electronic delivery of goods or services
 */
public class ElectronicDelivery {

  @JsonProperty("isElectronicDelivery")
  private Boolean isElectronicDelivery;
  @JsonProperty("email")
  private String email;

  public ElectronicDelivery() {
    super();
  }

  private ElectronicDelivery(final Builder builder) {
    setIsElectronicDelivery(builder.isElectronicDelivery);
    setEmail(builder.email);
  }

  public static Builder builder() {
    return new Builder();
  }


  public ElectronicDelivery isElectronicDelivery(Boolean isElectronicDelivery) {
    this.isElectronicDelivery = isElectronicDelivery;
    return this;
  }

  /**
   * Whether the delivery is electronic
   *
   * @return isElectronicDelivery
   */
  public Boolean getIsElectronicDelivery() {
    return isElectronicDelivery;
  }

  public void setIsElectronicDelivery(Boolean isElectronicDelivery) {
    this.isElectronicDelivery = isElectronicDelivery;
  }


  public ElectronicDelivery email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Email address for electronic delivery
   *
   * @return email
   */
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ElectronicDelivery electronicDelivery = (ElectronicDelivery) o;
    return Objects.equals(this.isElectronicDelivery, electronicDelivery.isElectronicDelivery) &&
        Objects.equals(this.email, electronicDelivery.email);
  }

  @Override
  public int hashCode() {
    return Objects.hash(isElectronicDelivery, email);
  }

  @Override
  public String toString() {

    return "class ElectronicDelivery {\n"
        + "    isElectronicDelivery: " + toIndentedString(isElectronicDelivery) + "\n"
        + "    email: " + toIndentedString(email) + "\n"
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
   * Information about electronic delivery of goods or services builder static inner class.
   */
  public static final class Builder {
    private Boolean isElectronicDelivery;
    private String email;

    private Builder() {
    }

    /**
     * Whether the delivery is electronic
     * <p>
     * Sets the isElectronicDelivery and returns a reference to this Builder enabling method chaining.
     *
     * @param isElectronicDelivery the isElectronicDelivery to set
     * @return a reference to this Builder
     */
    public Builder isElectronicDelivery(Boolean isElectronicDelivery) {
      this.isElectronicDelivery = isElectronicDelivery;
      return this;
    }

    /**
     * Email address for electronic delivery
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
     * Returns a ElectronicDelivery built from the parameters previously set.
     *
     * @return a ElectronicDelivery built with parameters of this ElectronicDelivery.Builder
     */
    public ElectronicDelivery build() {
      return new ElectronicDelivery(this);
    }
  }
}
