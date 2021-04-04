package com.karimelnaggar.currentaccounts.api.accounts;

import com.karimelnaggar.currentaccounts.service.accounts.Account;
import com.karimelnaggar.currentaccounts.service.accounts.Credit;
import com.karimelnaggar.currentaccounts.service.accounts.Customer;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Objects;

import static com.google.common.base.Preconditions.checkState;

@Component
class AccountResponseDtoFactory {

    public AccountResponseDto createAccountResponseDto(Account account) {

        checkState(Objects.nonNull(account), "account cannot be null");
        checkState(StringUtils.hasText(account.getCurrentAccountId()), "current account id cannot be empty");

        return new AccountResponseDto(
                account.getCurrentAccountId(),
                createCustomerIdentifierDto(account.getCustomer()),
                createInitialCreditDto(account.getCredit())
        );
    }

    private CustomerDto createCustomerIdentifierDto(Customer customer) {

        checkState(Objects.nonNull(customer), "customer cannot be null");
        checkState(StringUtils.hasText(customer.getCustomerId()), "customer id cannot be empty");
        checkState(StringUtils.hasText(customer.getFirstName()), "customer first name cannot be empty");
        checkState(StringUtils.hasText(customer.getSurname()), "customer surname cannot be empty");

        return new CustomerDto(
                customer.getCustomerId(),
                customer.getFirstName(),
                customer.getSurname()
        );
    }

    private CreditDto createInitialCreditDto(Credit credit) {

        checkState(Objects.nonNull(credit), "credit cannot be null");
        checkState(Objects.nonNull(credit.getBalance()), "credit balance cannot be null");

        return new CreditDto(
                credit.getBalance().getNumberStripped().toString(),
                credit.getBalance().getCurrency().toString()
        );
    }
}
