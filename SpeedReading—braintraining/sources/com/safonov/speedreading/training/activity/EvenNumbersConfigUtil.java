package com.safonov.speedreading.training.activity;

import com.safonov.speedreading.training.fragment.evennumbers.repository.entity.EvenNumbersConfig;

public class EvenNumbersConfigUtil {
    private static final int DEFAULT_COLUMN_COUNT = 4;
    private static final int DEFAULT_DIGITS_PER_NUMBER_COUNT = 4;
    private static final int DEFAULT_EVEN_NUMBERS_COUNT = 6;
    private static final int DEFAULT_ROW_COUNT = 10;
    private static final int DEFAULT_TRAINING_TIME = 120000;

    public static EvenNumbersConfig getDefaultConfig() {
        EvenNumbersConfig config = new EvenNumbersConfig();
        config.setRowCount(10);
        config.setColumnCount(4);
        config.setEvenNumberCount(6);
        config.setDigitsPerNumber(4);
        config.setTrainingDuration(DEFAULT_TRAINING_TIME);
        return config;
    }
}
