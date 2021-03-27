package com.karimelnaggar.currentaccounts.api.accounts;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

class CreateAccountRequestDto {

    @NotEmpty
    private String currentAccountId;

    @Valid
    @NotNull
    private CustomerIdentifierDto customer;

    @Valid
    @NotNull
    private InitialCreditDto initialCredit;

    public CreateAccountRequestDto() {

    }

    public CreateAccountRequestDto(@NotEmpty String currentAccountId, @Valid @NotNull CustomerIdentifierDto customer, @Valid @NotNull InitialCreditDto initialCredit) {
        this.currentAccountId = currentAccountId;
        this.customer = customer;
        this.initialCredit = initialCredit;
    }

    public String getCurrentAccountId() {
        return currentAccountId;
    }

    public void setCurrentAccountId(String currentAccountId) {
        this.currentAccountId = currentAccountId;
    }

    public CustomerIdentifierDto getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerIdentifierDto customer) {
        this.customer = customer;
    }

    public InitialCreditDto getInitialCredit() {
        return initialCredit;
    }

    public void setInitialCredit(InitialCreditDto initialCredit) {
        this.initialCredit = initialCredit;
    }
}
