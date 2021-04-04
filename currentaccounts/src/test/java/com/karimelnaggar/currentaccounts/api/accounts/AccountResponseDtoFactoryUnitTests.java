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
class AccountResponseDtoFactoryUnitTests {

    @InjectMocks
    private AccountResponseDtoFactory accountResponseDtoFactory;

    @ParameterizedTest
    @NullSource
    @MethodSource("com.karimelnaggar.currentaccounts.service.accounts.AccountInstanceProvider#createInvalidAccounts")
    void createAccountResponseDto_whenArgumentsAreInvalid_throwsIllegalStateException(Account account) {

        assertThatExceptionOfType(IllegalStateException.class).isThrownBy(() -> accountResponseDtoFactory.createAccountResponseDto(account));
    }

    @Test
    void createAccountResponseDto_whenArgumentsValid_returnsCorrectAccountResponseDto() {

        final Account account = AccountInstanceProvider.createValidAccount();

        final AccountResponseDto responseDto = accountResponseDtoFactory.createAccountResponseDto(account);

        assertCreateAccountResponseDtoIsCreatedFromAccount(responseDto, account);
    }
}
