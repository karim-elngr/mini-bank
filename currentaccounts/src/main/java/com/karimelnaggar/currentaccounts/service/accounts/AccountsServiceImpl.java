package com.karimelnaggar.currentaccounts.service.accounts;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountsServiceImpl implements AccountsService {

    @Override
    public Account createNewAccount(Account account) {

        return null;
    }

    @Override
    public Optional<Account> getAccount(String currentAccountId) {

        return Optional.empty();
    }
}
