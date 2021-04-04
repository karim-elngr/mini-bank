package com.karimelnaggar.currentaccounts.service.accounts;

import com.karimelnaggar.currentaccounts.persistence.AccountEntity;
import com.karimelnaggar.currentaccounts.persistence.CreditEntity;
import com.karimelnaggar.currentaccounts.persistence.CustomerEntity;
import org.javamoney.moneta.Money;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.money.UnknownCurrencyException;
import java.util.Objects;

import static com.google.common.base.Preconditions.checkState;

@Component
public class AccountModelConverter {

    public Account toModel(AccountEntity accountEntity) {

        checkState(Objects.nonNull(accountEntity), "account cannot be null");
        checkState(StringUtils.hasText(accountEntity.getCurrentAccountId()), "current account id cannot be empty");

        return new Account(
                accountEntity.getCurrentAccountId(),
                toModel(accountEntity.getCustomerEntity()),
                toModel(accountEntity.getCreditEntity()));
    }

    private Customer toModel(CustomerEntity customerEntity) {

        checkState(Objects.nonNull(customerEntity), "customer cannot be null");
        checkState(StringUtils.hasText(customerEntity.getCustomerId()), "customer id cannot be empty");
        checkState(StringUtils.hasText(customerEntity.getFirstName()), "customer first name cannot be empty");
        checkState(StringUtils.hasText(customerEntity.getSurname()), "customer surname cannot be empty");

        return new Customer(
                customerEntity.getCustomerId(),
                customerEntity.getFirstName(),
                customerEntity.getSurname()
        );
    }

    private Credit toModel(CreditEntity creditEntity) {

        checkState(Objects.nonNull(creditEntity), "credit cannot be null");
        checkState(Objects.nonNull(creditEntity.getAmount()), "amount cannot be null");
        checkState(Objects.nonNull(creditEntity.getCurrency()), "currency cannot be null");

        try {

            final Money balance = Money.of(
                    creditEntity.getAmount(),
                    creditEntity.getCurrency()
            );

            return new Credit(balance);

        } catch (final UnknownCurrencyException exception) {

            throw new IllegalStateException("unexpected unknown currency", exception);
        }
    }
}
