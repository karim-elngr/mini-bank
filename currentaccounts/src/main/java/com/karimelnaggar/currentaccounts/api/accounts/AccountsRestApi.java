package com.karimelnaggar.currentaccounts.api.accounts;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/customers/{customerId}/accounts")
@AllArgsConstructor
class AccountsRestApi {

    private final CreateAccountAdapter createAccountAdapter;

    @PostMapping
    public ResponseEntity<CreateAccountResponseDto> createNewAccount(
            @Valid @NotEmpty @PathVariable("customerId") String customerId,
            @Valid @NotNull @RequestBody CreateAccountRequestDto request
    ) {
        final CreateAccountResponseDto createAccountResponseDto = createAccountAdapter.createAccount(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(createAccountResponseDto);
    }

    @GetMapping
    public ResponseEntity<CreateAccountResponseDto> getCurrentAccounts(
            @Valid @NotEmpty @PathVariable("customerId") String customerId
    ) {
        return ResponseEntity.ok(new CreateAccountResponseDto());
    }

    @GetMapping("/{currentAccountId}")
    public ResponseEntity<CreateAccountResponseDto> getCurrentAccount(
            @Valid @NotEmpty @PathVariable("customerId") String customerId,
            @Valid @NotEmpty @PathVariable("currentAccountId") String currentAccountId
    ) {
        return ResponseEntity.ok(new CreateAccountResponseDto());
    }
}
