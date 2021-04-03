package com.karimelnaggar.currentaccounts.service.accounts;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.javamoney.moneta.Money;

@Data
@AllArgsConstructor
public class Credit {

    private Money balance;
}
