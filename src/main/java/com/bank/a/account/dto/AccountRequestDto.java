package com.bank.a.account.dto;

import com.sun.istack.NotNull;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class AccountRequestDto {
    @NotNull
    private long client_id;
    @NotNull
    private List<AccountDto> accounts;

    public AccountRequestDto() {
    }

    public long getClient_id() {
        return client_id;
    }

    public void setClient_id(long client_id) {
        this.client_id = client_id;
    }

    public List<AccountDto> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<AccountDto> accounts) {
        this.accounts = accounts;
    }
}
