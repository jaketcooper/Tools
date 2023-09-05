package com.safonov.speedreading.training.activity;

import com.safonov.speedreading.training.fragment.remembernumber.repository.entity.RememberNumberConfig;

public class RememberNumberConfigUtil {
    private static final int DEFAULT_ANSWERS_TO_COMPLEXITY_DOWN = -2;
    private static final int DEFAULT_ANSWERS_TO_COMPLEXITY_UP = 3;
    private static final int DEFAULT_COMPLEXITY = 4;
    private static final int DEFAULT_MAX_COMPLEXITY = 8;
    private static final int DEFAULT_MIN_COMPLEXITY = 4;
    private static final int DEFAULT_TRAINING_SHOW_COUNT = 15;

    public static RememberNumberConfig getDefaultConfig() {
        RememberNumberConfig config = new RememberNumberConfig();
        config.setTrainingShowCount(15);
        config.setMinComplexity(4);
        config.setMaxComplexity(8);
        config.setComplexity(4);
        config.setAnswersToComplexityUp(3);
        config.setAnswersToComplexityDown(-2);
        return config;
    }
}
