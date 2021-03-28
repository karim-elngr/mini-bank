package com.karimelnaggar.currentaccounts.api.accounts;

import com.karimelnaggar.currentaccounts.service.model.Account;
import com.karimelnaggar.currentaccounts.service.accounts.CreateAccountFacade;
import com.karimelnaggar.currentaccounts.service.model.CreateAccountRequestModel;
import org.springframework.stereotype.Component;

import java.util.Objects;

import static com.google.common.base.Preconditions.checkArgument;

@Component
class CreateAccountAdapterImpl implements CreateAccountAdapter {

    private final CreateAccountRequestModelFactory createAccountRequestModelFactory;
    private final CreateAccountFacade createAccountFacade;
    private final CreateAccountResponseDtoFactory createAccountResponseDtoFactory;

    public CreateAccountAdapterImpl(
            CreateAccountRequestModelFactory createAccountRequestModelFactory,
            CreateAccountFacade createAccountFacade,
            CreateAccountResponseDtoFactory createAccountResponseDtoFactory
    ) {
        this.createAccountRequestModelFactory = createAccountRequestModelFactory;
        this.createAccountFacade = createAccountFacade;
        this.createAccountResponseDtoFactory = createAccountResponseDtoFactory;
    }

    @Override
    public CreateAccountResponseDto createAccount(CreateAccountRequestDto request) {

        checkArgument(Objects.nonNull(request), "request cannot be null");

        final CreateAccountRequestModel createAccountRequestModel = createAccountRequestModelFactory.newCreateAccountRequestModel(request);

        final Account account = createAccountFacade.createNewAccount(createAccountRequestModel);

        return createAccountResponseDtoFactory.newCreateAccountResponseDto(account);
    }
}
