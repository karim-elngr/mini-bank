package com.karimelnaggar.currentaccounts.api.accounts;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.test.context.ActiveProfiles;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CREATED;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class AccountsRestApiIntegrationTests {

    @LocalServerPort
    private int port;

    private static String generateStringFromResource(String path) throws IOException {

        final Resource resource = new ClassPathResource(path);

        return new String(resource.getInputStream().readAllBytes());
    }

    @Test
    public void createNewAccount_whenRequestIsValid_respondsWithACreatedAccount() throws IOException {

        final String jsonRequest = generateStringFromResource("payloads/create_account/valid_request.json");

        given().port(port).body(jsonRequest).contentType(JSON)
                .when().post("/customers/customer1/accounts")
                .then()
                .assertThat()
                .statusCode(is(CREATED.value()))
                .body("currentAccountId", equalTo("1"));
    }

    @Test
    public void createNewAccount_whenRequestIsMissingAccountId_respondsWithABadRequest() throws IOException {

        final String jsonRequest = generateStringFromResource("payloads/create_account/invalid_request_missing_account_id.json");

        given().port(port).body(jsonRequest).contentType(JSON)
                .when().post("/customers/customer1/accounts")
                .then()
                .assertThat()
                .statusCode(is(BAD_REQUEST.value()));
    }
}
