// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.merchantdemo.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.paysafe.payments.PaysafeClient;
import com.paysafe.payments.errorhandling.exception.PaysafeSdkException;
import com.paysafe.payments.merchantdemo.model.CheckoutForm;
import com.paysafe.payments.merchantdemo.model.Transaction;
import com.paysafe.payments.model.card.Card;
import com.paysafe.payments.model.card.CardAuthentication;
import com.paysafe.payments.model.card.CardExpiry;
import com.paysafe.payments.model.card.MerchantDescriptor;
import com.paysafe.payments.model.card.enums.ThreeDsAuthenticationPurpose;
import com.paysafe.payments.model.card.enums.ThreeDsDeviceChannel;
import com.paysafe.payments.model.card.enums.ThreeDsMessageCategory;
import com.paysafe.payments.model.card.enums.ThreeDsRequestorChallengePreference;
import com.paysafe.payments.model.card.threeds.ThreeDs;
import com.paysafe.payments.model.common.BillingDetails;
import com.paysafe.payments.model.common.Link;
import com.paysafe.payments.model.common.ReturnLink;
import com.paysafe.payments.model.common.cancel.CancelRequest;
import com.paysafe.payments.model.common.enums.CurrencyCode;
import com.paysafe.payments.model.common.enums.HttpMethod;
import com.paysafe.payments.model.common.enums.TransactionRequestStatus;
import com.paysafe.payments.model.common.error.Error;
import com.paysafe.payments.model.lpm.Paypal;
import com.paysafe.payments.model.lpm.Paysafecard;
import com.paysafe.payments.model.lpm.Paysafecash;
import com.paysafe.payments.model.lpm.Skrill;
import com.paysafe.payments.model.lpm.enums.KeyLevelRestriction;
import com.paysafe.payments.model.lpm.enums.PaypalShippingReference;
import com.paysafe.payments.model.payment.Payment;
import com.paysafe.payments.model.paymenthandle.PaymentHandle;
import com.paysafe.payments.model.paymenthandle.PaymentHandleRequest;
import com.paysafe.payments.model.payment.PaymentRequest;
import com.paysafe.payments.model.paymenthandle.enums.Action;
import com.paysafe.payments.model.paymenthandle.enums.PaymentHandleStatus;
import com.paysafe.payments.model.paymenthandle.enums.PaymentType;
import com.paysafe.payments.model.paymenthandle.enums.ReturnLinkRel;
import com.paysafe.payments.model.paymenthandle.enums.TransactionType;
import com.paysafe.payments.model.refund.Refund;
import com.paysafe.payments.model.refund.RefundRequest;
import com.paysafe.payments.model.settlement.Settlement;
import com.paysafe.payments.model.settlement.SettlementRequest;
import com.paysafe.payments.model.voidauthorization.VoidAuthorization;
import com.paysafe.payments.model.voidauthorization.VoidAuthorizationRequest;

/**
 * Service layer for handling payment operations and transaction state in the Paysafe demo.
 * Encapsulates business logic for creating, processing, and managing payments.
 */
@Service
public class DemoService {

  @Autowired
  private PaysafeClient paysafeClient;

  @Value("${paysafe.accountId}")
  private String accountId;

  @Value("${paysafe.returnUrlBase:http://localhost:8881}")
  private String returnUrlBase;

  private final Map<String, Transaction> transactions = new ConcurrentHashMap<>();

  private static final String MERCHANT_CLIENT_ID = "merchantclientid";

  /**
   * Holds the result of creating a payment handle: the merchantRefNum (used to look up the handle
   * on the return URL) and the optional redirect URL (null if no redirect needed).
   */
  public record PaymentHandleResult(String merchantRef, String redirectUrl) {}

  /**
   * Create a CARD Payment Handle with 3DS. Returns a result with redirect URL (null if no redirect needed).
   */
  public PaymentHandleResult createPaymentHandleWith3ds(CheckoutForm form) throws PaysafeSdkException {
    int amountCents = parseDollarsToCents(form.getAmount());
    String merchantRef = UUID.randomUUID().toString();

    PaymentHandleRequest request = PaymentHandleRequest.builder()
        .accountId(accountId)
        .merchantRefNum(merchantRef)
        .transactionType(TransactionType.PAYMENT)
        .amount(amountCents)
        .currencyCode(CurrencyCode.USD)
        .paymentType(PaymentType.CARD)
        .card(Card.builder()
            .holderName(form.getHolderName())
            .cardNum(form.getCardNum())
            .cardExpiry(CardExpiry.builder()
                .month(form.getExpiryMonth())
                .year(form.getExpiryYear())
                .build())
            .cvv(form.getCvv())
            .build())
        .returnLinks(buildReturnLinks(returnUrlBase + "/3ds/return/" + merchantRef))
        .billingDetails(buildBillingDetails(form))
        .threeDs(ThreeDs.builder()
            .merchantUrl(returnUrlBase)
            .authenticationPurpose(ThreeDsAuthenticationPurpose.PAYMENT_TRANSACTION)
            .deviceChannel(ThreeDsDeviceChannel.BROWSER)
            .requestorChallengePreference(ThreeDsRequestorChallengePreference.CHALLENGE_MANDATED)
            .messageCategory(ThreeDsMessageCategory.PAYMENT)
            .build())
        .build();

    PaymentHandle handle = paysafeClient.paymentHandleService().createPaymentHandle(request);
    return new PaymentHandleResult(merchantRef, extractRedirectUrl(handle));
  }

  /**
   * Create a Payment Handle for PaysafeCard, PaysafeCash, PayPal, or Skrill. Returns a result with redirect URL.
   */
  public PaymentHandleResult createRedirectPaymentHandle(CheckoutForm form, String paymentMethod) throws PaysafeSdkException {
    int amountCents = parseDollarsToCents(form.getAmount());
    String merchantRef = UUID.randomUUID().toString();

    PaymentType paymentType = switch (paymentMethod) {
      case "PAYSAFECARD" -> PaymentType.PAYSAFECARD;
      case "PAYSAFECASH" -> PaymentType.PAYSAFECASH;
      case "PAYPAL"      -> PaymentType.PAYPAL;
      case "SKRILL"      -> PaymentType.SKRILL;
      default -> throw new IllegalArgumentException("Unsupported payment method: " + paymentMethod);
    };

    PaymentHandleRequest.Builder builder = PaymentHandleRequest.builder()
        .merchantRefNum(merchantRef)
        .transactionType(TransactionType.PAYMENT)
        .amount(amountCents)
        .currencyCode(CurrencyCode.USD)
        .paymentType(paymentType)
        .customerIp(form.getCustomerIp() != null ? form.getCustomerIp() : "127.0.0.1")
        .returnLinks(buildReturnLinks(returnUrlBase + "/redirect/return/" + merchantRef))
        .billingDetails(buildBillingDetails(form))
        .merchantDescriptor(MerchantDescriptor.builder()
            .dynamicDescriptor("OnlineStore")
            .phone("12345678")
            .build());

    switch (paymentMethod) {
      case "PAYSAFECARD" -> builder.paysafecard(Paysafecard.builder()
          .consumerId(MERCHANT_CLIENT_ID)
          .minAgeRestriction(18)
          .kycLevelRestriction(KeyLevelRestriction.SIMPLE)
          .countryRestriction("DE")
          .build());
      case "PAYSAFECASH" -> builder.paysafecash(Paysafecash.builder()
          .consumerId(MERCHANT_CLIENT_ID)
          .minAgeRestriction(18)
          .kycLevelRestriction(KeyLevelRestriction.SIMPLE)
          .countryRestriction("DE")
          .build());
      case "PAYPAL" -> builder.payPal(Paypal.builder()
          .consumerId(form.getPaypalEmail() != null && !form.getPaypalEmail().isBlank() ? form.getPaypalEmail() : null)
          .shippingPreference(PaypalShippingReference.NO_SHIPPING)
          .build());
      case "SKRILL" -> builder.skrill(Skrill.builder()
          .consumerId(form.getSkrillId() != null && !form.getSkrillId().isBlank() ? form.getSkrillId() : null)
          .build());
    }

    PaymentHandle handle = paysafeClient.paymentHandleService().createPaymentHandle(builder.build());

    return new PaymentHandleResult(merchantRef, extractRedirectUrl(handle));
  }

  /**
   * Complete a payment using the merchantRefNum from the return URL.
   * All required data is fetched from the API - no session required.
   */
  public Transaction completePendingHandle(String merchantRef) throws PaysafeSdkException {
    PaymentHandle handle = fetchAndVerifyHandle(merchantRef);

    String paymentType = handle.getPaymentType() != null ? handle.getPaymentType().name() : "CARD";
    boolean settleWithAuth = !"CARD".equals(paymentType);

    PaymentRequest request = PaymentRequest.builder()
        .merchantRefNum(handle.getMerchantRefNum())
        .amount(handle.getAmount())
        .currencyCode(CurrencyCode.USD)
        .paymentHandleToken(handle.getPaymentHandleToken())
        .settleWithAuth(settleWithAuth)
        .build();

    try {
      Payment payment = paysafeClient.paymentService().processPayment(request);

      Transaction tx = new Transaction(UUID.randomUUID().toString(), payment.getId(), handle.getMerchantRefNum(), handle.getAmount(), "USD");
      tx.setPaymentMethod(paymentType);
      tx.setStatus(settleWithAuth ? Transaction.Status.SETTLED : Transaction.Status.PENDING_SETTLEMENT);
      if (payment.getSettlements() != null && !payment.getSettlements().isEmpty()) {
        tx.setSettlementId(payment.getSettlements().get(0).getId());
      }
      transactions.put(tx.getId(), tx);
      return tx;
    } catch (NullPointerException npe) {
      throw new IllegalStateException(
          "Payment failed. The account may not be configured correctly for this payment method.");
    }
  }

  /**
   * Void a CARD authorization before settlement.
   */
  public Transaction voidAuthorization(String txId) throws PaysafeSdkException {
    Transaction tx = getTransactionById(txId);

    VoidAuthorizationRequest voidRequest = VoidAuthorizationRequest.builder()
        .merchantRefNum(tx.getMerchantRefNum())
        .amount(tx.getAmount())
        .build();

    VoidAuthorization voidAuth = paysafeClient.voidAuthorizationService()
        .voidAuthorization(tx.getPaymentId(), voidRequest);

    tx.setVoidAuthorizationId(voidAuth.getId());
    tx.setStatus(Transaction.Status.VOIDED);
    return tx;
  }

  /**
   * Manually settle a previously authorized CARD payment.
   */
  public Transaction settle(String txId) throws PaysafeSdkException {
    Transaction tx = getTransactionById(txId);

    SettlementRequest settlementRequest = SettlementRequest.builder()
        .merchantRefNum(tx.getMerchantRefNum())
        .amount(tx.getAmount())
        .build();

    Settlement settlement = paysafeClient.settlementService()
        .processSettlement(tx.getPaymentId(), settlementRequest);

    tx.setSettlementId(settlement.getId());
    tx.setStatus(Transaction.Status.SETTLED);
    return tx;
  }

  /**
   * Cancel (void) a pending settlement.
   */
  public void cancelSettlement(String txId) throws PaysafeSdkException {
    Transaction tx = getTransactionById(txId);

    CancelRequest cancelRequest = CancelRequest.builder()
        .status(TransactionRequestStatus.CANCELLED)
        .build();

    paysafeClient.settlementService().cancelSettlement(tx.getSettlementId(), cancelRequest);

    tx.setStatus(Transaction.Status.CANCELLED);
  }

  /**
   * Refund a settled payment. customerAccountId is required for PaysafeCard / PaysafeCash.
   */
  public Transaction refund(String txId, String customerAccountId) throws PaysafeSdkException {
    Transaction tx = getTransactionById(txId);

    RefundRequest refundRequest = RefundRequest.builder()
        .merchantRefNum(tx.getMerchantRefNum())
        .amount(tx.getAmount())
        .build();

    if (customerAccountId != null && !customerAccountId.isBlank()) {
      refundRequest.setCustomerAccountId(customerAccountId);
    }

    Refund refund = paysafeClient.refundService()
        .processRefund(tx.getSettlementId(), refundRequest);

    tx.setRefundId(refund.getId());
    tx.setStatus(Transaction.Status.REFUNDED);
    return tx;
  }

  /**
   * Retrieve all transactions, sorted by creation date descending.
   */
  public List<Transaction> getAllTransactions() {
    List<Transaction> list = new ArrayList<>(transactions.values());
    list.sort((a, b) -> b.getCreatedAt().compareTo(a.getCreatedAt()));
    return list;
  }

  /**
   * Fetches the payment handle by merchantRefNum and verifies it is PAYABLE or COMPLETED.
   * Since Paysafe only redirects the customer back after payment is finalised,
   * a single fetch is sufficient for both CARD (3DS) and APM flows.
   */
  private PaymentHandle fetchAndVerifyHandle(String merchantRef) throws PaysafeSdkException {
    PaymentHandle handle = fetchHandleByMerchantRef(merchantRef);
    checkHandlePayable(handle);
    return handle;
  }

  private PaymentHandle fetchHandleByMerchantRef(String merchantRef) throws PaysafeSdkException {
    var list = paysafeClient.paymentHandleService()
        .getPaymentHandleUsingMerchantReferenceNumber(merchantRef, null, 1, null, null);
    if (list == null || list.getPaymentHandles() == null || list.getPaymentHandles().isEmpty()) {
      throw new IllegalStateException("No payment handle found for merchantRefNum: " + merchantRef);
    }
    return list.getPaymentHandles().get(0);
  }

  private void checkHandlePayable(PaymentHandle handle) {
    PaymentHandleStatus status = handle.getStatus();
    if (PaymentHandleStatus.PAYABLE.equals(status) || PaymentHandleStatus.COMPLETED.equals(status)) {
      return;
    }
    StringBuilder msg = new StringBuilder("Payment handle is not payable. Status: ").append(status);

    Optional<Error> error = Optional.ofNullable(handle.getError())
        .or(() -> Optional.ofNullable(handle.getAuthentication())
            .map(CardAuthentication::getError));

    if (error.isPresent()) {
      Optional.ofNullable(error.get().getCode())
          .ifPresent(code -> msg.append("\nError Code: ").append(code));
      Optional.ofNullable(error.get().getMessage())
          .ifPresent(message -> msg.append("\nError Message: ").append(message));
      Optional.ofNullable(error.get().getDetails())
          .ifPresent(details -> details.forEach(d -> msg.append("\nDetail: ").append(d)));
    }
    throw new IllegalStateException(msg.toString());
  }

  private String extractRedirectUrl(PaymentHandle handle) {
    if (!Action.REDIRECT.equals(handle.getAction()) || handle.getLinks() == null) {
      return null;
    }
    return handle.getLinks().stream()
        .filter(l -> ReturnLinkRel.REDIRECT_PAYMENT.equals(l.getRel()))
        .findFirst()
        .or(() -> handle.getLinks().stream()
            .filter(l -> ReturnLinkRel.DEFAULT.equals(l.getRel()))
            .findFirst())
        .map(Link::getHref)
        .orElse(null);
  }

  private List<ReturnLink> buildReturnLinks(String url) {
    return List.of(
        ReturnLink.builder().href(url).method(HttpMethod.GET).rel(ReturnLinkRel.DEFAULT).build(),
        ReturnLink.builder().href(url).method(HttpMethod.GET).rel(ReturnLinkRel.ON_COMPLETED).build(),
        ReturnLink.builder().href(url).method(HttpMethod.GET).rel(ReturnLinkRel.ON_FAILED).build()
    );
  }

  private BillingDetails buildBillingDetails(CheckoutForm form) {
    BillingDetails.Builder builder = BillingDetails.builder()
        .street(form.getStreet())
        .city(form.getCity())
        .country(form.getCountry())
        .zip(form.getZip());
    if (form.getStreet2() != null && !form.getStreet2().isBlank()) {
      builder.street2(form.getStreet2());
    }
    if (form.getState() != null && !form.getState().isBlank()) {
      builder.state(form.getState());
    }
    return builder.build();
  }

  private Transaction getTransactionById(String txId) {
    Transaction tx = transactions.get(txId);
    if (tx == null) throw new IllegalArgumentException("Transaction not found: " + txId);
    return tx;
  }

  private int parseDollarsToCents(String dollars) {
    try {
      return new BigDecimal(dollars.trim()).multiply(BigDecimal.valueOf(100)).intValue();
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("Invalid amount: " + dollars);
    }
  }
}
