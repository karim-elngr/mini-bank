package com.karimelnaggar.currentaccounts;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
class CurrentAccountsApplicationIntegrationTests {

	@Autowired
	private CurrentAccountsApplication currentAccountsApplication;

	@Test
	void contextLoads() {

		assertThat(currentAccountsApplication).isNotNull();
	}
}
