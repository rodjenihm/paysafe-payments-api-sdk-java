// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.paysafe.payments.api.RequestOptions;
import com.paysafe.payments.base.BaseStubServerTest;
import com.paysafe.payments.base.TestStubServer.StubResponse;
import com.paysafe.payments.base.TestStubServer.UrlMatchType;
import com.paysafe.payments.errorhandling.exception.ApiConnectionException;
import com.paysafe.payments.errorhandling.exception.ApiException;
import com.paysafe.payments.errorhandling.exception.InvalidCredentialsException;
import com.paysafe.payments.errorhandling.exception.PaysafeSdkException;
import com.paysafe.payments.errorhandling.exception.RequestDeclinedException;
import com.paysafe.payments.errorhandling.exception.UnauthorizedException;
import com.paysafe.payments.model.card.Card;
import com.paysafe.payments.model.card.CardExpiry;
import com.paysafe.payments.model.card.enums.*;
import com.paysafe.payments.model.card.threeds.*;
import com.paysafe.payments.model.common.BillingDetails;
import com.paysafe.payments.model.common.ReturnLink;
import com.paysafe.payments.model.common.enums.CurrencyCode;
import com.paysafe.payments.model.common.enums.HttpMethod;
import com.paysafe.payments.model.common.enums.PaymentSimulator;
import com.paysafe.payments.model.paymenthandle.PaymentHandle;
import com.paysafe.payments.model.paymenthandle.PaymentHandleList;
import com.paysafe.payments.model.paymenthandle.PaymentHandleRequest;
import com.paysafe.payments.model.paymenthandle.enums.PaymentType;
import com.paysafe.payments.model.paymenthandle.enums.ReturnLinkRel;
import com.paysafe.payments.model.paymenthandle.enums.TransactionType;

public class PaymentHandleServiceTest extends BaseStubServerTest {

  public static final String PAYMENT_HANDLES_ENDPOINT = "/paymenthub/v1/paymenthandles";
  public static final String MERCHANT_REF_NUM = "rzkPbqSIHGGOmja8jf2tCKIHg";
  public static final String PAYMENT_HANDLE_ID = "e05205d9-93f3-4c20-9c2a-b6b8dc74cf17";

  @Test
  void testCreatePaymentHandle_isSuccessful() throws PaysafeSdkException {
    stubServer.stub("POST", PAYMENT_HANDLES_ENDPOINT, UrlMatchType.PATH_EQUAL,
        StubResponse.builder().status(200).header("Content-Type", "application/json")
            .bodyFile("paymenthandle/create_payment_handle_card_3ds_response.json").build());
    PaymentHandle response = paysafeClient.paymentHandleService().createPaymentHandle(buildPaymentHandleRequest());
    stubServer.verify(1, "POST", PAYMENT_HANDLES_ENDPOINT);
    assertNotNull(response);
  }

  @Test
  void testCreatePaymentHandle_withSimulatorOnRequestLevel_isSuccessful() throws PaysafeSdkException {
    stubServer.stub("POST", PAYMENT_HANDLES_ENDPOINT, UrlMatchType.PATH_EQUAL,
        StubResponse.builder().status(200).header("Content-Type", "application/json")
            .bodyFile("paymenthandle/create_payment_handle_card_3ds_response.json").build());
    PaymentHandle response = paysafeClient.paymentHandleService()
        .createPaymentHandle(buildPaymentHandleRequest(), RequestOptions.builder().simulator(PaymentSimulator.INTERNAL).build());
    stubServer.verify(1, "POST", PAYMENT_HANDLES_ENDPOINT);
    assertNotNull(response);
  }

  @Test
  void testCreatePaymentHandle_throwsExceptionOnInvalidCredentialsError() {
    stubServer.stub("POST", PAYMENT_HANDLES_ENDPOINT, UrlMatchType.PATH_EQUAL,
        StubResponse.builder().status(401).header("Content-Type", "application/json")
            .bodyFile("error/401_invalid_credentials_response.json").build());
    InvalidCredentialsException exception = assertThrows(InvalidCredentialsException.class,
        () -> paysafeClient.paymentHandleService().createPaymentHandle(new PaymentHandleRequest()));
    stubServer.verify(1, "POST", PAYMENT_HANDLES_ENDPOINT);
    assertEquals("5279", exception.getError().getCode());
    assertEquals("Invalid credentials", exception.getError().getMessage());
    assertEquals("The authentication credentials are invalid.", exception.getError().getDetails().get(0));
  }

  @Test
  void testCreatePaymentHandle_throwsApiException() {
    stubServer.stub("POST", PAYMENT_HANDLES_ENDPOINT, UrlMatchType.PATH_EQUAL,
        StubResponse.builder().status(500).header("Content-Type", "application/json")
            .bodyFile("error/500_internal_server_error_response.json").build());
    ApiException exception = assertThrows(ApiException.class,
        () -> paysafeClient.paymentHandleService().createPaymentHandle(new PaymentHandleRequest()));
    stubServer.verify(1, "POST", PAYMENT_HANDLES_ENDPOINT);
    assertEquals(500, exception.getCode());
    assertEquals("1000", exception.getError().getCode());
    assertEquals("Internal Error", exception.getError().getMessage());
    assertEquals("An internal error occurred.", exception.getError().getDetails().get(0));
  }

  @Test
  void testCreatePaymentHandle_throwsRequestDeclinedException() {
    stubServer.stub("POST", PAYMENT_HANDLES_ENDPOINT, UrlMatchType.PATH_EQUAL,
        StubResponse.builder().status(402).header("Content-Type", "application/json")
            .bodyFile("error/402_request_declined_response.json").build());
    RequestDeclinedException exception = assertThrows(RequestDeclinedException.class,
        () -> paysafeClient.paymentHandleService().createPaymentHandle(new PaymentHandleRequest()));
    stubServer.verify(1, "POST", PAYMENT_HANDLES_ENDPOINT);
    assertEquals(402, exception.getCode());
    assertEquals("ALTERNATE-PAYMENTS-GATEWAY-4", exception.getError().getCode());
    assertEquals("Transaction declined", exception.getError().getMessage());
    assertEquals("The transaction was declined by the processing gateway.", exception.getError().getDetails().get(0));
    assertEquals("Merchant configuration is incorrect. Verify setup in Netbanx.", exception.getError().getDetails().get(1));
    assertEquals("Refer to Issuer", ((PaymentHandle) exception.getApiResponse()).getGatewayResponse().getResponseCodeDescription());
    assertEquals("550e8400-e29b-41d4-a716-446655440000", ((PaymentHandle) exception.getApiResponse()).getId());
    assertEquals("12345", ((PaymentHandle) exception.getApiResponse()).getMerchantRefNum());
  }

  @Test
  void testCreatePaymentHandle_throwsExceptionOnUnauthorizedAccessError() {
    stubServer.stub("POST", PAYMENT_HANDLES_ENDPOINT, UrlMatchType.PATH_EQUAL,
        StubResponse.builder().status(403).header("Content-Type", "application/json")
            .bodyFile("error/403_unauthorized_response.json").build());
    PaysafeSdkException exception = assertThrows(PaysafeSdkException.class,
        () -> paysafeClient.paymentHandleService().createPaymentHandle(new PaymentHandleRequest()));
    stubServer.verify(1, "POST", PAYMENT_HANDLES_ENDPOINT);
    assertEquals("5270", exception.getError().getCode());
    assertEquals("Unauthorized access", exception.getError().getMessage());
  }

  @Test
  void testCreatePaymentHandle_throwsPaysafeSdkExceptionOnIOError() {
    stubServer.stub("POST", PAYMENT_HANDLES_ENDPOINT, UrlMatchType.PATH_EQUAL, StubResponse.fault());
    PaysafeSdkException exception = assertThrows(ApiConnectionException.class,
        () -> paysafeClient.paymentHandleService().createPaymentHandle(new PaymentHandleRequest()));
    stubServer.verify(1, "POST", PAYMENT_HANDLES_ENDPOINT);
    assertTrue(exception.getMessage().contains("Error connecting to " + baseUrl));
  }

  @Test
  void testGetPaymentHandleUsingMerchantReferenceNumber_isSuccessful() throws PaysafeSdkException {
    stubServer.stub("GET", PAYMENT_HANDLES_ENDPOINT, UrlMatchType.PATH_EQUAL,
        StubResponse.builder().status(200).header("Content-Type", "application/json")
            .bodyFile("paymenthandle/get_payment_handle_using_merchant_ref_number_card_response.json").build());
    PaymentHandleList response = paysafeClient.paymentHandleService().getPaymentHandleUsingMerchantReferenceNumber(MERCHANT_REF_NUM, null, null, null, null);
    stubServer.verify(1, "GET", String.format("%s?merchantRefNum=%s", PAYMENT_HANDLES_ENDPOINT, MERCHANT_REF_NUM));
    assertNotNull(response);
    assertNotNull(response.getMeta());
    assertNotNull(response.getPaymentHandles());
    assertFalse(response.getPaymentHandles().isEmpty());
  }

  @Test
  void testGetPaymentHandleUsingMerchantReferenceNumber_queryParamsAreSetCorrectly() throws PaysafeSdkException {
    stubServer.stub("GET", PAYMENT_HANDLES_ENDPOINT, UrlMatchType.PATH_EQUAL,
        StubResponse.builder().status(200).header("Content-Type", "application/json")
            .bodyFile("paymenthandle/get_payment_handle_using_merchant_ref_number_card_response.json").build());

    paysafeClient.paymentHandleService().getPaymentHandleUsingMerchantReferenceNumber(MERCHANT_REF_NUM, "2024-12-05", 30, 0, "2024-11-05");
    stubServer.verify(1, "GET", String.format("%s?merchantRefNum=%s&endDate=2024-12-05&limit=30&offset=0&startDate=2024-11-05", PAYMENT_HANDLES_ENDPOINT, MERCHANT_REF_NUM));

    stubServer.resetAll();
    stubServer.stub("GET", PAYMENT_HANDLES_ENDPOINT, UrlMatchType.PATH_EQUAL,
        StubResponse.builder().status(200).header("Content-Type", "application/json")
            .bodyFile("paymenthandle/get_payment_handle_using_merchant_ref_number_card_response.json").build());

    paysafeClient.paymentHandleService().getPaymentHandleUsingMerchantReferenceNumber(null, "2024-12-05", 30, 0, "2024-11-05");
    stubServer.verify(1, "GET", String.format("%s?endDate=2024-12-05&limit=30&offset=0&startDate=2024-11-05", PAYMENT_HANDLES_ENDPOINT));
  }

  @Test
  void testGetPaymentHandleUsingMerchantReferenceNumber_throwsExceptionOnInvalidCredentialsError() {
    stubServer.stub("GET", PAYMENT_HANDLES_ENDPOINT, UrlMatchType.PATH_EQUAL,
        StubResponse.builder().status(401).header("Content-Type", "application/json")
            .bodyFile("error/401_invalid_credentials_response.json").build());
    InvalidCredentialsException exception = assertThrows(InvalidCredentialsException.class,
        () -> paysafeClient.paymentHandleService().getPaymentHandleUsingMerchantReferenceNumber(MERCHANT_REF_NUM, null, null, null, null));
    stubServer.verify(1, "GET", String.format("%s?merchantRefNum=%s", PAYMENT_HANDLES_ENDPOINT, MERCHANT_REF_NUM));
    assertEquals(401, exception.getCode());
    assertNull(exception.getInternalCorrelationId());
    assertEquals("5279", exception.getError().getCode());
  }

  @Test
  void testGetPaymentHandleUsingMerchantReferenceNumber_throwsExceptionOnUnauthorizedAccessError() {
    stubServer.stub("GET", PAYMENT_HANDLES_ENDPOINT, UrlMatchType.PATH_EQUAL,
        StubResponse.builder().status(403).header("Content-Type", "application/json")
            .bodyFile("error/403_unauthorized_response.json").build());
    UnauthorizedException exception = assertThrows(UnauthorizedException.class,
        () -> paysafeClient.paymentHandleService().getPaymentHandleUsingMerchantReferenceNumber(MERCHANT_REF_NUM, null, null, null, null));
    stubServer.verify(1, "GET", String.format("%s?merchantRefNum=%s", PAYMENT_HANDLES_ENDPOINT, MERCHANT_REF_NUM));
    assertEquals(403, exception.getCode());
    assertEquals("5270", exception.getError().getCode());
  }

  @Test
  void testGetPaymentHandleUsingMerchantReferenceNumber_throwsExceptionOnEntityNotFoundError() {
    stubServer.stub("GET", PAYMENT_HANDLES_ENDPOINT, UrlMatchType.PATH_EQUAL,
        StubResponse.builder().status(404).header("Content-Type", "application/json")
            .bodyFile("error/404_entity_not_found_response.json").build());
    PaysafeSdkException exception = assertThrows(PaysafeSdkException.class,
        () -> paysafeClient.paymentHandleService().getPaymentHandleUsingMerchantReferenceNumber(MERCHANT_REF_NUM, null, null, null, null));
    stubServer.verify(1, "GET", String.format("%s?merchantRefNum=%s", PAYMENT_HANDLES_ENDPOINT, MERCHANT_REF_NUM));
    assertEquals(404, exception.getCode());
    assertEquals("5269", exception.getError().getCode());
  }

  @Test
  void testGetPaymentHandleUsingMerchantReferenceNumber_throwsApiConnectionException() {
    stubServer.stub("GET", PAYMENT_HANDLES_ENDPOINT, UrlMatchType.PATH_EQUAL, StubResponse.fault());
    ApiConnectionException exception = assertThrows(ApiConnectionException.class,
        () -> paysafeClient.paymentHandleService().getPaymentHandleUsingMerchantReferenceNumber(MERCHANT_REF_NUM, null, null, null, null));
    stubServer.verify(3, "GET", String.format("%s?merchantRefNum=%s", PAYMENT_HANDLES_ENDPOINT, MERCHANT_REF_NUM));
    assertNull(exception.getCode());
    assertNull(exception.getInternalCorrelationId());
    assertNull(exception.getError());
    assertTrue(exception.getMessage().contains("Error connecting to " + baseUrl));
  }

  @Test
  void testGetPaymentHandleById_isSuccessful() throws PaysafeSdkException {
    String url = String.format("%s/%s", PAYMENT_HANDLES_ENDPOINT, PAYMENT_HANDLE_ID);
    stubServer.stub("GET", url, UrlMatchType.PATH_EQUAL,
        StubResponse.builder().status(200).header("Content-Type", "application/json")
            .bodyFile("paymenthandle/get_payment_handle_by_id_card_response.json").build());
    PaymentHandle response = paysafeClient.paymentHandleService().getPaymentHandleById(PAYMENT_HANDLE_ID);
    stubServer.verify(1, "GET", url);
    assertNotNull(response);
  }

  @Test
  void testGetPaymentHandleById_throwsExceptionOnInvalidCredentialsError() {
    stubServer.stub("GET", String.format("%s/%s", PAYMENT_HANDLES_ENDPOINT, PAYMENT_HANDLE_ID), UrlMatchType.PATH_EQUAL,
        StubResponse.builder().status(401).header("Content-Type", "application/json")
            .bodyFile("error/401_invalid_credentials_response.json").build());
    PaysafeSdkException exception = assertThrows(PaysafeSdkException.class,
        () -> paysafeClient.paymentHandleService().getPaymentHandleById(PAYMENT_HANDLE_ID));
    stubServer.verify(1, "GET", String.format("%s/%s", PAYMENT_HANDLES_ENDPOINT, PAYMENT_HANDLE_ID));
    assertEquals(401, exception.getCode());
    assertEquals("5279", exception.getError().getCode());
  }

  @Test
  void testGetPaymentHandleById_throwsExceptionOnUnauthorizedAccessError() {
    stubServer.stub("GET", String.format("%s/%s", PAYMENT_HANDLES_ENDPOINT, PAYMENT_HANDLE_ID), UrlMatchType.PATH_EQUAL,
        StubResponse.builder().status(403).header("Content-Type", "application/json")
            .bodyFile("error/403_unauthorized_response.json").build());
    UnauthorizedException exception = assertThrows(UnauthorizedException.class,
        () -> paysafeClient.paymentHandleService().getPaymentHandleById(PAYMENT_HANDLE_ID));
    stubServer.verify(1, "GET", String.format("%s/%s", PAYMENT_HANDLES_ENDPOINT, PAYMENT_HANDLE_ID));
    assertEquals(403, exception.getCode());
    assertEquals("5270", exception.getError().getCode());
  }

  @Test
  void testGetPaymentHandleById_throwsExceptionOnEntityNotFoundError() {
    stubServer.stub("GET", String.format("%s/%s", PAYMENT_HANDLES_ENDPOINT, PAYMENT_HANDLE_ID), UrlMatchType.PATH_EQUAL,
        StubResponse.builder().status(404).header("Content-Type", "application/json")
            .bodyFile("error/404_entity_not_found_response.json").build());
    PaysafeSdkException exception = assertThrows(PaysafeSdkException.class,
        () -> paysafeClient.paymentHandleService().getPaymentHandleById(PAYMENT_HANDLE_ID));
    stubServer.verify(1, "GET", String.format("%s/%s", PAYMENT_HANDLES_ENDPOINT, PAYMENT_HANDLE_ID));
    assertEquals(404, exception.getCode());
    assertEquals("5269", exception.getError().getCode());
  }

  @Test
  void testGetPaymentHandleById_throwsApiConnectionException() {
    stubServer.stub("GET", String.format("%s/%s", PAYMENT_HANDLES_ENDPOINT, PAYMENT_HANDLE_ID), UrlMatchType.PATH_EQUAL, StubResponse.fault());
    ApiConnectionException exception = assertThrows(ApiConnectionException.class,
        () -> paysafeClient.paymentHandleService().getPaymentHandleById(PAYMENT_HANDLE_ID));
    stubServer.verify(3, "GET", String.format("%s/%s", PAYMENT_HANDLES_ENDPOINT, PAYMENT_HANDLE_ID));
    assertTrue(exception.getMessage().contains("Error connecting to " + baseUrl));
  }

  private PaymentHandleRequest buildPaymentHandleRequest() {
    return PaymentHandleRequest.builder()
        .merchantRefNum(MERCHANT_REF_NUM)
        .transactionType(TransactionType.PAYMENT)
        .threeDs(createThreeDsObject())
        .card(Card.builder()
            .cardNum("4000000000001026")
            .cardExpiry(CardExpiry.builder().month(10).year(2025).build())
            .cvv("111").issuingCountry("US").build())
        .accountId("1009688230")
        .paymentType(PaymentType.CARD)
        .amount(500)
        .currencyCode(CurrencyCode.USD)
        .billingDetails(BillingDetails.builder().nickName("Home").street("Street name").city("City Name").state("AL").country("US").zip("94404").build())
        .returnLinks(createReturnLinksList())
        .build();
  }

  private ThreeDs createThreeDsObject() {
    return ThreeDs.builder()
        .merchantUrl("https://api.qa.paysafe.com/checkout/v2/index.html#/desktop")
        .deviceChannel(ThreeDsDeviceChannel.BROWSER)
        .messageCategory(ThreeDsMessageCategory.PAYMENT)
        .transactionIntent(ThreeDsTransactionIntent.CHECK_ACCEPTANCE)
        .authenticationPurpose(ThreeDsAuthenticationPurpose.PAYMENT_TRANSACTION)
        .orderItemDetails(OrderItemDetails.builder()
            .preOrderItemAvailabilityDate("2014-01-26")
            .preOrderPurchaseIndicator(PreOrderPurchaseIndicator.MERCHANDISE_AVAILABLE)
            .reorderItemsIndicator(ReorderItemsIndicator.FIRST_TIME_ORDER)
            .shippingIndicator(ShippingIndicator.SHIP_TO_BILLING_ADDRESS).build())
        .purchasedGiftCardDetails(PurchasedGiftCardDetails.builder().amount(1234).count(2).currency(CurrencyCode.USD).build())
        .userAccountDetails(UserAccountDetails.builder()
            .addCardAttemptsForLastDay(1).changedDate("2010-01-26").changedRange(AccountChangedRange.DURING_TRANSACTION)
            .createdDate("2010-01-26").createdRange(AccountCreatedRange.NO_ACCOUNT)
            .passwordChangedDate("2012-01-26").passwordChangedRange(PasswordChangedRange.NO_CHANGE)
            .paymentAccountDetails(PaymentAccountDetails.builder().createdRange(AccountCreatedRange.NO_ACCOUNT).createdDate("2010-01-26").build())
            .build())
        .shippingDetailsUsage(ShippingDetailsUsage.builder()
            .cardHolderNameMatch(Boolean.TRUE).initialUsageDate("2014-01-26").initialUsageRange(ShippingAddressUsageRange.CURRENT_TRANSACTION).build())
        .suspiciousAccountActivity(Boolean.TRUE)
        .totalPurchasesSixMonthCount(1)
        .transactionCountForPreviousDay(1)
        .transactionCountForPreviousYear(3)
        .userLogin(UserLogin.builder()
            .authenticationMethod(UserLoginAuthenticationMethod.NO_LOGIN)
            .data("Some up to 2048 bytes undefined data").time("2014-01-26T10:32:28Z").build())
        .build();
  }

  private List<ReturnLink> createReturnLinksList() {
    return List.of(
        ReturnLink.builder().rel(ReturnLinkRel.DEFAULT).href("https://usgaminggamblig.com/payment/return/").method(HttpMethod.GET).build(),
        ReturnLink.builder().rel(ReturnLinkRel.ON_COMPLETED).href("https://usgaminggamblig.com/payment/return/success").method(HttpMethod.GET).build(),
        ReturnLink.builder().rel(ReturnLinkRel.ON_FAILED).href("https://usgaminggamblig.com/payment/return/failed").method(HttpMethod.GET).build());
  }
}
