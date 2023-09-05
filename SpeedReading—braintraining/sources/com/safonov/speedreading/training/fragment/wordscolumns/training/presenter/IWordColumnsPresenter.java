package com.safonov.speedreading.training.fragment.wordscolumns.training.presenter;

import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.safonov.speedreading.training.fragment.wordscolumns.training.view.IWordColumnsView;

public interface IWordColumnsPresenter extends MvpPresenter<IWordColumnsView> {
    void cancelTraining();

    void init(int i);

    void pauseTraining();

    void resumeTraining();

    void speedDown();

    void speedUp();

    void startTraining();

    void switchTrainingPauseStatus();
}
