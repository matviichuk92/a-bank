package com.bank.a.payment.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@XmlRootElement(name = "payment")
@XmlAccessorType(XmlAccessType.NONE)
public class PaymentDto {
    @XmlElement
    private long source_acc_id;
    @XmlElement
    private long dest_acc_id;
    @XmlElement
    private BigDecimal amount;
    @XmlElement
    private String reason;

    public PaymentDto() {
    }

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

    @Override
    public String toString() {
        return "PaymentDto{" +
                "source_acc_id=" + source_acc_id +
                ", dest_acc_id=" + dest_acc_id +
                ", amount=" + amount +
                ", reason='" + reason + '\'' +
                '}';
    }
}
