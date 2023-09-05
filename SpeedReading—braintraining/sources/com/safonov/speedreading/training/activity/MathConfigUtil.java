package com.safonov.speedreading.training.activity;

import com.safonov.speedreading.training.fragment.math.repository.entity.MathConfig;

public class MathConfigUtil {
    public static MathConfig getDefaultConfig(long duration) {
        MathConfig config = new MathConfig();
        config.setDuration(duration);
        return config;
    }
}
