package com.karimelnaggar.currentaccounts.service.accounts;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class AccountsFacadeImplUnitTests {

    @InjectMocks
    private AccountsFacadeImpl createAccountFacade;

    @Mock
    private AccountsFactory accountsFactory;

    @Mock
    private AccountsPersistenceService accountsPersistenceService;

    @Test
    void createNewAccount_whenAccountAlreadyExists_returnExistingAccount() {

        final CreateAccountRequest createAccountRequest = CreateAccountRequestInstanceProvider.createValidCreateAccountRequest();

        final Account existingAccount = AccountInstanceProvider.createValidAccount();
        doReturn(Optional.of(existingAccount)).when(accountsPersistenceService).findAccount(createAccountRequest.getCurrentAccountId());

        final Account account = createAccountFacade.createNewAccount(createAccountRequest);

        assertThat(account).isNotNull();
        assertThat(account).isEqualTo(existingAccount);
    }

    @Test
    void createNewAccount_whenAccountIsNew_persistAndReturnNewAccount() {

        final CreateAccountRequest createAccountRequest = CreateAccountRequestInstanceProvider.createValidCreateAccountRequest();
        doReturn(Optional.empty()).when(accountsPersistenceService).findAccount(createAccountRequest.getCurrentAccountId());

        final Account newAccount = AccountInstanceProvider.createValidAccount();
        doReturn(newAccount).when(accountsFactory).createNewAccount(createAccountRequest);
        doReturn(newAccount).when(accountsPersistenceService).persist(newAccount);

        final Account account = createAccountFacade.createNewAccount(createAccountRequest);

        assertThat(account).isNotNull();
        assertThat(account).isEqualTo(newAccount);
    }

    @Test
    void getAccount_whenCurrentAccountExists_returnsCurrentAccount() {

        final String accountId = "id#1";

        final Account expectedAccount = AccountInstanceProvider.createValidAccount();
        doReturn(Optional.of(expectedAccount)).when(accountsPersistenceService).findAccount(accountId);

        final Optional<Account> account = createAccountFacade.getAccount(accountId);

        assertThat(account).isPresent();
        assertThat(account.get()).isEqualTo(expectedAccount);
    }

    @Test
    void getAccount_whenCurrentAccountDoesNotExists_returnsEmptyOptional() {

        final String accountId = "id#1";

        doReturn(Optional.empty()).when(accountsPersistenceService).findAccount(accountId);

        final Optional<Account> account = createAccountFacade.getAccount(accountId);

        assertThat(account).isEmpty();
    }

    @Test
    void getAllAccounts_whenCustomerHaveAccounts_returnsAListOfAccounts() {

        final String customerId = "id#1";

        final Account expectedAccount = AccountInstanceProvider.createValidAccount();
        doReturn(List.of(expectedAccount)).when(accountsPersistenceService).findAllAccounts(customerId);

        final List<Account> accounts = createAccountFacade.getAllAccounts(customerId);

        assertThat(accounts).isNotEmpty();
        assertThat(accounts).hasSize(1);
        assertThat(accounts).contains(expectedAccount);
    }

    @Test
    void getAllAccounts_whenCustomerDoesNotHaveAccounts_returnsAnEmptyList() {

        final String customerId = "id#1";

        doReturn(List.of()).when(accountsPersistenceService).findAllAccounts(customerId);

        final List<Account> accounts = createAccountFacade.getAllAccounts(customerId);

        assertThat(accounts).isEmpty();
    }
}
