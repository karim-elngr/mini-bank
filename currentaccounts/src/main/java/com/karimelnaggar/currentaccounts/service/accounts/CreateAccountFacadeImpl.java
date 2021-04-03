package com.karimelnaggar.currentaccounts.service.accounts;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CreateAccountFacadeImpl implements CreateAccountFacade {

    private final AccountsFactory accountsFactory;
    private final AccountsPersistenceService accountsPersistenceService;

    @Override
    @Transactional
    public Account createNewAccount(CreateAccountRequest createAccountRequest) {

        final Optional<Account> potentialAccount = accountsPersistenceService.findAccount(createAccountRequest.getCurrentAccountId());

        if (potentialAccount.isPresent()) {

            return potentialAccount.get();
        }

        final Account unsafeAccount = accountsFactory.createNewAccount(createAccountRequest);

        return accountsPersistenceService.persist(unsafeAccount);
    }
}
