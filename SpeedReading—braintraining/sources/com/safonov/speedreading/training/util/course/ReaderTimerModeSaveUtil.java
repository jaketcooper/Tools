package com.safonov.speedreading.training.util.course;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.gson.Gson;

public class ReaderTimerModeSaveUtil {
    private static final String ACCELERATOR_COURSE_TIMER_MODE_JSON = "accelerator_course_timer_mode_json";
    private static final String COURSE_SAVE_PREFERENCES = "course_save_preferences";
    private static final String PASS_COURSE_TIMER_MODE_JSON = "pass_course_1_timer_mode_json";
    private final SharedPreferences sharedPreferences;

    public ReaderTimerModeSaveUtil(@NonNull Context context) {
        this.sharedPreferences = context.getSharedPreferences(COURSE_SAVE_PREFERENCES, 0);
    }

    public void save(int timerMode, long[] remainingTimes) {
        TimerModeSave save = new TimerModeSave();
        save.remainingTimes = remainingTimes;
        String json = new Gson().toJson((Object) save);
        switch (timerMode) {
            case 1:
                this.sharedPreferences.edit().putString(PASS_COURSE_TIMER_MODE_JSON, json).apply();
                return;
            case 2:
                this.sharedPreferences.edit().putString(ACCELERATOR_COURSE_TIMER_MODE_JSON, json).apply();
                return;
            default:
                throw new IllegalArgumentException("This course type is unsupported");
        }
    }

    @Nullable
    public TimerModeSave load(int timerMode) {
        String json;
        switch (timerMode) {
            case 1:
                json = this.sharedPreferences.getString(PASS_COURSE_TIMER_MODE_JSON, (String) null);
                break;
            case 2:
                json = this.sharedPreferences.getString(ACCELERATOR_COURSE_TIMER_MODE_JSON, (String) null);
                break;
            default:
                throw new IllegalArgumentException("This course type is unsupported");
        }
        if (json != null) {
            return (TimerModeSave) new Gson().fromJson(json, TimerModeSave.class);
        }
        return null;
    }

    public void reset(int timerMode) {
        switch (timerMode) {
            case 1:
                this.sharedPreferences.edit().putString(PASS_COURSE_TIMER_MODE_JSON, (String) null).apply();
                return;
            case 2:
                this.sharedPreferences.edit().putString(ACCELERATOR_COURSE_TIMER_MODE_JSON, (String) null).apply();
                return;
            default:
                throw new IllegalArgumentException("This course type is unsupported");
        }
    }
}
