package com.karimelnaggar.currentaccounts.api.accounts;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
class AccountsRestApiIntegrationTests {

    @Autowired
    private AccountsRestApi accountsRestApi;

    @Test
    public void contextLoads() {

        assertThat(accountsRestApi).isNotNull();
    }
}
