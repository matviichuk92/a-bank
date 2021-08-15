package com.bank.a.payment.service;

import com.bank.a.client.dto.ClientDto;
import com.bank.a.client.model.Client;
import com.bank.a.client.service.ClientService;
import com.bank.a.payment.dto.PaymentResponseDto;
import com.bank.a.payment.model.Payment;
import com.bank.a.payment.repository.PaymentRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static com.bank.a.result.handler.CodeDictionary.code001;

@Service
public class PaymentSearchService {
    @Autowired
    private ClientService clientService;

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private Gson gson;

    public String receiveAllPaymentsByClients(BigDecimal amount, Long timestamp) {
        List<Payment> resultSearch = paymentRepository.findAllByAmountGreaterThanAndTimestampIsBefore(amount, timestamp);
        return gson.toJson(generatePaymentDetailsList(resultSearch));
    }

    public String receiveAllPaymentsByClients(Long senderId, Long recipientId) {
        Client sender = clientService.findClientById(senderId);
        Client recipient = clientService.findClientById(recipientId);
        if (sender == null || recipient == null) {
            return gson.toJson(code001);
        }
        List<Payment> resultSearch = paymentRepository.findAllBySenderIdAndRecipientId(sender, recipient);
        return gson.toJson(generatePaymentDetailsList(resultSearch));
    }

    public String receiveAllPaymentsByStatus(String status) {
        List<Payment> resultSearch = paymentRepository.findAllByStatus(status.toLowerCase());
        return gson.toJson(generatePaymentDetailsList(resultSearch));
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
            responseDto.setPayer(new ClientDto(record.getSender().getName(),
                    record.getSender().getSurname()));
            responseDto.setRecipient(new ClientDto(record.getRecipient().getName(),
                    record.getRecipient().getSurname()));
            responseDto.setStatus(record.getStatus());
        }
        return result;
    }
}
