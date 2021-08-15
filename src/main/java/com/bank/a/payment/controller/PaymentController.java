package com.bank.a.payment.controller;

import com.bank.a.payment.dto.PaymentDto;
import com.bank.a.payment.dto.PaymentSearchDto;
import com.bank.a.payment.service.PaymentSearchService;
import com.bank.a.payment.service.PaymentService;
import com.bank.a.result.handler.ResultDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.bank.a.result.handler.CodeDictionary.code000;

@RestController
@RequestMapping(value = "/api/payment", produces = "application/json;charset=UTF-8")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @Autowired
    private PaymentSearchService paymentSearchService;


    @PostMapping("/create/single")
    public ResultDto createSinglePayment(@RequestBody PaymentDto paymentDto) {
        return code000.addData(paymentService.makePayments(List.of(paymentDto)));
    }

    @PostMapping("/create/multiple")
    public ResultDto createMultiplePayments(@RequestBody List<PaymentDto> payments) {
        return code000.addData(paymentService.makePayments(payments));
    }

    @PostMapping("/search/status")
    public ResultDto searchPaymentsByStatus(@RequestBody PaymentSearchDto paymentSearchDto) {
        return code000.addData(paymentSearchService.receiveAllPaymentsByStatus(paymentSearchDto.getStatus()));
    }

    @PostMapping("/search/client")
    public ResultDto searchPaymentsByClients(@RequestBody PaymentSearchDto paymentSearchDto) {
        return code000.addData(paymentSearchService.receiveAllPaymentsByClients(paymentSearchDto.getPayer_id(),
                paymentSearchDto.getRecipient_id()));
    }

    @PostMapping("/search/amount")
    public ResultDto searchPaymentsByAmountAndTime(@RequestBody PaymentSearchDto paymentSearchDto) {
        return code000.addData(paymentSearchService.receiveAllPaymentsByStatus(paymentSearchDto.getStatus()));
    }



}
