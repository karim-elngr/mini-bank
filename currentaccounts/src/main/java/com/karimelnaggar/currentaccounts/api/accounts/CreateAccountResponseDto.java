package com.karimelnaggar.currentaccounts.api.accounts;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
class CreateAccountResponseDto {

    private String currentAccountId;

    private CustomerDto customer;

    private CreditDto credit;
}
