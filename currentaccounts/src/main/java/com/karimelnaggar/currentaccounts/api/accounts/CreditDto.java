package com.karimelnaggar.currentaccounts.api.accounts;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
class CreditDto {

    @NotNull
    @NumberFormat
    private String amount;

    @NotEmpty
    private String currency;
}
