package com.karimelnaggar.currentaccounts.service.accounts;

import com.karimelnaggar.currentaccounts.persistence.AccountEntity;
import com.karimelnaggar.currentaccounts.persistence.CreditEntity;
import com.karimelnaggar.currentaccounts.persistence.CustomerEntity;
import org.javamoney.moneta.Money;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Objects;

import static com.google.common.base.Preconditions.checkArgument;

@Component
public class AccountEntityConverter {

    public AccountEntity toEntity(Account account) {

        checkArgument(Objects.nonNull(account), "account cannot be null");
        checkArgument(StringUtils.hasText(account.getCurrentAccountId()), "current account id cannot be empty");

        return AccountEntity.builder()
                .currentAccountId(account.getCurrentAccountId())
                .customerEntity(toEntity(account.getCustomer()))
                .creditEntity(toEntity(account.getCredit()))
                .build();
    }

    private CustomerEntity toEntity(Customer customer) {

        checkArgument(Objects.nonNull(customer), "customer cannot be null");
        checkArgument(StringUtils.hasText(customer.getCustomerId()), "customer id cannot be empty");
        checkArgument(StringUtils.hasText(customer.getFirstName()), "customer first name cannot be empty");
        checkArgument(StringUtils.hasText(customer.getSurname()), "customer surname cannot be empty");

        return CustomerEntity.builder()
                .customerId(customer.getCustomerId())
                .firstName(customer.getFirstName())
                .surname(customer.getSurname())
                .build();
    }

    private CreditEntity toEntity(Credit credit) {

        checkArgument(Objects.nonNull(credit), "credit cannot be null");
        checkArgument(Objects.nonNull(credit.getBalance()), "credit balance cannot be null");

        final Money balance = credit.getBalance();

        return CreditEntity.builder()
                .amount(balance.getNumberStripped())
                .currency(balance.getCurrency().getCurrencyCode())
                .build();
    }
}
