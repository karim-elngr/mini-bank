package com.karimelnaggar.currentaccounts.service.accounts;

import com.karimelnaggar.currentaccounts.service.model.Account;
import com.karimelnaggar.currentaccounts.service.model.CreateAccountRequestModel;

public interface CreateAccountFacade {

    Account createNewAccount(CreateAccountRequestModel createAccountRequestModel);
}
