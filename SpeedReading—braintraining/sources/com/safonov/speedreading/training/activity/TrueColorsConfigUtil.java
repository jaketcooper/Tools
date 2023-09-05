package com.safonov.speedreading.training.activity;

import com.safonov.speedreading.training.fragment.truecolors.repository.entity.TrueColorsConfig;

public class TrueColorsConfigUtil {
    private static final int DEFAULT_TRAINING_SHOW_TIME = 10000;

    public static TrueColorsConfig getDefaultConfig() {
        TrueColorsConfig config = new TrueColorsConfig();
        config.setShowTime(10000);
        return config;
    }
}
