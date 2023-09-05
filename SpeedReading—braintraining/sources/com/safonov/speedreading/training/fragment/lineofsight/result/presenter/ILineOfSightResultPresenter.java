package com.safonov.speedreading.training.fragment.lineofsight.result.presenter;

import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.safonov.speedreading.training.fragment.lineofsight.result.view.ILineOfSightResultView;

public interface ILineOfSightResultPresenter extends MvpPresenter<ILineOfSightResultView> {
    void initTrainingResults(int i);
}
