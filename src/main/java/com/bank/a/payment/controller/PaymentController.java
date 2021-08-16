package com.bank.a.payment.controller;

import com.bank.a.payment.dto.PaymentDto;
import com.bank.a.payment.dto.PaymentList;
import com.bank.a.payment.dto.PaymentSearchDto;
import com.bank.a.payment.service.PaymentSearchService;
import com.bank.a.payment.service.PaymentService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.math.BigDecimal;
import java.util.List;

import static com.bank.a.result.handler.CodeDictionary.code000;

@RestController
@RequestMapping(value = "/api/payment", produces = MediaType.APPLICATION_XML_VALUE,
        consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @Autowired
    private PaymentSearchService paymentSearchService;

    @Autowired
    private Gson gson;

    @PostMapping("/create/single")
    public String createSinglePayment(@RequestBody PaymentDto paymentDto) {
        return gson.toJson(code000.addData(paymentService.makePayments(List.of(paymentDto))));
    }

    @PostMapping("/create/multiple")
    public String createMultiplePayments(@RequestBody PaymentList payments) {
        System.out.println(payments.toString());
        return gson.toJson(code000.addData(paymentService.makePayments(payments.getPayments())));
    }

    @PostMapping("/search/status")
    public String searchPaymentsByStatus(@RequestBody PaymentSearchDto paymentSearchDto) {
        String statusPayments = paymentSearchDto.getStatus();
        return gson.toJson(code000.addData(paymentSearchService.receiveAllPaymentsByStatus(statusPayments)));
    }

    @PostMapping("/search/client")
    public String searchPaymentsByClients(@RequestBody PaymentSearchDto paymentSearchDto) {
        Long senderId = paymentSearchDto.getPayer_id();
        Long recipientId = paymentSearchDto.getRecipient_id();
        return gson.toJson(code000.addData(paymentSearchService.receiveAllPaymentsByClients(senderId, recipientId)));
    }

    @PostMapping("/search/date/amount")
    public String searchPaymentsByAmountAndTime(@RequestBody PaymentSearchDto paymentSearchDto) {
        BigDecimal amount = paymentSearchDto.getAmount();
        Long timestamp = paymentSearchDto.getTimestamp();
        return gson.toJson(code000.addData(paymentSearchService.findAllByAmountAndTime(amount, timestamp)));
    }
}
