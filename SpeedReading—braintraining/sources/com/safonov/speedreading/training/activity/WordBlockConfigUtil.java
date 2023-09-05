package com.safonov.speedreading.training.activity;

import android.support.annotation.NonNull;
import com.safonov.speedreading.training.fragment.wordsblock.repository.entity.WordBlockConfig;

public class WordBlockConfigUtil {
    private static final int DEFAULT_DURATION = 60000;
    private static final int DEFAULT_SPEED = 200;
    private static final int DEFAULT_WORD_COUNT = 1;

    @NonNull
    public static WordBlockConfig getDefaultConfig() {
        WordBlockConfig config = new WordBlockConfig();
        config.setSpeed(200);
        config.setTrainingDuration(60000);
        config.setWordCount(1);
        return config;
    }
}
