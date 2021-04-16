package com.karimelnaggar.currentaccounts.service.accounts;

import com.karimelnaggar.currentaccounts.service.transactions.Transaction;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TransactionsFactory {

    public Transaction createTopUpTransaction(Account persistedAccount, CreateAccountRequest createAccountRequest) {

        return new Transaction(
                UUID.randomUUID().toString(),
                persistedAccount.getCurrentAccountId(),
                createAccountRequest.getInitialCredit().getBalance().getNumberStripped(),
                persistedAccount.getCredit().getBalance().getCurrency().getCurrencyCode()
        );
    }
}
