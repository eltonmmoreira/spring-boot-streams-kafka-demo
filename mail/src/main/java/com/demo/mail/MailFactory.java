package com.demo.mail;

public class MailFactory {

    private static final String FROM = "test@test.com";

    private MailFactory() {
    }

    public static Mail create(PaymentAccept paymentAccept) {
        return Mail.builder()
                .from(FROM)
                .to(paymentAccept.getMail())
                .title("Payment")
                .content(String.format(
                        "Authorized payment. \n " +
                                "TransactionId - %s \n" +
                                "Order - %d \n",
                        paymentAccept.getTransactionId(),
                        paymentAccept.getOrderId()))
                .build();
    }

}
