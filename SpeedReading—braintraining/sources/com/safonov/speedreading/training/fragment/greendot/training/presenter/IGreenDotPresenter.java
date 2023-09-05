package com.safonov.speedreading.training.fragment.greendot.training.presenter;

import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.safonov.speedreading.training.fragment.greendot.training.view.IGreenDotView;

public interface IGreenDotPresenter extends MvpPresenter<IGreenDotView> {
    void cancelTraining();

    void pauseTraining();

    void resumeTraining();

    void startTraining(int i);
}
