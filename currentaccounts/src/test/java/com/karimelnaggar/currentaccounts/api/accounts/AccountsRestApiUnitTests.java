package com.karimelnaggar.currentaccounts.api.accounts;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

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

    @Test
    void getCurrentAccount_whenArgumentsAreValid_returnExistingAccount() {

        final String customerId = "id#1";
        final String accountId = "id#1";

        final AccountResponseDto expectedResponse = CreateAccountResponseDtoInstanceProvider.createValidResponse();
        doReturn(expectedResponse).when(accountsServiceAdapter).getAccount(accountId);

        final ResponseEntity<AccountResponseDto> response = accountsRestApi.getCurrentAccount(
                customerId,
                accountId
        );

        assertThat(response).isNotNull();
        assertThat(response.getStatusCode()).isEqualByComparingTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(expectedResponse);
    }

    @Test
    void getCurrentAccountsForCustomer_whenArgumentsAreValid_returnExistingAccounts() {

        final String customerId = "id#1";

        final AccountsResponseDto expectedResponse = new AccountsResponseDto(
                List.of(CreateAccountResponseDtoInstanceProvider.createValidResponse()));

        doReturn(expectedResponse).when(accountsServiceAdapter).getAllAccountsForCustomer(customerId);

        final ResponseEntity<AccountsResponseDto> response = accountsRestApi.getCurrentAccountsForCustomer(customerId);

        assertThat(response).isNotNull();
        assertThat(response.getStatusCode()).isEqualByComparingTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(expectedResponse);
    }
}
