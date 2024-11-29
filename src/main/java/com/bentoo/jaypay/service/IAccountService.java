package com.bentoo.jaypay.service;

import com.bentoo.jaypay.dto.account.AccountDTO;
import com.bentoo.jaypay.model.Account;

public interface IAccountService extends IServiceBase<Account, AccountDTO> {
    Account create(AccountDTO accountDTO) throws Exception;
}
