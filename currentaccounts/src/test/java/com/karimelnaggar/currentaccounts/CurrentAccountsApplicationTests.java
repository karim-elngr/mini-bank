package com.karimelnaggar.currentaccounts;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CurrentAccountsApplicationTests {

	@Autowired
	private CurrentAccountsApplication currentAccountsApplication;

	@Test
	void contextLoads() {

		assertThat(currentAccountsApplication).isNotNull();
	}
}
