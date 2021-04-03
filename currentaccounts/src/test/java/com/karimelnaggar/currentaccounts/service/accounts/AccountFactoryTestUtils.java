package com.karimelnaggar.currentaccounts.service.accounts;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountFactoryTestUtils {

    public static void assertAccountIsCreatedFromCreateAccountRequest(Account account, CreateAccountRequest createAccountRequest) {

        assertThat(account).isNotNull();
        assertThat(account.getCurrentAccountId()).isEqualTo(createAccountRequest.getCurrentAccountId());

        assertThat(account.getCustomer()).usingRecursiveComparison().isEqualTo(createAccountRequest.getCustomer());

        assertThat(account.getCredit()).usingRecursiveComparison().isEqualTo(createAccountRequest.getInitialCredit());
    }
}
