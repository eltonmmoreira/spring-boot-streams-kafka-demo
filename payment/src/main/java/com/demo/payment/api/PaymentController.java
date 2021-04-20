package com.demo.payment.api;

import com.demo.payment.service.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("payment")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PaymentResponse> findAll() {
        return paymentService.findAll()
                .stream()
                .map(payment -> PaymentResponse.builder()
                        .id(payment.getId())
                        .customerId(payment.getCustomerId())
                        .orderId(payment.getOrderId())
                        .value(payment.getValue())
                        .paymentDate(payment.getPaymentDate())
                        .transactionId(payment.getTransactionId())
                        .build()
                ).collect(Collectors.toList());
    }

}
