package com.safonov.speedreading.training.activity.model;

import android.support.annotation.NonNull;
import com.safonov.speedreading.training.TrainingType;
import com.safonov.speedreading.training.activity.model.entity.TrainingWrapper;

public interface ITrainingConfigUtil {

    public interface ConfigResponseListener {
        void onConfigResponse(TrainingWrapper trainingWrapper);
    }

    public interface CourseConfigResponseListener {
        void onCourseConfigResponse(TrainingWrapper[] trainingWrapperArr);
    }

    void requestToGetCourseConfigList(@NonNull TrainingType trainingType, CourseConfigResponseListener courseConfigResponseListener);

    void requestToGetTrainingConfig(@NonNull TrainingType trainingType, ConfigResponseListener configResponseListener);
}
