package com.safonov.speedreading.training.fragment.cuptimer.result.presenter;

import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.safonov.speedreading.training.fragment.cuptimer.result.view.ICupTimerResultView;

public interface ICupTimerResultPresenter extends MvpPresenter<ICupTimerResultView> {
    void initTrainingResults(int i);
}
