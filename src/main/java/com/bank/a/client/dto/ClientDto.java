package com.bank.a.client.dto;

import com.bank.a.account.Account;
import com.sun.istack.NotNull;

import java.util.List;

public class ClientDto {
    @NotNull
    private String first_name;
    @NotNull
    private String last_name;
    private List<Account> accounts;

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}
