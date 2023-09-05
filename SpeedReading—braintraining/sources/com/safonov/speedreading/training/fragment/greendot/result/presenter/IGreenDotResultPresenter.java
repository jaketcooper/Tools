package com.safonov.speedreading.training.fragment.greendot.result.presenter;

import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.safonov.speedreading.training.fragment.greendot.result.view.IGreenDotResultView;

public interface IGreenDotResultPresenter extends MvpPresenter<IGreenDotResultView> {
    void initTrainingResults(int i);
}
