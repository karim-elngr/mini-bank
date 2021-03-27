package com.karimelnaggar.currentaccounts.api.accounts;

import com.karimelnaggar.currentaccounts.service.accounts.CreateAccountRequestModel;
import com.karimelnaggar.currentaccounts.service.accounts.CustomerIdentifierModel;
import com.karimelnaggar.currentaccounts.service.accounts.InitialCreditModel;
import org.javamoney.moneta.Money;
import org.springframework.stereotype.Component;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import java.math.BigDecimal;

import static com.google.common.base.Preconditions.checkNotNull;

@Component
public class CreateAccountRequestModelFactory {

    public CreateAccountRequestModel newCreateAccountRequestModel(CreateAccountRequestDto request) {

        checkNotNull(request);

        final CustomerIdentifierModel customerIdentifierModel = createCustomerIdentifierModel(request);

        final InitialCreditModel initialCreditModel = createInitialCreditModel(request);

        return new CreateAccountRequestModel(
                request.getCurrentAccountId(),
                customerIdentifierModel,
                initialCreditModel
        );
    }

    private CustomerIdentifierModel createCustomerIdentifierModel(CreateAccountRequestDto request) {

        checkNotNull(request.getCustomer());

        return new CustomerIdentifierModel(request.getCustomer().getCustomerId());
    }

    private InitialCreditModel createInitialCreditModel(CreateAccountRequestDto request) {

        checkNotNull(request.getInitialCredit());

        final BigDecimal amount = new BigDecimal(request.getInitialCredit().getAmount());
        final CurrencyUnit currencyUnit = Monetary.getCurrency(request.getInitialCredit().getCurrency());

        return new InitialCreditModel(Money.of(amount, currencyUnit));
    }
}
