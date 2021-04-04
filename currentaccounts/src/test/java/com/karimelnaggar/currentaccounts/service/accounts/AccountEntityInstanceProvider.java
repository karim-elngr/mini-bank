package com.karimelnaggar.currentaccounts.service.accounts;

import com.karimelnaggar.currentaccounts.persistence.AccountEntity;
import com.karimelnaggar.currentaccounts.persistence.CreditEntity;
import com.karimelnaggar.currentaccounts.persistence.CustomerEntity;
import org.testcontainers.shaded.org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class AccountEntityInstanceProvider {

    private static final Long ID = 1L;
    private static final String CURRENT_ACCOUNT_ID = "currentAccountId#1";

    public static AccountEntity createValidAccountEntity() {

        return new AccountEntity(
                ID,
                CURRENT_ACCOUNT_ID,
                CustomerEntityInstanceProvider.createValidCustomerEntity(),
                CreditEntityInstanceProvider.createValidCreditEntity()
        );
    }

    public static List<AccountEntity> createInvalidAccountEntities() {

        final ArrayList<AccountEntity> invalidAccounts = new ArrayList<>();

        invalidAccounts.add(new AccountEntity());

        // Current account id is null or is empty

        invalidAccounts.add(new AccountEntity(
                ID,
                null,
                CustomerEntityInstanceProvider.createValidCustomerEntity(),
                CreditEntityInstanceProvider.createValidCreditEntity()
        ));

        invalidAccounts.add(new AccountEntity(
                ID,
                StringUtils.EMPTY,
                CustomerEntityInstanceProvider.createValidCustomerEntity(),
                CreditEntityInstanceProvider.createValidCreditEntity()
        ));

        // Customer is null or is invalid

        invalidAccounts.add(new AccountEntity(
                ID,
                CURRENT_ACCOUNT_ID,
                null,
                CreditEntityInstanceProvider.createValidCreditEntity()
        ));

        for (CustomerEntity invalidCustomer : CustomerEntityInstanceProvider.createInvalidCustomers()) {

            invalidAccounts.add(new AccountEntity(
                    ID,
                    CURRENT_ACCOUNT_ID,
                    invalidCustomer,
                    CreditEntityInstanceProvider.createValidCreditEntity()
            ));
        }

        // Credit is null or is invalid

        invalidAccounts.add(new AccountEntity(
                ID,
                CURRENT_ACCOUNT_ID,
                CustomerEntityInstanceProvider.createValidCustomerEntity(),
                null
        ));

        for (CreditEntity invalidCredit : CreditEntityInstanceProvider.createInvalidCredits()) {

            invalidAccounts.add(new AccountEntity(
                    ID,
                    CURRENT_ACCOUNT_ID,
                    CustomerEntityInstanceProvider.createValidCustomerEntity(),
                    invalidCredit
            ));
        }

        return invalidAccounts;
    }
}
