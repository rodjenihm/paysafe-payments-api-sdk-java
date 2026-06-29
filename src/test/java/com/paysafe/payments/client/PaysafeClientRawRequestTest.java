// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import com.paysafe.payments.PaysafeClient;
import com.paysafe.payments.api.DirectRequestOptions;
import com.paysafe.payments.api.PaysafeApiResponse;
import com.paysafe.payments.base.TestStubServer;
import com.paysafe.payments.base.TestStubServer.StubResponse;
import com.paysafe.payments.base.TestStubServer.UrlMatchType;
import com.paysafe.payments.config.Environment;
import com.paysafe.payments.errorhandling.exception.PaysafeSdkException;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PaysafeClientRawRequestTest {

  private PaysafeClient paysafeClient;
  private TestStubServer stubServer;

  @BeforeAll
  void setup() throws Exception {
    stubServer = new TestStubServer();
    stubServer.startHttp(0);
    paysafeClient = new PaysafeClient("testApiKey:testApiSecret", Environment.TEST);
    paysafeClient.overrideBaseUrl(stubServer.getBaseUrl());
  }

  @AfterAll
  void teardown() {
    if (stubServer != null) {
      stubServer.stop();
    }
  }

  @BeforeEach
  void reset() {
    stubServer.resetAll();
  }

  @Test
  void testRawGetBank() throws PaysafeSdkException {
    String bankEndpoint = "/paymenthub/v1/banks";
    stubServer.stub("GET", bankEndpoint, UrlMatchType.PATH_EQUAL,
        StubResponse.builder().status(200).header("Content-Type", "application/json")
            .body("[{\"bankId\":\"RZOOAT2L523\",\"bankName\":\"Attergauer Raiffeisenbank reg.Gen.m.b.H.\"}]").build());

    DirectRequestOptions options = new DirectRequestOptions();
    options.addHeader("Custom-Header", "value");

    PaysafeApiResponse response = paysafeClient.directRequest(PaysafeClient.RequestMethod.GET,
        bankEndpoint + "?accountId=12345612&countryCode=IT&currencyCode=EUR&paymentType=MBK", null, options);

    assertNotNull(response);
    assertEquals(200, response.getHttpStatusCode());
    assertTrue(response.getResponseBody().contains("bankId"));
    assertTrue(response.getResponseBody().contains("RZOOAT2L523"));
  }

  @Test
  void testRawPostSightlineRegistration() throws PaysafeSdkException {
    String registrationEndpoint = "/paymenthub/v1/sightline/registrations";
    stubServer.stub("POST", registrationEndpoint, UrlMatchType.URL_EQUAL,
        StubResponse.builder().status(201).header("Content-Type", "application/json")
            .body("{\"id\":\"reg-789\",\"status\":\"INITIATED\",\"merchantRefNum\":\"576d95e8-a8e6-48b5-a8a8-11ae8352071q\","
                + "\"paymentType\":\"SIGHTLINE\",\"profile\":{\"firstName\":\"John\",\"lastName\":\"Doe\","
                + "\"email\":\"paysafe@gmail.com\"},\"sightline\":{\"consumerId\":\"12312313\"}}").build());

    DirectRequestOptions options = new DirectRequestOptions();
    Map<String, Object> registration = new HashMap<>();
    registration.put("merchantRefNum", "576d95e8-a8e6-48b5-a8a8-11ae8352071q");
    registration.put("paymentType", "SIGHTLINE");
    Map<String, Object> sightline = new HashMap<>();
    sightline.put("consumerId", "12312313");
    registration.put("sightline", sightline);

    PaysafeApiResponse response = paysafeClient.directRequest(PaysafeClient.RequestMethod.POST, registrationEndpoint, registration, options);

    assertNotNull(response);
    assertEquals(201, response.getHttpStatusCode());
    assertTrue(response.getResponseBody().contains("INITIATED"));
    assertTrue(response.getResponseBody().contains("reg-789"));
  }

  @Test
  void testSerializeDeserialize() throws PaysafeSdkException {
    Map<String, Object> obj = new HashMap<>();
    obj.put("test", "testValue");

    String json = paysafeClient.serialize(obj);
    assertTrue(json.contains("test"));

    Map deserialized = paysafeClient.deserialize(json, Map.class);
    assertEquals("testValue", deserialized.get("test"));
  }

  @Test
  void testDirectRequestWithPreSerializedBody() throws PaysafeSdkException {
    String registrationEndpoint = "/paymenthub/v1/vippreferred/registrations";
    stubServer.stub("POST", registrationEndpoint, UrlMatchType.URL_EQUAL,
        StubResponse.builder().status(201).header("Content-Type", "application/json")
            .body("{\"id\":\"reg-123\",\"status\":\"INITIATED\"}").build());

    Map<String, Object> customObject = new HashMap<>();
    customObject.put("merchantRefNum", "abc-123");
    customObject.put("paymentType", "VIPPREFERRED");

    String requestBody = paysafeClient.serialize(customObject);
    DirectRequestOptions options = new DirectRequestOptions();
    PaysafeApiResponse response = paysafeClient.directRequest(PaysafeClient.RequestMethod.POST, registrationEndpoint, requestBody, options);

    assertNotNull(response);
    assertEquals(201, response.getHttpStatusCode());
    assertEquals(response.getResponseBody(), response.responseBody());
    assertTrue(response.responseBody().contains("INITIATED"));
  }
}
