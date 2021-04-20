package com.demo.order.stream;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class OrderCreated {
    private final Long id;
    private final Long customerId;
    private final String mail;
    private final LocalDateTime dateCreated;
    private final BigDecimal value;
}
