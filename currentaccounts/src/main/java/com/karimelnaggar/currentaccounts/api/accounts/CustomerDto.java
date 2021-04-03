package com.karimelnaggar.currentaccounts.api.accounts;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
class CustomerDto {

    @NotEmpty
    private String customerId;

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String surname;
}
