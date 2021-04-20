package com.demo.order.api.order;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderResponse {
    private Long id;
    private Long customerId;
    private String mail;
    private LocalDateTime dateCreated;
    private BigDecimal value;
}
