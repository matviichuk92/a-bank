package com.bank.a.payment.model;

import com.bank.a.client.model.Client;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long timestamp;
    private long senderAccount;
    private long recipientAccount;
    private BigDecimal amount;
    private String purpose;
    private String status;
    @OneToOne
    private Client sender;
    @OneToOne
    private Client recipient;

    public Payment() {
    }

    public Client getSender() {
        return sender;
    }

    public void setSender(Client senderId) {
        this.sender = senderId;
    }

    public Client getRecipient() {
        return recipient;
    }

    public void setRecipient(Client recipientId) {
        this.recipient = recipientId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public long getSenderAccount() {
        return senderAccount;
    }

    public void setSenderAccount(long senderAccount) {
        this.senderAccount = senderAccount;
    }

    public long getRecipientAccount() {
        return recipientAccount;
    }

    public void setRecipientAccount(long recipient) {
        this.recipientAccount = recipient;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

}
