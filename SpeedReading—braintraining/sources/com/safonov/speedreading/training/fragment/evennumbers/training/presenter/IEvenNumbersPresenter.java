package com.safonov.speedreading.training.fragment.evennumbers.training.presenter;

import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.safonov.speedreading.training.fragment.evennumbers.training.view.IEvenNumbersView;

public interface IEvenNumbersPresenter extends MvpPresenter<IEvenNumbersView> {
    void cancelTraining();

    void init(int i);

    void onItemTouchDown(int i);

    void onItemTouchUp(int i);

    void pauseTraining();

    void resumeTraining();

    void startTraining();
}
