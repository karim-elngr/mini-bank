package com.karimelnaggar.currentaccounts.service.accounts;

import com.karimelnaggar.currentaccounts.service.model.Account;
import com.karimelnaggar.currentaccounts.service.model.CreateAccountRequestModel;
import com.karimelnaggar.currentaccounts.service.model.TransactionCommand;
import com.karimelnaggar.currentaccounts.service.transactions.TransactionCommandFactory;
import com.karimelnaggar.currentaccounts.service.transactions.TransactionsService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CreateAccountFacadeImpl implements CreateAccountFacade {

    private final AccountsFactory accountsFactory;
    private final AccountsService accountsService;
    private final TransactionCommandFactory transactionCommandFactory;
    private final TransactionsService transactionsService;

    public CreateAccountFacadeImpl(
            AccountsFactory accountsFactory,
            AccountsService accountsService,
            TransactionCommandFactory transactionCommandFactory,
            TransactionsService transactionsService
    ) {
        this.accountsFactory = accountsFactory;
        this.accountsService = accountsService;
        this.transactionCommandFactory = transactionCommandFactory;
        this.transactionsService = transactionsService;
    }

    @Override
    public Account createNewAccount(CreateAccountRequestModel createAccountRequestModel) {

        final Optional<Account> potentialAccount = accountsService.findAccount(createAccountRequestModel.getCurrentAccountId());

        if (potentialAccount.isPresent()) {

            return potentialAccount.get();
        }

        final Account unsafeAccount = accountsFactory.createNewAccount(createAccountRequestModel);
        final Account newAccount = accountsService.persist(unsafeAccount);
        final TransactionCommand transactionCommand = transactionCommandFactory.createInitialTransaction(
                newAccount, createAccountRequestModel.getInitialCredit());
        transactionsService.scheduleTransactionCommand(transactionCommand);

        return newAccount;
    }
}
