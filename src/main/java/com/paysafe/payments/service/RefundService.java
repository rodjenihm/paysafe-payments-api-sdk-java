// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

package com.paysafe.payments.service;

import com.paysafe.payments.api.RequestOptions;
import com.paysafe.payments.errorhandling.exception.PaysafeSdkException;
import com.paysafe.payments.model.common.cancel.CancelRequest;
import com.paysafe.payments.model.common.cancel.CancelResponse;
import com.paysafe.payments.model.refund.Refund;
import com.paysafe.payments.model.refund.RefundList;
import com.paysafe.payments.model.refund.RefundRequest;

public interface RefundService {

  /**
   * Process a Refund request:
   * <ul>
   *   <li>A regular Refund.</li>
   *   <li> Refund that is split into multiple merchant accounts.
   *   This is applicable for those merchants whose accounts are configured to do so.</li>
   * </ul>
   * <p>
   * Uses PaysafeClient configuration to execute request.
   *
   * <p>Endpoint:
   * <strong>POST /v1/settlements/{settlementId}/refunds</strong></p>
   *
   * @param settlementId  the ID of the settlement for which the refund is being made
   * @param refundRequest the request body containing the details for the refund
   * @return a {@link Refund} object containing the result of refund processing request
   * @throws PaysafeSdkException if an error occurs with the Payments API
   */
  Refund processRefund(final String settlementId, final RefundRequest refundRequest) throws PaysafeSdkException;

  /**
   * Process a Refund request:
   * <ul>
   *   <li>A regular Refund.</li>
   *   <li> Refund that is split into multiple merchant accounts.
   *   This is applicable for those merchants whose accounts are configured to do so.</li>
   * </ul>
   * <p>
   * The request will be executed using custom RequestOptions (connectTimeout, responseTimeout, maxAutomaticRetries and/or simulator, if applicable),
   * instead of values from PaysafeClient.
   *
   * <p>Endpoint:
   * <strong>POST /v1/settlements/{settlementId}/refunds</strong></p>
   *
   * @param settlementId   the ID of the settlement for which the refund is being made
   * @param refundRequest  the request body containing the details for the refund
   * @param requestOptions custom connectTimeout, responseTimeout, maxAutomaticRetries and/or simulator (if applicable) for this request
   * @return a {@link Refund} object containing the result of refund processing request
   * @throws PaysafeSdkException if an error occurs with the Payments API
   */
  Refund processRefund(final String settlementId, final RefundRequest refundRequest, final RequestOptions requestOptions) throws PaysafeSdkException;

  /**
   * Gets the details of a specific refund by its unique ID. Uses PaysafeClient configuration to execute request.
   *
   * <p>Endpoint:
   * <strong>GET /v1/settlements/{settlementId}/refunds/{refundId}</strong></p>
   *
   * @param refundId the ID of the refund
   * @return a {@link Refund} object representing the response from Paysafe
   * @throws PaysafeSdkException if the request fails or the response cannot be processed
   */
  Refund getRefundById(final String refundId) throws PaysafeSdkException;

  /**
   * Gets the details of a specific refund by its unique ID. The request will be executed using custom RequestOptions
   * (connectTimeout, responseTimeout, maxAutomaticRetries and/or simulator, if applicable), instead of values from PaysafeClient.
   *
   * <p>Endpoint:
   * <strong>GET /v1/settlements/{settlementId}/refunds/{refundId}</strong></p>
   *
   * @param refundId       the ID of the refund
   * @param requestOptions custom connectTimeout, responseTimeout, maxAutomaticRetries and/or simulator (if applicable) for this request
   * @return a {@link Refund} object representing the response from Paysafe
   * @throws PaysafeSdkException if the request fails or the response cannot be processed
   */
  Refund getRefundById(final String refundId, final RequestOptions requestOptions) throws PaysafeSdkException;

  /**
   * Gets the details of a specific refund by its merchant reference number. Uses PaysafeClient configuration to execute request.
   *
   * <p>Endpoint:
   * <strong>GET /v1/settlements/{settlementId}/refunds</strong></p>
   *
   * @param merchantRefNum unique merchant reference number created by the merchant and submitted as part of the refund request
   * @param endDate        the end date in UTC; if null is provided, the current date will be used
   * @param limit          the total number of records to return; if null is provided, the default value (10) will be used
   * @param offset         the starting position, where 0 is the first record; if null is provided, the default value (0) will be used
   * @param startDate      the start date in UTC; if null is provided, the default value (30 days before the end date) will be used
   * @return a RefundList object containing a list of refunds and meta information for pagination
   * @throws PaysafeSdkException if an error occurs during the request
   */
  RefundList getRefundUsingMerchantReferenceNumber(final String merchantRefNum, final String endDate,
      final Integer limit, final Integer offset, final String startDate) throws PaysafeSdkException;

  /**
   * Retrieves refund details using the merchant reference number.
   * The request will be executed using custom RequestOptions
   * (connectTimeout, responseTimeout, and/or automaticRetries) instead of values from PaysafeClient.
   *
   * <p>Endpoint:
   * <strong>POST /v1/settlements/{settlementId}/refunds</strong></p>
   *
   * @param merchantRefNum unique merchant reference number created by the merchant and submitted as part of the refund request
   * @param endDate        the end date in UTC; if null is provided, the current date will be used
   * @param limit          the total number of records to return; if null is provided, the default value (10) will be used
   * @param offset         the starting position, where 0 is the first record; if null is provided, the default value (0) will be used
   * @param startDate      the start date in UTC; if null is provided, the default value (30 days before the end date) will be used
   * @param requestOptions custom connectTimeout, responseTimeout, and/or maxAutomaticRetries for this request
   * @return a RefundList object containing a list of refunds and meta information for pagination
   * @throws PaysafeSdkException if an error occurs during the request
   */
  RefundList getRefundUsingMerchantReferenceNumber(final String merchantRefNum,
      final String endDate, final Integer limit, final Integer offset, final String startDate,
      final RequestOptions requestOptions
  ) throws PaysafeSdkException;

  /**
   * Cancels a specific refund by its unique ID. The request will be executed using custom RequestOptions
   * (connectTimeout, responseTimeout, maxAutomaticRetries and/or simulator, if applicable), instead of values from PaysafeClient. <br> <br>
   * <b>Note</b>: You can cancel a Refund only if the payment type is CARD and the status is PENDING.
   *
   * <p>Endpoint:
   * <strong>PUT /v1/settlements/{settlementId}/refunds/{refundId}</strong></p>
   *
   * @param refundId       the ID of the refund
   * @param cancelRequest  the request body for canceling a Refund
   * @param requestOptions custom connectTimeout, responseTimeout, maxAutomaticRetries and/or simulator (if applicable) for this request
   * @return a {@code CancelResponse} object containing details about the canceled Refund, including the status and transaction time
   * @throws PaysafeSdkException if the request fails or the response cannot be processed
   */
  CancelResponse cancelRefund(final String refundId, final CancelRequest cancelRequest,
      final RequestOptions requestOptions) throws PaysafeSdkException;

  /**
   * Cancels a specific refund by its unique ID. <br> <br>
   * <b>Note</b>: You can cancel a Refund only if the payment type is CARD and the status is PENDING.
   *
   * <p>Endpoint:
   * <strong>PUT /v1/settlements/{settlementId}/refunds/{refundId}</strong></p>
   *
   * @param refundId      the ID of the refund
   * @param cancelRequest the request body for canceling a Refund
   * @return a {@code CancelResponse} object containing details about the canceled Refund, including the status and transaction time
   * @throws PaysafeSdkException if the request fails or the response cannot be processed
   */
  CancelResponse cancelRefund(final String refundId, final CancelRequest cancelRequest) throws PaysafeSdkException;
}
