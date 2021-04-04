package com.karimelnaggar.currentaccounts.service.accounts;

import com.karimelnaggar.currentaccounts.persistence.CustomerEntity;
import org.testcontainers.shaded.org.apache.commons.lang.StringUtils;

import java.util.List;

public class CustomerEntityInstanceProvider {

    private static final String CUSTOMER_ID = "customerId#1";
    private static final String FIRST_NAME = "karim";
    private static final String SURNAME = "elnaggar";

    public static CustomerEntity createValidCustomerEntity() {

        return new CustomerEntity(
                CUSTOMER_ID,
                FIRST_NAME,
                SURNAME
        );
    }

    public static List<CustomerEntity> createInvalidCustomers() {

        return List.of(
                new CustomerEntity(),
                // Customer id is null or empty
                new CustomerEntity(
                        null,
                        FIRST_NAME,
                        SURNAME
                ),
                new CustomerEntity(
                        StringUtils.EMPTY,
                        FIRST_NAME,
                        SURNAME
                ),
                // First name is null or empty
                new CustomerEntity(
                        CUSTOMER_ID,
                        null,
                        SURNAME
                ),
                new CustomerEntity(
                        CUSTOMER_ID,
                        StringUtils.EMPTY,
                        SURNAME
                ),
                // Surname is null or empty
                new CustomerEntity(
                        CUSTOMER_ID,
                        FIRST_NAME,
                        null
                ),
                new CustomerEntity(
                        CUSTOMER_ID,
                        FIRST_NAME,
                        StringUtils.EMPTY
                )
        );
    }
}
