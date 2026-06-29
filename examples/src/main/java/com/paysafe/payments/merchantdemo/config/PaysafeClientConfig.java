// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.merchantdemo.config;

import com.paysafe.payments.PaysafeClient;
import com.paysafe.payments.config.Environment;
import com.paysafe.payments.errorhandling.exception.IllegalArgumentException;
import com.paysafe.payments.logging.LoggingLevel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Spring configuration for creating and configuring the PaysafeClient bean.
 * Sets up API credentials and environment for SDK usage.
 */
@Configuration
public class PaysafeClientConfig {

  @Value("${paysafe.apiKey}")
  private String apiKey;

  @Bean
  public PaysafeClient paysafeClient() throws IllegalArgumentException {
    return PaysafeClient.builder()
        .apiKey(apiKey)
        .environment(Environment.TEST)
        .maxAutomaticRetries(3)
        .connectTimeout(60000)
        .responseTimeout(60000)
        .loggingLevel(LoggingLevel.ALL)
        .build();
  }
}
