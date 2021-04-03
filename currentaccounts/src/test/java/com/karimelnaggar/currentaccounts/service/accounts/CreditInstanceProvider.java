package com.karimelnaggar.currentaccounts.service.accounts;

import org.javamoney.moneta.Money;

import java.math.BigDecimal;
import java.util.List;

public class CreditInstanceProvider {

    private static final String CURRENCY_CODE = "EUR";
    private static final BigDecimal AMOUNT = BigDecimal.TEN;

    public static Credit createValidCredit() {

        return new Credit(Money.of(AMOUNT, CURRENCY_CODE));
    }

    public static List<Credit> createInvalidCredits() {

        return List.of(new Credit(null));
    }
}
