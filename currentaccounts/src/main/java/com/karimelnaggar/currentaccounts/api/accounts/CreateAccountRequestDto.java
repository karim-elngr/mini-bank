package com.karimelnaggar.currentaccounts.api.accounts;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
class CreateAccountRequestDto {

    @NotEmpty
    private String currentAccountId;

    @Valid
    @NotNull
    private CustomerDto customer;

    @Valid
    @NotNull
    private CreditDto initialCredit;
}
