package com.karimelnaggar.currentaccounts.api.accounts;

import com.karimelnaggar.currentaccounts.service.accounts.Account;
import com.karimelnaggar.currentaccounts.service.accounts.Credit;
import com.karimelnaggar.currentaccounts.service.accounts.Customer;
import org.springframework.stereotype.Component;

import java.util.Objects;

import static com.google.common.base.Preconditions.checkArgument;

@Component
class CreateAccountResponseDtoFactory {

    public CreateAccountResponseDto newCreateAccountResponseDto(Account account) {

        checkArgument(Objects.nonNull(account), "account cannot be null");

        return new CreateAccountResponseDto(
                account.getCurrentAccountId(),
                createCustomerIdentifierDto(account.getCustomer()),
                createInitialCreditDto(account.getCredit())
        );
    }

    private CustomerDto createCustomerIdentifierDto(Customer customerModel) {

        checkArgument(Objects.nonNull(customerModel), "customer cannot be null");

        return new CustomerDto(
                customerModel.getCustomerId(),
                customerModel.getFirstName(),
                customerModel.getSurname()
        );
    }

    private CreditDto createInitialCreditDto(Credit credit) {

        checkArgument(Objects.nonNull(credit), "balance cannot be null");

        return new CreditDto(
                credit.getBalance().getNumber().toString(),
                credit.getBalance().getCurrency().toString()
        );
    }
}
