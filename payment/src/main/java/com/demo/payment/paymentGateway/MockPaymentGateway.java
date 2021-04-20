package com.demo.payment.paymentGateway;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@Log4j2
@Service
public class MockPaymentGateway implements PaymentGateway {

    @Override
    public Optional<PaymentTransaction> pay() {
        try {
            log.info("Authorizing payment");
            return Optional.of(CompletableFuture.supplyAsync(() -> new PaymentTransaction(UUID.randomUUID().toString()),
                    CompletableFuture.delayedExecutor(5, TimeUnit.SECONDS)).get());
        } catch (InterruptedException | ExecutionException e) {
            log.info("Error authorizing payment");
            e.printStackTrace();
        }
        return Optional.empty();
    }

}
