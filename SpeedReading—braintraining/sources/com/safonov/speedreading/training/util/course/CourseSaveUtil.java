package com.safonov.speedreading.training.util.course;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.gson.Gson;
import com.safonov.speedreading.training.TrainingType;

public class CourseSaveUtil {
    private static final String ACCELERATOR_COURSE_TRAININGS_JSON = "accelerator_course_json";
    private static final String COURSE_SAVE_PREFERENCES = "course_save_preferences";
    private static final String PASS_COURSE_1_TRAININGS_JSON = "pass_course_1_json";
    private final SharedPreferences sharedPreferences;

    public CourseSaveUtil(@NonNull Context context) {
        this.sharedPreferences = context.getSharedPreferences(COURSE_SAVE_PREFERENCES, 0);
    }

    public void save(@NonNull TrainingType courseType, int trainingsCompletedCount, @NonNull int[] resultIds) {
        CourseTrainingSave save = new CourseTrainingSave();
        save.trainingCompletedCount = trainingsCompletedCount;
        save.trainingResultIds = resultIds;
        String json = new Gson().toJson((Object) save);
        switch (courseType) {
            case PASS_COURSE:
                this.sharedPreferences.edit().putString(PASS_COURSE_1_TRAININGS_JSON, json).apply();
                return;
            case ACCELERATOR_COURSE:
                this.sharedPreferences.edit().putString(ACCELERATOR_COURSE_TRAININGS_JSON, json).apply();
                return;
            default:
                throw new IllegalArgumentException("This course type is unsupported");
        }
    }

    @Nullable
    public CourseTrainingSave load(@NonNull TrainingType courseType) {
        String json;
        switch (courseType) {
            case PASS_COURSE:
                json = this.sharedPreferences.getString(PASS_COURSE_1_TRAININGS_JSON, (String) null);
                break;
            case ACCELERATOR_COURSE:
                json = this.sharedPreferences.getString(ACCELERATOR_COURSE_TRAININGS_JSON, (String) null);
                break;
            default:
                throw new IllegalArgumentException("This course type is unsupported");
        }
        if (json != null) {
            return (CourseTrainingSave) new Gson().fromJson(json, CourseTrainingSave.class);
        }
        return null;
    }

    public void reset(@NonNull TrainingType courseType) {
        switch (courseType) {
            case PASS_COURSE:
                this.sharedPreferences.edit().putString(PASS_COURSE_1_TRAININGS_JSON, (String) null).apply();
                return;
            case ACCELERATOR_COURSE:
                this.sharedPreferences.edit().putString(ACCELERATOR_COURSE_TRAININGS_JSON, (String) null).apply();
                return;
            default:
                throw new IllegalArgumentException("This course type is unsupported");
        }
    }
}
