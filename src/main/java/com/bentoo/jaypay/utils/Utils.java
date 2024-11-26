package com.bentoo.jaypay.utils;

import org.springframework.stereotype.Component;

@Component
public class Utils {
    public String generateCVV(){
        double cvv = Math.floor(Math.random() * 1000);
        return Double.toString(cvv);
    }
}
