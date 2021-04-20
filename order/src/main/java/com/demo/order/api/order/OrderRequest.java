package com.demo.order.api.order;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class OrderRequest {
    private Long customerId;
    private BigDecimal value;
}
