package com.karimelnaggar.currentaccounts.service.accounts;

import java.util.List;
import java.util.Optional;

interface AccountsPersistenceService {

    Account persist(Account account);

    Optional<Account> findAccount(String currentAccountId);

    List<Account> findAllAccounts(String customerId);
}
