package com.bank.a.payment.repository;

import com.bank.a.payment.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.math.BigDecimal;
import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    List<Payment> findAllBySenderIdAndRecipientId(Long senderId, Long recipientId);
    List<Payment> findAllByAmountGreaterThanAndTimestampIsAfter(BigDecimal amount, Long timestamp);
    List<Payment> findAllByStatus(String status);
}
