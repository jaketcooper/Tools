package com.safonov.speedreading.training.fragment.math.training.presenter;

import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.safonov.speedreading.training.fragment.math.training.view.IMathView;

public interface IMathPresenter extends MvpPresenter<IMathView> {
    void compleateTraining();

    void onNumberButtonPressed(int i);

    void pauseGame();

    void shuffleArray();

    void startTraining(int i);
}
