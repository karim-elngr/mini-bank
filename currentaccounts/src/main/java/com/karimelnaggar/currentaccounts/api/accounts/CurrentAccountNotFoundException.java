package com.karimelnaggar.currentaccounts.api.accounts;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Current account is not found!")
public class CurrentAccountNotFoundException extends RuntimeException {

    public CurrentAccountNotFoundException(String message) {
        super(message);
    }
}
