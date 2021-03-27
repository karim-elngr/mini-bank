package com.karimelnaggar.currentaccounts.service.accounts;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CreateAccountFacadeImpl implements CreateAccountFacade {

    private final AccountsService accountsService;

    public CreateAccountFacadeImpl(AccountsService accountsService) {
        this.accountsService = accountsService;
    }

    @Override
    public Account createNewAccount(CreateAccountRequestModel createAccountRequestModel) {

        final Optional<Account> potentialAccount = accountsService.getAccount("");

        if (potentialAccount.isPresent()) {

            final Account existingAccount = potentialAccount.get();
            return existingAccount;
        }

        final Account unsafeAccount = new Account();
        final Account newAccount = accountsService.createNewAccount(unsafeAccount);
        return unsafeAccount;
    }
}
