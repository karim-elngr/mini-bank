package com.karimelnaggar.currentaccounts.api.accounts;

import javax.validation.constraints.NotEmpty;

class CustomerIdentifierDto {

    @NotEmpty
    private String customerId;

    public CustomerIdentifierDto() {

    }

    public CustomerIdentifierDto(@NotEmpty String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}
