package com.bank.a.client.controller;

import com.bank.a.client.dto.ClientDto;
import com.bank.a.client.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/client", produces = MediaType.APPLICATION_XML_VALUE,
        consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
public class ClientController {
    @Autowired
    private ClientService clientService;

    @PostMapping("/create")
    public String createClient(@Valid @RequestBody ClientDto clientDto) {
        return clientService.createUser(clientDto);
    }
}
