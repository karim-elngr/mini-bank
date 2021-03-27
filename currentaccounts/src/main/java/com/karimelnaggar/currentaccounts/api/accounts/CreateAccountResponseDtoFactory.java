package com.karimelnaggar.currentaccounts.api.accounts;

import com.karimelnaggar.currentaccounts.service.accounts.Account;
import org.springframework.stereotype.Component;

import static com.google.common.base.Preconditions.checkNotNull;

@Component
public class CreateAccountResponseDtoFactory {

    public CreateAccountResponseDto newCreateAccountResponseDto(Account account) {

        checkNotNull(account);

        return null;
    }
}
