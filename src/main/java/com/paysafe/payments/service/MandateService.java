// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.service;

import com.paysafe.payments.api.RequestOptions;
import com.paysafe.payments.errorhandling.exception.PaysafeSdkException;
import com.paysafe.payments.model.common.Mandate;

public interface MandateService {

  /**
   * <p>Create a Mandate for a Customer.</p>
   *
   * <p>Endpoint:
   * <strong>POST /v1/customers/{customerId}/paymenthandles/{paymentHandleId}/mandates</strong></p>
   *
   * @param customerId      the ID of the customer
   * @param paymentHandleId the Payment Handle ID returned in the response to the Customer Payment Handle creation request
   * @param requestBody     containing the mandate reference (required)
   * @param requestOptions  RequestOptions including simulator, timeouts, and retries
   * @return Mandate containing the created mandate details
   * @throws PaysafeSdkException if an error occurs
   */
  Mandate createMandate(String customerId, String paymentHandleId, Object requestBody, RequestOptions requestOptions) throws PaysafeSdkException;

  /**
   * <p>Look up the status of a Mandate.</p>
   *
   * <p>Endpoint:
   * <strong>GET /v1/customers/{customerId}/paymenthandles/{paymentHandleId}/mandates/{mandateId}</strong></p>
   *
   * @param customerId      the ID of the customer
   * @param paymentHandleId the Payment Handle ID
   * @param mandateId       the Mandate ID returned in the response to the Create Mandate request
   * @param requestOptions  RequestOptions including simulator, timeouts, and retries
   * @return Mandate containing the mandate details and status
   * @throws PaysafeSdkException if an error occurs
   */
  Mandate getMandateStatus(String customerId, String paymentHandleId, String mandateId, RequestOptions requestOptions) throws PaysafeSdkException;

  /**
   * <p>Cancel a Mandate.</p>
   *
   * <p>Endpoint:
   * <strong>PUT /v1/customers/{customerId}/paymenthandles/{paymentHandleId}/mandates/{mandateId}</strong></p>
   *
   * @param customerId      the ID of the customer
   * @param paymentHandleId the Payment Handle ID
   * @param mandateId       the Mandate ID returned in the response to the Create Mandate request
   * @param requestBody     containing the status set to CANCELLED
   * @param requestOptions  RequestOptions including simulator, timeouts, and retries
   * @return Mandate containing the cancelled mandate details with status CANCELLED and statusReason MERCHANT_CANCELLED
   * @throws PaysafeSdkException if an error occurs
   */
  Mandate cancelMandate(String customerId, String paymentHandleId, String mandateId, Object requestBody, RequestOptions requestOptions)
      throws PaysafeSdkException;
}
