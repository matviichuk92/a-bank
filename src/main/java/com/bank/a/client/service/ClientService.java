package com.bank.a.client.service;

import com.bank.a.client.Client;
import com.bank.a.client.dto.ClientDto;
import com.bank.a.client.dto.ClientResponseDto;
import com.bank.a.client.repository.ClientRepository;
import com.bank.a.result.handler.ResultDto;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    @Autowired
    private Gson gson;

    @Autowired
    private ClientRepository clientRepository;

    public String createUser(ClientDto clientDto) {
        Client client = new Client();
        client.setName(clientDto.getFirst_name());
        client.setSurname(clientDto.getLast_name());
        clientRepository.save(client);
        if(clientDto.getAccounts() != null && !clientDto.getAccounts().isEmpty()) {
            //do something
        }
        return gson.toJson(new ClientResponseDto(client.getId()));

    }
}
