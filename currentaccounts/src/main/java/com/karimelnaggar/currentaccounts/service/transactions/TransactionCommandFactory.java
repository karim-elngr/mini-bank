package com.karimelnaggar.currentaccounts.service.transactions;

import com.karimelnaggar.currentaccounts.service.model.Account;
import com.karimelnaggar.currentaccounts.service.model.InitialCreditModel;
import com.karimelnaggar.currentaccounts.service.model.TransactionCommand;
import org.springframework.stereotype.Component;

@Component
public class TransactionCommandFactory {

    public TransactionCommand createInitialTransaction(Account newAccount, InitialCreditModel initialCredit) {

        return null;
    }
}
