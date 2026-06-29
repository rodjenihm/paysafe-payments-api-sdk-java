// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.logging;

public interface SdkLogger {

  <T> void logEvent(String event, T context);
  <T> void logError(String event, Throwable error, T context);
}
