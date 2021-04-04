package com.karimelnaggar.currentaccounts.persistence;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerEntity {

    @Column(name="customer_id", length=16, nullable=false)
    private String customerId;

    @Column(name="first_name", length=16, nullable=false)
    private String firstName;

    @Column(name="surname", length=16, nullable=false)
    private String surname;
}
