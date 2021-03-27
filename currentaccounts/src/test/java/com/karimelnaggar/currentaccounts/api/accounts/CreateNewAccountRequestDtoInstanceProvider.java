package com.karimelnaggar.currentaccounts.api.accounts;

final class CreateNewAccountRequestDtoInstanceProvider {

    static final String CURRENT_ACCOUNT_ID = "currentAccountId#1";
    static final String CUSTOMER_ID = "customerId#1";
    static final String CREDIT_AMOUNT = "1500";
    static final String CREDIT_CURRENCY = "EUR";

    static CreateAccountRequestDto createWithFullPayload() {

        return new CreateAccountRequestDto(
                CURRENT_ACCOUNT_ID,
                new CustomerIdentifierDto(
                        CUSTOMER_ID
                ),
                new InitialCreditDto(
                        CREDIT_AMOUNT,
                        CREDIT_CURRENCY
                )
        );
    }
}
