package com.demo.payment.stream;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class OrderCreated {
    private Long id;
    private Long customerId;
    private String mail;
    private BigDecimal value;

    public OrderCreated() {
    }

    public OrderCreated(Long id, Long customerId, String mail, BigDecimal value) {
        this.id = id;
        this.customerId = customerId;
        this.mail = mail;
        this.value = value;
    }
}
