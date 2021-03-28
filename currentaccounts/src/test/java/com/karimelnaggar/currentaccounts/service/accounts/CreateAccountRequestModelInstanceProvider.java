package com.karimelnaggar.currentaccounts.service.accounts;

import com.karimelnaggar.currentaccounts.service.model.CreateAccountRequestModel;
import com.karimelnaggar.currentaccounts.service.model.CustomerIdentifierModel;
import com.karimelnaggar.currentaccounts.service.model.InitialCreditModel;
import org.javamoney.moneta.Money;

import java.math.BigDecimal;

public class CreateAccountRequestModelInstanceProvider {

    public static CreateAccountRequestModel createValidModel() {

        return new CreateAccountRequestModel(
                "currentAccountId",
                new CustomerIdentifierModel(
                        "customerId#1"
                ),
                new InitialCreditModel(
                        Money.of(new BigDecimal("500.05"), "EUR")
                )
        );
    }
}
