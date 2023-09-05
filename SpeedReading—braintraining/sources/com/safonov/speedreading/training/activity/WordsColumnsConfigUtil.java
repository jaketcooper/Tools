package com.safonov.speedreading.training.activity;

import android.support.annotation.NonNull;
import com.safonov.speedreading.training.fragment.wordscolumns.repository.entity.WordsColumnsConfig;

public class WordsColumnsConfigUtil {
    private static final int ACCELERATOR_COURSE_TYPE_1_COLUMN_COUNT = 1;
    private static final int ACCELERATOR_COURSE_TYPE_1_WORDS_PER_ITEM = 1;
    private static final int ACCELERATOR_COURSE_TYPE_2_COLUMN_COUNT = 2;
    private static final int ACCELERATOR_COURSE_TYPE_2_WORDS_PER_ITEM = 1;
    private static final int ACCELERATOR_COURSE_TYPE_3_COLUMN_COUNT = 3;
    private static final int ACCELERATOR_COURSE_TYPE_3_WORDS_PER_ITEM = 1;
    private static final int ACCELERATOR_COURSE_TYPE_4_COLUMN_COUNT = 2;
    private static final int ACCELERATOR_COURSE_TYPE_4_WORDS_PER_ITEM = 2;
    private static final int ACCELERATOR_COURSE_TYPE_5_COLUMN_COUNT = 1;
    private static final int ACCELERATOR_COURSE_TYPE_5_WORDS_PER_ITEM = 4;
    private static final int DEFAULT_DURATION = 60000;
    private static final int DEFAULT_ROW_COUNT = 16;
    private static final int DEFAULT_SPEED = 200;
    private static final int DEFAULT_WORDS_PER_ITEM = 1;

    @NonNull
    public static WordsColumnsConfig getUserConfig(int columnCount, long duration) {
        WordsColumnsConfig config = new WordsColumnsConfig();
        config.setRowCount(16);
        config.setColumnCount(columnCount);
        config.setWordsPerItem(1);
        config.setSpeed(200);
        config.setTrainingDuration(duration);
        return config;
    }

    @NonNull
    private static WordsColumnsConfig getAcceleratorCourseConfig(int columnCount, int wordsPerItem) {
        WordsColumnsConfig config = new WordsColumnsConfig();
        config.setRowCount(16);
        config.setColumnCount(columnCount);
        config.setWordsPerItem(wordsPerItem);
        config.setSpeed(200);
        config.setTrainingDuration(60000);
        return config;
    }

    @NonNull
    public static WordsColumnsConfig getAcceleratorCourseType1Config() {
        return getAcceleratorCourseConfig(1, 1);
    }

    @NonNull
    public static WordsColumnsConfig getAcceleratorCourseType2Config() {
        return getAcceleratorCourseConfig(2, 1);
    }

    @NonNull
    public static WordsColumnsConfig getAcceleratorCourseType3Config() {
        return getAcceleratorCourseConfig(3, 1);
    }

    @NonNull
    public static WordsColumnsConfig getAcceleratorCourseType4Config() {
        return getAcceleratorCourseConfig(2, 2);
    }

    @NonNull
    public static WordsColumnsConfig getAcceleratorCourseType5Config() {
        return getAcceleratorCourseConfig(1, 4);
    }
}
