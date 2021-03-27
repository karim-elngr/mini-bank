package com.karimelnaggar.currentaccounts.api.accounts;

class CreateAccountResponseDto {

    private String currentAccountId;

    private CustomerIdentifierDto customer;

    private InitialCreditDto credit;

    public CreateAccountResponseDto() {

    }

    public CreateAccountResponseDto(String currentAccountId, CustomerIdentifierDto customer, InitialCreditDto credit) {
        this.currentAccountId = currentAccountId;
        this.customer = customer;
        this.credit = credit;
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

    public InitialCreditDto getCredit() {
        return credit;
    }

    public void setCredit(InitialCreditDto credit) {
        this.credit = credit;
    }
}
