package com.karimelnaggar.currentaccounts.service.accounts;

import com.karimelnaggar.currentaccounts.service.model.Account;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountsServiceImpl implements AccountsService {

    @Override
    public Account persist(Account account) {

        return null;
    }

    @Override
    public Optional<Account> findAccount(String currentAccountId) {

        return Optional.empty();
    }
}
