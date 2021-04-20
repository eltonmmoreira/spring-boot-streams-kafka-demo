package com.demo.payment.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@Getter
public class PaymentResponse {
    private final Long id;
    private final Long orderId;
    private final Long customerId;
    private final BigDecimal value;
    private final LocalDateTime paymentDate;
    private final String transactionId;
}
