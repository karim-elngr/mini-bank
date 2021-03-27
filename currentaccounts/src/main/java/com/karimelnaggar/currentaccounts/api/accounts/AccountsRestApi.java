package com.karimelnaggar.currentaccounts.api.accounts;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/accounts")
class AccountsRestApi {

    private final CreateAccountAdapter createAccountAdapter;

    public AccountsRestApi(CreateAccountAdapter createAccountAdapter) {
        this.createAccountAdapter = createAccountAdapter;
    }

    @PostMapping
    public ResponseEntity<CreateAccountResponseDto> createNewAccount(
            @Valid @NotNull @RequestBody CreateAccountRequestDto request
    ) {
        final CreateAccountResponseDto createAccountResponseDto = createAccountAdapter.createAccount(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(createAccountResponseDto);
    }
}
