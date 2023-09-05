package com.safonov.speedreading.training.fragment.flashword.result.presenter;

import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.safonov.speedreading.training.fragment.flashword.result.view.IFlashWordsResultView;

public interface IFlashWordsResultPresenter extends MvpPresenter<IFlashWordsResultView> {
    void initTrainingResults(int i);
}
