package com.safonov.speedreading.training.fragment.cuptimer.training.presenter;

import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.safonov.speedreading.training.fragment.cuptimer.training.view.ICupTimerView;

public interface ICupTimerPresenter extends MvpPresenter<ICupTimerView> {
    void cancelTraining();

    void pauseTraining();

    void resumeTraining();

    void saveResult();

    void startTraining(int i);
}
