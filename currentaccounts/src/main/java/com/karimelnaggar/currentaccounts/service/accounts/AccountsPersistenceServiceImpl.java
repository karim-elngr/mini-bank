package com.karimelnaggar.currentaccounts.service.accounts;

import com.karimelnaggar.currentaccounts.persistence.AccountEntity;
import com.karimelnaggar.currentaccounts.persistence.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
class AccountsPersistenceServiceImpl implements AccountsPersistenceService {

    private final AccountEntityConverter accountEntityConverter;
    private final AccountRepository accountRepository;
    private final AccountModelConverter accountModelConverter;

    @Override
    public Account persist(Account account) {

        final AccountEntity accountEntity = accountEntityConverter.toEntity(account);

        final AccountEntity persistedAccountEntity = accountRepository.save(accountEntity);

        return accountModelConverter.toModel(persistedAccountEntity);
    }

    @Override
    public Optional<Account> findAccount(String currentAccountId) {

        final Optional<AccountEntity> accountEntity = accountRepository.findByCurrentAccountId(currentAccountId);

        return accountEntity.map(accountModelConverter::toModel);
    }

    @Override
    public List<Account> findAllAccounts(String customerId) {

        final List<AccountEntity> accountEntities = accountRepository.findAllByCustomerEntityCustomerId(customerId);

        return accountEntities.stream().map(accountModelConverter::toModel).collect(Collectors.toUnmodifiableList());
    }
}
