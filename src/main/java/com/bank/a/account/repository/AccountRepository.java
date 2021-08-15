package com.bank.a.account.repository;

import com.bank.a.account.Account;
import com.bank.a.client.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByNumber(String number);
    List<Account> findAllByClient(Client client);
}
