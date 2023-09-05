package com.safonov.speedreading.training.fragment.wordscolumns.result.presenter;

import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.safonov.speedreading.training.fragment.wordscolumns.result.view.IWordColumnsResultView;

public interface IWordColumnsResultPresenter extends MvpPresenter<IWordColumnsResultView> {
    void initTrainingResults(int i);
}
