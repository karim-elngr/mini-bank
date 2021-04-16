package com.karimelnaggar.currentaccounts.service.accounts;

import com.karimelnaggar.currentaccounts.persistence.AccountEntity;
import com.karimelnaggar.currentaccounts.persistence.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
class AccountsPersistenceServiceImpl implements AccountsPersistenceService {

    private final AccountEntityConverter accountEntityConverter;
    private final AccountRepository accountRepository;
    private final AccountModelConverter accountModelConverter;

    @Override
    @Transactional
    public Account persist(Account account) {

        final AccountEntity accountEntity = accountEntityConverter.toEntity(account);

        final AccountEntity persistedAccountEntity = accountRepository.save(accountEntity);

        return accountModelConverter.toModel(persistedAccountEntity);
    }

    @Override
    @Transactional
    public Optional<Account> findAccount(String currentAccountId) {

        final Optional<AccountEntity> accountEntity = accountRepository.findByCurrentAccountId(currentAccountId);

        return accountEntity.map(accountModelConverter::toModel);
    }

    @Override
    @Transactional
    public List<Account> findAllAccounts(String customerId) {

        final List<AccountEntity> accountEntities = accountRepository.findAllByCustomerEntityCustomerId(customerId);

        return accountEntities.stream().map(accountModelConverter::toModel).toList();
    }
}
