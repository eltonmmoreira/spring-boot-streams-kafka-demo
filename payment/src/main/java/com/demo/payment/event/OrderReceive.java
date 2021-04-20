package com.demo.payment.event;

import com.demo.payment.stream.OrderCreated;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

public class OrderReceive extends ApplicationEvent {

    @Getter
    private final OrderCreated orderCreatedMessage;

    public OrderReceive(Object source, OrderCreated orderCreatedMessage) {
        super(source);
        this.orderCreatedMessage = orderCreatedMessage;
    }
}
