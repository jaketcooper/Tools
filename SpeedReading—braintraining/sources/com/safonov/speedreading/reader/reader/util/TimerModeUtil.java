package com.safonov.speedreading.reader.reader.util;

import android.support.annotation.NonNull;
import com.safonov.speedreading.reader.reader.model.TimerModeModel;

public class TimerModeUtil {
    @NonNull
    public static TimerModeModel[] getTimerModeModels(int timerMode) {
        switch (timerMode) {
            case 1:
                return new TimerModeModel[]{new TimerModeModel(1, 300000), new TimerModeModel(2, 300000)};
            case 2:
                return new TimerModeModel[]{new TimerModeModel(1, 60000), new TimerModeModel(2, 60000)};
            default:
                throw new IllegalArgumentException("Unsupported timer mode");
        }
    }
}
