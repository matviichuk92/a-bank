package com.bank.a.client.repository;

import com.bank.a.client.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findTopById(Long id);
}
