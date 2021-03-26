package com.karimelnaggar.currentaccounts.api.accounts;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AccountsRestApiUT {

    @InjectMocks
    private AccountsRestApi accountsRestApi;

    @Mock
    private CreateNewAccountFacade createNewAccountFacade;

    @Test
    void createNewAccount_whenCalledWithValidArguments_createNewAccountAndReturnCreatedStatusCode() {

        final CreateNewAccountRequestDto request = CreateNewAccountRequestDtoInstanceProvider.createWithFullPayload();

        final CreateNewAccountResponseDto expectedResponse = new CreateNewAccountResponseDto();
        doReturn(expectedResponse).when(createNewAccountFacade).createNewAccount(request);

        final ResponseEntity<CreateNewAccountResponseDto> response = accountsRestApi.createNewAccount(request);

        assertThat(response).isNotNull();
        assertThat(response.getStatusCode()).isEqualByComparingTo(HttpStatus.CREATED);
        assertThat(response.getBody()).isEqualTo(expectedResponse);

        verify(createNewAccountFacade, times(1)).createNewAccount(request);
    }
}
