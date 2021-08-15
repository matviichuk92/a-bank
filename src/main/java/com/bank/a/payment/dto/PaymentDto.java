package com.bank.a.payment.dto;

import java.math.BigDecimal;

public class PaymentDto {
    private long source_acc_id;
    private long dest_acc_id;
    private BigDecimal amount;
    private String reason;

    public long getSource_acc_id() {
        return source_acc_id;
    }

    public void setSource_acc_id(long source_acc_id) {
        this.source_acc_id = source_acc_id;
    }

    public long getDest_acc_id() {
        return dest_acc_id;
    }

    public void setDest_acc_id(long dest_acc_id) {
        this.dest_acc_id = dest_acc_id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
