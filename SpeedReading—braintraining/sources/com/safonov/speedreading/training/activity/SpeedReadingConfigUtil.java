package com.safonov.speedreading.training.activity;

import com.safonov.speedreading.training.fragment.speedreading.repository.entity.SpeedReadingConfig;

public class SpeedReadingConfigUtil {
    private static final int DEFAULT_MAX_SHOW_WORD_COUNT = 20;
    private static final int DEFAULT_MIN_SHOW_WORD_COUNT = 12;
    private static final int DEFAULT_MIN_SPEED = 100;
    private static final int DEFAULT_SPEED = 200;
    private static final int DEFAULT_SPEED_STEP = 50;
    private static final int DEFAULT_TRAINING_SHOW_COUNT = 20;

    public static SpeedReadingConfig getDefaultConfig() {
        SpeedReadingConfig config = new SpeedReadingConfig();
        config.setTrainingShowCount(20);
        config.setMinWordShowCount(12);
        config.setMaxWordShowCount(20);
        config.setMinSpeed(100);
        config.setSpeed(200);
        config.setSpeedStep(50);
        return config;
    }
}
