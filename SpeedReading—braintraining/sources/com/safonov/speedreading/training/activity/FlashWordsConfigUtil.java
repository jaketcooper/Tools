package com.safonov.speedreading.training.activity;

import android.support.annotation.NonNull;
import com.safonov.speedreading.training.fragment.flashword.repository.entity.FlashWordsConfig;

public class FlashWordsConfigUtil {
    private static final int ACCELERATOR_COURSE_TYPE_1_BOARD_TYPE = 1;
    private static final int ACCELERATOR_COURSE_TYPE_2_BOARD_TYPE = 2;
    private static final int ACCELERATOR_COURSE_TYPE_3_BOARD_TYPE = 3;
    private static final int DEFAULT_DURATION = 60000;
    private static final int DEFAULT_SPEED = 200;

    @NonNull
    public static FlashWordsConfig getUserConfig(int boardType, long duration) {
        FlashWordsConfig config = new FlashWordsConfig();
        config.setSpeed(200);
        config.setBoarType(boardType);
        config.setTrainingDuration(duration);
        return config;
    }

    @NonNull
    public static FlashWordsConfig getAcceleratorCourse1Config() {
        FlashWordsConfig config = new FlashWordsConfig();
        config.setSpeed(200);
        config.setBoarType(1);
        config.setTrainingDuration(60000);
        return config;
    }

    @NonNull
    public static FlashWordsConfig getAcceleratorCourse2Config() {
        FlashWordsConfig config = new FlashWordsConfig();
        config.setSpeed(200);
        config.setBoarType(2);
        config.setTrainingDuration(60000);
        return config;
    }

    @NonNull
    public static FlashWordsConfig getAcceleratorCourse3Config() {
        FlashWordsConfig config = new FlashWordsConfig();
        config.setSpeed(200);
        config.setBoarType(3);
        config.setTrainingDuration(60000);
        return config;
    }
}
