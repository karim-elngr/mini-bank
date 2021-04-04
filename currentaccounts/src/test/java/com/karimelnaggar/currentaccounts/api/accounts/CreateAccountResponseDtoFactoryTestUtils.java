package com.karimelnaggar.currentaccounts.api.accounts;

import com.karimelnaggar.currentaccounts.service.accounts.Account;
import com.karimelnaggar.currentaccounts.service.accounts.Credit;
import com.karimelnaggar.currentaccounts.service.accounts.Customer;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateAccountResponseDtoFactoryTestUtils {

    public static void assertCreateAccountResponseDtoIsCreatedFromAccount(CreateAccountResponseDto responseDto, Account account) {

        assertThat(responseDto).isNotNull();
        assertThat(responseDto.getCurrentAccountId()).isEqualTo(account.getCurrentAccountId());

        assertCustomerDtoIsCreatedFromCustomerModel(responseDto.getCustomer(), account.getCustomer());

        assertCreditDtoIsCreatedFromCreditModel(responseDto.getCredit(), account.getCredit());

    }

    private static void assertCustomerDtoIsCreatedFromCustomerModel(CustomerDto customerDto, Customer customer) {

        assertThat(customerDto).isNotNull();
        assertThat(customerDto.getCustomerId()).isEqualTo(customer.getCustomerId());
        assertThat(customerDto.getFirstName()).isEqualTo(customer.getFirstName());
        assertThat(customerDto.getSurname()).isEqualTo(customer.getSurname());
    }

    private static void assertCreditDtoIsCreatedFromCreditModel(CreditDto creditDto, Credit credit) {

        assertThat(creditDto).isNotNull();
        assertThat(creditDto.getAmount()).isEqualTo(credit.getBalance().getNumberStripped().toString());
        assertThat(creditDto.getCurrency()).isEqualTo(credit.getBalance().getCurrency().getCurrencyCode());
    }
}
