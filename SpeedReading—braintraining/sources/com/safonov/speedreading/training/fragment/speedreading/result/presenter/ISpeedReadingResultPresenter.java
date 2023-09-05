package com.safonov.speedreading.training.fragment.speedreading.result.presenter;

import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.safonov.speedreading.training.fragment.speedreading.result.view.ISpeedReadingResultView;

public interface ISpeedReadingResultPresenter extends MvpPresenter<ISpeedReadingResultView> {
    void initTrainingResults(int i);
}
