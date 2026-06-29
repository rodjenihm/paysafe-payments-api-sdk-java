// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.logging;

import static com.paysafe.payments.config.ObjectMapperConfiguration.getObjectMapper;

import java.time.Instant;
import java.util.LinkedHashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;

public class JsonSlf4jLogger implements SdkLogger {

  private static final Logger logger = LoggerFactory.getLogger("PaysafeSdk");
  private static final TypeReference<LinkedHashMap<String, Object>> MAP_TYPE_REF = new TypeReference<>() {};

  private final LoggingLevel loggingLevel;

  public JsonSlf4jLogger(LoggingLevel loggingLevel) {
    this.loggingLevel = loggingLevel != null ? loggingLevel : LoggingLevel.ERROR;
  }

  @Override
  public <T> void logEvent(String event, T context) {
    if (!LoggingLevel.ALL.equals(loggingLevel)) {
      return;
    }

    writeLog(event, context, null);
  }

  @Override
  public <T> void logError(String event, Throwable error, T context) {
    writeLog(event, context, error);
  }

  private <T> void writeLog(String event, T context, Throwable error) {
    Map<String, Object> logMap = buildLogMap(event, context);

    try {
      String jsonLog = getObjectMapper().writeValueAsString(logMap);
      if (error != null) {
        logger.error(jsonLog, error);
      } else {
        logger.info(jsonLog);
      }
    } catch (JsonProcessingException e) {
      logger.warn("Failed to log JSON event: {}", event, e);
    }
  }

  private <T> Map<String, Object> buildLogMap(String event, T context) {
    Map<String, Object> logMap = new LinkedHashMap<>();
    logMap.put("event", event);
    logMap.put("timestamp", Instant.now().toString());
    mergeContext(logMap, context);

    return logMap;
  }

  private <T> void mergeContext(Map<String, Object> logMap, T context) {
    if (context == null) {
      return;
    }

    try {
      Map<String, Object> fields = getObjectMapper().convertValue(context, MAP_TYPE_REF);
      fields.replaceAll((key, value) -> tryParseJson(value));
      logMap.putAll(fields);
    } catch (IllegalArgumentException e) {
      logMap.put("context", context.toString());
    }
  }

  private Object tryParseJson(Object value) {
    if (value instanceof String) {
      try {
        return getObjectMapper().readTree((String) value);
      } catch (JsonProcessingException e) {
        // non-JSON strings are returned as-is
        return value;
      }
    }

    return value;
  }
}
