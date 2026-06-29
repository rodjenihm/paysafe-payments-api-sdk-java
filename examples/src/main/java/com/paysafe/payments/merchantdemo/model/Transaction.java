// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.merchantdemo.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents a payment transaction in the Paysafe demo application.
 * Stores transaction details such as status, payment method, and amounts.
 * Used for displaying and managing transactions in the example UI.
 */
public class Transaction {

    public enum Status {
        PENDING_SETTLEMENT,
        VOIDED,
        SETTLED,
        CANCELLED,
        REFUNDED
    }

    private String id;
    private String paymentId;
    private String voidAuthorizationId;
    private String settlementId;
    private String refundId;
    private String merchantRefNum;
    private int amount;
    private String currencyCode;
    private Status status;
    private String createdAt;
    private String paymentMethod;

    public Transaction() {}

    public Transaction(String id, String paymentId, String merchantRefNum,
                       int amount, String currencyCode) {
        this.id = id;
        this.paymentId = paymentId;
        this.merchantRefNum = merchantRefNum;
        this.amount = amount;
        this.currencyCode = currencyCode;
        this.status = Status.PENDING_SETTLEMENT;
        this.createdAt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    public String getAmountFormatted() {
        return String.format("%s %.2f", currencyCode, amount / 100.0);
    }

    public String getPaymentMethodLabel() {
        if (paymentMethod == null) return "—";
        return switch (paymentMethod) {
            case "CARD"        -> "Card";
            case "PAYSAFECARD" -> "PaysafeCard";
            case "PAYSAFECASH" -> "PaysafeCash";
            case "PAYPAL"      -> "PayPal";
            case "SKRILL"      -> "Skrill";
            default            -> paymentMethod;
        };
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getPaymentId() { return paymentId; }
    public void setPaymentId(String paymentId) { this.paymentId = paymentId; }

    public String getVoidAuthorizationId() { return voidAuthorizationId; }
    public void setVoidAuthorizationId(String voidAuthorizationId) { this.voidAuthorizationId = voidAuthorizationId; }

    public String getSettlementId() { return settlementId; }
    public void setSettlementId(String settlementId) { this.settlementId = settlementId; }

    public String getRefundId() { return refundId; }
    public void setRefundId(String refundId) { this.refundId = refundId; }

    public String getMerchantRefNum() { return merchantRefNum; }
    public void setMerchantRefNum(String merchantRefNum) { this.merchantRefNum = merchantRefNum; }

    public int getAmount() { return amount; }
    public void setAmount(int amount) { this.amount = amount; }

    public String getCurrencyCode() { return currencyCode; }
    public void setCurrencyCode(String currencyCode) { this.currencyCode = currencyCode; }

    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }

    public String getCreatedAt() { return createdAt; }
    public void setCreatedAt(String createdAt) { this.createdAt = createdAt; }

    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }
}
