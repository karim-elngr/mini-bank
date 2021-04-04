package com.karimelnaggar.currentaccounts.service.accounts;

import java.util.List;
import java.util.Optional;

public interface AccountsFacade {

    Account createNewAccount(CreateAccountRequest createAccountRequest);

    Optional<Account> getAccount(String currentAccountId);

    List<Account> getAllAccounts(String customerId);
}
