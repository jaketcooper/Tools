package com.safonov.speedreading.training.fragment.wordpairs.passcourseresult.presenter;

import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.safonov.speedreading.training.fragment.wordpairs.passcourseresult.view.IWordPairsPassCourseResultView;

public interface IWordPairsPassCourseResultPresenter extends MvpPresenter<IWordPairsPassCourseResultView> {
    void initTrainingResults(int i);
}
