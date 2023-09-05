package com.safonov.speedreading.training.activity;

import com.safonov.speedreading.training.fragment.rememberwords.repository.entity.RememberWordsConfig;

public class RememberWordsConfigUtil {
    public static final int DEFAULT_SHOW_WORDS_COUNT = 3;

    public static RememberWordsConfig getDefaultConfig() {
        RememberWordsConfig config = new RememberWordsConfig();
        config.setStartWordsCount(3);
        return config;
    }
}
