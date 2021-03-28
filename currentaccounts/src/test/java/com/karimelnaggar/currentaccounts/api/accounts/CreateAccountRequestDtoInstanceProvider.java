package com.karimelnaggar.currentaccounts.api.accounts;

import java.util.List;

public class CreateAccountRequestDtoInstanceProvider {

    public static List<CreateAccountRequestDto> createWithInvalidFields() {

        return List.of(

                // Current account id is null
                new CreateAccountRequestDto(
                        null,
                        new CustomerIdentifierDto(
                                "customerId#1"
                        ),
                        new InitialCreditDto(
                                "500",
                                "EUR"
                        )
                ),

                // Customer is null
                new CreateAccountRequestDto(
                        "currentAccountId#1",
                        null,
                        new InitialCreditDto(
                                "500",
                                "EUR"
                        )
                ),

                // Initial credit is null
                new CreateAccountRequestDto(
                        "currentAccountId#1",
                        new CustomerIdentifierDto(
                                "customerId#1"
                        ),
                        null
                ),

                // Current account id is empty
                new CreateAccountRequestDto(
                        " ",
                        new CustomerIdentifierDto(
                                "customerId#1"
                        ),
                        new InitialCreditDto(
                                "500",
                                "EUR"
                        )
                ),

                // Customer id is empty
                new CreateAccountRequestDto(
                        "currentAccountId#1",
                        new CustomerIdentifierDto(
                                " "
                        ),
                        new InitialCreditDto(
                                "500",
                                "EUR"
                        )
                ),

                // Amount is empty
                new CreateAccountRequestDto(
                        "currentAccountId#1",
                        new CustomerIdentifierDto(
                                "customerId#1"
                        ),
                        new InitialCreditDto(
                                " ",
                                "EUR"
                        )
                ),

                // Currency is empty
                new CreateAccountRequestDto(
                        "currentAccountId#1",
                        new CustomerIdentifierDto(
                                "customerId#1"
                        ),
                        new InitialCreditDto(
                                "500",
                                " "
                        )
                ),

                // Amount is not a number
                new CreateAccountRequestDto(
                        "currentAccountId#1",
                        new CustomerIdentifierDto(
                                "customerId#1"
                        ),
                        new InitialCreditDto(
                                "AD",
                                "EUR"
                        )
                ),

                // Currency is not a valid currency
                new CreateAccountRequestDto(
                        "currentAccountId#1",
                        new CustomerIdentifierDto(
                                "customerId#1"
                        ),
                        new InitialCreditDto(
                                "500",
                                "EURR"
                        )
                )
        );
    }

    public static CreateAccountRequestDto createValidRequest() {

        return new CreateAccountRequestDto(
                "currentAccountId#1",
                new CustomerIdentifierDto(
                        "customerId#1"
                ),
                new InitialCreditDto(
                        "500.05",
                        "EUR"
                )
        );
    }
}
