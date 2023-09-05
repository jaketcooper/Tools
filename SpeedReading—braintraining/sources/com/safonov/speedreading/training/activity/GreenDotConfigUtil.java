package com.safonov.speedreading.training.activity;

import android.support.annotation.NonNull;
import com.safonov.speedreading.training.fragment.greendot.repository.entity.GreenDotConfig;

public class GreenDotConfigUtil {
    private static final long PASS_COURSE_DURATION = 300000;

    @NonNull
    public static GreenDotConfig getUserConfig(long duration) {
        GreenDotConfig config = new GreenDotConfig();
        config.setDuration(duration);
        return config;
    }

    public static GreenDotConfig getPassCourseConfig() {
        GreenDotConfig config = new GreenDotConfig();
        config.setDuration(PASS_COURSE_DURATION);
        return config;
    }
}
