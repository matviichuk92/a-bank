package com.bank.a.client.dto;

import com.bank.a.account.dto.AccountDto;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class ClientDto {
    private long client_id;
    @NotNull
    private String first_name;
    @NotNull
    private String last_name;
    private List<AccountDto> accounts;

    public ClientDto() {
    }

    public ClientDto(String first_name, String last_name) {
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public ClientDto(long client_id) {
        this.client_id = client_id;
    }

    public long getClient_id() {
        return client_id;
    }

    public void setClient_id(long client_id) {
        this.client_id = client_id;
    }

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

    public List<AccountDto> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<AccountDto> accounts) {
        this.accounts = accounts;
    }
}
