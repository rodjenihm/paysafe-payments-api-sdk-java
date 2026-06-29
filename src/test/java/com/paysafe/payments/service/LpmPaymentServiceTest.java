// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.paysafe.payments.base.BaseStubServerTest;
import com.paysafe.payments.base.TestStubServer.StubResponse;
import com.paysafe.payments.base.TestStubServer.UrlMatchType;
import com.paysafe.payments.errorhandling.exception.PaysafeSdkException;
import com.paysafe.payments.model.common.BillingDetails;
import com.paysafe.payments.model.common.ReturnLink;
import com.paysafe.payments.model.common.enums.CurrencyCode;
import com.paysafe.payments.model.common.enums.HttpMethod;
import com.paysafe.payments.model.lpm.Neteller;
import com.paysafe.payments.model.lpm.Paypal;
import com.paysafe.payments.model.lpm.Paysafecard;
import com.paysafe.payments.model.lpm.Paysafecash;
import com.paysafe.payments.model.lpm.Skrill;
import com.paysafe.payments.model.lpm.enums.KeyLevelRestriction;
import com.paysafe.payments.model.lpm.enums.LanguageCode;
import com.paysafe.payments.model.lpm.enums.PaypalShippingReference;
import com.paysafe.payments.model.payment.Payment;
import com.paysafe.payments.model.paymenthandle.PaymentHandle;
import com.paysafe.payments.model.paymenthandle.PaymentHandleRequest;
import com.paysafe.payments.model.payment.PaymentRequest;
import com.paysafe.payments.model.paymenthandle.enums.PaymentType;
import com.paysafe.payments.model.paymenthandle.enums.ReturnLinkRel;
import com.paysafe.payments.model.paymenthandle.enums.TransactionType;

class LpmPaymentServiceTest extends BaseStubServerTest {

  private static final String PAYMENT_HANDLES_ENDPOINT = "/paymenthub/v1/paymenthandles";
  private static final String PAYMENT_ENDPOINT = "/paymenthub/v1/payments";

  @Test
  void testCreatePaymentHandle_skrill_isSuccessful() throws PaysafeSdkException {
    stubServer.stub("POST", PAYMENT_HANDLES_ENDPOINT, UrlMatchType.PATH_EQUAL,
        StubResponse.builder()
            .status(200)
            .header("Content-Type", "application/json")
            .bodyFile("paymenthandle/create_payment_handle_skrill_response.json")
            .build());

    PaymentHandleRequest request = PaymentHandleRequest.builder()
        .merchantRefNum("merchant-ref-skrill-001")
        .transactionType(TransactionType.PAYMENT)
        .paymentType(PaymentType.SKRILL)
        .amount(500)
        .currencyCode(CurrencyCode.USD)
        .customerIp("172.0.0.1")
        .skrill(Skrill.builder()
            .consumerId("john.doe@gmail.com")
            .language(LanguageCode.EN)
            .logoUrl("http://www.paysafe.com/icon.jpg")
            .detail1Text("Detail 1 text")
            .detail1Description("Detail 1 description")
            .countryCode("DE")
            .build())
        .billingDetails(BillingDetails.builder()
            .zip("M5H 2N2")
            .country("CA")
            .build())
        .returnLinks(buildReturnLinks())
        .build();

    PaymentHandle response = paysafeClient.paymentHandleService().createPaymentHandle(request);

    stubServer.verify(1, "POST", PAYMENT_HANDLES_ENDPOINT);
    assertNotNull(response);
    assertEquals("cdd1e763-352f-4905-a93f-1838ea467a1e", response.getId());
    assertEquals("SKRILL", response.getPaymentType().toString());
    assertEquals("INITIATED", response.getStatus().toString());
    assertEquals(500, response.getAmount());
    assertNotNull(response.getSkrill());
    assertEquals("john.doe@gmail.com", response.getSkrill().getConsumerId());
  }

  @Test
  void testCreatePaymentHandle_neteller_isSuccessful() throws PaysafeSdkException {
    stubServer.stub("POST", PAYMENT_HANDLES_ENDPOINT, UrlMatchType.PATH_EQUAL,
        StubResponse.builder()
            .status(200)
            .header("Content-Type", "application/json")
            .bodyFile("paymenthandle/create_payment_handle_neteller_response.json")
            .build());

    PaymentHandleRequest request = PaymentHandleRequest.builder()
        .merchantRefNum("merchant-ref-neteller-001")
        .transactionType(TransactionType.PAYMENT)
        .paymentType(PaymentType.NETELLER)
        .amount(500)
        .currencyCode(CurrencyCode.USD)
        .customerIp("172.0.0.1")
        .neteller(Neteller.builder()
            .consumerId("neteller.account@example.org")
            .recipientDescription("logo_url_alt_text")
            .logoUrl("http://www.paysafe.com/icon.jpg")
            .build())
        .billingDetails(buildBillingDetails())
        .returnLinks(buildReturnLinks())
        .build();

    PaymentHandle response = paysafeClient.paymentHandleService().createPaymentHandle(request);

    stubServer.verify(1, "POST", PAYMENT_HANDLES_ENDPOINT);
    assertNotNull(response);
    assertEquals("43693f8a-f3d8-4669-9b92-a04c2208afb5", response.getId());
    assertEquals("NETELLER", response.getPaymentType().toString());
    assertEquals("INITIATED", response.getStatus().toString());
    assertEquals(500, response.getAmount());
    assertNotNull(response.getNeteller());
    assertEquals("neteller.account@example.org", response.getNeteller().getConsumerId());
  }

  @Test
  void testCreatePaymentHandle_paysafecash_isSuccessful() throws PaysafeSdkException {
    stubServer.stub("POST", PAYMENT_HANDLES_ENDPOINT, UrlMatchType.PATH_EQUAL,
        StubResponse.builder()
            .status(200)
            .header("Content-Type", "application/json")
            .bodyFile("paymenthandle/create_payment_handle_paysafecash_response.json")
            .build());

    PaymentHandleRequest request = PaymentHandleRequest.builder()
        .merchantRefNum("merchant-ref-paysafecash-001")
        .transactionType(TransactionType.PAYMENT)
        .amount(500)
        .currencyCode(CurrencyCode.USD)
        .customerIp("172.0.0.1")
        .paysafecash(Paysafecash.builder()
            .consumerId("merchantclientid")
            .minAgeRestriction(18)
            .kycLevelRestriction(KeyLevelRestriction.SIMPLE)
            .countryRestriction("DE")
            .build())
        .billingDetails(buildBillingDetails())
        .returnLinks(buildReturnLinks())
        .build();

    PaymentHandle response = paysafeClient.paymentHandleService().createPaymentHandle(request);

    stubServer.verify(1, "POST", PAYMENT_HANDLES_ENDPOINT);
    assertNotNull(response);
    assertEquals("d336de7e-b1a3-4fa7-93d4-224b51185122", response.getId());
    assertEquals("PAYSAFECASH", response.getPaymentType().toString());
    assertEquals("INITIATED", response.getStatus().toString());
    assertEquals(500, response.getAmount());
    assertNotNull(response.getPaysafecash());
    assertEquals("merchantclientid", response.getPaysafecash().getConsumerId());
  }

  @Test
  void testCreatePaymentHandle_paysafecard_isSuccessful() throws PaysafeSdkException {
    stubServer.stub("POST", PAYMENT_HANDLES_ENDPOINT, UrlMatchType.PATH_EQUAL,
        StubResponse.builder()
            .status(200)
            .header("Content-Type", "application/json")
            .bodyFile("paymenthandle/create_payment_handle_paysafecard_response.json")
            .build());

    PaymentHandleRequest request = PaymentHandleRequest.builder()
        .merchantRefNum("merchant-ref-paysafecard-001")
        .transactionType(TransactionType.PAYMENT)
        .paymentType(PaymentType.PAYSAFECARD)
        .amount(500)
        .currencyCode(CurrencyCode.USD)
        .customerIp("172.0.0.1")
        .paysafecard(Paysafecard.builder()
            .consumerId("merchantclientid")
            .minAgeRestriction(18)
            .kycLevelRestriction(KeyLevelRestriction.SIMPLE)
            .countryRestriction("DE")
            .build())
        .billingDetails(buildBillingDetails())
        .returnLinks(buildReturnLinks())
        .build();

    PaymentHandle response = paysafeClient.paymentHandleService().createPaymentHandle(request);

    stubServer.verify(1, "POST", PAYMENT_HANDLES_ENDPOINT);
    assertNotNull(response);
    assertEquals("29441aa1-dc3d-43a8-8a6e-6557b1cd17d4", response.getId());
    assertEquals("PAYSAFECARD", response.getPaymentType().toString());
    assertEquals("INITIATED", response.getStatus().toString());
    assertEquals(500, response.getAmount());
    assertNotNull(response.getPaysafecard());
    assertEquals("merchantclientid", response.getPaysafecard().getConsumerId());
  }

  @Test
  void testCreatePaymentHandle_paypal_isSuccessful() throws PaysafeSdkException {
    stubServer.stub("POST", PAYMENT_HANDLES_ENDPOINT, UrlMatchType.PATH_EQUAL,
        StubResponse.builder()
            .status(200)
            .header("Content-Type", "application/json")
            .bodyFile("paymenthandle/create_payment_handle_paypal_response.json")
            .build());

    PaymentHandleRequest request = PaymentHandleRequest.builder()
        .merchantRefNum("merchant-ref-paypal-001")
        .transactionType(TransactionType.PAYMENT)
        .paymentType(PaymentType.PAYPAL)
        .amount(500)
        .currencyCode(CurrencyCode.USD)
        .customerIp("172.0.0.1")
        .payPal(Paypal.builder()
            .consumerId("sb-cpfxo1472281@personal.example.com")
            .recipientDescription("Paysafe store description for payment")
            .language(LanguageCode.US)
            .shippingPreference(PaypalShippingReference.SET_PROVIDED_ADDRESS)
            .consumerMessage("Paysafe note to payer for payment")
            .orderDescription("Paysafe Order description for payment")
            .build())
        .billingDetails(buildBillingDetails())
        .returnLinks(buildReturnLinks())
        .build();

    PaymentHandle response = paysafeClient.paymentHandleService().createPaymentHandle(request);

    stubServer.verify(1, "POST", PAYMENT_HANDLES_ENDPOINT);
    assertNotNull(response);
    assertEquals("e85f125b-a20b-455e-9657-f4a4c2beae3c", response.getId());
    assertEquals("PAYPAL", response.getPaymentType().toString());
    assertEquals("INITIATED", response.getStatus().toString());
    assertEquals(500, response.getAmount());
    assertNotNull(response.getPayPal());
    assertEquals("sb-cpfxo1472281@personal.example.com", response.getPayPal().getConsumerId());
  }

  @Test
  void testProcessPayment_skrill_isSuccessful() throws PaysafeSdkException {
    stubServer.stub("POST", PAYMENT_ENDPOINT, UrlMatchType.PATH_EQUAL,
        StubResponse.builder()
            .status(200)
            .header("Content-Type", "application/json")
            .bodyFile("payment/process_payment_skrill_response.json")
            .build());

    PaymentRequest request = PaymentRequest.builder()
        .merchantRefNum("merchant-ref-skrill-payment-001")
        .amount(1000)
        .settleWithAuth(true)
        .paymentHandleToken("PHToken_Skrill_001")
        .customerIp("172.0.0.1")
        .currencyCode(CurrencyCode.USD)
        .build();

    Payment response = paysafeClient.paymentService().processPayment(request);

    stubServer.verify(1, "POST", PAYMENT_ENDPOINT);
    assertNotNull(response);
    assertEquals("f1a2b3c4-d5e6-7890-abcd-ef1234567890", response.getId());
    assertEquals("SKRILL", response.getPaymentType().toString());
    assertEquals("COMPLETED", response.getStatus().toString());
    assertEquals(1000, response.getAmount());
    assertNotNull(response.getSkrill());
  }

  @Test
  void testProcessPayment_neteller_isSuccessful() throws PaysafeSdkException {
    stubServer.stub("POST", PAYMENT_ENDPOINT, UrlMatchType.PATH_EQUAL,
        StubResponse.builder()
            .status(200)
            .header("Content-Type", "application/json")
            .bodyFile("payment/process_payment_neteller_response.json")
            .build());

    PaymentRequest request = PaymentRequest.builder()
        .merchantRefNum("merchant-ref-neteller-payment-001")
        .amount(1000)
        .settleWithAuth(true)
        .paymentHandleToken("PHToken_Neteller_001")
        .customerIp("172.0.0.1")
        .currencyCode(CurrencyCode.USD)
        .build();

    Payment response = paysafeClient.paymentService().processPayment(request);

    stubServer.verify(1, "POST", PAYMENT_ENDPOINT);
    assertNotNull(response);
    assertEquals("f2b3c4d5-e6f7-8901-bcde-f23456789012", response.getId());
    assertEquals("NETELLER", response.getPaymentType().toString());
    assertEquals("COMPLETED", response.getStatus().toString());
    assertEquals(1000, response.getAmount());
    assertNotNull(response.getNeteller());
  }

  @Test
  void testProcessPayment_paysafecash_isSuccessful() throws PaysafeSdkException {
    stubServer.stub("POST", PAYMENT_ENDPOINT, UrlMatchType.PATH_EQUAL,
        StubResponse.builder()
            .status(200)
            .header("Content-Type", "application/json")
            .bodyFile("payment/process_payment_paysafecash_response.json")
            .build());

    PaymentRequest request = PaymentRequest.builder()
        .merchantRefNum("merchant-ref-paysafecash-payment-001")
        .amount(1000)
        .settleWithAuth(true)
        .paymentHandleToken("PHToken_Paysafecash_001")
        .customerIp("172.0.0.1")
        .currencyCode(CurrencyCode.EUR)
        .build();

    Payment response = paysafeClient.paymentService().processPayment(request);

    stubServer.verify(1, "POST", PAYMENT_ENDPOINT);
    assertNotNull(response);
    assertEquals("f3c4d5e6-f7a8-9012-cdef-345678901234", response.getId());
    assertEquals("PAYSAFECASH", response.getPaymentType().toString());
    assertEquals("COMPLETED", response.getStatus().toString());
    assertEquals(1000, response.getAmount());
    assertNotNull(response.getPaysafecash());
  }

  @Test
  void testProcessPayment_paysafecard_isSuccessful() throws PaysafeSdkException {
    stubServer.stub("POST", PAYMENT_ENDPOINT, UrlMatchType.PATH_EQUAL,
        StubResponse.builder()
            .status(200)
            .header("Content-Type", "application/json")
            .bodyFile("payment/process_payment_paysafecard_response.json")
            .build());

    PaymentRequest request = PaymentRequest.builder()
        .merchantRefNum("merchant-ref-paysafecard-payment-001")
        .amount(1000)
        .settleWithAuth(true)
        .paymentHandleToken("PHToken_Paysafecard_001")
        .customerIp("172.0.0.1")
        .currencyCode(CurrencyCode.EUR)
        .build();

    Payment response = paysafeClient.paymentService().processPayment(request);

    stubServer.verify(1, "POST", PAYMENT_ENDPOINT);
    assertNotNull(response);
    assertEquals("f4d5e6f7-a8b9-0123-defa-456789012345", response.getId());
    assertEquals("PAYSAFECARD", response.getPaymentType().toString());
    assertEquals("COMPLETED", response.getStatus().toString());
    assertEquals(1000, response.getAmount());
    assertNotNull(response.getPaysafecard());
  }

  @Test
  void testProcessPayment_paypal_isSuccessful() throws PaysafeSdkException {
    stubServer.stub("POST", PAYMENT_ENDPOINT, UrlMatchType.PATH_EQUAL,
        StubResponse.builder()
            .status(200)
            .header("Content-Type", "application/json")
            .bodyFile("payment/process_payment_paypal_response.json")
            .build());

    PaymentRequest request = PaymentRequest.builder()
        .merchantRefNum("merchant-ref-paypal-payment-001")
        .amount(1000)
        .settleWithAuth(true)
        .paymentHandleToken("PHToken_PayPal_001")
        .customerIp("172.0.0.1")
        .currencyCode(CurrencyCode.USD)
        .build();

    Payment response = paysafeClient.paymentService().processPayment(request);

    stubServer.verify(1, "POST", PAYMENT_ENDPOINT);
    assertNotNull(response);
    assertEquals("f5e6f7a8-b9c0-1234-efab-567890123456", response.getId());
    assertEquals("PAYPAL", response.getPaymentType().toString());
    assertEquals("COMPLETED", response.getStatus().toString());
    assertEquals(1000, response.getAmount());
    assertNotNull(response.getPayPal());
  }

  private BillingDetails buildBillingDetails() {
    return BillingDetails.builder()
        .street("100 Queen Street")
        .city("Toronto")
        .zip("M5H 2N2")
        .state("ON")
        .country("CA")
        .build();
  }

  private List<ReturnLink> buildReturnLinks() {
    return List.of(
        ReturnLink.builder()
            .rel(ReturnLinkRel.DEFAULT)
            .href("https://example.com/payment/return/")
            .method(HttpMethod.GET)
            .build(),
        ReturnLink.builder()
            .rel(ReturnLinkRel.ON_COMPLETED)
            .href("https://example.com/payment/return/success")
            .method(HttpMethod.GET)
            .build(),
        ReturnLink.builder()
            .rel(ReturnLinkRel.ON_FAILED)
            .href("https://example.com/payment/return/failed")
            .method(HttpMethod.GET)
            .build()
    );
  }
}
