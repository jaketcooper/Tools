package com.safonov.speedreading.training.fragment.evennumbers.training.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

class NumberWrapperGenerator {
    private static final Random random = new Random();

    NumberWrapperGenerator() {
    }

    static List<NumberWrapper> createNumberWrappers(int digitPerNumber, int numbersCount, int evenNumbersCount) {
        if (evenNumbersCount > numbersCount) {
            throw new IllegalArgumentException("evenNumbersCount must be no greater than numbersCount");
        } else if (digitPerNumber < 1) {
            throw new IllegalArgumentException("digitPerNumber must be greater than 1");
        } else {
            List<NumberWrapper> result = new ArrayList<>(numbersCount);
            for (int i = 0; i < numbersCount - evenNumbersCount; i++) {
                result.add(new NumberWrapper(getRandomNumber(digitPerNumber, false), false));
            }
            for (int i2 = numbersCount - evenNumbersCount; i2 < numbersCount; i2++) {
                result.add(new NumberWrapper(getRandomNumber(digitPerNumber, true), true));
            }
            Collections.shuffle(result);
            return result;
        }
    }

    private static String getRandomNumber(int length, boolean isEvenNumber) {
        StringBuilder builder = new StringBuilder();
        int firstDigit = random.nextInt(10);
        while (firstDigit == 0) {
            firstDigit = random.nextInt(10);
        }
        builder.append(firstDigit);
        for (int i = 1; i < length - 1; i++) {
            builder.append(random.nextInt(10));
        }
        int lastDigit = random.nextInt(10);
        while (true) {
            if ((lastDigit % 2 == 0) != isEvenNumber) {
                lastDigit = random.nextInt(10);
            } else {
                builder.append(lastDigit);
                return builder.toString();
            }
        }
    }
}
