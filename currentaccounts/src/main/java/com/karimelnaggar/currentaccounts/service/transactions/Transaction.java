package com.karimelnaggar.currentaccounts.service.transactions;

import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {

    private String transactionId;
    private String currentAccountId;
    private BigDecimal amount;
    private String currencyCode;
}
