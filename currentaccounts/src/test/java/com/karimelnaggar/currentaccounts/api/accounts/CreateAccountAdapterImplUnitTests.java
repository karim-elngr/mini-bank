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
class CreateAccountAdapterImplUnitTests {

    @InjectMocks
    private CreateAccountAdapterImpl createAccountAdapter;

    @Mock
    private CreateAccountRequestModelFactory createAccountRequestModelFactory;

    @Mock
    private CreateAccountFacade createAccountFacade;

    @Mock
    private CreateAccountResponseDtoFactory createAccountResponseDtoFactory;

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
        doReturn(expectedAccount).when(createAccountFacade).createNewAccount(expectedRequestModel);

        final CreateAccountResponseDto expectedResponse = CreateAccountResponseDtoInstanceProvider.createValidResponse();
        doReturn(expectedResponse).when(createAccountResponseDtoFactory).newCreateAccountResponseDto(expectedAccount);

        final CreateAccountResponseDto actualResponse = createAccountAdapter.createAccount(requestDto);

        assertThat(actualResponse).isEqualTo(expectedResponse);
    }
}
