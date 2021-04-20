package com.demo.payment.stream;

import com.demo.payment.event.PostSavePayment;
import lombok.extern.log4j.Log4j2;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class PostSavePaymentStream {

    private static final String BINDING_NAME = "streaming.payment.accept";

    private final StreamBridge streamBridge;

    public PostSavePaymentStream(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }

    @EventListener
    public void paymentAccept(PostSavePayment event) {
        var payment = event.getPayment();
        log.info("Send order {} - {}", payment.getId(), BINDING_NAME);
        streamBridge.send(BINDING_NAME, new PaymentAccept(
                payment.getTransactionId(),
                payment.getOrderId(),
                payment.getCustomerId(),
                payment.getMail())
        );
    }
}
