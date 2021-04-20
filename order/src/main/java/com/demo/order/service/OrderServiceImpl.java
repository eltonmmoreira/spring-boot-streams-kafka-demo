package com.demo.order.service;

import com.demo.order.entity.Order;
import com.demo.order.event.PostSaveOrder;
import com.demo.order.exception.NoResultException;
import com.demo.order.repository.OrderRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ApplicationEventPublisher eventPublisher;

    public OrderServiceImpl(OrderRepository orderRepository, ApplicationEventPublisher eventPublisher) {
        this.orderRepository = orderRepository;
        this.eventPublisher = eventPublisher;
    }

    @Override
    public Order save(Order order) {
        order = orderRepository.save(order);
        eventPublisher.publishEvent(new PostSaveOrder(this, order));
        return order;
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public void cancelOrder(Long id) {
        orderRepository.findById(id)
                .ifPresentOrElse(order -> {
                    order.cancel();
                    save(order);
                }, () -> {
                    throw new NoResultException(String.format("No Result order [%d]", id));
                });
    }
}
