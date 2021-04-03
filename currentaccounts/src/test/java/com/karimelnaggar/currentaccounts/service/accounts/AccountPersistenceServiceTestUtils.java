package com.karimelnaggar.currentaccounts.service.accounts;

import com.karimelnaggar.currentaccounts.persistence.AccountEntity;
import com.karimelnaggar.currentaccounts.persistence.CreditEntity;
import com.karimelnaggar.currentaccounts.persistence.CustomerEntity;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountPersistenceServiceTestUtils {

    public static void assertAccountEntityIsSameAsAccount(AccountEntity accountEntity, Account account) {

        assertThat(accountEntity).isNotNull();
        assertThat(accountEntity.getCurrentAccountId()).isEqualTo(account.getCurrentAccountId());

        assertCustomerEntityIsSameAsCustomer(accountEntity.getCustomerEntity(), account.getCustomer());

        assertCreditEntityIsSameAsCredit(accountEntity.getCreditEntity(), account.getCredit());
    }

    private static void assertCustomerEntityIsSameAsCustomer(CustomerEntity customerEntity, Customer customer) {

        assertThat(customerEntity).isNotNull();
        assertThat(customerEntity.getCustomerId()).isEqualTo(customer.getCustomerId());
        assertThat(customerEntity.getFirstName()).isEqualTo(customer.getFirstName());
        assertThat(customerEntity.getSurname()).isEqualTo(customer.getSurname());
    }

    private static void assertCreditEntityIsSameAsCredit(CreditEntity creditEntity, Credit credit) {

        assertThat(creditEntity).isNotNull();
        assertThat(creditEntity.getAmount()).isEqualTo(credit.getBalance().getNumberStripped());
        assertThat(creditEntity.getCurrency()).isEqualTo(credit.getBalance().getCurrency().getCurrencyCode());
    }

    public static void assertAccountIsSameAsAccountEntity(Account account, AccountEntity accountEntity) {

        assertThat(account).isNotNull();
        assertThat(account.getCurrentAccountId()).isEqualTo(accountEntity.getCurrentAccountId());

        assertCustomerIsSameAsCustomerEntity(account.getCustomer(), accountEntity.getCustomerEntity());

        assertCreditIsSameAsCreditEntity(account.getCredit(), accountEntity.getCreditEntity());
    }

    private static void assertCustomerIsSameAsCustomerEntity(Customer customer, CustomerEntity customerEntity) {

        assertThat(customer).isNotNull();
        assertThat(customer.getCustomerId()).isEqualTo(customerEntity.getCustomerId());
        assertThat(customer.getFirstName()).isEqualTo(customerEntity.getFirstName());
        assertThat(customer.getSurname()).isEqualTo(customerEntity.getSurname());
    }

    private static void assertCreditIsSameAsCreditEntity(Credit credit, CreditEntity creditEntity) {

        assertThat(credit).isNotNull();
        assertThat(credit.getBalance().getNumberStripped()).isEqualByComparingTo(creditEntity.getAmount());
        assertThat(credit.getBalance().getCurrency().getCurrencyCode()).isEqualTo(creditEntity.getCurrency());
    }
}
