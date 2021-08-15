package com.bank.a.account.controller;

import com.bank.a.account.dto.AccountRequestDto;
import com.bank.a.account.service.AccountService;
import com.bank.a.client.model.Client;
import com.bank.a.client.service.ClientService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.bank.a.result.handler.ErrorDictionary.error001;

@RestController
@RequestMapping(value = "/api/account", produces = "application/json;charset=UTF-8")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private Gson gson;

    @PostMapping("/create")
    public String createClient(@RequestBody AccountRequestDto accountDtoList) {
        Client client = clientService.findClientById(accountDtoList.getClient_id());
        if (client == null) {
            return gson.toJson(error001);
        }
        return gson.toJson(accountService.createAccounts(accountDtoList.getAccounts(), client));
    }
}
