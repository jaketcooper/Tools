package com.safonov.speedreading.training.activity;

import android.support.annotation.NonNull;
import com.safonov.speedreading.training.fragment.cuptimer.repository.entity.CupTimerConfig;

public class CupTimerConfigUtil {
    @NonNull
    public static CupTimerConfig getUserConfig(long duration, int type) {
        CupTimerConfig config = new CupTimerConfig();
        config.setDuration(duration);
        config.setType(type);
        return config;
    }
}
