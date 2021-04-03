package com.karimelnaggar.currentaccounts.api.accounts;

import com.karimelnaggar.currentaccounts.service.accounts.CreateAccountRequest;
import com.karimelnaggar.currentaccounts.service.accounts.Credit;
import com.karimelnaggar.currentaccounts.service.accounts.Customer;
import org.javamoney.moneta.Money;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.UnknownCurrencyException;
import java.math.BigDecimal;
import java.util.Objects;

import static com.google.common.base.Preconditions.checkArgument;

@Component
class CreateAccountRequestModelFactory {

    public CreateAccountRequest newCreateAccountRequestModel(CreateAccountRequestDto request) {

        checkArgument(Objects.nonNull(request), "request cannot be null");
        checkArgument(StringUtils.hasText(request.getCurrentAccountId()), "current account id cannot be empty");

        final Customer customer = createCustomerIdentifierModel(request);

        final Credit initialCreditModel = createInitialCreditModel(request);

        return new CreateAccountRequest(
                request.getCurrentAccountId(),
                customer,
                initialCreditModel
        );
    }

    private Customer createCustomerIdentifierModel(CreateAccountRequestDto request) {

        checkArgument(Objects.nonNull(request.getCustomer()), "customer cannot be null");
        checkArgument(StringUtils.hasText(request.getCustomer().getCustomerId()), "customer id cannot be empty");
        checkArgument(StringUtils.hasText(request.getCustomer().getFirstName()), "customer first name cannot be empty");
        checkArgument(StringUtils.hasText(request.getCustomer().getSurname()), "customer surname cannot be empty");

        return new Customer(
                request.getCustomer().getCustomerId(),
                request.getCustomer().getFirstName(),
                request.getCustomer().getSurname()
        );
    }

    private Credit createInitialCreditModel(CreateAccountRequestDto request) {

        checkArgument(Objects.nonNull(request.getInitialCredit()), "initial credit cannot be null");
        checkArgument(StringUtils.hasText(request.getInitialCredit().getAmount()), "amount cannot be empty");
        checkArgument(StringUtils.hasText(request.getInitialCredit().getCurrency()), "currency cannot be empty");

        try {
            final BigDecimal amount = new BigDecimal(request.getInitialCredit().getAmount());
            final CurrencyUnit currencyUnit = Monetary.getCurrency(request.getInitialCredit().getCurrency());

            return new Credit(Money.of(amount, currencyUnit));

        } catch (final NumberFormatException | UnknownCurrencyException exception) {

            throw new IllegalArgumentException("amount or currency are not properly formatted", exception);
        }
    }
}
