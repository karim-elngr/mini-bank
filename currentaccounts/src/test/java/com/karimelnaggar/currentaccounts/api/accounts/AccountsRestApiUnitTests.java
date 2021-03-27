package com.karimelnaggar.currentaccounts.api.accounts;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AccountsRestApiUnitTests {

    @InjectMocks
    private AccountsRestApi accountsRestApi;

    @Mock
    private CreateAccountAdapter createAccountAdapter;

    @Test
    void createNewAccount_whenArgumentsAreValid_createNewAccountAndReturnCreatedStatusCode() {

        final CreateAccountRequestDto request = CreateNewAccountRequestDtoInstanceProvider.createWithFullPayload();

        final CreateAccountResponseDto expectedResponse = new CreateAccountResponseDto();
        doReturn(expectedResponse).when(createAccountAdapter).createAccount(request);

        final ResponseEntity<CreateAccountResponseDto> response = accountsRestApi.createNewAccount(request);

        assertThat(response).isNotNull();
        assertThat(response.getStatusCode()).isEqualByComparingTo(HttpStatus.CREATED);
        assertThat(response.getBody()).isEqualTo(expectedResponse);

        verify(createAccountAdapter, times(1)).createAccount(request);
    }
}
