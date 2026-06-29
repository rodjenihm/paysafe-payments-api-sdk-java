// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.service.impl;

import com.paysafe.payments.api.PaysafeApiClient;
import com.paysafe.payments.api.PaysafeApiResponse;
import com.paysafe.payments.api.RequestOptions;
import com.paysafe.payments.errorhandling.exception.PaysafeSdkException;
import com.paysafe.payments.model.common.Mandate;
import com.paysafe.payments.service.MandateService;

public class MandateServiceImpl implements MandateService {

  public static final String MANDATES_ENDPOINT = "/v1/customers/%s/paymenthandles/%s/mandates";
  public static final String MANDATE_BY_ID_ENDPOINT = "/v1/customers/%s/paymenthandles/%s/mandates/%s";

  private final PaysafeApiClient paysafeApiClient;

  public MandateServiceImpl(final PaysafeApiClient paysafeApiClient) {
    this.paysafeApiClient = paysafeApiClient;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Mandate createMandate(final String customerId, final String paymentHandleId, final Object requestBody,
      final RequestOptions requestOptions) throws PaysafeSdkException {

    final String path = String.format(MANDATES_ENDPOINT, customerId, paymentHandleId);
    PaysafeApiResponse response = paysafeApiClient.executePost(path, requestBody, requestOptions);
    return paysafeApiClient.processResponse(response, Mandate.class);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Mandate getMandateStatus(final String customerId, final String paymentHandleId, final String mandateId,
      final RequestOptions requestOptions) throws PaysafeSdkException {

    final String path = String.format(MANDATE_BY_ID_ENDPOINT, customerId, paymentHandleId, mandateId);
    PaysafeApiResponse response = paysafeApiClient.executeGet(path, requestOptions);
    return paysafeApiClient.processResponse(response, Mandate.class);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Mandate cancelMandate(final String customerId, final String paymentHandleId, final String mandateId,
      final Object requestBody, final RequestOptions requestOptions) throws PaysafeSdkException {

    final String path = String.format(MANDATE_BY_ID_ENDPOINT, customerId, paymentHandleId, mandateId);
    PaysafeApiResponse response = paysafeApiClient.executePut(path, requestBody, requestOptions);
    return paysafeApiClient.processResponse(response, Mandate.class);
  }
}