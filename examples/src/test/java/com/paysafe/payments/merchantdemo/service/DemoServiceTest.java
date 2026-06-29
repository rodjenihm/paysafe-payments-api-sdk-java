package com.paysafe.payments.merchantdemo.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DemoServiceTest {

    @Test
    void testGetAllTransactionsReturnsEmptyListInitially() {
        DemoService service = new DemoService();
        assertNotNull(service.getAllTransactions());
        assertTrue(service.getAllTransactions().isEmpty());
    }
}

