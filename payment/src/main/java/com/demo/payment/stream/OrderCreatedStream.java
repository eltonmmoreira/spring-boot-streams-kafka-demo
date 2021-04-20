package com.demo.payment.stream;

import com.demo.payment.event.OrderReceive;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Log4j2
@Component
public class OrderCreatedStream {

    private final ApplicationEventPublisher eventPublisher;

    public OrderCreatedStream(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    @Bean
    public Consumer<OrderCreated> orderCreated() {
        return orderCreatedMessage -> {
            log.info("Order received {}", orderCreatedMessage.getId());
            eventPublisher.publishEvent(new OrderReceive(this, orderCreatedMessage));
        };
    }
}
