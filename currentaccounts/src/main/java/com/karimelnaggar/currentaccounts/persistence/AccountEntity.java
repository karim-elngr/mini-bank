package com.karimelnaggar.currentaccounts.persistence;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

@Entity
@Table(
        name="accounts",
        indexes = {
                @Index(name = "customer_id_index", columnList = "customer_id")
        })
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @NaturalId
    @Column(name="current_account_id", length=16, nullable=false, unique=true)
    private String currentAccountId;

    @Embedded
    private CustomerEntity customerEntity;

    @Embedded
    private CreditEntity creditEntity;
}
