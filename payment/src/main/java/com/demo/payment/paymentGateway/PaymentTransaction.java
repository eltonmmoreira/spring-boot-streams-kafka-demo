package com.demo.payment.paymentGateway;

public class PaymentTransaction {
    private String transactionId;

    public PaymentTransaction(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionId() {
        return transactionId;
    }
}
