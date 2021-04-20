package com.demo.payment.event;

import com.demo.payment.entity.Payment;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

public class PostSavePayment extends ApplicationEvent {

    @Getter
    private final Payment payment;

    public PostSavePayment(Object source, Payment payment) {
        super(source);
        this.payment = payment;
    }
}
