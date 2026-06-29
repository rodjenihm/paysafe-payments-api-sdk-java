// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.webhookhandler.model;

import java.time.OffsetDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.paysafe.payments.webhookhandler.RawJsonDeserializer;

/**
 * Represents a webhook event received from Paysafe. Contains details about the event.
 */
public class WebhookEvent {

  @JsonProperty("payload")
  @JsonDeserialize(using = RawJsonDeserializer.class)
  private String payload;
  @JsonProperty("attemptNumber")
  private int attemptNumber;
  @JsonProperty("type")
  private String type;
  @JsonProperty("resourceId")
  private String resourceId;
  @JsonProperty("eventDate")
  private OffsetDateTime eventDate;
  @JsonProperty("eventName")
  private String eventName;

  public WebhookEvent() {
    // Default constructor for JSON deserialization
  }

  /**
   * The webhook payload. This contains details about the transaction or other relevant information related to the event.
   *
   * @return the payload
   */
  public String getPayload() {
    return payload;
  }

  /**
   * The number of attempts made to deliver this webhook event. This can be useful for tracking retries in case of delivery failures.
   *
   * @return the attempt number
   */
  public int getAttemptNumber() {
    return attemptNumber;
  }

  /**
   * The type of the webhook event. This indicates the category or nature of the event, such as "PAYMENT_HANDLE" or "REFUND".
   *
   * @return the event type
   */
  public String getType() {
    return type;
  }

  /**
   * The ID of the resource associated with this webhook event. This could be an identifier for a payment, refund, or other relevant entity.
   *
   * @return the resource ID
   */
  public String getResourceId() {
    return resourceId;
  }

  /**
   * The date and time when the event occurred.
   *
   * @return the event date
   */
  public OffsetDateTime getEventDate() {
    return eventDate;
  }

  /**
   * The name of the event, which provides a more specific description of the event type, such as "PAYMENT_HANDLE_COMPLETED".
   *
   * @return the event name
   */
  public String getEventName() {
    return eventName;
  }

  @Override
  public String toString() {
    return "WebhookEvent{" +
        "payload='" + payload + '\'' +
        ", attemptNumber=" + attemptNumber +
        ", type='" + type + '\'' +
        ", resourceId='" + resourceId + '\'' +
        ", eventDate=" + eventDate +
        ", eventName='" + eventName + '\'' +
        '}';
  }

  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WebhookEvent that = (WebhookEvent) o;
    return attemptNumber == that.attemptNumber &&
        Objects.equals(payload, that.payload) &&
        Objects.equals(type, that.type) &&
        Objects.equals(resourceId, that.resourceId) &&
        Objects.equals(eventDate, that.eventDate) &&
        Objects.equals(eventName, that.eventName);
  }

  @Override public int hashCode() {
    return Objects.hash(payload, attemptNumber, type, resourceId, eventDate, eventName);
  }
}
