package com.safonov.speedreading.training.fragment.evennumbers.training.model;

public class NumberWrapper {
    private boolean isEvenNumber;
    private String number;

    public NumberWrapper(String number2, boolean isEvenNumber2) {
        this.number = number2;
        this.isEvenNumber = isEvenNumber2;
    }

    public String getNumber() {
        return this.number;
    }

    public boolean isEvenNumber() {
        return this.isEvenNumber;
    }
}
