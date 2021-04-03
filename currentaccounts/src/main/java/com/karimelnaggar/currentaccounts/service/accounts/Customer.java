package com.karimelnaggar.currentaccounts.service.accounts;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Customer {

    private String customerId;

    private String firstName;

    private String surname;
}
