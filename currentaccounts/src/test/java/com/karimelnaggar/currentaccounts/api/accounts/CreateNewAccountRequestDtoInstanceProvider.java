package com.karimelnaggar.currentaccounts.api.accounts;

final class CreateNewAccountRequestDtoInstanceProvider {

    static final String CUSTOMER_ID = "customerId#1";
    static final String CREDIT_AMOUNT = "1500";
    static final String CREDIT_CURRENCY = "EUR";

    static CreateNewAccountRequestDto createWithFullPayload() {

        return new CreateNewAccountRequestDto(
                new CustomerDto(
                        CUSTOMER_ID
                ),
                new CreditDto(
                        CREDIT_AMOUNT,
                        CREDIT_CURRENCY
                )
        );
    }
}
