package com.karimelnaggar.currentaccounts.api.accounts;

import javax.validation.constraints.NotEmpty;

class CustomerDto {

    @NotEmpty
    private String customerId;

    public CustomerDto() {

    }

    public CustomerDto(@NotEmpty String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}
