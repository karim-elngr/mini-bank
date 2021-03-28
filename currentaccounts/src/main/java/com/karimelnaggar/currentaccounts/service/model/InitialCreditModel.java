package com.karimelnaggar.currentaccounts.service.model;

import javax.money.MonetaryAmount;

public class InitialCreditModel {

    private MonetaryAmount monetaryAmount;

    public InitialCreditModel() {
    }

    public InitialCreditModel(MonetaryAmount monetaryAmount) {
        this.monetaryAmount = monetaryAmount;
    }

    public MonetaryAmount getMonetaryAmount() {
        return monetaryAmount;
    }

    public void setMonetaryAmount(MonetaryAmount monetaryAmount) {
        this.monetaryAmount = monetaryAmount;
    }
}
