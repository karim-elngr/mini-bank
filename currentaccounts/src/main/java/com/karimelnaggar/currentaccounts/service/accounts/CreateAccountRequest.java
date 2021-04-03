package com.karimelnaggar.currentaccounts.service.accounts;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateAccountRequest {

    private String currentAccountId;

    private Customer customer;

    private Credit initialCredit;
}
