// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.logging;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.spy;

import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.paysafe.payments.config.ObjectMapperConfiguration;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.read.ListAppender;

@ExtendWith(MockitoExtension.class)
class JsonSlf4jLoggerTest {

  private final ObjectMapper realMapper = new ObjectMapper();
  private ListAppender<ILoggingEvent> appender;
  private Logger sdkLogger;

  @BeforeEach
  void setUp() {
    sdkLogger = (Logger) LoggerFactory.getLogger("PaysafeSdk");
    appender = new ListAppender<>();
    appender.start();
    sdkLogger.addAppender(appender);
  }

  @AfterEach
  void tearDown() {
    sdkLogger.detachAppender(appender);
  }

  @Test
  void constructor_nullLoggingLevel_defaultsToError() {
    try (MockedStatic<ObjectMapperConfiguration> mockMapper = mockStatic(ObjectMapperConfiguration.class)) {
      mockMapper.when(ObjectMapperConfiguration::getObjectMapper).thenReturn(realMapper);
      new JsonSlf4jLogger(null).logEvent("test", null);

      assertTrue(appender.list.stream().noneMatch(e -> e.getLevel() == Level.INFO));
    }
  }

  @Test
  void logEvent_loggingLevelAll_logsAtInfoLevel() {
    try (MockedStatic<ObjectMapperConfiguration> mockMapper = mockStatic(ObjectMapperConfiguration.class)) {
      mockMapper.when(ObjectMapperConfiguration::getObjectMapper).thenReturn(realMapper);
      new JsonSlf4jLogger(LoggingLevel.ALL).logEvent("some-event", null);

      assertEquals(1, appender.list.size());
      assertEquals(Level.INFO, appender.list.get(0).getLevel());
      assertTrue(appender.list.get(0).getFormattedMessage().contains("some-event"));
    }
  }

  @Test
  void logEvent_loggingLevelError_doesNotLog() {
    new JsonSlf4jLogger(LoggingLevel.ERROR).logEvent("some-event", null);

    assertTrue(appender.list.isEmpty());
  }

  @Test
  void logError_alwaysLogsAtErrorLevel() {
    try (MockedStatic<ObjectMapperConfiguration> mockMapper = mockStatic(ObjectMapperConfiguration.class)) {
      mockMapper.when(ObjectMapperConfiguration::getObjectMapper).thenReturn(realMapper);
      Throwable error = new RuntimeException("fail");
      new JsonSlf4jLogger(LoggingLevel.ERROR).logError("error-event", error, null);

      assertEquals(1, appender.list.size());
      assertEquals(Level.ERROR, appender.list.get(0).getLevel());
      assertTrue(appender.list.get(0).getFormattedMessage().contains("error-event"));
    }
  }

  @Test
  void logEvent_logContainsEventAndTimestampFields() throws Exception {
    try (MockedStatic<ObjectMapperConfiguration> mockMapper = mockStatic(ObjectMapperConfiguration.class)) {
      mockMapper.when(ObjectMapperConfiguration::getObjectMapper).thenReturn(realMapper);
      new JsonSlf4jLogger(LoggingLevel.ALL).logEvent("test-event", null);

      assertEquals(1, appender.list.size());
      Map<?, ?> logMap = realMapper.readValue(appender.list.get(0).getFormattedMessage(), Map.class);
      assertEquals("test-event", logMap.get("event"));
      assertTrue(logMap.containsKey("timestamp"));
    }
  }

  @Test
  void logEvent_contextFieldsMergedIntoLogMap() throws Exception {
    try (MockedStatic<ObjectMapperConfiguration> mockMapper = mockStatic(ObjectMapperConfiguration.class)) {
      mockMapper.when(ObjectMapperConfiguration::getObjectMapper).thenReturn(realMapper);
      new JsonSlf4jLogger(LoggingLevel.ALL).logEvent("test-event", Map.of("requestId", "abc-123"));

      assertEquals(1, appender.list.size());
      Map<?, ?> logMap = realMapper.readValue(appender.list.get(0).getFormattedMessage(), Map.class);
      assertEquals("abc-123", logMap.get("requestId"));
    }
  }

  @Test
  void logEvent_nestedJsonStringInContext_isParsedIntoObject() {
    try (MockedStatic<ObjectMapperConfiguration> mockMapper = mockStatic(ObjectMapperConfiguration.class)) {
      mockMapper.when(ObjectMapperConfiguration::getObjectMapper).thenReturn(realMapper);
      new JsonSlf4jLogger(LoggingLevel.ALL).logEvent("test-event", Map.of("body", "{\"amount\":100}"));

      assertEquals(1, appender.list.size());
      assertTrue(appender.list.get(0).getFormattedMessage().contains("\"amount\":100"));
    }
  }

  @Test
  void logEvent_nonJsonStringInContext_returnedAsIs() throws Exception {
    try (MockedStatic<ObjectMapperConfiguration> mockMapper = mockStatic(ObjectMapperConfiguration.class)) {
      mockMapper.when(ObjectMapperConfiguration::getObjectMapper).thenReturn(realMapper);
      new JsonSlf4jLogger(LoggingLevel.ALL).logEvent("test-event", Map.of("body", "not-json-content"));

      assertEquals(1, appender.list.size());
      Map<?, ?> logMap = realMapper.readValue(appender.list.get(0).getFormattedMessage(), Map.class);
      assertEquals("not-json-content", logMap.get("body"));
    }
  }

  @Test
  void logEvent_nullContext_handledGracefully() {
    try (MockedStatic<ObjectMapperConfiguration> mockMapper = mockStatic(ObjectMapperConfiguration.class)) {
      mockMapper.when(ObjectMapperConfiguration::getObjectMapper).thenReturn(realMapper);
      new JsonSlf4jLogger(LoggingLevel.ALL).logEvent("test-event", null);

      assertEquals(1, appender.list.size());
      assertEquals(Level.INFO, appender.list.get(0).getLevel());
    }
  }

  @Test
  void logEvent_nonSerializableContext_fallsBackToToString() {
    try (MockedStatic<ObjectMapperConfiguration> mockMapper = mockStatic(ObjectMapperConfiguration.class)) {
      mockMapper.when(ObjectMapperConfiguration::getObjectMapper).thenReturn(realMapper);
      new JsonSlf4jLogger(LoggingLevel.ALL).logEvent("test-event", 12345);

      assertEquals(1, appender.list.size());
      assertTrue(appender.list.get(0).getFormattedMessage().contains("12345"));
    }
  }

  @Test
  void writeLog_jsonProcessingException_logsWarning() throws Exception {
    try (MockedStatic<ObjectMapperConfiguration> mockMapper = mockStatic(ObjectMapperConfiguration.class)) {
      ObjectMapper spyMapper = spy(realMapper);
      doThrow(new com.fasterxml.jackson.core.JsonProcessingException("error") {})
          .when(spyMapper).writeValueAsString(any());
      mockMapper.when(ObjectMapperConfiguration::getObjectMapper).thenReturn(spyMapper);

      new JsonSlf4jLogger(LoggingLevel.ALL).logEvent("bad-event", null);

      assertEquals(1, appender.list.size());
      assertEquals(Level.WARN, appender.list.get(0).getLevel());
      assertTrue(appender.list.get(0).getFormattedMessage().contains("bad-event"));
    }
  }
}
