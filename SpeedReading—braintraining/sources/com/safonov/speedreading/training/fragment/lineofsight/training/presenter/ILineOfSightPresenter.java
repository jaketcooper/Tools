package com.safonov.speedreading.training.fragment.lineofsight.training.presenter;

import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.safonov.speedreading.training.fragment.lineofsight.training.view.ILineOfSightView;

public interface ILineOfSightPresenter extends MvpPresenter<ILineOfSightView> {
    void cancelTraining();

    void init(int i);

    void onCheckButtonPressed();

    void onPreShowAnimationCompleted();

    void pauseTraining();

    void resumeTraining();

    void startTraining();
}
