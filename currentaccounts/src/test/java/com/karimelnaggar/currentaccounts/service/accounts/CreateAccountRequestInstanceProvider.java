package com.karimelnaggar.currentaccounts.service.accounts;

import org.testcontainers.shaded.org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CreateAccountRequestInstanceProvider {

    private static final String CURRENT_ACCOUNT_ID = "currentAccountId#1";

    public static CreateAccountRequest createValidCreateAccountRequest() {

        return new CreateAccountRequest(
                CURRENT_ACCOUNT_ID,
                CustomerInstanceProvider.createValidCustomer(),
                CreditInstanceProvider.createValidCredit()
        );
    }

    public static List<CreateAccountRequest> createInvalidCreateAccountRequests() {

        final ArrayList<CreateAccountRequest> invalidCreateAccountRequests = new ArrayList<>();

        // Current account id is null or is empty

        invalidCreateAccountRequests.add(new CreateAccountRequest(null,
                CustomerInstanceProvider.createValidCustomer(),
                CreditInstanceProvider.createValidCredit()));

        invalidCreateAccountRequests.add(new CreateAccountRequest(StringUtils.EMPTY,
                CustomerInstanceProvider.createValidCustomer(),
                CreditInstanceProvider.createValidCredit()));

        // Customer is null or is invalid

        invalidCreateAccountRequests.add(new CreateAccountRequest(CURRENT_ACCOUNT_ID,
                null,
                CreditInstanceProvider.createValidCredit()));

        for (Customer invalidCustomer : CustomerInstanceProvider.createInvalidCustomers()) {

            invalidCreateAccountRequests.add(new CreateAccountRequest(CURRENT_ACCOUNT_ID,
                    invalidCustomer,
                    CreditInstanceProvider.createValidCredit()));
        }

        // Credit is null or is invalid

        invalidCreateAccountRequests.add(new CreateAccountRequest(CURRENT_ACCOUNT_ID,
                CustomerInstanceProvider.createValidCustomer(),
                null));

        for (Credit invalidCredit : CreditInstanceProvider.createInvalidCredits()) {

            invalidCreateAccountRequests.add(new CreateAccountRequest(CURRENT_ACCOUNT_ID,
                    CustomerInstanceProvider.createValidCustomer(),
                    invalidCredit));
        }

        return invalidCreateAccountRequests;
    }
}
