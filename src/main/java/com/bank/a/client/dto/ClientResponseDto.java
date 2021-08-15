package com.bank.a.client.dto;

public class ClientResponseDto {
    private long client_id;

    public ClientResponseDto() {
    }

    public ClientResponseDto(long client_id) {
        this.client_id = client_id;
    }

    public long getClient_id() {
        return client_id;
    }

    public void setClient_id(long client_id) {
        this.client_id = client_id;
    }
}
