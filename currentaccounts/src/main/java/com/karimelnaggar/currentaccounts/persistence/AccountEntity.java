package com.karimelnaggar.currentaccounts.persistence;

import javax.persistence.*;

@Entity
@Table(name="accounts")
public class AccountEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name="current_account_id", length=16, nullable=false, unique=true)
    private String currentAccountId;


    public AccountEntity() {
    }

    public AccountEntity(Long id, String currentAccountId) {
        this.id = id;
        this.currentAccountId = currentAccountId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCurrentAccountId() {
        return currentAccountId;
    }

    public void setCurrentAccountId(String currentAccountId) {
        this.currentAccountId = currentAccountId;
    }
}
