// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Set;

import org.junit.jupiter.api.Test;

import com.paysafe.payments.base.BaseStubServerTest;
import com.paysafe.payments.base.TestStubServer.StubResponse;
import com.paysafe.payments.base.TestStubServer.UrlMatchType;
import com.paysafe.payments.errorhandling.exception.PaysafeSdkException;
import com.paysafe.payments.model.common.profile.DateOfBirth;
import com.paysafe.payments.model.customer.enums.CustomerGender;
import com.paysafe.payments.model.customer.enums.CustomerStatus;
import com.paysafe.payments.model.customer.Customer;
import com.paysafe.payments.model.customer.CustomerRequest;
import com.paysafe.payments.model.customer.enums.Locale;

public class CustomerServiceTest extends BaseStubServerTest {

  private static final String CUSTOMERS_ENDPOINT = "/paymenthub/v1/customers";
  private static final String CUSTOMER_ID = "d60fc496-9023-4641-890e-e05c852d2ac4";
  private static final String NON_EXISTING_CUSTOMER_ID = "non-existing-customer-id";
  private static final String MERCHANT_CUSTOMER_ID = "merchant@email.com";

  @Test
  void testCreateCustomer_isSuccessful() throws PaysafeSdkException {
    stubServer.stub("POST", CUSTOMERS_ENDPOINT, UrlMatchType.PATH_EQUAL,
        StubResponse.builder().status(200).header("Content-Type", "application/json")
            .bodyFile("customer/create_customer_response.json").build());

    CustomerRequest customerRequest = CustomerRequest.builder()
        .merchantCustomerId("546456451").locale(Locale.EN_US).firstName("John").middleName("James")
        .dateOfBirth(DateOfBirth.builder().day(24).month(10).year(1981).build())
        .email("john.smith@email.com").phone("777-444-8888").ip("192.0.126.111")
        .gender(CustomerGender.M).nationality("Canadian").cellPhone("777-555-8888").build();

    Customer customer = paysafeClient.customerService().createCustomer(customerRequest, null);

    stubServer.verify(1, "POST", CUSTOMERS_ENDPOINT);
    assertNotNull(customer);
    assertEquals(CustomerStatus.ACTIVE, customer.getStatus());
    assertEquals("546456451", customer.getMerchantCustomerId());
    assertEquals("PPlfJ2gmQoYAQ1d", customer.getPaymentToken());
    assertNull(customer.getPaymentHandles());
  }

  @Test
  void testCreateCustomerUsingSingleUsePaymentHandleToken_isSuccessful() throws PaysafeSdkException {
    stubServer.stub("POST", CUSTOMERS_ENDPOINT, UrlMatchType.PATH_EQUAL,
        StubResponse.builder().status(200).header("Content-Type", "application/json")
            .bodyFile("customer/create_customer_using_single_user_payment_handle_token_response.json").build());

    CustomerRequest customerRequest = CustomerRequest.builder()
        .merchantCustomerId("546456451").locale(Locale.EN_US).firstName("John").middleName("James")
        .dateOfBirth(DateOfBirth.builder().day(24).month(10).year(1981).build())
        .email("john.smith@email.com").phone("777-444-8888").ip("192.0.126.111")
        .gender(CustomerGender.M).nationality("Canadian").cellPhone("777-555-8888")
        .paymentHandleTokenFrom("SCAXH2IawyUMX9BG").accountId("1009688230").build();

    Customer customer = paysafeClient.customerService().createCustomer(customerRequest, null);

    stubServer.verify(1, "POST", CUSTOMERS_ENDPOINT);
    assertNotNull(customer);
    assertEquals(CustomerStatus.ACTIVE, customer.getStatus());
    assertEquals("f8303a052", customer.getMerchantCustomerId());
    assertEquals("PNWaCnbFb7Y5zUk", customer.getPaymentToken());
    assertNotNull(customer.getPaymentHandles());
    assertEquals(1, customer.getPaymentHandles().size());
    assertEquals("e6ad67f5-16f1-4be6-8944-0b897e3b1380", customer.getPaymentHandles().get(0).getId());
    assertEquals("Dilip", customer.getPaymentHandles().get(0).getCard().getHolderName());
    assertEquals("453091", customer.getPaymentHandles().get(0).getCard().getCardBin());
    assertNotNull(customer.getAddresses());
    assertEquals(1, customer.getAddresses().size());
  }

  @Test
  void testDeleteCustomer_isSuccessful() {
    stubServer.stub("DELETE", String.format("%s/%s", CUSTOMERS_ENDPOINT, CUSTOMER_ID), UrlMatchType.PATH_EQUAL,
        StubResponse.builder().status(200).build());

    assertDoesNotThrow(() -> paysafeClient.customerService().deleteCustomer(CUSTOMER_ID));
    stubServer.verify(1, "DELETE", String.format("%s/%s", CUSTOMERS_ENDPOINT, CUSTOMER_ID));
  }

  @Test
  void testDeleteCustomer_throwsExceptionOnEntityNotFoundError() {
    stubServer.stub("DELETE", String.format("%s/%s", CUSTOMERS_ENDPOINT, NON_EXISTING_CUSTOMER_ID), UrlMatchType.PATH_EQUAL,
        StubResponse.builder().status(404).header("Content-Type", "application/json")
            .bodyFile("error/404_entity_not_found_response.json").build());

    PaysafeSdkException exception = assertThrows(
        PaysafeSdkException.class, () -> paysafeClient.customerService().deleteCustomer(NON_EXISTING_CUSTOMER_ID));

    stubServer.verify(1, "DELETE", String.format("%s/%s", CUSTOMERS_ENDPOINT, NON_EXISTING_CUSTOMER_ID));
    assertEquals(404, exception.getCode());
    assertEquals("5269", exception.getError().getCode());
    assertEquals("Entity not found", exception.getError().getMessage());
  }

  @Test
  void testGetCustomerById_isSuccessful() throws PaysafeSdkException {
    stubServer.stub("GET", String.format("%s/%s", CUSTOMERS_ENDPOINT, CUSTOMER_ID), UrlMatchType.PATH_EQUAL,
        StubResponse.builder().status(200).header("Content-Type", "application/json")
            .bodyFile("customer/get_customer_profile_by_customer_id_with_subcomponents_response.json").build());

    Customer response = paysafeClient.customerService().getCustomerById(CUSTOMER_ID, Set.of("addresses", "paymenthandles"));

    stubServer.verifyByPath(1, "GET", String.format("%s/%s", CUSTOMERS_ENDPOINT, CUSTOMER_ID));
    assertNotNull(response);
    assertFalse(response.getAddresses().isEmpty());
    assertFalse(response.getPaymentHandles().isEmpty());
  }

  @Test
  void testGetCustomerById_throwsExceptionOnEntityNotFoundError() {
    stubServer.stub("GET", String.format("%s/%s", CUSTOMERS_ENDPOINT, NON_EXISTING_CUSTOMER_ID), UrlMatchType.PATH_EQUAL,
        StubResponse.builder().status(404).header("Content-Type", "application/json")
            .bodyFile("error/404_entity_not_found_response.json").build());

    PaysafeSdkException exception = assertThrows(
        PaysafeSdkException.class, () -> paysafeClient.customerService().getCustomerById(NON_EXISTING_CUSTOMER_ID, null));

    stubServer.verifyByPath(1, "GET", String.format("%s/%s", CUSTOMERS_ENDPOINT, NON_EXISTING_CUSTOMER_ID));
    assertEquals(404, exception.getCode());
    assertEquals("5269", exception.getError().getCode());
    assertEquals("Entity not found", exception.getError().getMessage());
  }

  @Test
  void testGetCustomerByMerchantCustomerId_isSuccessful() throws PaysafeSdkException {
    stubServer.stub("GET", CUSTOMERS_ENDPOINT, UrlMatchType.PATH_EQUAL,
        StubResponse.builder().status(200).header("Content-Type", "application/json")
            .bodyFile("customer/get_customer_using_merchant_customer_id_response.json").build());

    Customer response = paysafeClient.customerService().getCustomerByMerchantCustomerId(MERCHANT_CUSTOMER_ID, Set.of("addresses", "paymenthandles"));

    stubServer.verifyByPath(1, "GET", CUSTOMERS_ENDPOINT);
    assertNotNull(response);
    assertNull(response.getAddresses());
    assertNull(response.getPaymentHandles());
  }

  @Test
  void testGetCustomerByMerchantCustomerId_throwsExceptionOnEntityNotFoundError() {
    stubServer.stub("GET", CUSTOMERS_ENDPOINT, UrlMatchType.PATH_EQUAL,
        StubResponse.builder().status(404).header("Content-Type", "application/json")
            .bodyFile("error/404_entity_not_found_response.json").build());

    PaysafeSdkException exception = assertThrows(
        PaysafeSdkException.class, () -> paysafeClient.customerService().getCustomerByMerchantCustomerId(NON_EXISTING_CUSTOMER_ID, null));

    stubServer.verify(1, "GET", String.format("%s?merchantCustomerId=%s", CUSTOMERS_ENDPOINT, NON_EXISTING_CUSTOMER_ID));
    assertEquals(404, exception.getCode());
    assertEquals("5269", exception.getError().getCode());
    assertEquals("Entity not found", exception.getError().getMessage());
  }

  @Test
  void testUpdateCustomer_isSuccessful() throws PaysafeSdkException {
    stubServer.stub("PUT", String.format("%s/%s", CUSTOMERS_ENDPOINT, CUSTOMER_ID), UrlMatchType.PATH_EQUAL,
        StubResponse.builder().status(200).header("Content-Type", "application/json")
            .bodyFile("customer/update_customer_response.json").build());

    CustomerRequest updateCustomerRequest = CustomerRequest.builder()
        .merchantCustomerId("546456451").locale(Locale.EN_US).firstName("John").middleName("James").lastName("Smith")
        .dateOfBirth(DateOfBirth.builder().day(24).month(10).year(1981).build())
        .gender(CustomerGender.M).email("johnjames.smith@email.com").phone("777-444-9999")
        .cellPhone("777-555-8888").nationality("Canadian").ip("192.0.126.111")
        .paymentHandleTokenFrom("PPlfJ2gmQoYAQ1d").build();

    Customer response = paysafeClient.customerService().updateCustomer(CUSTOMER_ID, updateCustomerRequest);

    stubServer.verify(1, "PUT", String.format("%s/%s", CUSTOMERS_ENDPOINT, CUSTOMER_ID));
    assertNotNull(response);
    assertEquals(CUSTOMER_ID, response.getId());
    assertEquals(CustomerStatus.ACTIVE, response.getStatus());
    assertEquals("546456451", response.getMerchantCustomerId());
    assertEquals("johnjames.smith@email.com", response.getEmail());
    assertEquals("777-444-9999", response.getPhone());
  }

  @Test
  void testUpdateCustomer_throwsExceptionOnEntityNotFoundError() {
    stubServer.stub("PUT", String.format("%s/%s", CUSTOMERS_ENDPOINT, NON_EXISTING_CUSTOMER_ID), UrlMatchType.PATH_EQUAL,
        StubResponse.builder().status(404).header("Content-Type", "application/json")
            .bodyFile("error/404_entity_not_found_response.json").build());

    PaysafeSdkException exception = assertThrows(
        PaysafeSdkException.class, () -> paysafeClient.customerService().updateCustomer(NON_EXISTING_CUSTOMER_ID, new CustomerRequest()));

    stubServer.verify(1, "PUT", String.format("%s/%s", CUSTOMERS_ENDPOINT, NON_EXISTING_CUSTOMER_ID));
    assertEquals(404, exception.getCode());
    assertEquals("5269", exception.getError().getCode());
    assertEquals("Entity not found", exception.getError().getMessage());
  }
}