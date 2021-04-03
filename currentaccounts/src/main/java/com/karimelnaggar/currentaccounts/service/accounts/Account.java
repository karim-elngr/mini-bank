package com.karimelnaggar.currentaccounts.service.accounts;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Account {

    private String currentAccountId;

    private Customer customer;

    private Credit credit;
}
