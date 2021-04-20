package com.demo.mail;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class PaymentAccept {
    private String transactionId;
    private Long orderId;
    private Long customerId;
    private String mail;

    public PaymentAccept(String transactionId, Long orderId, Long customerId, String mail) {
        this.transactionId = transactionId;
        this.orderId = orderId;
        this.customerId = customerId;
        this.mail = mail;
    }
}
