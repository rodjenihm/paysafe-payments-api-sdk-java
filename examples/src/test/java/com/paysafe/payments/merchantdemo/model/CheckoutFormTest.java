package com.paysafe.payments.merchantdemo.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckoutFormTest {

    @Test
    void testDefaultValues() {
        CheckoutForm form = new CheckoutForm();
        assertEquals("CARD", form.getPaymentMethod());
        assertEquals("10.00", form.getAmount());
        assertNotNull(form.getHolderName());
        assertNotNull(form.getCardNum());
    }

    @Test
    void testSettersAndGetters() {
        CheckoutForm form = new CheckoutForm();
        form.setPaymentMethod("PAYPAL");
        form.setAmount("25.00");
        form.setHolderName("Jane Doe");
        form.setCardNum("4111111111111111");
        form.setExpiry("12/30");
        form.setCvv("456");
        form.setStreet("Main St");
        form.setStreet2("Apt 4");
        form.setCity("London");
        form.setZip("12345");
        form.setState("CA");
        form.setCountry("US");
        form.setCustomerIp("10.0.0.1");

        assertEquals("PAYPAL", form.getPaymentMethod());
        assertEquals("25.00", form.getAmount());
        assertEquals("Jane Doe", form.getHolderName());
        assertEquals("4111111111111111", form.getCardNum());
        assertEquals("12/30", form.getExpiry());
        assertEquals("456", form.getCvv());
        assertEquals("Main St", form.getStreet());
        assertEquals("Apt 4", form.getStreet2());
        assertEquals("London", form.getCity());
        assertEquals("12345", form.getZip());
        assertEquals("CA", form.getState());
        assertEquals("US", form.getCountry());
        assertEquals("10.0.0.1", form.getCustomerIp());
    }

    @Test
    void testExpiryParsing() {
        CheckoutForm form = new CheckoutForm();
        form.setExpiry("03/28");
        assertEquals(3, form.getExpiryMonth());
        assertEquals(2028, form.getExpiryYear());
    }

    @Test
    void testExpiryParsingFourDigitYear() {
        CheckoutForm form = new CheckoutForm();
        form.setExpiry("12/2030");
        assertEquals(12, form.getExpiryMonth());
        assertEquals(2030, form.getExpiryYear());
    }
}

