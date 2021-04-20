package com.demo.mail;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Log4j2
@Component
public class MockMailSender implements MailSender {

    @Override
    public void sendMail(Mail mail) {
        log.info("Sending mail");
        log.info("Mail: {}", mail);
        log.info("mail sent");
    }
}
