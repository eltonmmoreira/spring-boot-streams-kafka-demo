package com.demo.order.api.customer;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerResponse {
    private Long id;
    private String name;
    private String email;
}
