package com.karimelnaggar.currentaccounts.service.accounts;

import com.karimelnaggar.currentaccounts.service.model.Account;

import java.util.Optional;

public interface AccountsService {

    Account persist(Account account);

    Optional<Account> findAccount(String currentAccountId);
}
