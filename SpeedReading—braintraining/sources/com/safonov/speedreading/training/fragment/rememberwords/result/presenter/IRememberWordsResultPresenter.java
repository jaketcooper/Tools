package com.safonov.speedreading.training.fragment.rememberwords.result.presenter;

import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.safonov.speedreading.training.fragment.rememberwords.result.view.IRememberWordsResultView;

public interface IRememberWordsResultPresenter extends MvpPresenter<IRememberWordsResultView> {
    void initTrainingResults(int i);
}
