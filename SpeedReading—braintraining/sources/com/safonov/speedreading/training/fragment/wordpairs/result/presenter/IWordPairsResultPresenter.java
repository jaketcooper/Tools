package com.safonov.speedreading.training.fragment.wordpairs.result.presenter;

import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.safonov.speedreading.training.fragment.wordpairs.result.view.IWordPairsResultView;

public interface IWordPairsResultPresenter extends MvpPresenter<IWordPairsResultView> {
    void initTrainingResults(int i);
}
