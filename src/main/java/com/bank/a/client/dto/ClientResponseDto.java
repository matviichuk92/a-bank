package com.bank.a.client.dto;

import com.bank.a.account.dto.AccountResponseDto;

public class ClientResponseDto {
    private long client_id;
    private AccountResponseDto accountsInfo;

    public ClientResponseDto() {
    }

    public ClientResponseDto(long client_id, AccountResponseDto accountsInfo) {
        this.client_id = client_id;
        this.accountsInfo = accountsInfo;
    }

    public long getClient_id() {
        return client_id;
    }

    public void setClient_id(long client_id) {
        this.client_id = client_id;
    }

    public AccountResponseDto getAccountsInfo() {
        return accountsInfo;
    }

    public void setAccountsInfo(AccountResponseDto accountsInfo) {
        this.accountsInfo = accountsInfo;
    }
}
