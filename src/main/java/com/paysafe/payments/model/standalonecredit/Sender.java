// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.model.standalonecredit;

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
 * The Sender is deemed to be the person or party who has the contractual relationship with the end customer. **Note:** In case of Visa Direct with use cases Account to Account, Wallet transfer or Funds Transfer, the sender name should be the same as the recipient name.
 */
public class Sender {

  @JsonProperty("firstName")
  private String firstName;
  @JsonProperty("lastName")
  private String lastName;
  @JsonProperty("accountNumber")
  private String accountNumber;
  @JsonProperty("address")
  private SenderAddress address;

  public Sender() {
    super();
  }

  private Sender(final Builder builder) {
    setFirstName(builder.firstName);
    setLastName(builder.lastName);
    setAccountNumber(builder.accountNumber);
    setAddress(builder.address);
  }

  public static Builder builder() {
    return new Builder();
  }


  public Sender firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  /**
   * Sender's first name.
   *
   * @return firstName
   */
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }


  public Sender lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  /**
   * Sender's last name.
   *
   * @return lastName
   */
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }


  public Sender accountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
    return this;
  }

  /**
   * This is the sender's account number, e.g., a loan agreement number or customer ID.
   *
   * @return accountNumber
   */
  public String getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
  }


  public Sender address(SenderAddress address) {
    this.address = address;
    return this;
  }

  /**
   * Get address
   *
   * @return address
   */
  public SenderAddress getAddress() {
    return address;
  }

  public void setAddress(SenderAddress address) {
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
    Sender sender = (Sender) o;
    return Objects.equals(this.firstName, sender.firstName) &&
        Objects.equals(this.lastName, sender.lastName) &&
        Objects.equals(this.accountNumber, sender.accountNumber) &&
        Objects.equals(this.address, sender.address);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstName, lastName, accountNumber, address);
  }

  @Override
  public String toString() {

    return "class Sender {\n"
        + "    firstName: " + toIndentedString(firstName) + "\n"
        + "    lastName: " + toIndentedString(lastName) + "\n"
        + "    accountNumber: " + toIndentedString(accountNumber) + "\n"
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
   * The Sender is deemed to be the person or party who has the contractual relationship with the end customer. **Note:** In case of Visa Direct with use cases Account to Account, Wallet transfer or Funds Transfer, the sender name should be the same as the recipient name. builder static inner class.
   */
  public static final class Builder {
    private String firstName;
    private String lastName;
    private String accountNumber;
    private SenderAddress address;

    private Builder() {
    }

    /**
     * Sender's first name.
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
     * Sender's last name.
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
     * This is the sender's account number, e.g., a loan agreement number or customer ID.
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
     * Sets the address and returns a reference to this Builder enabling method chaining.
     *
     * @param address the address to set
     * @return a reference to this Builder
     */
    public Builder address(SenderAddress address) {
      this.address = address;
      return this;
    }

    /**
     * Returns a Sender built from the parameters previously set.
     *
     * @return a Sender built with parameters of this Sender.Builder
     */
    public Sender build() {
      return new Sender(this);
    }
  }
}
