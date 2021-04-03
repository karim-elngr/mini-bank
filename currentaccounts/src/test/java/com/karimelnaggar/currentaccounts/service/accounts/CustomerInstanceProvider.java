package com.karimelnaggar.currentaccounts.service.accounts;

import org.testcontainers.shaded.org.apache.commons.lang.StringUtils;

import java.util.List;

public class CustomerInstanceProvider {

    private static final String CUSTOMER_ID = "customerId#1";
    private static final String FIRST_NAME = "karim";
    private static final String SURNAME = "elnaggar";

    public static Customer createValidCustomer() {

        return new Customer(
                CUSTOMER_ID,
                FIRST_NAME,
                SURNAME
        );
    }

    public static List<Customer> createInvalidCustomers() {

        return List.of(
                // Customer id is null or empty
                new Customer(
                        null,
                        FIRST_NAME,
                        SURNAME
                ),
                new Customer(
                        StringUtils.EMPTY,
                        FIRST_NAME,
                        SURNAME
                ),
                // First name is null or empty
                new Customer(
                        CUSTOMER_ID,
                        null,
                        SURNAME
                ),
                new Customer(
                        CUSTOMER_ID,
                        StringUtils.EMPTY,
                        SURNAME
                ),
                // Surname is null or empty
                new Customer(
                        CUSTOMER_ID,
                        FIRST_NAME,
                        null
                ),
                new Customer(
                        CUSTOMER_ID,
                        FIRST_NAME,
                        StringUtils.EMPTY
                )
        );
    }
}
