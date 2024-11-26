package com.bentoo.jaypay.lib;

import at.favre.lib.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;

@Component
public class CryptLib {

    public String hash(String password){
        return BCrypt.withDefaults().hashToString(10,password.toCharArray());
    }
}
