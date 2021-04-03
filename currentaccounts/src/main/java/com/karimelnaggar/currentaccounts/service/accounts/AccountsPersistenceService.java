package com.karimelnaggar.currentaccounts.service.accounts;

import java.util.Optional;

interface AccountsPersistenceService {

    Account persist(Account account);

    Optional<Account> findAccount(String currentAccountId);
}
