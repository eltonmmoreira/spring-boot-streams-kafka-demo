package com.demo.payment.entity;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@ToString(exclude = {"id"})
@Entity
@Table(name = "PAYMENT")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "ORDER_ID", nullable = false)
    private Long orderId;

    @Column(name = "CUSTOMER_ID", nullable = false)
    private Long customerId;

    @Column(name = "MAIL", length = 150, nullable = false)
    private String mail;

    @Column(name = "VALUE", nullable = false, precision = 15, scale = 2)
    private BigDecimal value;

    @Column(name = "PAYMENT_DATE", nullable = false)
    private LocalDateTime paymentDate;

    @Column(name = "TRANSACTION_ID")
    private String transactionId;

    @Deprecated
    public Payment() {
    }

    public Payment(Long orderId, Long customerId,
                   String mail, BigDecimal value,
                   String transactionId) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.mail = mail;
        this.value = value;
        this.transactionId = transactionId;
    }

    @PrePersist
    public void prePersist() {
        paymentDate = LocalDateTime.now();
    }
}
