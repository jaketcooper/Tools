package com.safonov.speedreading.training.fragment.wordscolumns.passcourseresult.presenter;

import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.safonov.speedreading.training.fragment.wordscolumns.passcourseresult.view.IWordColumnsCourseResultView;

public interface IWordColumnsCourseResultPresenter extends MvpPresenter<IWordColumnsCourseResultView> {
    void initTrainingResults(int i);
}
