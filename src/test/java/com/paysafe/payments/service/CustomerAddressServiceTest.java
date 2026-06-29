// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.paysafe.payments.base.BaseStubServerTest;
import com.paysafe.payments.base.TestStubServer.StubResponse;
import com.paysafe.payments.base.TestStubServer.UrlMatchType;
import com.paysafe.payments.errorhandling.exception.PaysafeSdkException;
import com.paysafe.payments.model.customer.Address;
import com.paysafe.payments.model.customer.enums.AddressStatus;

public class CustomerAddressServiceTest extends BaseStubServerTest {

  private static final String CUSTOMER_ID = "11111-6882-422c-ae4f-a10ddbae95ff";
  private static final String ADDRESS_ID = "99999-6882-422c-ae4f-a10ddbae95fe";
  private static final String CUSTOMER_ADDRESS_ENDPOINT = "/paymenthub/v1/customers/%s/addresses";

  @Test
  void testCreateAddress_isSuccessful() throws PaysafeSdkException {
    final String urlPath = String.format(CUSTOMER_ADDRESS_ENDPOINT, CUSTOMER_ID);

    stubServer.stub("POST", urlPath, UrlMatchType.PATH_EQUAL,
        StubResponse.builder()
            .status(200)
            .header("Content-Type", "application/json")
            .bodyFile("customer_address/create_address_response.json")
            .build());

    Address addressRequest = Address.builder()
        .nickName("Home")
        .street("N.G.O's Colony")
        .street2("Besdie Sri Ramakrishna P.G College")
        .city("Nandyal")
        .zip("518502")
        .country("CA")
        .state("ON")
        .phone("647-788-3901")
        .defaultShippingAddressIndicator(true)
        .build();

    Address response = paysafeClient.customerAddressService().createAddress(CUSTOMER_ID, addressRequest);

    stubServer.verify(1, "POST", urlPath);
    assertNotNull(response);
    assertEquals("Home", response.getNickName());
    assertEquals("N.G.O's Colony", response.getStreet());
    assertEquals(AddressStatus.ACTIVE, response.getStatus());
  }

  @Test
  void testGetAddressById_isSuccessful() throws PaysafeSdkException {
    final String urlPath = String.format(CUSTOMER_ADDRESS_ENDPOINT + "/%s", CUSTOMER_ID, ADDRESS_ID);

    stubServer.stub("GET", urlPath, UrlMatchType.PATH_EQUAL,
        StubResponse.builder()
            .status(200)
            .header("Content-Type", "application/json")
            .bodyFile("customer_address/get_address_response.json")
            .build());

    Address response = paysafeClient.customerAddressService().getAddressById(CUSTOMER_ID, ADDRESS_ID);

    stubServer.verify(1, "GET", urlPath);
    assertNotNull(response);
    assertEquals(ADDRESS_ID, response.getId());
    assertEquals("Home", response.getNickName());
    assertEquals(AddressStatus.ACTIVE, response.getStatus());
    assertEquals("N.G.O's Colony", response.getStreet());
    assertEquals("Nandyal", response.getCity());
    assertEquals("ON", response.getState());
    assertEquals("CA", response.getCountry());
    assertEquals("518502", response.getZip());
    assertEquals("647-788-3901", response.getPhone());
    assertFalse(response.getDefaultShippingAddressIndicator());
  }

  @Test
  void testGetAddressById_throwsExceptionOnEntityNotFoundError() {
    final String nonExistingAddressId = "non-existing-address-id";
    final String urlPath = String.format(CUSTOMER_ADDRESS_ENDPOINT + "/%s", CUSTOMER_ID, nonExistingAddressId);

    stubServer.stub("GET", urlPath, UrlMatchType.PATH_EQUAL,
        StubResponse.builder()
            .status(404)
            .header("Content-Type", "application/json")
            .bodyFile("error/404_entity_not_found_response.json")
            .build());

    PaysafeSdkException exception = assertThrows(
        PaysafeSdkException.class,
        () -> paysafeClient.customerAddressService().getAddressById(CUSTOMER_ID, nonExistingAddressId)
    );

    stubServer.verify(1, "GET", urlPath);
    assertEquals(404, exception.getCode());
    assertEquals("5269", exception.getError().getCode());
    assertEquals("Entity not found", exception.getError().getMessage());
  }

  @Test
  void testUpdateAddress_isSuccessful() throws PaysafeSdkException {
    final String urlPath = String.format(CUSTOMER_ADDRESS_ENDPOINT + "/%s", CUSTOMER_ID, ADDRESS_ID);

    stubServer.stub("PUT", urlPath, UrlMatchType.PATH_EQUAL,
        StubResponse.builder()
            .status(200)
            .header("Content-Type", "application/json")
            .bodyFile("customer_address/update_address_response.json")
            .build());

    Address updatedRequest = Address.builder()
        .nickName("Office")
        .street("101 Queen")
        .street2("Unit 202")
        .city("Toronto0")
        .zip("M5H 2N2")
        .country("US")
        .state("NY")
        .phone("903-788-3901")
        .defaultShippingAddressIndicator(false)
        .build();

    Address response = paysafeClient.customerAddressService().updateAddress(CUSTOMER_ID, ADDRESS_ID, updatedRequest);

    stubServer.verify(1, "PUT", urlPath);

    assertNotNull(response);
    assertEquals("Office", response.getNickName());
    assertEquals("101 Queen", response.getStreet());
    assertEquals("Unit 202", response.getStreet2());
    assertEquals("Toronto0", response.getCity());
    assertEquals("NY", response.getState());
    assertEquals("US", response.getCountry());
    assertEquals("M5H 2N2", response.getZip());
    assertEquals("903-788-3901", response.getPhone());
    assertEquals(AddressStatus.ACTIVE, response.getStatus());
    assertFalse(response.getDefaultShippingAddressIndicator());
  }

  @Test
  void testUpdateAddress_throwsExceptionOnEntityNotFoundError() {
    final String nonExistingAddressId = "non-existing-address-id";
    final String urlPath = String.format(CUSTOMER_ADDRESS_ENDPOINT + "/%s", CUSTOMER_ID, nonExistingAddressId);

    stubServer.stub("PUT", urlPath, UrlMatchType.PATH_EQUAL,
        StubResponse.builder()
            .status(404)
            .header("Content-Type", "application/json")
            .bodyFile("error/404_entity_not_found_response.json")
            .build());

    Address updatedRequest = Address.builder()
        .nickName("Office")
        .street("101 Queen")
        .street2("Unit 202")
        .city("Toronto0")
        .zip("M5H 2N2")
        .country("US")
        .state("NY")
        .phone("903-788-3901")
        .defaultShippingAddressIndicator(false)
        .build();

    PaysafeSdkException exception = assertThrows(
        PaysafeSdkException.class,
        () -> paysafeClient.customerAddressService().updateAddress(CUSTOMER_ID, nonExistingAddressId, updatedRequest, null)
    );

    stubServer.verify(1, "PUT", urlPath);
    assertEquals(404, exception.getCode());
    assertEquals("5269", exception.getError().getCode());
    assertEquals("Entity not found", exception.getError().getMessage());
  }

  @Test
  void testDeleteAddress_isSuccessful() {
    final String urlPath = String.format(CUSTOMER_ADDRESS_ENDPOINT + "/%s", CUSTOMER_ID, ADDRESS_ID);

    stubServer.stub("DELETE", urlPath, UrlMatchType.URL_EQUAL,
        StubResponse.builder()
            .status(200)
            .build());

    assertDoesNotThrow(() -> paysafeClient.customerAddressService().deleteAddress(CUSTOMER_ID, ADDRESS_ID));
    stubServer.verify(1, "DELETE", urlPath);
  }

  @Test
  void testDeleteAddress_throwsExceptionOnEntityNotFound() {
    final String nonExistingAddressId = "non-existing-address-id";
    final String urlPath = String.format(CUSTOMER_ADDRESS_ENDPOINT + "/%s", CUSTOMER_ID, nonExistingAddressId);

    stubServer.stub("DELETE", urlPath, UrlMatchType.URL_EQUAL,
        StubResponse.builder()
            .status(404)
            .header("Content-Type", "application/json")
            .bodyFile("error/404_entity_not_found_response.json")
            .build());

    PaysafeSdkException exception = assertThrows(PaysafeSdkException.class, () ->
        paysafeClient.customerAddressService().deleteAddress(CUSTOMER_ID, nonExistingAddressId));

    stubServer.verify(1, "DELETE", urlPath);
    assertEquals(404, exception.getCode());
    assertEquals("5269", exception.getError().getCode());
    assertEquals("Entity not found", exception.getError().getMessage());
  }
}