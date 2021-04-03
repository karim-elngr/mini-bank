package com.karimelnaggar.currentaccounts.service.accounts;

import org.testcontainers.shaded.org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class AccountInstanceProvider {

    private static final String CURRENT_ACCOUNT_ID = "currentAccountId#1";

    public static Account createValidAccount() {

        return new Account(
                CURRENT_ACCOUNT_ID,
                CustomerInstanceProvider.createValidCustomer(),
                CreditInstanceProvider.createValidCredit()
        );
    }

    public static List<Account> createInvalidAccounts() {

        final ArrayList<Account> invalidAccounts = new ArrayList<>();

        // Current account id is null or is empty

        invalidAccounts.add(new Account(null,
                        CustomerInstanceProvider.createValidCustomer(),
                        CreditInstanceProvider.createValidCredit()));

        invalidAccounts.add(new Account(StringUtils.EMPTY,
                CustomerInstanceProvider.createValidCustomer(),
                CreditInstanceProvider.createValidCredit()));

        // Customer is null or is invalid

        invalidAccounts.add(new Account(CURRENT_ACCOUNT_ID,
                null,
                CreditInstanceProvider.createValidCredit()));

        for (Customer invalidCustomer : CustomerInstanceProvider.createInvalidCustomers()) {

            invalidAccounts.add(new Account(CURRENT_ACCOUNT_ID,
                    invalidCustomer,
                    CreditInstanceProvider.createValidCredit()));
        }

        // Credit is null or is invalid

        invalidAccounts.add(new Account(CURRENT_ACCOUNT_ID,
                CustomerInstanceProvider.createValidCustomer(),
                null));

        for (Credit invalidCredit : CreditInstanceProvider.createInvalidCredits()) {

            invalidAccounts.add(new Account(CURRENT_ACCOUNT_ID,
                    CustomerInstanceProvider.createValidCustomer(),
                    invalidCredit));
        }

        return invalidAccounts;
    }
}
