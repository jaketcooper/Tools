package com.safonov.speedreading.training.fragment.remembernumber.result.presenter;

import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.safonov.speedreading.training.fragment.remembernumber.result.view.IRememberNumberResultView;

public interface IRememberNumberResultPresenter extends MvpPresenter<IRememberNumberResultView> {
    void initTrainingResults(int i);
}
