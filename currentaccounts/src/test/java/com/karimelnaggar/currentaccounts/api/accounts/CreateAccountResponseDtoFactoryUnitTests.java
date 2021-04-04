package com.karimelnaggar.currentaccounts.api.accounts;

import com.karimelnaggar.currentaccounts.service.accounts.Account;
import com.karimelnaggar.currentaccounts.service.accounts.AccountInstanceProvider;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.karimelnaggar.currentaccounts.api.accounts.CreateAccountResponseDtoFactoryTestUtils.assertCreateAccountResponseDtoIsCreatedFromAccount;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@ExtendWith(MockitoExtension.class)
class CreateAccountResponseDtoFactoryUnitTests {

    @InjectMocks
    private CreateAccountResponseDtoFactory createAccountResponseDtoFactory;

    @ParameterizedTest
    @NullSource
    @MethodSource("com.karimelnaggar.currentaccounts.service.accounts.AccountInstanceProvider#createInvalidAccounts")
    void newCreateAccountResponseDto_whenArgumentsAreInvalid_throwsIllegalStateException(Account account) {

        assertThatExceptionOfType(IllegalStateException.class).isThrownBy(() -> createAccountResponseDtoFactory.newCreateAccountResponseDto(account));
    }

    @Test
    void newCreateAccountResponseDto_whenArgumentsValid_returnsCorrectCreateAccountResponseDto() {

        final Account account = AccountInstanceProvider.createValidAccount();

        final CreateAccountResponseDto responseDto = createAccountResponseDtoFactory.newCreateAccountResponseDto(account);

        assertCreateAccountResponseDtoIsCreatedFromAccount(responseDto, account);
    }
}
