package com.karimelnaggar.currentaccounts.api.accounts;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/accounts")
class AccountsRestApi {

    private final CreateNewAccountFacade createNewAccountFacade;

    public AccountsRestApi(CreateNewAccountFacade createNewAccountFacade) {
        this.createNewAccountFacade = createNewAccountFacade;
    }

    @PostMapping
    public ResponseEntity<CreateNewAccountResponseDto> createNewAccount(
            @Valid @NotNull @RequestBody CreateNewAccountRequestDto request
    ) {
        final CreateNewAccountResponseDto createNewAccountResponseDto = createNewAccountFacade.createNewAccount(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(createNewAccountResponseDto);
    }
}
