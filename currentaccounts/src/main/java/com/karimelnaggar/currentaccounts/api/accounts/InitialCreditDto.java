package com.karimelnaggar.currentaccounts.api.accounts;

import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

class InitialCreditDto {

    @NotNull
    @NumberFormat
    private String amount;

    @NotEmpty
    private String currency;

    public InitialCreditDto() {

    }

    public InitialCreditDto(@NotNull String amount, @NotEmpty String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
