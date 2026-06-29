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
 * This is more detailed information about the items that are being purchased for Level2Level3 merchants. This class is typically used for creating detailed receipts or invoices that include itemized purchases, taxes and total costs.
 */
public class LineItems {

  @JsonProperty("description")
  private String description;
  @JsonProperty("productCode")
  private String productCode;
  @JsonProperty("quantity")
  private Integer quantity;
  @JsonProperty("unitAmount")
  private Integer unitAmount;
  @JsonProperty("taxRate")
  private Integer taxRate;
  @JsonProperty("taxAmount")
  private Integer taxAmount;
  @JsonProperty("totalAmount")
  private Integer totalAmount;

  public LineItems() {
    super();
  }

  private LineItems(final Builder builder) {
    setDescription(builder.description);
    setProductCode(builder.productCode);
    setQuantity(builder.quantity);
    setUnitAmount(builder.unitAmount);
    setTaxRate(builder.taxRate);
    setTaxAmount(builder.taxAmount);
    setTotalAmount(builder.totalAmount);
  }

  public static Builder builder() {
    return new Builder();
  }


  public LineItems description(String description) {
    this.description = description;
    return this;
  }

  /**
   * This is a description of the item(s) being purchased
   *
   * @return description
   */
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  public LineItems productCode(String productCode) {
    this.productCode = productCode;
    return this;
  }

  /**
   * This is the merchant-defined description code of the item being purchased.
   *
   * @return productCode
   */
  public String getProductCode() {
    return productCode;
  }

  public void setProductCode(String productCode) {
    this.productCode = productCode;
  }


  public LineItems quantity(Integer quantity) {
    this.quantity = quantity;
    return this;
  }

  /**
   * This is the quantity of the item. Note - Max 4 decimals is allowed
   *
   * @return quantity
   */
  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }


  public LineItems unitAmount(Integer unitAmount) {
    this.unitAmount = unitAmount;
    return this;
  }

  /**
   * This is the unit price of the item being purchased, in minor units. The currency will be based on the account setting
   *
   * @return unitAmount
   */
  public Integer getUnitAmount() {
    return unitAmount;
  }

  public void setUnitAmount(Integer unitAmount) {
    this.unitAmount = unitAmount;
  }


  public LineItems taxRate(Integer taxRate) {
    this.taxRate = taxRate;
    return this;
  }

  /**
   * This is the tax rate used to calculate the tax amount. For example, if the tax rate is 10.5%, this value should be 10.5. Note - Max 2 decimals allowed
   *
   * @return taxRate
   */
  public Integer getTaxRate() {
    return taxRate;
  }

  public void setTaxRate(Integer taxRate) {
    this.taxRate = taxRate;
  }


  public LineItems taxAmount(Integer taxAmount) {
    this.taxAmount = taxAmount;
    return this;
  }

  /**
   * This is the amount of any value-added taxes that can be associated with the purchased item, in minor units. The currency will be based on the account setting. Note - Our system will not validate the accuracy of this value. The merchant's application must calculate this value correctly
   *
   * @return taxAmount
   */
  public Integer getTaxAmount() {
    return taxAmount;
  }

  public void setTaxAmount(Integer taxAmount) {
    this.taxAmount = taxAmount;
  }


  public LineItems totalAmount(Integer totalAmount) {
    this.totalAmount = totalAmount;
    return this;
  }

  /**
   * This is the total amount of the line item, typically calculated as price multiplied by quantity, in minor units. The currency is based on the account setting. Note - Our system will not validate the accuracy of this value. The merchant's application must calculate this value correctly
   *
   * @return totalAmount
   */
  public Integer getTotalAmount() {
    return totalAmount;
  }

  public void setTotalAmount(Integer totalAmount) {
    this.totalAmount = totalAmount;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LineItems lineItems = (LineItems) o;
    return Objects.equals(this.description, lineItems.description) &&
        Objects.equals(this.productCode, lineItems.productCode) &&
        Objects.equals(this.quantity, lineItems.quantity) &&
        Objects.equals(this.unitAmount, lineItems.unitAmount) &&
        Objects.equals(this.taxRate, lineItems.taxRate) &&
        Objects.equals(this.taxAmount, lineItems.taxAmount) &&
        Objects.equals(this.totalAmount, lineItems.totalAmount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, productCode, quantity, unitAmount, taxRate, taxAmount, totalAmount);
  }

  @Override
  public String toString() {

    return "class LineItems {\n"
        + "    description: " + toIndentedString(description) + "\n"
        + "    productCode: " + toIndentedString(productCode) + "\n"
        + "    quantity: " + toIndentedString(quantity) + "\n"
        + "    unitAmount: " + toIndentedString(unitAmount) + "\n"
        + "    taxRate: " + toIndentedString(taxRate) + "\n"
        + "    taxAmount: " + toIndentedString(taxAmount) + "\n"
        + "    totalAmount: " + toIndentedString(totalAmount) + "\n"
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
   * This is more detailed information about the items that are being purchased for Level2Level3 merchants. This class is typically used for creating detailed receipts or invoices that include itemized purchases, taxes and total costs. builder static inner class.
   */
  public static final class Builder {
    private String description;
    private String productCode;
    private Integer quantity;
    private Integer unitAmount;
    private Integer taxRate;
    private Integer taxAmount;
    private Integer totalAmount;

    private Builder() {
    }

    /**
     * This is a description of the item(s) being purchased
     * <p>
     * Sets the description and returns a reference to this Builder enabling method chaining.
     *
     * @param description the description to set
     * @return a reference to this Builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * This is the merchant-defined description code of the item being purchased.
     * <p>
     * Sets the productCode and returns a reference to this Builder enabling method chaining.
     *
     * @param productCode the productCode to set
     * @return a reference to this Builder
     */
    public Builder productCode(String productCode) {
      this.productCode = productCode;
      return this;
    }

    /**
     * This is the quantity of the item. Note - Max 4 decimals is allowed
     * <p>
     * Sets the quantity and returns a reference to this Builder enabling method chaining.
     *
     * @param quantity the quantity to set
     * @return a reference to this Builder
     */
    public Builder quantity(Integer quantity) {
      this.quantity = quantity;
      return this;
    }

    /**
     * This is the unit price of the item being purchased, in minor units. The currency will be based on the account setting
     * <p>
     * Sets the unitAmount and returns a reference to this Builder enabling method chaining.
     *
     * @param unitAmount the unitAmount to set
     * @return a reference to this Builder
     */
    public Builder unitAmount(Integer unitAmount) {
      this.unitAmount = unitAmount;
      return this;
    }

    /**
     * This is the tax rate used to calculate the tax amount. For example, if the tax rate is 10.5%, this value should be 10.5. Note - Max 2 decimals allowed
     * <p>
     * Sets the taxRate and returns a reference to this Builder enabling method chaining.
     *
     * @param taxRate the taxRate to set
     * @return a reference to this Builder
     */
    public Builder taxRate(Integer taxRate) {
      this.taxRate = taxRate;
      return this;
    }

    /**
     * This is the amount of any value-added taxes that can be associated with the purchased item, in minor units. The currency will be based on the account setting. Note - Our system will not validate the accuracy of this value. The merchant's application must calculate this value correctly
     * <p>
     * Sets the taxAmount and returns a reference to this Builder enabling method chaining.
     *
     * @param taxAmount the taxAmount to set
     * @return a reference to this Builder
     */
    public Builder taxAmount(Integer taxAmount) {
      this.taxAmount = taxAmount;
      return this;
    }

    /**
     * This is the total amount of the line item, typically calculated as price multiplied by quantity, in minor units. The currency is based on the account setting. Note - Our system will not validate the accuracy of this value. The merchant's application must calculate this value correctly
     * <p>
     * Sets the totalAmount and returns a reference to this Builder enabling method chaining.
     *
     * @param totalAmount the totalAmount to set
     * @return a reference to this Builder
     */
    public Builder totalAmount(Integer totalAmount) {
      this.totalAmount = totalAmount;
      return this;
    }

    /**
     * Returns a LineItems built from the parameters previously set.
     *
     * @return a LineItems built with parameters of this LineItems.Builder
     */
    public LineItems build() {
      return new LineItems(this);
    }
  }
}
