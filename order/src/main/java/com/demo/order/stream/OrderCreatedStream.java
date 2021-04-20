package com.demo.order.stream;

import com.demo.order.event.PostSaveOrder;
import lombok.extern.log4j.Log4j2;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import static com.demo.order.api.order.OrderMapper.mapToOrderStream;

@Log4j2
@Component
public class OrderCreatedStream {

    private static final String BINDING_NAME = "streaming.order.created";

    private final StreamBridge streamBridge;

    public OrderCreatedStream(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }

    @EventListener
    public void create(PostSaveOrder event) {
        var order = event.getOrder();
        log.info("Send order {} - {}", order.getId(), BINDING_NAME);
        streamBridge.send(BINDING_NAME, mapToOrderStream.apply(order));
    }

}
