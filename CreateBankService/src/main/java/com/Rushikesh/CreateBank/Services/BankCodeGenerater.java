package com.Rushikesh.CreateBank.Services;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class BankCodeGenerater {

    private String randomAlphabetGenerator(){
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < 4; i++){
            sb.append((char) ('A' + random.nextInt(26)));
        }

        return sb.toString();
    }

    private int randomNumberGenerator(){
        Random random = new Random();
        return 10000 + random.nextInt(90000);
    }

    protected String randomCodeGenerator(){
        String bankCode = randomAlphabetGenerator() + randomNumberGenerator();
        return bankCode;
    }
}
