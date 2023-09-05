package com.safonov.speedreading.training.activity;

import com.safonov.speedreading.training.fragment.wordpairs.repository.entity.WordPairsConfig;

public class WordPairsConfigUtil {
    private static final int DEFAULT_COLUMN_COUNT = 3;
    private static final int DEFAULT_DIFFERENT_WORD_PAIRS_COUNT = 5;
    private static final int DEFAULT_ROW_COUNT = 6;
    private static final int DEFAULT_TRAINING_TIME = 120000;

    public static WordPairsConfig getDefaultConfig() {
        WordPairsConfig config = new WordPairsConfig();
        config.setRowCount(6);
        config.setColumnCount(3);
        config.setDifferentWordPairsCount(5);
        config.setTrainingDuration(DEFAULT_TRAINING_TIME);
        return config;
    }
}
