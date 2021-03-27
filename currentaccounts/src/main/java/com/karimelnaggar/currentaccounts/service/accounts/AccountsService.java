package com.karimelnaggar.currentaccounts.service.accounts;

import java.util.Optional;

public interface AccountsService {

    Account createNewAccount(Account account);

    Optional<Account> getAccount(String currentAccountId);
}
