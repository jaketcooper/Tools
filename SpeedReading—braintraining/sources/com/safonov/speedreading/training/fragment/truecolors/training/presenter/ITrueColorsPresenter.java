package com.safonov.speedreading.training.fragment.truecolors.training.presenter;

import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.safonov.speedreading.training.fragment.truecolors.training.model.TrueColorsModel;
import com.safonov.speedreading.training.fragment.truecolors.training.view.ITrueColorsView;

public interface ITrueColorsPresenter extends MvpPresenter<ITrueColorsView> {
    void cancelTraining();

    void finishTraining();

    void onNumberButtonPressed(TrueColorsModel trueColorsModel, String str);

    void pauseTraining();

    void resumeTraining();

    void startTraining(int i);
}
