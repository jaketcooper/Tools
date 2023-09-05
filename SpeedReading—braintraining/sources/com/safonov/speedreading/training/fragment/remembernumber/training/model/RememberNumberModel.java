package com.safonov.speedreading.training.fragment.remembernumber.training.model;

import java.util.Random;

public class RememberNumberModel implements IRememberNumberModel {
    private Random random = new Random();

    public String[] createNumber(int length) {
        String[] resultNumber = new String[length];
        for (int i = 0; i < length; i++) {
            resultNumber[i] = String.valueOf(this.random.nextInt(10));
        }
        return resultNumber;
    }
}
