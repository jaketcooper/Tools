package com.safonov.speedreading.training.fragment.speedreading.training.presenter;

import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.safonov.speedreading.training.fragment.speedreading.training.view.ISpeedReadingView;

public interface ISpeedReadingPresenter extends MvpPresenter<ISpeedReadingView> {
    void answerAnimationEnded();

    void answerButtonClick(int i);

    void cancelTraining();

    void pauseTraining();

    void resumeTraining();

    void startTraining(int i);
}
