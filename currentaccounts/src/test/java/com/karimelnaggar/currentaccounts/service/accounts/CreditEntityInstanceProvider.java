package com.karimelnaggar.currentaccounts.service.accounts;

import com.karimelnaggar.currentaccounts.persistence.CreditEntity;
import org.testcontainers.shaded.org.apache.commons.lang.StringUtils;

import java.math.BigDecimal;
import java.util.List;

public class CreditEntityInstanceProvider {

    private static final String CURRENCY_CODE = "EUR";
    private static final BigDecimal AMOUNT = BigDecimal.TEN;

    public static CreditEntity createValidCreditEntity() {

        return new CreditEntity(AMOUNT, CURRENCY_CODE);
    }

    public static List<CreditEntity> createInvalidCredits() {

        return List.of(
                new CreditEntity(),
                new CreditEntity(null, CURRENCY_CODE),
                new CreditEntity(AMOUNT, null),
                new CreditEntity(AMOUNT, StringUtils.EMPTY)
        );
    }
}
