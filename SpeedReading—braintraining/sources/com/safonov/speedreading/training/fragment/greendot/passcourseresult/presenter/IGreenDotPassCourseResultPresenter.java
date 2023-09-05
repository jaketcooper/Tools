package com.safonov.speedreading.training.fragment.greendot.passcourseresult.presenter;

import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.safonov.speedreading.training.fragment.greendot.passcourseresult.view.IGreenDotPassCourseResultView;

public interface IGreenDotPassCourseResultPresenter extends MvpPresenter<IGreenDotPassCourseResultView> {
    void initTrainingResults(int i);
}
