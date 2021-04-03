package com.karimelnaggar.currentaccounts.service.accounts;

import org.javamoney.moneta.Money;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.money.UnknownCurrencyException;
import java.math.BigDecimal;
import java.util.Objects;

import static com.google.common.base.Preconditions.checkArgument;

@Component
class AccountsFactory {

    Account createNewAccount(CreateAccountRequest createAccountRequest) {

        checkArgument(Objects.nonNull(createAccountRequest), "create account request cannot be null");
        checkArgument(StringUtils.hasText(createAccountRequest.getCurrentAccountId()), "current account id cannot be empty");

        final Customer customerModel = createNewCustomer(createAccountRequest.getCustomer());
        final Credit initialCredit = createInitialBalance(createAccountRequest.getInitialCredit());

        return new Account(
                createAccountRequest.getCurrentAccountId(),
                customerModel,
                initialCredit
        );
    }

    private Customer createNewCustomer(Customer customer) {

        checkArgument(Objects.nonNull(customer), "customer cannot be null");
        checkArgument(StringUtils.hasText(customer.getCustomerId()), "customer id cannot be empty");
        checkArgument(StringUtils.hasText(customer.getFirstName()), "customer first name cannot be empty");
        checkArgument(StringUtils.hasText(customer.getSurname()), "customer surname cannot be empty");

        return new Customer(
                customer.getCustomerId(),
                customer.getFirstName(),
                customer.getSurname()
        );
    }

    private Credit createInitialBalance(Credit initialCredit) {

        checkArgument(Objects.nonNull(initialCredit), "initial credit cannot be null");
        checkArgument(Objects.nonNull(initialCredit.getBalance()), "initial credit balance cannot be null");

        try {

            return new Credit(Money.of(BigDecimal.ZERO, initialCredit.getBalance().getCurrency()));

        } catch (final UnknownCurrencyException exception) {

            throw new IllegalArgumentException("currency is not a valid currency", exception);
        }
    }
}
