package com.karimelnaggar.currentaccounts.api.accounts;

import com.karimelnaggar.currentaccounts.service.accounts.Account;
import com.karimelnaggar.currentaccounts.service.accounts.CreateAccountFacade;
import com.karimelnaggar.currentaccounts.service.accounts.CreateAccountRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Objects;

import static com.google.common.base.Preconditions.checkArgument;

@Component
@AllArgsConstructor
class CreateAccountAdapterImpl implements CreateAccountAdapter {

    private final CreateAccountRequestModelFactory createAccountRequestModelFactory;
    private final CreateAccountFacade createAccountFacade;
    private final CreateAccountResponseDtoFactory createAccountResponseDtoFactory;

    @Override
    public CreateAccountResponseDto createAccount(CreateAccountRequestDto request) {

        checkArgument(Objects.nonNull(request), "request cannot be null");

        final CreateAccountRequest createAccountRequest = createAccountRequestModelFactory.newCreateAccountRequestModel(request);

        final Account account = createAccountFacade.createNewAccount(createAccountRequest);

        return createAccountResponseDtoFactory.newCreateAccountResponseDto(account);
    }
}
