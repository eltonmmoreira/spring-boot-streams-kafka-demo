package com.demo.order.event;

import com.demo.order.entity.Order;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

public class PostSaveOrder extends ApplicationEvent {

    @Getter
    private final Order order;

    public PostSaveOrder(Object source, Order order) {
        super(source);
        this.order = order;
    }
}
