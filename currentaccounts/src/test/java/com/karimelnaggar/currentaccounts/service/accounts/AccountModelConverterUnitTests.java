package com.karimelnaggar.currentaccounts.service.accounts;

import com.karimelnaggar.currentaccounts.persistence.AccountEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.karimelnaggar.currentaccounts.service.accounts.AccountPersistenceServiceTestUtils.assertAccountIsSameAsAccountEntity;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@ExtendWith(MockitoExtension.class)
class AccountModelConverterUnitTests {

    @InjectMocks
    private AccountModelConverter accountModelConverter;

    @ParameterizedTest
    @NullSource
    @MethodSource("com.karimelnaggar.currentaccounts.service.accounts.AccountEntityInstanceProvider#createInvalidAccountEntities")
    void toModel_whenArgumentsAreInvalid_throwsIllegalStateException(AccountEntity accountEntity) {

        assertThatExceptionOfType(IllegalStateException.class).isThrownBy(() -> accountModelConverter.toModel(accountEntity));
    }

    @Test
    void toModel_whenArgumentIsValid_returnCorrectAccount() {

        final AccountEntity accountEntity = AccountEntityInstanceProvider.createValidAccountEntity();

        final Account account = accountModelConverter.toModel(accountEntity);

        assertAccountIsSameAsAccountEntity(account, accountEntity);
    }
}
