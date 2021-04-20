package com.demo.payment.stream;

import lombok.Getter;

@Getter
public class PaymentAccept {
    private final String transactionId;
    private final Long orderId;
    private final Long customerId;
    private final String mail;

    public PaymentAccept(String transactionId, Long orderId, Long customerId, String mail) {
        this.transactionId = transactionId;
        this.orderId = orderId;
        this.customerId = customerId;
        this.mail = mail;
    }
}
