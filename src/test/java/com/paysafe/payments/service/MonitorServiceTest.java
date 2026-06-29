// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.paysafe.payments.base.BaseStubServerTest;
import com.paysafe.payments.base.TestStubServer.StubResponse;
import com.paysafe.payments.base.TestStubServer.UrlMatchType;
import com.paysafe.payments.errorhandling.exception.PaysafeSdkException;
import com.paysafe.payments.model.monitor.MonitorResponse;
import com.paysafe.payments.model.monitor.enums.ServiceStatus;

public class MonitorServiceTest extends BaseStubServerTest {

  public static final String MONITOR_ENDPOINT = "/paymenthub/v1/monitor";

  @Test
  void testVerifyThatServiceIsAccessible_isSuccessful() throws PaysafeSdkException {
    stubServer.stub("GET", MONITOR_ENDPOINT, UrlMatchType.PATH_EQUAL,
        StubResponse.builder()
            .status(200)
            .header("Content-Type", "application/json")
            .bodyFile("monitor/verify_that_service_is_accessible_response.json")
            .build());

    MonitorResponse monitorResponse = paysafeClient.monitorService().verifyThatServiceIsAccessible();

    stubServer.verify(1, "GET", MONITOR_ENDPOINT);
    assertEquals(ServiceStatus.READY, monitorResponse.getStatus());
  }
}
