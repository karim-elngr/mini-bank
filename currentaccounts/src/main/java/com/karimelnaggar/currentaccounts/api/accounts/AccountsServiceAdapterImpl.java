package com.karimelnaggar.currentaccounts.api.accounts;

import com.karimelnaggar.currentaccounts.service.accounts.Account;
import com.karimelnaggar.currentaccounts.service.accounts.AccountsFacade;
import com.karimelnaggar.currentaccounts.service.accounts.CreateAccountRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.google.common.base.Preconditions.checkArgument;

@Component
@AllArgsConstructor
class AccountsServiceAdapterImpl implements AccountsServiceAdapter {

    private final CreateAccountRequestModelFactory createAccountRequestModelFactory;
    private final AccountsFacade accountsFacade;
    private final AccountResponseDtoFactory accountResponseDtoFactory;

    @Override
    public AccountResponseDto createAccount(CreateAccountRequestDto request) {

        checkArgument(Objects.nonNull(request), "request cannot be null");

        final CreateAccountRequest createAccountRequest = createAccountRequestModelFactory.newCreateAccountRequestModel(request);

        final Account account = accountsFacade.createNewAccount(createAccountRequest);

        return accountResponseDtoFactory.createAccountResponseDto(account);
    }

    @Override
    public AccountResponseDto getAccount(String currentAccountId) {

        checkArgument(StringUtils.hasText(currentAccountId), "current account id cannot be empty");

        final Optional<Account> account = accountsFacade.getAccount(currentAccountId);

        if (account.isPresent()) {

            return accountResponseDtoFactory.createAccountResponseDto(account.get());
        }

        throw new CurrentAccountNotFoundException("Current account is not found!");
    }

    @Override
    public AccountsResponseDto getAllAccountsForCustomer(String customerId) {

        checkArgument(StringUtils.hasText(customerId), "customer id cannot be empty");

        final List<Account> accounts = accountsFacade.getAllAccounts(customerId);

        final List<AccountResponseDto> accountsResponseDto = accounts.stream()
                .map(accountResponseDtoFactory::createAccountResponseDto)
                .collect(Collectors.toUnmodifiableList());

        return new AccountsResponseDto(accountsResponseDto);
    }
}
