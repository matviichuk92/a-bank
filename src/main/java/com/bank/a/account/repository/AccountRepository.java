package com.bank.a.account.repository;

import com.bank.a.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByNumber(String number);
}
