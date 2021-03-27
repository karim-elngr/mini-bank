package com.karimelnaggar.currentaccounts.service.accounts;

public class CustomerIdentifierModel {

    private String customerId;

    public CustomerIdentifierModel() {
    }

    public CustomerIdentifierModel(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}
