package com.karimelnaggar.currentaccounts.api.accounts;

import com.karimelnaggar.currentaccounts.service.accounts.Account;
import com.karimelnaggar.currentaccounts.service.accounts.CreateAccountFacade;
import com.karimelnaggar.currentaccounts.service.accounts.CreateAccountRequestModel;
import org.springframework.stereotype.Component;

import static com.google.common.base.Preconditions.checkNotNull;

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

        checkNotNull(request);

        final CreateAccountRequestModel createAccountRequestModel = createAccountRequestModelFactory.newCreateAccountRequestModel(request);

        final Account account = createAccountFacade.createNewAccount(createAccountRequestModel);

        return createAccountResponseDtoFactory.newCreateAccountResponseDto(account);
    }
}
