package com.safonov.speedreading.training.fragment.remembernumber.training.presenter;

import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.safonov.speedreading.training.fragment.remembernumber.training.view.IRememberNumberView;

public interface IRememberNumberPresenter extends MvpPresenter<IRememberNumberView> {
    void cancelTraining();

    void onBackspaceButtonPressed();

    void onNumberButtonPressed(String str);

    void pauseTraining();

    void resumeTraining();

    void startTraining(int i);
}
