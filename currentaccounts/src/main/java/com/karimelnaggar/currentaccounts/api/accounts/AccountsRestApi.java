package com.karimelnaggar.currentaccounts.api.accounts;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/accounts")
@AllArgsConstructor
class AccountsRestApi {

    private final CreateAccountAdapter createAccountAdapter;

    @PostMapping
    public ResponseEntity<CreateAccountResponseDto> createNewAccount(
            @Valid @NotNull @RequestBody CreateAccountRequestDto request
    ) {
        final CreateAccountResponseDto createAccountResponseDto = createAccountAdapter.createAccount(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(createAccountResponseDto);
    }
}
