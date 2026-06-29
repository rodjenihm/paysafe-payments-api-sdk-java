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
import com.paysafe.payments.model.card.enums.PreOrderPurchaseIndicator;
import com.paysafe.payments.model.card.enums.ReorderItemsIndicator;
import com.paysafe.payments.model.card.enums.ShippingIndicator;



/**
 * Order details for 3DS authentication
 */
public class OrderItemDetails {

  @JsonProperty("preOrderItemAvailabilityDate")
  private String preOrderItemAvailabilityDate;
  @JsonProperty("preOrderPurchaseIndicator")
  private PreOrderPurchaseIndicator preOrderPurchaseIndicator;
  @JsonProperty("reorderItemsIndicator")
  private ReorderItemsIndicator reorderItemsIndicator;
  @JsonProperty("shippingIndicator")
  private ShippingIndicator shippingIndicator;

  public OrderItemDetails() {
    super();
  }

  private OrderItemDetails(final Builder builder) {
    setPreOrderItemAvailabilityDate(builder.preOrderItemAvailabilityDate);
    setPreOrderPurchaseIndicator(builder.preOrderPurchaseIndicator);
    setReorderItemsIndicator(builder.reorderItemsIndicator);
    setShippingIndicator(builder.shippingIndicator);
  }

  public static Builder builder() {
    return new Builder();
  }


  public OrderItemDetails preOrderItemAvailabilityDate(String preOrderItemAvailabilityDate) {
    this.preOrderItemAvailabilityDate = preOrderItemAvailabilityDate;
    return this;
  }

  /**
   * For a pre-ordered purchase, this is the date that the merchandise is expected to be available
   *
   * @return preOrderItemAvailabilityDate
   */
  public String getPreOrderItemAvailabilityDate() {
    return preOrderItemAvailabilityDate;
  }

  public void setPreOrderItemAvailabilityDate(String preOrderItemAvailabilityDate) {
    this.preOrderItemAvailabilityDate = preOrderItemAvailabilityDate;
  }


  public OrderItemDetails preOrderPurchaseIndicator(PreOrderPurchaseIndicator preOrderPurchaseIndicator) {
    this.preOrderPurchaseIndicator = preOrderPurchaseIndicator;
    return this;
  }

  /**
   * Get preOrderPurchaseIndicator
   *
   * @return preOrderPurchaseIndicator
   */
  public PreOrderPurchaseIndicator getPreOrderPurchaseIndicator() {
    return preOrderPurchaseIndicator;
  }

  public void setPreOrderPurchaseIndicator(PreOrderPurchaseIndicator preOrderPurchaseIndicator) {
    this.preOrderPurchaseIndicator = preOrderPurchaseIndicator;
  }


  public OrderItemDetails reorderItemsIndicator(ReorderItemsIndicator reorderItemsIndicator) {
    this.reorderItemsIndicator = reorderItemsIndicator;
    return this;
  }

  /**
   * Get reorderItemsIndicator
   *
   * @return reorderItemsIndicator
   */
  public ReorderItemsIndicator getReorderItemsIndicator() {
    return reorderItemsIndicator;
  }

  public void setReorderItemsIndicator(ReorderItemsIndicator reorderItemsIndicator) {
    this.reorderItemsIndicator = reorderItemsIndicator;
  }


  public OrderItemDetails shippingIndicator(ShippingIndicator shippingIndicator) {
    this.shippingIndicator = shippingIndicator;
    return this;
  }

  /**
   * Get shippingIndicator
   *
   * @return shippingIndicator
   */
  public ShippingIndicator getShippingIndicator() {
    return shippingIndicator;
  }

  public void setShippingIndicator(ShippingIndicator shippingIndicator) {
    this.shippingIndicator = shippingIndicator;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrderItemDetails orderItemDetails = (OrderItemDetails) o;
    return Objects.equals(this.preOrderItemAvailabilityDate, orderItemDetails.preOrderItemAvailabilityDate) &&
        Objects.equals(this.preOrderPurchaseIndicator, orderItemDetails.preOrderPurchaseIndicator) &&
        Objects.equals(this.reorderItemsIndicator, orderItemDetails.reorderItemsIndicator) &&
        Objects.equals(this.shippingIndicator, orderItemDetails.shippingIndicator);
  }

  @Override
  public int hashCode() {
    return Objects.hash(preOrderItemAvailabilityDate, preOrderPurchaseIndicator, reorderItemsIndicator, shippingIndicator);
  }

  @Override
  public String toString() {

    return "class OrderItemDetails {\n"
        + "    preOrderItemAvailabilityDate: " + toIndentedString(preOrderItemAvailabilityDate) + "\n"
        + "    preOrderPurchaseIndicator: " + toIndentedString(preOrderPurchaseIndicator) + "\n"
        + "    reorderItemsIndicator: " + toIndentedString(reorderItemsIndicator) + "\n"
        + "    shippingIndicator: " + toIndentedString(shippingIndicator) + "\n"
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
   * Order details for 3DS authentication builder static inner class.
   */
  public static final class Builder {
    private String preOrderItemAvailabilityDate;
    private PreOrderPurchaseIndicator preOrderPurchaseIndicator;
    private ReorderItemsIndicator reorderItemsIndicator;
    private ShippingIndicator shippingIndicator;

    private Builder() {
    }

    /**
     * For a pre-ordered purchase, this is the date that the merchandise is expected to be available
     * <p>
     * Sets the preOrderItemAvailabilityDate and returns a reference to this Builder enabling method chaining.
     *
     * @param preOrderItemAvailabilityDate the preOrderItemAvailabilityDate to set
     * @return a reference to this Builder
     */
    public Builder preOrderItemAvailabilityDate(String preOrderItemAvailabilityDate) {
      this.preOrderItemAvailabilityDate = preOrderItemAvailabilityDate;
      return this;
    }

    /**
     * Sets the preOrderPurchaseIndicator and returns a reference to this Builder enabling method chaining.
     *
     * @param preOrderPurchaseIndicator the preOrderPurchaseIndicator to set
     * @return a reference to this Builder
     */
    public Builder preOrderPurchaseIndicator(PreOrderPurchaseIndicator preOrderPurchaseIndicator) {
      this.preOrderPurchaseIndicator = preOrderPurchaseIndicator;
      return this;
    }

    /**
     * Sets the reorderItemsIndicator and returns a reference to this Builder enabling method chaining.
     *
     * @param reorderItemsIndicator the reorderItemsIndicator to set
     * @return a reference to this Builder
     */
    public Builder reorderItemsIndicator(ReorderItemsIndicator reorderItemsIndicator) {
      this.reorderItemsIndicator = reorderItemsIndicator;
      return this;
    }

    /**
     * Sets the shippingIndicator and returns a reference to this Builder enabling method chaining.
     *
     * @param shippingIndicator the shippingIndicator to set
     * @return a reference to this Builder
     */
    public Builder shippingIndicator(ShippingIndicator shippingIndicator) {
      this.shippingIndicator = shippingIndicator;
      return this;
    }

    /**
     * Returns a OrderItemDetails built from the parameters previously set.
     *
     * @return a OrderItemDetails built with parameters of this OrderItemDetails.Builder
     */
    public OrderItemDetails build() {
      return new OrderItemDetails(this);
    }
  }
}
