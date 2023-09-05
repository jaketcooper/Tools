package com.safonov.speedreading.training.fragment.wordsblock.result.presenter;

import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.safonov.speedreading.training.fragment.wordsblock.result.view.IWordBlockResultView;

public interface IWordBlockResultPresenter extends MvpPresenter<IWordBlockResultView> {
    void initTrainingResults(int i);
}
