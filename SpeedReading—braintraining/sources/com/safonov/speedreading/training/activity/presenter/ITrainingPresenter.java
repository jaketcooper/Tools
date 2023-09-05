package com.safonov.speedreading.training.activity.presenter;

import android.support.annotation.NonNull;
import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.safonov.speedreading.training.TrainingType;
import com.safonov.speedreading.training.activity.view.ITrainingView;

public interface ITrainingPresenter extends MvpPresenter<ITrainingView> {
    void onActionBarHelpPressed();

    void onActionBarHomePressed();

    void onActionBarRestartPressed();

    void onActionBarSettingsPressed();

    void onBackPressed();

    void onPause();

    void onPauseDialogContinueClick();

    void onPauseDialogDismiss();

    void onPauseDialogExitClick();

    void onPauseDialogHelpClick();

    void onPauseDialogRestartClick();

    void onPauseDialogSettingsClick();

    void onPauseDialogShow();

    void onReadingCompleted();

    void onResume();

    void onStop();

    void onTrainingCompleted(@NonNull TrainingType trainingType, int i);

    void requestToLoadTraining(@NonNull TrainingType trainingType);

    void requestToSetNextCourseTraining();

    void requestToSetNextFragment();

    void restartCourse();
}
