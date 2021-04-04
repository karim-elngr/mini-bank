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

    private final AccountsServiceAdapter accountsServiceAdapter;

    @PostMapping
    public ResponseEntity<AccountResponseDto> createNewAccount(
            @Valid @NotEmpty @PathVariable("customerId") String customerId,
            @Valid @NotNull @RequestBody CreateAccountRequestDto request
    ) {
        final AccountResponseDto accountResponseDto = accountsServiceAdapter.createAccount(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(accountResponseDto);
    }

    @GetMapping("/{currentAccountId}")
    public ResponseEntity<AccountResponseDto> getCurrentAccount(
            @Valid @NotEmpty @PathVariable("customerId") String customerId,
            @Valid @NotEmpty @PathVariable("currentAccountId") String currentAccountId
    ) {
        final AccountResponseDto accountResponseDto = accountsServiceAdapter.getAccount(currentAccountId);

        return ResponseEntity.ok(accountResponseDto);
    }

    @GetMapping
    public ResponseEntity<AccountsResponseDto> getCurrentAccountsForCustomer(
            @Valid @NotEmpty @PathVariable("customerId") String customerId
    ) {
        final AccountsResponseDto accountsResponse = accountsServiceAdapter.getAllAccountsForCustomer(customerId);

        return ResponseEntity.ok(accountsResponse);
    }
}
