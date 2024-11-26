package com.bentoo.jaypay.service;

import com.bentoo.jaypay.model.Account;

public interface IAccountService {
    Account create(Account account) throws Exception;
}
