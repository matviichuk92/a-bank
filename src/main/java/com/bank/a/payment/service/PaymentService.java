package com.bank.a.payment.service;

import com.bank.a.account.model.Account;
import com.bank.a.account.service.AccountService;
import com.bank.a.payment.dto.PaymentDto;
import com.bank.a.payment.model.Payment;
import com.bank.a.payment.repository.PaymentRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PaymentService {
    @Autowired
    private AccountService accountService;

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private Gson gson;

    public static final String OK_STATUS = "ok";
    public static final String ERROR_STATUS = "error";

    public Map<Long, String> makePayments(List<PaymentDto> paymentDto) {
        Map<Long, String> paymentsResult = new HashMap<>();
        for (PaymentDto record : paymentDto) {
            Payment payment = new Payment();
            payment.setStatus(OK_STATUS);
            checkingValidParameters(payment, record);
            payment.setSenderAccount(record.getSource_acc_id());
            payment.setRecipientAccount(record.getDest_acc_id());
            payment.setAmount(record.getAmount());
            payment.setPurpose(record.getReason());
            payment.setTimestamp(System.currentTimeMillis());
            paymentRepository.save(payment);

            paymentsResult.put(payment.getId(), payment.getStatus());
        }
        return paymentsResult;
    }

    private void checkingValidParameters(Payment payment, PaymentDto paymentSingle) {
        Account sender = accountService.findAccountById(paymentSingle.getSource_acc_id());
        Account recipient = accountService.findAccountById(paymentSingle.getDest_acc_id());
        if (sender == null || recipient == null) {
            payment.setStatus(ERROR_STATUS);
        }

        if (sender != null && recipient != null) {
            payment.setSender(sender.getClient());
            payment.setRecipient(recipient.getClient());
            if (sender.getBalance().compareTo(paymentSingle.getAmount()) < 0) {
                System.out.println("");
                payment.setStatus(ERROR_STATUS);
            } else if (BigDecimal.ZERO.compareTo(paymentSingle.getAmount()) > 0) {
                payment.setStatus(ERROR_STATUS);
            } else {
                BigDecimal balanceSenderAfterTransfer = sender.getBalance().subtract(paymentSingle.getAmount());
                BigDecimal balanceRecipientAfterTransfer = recipient.getBalance().add(paymentSingle.getAmount());

                sender.setBalance(balanceSenderAfterTransfer);
                recipient.setBalance(balanceRecipientAfterTransfer);
                accountService.saveChangesAfterTransaction(sender, recipient);
            }
        }
    }
}

