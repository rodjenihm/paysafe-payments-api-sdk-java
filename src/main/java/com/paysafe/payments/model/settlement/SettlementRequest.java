// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.model.settlement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.paysafe.payments.model.common.travel.airline.AirlineTravelDetails;
import com.paysafe.payments.model.common.travel.carrental.CarRentalDetails;
import com.paysafe.payments.model.common.travel.cruise.CruiselineTravelDetails;
import com.paysafe.payments.model.common.travel.lodging.LodgingDetails;
import com.paysafe.payments.model.lpm.Splitpay;



/**
 * A Settlement request allows you to settle a previous authorization that was not settled in the original Purchase request (i.e., where settleWithAuth was set to false). <ul>   <li>A regular Settlement, where the initial request was an Authorization that is to be settled.</li>   <li>A Settlement that is split into multiple merchant accounts. This is applicable for those merchants whose accounts are configured to do so.</li>   <li>A Settlement for the authorization with the full airline travel details for the AIRLINE Merchants.</li> </ul>
 */
public class SettlementRequest {

  @JsonProperty("merchantRefNum")
  private String merchantRefNum;
  @JsonProperty("amount")
  private Integer amount;
  @JsonProperty("dupCheck")
  private Boolean dupCheck = true;
  @JsonProperty("splitpay")
  private List<Splitpay> splitpay;
  @JsonProperty("airlineTravelDetails")
  private AirlineTravelDetails airlineTravelDetails;
  @JsonProperty("cruiselineTravelDetails")
  private CruiselineTravelDetails cruiselineTravelDetails;
  @JsonProperty("lodgingDetails")
  private LodgingDetails lodgingDetails;
  @JsonProperty("carRentalDetails")
  private CarRentalDetails carRentalDetails;
  private Map<String, Object> additionalParameters;

  public SettlementRequest() {
    super();
  }

  private SettlementRequest(final Builder builder) {
    setMerchantRefNum(builder.merchantRefNum);
    setAmount(builder.amount);
    setDupCheck(builder.dupCheck);
    setSplitpay(builder.splitpay);
    setAirlineTravelDetails(builder.airlineTravelDetails);
    setCruiselineTravelDetails(builder.cruiselineTravelDetails);
    setLodgingDetails(builder.lodgingDetails);
    setCarRentalDetails(builder.carRentalDetails);
    this.additionalParameters = builder.additionalParameters;
  }

  public static Builder builder() {
    return new Builder();
  }


  public SettlementRequest merchantRefNum(String merchantRefNum) {
    this.merchantRefNum = merchantRefNum;
    return this;
  }

  /**
   * This is the merchant reference number created by the merchant and submitted as part of the request. It must be unique for each request.
   *
   * @return merchantRefNum
   */
  public String getMerchantRefNum() {
    return merchantRefNum;
  }

  public void setMerchantRefNum(String merchantRefNum) {
    this.merchantRefNum = merchantRefNum;
  }


  public SettlementRequest amount(Integer amount) {
    this.amount = amount;
    return this;
  }

  /**
   * This is the amount of the request, in minor units.For example, to process US $10.99, this value should be 1099. Maximum: 99999999999
   *
   * @return amount
   */
  public Integer getAmount() {
    return amount;
  }

  public void setAmount(Integer amount) {
    this.amount = amount;
  }


  public SettlementRequest dupCheck(Boolean dupCheck) {
    this.dupCheck = dupCheck;
    return this;
  }

  /**
   * This validates that this request is not a duplicate. A request is considered a duplicate if the merchantRefNum has already been used in a previous request within the past 90 days. **Note:** This value defaults to true
   *
   * @return dupCheck
   */
  public Boolean getDupCheck() {
    return dupCheck;
  }

  public void setDupCheck(Boolean dupCheck) {
    this.dupCheck = dupCheck;
  }


  public SettlementRequest splitpay(List<Splitpay> splitpay) {
    this.splitpay = splitpay;
    return this;
  }

  public SettlementRequest addSplitpayItem(Splitpay splitpayItem) {
    if (this.splitpay == null) {
      this.splitpay = new ArrayList<>();
    }
    this.splitpay.add(splitpayItem);
    return this;
  }

  public SettlementRequest removeSplitpayItem(Splitpay splitpayItem) {
    if (splitpayItem != null && this.splitpay != null) {
      this.splitpay.remove(splitpayItem);
    }

    return this;
  }

  /**
   * Get splitpay
   *
   * @return splitpay
   */
  public List<Splitpay> getSplitpay() {
    return splitpay;
  }

  public void setSplitpay(List<Splitpay> splitpay) {
    this.splitpay = splitpay;
  }


  public SettlementRequest airlineTravelDetails(AirlineTravelDetails airlineTravelDetails) {
    this.airlineTravelDetails = airlineTravelDetails;
    return this;
  }

  /**
   * Get airlineTravelDetails
   *
   * @return airlineTravelDetails
   */
  public AirlineTravelDetails getAirlineTravelDetails() {
    return airlineTravelDetails;
  }

  public void setAirlineTravelDetails(AirlineTravelDetails airlineTravelDetails) {
    this.airlineTravelDetails = airlineTravelDetails;
  }


  public SettlementRequest cruiselineTravelDetails(CruiselineTravelDetails cruiselineTravelDetails) {
    this.cruiselineTravelDetails = cruiselineTravelDetails;
    return this;
  }

  /**
   * Get cruiselineTravelDetails
   *
   * @return cruiselineTravelDetails
   */
  public CruiselineTravelDetails getCruiselineTravelDetails() {
    return cruiselineTravelDetails;
  }

  public void setCruiselineTravelDetails(CruiselineTravelDetails cruiselineTravelDetails) {
    this.cruiselineTravelDetails = cruiselineTravelDetails;
  }


  public SettlementRequest lodgingDetails(LodgingDetails lodgingDetails) {
    this.lodgingDetails = lodgingDetails;
    return this;
  }

  /**
   * Get lodgingDetails
   *
   * @return lodgingDetails
   */
  public LodgingDetails getLodgingDetails() {
    return lodgingDetails;
  }

  public void setLodgingDetails(LodgingDetails lodgingDetails) {
    this.lodgingDetails = lodgingDetails;
  }


  public SettlementRequest carRentalDetails(CarRentalDetails carRentalDetails) {
    this.carRentalDetails = carRentalDetails;
    return this;
  }

  /**
   * Get carRentalDetails
   *
   * @return carRentalDetails
   */
  public CarRentalDetails getCarRentalDetails() {
    return carRentalDetails;
  }

  public void setCarRentalDetails(CarRentalDetails carRentalDetails) {
    this.carRentalDetails = carRentalDetails;
  }

  /**
   * This map holds additional parameters that can be used for features not available in this client library.
   * During serialization, each key-value pair is treated as if the key were a top-level field in the serialized object,
   * e.g. <code>{"merchantRefNum" : "uuid", "additionalParameter1" : 100, "additionalParameter2" : "string" }</code> .
   *
   * @return additionalParameters
   */
  @JsonAnyGetter
  public Map<String, Object> getAdditionalParameters() {
    return this.additionalParameters;
  }

  public void setAdditionalParameters(Map<String, Object> additionalParameters) {
    this.additionalParameters = additionalParameters;
  }

  public void addAdditionalParameter(String key, Object value) {
    if (this.additionalParameters == null) {
      this.additionalParameters = new HashMap<>();
    }
    this.additionalParameters.put(key, value);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SettlementRequest settlementRequest = (SettlementRequest) o;
    return Objects.equals(this.merchantRefNum, settlementRequest.merchantRefNum) &&
        Objects.equals(this.amount, settlementRequest.amount) &&
        Objects.equals(this.dupCheck, settlementRequest.dupCheck) &&
        Objects.equals(this.splitpay, settlementRequest.splitpay) &&
        Objects.equals(this.airlineTravelDetails, settlementRequest.airlineTravelDetails) &&
        Objects.equals(this.cruiselineTravelDetails, settlementRequest.cruiselineTravelDetails) &&
        Objects.equals(this.lodgingDetails, settlementRequest.lodgingDetails) &&
        Objects.equals(this.carRentalDetails, settlementRequest.carRentalDetails);
  }

  @Override
  public int hashCode() {
    return Objects.hash(merchantRefNum, amount, dupCheck, splitpay, airlineTravelDetails, cruiselineTravelDetails, lodgingDetails, carRentalDetails);
  }

  @Override
  public String toString() {

    return "class SettlementRequest {\n"
        + "    merchantRefNum: " + toIndentedString(merchantRefNum) + "\n"
        + "    amount: " + toIndentedString(amount) + "\n"
        + "    dupCheck: " + toIndentedString(dupCheck) + "\n"
        + "    splitpay: " + toIndentedString(splitpay) + "\n"
        + "    airlineTravelDetails: " + toIndentedString(airlineTravelDetails) + "\n"
        + "    cruiselineTravelDetails: " + toIndentedString(cruiselineTravelDetails) + "\n"
        + "    lodgingDetails: " + toIndentedString(lodgingDetails) + "\n"
        + "    carRentalDetails: " + toIndentedString(carRentalDetails) + "\n"
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
   * A Settlement request allows you to settle a previous authorization that was not settled in the original Purchase request (i.e., where settleWithAuth was set to false). <ul>   <li>A regular Settlement, where the initial request was an Authorization that is to be settled.</li>   <li>A Settlement that is split into multiple merchant accounts. This is applicable for those merchants whose accounts are configured to do so.</li>   <li>A Settlement for the authorization with the full airline travel details for the AIRLINE Merchants.</li> </ul> builder static inner class.
   */
  public static final class Builder {
    private String merchantRefNum;
    private Integer amount;
    private Boolean dupCheck;
    private List<Splitpay> splitpay;
    private AirlineTravelDetails airlineTravelDetails;
    private CruiselineTravelDetails cruiselineTravelDetails;
    private LodgingDetails lodgingDetails;
    private CarRentalDetails carRentalDetails;
    private Map<String, Object> additionalParameters;

    private Builder() {
    }

    /**
     * This is the merchant reference number created by the merchant and submitted as part of the request. It must be unique for each request.
     * <p>
     * Sets the merchantRefNum and returns a reference to this Builder enabling method chaining.
     *
     * @param merchantRefNum the merchantRefNum to set
     * @return a reference to this Builder
     */
    public Builder merchantRefNum(String merchantRefNum) {
      this.merchantRefNum = merchantRefNum;
      return this;
    }

    /**
     * This is the amount of the request, in minor units.For example, to process US $10.99, this value should be 1099. Maximum: 99999999999
     * <p>
     * Sets the amount and returns a reference to this Builder enabling method chaining.
     *
     * @param amount the amount to set
     * @return a reference to this Builder
     */
    public Builder amount(Integer amount) {
      this.amount = amount;
      return this;
    }

    /**
     * This validates that this request is not a duplicate. A request is considered a duplicate if the merchantRefNum has already been used in a previous request within the past 90 days. **Note:** This value defaults to true
     * <p>
     * Sets the dupCheck and returns a reference to this Builder enabling method chaining.
     *
     * @param dupCheck the dupCheck to set
     * @return a reference to this Builder
     */
    public Builder dupCheck(Boolean dupCheck) {
      this.dupCheck = dupCheck;
      return this;
    }

    /**
     * Get splitpay
     * <p>
     * Sets the splitpay and returns a reference to this Builder enabling method chaining.
     *
     * @param splitpay the splitpay to set
     * @return a reference to this Builder
     */
    public Builder splitpay(List<Splitpay> splitpay) {
      this.splitpay = splitpay;
      return this;
    }

    /**
     * Sets the airlineTravelDetails and returns a reference to this Builder enabling method chaining.
     *
     * @param airlineTravelDetails the airlineTravelDetails to set
     * @return a reference to this Builder
     */
    public Builder airlineTravelDetails(AirlineTravelDetails airlineTravelDetails) {
      this.airlineTravelDetails = airlineTravelDetails;
      return this;
    }

    /**
     * Sets the cruiselineTravelDetails and returns a reference to this Builder enabling method chaining.
     *
     * @param cruiselineTravelDetails the cruiselineTravelDetails to set
     * @return a reference to this Builder
     */
    public Builder cruiselineTravelDetails(CruiselineTravelDetails cruiselineTravelDetails) {
      this.cruiselineTravelDetails = cruiselineTravelDetails;
      return this;
    }

    /**
     * Sets the lodgingDetails and returns a reference to this Builder enabling method chaining.
     *
     * @param lodgingDetails the lodgingDetails to set
     * @return a reference to this Builder
     */
    public Builder lodgingDetails(LodgingDetails lodgingDetails) {
      this.lodgingDetails = lodgingDetails;
      return this;
    }

    /**
     * Sets the carRentalDetails and returns a reference to this Builder enabling method chaining.
     *
     * @param carRentalDetails the carRentalDetails to set
     * @return a reference to this Builder
     */
    public Builder carRentalDetails(CarRentalDetails carRentalDetails) {
      this.carRentalDetails = carRentalDetails;
      return this;
    }

    /**
     * Sets the {@code additionalParameters} and returns a reference to this Builder enabling method chaining.
     *
     * @param additionalParameters the {@code additionalParameters} to set
     * @return a reference to this Builder
     */
    public Builder additionalParameters(Map<String, Object> additionalParameters) {
      this.additionalParameters = additionalParameters;
      return this;
    }

    /**
     * Inserts one key/value pair to additionalParameters and returns a reference to this Builder enabling method chaining.
     *
     * @param key the key to insert
     * @param value the value to insert
     * @return a reference to this Builder
     */
    public Builder addAdditionalParameter(String key, Object value) {
      if (this.additionalParameters == null) {
        this.additionalParameters = new HashMap<>();
      }
      this.additionalParameters.put(key, value);
      return this;
    }

    /**
     * Inserts provided key/value pairs to additionalParameters and returns a reference to this Builder enabling method chaining.
     *
     * @param additionalParameters the key/value pairs to insert
     * @return a reference to this Builder
     */
    public Builder addAllAdditionalParameters(Map<String, Object> additionalParameters) {
      if (this.additionalParameters == null) {
        this.additionalParameters = new HashMap<>();
      }
      this.additionalParameters.putAll(additionalParameters);
      return this;
    }

    /**
     * Returns a SettlementRequest built from the parameters previously set.
     *
     * @return a SettlementRequest built with parameters of this SettlementRequest.Builder
     */
    public SettlementRequest build() {
      return new SettlementRequest(this);
    }
  }
}
