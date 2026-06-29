// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

package com.paysafe.payments.merchantdemo.model;

/**
 * Form backing bean for collecting payment and billing details from the user.
 * Used to bind form fields in the Thymeleaf UI.
 */
public class CheckoutForm {

    // Payment method: CARD, PAYSAFECARD, PAYSAFECASH, PAYPAL, SKRILL
    private String paymentMethod = "CARD";

    private String holderName = "Jane Doe";
    private String cardNum = "4000000000002503";
    private String expiry = "10/28";
    private String cvv = "123";

    // Amount in dollars
    private String amount = "10.00";

    private String street = "221B Baker Street";
    private String street2;
    private String city = "London";
    private String state = "England";
    private String country = "GB";
    private String zip = "NW1 6XE";
    private String customerIp;
    private String paypalEmail = "JohnSmith@example.com";
    private String skrillId = "your_skrill_id";

    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }

    public String getHolderName() { return holderName; }
    public void setHolderName(String holderName) { this.holderName = holderName; }

    public String getCardNum() { return cardNum; }
    public void setCardNum(String cardNum) { this.cardNum = cardNum; }

    public String getExpiry() { return expiry; }
    public void setExpiry(String expiry) { this.expiry = expiry; }

    /** Parses "MM/YY" or "MM/YYYY" and returns the month as int. */
    public int getExpiryMonth() {
        if (expiry == null || !expiry.contains("/")) return 1;
        return Integer.parseInt(expiry.split("/")[0].trim());
    }

    /** Parses "MM/YY" or "MM/YYYY" and returns the full year as int. */
    public int getExpiryYear() {
        if (expiry == null || !expiry.contains("/")) return 2025;
        String yr = expiry.split("/")[1].trim();
        return yr.length() == 2 ? 2000 + Integer.parseInt(yr) : Integer.parseInt(yr);
    }

    public String getCvv() { return cvv; }
    public void setCvv(String cvv) { this.cvv = cvv; }

    public String getAmount() { return amount; }
    public void setAmount(String amount) { this.amount = amount; }

    public String getStreet() { return street; }
    public void setStreet(String street) { this.street = street; }

    public String getStreet2() { return street2; }
    public void setStreet2(String street2) { this.street2 = street2; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getState() { return state; }
    public void setState(String state) { this.state = state; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    public String getZip() { return zip; }
    public void setZip(String zip) { this.zip = zip; }

    public String getCustomerIp() {
        return customerIp;
    }
    public void setCustomerIp(String customerIp) {
        this.customerIp = customerIp;
    }

    public String getPaypalEmail() { return paypalEmail; }
    public void setPaypalEmail(String paypalEmail) { this.paypalEmail = paypalEmail; }

    public String getSkrillId() { return skrillId; }
    public void setSkrillId(String skrillId) { this.skrillId = skrillId; }
}
