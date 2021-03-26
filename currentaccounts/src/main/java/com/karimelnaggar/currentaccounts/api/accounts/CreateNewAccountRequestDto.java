package com.karimelnaggar.currentaccounts.api.accounts;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

class CreateNewAccountRequestDto {

    @Valid
    @NotNull
    private CustomerDto customer;

    @Valid
    @NotNull
    private CreditDto initialCredit;

    public CreateNewAccountRequestDto() {

    }

    public CreateNewAccountRequestDto(@Valid @NotNull CustomerDto customer, @Valid @NotNull CreditDto initialCredit) {
        this.customer = customer;
        this.initialCredit = initialCredit;
    }

    public CustomerDto getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDto customer) {
        this.customer = customer;
    }

    public CreditDto getInitialCredit() {
        return initialCredit;
    }

    public void setInitialCredit(CreditDto initialCredit) {
        this.initialCredit = initialCredit;
    }
}
