package com.karimelnaggar.currentaccounts.api.accounts;

import com.karimelnaggar.currentaccounts.service.accounts.CreateAccountRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@ExtendWith(MockitoExtension.class)
class CreateAccountRequestFactoryUnitTests {

    @InjectMocks
    private CreateAccountRequestModelFactory createAccountRequestModelFactory;

    @ParameterizedTest
    @NullSource
    @MethodSource("com.karimelnaggar.currentaccounts.api.accounts.CreateAccountRequestDtoInstanceProvider#createInvalidRequests")
    void newCreateAccountRequestModel_whenArgumentsAreInvalid_throwsIllegalArgumentException(CreateAccountRequestDto request) {

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> createAccountRequestModelFactory.newCreateAccountRequestModel(request));
    }

    @Test
    void newCreateAccountRequestModel_whenArgumentIsValidRequest_returnCreateAccountRequestModel() {

        final CreateAccountRequestDto requestDto = CreateAccountRequestDtoInstanceProvider.createValidRequest();

        final CreateAccountRequest requestModel = createAccountRequestModelFactory.newCreateAccountRequestModel(requestDto);

        assertThat(requestModel).isNotNull();

        assertThat(requestModel.getCurrentAccountId()).isEqualTo(requestDto.getCurrentAccountId());

        assertThat(requestModel.getCustomer()).isNotNull();
        assertThat(requestModel.getCustomer().getCustomerId()).isEqualTo(requestDto.getCustomer().getCustomerId());
        assertThat(requestModel.getCustomer().getFirstName()).isEqualTo(requestDto.getCustomer().getFirstName());
        assertThat(requestModel.getCustomer().getSurname()).isEqualTo(requestDto.getCustomer().getSurname());


        assertThat(requestModel.getInitialCredit()).isNotNull();
        assertThat(requestModel.getInitialCredit().getBalance()).isNotNull();

        assertThat(requestModel.getInitialCredit().getBalance().getNumber().numberValue(BigDecimal.class))
                .isEqualByComparingTo(new BigDecimal(requestDto.getInitialCredit().getAmount()));
        assertThat(requestModel.getInitialCredit().getBalance().getCurrency().toString())
                .isEqualTo(requestDto.getInitialCredit().getCurrency());
    }
}
