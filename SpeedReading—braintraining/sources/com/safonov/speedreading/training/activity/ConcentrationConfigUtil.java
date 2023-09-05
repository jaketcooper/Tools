package com.safonov.speedreading.training.activity;

import com.safonov.speedreading.training.fragment.concentration.repository.entity.ConcentrationConfig;

public class ConcentrationConfigUtil {
    public static final int DEFAULT_CIRCLES_COUNT = 4;
    public static final int DEFAULT_GRAY_DURATION = 2000;
    public static final int DEFAULT_RADIUS = 70;
    public static final int DEFAULT_SPEED = 3;

    public static ConcentrationConfig getDefaultConfig() {
        ConcentrationConfig config = new ConcentrationConfig();
        config.setCirclesCount(4);
        config.setCirclesSpeed(3);
        config.setCirclesRadius(70);
        config.setGrayTime(2000);
        config.setCirclesSpeedCustom(3);
        config.setCirclesCountCustom(4);
        config.setCirclesSizeCustom(70);
        return config;
    }
}
