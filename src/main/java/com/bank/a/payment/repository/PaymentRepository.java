package com.bank.a.payment.repository;

import com.bank.a.client.model.Client;
import com.bank.a.payment.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    List<Payment> findAllBySenderIdAndRecipientId(Client senderId, Client recipientId);
    List<Payment> findAllByAmountGreaterThanAndTimestampIsBefore(BigDecimal amount, Long timestamp);
    List<Payment> findAllByStatus(String status);
}
