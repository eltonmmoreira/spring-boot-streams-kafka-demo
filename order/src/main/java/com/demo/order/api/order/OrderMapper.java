package com.demo.order.api.order;

import com.demo.order.entity.Customer;
import com.demo.order.entity.Order;
import com.demo.order.stream.OrderCreated;

import java.util.function.Function;

public class OrderMapper {

    public static Function<Order, OrderResponse> mapToResponse = order ->
            new OrderResponse(order.getId(),
                    order.getCustomer().getId(),
                    order.getCustomer().getMail(),
                    order.getDateCreated(),
                    order.getValue());

    public static Function<OrderRequest, Order> mapToEntity = orderRequest -> Order.builder()
            .customer(new Customer(orderRequest.getCustomerId()))
            .value(orderRequest.getValue())
            .build();

    public static Function<Order, OrderCreated> mapToOrderStream = order ->
            new OrderCreated(order.getId(),
                    order.getCustomer().getId(),
                    order.getCustomer().getMail(),
                    order.getDateCreated(),
                    order.getValue());

}
