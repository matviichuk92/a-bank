package com.bank.a.client.service;

import com.bank.a.account.Account;
import com.bank.a.account.dto.AccountResponseDto;
import com.bank.a.account.service.AccountService;
import com.bank.a.client.dto.ClientResponseDto;
import com.bank.a.client.model.Client;
import com.bank.a.client.dto.ClientDto;
import com.bank.a.client.repository.ClientRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    @Autowired
    private Gson gson;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AccountService accountService;

    public String createUser(ClientDto clientDto) {
        Client client = new Client();
        client.setName(clientDto.getFirst_name());
        client.setSurname(clientDto.getLast_name());
        clientRepository.save(client);

        if (clientDto.getAccounts() != null && !clientDto.getAccounts().isEmpty()) {
            AccountResponseDto accountResponseDto = accountService.createAccounts(clientDto.getAccounts(), client);

            if (!accountResponseDto.getNumbersAlreadyHasAccounts().isEmpty()) {
                return gson.toJson(new ClientResponseDto(client.getId(), accountResponseDto));
            }
        }

        return gson.toJson(new ClientDto(client.getId()));
    }

    public Client findClientById(long id) {
        return clientRepository.findTopById(id);
    }
}
