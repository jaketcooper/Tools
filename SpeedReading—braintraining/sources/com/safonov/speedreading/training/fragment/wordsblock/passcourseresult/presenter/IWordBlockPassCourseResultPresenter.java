package com.safonov.speedreading.training.fragment.wordsblock.passcourseresult.presenter;

import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.safonov.speedreading.training.fragment.wordsblock.passcourseresult.view.IWordBlockPassCourseResultView;

public interface IWordBlockPassCourseResultPresenter extends MvpPresenter<IWordBlockPassCourseResultView> {
    void initTrainingResults(int i);
}
