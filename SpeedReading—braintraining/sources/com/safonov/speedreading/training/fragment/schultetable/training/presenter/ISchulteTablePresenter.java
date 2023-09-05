package com.safonov.speedreading.training.fragment.schultetable.training.presenter;

import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.safonov.speedreading.training.fragment.schultetable.training.view.ISchulteTableView;

public interface ISchulteTablePresenter extends MvpPresenter<ISchulteTableView> {
    void cancelTraining();

    void init(int i);

    void onItemTouchDown(int i);

    void onItemTouchUp(int i);

    void pauseTraining();

    void resumeTraining();

    void startTraining();
}
