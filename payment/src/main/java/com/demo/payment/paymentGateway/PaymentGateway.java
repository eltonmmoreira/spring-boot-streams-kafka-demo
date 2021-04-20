package com.demo.payment.paymentGateway;

import java.util.Optional;

public interface PaymentGateway {

    Optional<PaymentTransaction> pay();

}
