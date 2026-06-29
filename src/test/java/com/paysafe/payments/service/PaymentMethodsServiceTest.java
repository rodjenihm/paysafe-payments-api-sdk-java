// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.paysafe.payments.base.BaseStubServerTest;
import com.paysafe.payments.base.TestStubServer.StubResponse;
import com.paysafe.payments.base.TestStubServer.UrlMatchType;
import com.paysafe.payments.errorhandling.exception.PaysafeSdkException;
import com.paysafe.payments.model.common.enums.CurrencyCode;
import com.paysafe.payments.model.paymenthandle.enums.PaymentType;
import com.paysafe.payments.model.paymentmethod.LookUpPaymentMethodsResponse;

public class PaymentMethodsServiceTest extends BaseStubServerTest {

  public static final String PAYMENT_METHODS_ENDPOINT = "/paymenthub/v1/paymentmethods";

  @Test
  void testLookUpPaymentMethods_isSuccessful() throws PaysafeSdkException {
    stubServer.stub("GET", PAYMENT_METHODS_ENDPOINT, UrlMatchType.PATH_EQUAL,
        StubResponse.builder()
            .status(200)
            .header("Content-Type", "application/json")
            .bodyFile("payment_methods/payment_methods_response.json")
            .build());

    LookUpPaymentMethodsResponse response = paysafeClient.lookUpPaymentMethodsService().lookUpPaymentMethods(CurrencyCode.USD);

    stubServer.verify(1, "GET", String.format("%s?currencyCode=USD", PAYMENT_METHODS_ENDPOINT));

    assertEquals(CurrencyCode.USD, response.getPaymentMethods().get(0).getCurrencyCode());
    assertEquals("1009355920", response.getPaymentMethods().get(0).getAccountId());
    assertEquals(2, response.getPaymentMethods().size());
    assertEquals(PaymentType.CARD, response.getPaymentMethods().get(0).getPaymentMethod());
  }
}
