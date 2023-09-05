package com.safonov.speedreading.training.fragment.schultetable.result.presenter;

import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.safonov.speedreading.training.fragment.schultetable.result.view.ISchulteTableResultView;

public interface ISchulteTableResultPresenter extends MvpPresenter<ISchulteTableResultView> {
    void initTrainingResults(int i);
}
