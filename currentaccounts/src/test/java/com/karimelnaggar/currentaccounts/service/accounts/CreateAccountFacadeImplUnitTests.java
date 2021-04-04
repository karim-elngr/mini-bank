package com.karimelnaggar.currentaccounts.service.accounts;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class CreateAccountFacadeImplUnitTests {

    @InjectMocks
    private CreateAccountFacadeImpl createAccountFacade;

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
}
