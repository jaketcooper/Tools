package com.safonov.speedreading.training.fragment.evennumbers.result.presenter;

import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.safonov.speedreading.training.fragment.evennumbers.result.view.IEvenNumbersResultView;

public interface IEvenNumbersResultPresenter extends MvpPresenter<IEvenNumbersResultView> {
    void initTrainingResults(int i);
}
