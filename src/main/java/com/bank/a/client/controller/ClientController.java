package com.bank.a.client.controller;

import com.bank.a.client.dto.ClientDto;
import com.bank.a.client.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/user", produces = "application/json;charset=UTF-8")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @PostMapping("/create")
    public String createClient(@RequestBody ClientDto clientDto) {
        return clientService.createUser(clientDto);
    }
}
