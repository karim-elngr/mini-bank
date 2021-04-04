package com.karimelnaggar.currentaccounts.service.accounts;

import com.karimelnaggar.currentaccounts.persistence.AccountEntity;
import com.karimelnaggar.currentaccounts.persistence.AccountRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static com.karimelnaggar.currentaccounts.service.accounts.AccountPersistenceServiceTestUtils.assertAccountIsSameAsAccountEntity;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.doReturn;

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

        doReturn(accountEntity).when(accountEntityConverter).toEntity(account);
        doReturn(accountEntity).when(accountRepository).save(accountEntity);
        doReturn(account).when(accountModelConverter).toModel(accountEntity);

        final Account persistedAccount = accountsPersistenceService.persist(account);

        assertThat(persistedAccount).usingRecursiveComparison().isEqualTo(account);
    }

    @Test
    void findAccount_whenArgumentIsValid_returnAccount() {

        final Account account = AccountInstanceProvider.createValidAccount();
        final AccountEntity accountEntity = AccountEntityInstanceProvider.createValidAccountEntity();

        doReturn(Optional.of(accountEntity)).when(accountRepository).findByCurrentAccountId(accountEntity.getCurrentAccountId());
        doReturn(account).when(accountModelConverter).toModel(accountEntity);

        final Optional<Account> persistedAccount = accountsPersistenceService.findAccount(accountEntity.getCurrentAccountId());

        assertThat(persistedAccount).isPresent();
        assertThat(persistedAccount.get()).usingRecursiveComparison().isEqualTo(account);
    }

    @Test
    void findAllAccounts_whenCustomerHaveAccounts_returnsAListOfAccounts() {

        final String customerId = "id#1";

        final AccountEntity accountEntity = AccountEntityInstanceProvider.createValidAccountEntity();

        doReturn(List.of(accountEntity)).when(accountRepository).findAllByCustomerEntityCustomerId(customerId);
        doCallRealMethod().when(accountModelConverter).toModel(accountEntity);

        final List<Account> accounts = accountsPersistenceService.findAllAccounts(customerId);

        assertThat(accounts).isNotEmpty();
        assertThat(accounts.get(0)).satisfies(acc -> assertAccountIsSameAsAccountEntity(acc, accountEntity));
    }

    @Test
    void findAllAccounts_whenCustomerDoesNotHaveAccounts_returnsAnEmptyList() {

        final String customerId = "id#1";

        doReturn(List.of()).when(accountRepository).findAllByCustomerEntityCustomerId(customerId);

        final List<Account> accounts = accountsPersistenceService.findAllAccounts(customerId);

        assertThat(accounts).isEmpty();
    }
}
