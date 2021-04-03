package com.karimelnaggar.currentaccounts.service.accounts;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.karimelnaggar.currentaccounts.service.accounts.AccountFactoryTestUtils.assertAccountIsCreatedFromCreateAccountRequest;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@ExtendWith(MockitoExtension.class)
class AccountsFactoryUnitTests {

    @InjectMocks
    private AccountsFactory accountsFactory;

    @ParameterizedTest
    @NullSource
    @MethodSource("com.karimelnaggar.currentaccounts.service.accounts.CreateAccountRequestInstanceProvider#createInvalidCreateAccountRequests")
    void createNewAccount_whenArgumentsAreInvalid_throwsIllegalArgumentException(CreateAccountRequest createAccountRequest) {

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> accountsFactory.createNewAccount(createAccountRequest));
    }

    @Test
    void createNewAccount_whenArgumentIsValid_returnCorrectAccount() {

        final CreateAccountRequest createAccountRequest = CreateAccountRequestInstanceProvider.createValidCreateAccountRequest();

        final Account account = accountsFactory.createNewAccount(createAccountRequest);

        assertAccountIsCreatedFromCreateAccountRequest(account, createAccountRequest);
    }
}
