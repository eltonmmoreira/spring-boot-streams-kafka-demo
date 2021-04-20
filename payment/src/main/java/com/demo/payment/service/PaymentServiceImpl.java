package com.demo.payment.service;

import com.demo.payment.entity.Payment;
import com.demo.payment.event.OrderReceive;
import com.demo.payment.event.PostSavePayment;
import com.demo.payment.paymentGateway.PaymentGateway;
import com.demo.payment.repository.PaymentRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final ApplicationEventPublisher eventPublisher;
    private final PaymentGateway paymentGateway;

    public PaymentServiceImpl(PaymentRepository paymentRepository, ApplicationEventPublisher eventPublisher, PaymentGateway paymentGateway) {
        this.paymentRepository = paymentRepository;
        this.eventPublisher = eventPublisher;
        this.paymentGateway = paymentGateway;
    }

    @Override
    public Payment save(Payment payment) {
        payment = paymentRepository.save(payment);
        log.info("Payment saved successfully {}", payment.getId());
        eventPublisher.publishEvent(new PostSavePayment(this, payment));
        return payment;
    }

    @Override
    public List<Payment> findAll() {
        return paymentRepository.findAll();
    }

    @EventListener
    public void pay(OrderReceive orderReceive) {
        var order = orderReceive.getOrderCreatedMessage();
        paymentGateway.pay().ifPresent(paymentTransaction -> {
            log.info("Authorized payment transactionId - {}", paymentTransaction.getTransactionId());

            save(new Payment(order.getId(),
                    order.getCustomerId(),
                    order.getMail(),
                    order.getValue(),
                    paymentTransaction.getTransactionId())
            );
        });
    }
}
