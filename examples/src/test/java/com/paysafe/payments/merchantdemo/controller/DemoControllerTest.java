package com.paysafe.payments.merchantdemo.controller;

import com.paysafe.payments.merchantdemo.service.DemoService;
import jakarta.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DemoControllerTest {

    @Mock
    private DemoService demoService;
    @Mock
    private Model model;
    @Mock
    private RedirectAttributes redirectAttributes;
    @Mock
    private HttpServletRequest request;

    @InjectMocks
    private DemoController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testHomeReturnsIndex() {
        when(demoService.getAllTransactions()).thenReturn(java.util.List.of());
        String view = controller.home(model);
        assertEquals("index", view);
    }

    @Test
    void testCheckoutHandlesNullForm() {
        when(request.getRemoteAddr()).thenReturn("127.0.0.1");
        String result = controller.checkout(null, request, redirectAttributes);
        assertEquals("redirect:/", result);
    }

    @Test
    void testHandle3dsReturn() {
        String result = controller.handle3dsReturn("some-merchant-ref", redirectAttributes);
        assertEquals("redirect:/", result);
    }

    @Test
    void testHandleRedirectReturn() {
        String result = controller.handleRedirectReturn("some-merchant-ref", redirectAttributes);
        assertEquals("redirect:/", result);
    }

    @Test
    void testVoidAuth() {
        String result = controller.voidAuth("txid", redirectAttributes);
        assertEquals("redirect:/", result);
    }

    @Test
    void testSettle() {
        String result = controller.settle("txid", redirectAttributes);
        assertEquals("redirect:/", result);
    }

    @Test
    void testCancel() {
        String result = controller.cancel("txid", redirectAttributes);
        assertEquals("redirect:/", result);
    }

    @Test
    void testRefund() {
        String result = controller.refund("txid", null, redirectAttributes);
        assertEquals("redirect:/", result);
    }
}
