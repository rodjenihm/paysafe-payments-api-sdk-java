package com.paysafe.payments.merchantdemo.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransactionTest {

    @Test
    void testDefaultConstructor() {
        Transaction tx = new Transaction();
        assertNotNull(tx);
        assertNull(tx.getStatus());
    }

    @Test
    void testFullConstructor() {
        Transaction tx = new Transaction("id1", "pid1", "ref1", 1000, "USD");
        assertEquals("id1", tx.getId());
        assertEquals("pid1", tx.getPaymentId());
        assertEquals("ref1", tx.getMerchantRefNum());
        assertEquals(1000, tx.getAmount());
        assertEquals("USD", tx.getCurrencyCode());
        assertEquals(Transaction.Status.PENDING_SETTLEMENT, tx.getStatus());
        assertNotNull(tx.getCreatedAt());
    }

    @Test
    void testSettersAndGetters() {
        Transaction tx = new Transaction();
        tx.setId("id2");
        tx.setPaymentId("pid2");
        tx.setVoidAuthorizationId("void2");
        tx.setSettlementId("settle2");
        tx.setRefundId("refund2");
        tx.setMerchantRefNum("ref2");
        tx.setAmount(2000);
        tx.setCurrencyCode("CAD");
        tx.setStatus(Transaction.Status.SETTLED);
        tx.setCreatedAt("2026-05-15 12:00:00");
        tx.setPaymentMethod("CARD");

        assertEquals("id2", tx.getId());
        assertEquals("pid2", tx.getPaymentId());
        assertEquals("void2", tx.getVoidAuthorizationId());
        assertEquals("settle2", tx.getSettlementId());
        assertEquals("refund2", tx.getRefundId());
        assertEquals("ref2", tx.getMerchantRefNum());
        assertEquals(2000, tx.getAmount());
        assertEquals("CAD", tx.getCurrencyCode());
        assertEquals(Transaction.Status.SETTLED, tx.getStatus());
        assertEquals("2026-05-15 12:00:00", tx.getCreatedAt());
        assertEquals("CARD", tx.getPaymentMethod());
    }

    @Test
    void testAmountFormatted() {
        Transaction tx = new Transaction("id3", "pid3", "ref3", 1234, "USD");
        assertEquals("USD 12.34", tx.getAmountFormatted());
    }

    @Test
    void testPaymentMethodLabel() {
        Transaction tx = new Transaction();

        tx.setPaymentMethod("CARD");
        assertEquals("Card", tx.getPaymentMethodLabel());

        tx.setPaymentMethod("PAYSAFECARD");
        assertEquals("PaysafeCard", tx.getPaymentMethodLabel());

        tx.setPaymentMethod("PAYSAFECASH");
        assertEquals("PaysafeCash", tx.getPaymentMethodLabel());

        tx.setPaymentMethod("PAYPAL");
        assertEquals("PayPal", tx.getPaymentMethodLabel());

        tx.setPaymentMethod(null);
        assertEquals("—", tx.getPaymentMethodLabel());
    }
}

