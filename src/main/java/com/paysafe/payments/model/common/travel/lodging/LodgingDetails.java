// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.model.common.travel.lodging;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.paysafe.payments.model.common.travel.lodging.enums.ExtraChargesType;
import com.paysafe.payments.model.common.travel.lodging.enums.LodgingProgramCode;



/**
 * Contains information about lodging details. <br>**Note:** This object is only for Lodging Merchants. <br>**Note:** This field has to be passed only in case of card transactions.
 */
public class LodgingDetails {

  @JsonProperty("hotelFolioNumber")
  private String hotelFolioNumber;
  @JsonProperty("checkInDate")
  private String checkInDate;
  @JsonProperty("checkOutDate")
  private String checkOutDate;
  @JsonProperty("customerServicePhone")
  private String customerServicePhone;
  @JsonProperty("propertyLocalPhone")
  private String propertyLocalPhone;
  @JsonProperty("extraCharges")
  private List<ExtraChargesType> extraCharges;
  @JsonProperty("roomRate")
  private Integer roomRate;
  @JsonProperty("programCode")
  private LodgingProgramCode programCode = LodgingProgramCode.LODGING;
  @JsonProperty("numberOfNights")
  private Integer numberOfNights;
  @JsonProperty("isFireSafetyActCompliant")
  private Boolean isFireSafetyActCompliant;

  public LodgingDetails() {
    super();
  }

  private LodgingDetails(final Builder builder) {
    setHotelFolioNumber(builder.hotelFolioNumber);
    setCheckInDate(builder.checkInDate);
    setCheckOutDate(builder.checkOutDate);
    setCustomerServicePhone(builder.customerServicePhone);
    setPropertyLocalPhone(builder.propertyLocalPhone);
    setExtraCharges(builder.extraCharges);
    setRoomRate(builder.roomRate);
    setProgramCode(builder.programCode);
    setNumberOfNights(builder.numberOfNights);
    setIsFireSafetyActCompliant(builder.isFireSafetyActCompliant);
  }

  public static Builder builder() {
    return new Builder();
  }


  public LodgingDetails hotelFolioNumber(String hotelFolioNumber) {
    this.hotelFolioNumber = hotelFolioNumber;
    return this;
  }

  /**
   * The card acceptor’s internal invoice or billing ID reference number. Required during settlement
   *
   * @return hotelFolioNumber
   */
  public String getHotelFolioNumber() {
    return hotelFolioNumber;
  }

  public void setHotelFolioNumber(String hotelFolioNumber) {
    this.hotelFolioNumber = hotelFolioNumber;
  }


  public LodgingDetails checkInDate(String checkInDate) {
    this.checkInDate = checkInDate;
    return this;
  }

  /**
   * The arrival date. Date format = YYYY-MM-DD, ISO 8601 expected. For example 2023-12-20. * Required during settlement.
   *
   * @return checkInDate
   */
  public String getCheckInDate() {
    return checkInDate;
  }

  public void setCheckInDate(String checkInDate) {
    this.checkInDate = checkInDate;
  }


  public LodgingDetails checkOutDate(String checkOutDate) {
    this.checkOutDate = checkOutDate;
    return this;
  }

  /**
   * The departure date. Date format = YYYY-MM-DD, ISO 8601 expected. For example 2023-12-20. * Required during settlement.
   *
   * @return checkOutDate
   */
  public String getCheckOutDate() {
    return checkOutDate;
  }

  public void setCheckOutDate(String checkOutDate) {
    this.checkOutDate = checkOutDate;
  }


  public LodgingDetails customerServicePhone(String customerServicePhone) {
    this.customerServicePhone = customerServicePhone;
    return this;
  }

  /**
   * Merchant phone number that the cardholder may call for service. Allowed numeric characters only. * Required during settlement request with Visa or Mastercard for integration with TSYS processor
   *
   * @return customerServicePhone
   */
  public String getCustomerServicePhone() {
    return customerServicePhone;
  }

  public void setCustomerServicePhone(String customerServicePhone) {
    this.customerServicePhone = customerServicePhone;
  }


  public LodgingDetails propertyLocalPhone(String propertyLocalPhone) {
    this.propertyLocalPhone = propertyLocalPhone;
    return this;
  }

  /**
   * The lodging property location's phone number. Allowed numeric characters only. * Required during settlement requests with Mastercard for integration with TSYS processor
   *
   * @return propertyLocalPhone
   */
  public String getPropertyLocalPhone() {
    return propertyLocalPhone;
  }

  public void setPropertyLocalPhone(String propertyLocalPhone) {
    this.propertyLocalPhone = propertyLocalPhone;
  }


  public LodgingDetails extraCharges(List<ExtraChargesType> extraCharges) {
    this.extraCharges = extraCharges;
    return this;
  }

  public LodgingDetails addExtraChargesItem(ExtraChargesType extraChargesItem) {
    if (this.extraCharges == null) {
      this.extraCharges = new ArrayList<>();
    }
    this.extraCharges.add(extraChargesItem);
    return this;
  }

  public LodgingDetails removeExtraChargesItem(ExtraChargesType extraChargesItem) {
    if (extraChargesItem != null && this.extraCharges != null) {
      this.extraCharges.remove(extraChargesItem);
    }

    return this;
  }

  /**
   * Indicates if the reservation includes additional ancillary charges.
   *
   * @return extraCharges
   */
  public List<ExtraChargesType> getExtraCharges() {
    return extraCharges;
  }

  public void setExtraCharges(List<ExtraChargesType> extraCharges) {
    this.extraCharges = extraCharges;
  }


  public LodgingDetails roomRate(Integer roomRate) {
    this.roomRate = roomRate;
    return this;
  }

  /**
   * The nightly rate for one room at the lodging property. * Required during settlement request with Amex for integration with TSYS processor
   *
   * @return roomRate
   */
  public Integer getRoomRate() {
    return roomRate;
  }

  public void setRoomRate(Integer roomRate) {
    this.roomRate = roomRate;
  }


  public LodgingDetails programCode(LodgingProgramCode programCode) {
    this.programCode = programCode;
    return this;
  }

  /**
   * Get programCode
   *
   * @return programCode
   */
  public LodgingProgramCode getProgramCode() {
    return programCode;
  }

  public void setProgramCode(LodgingProgramCode programCode) {
    this.programCode = programCode;
  }


  public LodgingDetails numberOfNights(Integer numberOfNights) {
    this.numberOfNights = numberOfNights;
    return this;
  }

  /**
   * The total number of nights the room is booked for. * Required during authorization request with Visa for integration with TSYS processor * Required during settlement request with Amex for integration with TSYS processor
   *
   * @return numberOfNights
   */
  public Integer getNumberOfNights() {
    return numberOfNights;
  }

  public void setNumberOfNights(Integer numberOfNights) {
    this.numberOfNights = numberOfNights;
  }


  public LodgingDetails isFireSafetyActCompliant(Boolean isFireSafetyActCompliant) {
    this.isFireSafetyActCompliant = isFireSafetyActCompliant;
    return this;
  }

  /**
   * Identifies that the facility complies with the Hotel and Motel Fire Safety Act of 1990. Possible values: - true - false
   *
   * @return isFireSafetyActCompliant
   */
  public Boolean getIsFireSafetyActCompliant() {
    return isFireSafetyActCompliant;
  }

  public void setIsFireSafetyActCompliant(Boolean isFireSafetyActCompliant) {
    this.isFireSafetyActCompliant = isFireSafetyActCompliant;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LodgingDetails lodgingDetails = (LodgingDetails) o;
    return Objects.equals(this.hotelFolioNumber, lodgingDetails.hotelFolioNumber) &&
        Objects.equals(this.checkInDate, lodgingDetails.checkInDate) &&
        Objects.equals(this.checkOutDate, lodgingDetails.checkOutDate) &&
        Objects.equals(this.customerServicePhone, lodgingDetails.customerServicePhone) &&
        Objects.equals(this.propertyLocalPhone, lodgingDetails.propertyLocalPhone) &&
        Objects.equals(this.extraCharges, lodgingDetails.extraCharges) &&
        Objects.equals(this.roomRate, lodgingDetails.roomRate) &&
        Objects.equals(this.programCode, lodgingDetails.programCode) &&
        Objects.equals(this.numberOfNights, lodgingDetails.numberOfNights) &&
        Objects.equals(this.isFireSafetyActCompliant, lodgingDetails.isFireSafetyActCompliant);
  }

  @Override
  public int hashCode() {
    return Objects.hash(hotelFolioNumber, checkInDate, checkOutDate, customerServicePhone, propertyLocalPhone, extraCharges, roomRate, programCode, numberOfNights, isFireSafetyActCompliant);
  }

  @Override
  public String toString() {

    return "class LodgingDetails {\n"
        + "    hotelFolioNumber: " + toIndentedString(hotelFolioNumber) + "\n"
        + "    checkInDate: " + toIndentedString(checkInDate) + "\n"
        + "    checkOutDate: " + toIndentedString(checkOutDate) + "\n"
        + "    customerServicePhone: " + toIndentedString(customerServicePhone) + "\n"
        + "    propertyLocalPhone: " + toIndentedString(propertyLocalPhone) + "\n"
        + "    extraCharges: " + toIndentedString(extraCharges) + "\n"
        + "    roomRate: " + toIndentedString(roomRate) + "\n"
        + "    programCode: " + toIndentedString(programCode) + "\n"
        + "    numberOfNights: " + toIndentedString(numberOfNights) + "\n"
        + "    isFireSafetyActCompliant: " + toIndentedString(isFireSafetyActCompliant) + "\n"
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
   * Contains information about lodging details. <br>**Note:** This object is only for Lodging Merchants. <br>**Note:** This field has to be passed only in case of card transactions. builder static inner class.
   */
  public static final class Builder {
    private String hotelFolioNumber;
    private String checkInDate;
    private String checkOutDate;
    private String customerServicePhone;
    private String propertyLocalPhone;
    private List<ExtraChargesType> extraCharges;
    private Integer roomRate;
    private LodgingProgramCode programCode;
    private Integer numberOfNights;
    private Boolean isFireSafetyActCompliant;

    private Builder() {
    }

    /**
     * The card acceptor’s internal invoice or billing ID reference number. Required during settlement
     * <p>
     * Sets the hotelFolioNumber and returns a reference to this Builder enabling method chaining.
     *
     * @param hotelFolioNumber the hotelFolioNumber to set
     * @return a reference to this Builder
     */
    public Builder hotelFolioNumber(String hotelFolioNumber) {
      this.hotelFolioNumber = hotelFolioNumber;
      return this;
    }

    /**
     * The arrival date. Date format = YYYY-MM-DD, ISO 8601 expected. For example 2023-12-20. * Required during settlement.
     * <p>
     * Sets the checkInDate and returns a reference to this Builder enabling method chaining.
     *
     * @param checkInDate the checkInDate to set
     * @return a reference to this Builder
     */
    public Builder checkInDate(String checkInDate) {
      this.checkInDate = checkInDate;
      return this;
    }

    /**
     * The departure date. Date format = YYYY-MM-DD, ISO 8601 expected. For example 2023-12-20. * Required during settlement.
     * <p>
     * Sets the checkOutDate and returns a reference to this Builder enabling method chaining.
     *
     * @param checkOutDate the checkOutDate to set
     * @return a reference to this Builder
     */
    public Builder checkOutDate(String checkOutDate) {
      this.checkOutDate = checkOutDate;
      return this;
    }

    /**
     * Merchant phone number that the cardholder may call for service. Allowed numeric characters only. * Required during settlement request with Visa or Mastercard for integration with TSYS processor
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
     * The lodging property location's phone number. Allowed numeric characters only. * Required during settlement requests with Mastercard for integration with TSYS processor
     * <p>
     * Sets the propertyLocalPhone and returns a reference to this Builder enabling method chaining.
     *
     * @param propertyLocalPhone the propertyLocalPhone to set
     * @return a reference to this Builder
     */
    public Builder propertyLocalPhone(String propertyLocalPhone) {
      this.propertyLocalPhone = propertyLocalPhone;
      return this;
    }

    /**
     * Indicates if the reservation includes additional ancillary charges.
     * <p>
     * Sets the extraCharges and returns a reference to this Builder enabling method chaining.
     *
     * @param extraCharges the extraCharges to set
     * @return a reference to this Builder
     */
    public Builder extraCharges(List<ExtraChargesType> extraCharges) {
      this.extraCharges = extraCharges;
      return this;
    }

    /**
     * The nightly rate for one room at the lodging property. * Required during settlement request with Amex for integration with TSYS processor
     * <p>
     * Sets the roomRate and returns a reference to this Builder enabling method chaining.
     *
     * @param roomRate the roomRate to set
     * @return a reference to this Builder
     */
    public Builder roomRate(Integer roomRate) {
      this.roomRate = roomRate;
      return this;
    }

    /**
     * Sets the programCode and returns a reference to this Builder enabling method chaining.
     *
     * @param programCode the programCode to set
     * @return a reference to this Builder
     */
    public Builder programCode(LodgingProgramCode programCode) {
      this.programCode = programCode;
      return this;
    }

    /**
     * The total number of nights the room is booked for. * Required during authorization request with Visa for integration with TSYS processor * Required during settlement request with Amex for integration with TSYS processor
     * <p>
     * Sets the numberOfNights and returns a reference to this Builder enabling method chaining.
     *
     * @param numberOfNights the numberOfNights to set
     * @return a reference to this Builder
     */
    public Builder numberOfNights(Integer numberOfNights) {
      this.numberOfNights = numberOfNights;
      return this;
    }

    /**
     * Identifies that the facility complies with the Hotel and Motel Fire Safety Act of 1990. Possible values: - true - false
     * <p>
     * Sets the isFireSafetyActCompliant and returns a reference to this Builder enabling method chaining.
     *
     * @param isFireSafetyActCompliant the isFireSafetyActCompliant to set
     * @return a reference to this Builder
     */
    public Builder isFireSafetyActCompliant(Boolean isFireSafetyActCompliant) {
      this.isFireSafetyActCompliant = isFireSafetyActCompliant;
      return this;
    }

    /**
     * Returns a LodgingDetails built from the parameters previously set.
     *
     * @return a LodgingDetails built with parameters of this LodgingDetails.Builder
     */
    public LodgingDetails build() {
      return new LodgingDetails(this);
    }
  }
}
