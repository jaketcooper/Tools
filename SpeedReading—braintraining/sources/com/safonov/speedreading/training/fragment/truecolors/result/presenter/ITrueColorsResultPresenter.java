package com.safonov.speedreading.training.fragment.truecolors.result.presenter;

import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.safonov.speedreading.training.fragment.truecolors.result.view.ITrueColorsResultView;

public interface ITrueColorsResultPresenter extends MvpPresenter<ITrueColorsResultView> {
    void initTrainingResults(int i);
}
