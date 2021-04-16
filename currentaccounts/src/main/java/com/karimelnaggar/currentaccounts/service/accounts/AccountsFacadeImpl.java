package com.karimelnaggar.currentaccounts.service.accounts;

import com.karimelnaggar.currentaccounts.service.transactions.Transaction;
import com.karimelnaggar.currentaccounts.service.transactions.TransactionsPlacementService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AccountsFacadeImpl implements AccountsFacade {

    private final AccountsFactory accountsFactory;
    private final AccountsPersistenceService accountsPersistenceService;
    private final TransactionsFactory transactionsFactory;
    private final TransactionsPlacementService transactionsPlacementService;

    @Override
    @Transactional
    public Account createNewAccount(CreateAccountRequest createAccountRequest) {

        final Optional<Account> potentialAccount = accountsPersistenceService.findAccount(createAccountRequest.getCurrentAccountId());

        if (potentialAccount.isPresent()) {

            return potentialAccount.get();
        }

        final Account unsafeAccount = accountsFactory.createNewAccount(createAccountRequest);
        final Account persistedAccount = accountsPersistenceService.persist(unsafeAccount);

        final Transaction topUpTransaction = transactionsFactory.createTopUpTransaction(
                persistedAccount,
                createAccountRequest
        );
        transactionsPlacementService.placeNewTransaction(topUpTransaction);

        return persistedAccount;
    }

    @Override
    @Transactional
    public Optional<Account> getAccount(String currentAccountId) {

        return accountsPersistenceService.findAccount(currentAccountId);
    }

    @Override
    @Transactional
    public List<Account> getAllAccounts(String customerId) {

        return accountsPersistenceService.findAllAccounts(customerId);
    }
}
