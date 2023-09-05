package com.safonov.speedreading.training.fragment.flashword.passcourseresult.presenter;

import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.safonov.speedreading.training.fragment.flashword.passcourseresult.view.IFlashWordsPassCourseResultView;

public interface IFlashWordsPassCourseResultPresenter extends MvpPresenter<IFlashWordsPassCourseResultView> {
    void initTrainingResults(int i);
}
