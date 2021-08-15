package com.bank.a.payment.dto;

import com.bank.a.client.dto.ClientDto;

import java.math.BigDecimal;

public class PaymentResponseDto {
    private Long payment_id;
    private Long timestamp;
    private Long src_acc_num;
    private Long dest_acc_num;
    private BigDecimal amount;
    private ClientDto payer;
    private ClientDto recipient;
    private String status;

    public Long getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(Long payment_id) {
        this.payment_id = payment_id;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Long getSrc_acc_num() {
        return src_acc_num;
    }

    public void setSrc_acc_num(Long src_acc_num) {
        this.src_acc_num = src_acc_num;
    }

    public Long getDest_acc_num() {
        return dest_acc_num;
    }

    public void setDest_acc_num(Long dest_acc_num) {
        this.dest_acc_num = dest_acc_num;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public ClientDto getPayer() {
        return payer;
    }

    public void setPayer(ClientDto payer) {
        this.payer = payer;
    }

    public ClientDto getRecipient() {
        return recipient;
    }

    public void setRecipient(ClientDto recipient) {
        this.recipient = recipient;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}



