// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.model.common.travel.carrental;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.paysafe.payments.model.common.travel.carrental.enums.CarRentalExtraChargeType;
import com.paysafe.payments.model.common.travel.carrental.enums.VehicleClass;
import com.paysafe.payments.model.customer.Customer;



/**
 * Contains information about your car rental. <br>**Note:** This object is only for Car rental Merchants. <br>**Note:** This field has to be passed only in case of card transactions.
 */
public class CarRentalDetails {

  @JsonProperty("rentalAgreementNumber")
  private String rentalAgreementNumber;
  @JsonProperty("renterName")
  private String renterName;
  @JsonProperty("rentalDays")
  private Integer rentalDays;
  @JsonProperty("noShow")
  private Boolean noShow;
  @JsonProperty("extraCharges")
  private List<CarRentalExtraChargeType> extraCharges;
  @JsonProperty("customerServicePhone")
  private String customerServicePhone;
  @JsonProperty("returnDetails")
  private CarRentalReturnDetails returnDetails;
  @JsonProperty("pickupDetails")
  private CarRentalPickupDetails pickupDetails;
  @JsonProperty("vehicleClass")
  private VehicleClass vehicleClass;

  public CarRentalDetails() {
    super();
  }

  private CarRentalDetails(final Builder builder) {
    setRentalAgreementNumber(builder.rentalAgreementNumber);
    setRenterName(builder.renterName);
    setRentalDays(builder.rentalDays);
    setNoShow(builder.noShow);
    setExtraCharges(builder.extraCharges);
    setCustomerServicePhone(builder.customerServicePhone);
    setReturnDetails(builder.returnDetails);
    setPickupDetails(builder.pickupDetails);
    setVehicleClass(builder.vehicleClass);
  }

  public static Builder builder() {
    return new Builder();
  }


  public CarRentalDetails rentalAgreementNumber(String rentalAgreementNumber) {
    this.rentalAgreementNumber = rentalAgreementNumber;
    return this;
  }

  /**
   * The rental agreement number for the car rental. Required during settlement
   *
   * @return rentalAgreementNumber
   */
  public String getRentalAgreementNumber() {
    return rentalAgreementNumber;
  }

  public void setRentalAgreementNumber(String rentalAgreementNumber) {
    this.rentalAgreementNumber = rentalAgreementNumber;
  }


  public CarRentalDetails renterName(String renterName) {
    this.renterName = renterName;
    return this;
  }

  /**
   * The name of the person renting the car. Required during settlement request with Mastercard or Amex for integration with TSYS processor
   *
   * @return renterName
   */
  public String getRenterName() {
    return renterName;
  }

  public void setRenterName(String renterName) {
    this.renterName = renterName;
  }


  public CarRentalDetails rentalDays(Integer rentalDays) {
    this.rentalDays = rentalDays;
    return this;
  }

  /**
   * The total number of days the car is rented for. Required during authorization request for integration with TSYS processor
   *
   * @return rentalDays
   */
  public Integer getRentalDays() {
    return rentalDays;
  }

  public void setRentalDays(Integer rentalDays) {
    this.rentalDays = rentalDays;
  }


  public CarRentalDetails noShow(Boolean noShow) {
    this.noShow = noShow;
    return this;
  }

  /**
   * Indicates if the customer didn't check in for their booking. true if the customer didn't check in, false if the customer checked in
   *
   * @return noShow
   */
  public Boolean getNoShow() {
    return noShow;
  }

  public void setNoShow(Boolean noShow) {
    this.noShow = noShow;
  }


  public CarRentalDetails extraCharges(List<CarRentalExtraChargeType> extraCharges) {
    this.extraCharges = extraCharges;
    return this;
  }

  public CarRentalDetails addExtraChargesItem(CarRentalExtraChargeType extraChargesItem) {
    if (this.extraCharges == null) {
      this.extraCharges = new ArrayList<>();
    }
    this.extraCharges.add(extraChargesItem);
    return this;
  }

  public CarRentalDetails removeExtraChargesItem(CarRentalExtraChargeType extraChargesItem) {
    if (extraChargesItem != null && this.extraCharges != null) {
      this.extraCharges.remove(extraChargesItem);
    }

    return this;
  }

  /**
   * Indicates if the reservation includes additional ancillary charges
   *
   * @return extraCharges
   */
  public List<CarRentalExtraChargeType> getExtraCharges() {
    return extraCharges;
  }

  public void setExtraCharges(List<CarRentalExtraChargeType> extraCharges) {
    this.extraCharges = extraCharges;
  }


  public CarRentalDetails customerServicePhone(String customerServicePhone) {
    this.customerServicePhone = customerServicePhone;
    return this;
  }

  /**
   * Customer service phone number
   *
   * @return customerServicePhone
   */
  public String getCustomerServicePhone() {
    return customerServicePhone;
  }

  public void setCustomerServicePhone(String customerServicePhone) {
    this.customerServicePhone = customerServicePhone;
  }


  public CarRentalDetails returnDetails(CarRentalReturnDetails returnDetails) {
    this.returnDetails = returnDetails;
    return this;
  }

  /**
   * Get returnDetails
   *
   * @return returnDetails
   */
  public CarRentalReturnDetails getReturnDetails() {
    return returnDetails;
  }

  public void setReturnDetails(CarRentalReturnDetails returnDetails) {
    this.returnDetails = returnDetails;
  }


  public CarRentalDetails pickupDetails(CarRentalPickupDetails pickupDetails) {
    this.pickupDetails = pickupDetails;
    return this;
  }

  /**
   * Get pickupDetails
   *
   * @return pickupDetails
   */
  public CarRentalPickupDetails getPickupDetails() {
    return pickupDetails;
  }

  public void setPickupDetails(CarRentalPickupDetails pickupDetails) {
    this.pickupDetails = pickupDetails;
  }


  public CarRentalDetails vehicleClass(VehicleClass vehicleClass) {
    this.vehicleClass = vehicleClass;
    return this;
  }

  /**
   * Get vehicleClass
   *
   * @return vehicleClass
   */
  public VehicleClass getVehicleClass() {
    return vehicleClass;
  }

  public void setVehicleClass(VehicleClass vehicleClass) {
    this.vehicleClass = vehicleClass;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CarRentalDetails carRentalDetails = (CarRentalDetails) o;
    return Objects.equals(this.rentalAgreementNumber, carRentalDetails.rentalAgreementNumber) &&
        Objects.equals(this.renterName, carRentalDetails.renterName) &&
        Objects.equals(this.rentalDays, carRentalDetails.rentalDays) &&
        Objects.equals(this.noShow, carRentalDetails.noShow) &&
        Objects.equals(this.extraCharges, carRentalDetails.extraCharges) &&
        Objects.equals(this.customerServicePhone, carRentalDetails.customerServicePhone) &&
        Objects.equals(this.returnDetails, carRentalDetails.returnDetails) &&
        Objects.equals(this.pickupDetails, carRentalDetails.pickupDetails) &&
        Objects.equals(this.vehicleClass, carRentalDetails.vehicleClass);
  }

  @Override
  public int hashCode() {
    return Objects.hash(rentalAgreementNumber, renterName, rentalDays, noShow, extraCharges, customerServicePhone, returnDetails, pickupDetails, vehicleClass);
  }

  @Override
  public String toString() {

    return "class CarRentalDetails {\n"
        + "    rentalAgreementNumber: " + toIndentedString(rentalAgreementNumber) + "\n"
        + "    renterName: " + toIndentedString(renterName) + "\n"
        + "    rentalDays: " + toIndentedString(rentalDays) + "\n"
        + "    noShow: " + toIndentedString(noShow) + "\n"
        + "    extraCharges: " + toIndentedString(extraCharges) + "\n"
        + "    customerServicePhone: " + toIndentedString(customerServicePhone) + "\n"
        + "    returnDetails: " + toIndentedString(returnDetails) + "\n"
        + "    pickupDetails: " + toIndentedString(pickupDetails) + "\n"
        + "    vehicleClass: " + toIndentedString(vehicleClass) + "\n"
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
   * Contains information about your car rental. <br>**Note:** This object is only for Car rental Merchants. <br>**Note:** This field has to be passed only in case of card transactions. builder static inner class.
   */
  public static final class Builder {
    private String rentalAgreementNumber;
    private String renterName;
    private Integer rentalDays;
    private Boolean noShow;
    private List<CarRentalExtraChargeType> extraCharges;
    private String customerServicePhone;
    private CarRentalReturnDetails returnDetails;
    private CarRentalPickupDetails pickupDetails;
    private VehicleClass vehicleClass;

    private Builder() {
    }

    /**
     * The rental agreement number for the car rental. Required during settlement
     * <p>
     * Sets the rentalAgreementNumber and returns a reference to this Builder enabling method chaining.
     *
     * @param rentalAgreementNumber the rentalAgreementNumber to set
     * @return a reference to this Builder
     */
    public Builder rentalAgreementNumber(String rentalAgreementNumber) {
      this.rentalAgreementNumber = rentalAgreementNumber;
      return this;
    }

    /**
     * The name of the person renting the car. Required during settlement request with Mastercard or Amex for integration with TSYS processor
     * <p>
     * Sets the renterName and returns a reference to this Builder enabling method chaining.
     *
     * @param renterName the renterName to set
     * @return a reference to this Builder
     */
    public Builder renterName(String renterName) {
      this.renterName = renterName;
      return this;
    }

    /**
     * The total number of days the car is rented for. Required during authorization request for integration with TSYS processor
     * <p>
     * Sets the rentalDays and returns a reference to this Builder enabling method chaining.
     *
     * @param rentalDays the rentalDays to set
     * @return a reference to this Builder
     */
    public Builder rentalDays(Integer rentalDays) {
      this.rentalDays = rentalDays;
      return this;
    }

    /**
     * Indicates if the customer didn't check in for their booking. true if the customer didn't check in, false if the customer checked in
     * <p>
     * Sets the noShow and returns a reference to this Builder enabling method chaining.
     *
     * @param noShow the noShow to set
     * @return a reference to this Builder
     */
    public Builder noShow(Boolean noShow) {
      this.noShow = noShow;
      return this;
    }

    /**
     * Indicates if the reservation includes additional ancillary charges
     * <p>
     * Sets the extraCharges and returns a reference to this Builder enabling method chaining.
     *
     * @param extraCharges the extraCharges to set
     * @return a reference to this Builder
     */
    public Builder extraCharges(List<CarRentalExtraChargeType> extraCharges) {
      this.extraCharges = extraCharges;
      return this;
    }

    /**
     * Customer service phone number
     * <p>
     * Sets the customerServicePhone and returns a reference to this Builder enabling method chaining.
     *
     * @param customerServicePhone the customerServicePhone to set
     * @return a reference to this Builder
     */
    public Builder customerServicePhone(String customerServicePhone) {
      this.customerServicePhone = customerServicePhone;
      return this;
    }

    /**
     * Sets the returnDetails and returns a reference to this Builder enabling method chaining.
     *
     * @param returnDetails the returnDetails to set
     * @return a reference to this Builder
     */
    public Builder returnDetails(CarRentalReturnDetails returnDetails) {
      this.returnDetails = returnDetails;
      return this;
    }

    /**
     * Sets the pickupDetails and returns a reference to this Builder enabling method chaining.
     *
     * @param pickupDetails the pickupDetails to set
     * @return a reference to this Builder
     */
    public Builder pickupDetails(CarRentalPickupDetails pickupDetails) {
      this.pickupDetails = pickupDetails;
      return this;
    }

    /**
     * Sets the vehicleClass and returns a reference to this Builder enabling method chaining.
     *
     * @param vehicleClass the vehicleClass to set
     * @return a reference to this Builder
     */
    public Builder vehicleClass(VehicleClass vehicleClass) {
      this.vehicleClass = vehicleClass;
      return this;
    }

    /**
     * Returns a CarRentalDetails built from the parameters previously set.
     *
     * @return a CarRentalDetails built with parameters of this CarRentalDetails.Builder
     */
    public CarRentalDetails build() {
      return new CarRentalDetails(this);
    }
  }
}
