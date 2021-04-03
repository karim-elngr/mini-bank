package com.karimelnaggar.currentaccounts.api.accounts;

import java.util.List;

public class CreateAccountRequestDtoInstanceProvider {

    public static CreateAccountRequestDto createValidRequest() {

        return new CreateAccountRequestDto(
                "currentAccountId#1",
                new CustomerDto(
                        "customerId#1",
                        "karim",
                        "elnaggar"),
                new CreditDto(
                        "500.05",
                        "EUR"
                )
        );
    }

    public static List<CreateAccountRequestDto> createInvalidRequests() {

        return List.of(

                // Current account id is null
                new CreateAccountRequestDto(
                        null,
                        new CustomerDto(
                                "customerId#1",
                                "karim",
                                "elnaggar"),
                        new CreditDto(
                                "500",
                                "EUR"
                        )
                ),

                // Customer is null
                new CreateAccountRequestDto(
                        "currentAccountId#1",
                        null,
                        new CreditDto(
                                "500",
                                "EUR"
                        )
                ),

                // Initial credit is null
                new CreateAccountRequestDto(
                        "currentAccountId#1",
                        new CustomerDto(
                                "customerId#1",
                                "karim",
                                "elnaggar"),
                        null
                ),

                // Current account id is empty
                new CreateAccountRequestDto(
                        " ",
                        new CustomerDto(
                                "customerId#1",
                                "karim",
                                "elnaggar"),
                        new CreditDto(
                                "500",
                                "EUR"
                        )
                ),

                // Customer id is null
                new CreateAccountRequestDto(
                        "currentAccountId#1",
                        new CustomerDto(
                                null,
                                "karim",
                                "elnaggar"),
                        new CreditDto(
                                "500",
                                "EUR"
                        )
                ),

                // Customer id is empty
                new CreateAccountRequestDto(
                        "currentAccountId#1",
                        new CustomerDto(
                                " ",
                                "karim",
                                "elnaggar"),
                        new CreditDto(
                                "500",
                                "EUR"
                        )
                ),

                // Customer first name is null
                new CreateAccountRequestDto(
                        "currentAccountId#1",
                        new CustomerDto(
                                "customerId#1",
                                null,
                                "elnaggar"),
                        new CreditDto(
                                "500",
                                "EUR"
                        )
                ),

                // Customer first name is empty
                new CreateAccountRequestDto(
                        "currentAccountId#1",
                        new CustomerDto(
                                "customerId#1",
                                " ",
                                "elnaggar"),
                        new CreditDto(
                                "500",
                                "EUR"
                        )
                ),

                // Customer surname is null
                new CreateAccountRequestDto(
                        "currentAccountId#1",
                        new CustomerDto(
                                "customerId#1",
                                "karim",
                                null),
                        new CreditDto(
                                "500",
                                "EUR"
                        )
                ),

                // Customer surname is empty
                new CreateAccountRequestDto(
                        "currentAccountId#1",
                        new CustomerDto(
                                "customerId#1",
                                "karim",
                                " "),
                        new CreditDto(
                                "500",
                                "EUR"
                        )
                ),

                // Amount is empty
                new CreateAccountRequestDto(
                        "currentAccountId#1",
                        new CustomerDto(
                                "customerId#1",
                                "karim",
                                "elnaggar"),
                        new CreditDto(
                                " ",
                                "EUR"
                        )
                ),

                // Currency is empty
                new CreateAccountRequestDto(
                        "currentAccountId#1",
                        new CustomerDto(
                                "customerId#1",
                                "karim",
                                "elnaggar"),
                        new CreditDto(
                                "500",
                                " "
                        )
                ),

                // Amount is not a number
                new CreateAccountRequestDto(
                        "currentAccountId#1",
                        new CustomerDto(
                                "customerId#1",
                                "karim",
                                "elnaggar"),
                        new CreditDto(
                                "AD",
                                "EUR"
                        )
                ),

                // Currency is not a valid currency
                new CreateAccountRequestDto(
                        "currentAccountId#1",
                        new CustomerDto(
                                "customerId#1",
                                "karim",
                                "elnaggar"),
                        new CreditDto(
                                "500",
                                "EURR"
                        )
                )
        );
    }
}
