package com.demo.mail;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Log4j2
@Component
public class MailStream {

    private final MailSender mailSender;

    public MailStream(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Bean
    public Consumer<PaymentAccept> consumer() {
        return paymentAccept -> {
            log.info("Payment authorized");
            mailSender.sendMail(
                MailFactory.create(paymentAccept)
            );
        };
    }
}
