package com.bentoo.jaypay.utils;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class Utils {
    private final Random random = new Random();

    public String generateAccountNumber(){
        StringBuilder accountNumber = new StringBuilder("1");

        for (int i = 0; i < 8; i++) {
            accountNumber.append(random.nextInt(10));
        }
        accountNumber.append("454");

        return accountNumber.toString();
    }
    public String generateCVV(){
        double cvv = Math.floor(Math.random() * 1000);
        return Double.toString(cvv);
    }
    public String generateCardNumber(){
        StringBuilder cardNumber = new StringBuilder("2");

        for (int i = 0; i < 8; i++) {
            cardNumber.append(random.nextInt(10));
        }
        cardNumber.append("545");
        return cardNumber.toString();
    }
}
