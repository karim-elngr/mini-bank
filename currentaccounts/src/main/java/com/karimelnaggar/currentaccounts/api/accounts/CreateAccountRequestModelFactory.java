package com.karimelnaggar.currentaccounts.api.accounts;

import com.karimelnaggar.currentaccounts.service.accounts.CreateAccountRequestModel;
import com.karimelnaggar.currentaccounts.service.accounts.CustomerIdentifierModel;
import com.karimelnaggar.currentaccounts.service.accounts.InitialCreditModel;
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
public class CreateAccountRequestModelFactory {

    public CreateAccountRequestModel newCreateAccountRequestModel(CreateAccountRequestDto request) {

        checkArgument(Objects.nonNull(request), "request cannot be null");
        checkArgument(StringUtils.hasText(request.getCurrentAccountId()), "current account id cannot be null");

        final CustomerIdentifierModel customerIdentifierModel = createCustomerIdentifierModel(request);

        final InitialCreditModel initialCreditModel = createInitialCreditModel(request);

        return new CreateAccountRequestModel(
                request.getCurrentAccountId(),
                customerIdentifierModel,
                initialCreditModel
        );
    }

    private CustomerIdentifierModel createCustomerIdentifierModel(CreateAccountRequestDto request) {

        checkArgument(Objects.nonNull(request.getCustomer()), "customer cannot be null");
        checkArgument(StringUtils.hasText(request.getCustomer().getCustomerId()), "customer id cannot be null");

        return new CustomerIdentifierModel(request.getCustomer().getCustomerId());
    }

    private InitialCreditModel createInitialCreditModel(CreateAccountRequestDto request) {

        checkArgument(Objects.nonNull(request.getInitialCredit()), "initial credit cannot be null");
        checkArgument(StringUtils.hasText(request.getInitialCredit().getAmount()), "amount cannot be null");
        checkArgument(StringUtils.hasText(request.getInitialCredit().getCurrency()), "currency cannot be null");

        try {
            final BigDecimal amount = new BigDecimal(request.getInitialCredit().getAmount());
            final CurrencyUnit currencyUnit = Monetary.getCurrency(request.getInitialCredit().getCurrency());

            return new InitialCreditModel(Money.of(amount, currencyUnit));

        } catch (final NumberFormatException | UnknownCurrencyException exception) {

            throw new IllegalArgumentException("amount or currency are not properly formatted", exception);
        }
    }
}
