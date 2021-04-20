package com.demo.order.api.customer;

import com.demo.order.entity.Customer;

import java.util.function.Function;

public class CustomerMapper {

    public static Function<Customer, CustomerResponse> mapToResponse = customer -> new CustomerResponse(customer.getId(), customer.getName(), customer.getMail());

    public static Function<CustomerRequest, Customer> mapToEntity = customerRequest -> Customer.builder()
            .name(customerRequest.getName())
            .mail(customerRequest.getEmail())
            .build();
}
