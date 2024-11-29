package com.bentoo.jaypay.controller;

import com.bentoo.jaypay.dto.account.AccountDTO;
import com.bentoo.jaypay.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    Utils utils;

    @PostMapping(path = "")
    public String createAccount(@RequestBody AccountDTO body){
        return "No accounts";
    }
}
