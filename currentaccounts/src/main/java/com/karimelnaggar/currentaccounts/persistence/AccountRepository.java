package com.karimelnaggar.currentaccounts.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<AccountEntity, Long> {

    Optional<AccountEntity> findByCurrentAccountId(String currentAccountId);

    List<AccountEntity> findAllByCustomerEntityCustomerId(String customerId);
}
