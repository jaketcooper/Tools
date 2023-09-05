package com.safonov.speedreading.training.fragment.math.result.presenter;

import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.safonov.speedreading.training.fragment.math.result.view.IMathResultView;

public interface IMathResultPresenter extends MvpPresenter<IMathResultView> {
    void initTrainingResults(int i);
}
