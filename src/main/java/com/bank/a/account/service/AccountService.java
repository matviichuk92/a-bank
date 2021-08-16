package com.bank.a.account.service;

import com.bank.a.account.model.Account;
import com.bank.a.account.dto.AccountDto;
import com.bank.a.account.dto.AccountResponseDto;
import com.bank.a.account.repository.AccountRepository;
import com.bank.a.client.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public AccountResponseDto createAccounts(List<AccountDto> accounts, Client client) {
        List<String> numbersHasAccountsInDb = new ArrayList<>();
        List<String> newAccountsList = new ArrayList<>();

        for(AccountDto account : accounts) {
            Account accountFromDb = accountRepository.findByNumber(account.getAccount_num());
            if(accountFromDb != null) {
                numbersHasAccountsInDb.add(account.getAccount_num());
                continue;
            }
            Account newAccount = new Account();
            newAccount.setNumber(account.getAccount_num());
            newAccount.setType(account.getAccount_type());
            newAccount.setBalance(account.getBalance());
            newAccount.setClient(client);
            accountRepository.save(newAccount);
            newAccountsList.add(account.getAccount_num());
        }

        AccountResponseDto accountResponseDto = new AccountResponseDto();
        accountResponseDto.setNumbersAlreadyHasAccounts(numbersHasAccountsInDb);
        accountResponseDto.setNewAccountsWasCreatedByNumbers(newAccountsList);
        return accountResponseDto;
    }

    public List<AccountDto> findListAccountsByClientId(Client client) {
        return accountRepository.findAllByClient(client)
                .stream().map(o -> new AccountDto(o.getId(), o.getNumber(), o.getType(), o.getBalance()))
                .collect(Collectors.toList());
    }

    public Account findAccountById(Long id) {
        return accountRepository.findAccountById(id);
    }

    public void saveChangesAfterTransaction(Account sender, Account receipt) {
        accountRepository.save(sender);
        accountRepository.save(receipt);
    }
}
