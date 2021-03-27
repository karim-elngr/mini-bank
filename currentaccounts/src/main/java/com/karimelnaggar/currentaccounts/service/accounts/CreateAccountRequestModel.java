package com.karimelnaggar.currentaccounts.service.accounts;

public class CreateAccountRequestModel {

    private String currentAccountId;

    private CustomerIdentifierModel customer;

    private InitialCreditModel initialCredit;

    public CreateAccountRequestModel() {

    }

    public CreateAccountRequestModel(String currentAccountId, CustomerIdentifierModel customer, InitialCreditModel initialCredit) {
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

    public CustomerIdentifierModel getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerIdentifierModel customer) {
        this.customer = customer;
    }

    public InitialCreditModel getInitialCredit() {
        return initialCredit;
    }

    public void setInitialCredit(InitialCreditModel initialCredit) {
        this.initialCredit = initialCredit;
    }
}
