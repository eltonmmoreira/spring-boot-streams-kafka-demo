package com.demo.payment.service;

import com.demo.payment.entity.Payment;

import java.util.List;

public interface PaymentService {

    Payment save(Payment payment);

    List<Payment> findAll();
}
