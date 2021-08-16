package com.bank.a.account.dto;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;
@XmlRootElement(name = "AccountDto")
@XmlAccessorType (XmlAccessType.NONE)
public class AccountDto {
    private long account_id;
    @XmlElement(name = "account_num")
    private String account_num;
    @XmlElement(name = "account_type")
    private String account_type;
    @XmlElement(name = "balance")
    private BigDecimal balance;

    public AccountDto() {
    }

    public long getAccount_id() {
        return account_id;
    }

    public void setAccount_id(long account_id) {
        this.account_id = account_id;
    }

    public AccountDto(long account_id, String account_num, String account_type, BigDecimal balance) {
        this.account_id = account_id;
        this.account_num = account_num;
        this.account_type = account_type;
        this.balance = balance;
    }

    public String getAccount_num() {
        return account_num;
    }

    public void setAccount_num(String account_num) {
        this.account_num = account_num;
    }

    public String getAccount_type() {
        return account_type;
    }

    public void setAccount_type(String account_type) {
        this.account_type = account_type;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
