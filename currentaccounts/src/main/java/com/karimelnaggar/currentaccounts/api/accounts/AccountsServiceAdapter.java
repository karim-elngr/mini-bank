package com.karimelnaggar.currentaccounts.api.accounts;

interface AccountsServiceAdapter {

    AccountResponseDto createAccount(CreateAccountRequestDto request);

    AccountResponseDto getAccount(String currentAccountId);

    AccountsResponseDto getAllAccountsForCustomer(String customerId);
}
