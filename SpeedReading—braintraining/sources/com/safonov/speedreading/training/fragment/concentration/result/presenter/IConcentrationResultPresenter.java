package com.safonov.speedreading.training.fragment.concentration.result.presenter;

import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.safonov.speedreading.training.fragment.concentration.result.view.IConcentrationResultView;

public interface IConcentrationResultPresenter extends MvpPresenter<IConcentrationResultView> {
    void initTrainingResults(int i);
}
