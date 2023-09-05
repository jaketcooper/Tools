package com.safonov.speedreading.training.fragment.wordsblock.training.presenter;

import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.safonov.speedreading.training.fragment.wordsblock.training.view.IWordBlockView;

public interface IWordBlockPresenter extends MvpPresenter<IWordBlockView> {
    void cancelTraining();

    void init(int i);

    void pauseTraining();

    void resumeTraining();

    void speedDown();

    void speedUp();

    void startTraining();

    void switchPauseStatus();

    void wordCountMinus();

    void wordCountPlus();
}
