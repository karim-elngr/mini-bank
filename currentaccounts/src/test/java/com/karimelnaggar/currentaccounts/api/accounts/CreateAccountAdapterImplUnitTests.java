package com.karimelnaggar.currentaccounts.api.accounts;

import com.karimelnaggar.currentaccounts.service.accounts.CreateAccountFacade;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

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
    void createAccount_whenArgumentsAreNull_throwsNullPointerException() {

        assertThatExceptionOfType(NullPointerException.class).isThrownBy(() -> createAccountAdapter.createAccount(null));
    }

    @Test
    void createAccount_whenArgumentsAreValid_createNewAccountAndReturnResponseDto() {


    }
}