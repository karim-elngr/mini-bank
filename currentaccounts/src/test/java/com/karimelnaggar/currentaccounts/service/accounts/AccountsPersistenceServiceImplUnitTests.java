package com.karimelnaggar.currentaccounts.service.accounts;

import com.karimelnaggar.currentaccounts.persistence.AccountEntity;
import com.karimelnaggar.currentaccounts.persistence.AccountRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class AccountsPersistenceServiceImplUnitTests {

    @InjectMocks
    private AccountsPersistenceServiceImpl accountsPersistenceService;

    @Mock
    private AccountEntityConverter accountEntityConverter;

    @Mock
    private AccountRepository accountRepository;

    @Mock
    private AccountModelConverter accountModelConverter;

    @Test
    void persist_whenArgumentIsValid_returnPersistedAccount() {

        final Account account = AccountInstanceProvider.createValidAccount();
        final AccountEntity accountEntity = AccountEntityInstanceProvider.createValidAccountEntity();

        Mockito.doReturn(accountEntity).when(accountEntityConverter).toEntity(account);
        Mockito.doReturn(accountEntity).when(accountRepository).save(accountEntity);
        Mockito.doReturn(account).when(accountModelConverter).toModel(accountEntity);

        final Account persistedAccount = accountsPersistenceService.persist(account);

        assertThat(persistedAccount).usingRecursiveComparison().isEqualTo(account);
    }

    @Test
    void findAccount_whenArgumentIsValid_returnAccount() {

        final Account account = AccountInstanceProvider.createValidAccount();
        final AccountEntity accountEntity = AccountEntityInstanceProvider.createValidAccountEntity();

        Mockito.doReturn(Optional.of(accountEntity)).when(accountRepository).findByCurrentAccountId(accountEntity.getCurrentAccountId());
        Mockito.doReturn(account).when(accountModelConverter).toModel(accountEntity);

        final Optional<Account> persistedAccount = accountsPersistenceService.findAccount(accountEntity.getCurrentAccountId());

        assertThat(persistedAccount).isPresent();
        assertThat(persistedAccount.get()).usingRecursiveComparison().isEqualTo(account);
    }
}
