package com.safonov.speedreading.training.fragment.flashword.training.presenter;

import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.safonov.speedreading.training.fragment.flashword.training.view.IFlashWordsView;

public interface IFlashWordsPresenter extends MvpPresenter<IFlashWordsView> {
    void cancelTraining();

    void init(int i);

    void levelDown();

    void levelUp();

    void pauseTraining();

    void resumeTraining();

    void speedDown();

    void speedUp();

    void startTraining();

    void switchTrainingPause();
}
