package com.karimelnaggar.currentaccounts.api.accounts;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class AccountsRestApiIntegrationTests {

    @Autowired
    private AccountsRestApi accountsRestApi;

    @Test
    public void contextLoads() {

        assertThat(accountsRestApi).isNotNull();
    }
}
