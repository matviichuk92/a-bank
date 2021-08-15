package com.bank.a.account.dto;

import java.util.List;

public class AccountResponseDto {
    private List<String> newAccountsWasCreatedByNumbers;
    private List<String> numbersAlreadyHasAccounts;

    public List<String> getNewAccountsWasCreatedByNumbers() {
        return newAccountsWasCreatedByNumbers;
    }

    public void setNewAccountsWasCreatedByNumbers(List<String> newAccountsWasCreatedByNumbers) {
        this.newAccountsWasCreatedByNumbers = newAccountsWasCreatedByNumbers;
    }

    public List<String> getNumbersAlreadyHasAccounts() {
        return numbersAlreadyHasAccounts;
    }

    public void setNumbersAlreadyHasAccounts(List<String> numbersAlreadyHasAccounts) {
        this.numbersAlreadyHasAccounts = numbersAlreadyHasAccounts;
    }
}
