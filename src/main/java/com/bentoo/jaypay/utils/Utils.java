package com.bentoo.jaypay.utils;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class Utils {
    private final Random random = new Random();

    public String generateCVV(){
        double cvv = Math.floor(Math.random() * 1000);
        return Double.toString(cvv);
    }
    public String generateCardNumber(){
        StringBuilder accountNumberGenerated = new StringBuilder("2");

        for (int i = 0; i < 8; i++) {
            accountNumberGenerated.append(random.nextInt(10));
        }
        accountNumberGenerated.append("999");

        return accountNumberGenerated.toString();
    }
}
