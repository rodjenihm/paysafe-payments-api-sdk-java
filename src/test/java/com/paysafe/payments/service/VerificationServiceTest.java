// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.paysafe.payments.base.BaseStubServerTest;
import com.paysafe.payments.base.TestStubServer.StubResponse;
import com.paysafe.payments.base.TestStubServer.UrlMatchType;
import com.paysafe.payments.errorhandling.exception.ApiConnectionException;
import com.paysafe.payments.errorhandling.exception.InvalidCredentialsException;
import com.paysafe.payments.errorhandling.exception.PaysafeSdkException;
import com.paysafe.payments.errorhandling.exception.UnauthorizedException;
import com.paysafe.payments.model.common.paymentfacilitator.PaymentFacilitator;
import com.paysafe.payments.model.common.paymentfacilitator.SubMerchant;
import com.paysafe.payments.model.common.paymentfacilitator.SubMerchantAddress;
import com.paysafe.payments.model.verification.Verification;
import com.paysafe.payments.model.verification.VerificationList;
import com.paysafe.payments.model.verification.VerificationRequest;

class VerificationServiceTest extends BaseStubServerTest {

  public static final String VERIFICATION_ENDPOINT = "/paymenthub/v1/verifications";
  public static final String VERIFICATION_ID = "71aea8ae-e801-4df3-9436-c5a61c88d3ad";
  public static final String MERCHANT_REF_NUM = "2009581773001912343";

  @Test
  void testGetVerificationById_isSuccessful() throws PaysafeSdkException {
    stubServer.stub("GET", String.format("%s/%s", VERIFICATION_ENDPOINT, VERIFICATION_ID), UrlMatchType.PATH_EQUAL,
        StubResponse.builder().status(200).header("Content-Type", "application/json")
            .bodyFile("verification/get_verification_by_id_card_response.json").build());

    Verification response = paysafeClient.verificationService().getVerificationById(VERIFICATION_ID);

    stubServer.verify(1, "GET", String.format("%s/%s", VERIFICATION_ENDPOINT, VERIFICATION_ID));
    assertNotNull(response);
  }

  @Test
  void testGetVerificationById_throwsExceptionOnInvalidCredentialsError() {
    stubServer.stub("GET", String.format("%s/%s", VERIFICATION_ENDPOINT, VERIFICATION_ID), UrlMatchType.PATH_EQUAL,
        StubResponse.builder().status(401).header("Content-Type", "application/json")
            .bodyFile("error/401_invalid_credentials_response.json").build());

    PaysafeSdkException exception = assertThrows(PaysafeSdkException.class,
        () -> paysafeClient.verificationService().getVerificationById(VERIFICATION_ID));

    stubServer.verify(1, "GET", String.format("%s/%s", VERIFICATION_ENDPOINT, VERIFICATION_ID));
    assertEquals(401, exception.getCode());
    assertNull(exception.getInternalCorrelationId());
    assertEquals("5279", exception.getError().getCode());
    assertEquals("Invalid credentials", exception.getError().getMessage());
    assertEquals("The authentication credentials are invalid.", exception.getError().getDetails().get(0));
  }

  @Test
  void testGetVerificationById_throwsExceptionOnEntityNotFoundError() {
    stubServer.stub("GET", String.format("%s/%s", VERIFICATION_ENDPOINT, VERIFICATION_ID), UrlMatchType.PATH_EQUAL,
        StubResponse.builder().status(404).header("Content-Type", "application/json")
            .bodyFile("error/404_entity_not_found_response.json").build());

    PaysafeSdkException exception = assertThrows(PaysafeSdkException.class,
        () -> paysafeClient.verificationService().getVerificationById(VERIFICATION_ID));

    stubServer.verify(1, "GET", String.format("%s/%s", VERIFICATION_ENDPOINT, VERIFICATION_ID));
    assertEquals(404, exception.getCode());
    assertNull(exception.getInternalCorrelationId());
    assertEquals("5269", exception.getError().getCode());
    assertEquals("Entity not found", exception.getError().getMessage());
    assertEquals("The ID(s) specified in the URL do not correspond to the values in the system.", exception.getError().getDetails().get(0));
  }

  @Test
  void testGetVerificationById_throwsExceptionOnUnauthorizedAccessError() {
    stubServer.stub("GET", String.format("%s/%s", VERIFICATION_ENDPOINT, VERIFICATION_ID), UrlMatchType.PATH_EQUAL,
        StubResponse.builder().status(403).header("Content-Type", "application/json")
            .bodyFile("error/403_unauthorized_response.json").build());

    PaysafeSdkException exception = assertThrows(PaysafeSdkException.class,
        () -> paysafeClient.verificationService().getVerificationById(VERIFICATION_ID));

    stubServer.verify(1, "GET", String.format("%s/%s", VERIFICATION_ENDPOINT, VERIFICATION_ID));
    assertEquals(403, exception.getCode());
    assertNull(exception.getInternalCorrelationId());
    assertEquals("5270", exception.getError().getCode());
    assertEquals("Unauthorized access", exception.getError().getMessage());
    assertEquals("The credentials do not have permission to access the requested data.", exception.getError().getDetails().get(0));
  }

  @Test
  void testGetVerificationById_throwsPaysafeSdkExceptionOnIOError() {
    stubServer.stub("GET", String.format("%s/%s", VERIFICATION_ENDPOINT, VERIFICATION_ID), UrlMatchType.PATH_EQUAL,
        StubResponse.fault());

    ApiConnectionException exception = assertThrows(ApiConnectionException.class,
        () -> paysafeClient.verificationService().getVerificationById(VERIFICATION_ID));

    assertNull(exception.getCode());
    assertNull(exception.getInternalCorrelationId());
    assertNull(exception.getError());
    assertTrue(exception.getMessage().contains("Error connecting to " + baseUrl));
  }

  @Test
  void testGetVerificationUsingMerchantReferenceNumber_isSuccessful() throws PaysafeSdkException {
    stubServer.stub("GET", VERIFICATION_ENDPOINT, UrlMatchType.PATH_EQUAL,
        StubResponse.builder().status(200).header("Content-Type", "application/json")
            .bodyFile("verification/get_verification_using_merchant_ref_num_card_response.json").build());

    VerificationList response = paysafeClient.verificationService().getVerificationUsingMerchantReferenceNumber(MERCHANT_REF_NUM,
        null, null, null, null);

    stubServer.verify(1, "GET", String.format("%s?merchantRefNum=%s", VERIFICATION_ENDPOINT, MERCHANT_REF_NUM));
    assertNotNull(response);
    assertNotNull(response.getMeta());
    assertNotNull(response.getVerifications());
    assertFalse(response.getVerifications().isEmpty());
  }

  @Test
  void testGetVerificationUsingMerchantReferenceNumber_throwsExceptionOnInvalidCredentialsError() {
    stubServer.stub("GET", VERIFICATION_ENDPOINT, UrlMatchType.PATH_EQUAL,
        StubResponse.builder().status(401).header("Content-Type", "application/json")
            .bodyFile("error/401_invalid_credentials_response.json").build());

    InvalidCredentialsException exception = assertThrows(InvalidCredentialsException.class,
        () -> paysafeClient.verificationService().getVerificationUsingMerchantReferenceNumber(MERCHANT_REF_NUM, null, null, null, null));

    stubServer.verify(1, "GET", String.format("%s?merchantRefNum=%s", VERIFICATION_ENDPOINT, MERCHANT_REF_NUM));
    assertEquals(401, exception.getCode());
    assertNull(exception.getInternalCorrelationId());
    assertEquals("5279", exception.getError().getCode());
    assertEquals("Invalid credentials", exception.getError().getMessage());
    assertEquals("The authentication credentials are invalid.", exception.getError().getDetails().get(0));
  }

  @Test
  void testGetVerificationUsingMerchantReferenceNumber_throwsExceptionOnUnauthorizedAccessError() {
    stubServer.stub("GET", VERIFICATION_ENDPOINT, UrlMatchType.PATH_EQUAL,
        StubResponse.builder().status(403).header("Content-Type", "application/json")
            .bodyFile("error/403_unauthorized_response.json").build());

    UnauthorizedException exception = assertThrows(UnauthorizedException.class,
        () -> paysafeClient.verificationService().getVerificationUsingMerchantReferenceNumber(MERCHANT_REF_NUM, null, null, null, null));

    stubServer.verify(1, "GET", String.format("%s?merchantRefNum=%s", VERIFICATION_ENDPOINT, MERCHANT_REF_NUM));
    assertEquals(403, exception.getCode());
    assertNull(exception.getInternalCorrelationId());
    assertEquals("5270", exception.getError().getCode());
    assertEquals("Unauthorized access", exception.getError().getMessage());
    assertEquals("The credentials do not have permission to access the requested data.", exception.getError().getDetails().get(0));
  }

  @Test
  void testGetVerificationUsingMerchantReferenceNumber_throwsExceptionOnEntityNotFoundError() {
    stubServer.stub("GET", VERIFICATION_ENDPOINT, UrlMatchType.PATH_EQUAL,
        StubResponse.builder().status(404).header("Content-Type", "application/json")
            .bodyFile("error/404_entity_not_found_response.json").build());

    PaysafeSdkException exception = assertThrows(PaysafeSdkException.class,
        () -> paysafeClient.verificationService().getVerificationUsingMerchantReferenceNumber(MERCHANT_REF_NUM, null, null, null, null));

    stubServer.verify(1, "GET", String.format("%s?merchantRefNum=%s", VERIFICATION_ENDPOINT, MERCHANT_REF_NUM));
    assertEquals(404, exception.getCode());
    assertNull(exception.getInternalCorrelationId());
    assertEquals("5269", exception.getError().getCode());
    assertEquals("Entity not found", exception.getError().getMessage());
    assertEquals("The ID(s) specified in the URL do not correspond to the values in the system.", exception.getError().getDetails().get(0));
  }

  @Test
  void testGetVerificationUsingMerchantReferenceNumber_throwsPaysafeSdkExceptionOnIOError() {
    stubServer.stub("GET", VERIFICATION_ENDPOINT, UrlMatchType.PATH_EQUAL,
        StubResponse.fault());

    ApiConnectionException exception = assertThrows(ApiConnectionException.class,
        () -> paysafeClient.verificationService().getVerificationUsingMerchantReferenceNumber(MERCHANT_REF_NUM, null, null, null, null));

    stubServer.verify(3, "GET", String.format("%s?merchantRefNum=%s", VERIFICATION_ENDPOINT, MERCHANT_REF_NUM));
    assertNull(exception.getCode());
    assertNull(exception.getInternalCorrelationId());
    assertNull(exception.getError());
    assertTrue(exception.getMessage().contains("Error connecting to " + baseUrl));
  }

  @Test
  void testCreateVerification_isSuccessful() throws PaysafeSdkException {
    stubServer.stub("POST", VERIFICATION_ENDPOINT, UrlMatchType.PATH_EQUAL,
        StubResponse.builder().status(200).header("Content-Type", "application/json")
            .bodyFile("verification/create_verification_card_response.json").build());

    Verification response = paysafeClient.verificationService().createVerification(buildVerificationRequest());

    stubServer.verify(1, "POST", VERIFICATION_ENDPOINT);
    assertNotNull(response);
  }

  @Test
  void testCreateVerification_throwsExceptionOnInvalidCredentialsError() {
    stubServer.stub("POST", VERIFICATION_ENDPOINT, UrlMatchType.PATH_EQUAL,
        StubResponse.builder().status(401).header("Content-Type", "application/json")
            .bodyFile("error/401_invalid_credentials_response.json").build());

    InvalidCredentialsException exception = assertThrows(InvalidCredentialsException.class,
        () -> paysafeClient.verificationService().createVerification(buildVerificationRequest()));

    stubServer.verify(1, "POST", VERIFICATION_ENDPOINT);
    assertEquals(401, exception.getCode());
    assertNull(exception.getInternalCorrelationId());
    assertEquals("5279", exception.getError().getCode());
    assertEquals("Invalid credentials", exception.getError().getMessage());
    assertEquals("The authentication credentials are invalid.", exception.getError().getDetails().get(0));
  }

  @Test
  void testCreateVerification_throwsExceptionOnUnauthorizedAccessError() {
    stubServer.stub("POST", VERIFICATION_ENDPOINT, UrlMatchType.PATH_EQUAL,
        StubResponse.builder().status(403).header("Content-Type", "application/json")
            .bodyFile("error/403_unauthorized_response.json").build());

    UnauthorizedException exception = assertThrows(UnauthorizedException.class,
        () -> paysafeClient.verificationService().createVerification(buildVerificationRequest()));

    stubServer.verify(1, "POST", VERIFICATION_ENDPOINT);
    assertEquals(403, exception.getCode());
    assertNull(exception.getInternalCorrelationId());
    assertEquals("5270", exception.getError().getCode());
    assertEquals("Unauthorized access", exception.getError().getMessage());
    assertEquals("The credentials do not have permission to access the requested data.", exception.getError().getDetails().get(0));
  }

  @Test
  void testCreateVerification_throwsPaysafeSdkExceptionOnIOError() {
    stubServer.stub("POST", VERIFICATION_ENDPOINT, UrlMatchType.PATH_EQUAL,
        StubResponse.fault());

    ApiConnectionException exception = assertThrows(ApiConnectionException.class,
        () -> paysafeClient.verificationService().createVerification(buildVerificationRequest()));

    stubServer.verify(1, "POST", VERIFICATION_ENDPOINT);
    assertNull(exception.getCode());
    assertNull(exception.getInternalCorrelationId());
    assertNull(exception.getError());
    assertTrue(exception.getMessage().contains("Error connecting to " + baseUrl));
  }

  private VerificationRequest buildVerificationRequest() {
    return VerificationRequest.builder()
        .paymentHandleToken("SCTGXiTclLWRk5Pt")
        .merchantRefNum("2ca14f87ff6f60976d18")
        .customerIp("172.10.12.64")
        .dupCheck(Boolean.FALSE)
        .description("Winning payment from Loto 649")
        .paymentFacilitator(PaymentFacilitator.builder()
            .subMerchant(SubMerchant.builder()
                .id("123456789")
                .name("PayFacSubMerchant")
                .phone("478234562331")
                .email("payfac@mail.com")
                .url("www.payfac.com")
                .address(SubMerchantAddress.builder()
                    .street("100 Queen Street West")
                    .city("Toronto")
                    .state("ON")
                    .country("CA")
                    .zip("M5H 2N2")
                    .build())
                .build())
            .build())
        .build();
  }
}
