package com.karimelnaggar.currentaccounts.api.accounts;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class AccountsRestApiUnitTests {

    @InjectMocks
    private AccountsRestApi accountsRestApi;

    @Mock
    private AccountsServiceAdapter accountsServiceAdapter;

    @Test
    void createNewAccount_whenArgumentsAreValid_createNewAccountAndReturnCreatedStatusCode() {

        final CreateAccountRequestDto request = CreateAccountRequestDtoInstanceProvider.createValidRequest();

        final AccountResponseDto expectedResponse = CreateAccountResponseDtoInstanceProvider.createValidResponse();
        doReturn(expectedResponse).when(accountsServiceAdapter).createAccount(request);

        final ResponseEntity<AccountResponseDto> response = accountsRestApi.createNewAccount(
                request.getCustomer().getCustomerId(),
                request
        );

        assertThat(response).isNotNull();
        assertThat(response.getStatusCode()).isEqualByComparingTo(HttpStatus.CREATED);
        assertThat(response.getBody()).isEqualTo(expectedResponse);
    }
}
