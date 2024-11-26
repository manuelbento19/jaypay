package com.bentoo.jaypay.service.implementation;

import com.bentoo.jaypay.lib.CryptLib;
import com.bentoo.jaypay.model.Account;
import com.bentoo.jaypay.repository.IAccountRepository;
import com.bentoo.jaypay.service.IAccountService;
import com.bentoo.jaypay.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements IAccountService {
    @Autowired
    private IAccountRepository accountRepository;
    @Autowired
    private CryptLib cryptLib;
    @Autowired
    private Utils utils;

    public Account create(Account account) throws Exception {
        Account existAccount = accountRepository.findByEmail(account.getEmail());
        if(existAccount != null){
            throw new Exception("Account already exists.");
        }
        String accountNumber = utils.generateAccountNumber();
        account.setAccountNumber(accountNumber);
        String hashPassword = cryptLib.hash(account.getPassword());
        account.setPassword(hashPassword);
        return accountRepository.save(account);
    }
}
