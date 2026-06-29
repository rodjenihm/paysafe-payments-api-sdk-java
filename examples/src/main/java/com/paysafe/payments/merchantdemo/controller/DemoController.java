// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.merchantdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpServletRequest;

import com.paysafe.payments.errorhandling.exception.PaysafeSdkException;
import com.paysafe.payments.merchantdemo.model.CheckoutForm;
import com.paysafe.payments.merchantdemo.model.Transaction;
import com.paysafe.payments.merchantdemo.service.DemoService;


/**
 * Spring MVC controller for handling web requests in the Paysafe demo application.
 * Maps HTTP endpoints to payment and transaction operations.
 */
@Controller
public class DemoController {

  private final DemoService demoService;

  public DemoController(DemoService demoService) {
    this.demoService = demoService;
  }

  private static final String REDIRECT_HOME = "redirect:/";
  private static final String SUCCESS_PAYMENT_AUTH = "Payment authorized! Transaction ID: %s | Paysafe Payment ID: %s";
  private static final String SUCCESS_3DS = "3DS payment completed! Transaction ID: %s | Paysafe Payment ID: %s";
  private static final String SUCCESS_PAYMENT = "Payment completed! Transaction ID: %s | Paysafe Payment ID: %s";
  private static final String SUCCESS_VOID = "Authorization voided! Void ID: %s";
  private static final String SUCCESS_SETTLE = "Settlement successful! Settlement ID: %s";
  private static final String SUCCESS_CANCEL = "Transaction cancelled successfully.";
  private static final String SUCCESS_REFUND = "Refund issued! Refund ID: %s";
  private static final String ERROR_PAYMENT_FAILED = "Payment failed";
  private static final String ERROR_VOID_FAILED = "Void failed";
  private static final String ERROR_3DS_FAILED = "3DS payment failed";
  private static final String ERROR_REDIRECT_FAILED  = "Redirect payment failed";
  private static final String ERROR_SETTLEMENT_FAILED = "Settlement failed";
  private static final String ERROR_CANCEL_FAILED = "Cancellation failed";
  private static final String ERROR_REFUND_FAILED = "Refund failed";
  private static final String ATTR_SUCCESS_MESSAGE = "successMessage";
  private static final String ATTR_ERROR_MESSAGE = "errorMessage";

  /**
   * Ensures a CheckoutForm is always available in the model,
   * even on redirect-return endpoints that render the index template.
   */
  @ModelAttribute("form")
  public CheckoutForm defaultForm() {
    return new CheckoutForm();
  }

  @GetMapping("/")
  public String home(Model model) {
    model.addAttribute("transactions", demoService.getAllTransactions());
    return "index";
  }

  @PostMapping("/checkout")
  public String checkout(@ModelAttribute CheckoutForm form, HttpServletRequest request, RedirectAttributes redirectAttributes) {
    if (form == null) {
      redirectAttributes.addFlashAttribute(ATTR_ERROR_MESSAGE, ERROR_PAYMENT_FAILED);
      return REDIRECT_HOME;
    }

    // Resolve client IP from request (supports X-Forwarded-For for proxied requests)
    String clientIp = request.getHeader("X-Forwarded-For");
    if (clientIp == null || clientIp.isBlank()) {
      clientIp = request.getRemoteAddr();
    } else {
      // X-Forwarded-For may contain multiple IPs; take the first (original client)
      clientIp = clientIp.split(",")[0].trim();
    }
    form.setCustomerIp(clientIp);

    try {
      String paymentMethod = form.getPaymentMethod();
      DemoService.PaymentHandleResult result;
      if ("CARD".equals(paymentMethod)) {
        result = demoService.createPaymentHandleWith3ds(form);
      } else {
        result = demoService.createRedirectPaymentHandle(form, paymentMethod);
      }

      if (result.redirectUrl() != null) {
        return "redirect:" + result.redirectUrl();
      }

      Transaction tx = demoService.completePendingHandle(result.merchantRef());
      redirectAttributes.addFlashAttribute(ATTR_SUCCESS_MESSAGE,
          String.format(SUCCESS_PAYMENT_AUTH, tx.getId(), tx.getPaymentId()));

    } catch (PaysafeSdkException e) {
      redirectAttributes.addFlashAttribute(ATTR_ERROR_MESSAGE, buildErrorMessage(ERROR_PAYMENT_FAILED, e));
    } catch (NullPointerException e) {
      redirectAttributes.addFlashAttribute(ATTR_ERROR_MESSAGE,
          ERROR_PAYMENT_FAILED + ": The API returned an error that the SDK cannot parse. "
              + "This usually means the account is not configured for this payment method.");
    } catch (Exception e) {
      redirectAttributes.addFlashAttribute(ATTR_ERROR_MESSAGE, buildErrorMessage(ERROR_PAYMENT_FAILED, e));
    }
    return REDIRECT_HOME;
  }

  /**
   * Return endpoint after a 3DS challenge.
   */
  @GetMapping("/3ds/return/{ref}")
  public String handle3dsReturn(@PathVariable String ref, RedirectAttributes redirectAttributes) {
    return completeRedirectPayment(SUCCESS_3DS, ERROR_3DS_FAILED, ref, redirectAttributes);
  }

  /**
   * Return endpoint after a PaysafeCard / PaysafeCash / PayPal redirect.
   */
  @GetMapping("/redirect/return/{ref}")
  public String handleRedirectReturn(@PathVariable String ref, RedirectAttributes redirectAttributes) {
    return completeRedirectPayment(SUCCESS_PAYMENT, ERROR_REDIRECT_FAILED, ref, redirectAttributes);
  }

  private String completeRedirectPayment(String successMsg, String errorPrefix, String merchantRef, RedirectAttributes redirectAttributes) {
    try {
      Transaction tx = demoService.completePendingHandle(merchantRef);
      redirectAttributes.addFlashAttribute(ATTR_SUCCESS_MESSAGE,
          String.format(successMsg, tx.getId(), tx.getPaymentId()));
    } catch (PaysafeSdkException e) {
      redirectAttributes.addFlashAttribute(ATTR_ERROR_MESSAGE, buildErrorMessage(errorPrefix, e));
    } catch (Exception e) {
      redirectAttributes.addFlashAttribute(ATTR_ERROR_MESSAGE, errorPrefix + ": " + e.getMessage());
    }
    return REDIRECT_HOME;
  }

  @PostMapping("/void/{txId}")
  public String voidAuth(@PathVariable String txId, RedirectAttributes redirectAttributes) {
    try {
      Transaction tx = demoService.voidAuthorization(txId);
      redirectAttributes.addFlashAttribute(ATTR_SUCCESS_MESSAGE,
          String.format(SUCCESS_VOID, tx.getVoidAuthorizationId()));
    } catch (PaysafeSdkException e) {
      redirectAttributes.addFlashAttribute(ATTR_ERROR_MESSAGE, buildErrorMessage(ERROR_VOID_FAILED, e));
    } catch (Exception e) {
      redirectAttributes.addFlashAttribute(ATTR_ERROR_MESSAGE, buildErrorMessage(ERROR_VOID_FAILED, e));
    }
    return REDIRECT_HOME;
  }

  @PostMapping("/settle/{txId}")
  public String settle(@PathVariable String txId, RedirectAttributes redirectAttributes) {
    try {
      Transaction tx = demoService.settle(txId);
      redirectAttributes.addFlashAttribute(ATTR_SUCCESS_MESSAGE,
          String.format(SUCCESS_SETTLE, tx.getSettlementId()));
    } catch (PaysafeSdkException e) {
      redirectAttributes.addFlashAttribute(ATTR_ERROR_MESSAGE, buildErrorMessage(ERROR_SETTLEMENT_FAILED, e));
    } catch (Exception e) {
      redirectAttributes.addFlashAttribute(ATTR_ERROR_MESSAGE, buildErrorMessage(ERROR_SETTLEMENT_FAILED, e));
    }
    return REDIRECT_HOME;
  }

  @PostMapping("/cancel/{txId}")
  public String cancel(@PathVariable String txId, RedirectAttributes redirectAttributes) {
    try {
      demoService.cancelSettlement(txId);
      redirectAttributes.addFlashAttribute(ATTR_SUCCESS_MESSAGE, SUCCESS_CANCEL);
    } catch (PaysafeSdkException e) {
      redirectAttributes.addFlashAttribute(ATTR_ERROR_MESSAGE, buildErrorMessage(ERROR_CANCEL_FAILED, e));
    } catch (Exception e) {
      redirectAttributes.addFlashAttribute(ATTR_ERROR_MESSAGE, buildErrorMessage(ERROR_CANCEL_FAILED, e));
    }
    return REDIRECT_HOME;
  }

  @PostMapping("/refund/{txId}")
  public String refund(@PathVariable String txId,
      @RequestParam(required = false) String customerAccountId,
      RedirectAttributes redirectAttributes) {
    try {
      Transaction tx = demoService.refund(txId, customerAccountId);
      redirectAttributes.addFlashAttribute(ATTR_SUCCESS_MESSAGE,
          String.format(SUCCESS_REFUND, tx.getRefundId()));
    } catch (PaysafeSdkException e) {
      redirectAttributes.addFlashAttribute(ATTR_ERROR_MESSAGE, buildErrorMessage(ERROR_REFUND_FAILED, e));
    } catch (Exception e) {
      redirectAttributes.addFlashAttribute(ATTR_ERROR_MESSAGE, buildErrorMessage(ERROR_REFUND_FAILED, e));
    }
    return REDIRECT_HOME;
  }

  private String buildErrorMessage(String prefix, PaysafeSdkException e) {
    StringBuilder sb = new StringBuilder(prefix).append("\n");
    if (e == null) return sb.toString().trim();
    appendIfNotNull(sb, "HTTP Status", e.getCode());
    appendIfNotNull(sb, "Message", e.getMessage());
    appendIfNotNull(sb, "Correlation ID", e.getInternalCorrelationId());
    var err = e.getError();
    if (err == null) return sb.toString().trim();
    appendIfNotNull(sb, "Error Code", err.getCode());
    appendIfNotNull(sb, "Error Message", err.getMessage());
    appendListIfNotEmpty(sb, "Details", err.getDetails());
    appendFieldErrors(sb, err.getFieldErrors());
    appendAdditionalDetails(sb, err.getAdditionalDetails());
    return sb.toString().trim();
  }

  private String buildErrorMessage(String prefix, Exception e) {
    StringBuilder sb = new StringBuilder(prefix).append("\n");
    if (e == null) return sb.toString().trim();
    appendIfNotNull(sb, "Message", e.getMessage());
    if (e.getCause() != null) {
      appendIfNotNull(sb, "Cause", e.getCause().getMessage());
    }
    return sb.toString().trim();
  }

  private void appendListIfNotEmpty(StringBuilder sb, String label, java.util.List<String> list) {
    if (list != null && !list.isEmpty()) {
      sb.append(label).append(": ").append(String.join(", ", list)).append("\n");
    }
  }

  private void appendFieldErrors(StringBuilder sb, java.util.List<?> fieldErrors) {
    if (fieldErrors != null && !fieldErrors.isEmpty()) {
      fieldErrors.forEach(f -> {
        try {
          var field = f.getClass().getMethod("getField").invoke(f);
          var error = f.getClass().getMethod("getError").invoke(f);
          sb.append("Field Error [").append(field).append("]: ").append(error).append("\n");
        } catch (Exception ignored) {
          // Reflection failed: the field error object does not have the expected methods or structure.
          // This is not critical for error reporting, so we skip this entry and continue.
        }
      });
    }
  }

  private void appendAdditionalDetails(StringBuilder sb, java.util.List<?> additionalDetails) {
    if (additionalDetails != null && !additionalDetails.isEmpty()) {
      additionalDetails.forEach(d -> {
        try {
          var type = d.getClass().getMethod("getType").invoke(d);
          var message = d.getClass().getMethod("getMessage").invoke(d);
          sb.append("Additional [").append(type).append("]: ").append(message).append("\n");
        } catch (Exception ignored) {
          // Reflection failed: the additional detail object does not have the expected methods or structure.
          // This is not critical for error reporting, so we skip this entry and continue.
        }
      });
    }
  }

  private void appendIfNotNull(StringBuilder sb, String label, Object value) {
    if (value != null) {
      sb.append(label).append(": ").append(value).append("\n");
    }
  }
}
