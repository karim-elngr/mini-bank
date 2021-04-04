package com.karimelnaggar.currentaccounts.persistence;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.math.BigDecimal;

@Embeddable
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreditEntity {

    @Column(name="amount", nullable=false)
    private BigDecimal amount;

    @Column(name="currency", length=3, nullable=false)
    private String currency;
}
