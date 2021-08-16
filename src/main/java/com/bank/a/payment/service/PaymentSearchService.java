package com.bank.a.payment.service;

import com.bank.a.client.dto.ClientDto;
import com.bank.a.payment.dto.PaymentResponseDto;
import com.bank.a.payment.model.Payment;
import com.bank.a.payment.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class PaymentSearchService {
    @Autowired
    private PaymentRepository paymentRepository;

    public List<PaymentResponseDto> findAllByAmountAndTime(BigDecimal amount, Long timestamp) {
        List<Payment> resultSearch = paymentRepository.findAllByAmountGreaterThanAndTimestampIsAfter(amount, timestamp);
        return generatePaymentDetailsList(resultSearch);
    }

    public List<PaymentResponseDto> receiveAllPaymentsByClients(Long senderId, Long recipientId) {
        List<Payment> resultSearch = paymentRepository.findAllBySenderIdAndRecipientId(senderId, recipientId);
        return generatePaymentDetailsList(resultSearch);
    }

    public List<PaymentResponseDto> receiveAllPaymentsByStatus(String status) {
        List<Payment> resultSearch = paymentRepository.findAllByStatus(status);
        System.out.println("result search " + resultSearch.toString());
        return generatePaymentDetailsList(resultSearch);
    }

    private List<PaymentResponseDto> generatePaymentDetailsList(List<Payment> payments) {
        List<PaymentResponseDto> result = new ArrayList<>();
        for (Payment record : payments) {
            PaymentResponseDto responseDto = new PaymentResponseDto();
            responseDto.setPayment_id(record.getId());
            responseDto.setTimestamp(record.getTimestamp());
            responseDto.setSrc_acc_num(record.getSenderAccount());
            responseDto.setDest_acc_num(record.getRecipientAccount());
            responseDto.setAmount(record.getAmount());
            responseDto.setStatus(record.getStatus());
            if (record.getSender() != null && record.getRecipient() != null) {
                responseDto.setPayer(new ClientDto(record.getSender().getName(),
                        record.getSender().getSurname()));
                responseDto.setRecipient(new ClientDto(record.getRecipient().getName(),
                        record.getRecipient().getSurname()));
            }
            result.add(responseDto);
        }
        return result;
    }
}
