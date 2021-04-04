package com.karimelnaggar.currentaccounts.api.accounts;

import com.karimelnaggar.currentaccounts.service.accounts.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class AccountsServiceAdapterImplUnitTests {

    @InjectMocks
    private AccountsServiceAdapterImpl createAccountAdapter;

    @Mock
    private CreateAccountRequestModelFactory createAccountRequestModelFactory;

    @Mock
    private AccountsFacade accountsFacade;

    @Mock
    private AccountResponseDtoFactory accountResponseDtoFactory;

    @Test
    void createAccount_whenArgumentsAreNull_throwsIllegalArgumentException() {

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> createAccountAdapter.createAccount(null));
    }

    @Test
    void createAccount_whenArgumentsAreValid_createNewAccountAndReturnResponseDto() {

        final CreateAccountRequestDto requestDto = CreateAccountRequestDtoInstanceProvider.createValidRequest();
        final CreateAccountRequest expectedRequestModel = CreateAccountRequestInstanceProvider.createValidCreateAccountRequest();
        doReturn(expectedRequestModel).when(createAccountRequestModelFactory).newCreateAccountRequestModel(requestDto);

        final Account expectedAccount = AccountInstanceProvider.createValidAccount();
        doReturn(expectedAccount).when(accountsFacade).createNewAccount(expectedRequestModel);

        final AccountResponseDto expectedResponse = CreateAccountResponseDtoInstanceProvider.createValidResponse();
        doReturn(expectedResponse).when(accountResponseDtoFactory).createAccountResponseDto(expectedAccount);

        final AccountResponseDto actualResponse = createAccountAdapter.createAccount(requestDto);

        assertThat(actualResponse).isEqualTo(expectedResponse);
    }
}
