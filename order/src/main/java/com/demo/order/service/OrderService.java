package com.demo.order.service;

import com.demo.order.entity.Order;

import java.util.List;

public interface OrderService {

    Order save(Order order);

    List<Order> findAll();

    void cancelOrder(Long id);
}
