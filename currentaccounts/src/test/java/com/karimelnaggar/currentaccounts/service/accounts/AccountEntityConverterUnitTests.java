package com.karimelnaggar.currentaccounts.service.accounts;

import com.karimelnaggar.currentaccounts.persistence.AccountEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.karimelnaggar.currentaccounts.service.accounts.AccountPersistenceServiceTestUtils.assertAccountEntityIsSameAsAccount;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@ExtendWith(MockitoExtension.class)
class AccountEntityConverterUnitTests {

    @InjectMocks
    private AccountEntityConverter accountEntityConverter;

    @ParameterizedTest
    @NullSource
    @MethodSource("com.karimelnaggar.currentaccounts.service.accounts.AccountInstanceProvider#createInvalidAccounts")
    void toEntity_whenArgumentsAreInvalid_throwsIllegalArgumentException(Account account) {

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> accountEntityConverter.toEntity(account));
    }

    @Test
    void toEntity_whenArgumentIsValid_returnCorrectAccountEntity() {

        final Account account = AccountInstanceProvider.createValidAccount();

        final AccountEntity accountEntity = accountEntityConverter.toEntity(account);

        assertAccountEntityIsSameAsAccount(accountEntity, account);
    }
}
