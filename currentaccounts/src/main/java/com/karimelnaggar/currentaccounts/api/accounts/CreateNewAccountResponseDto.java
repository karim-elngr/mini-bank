package com.karimelnaggar.currentaccounts.api.accounts;

class CreateNewAccountResponseDto {

    private String accountId;

    private CustomerDto customer;

    private CreditDto credit;

    public CreateNewAccountResponseDto() {

    }

    public CreateNewAccountResponseDto(String accountId, CustomerDto customer, CreditDto credit) {
        this.accountId = accountId;
        this.customer = customer;
        this.credit = credit;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public CustomerDto getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDto customer) {
        this.customer = customer;
    }

    public CreditDto getCredit() {
        return credit;
    }

    public void setCredit(CreditDto credit) {
        this.credit = credit;
    }
}
