package com.karimelnaggar.currentaccounts.api.accounts;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class CreateNewAccountFacadeImplUT {

    @InjectMocks
    private CreateNewAccountFacadeImpl createNewAccountFacade;

    @Test
    void createNewAccount_whenArgumentsAreNull_returnNull() {

        final CreateNewAccountResponseDto response = createNewAccountFacade.createNewAccount(null);

        assertThat(response).isNull();
    }
}