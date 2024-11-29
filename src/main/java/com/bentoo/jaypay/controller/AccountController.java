package com.bentoo.jaypay.controller;

import com.bentoo.jaypay.dto.account.AccountDTO;
import com.bentoo.jaypay.model.Account;
import com.bentoo.jaypay.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    IAccountService accountService;

    @PostMapping(path = "")
    public ResponseEntity<Account> createAccount(@RequestBody AccountDTO body) throws Exception{
        var result = accountService.create(body);
        var uri = UriComponentsBuilder.fromPath("/").build().toUri();
        return ResponseEntity.created(uri).body(result);
    }
}
