package com.safonov.speedreading.training.fragment.remembernumber.passcourseresult.presenter;

import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.safonov.speedreading.training.fragment.remembernumber.passcourseresult.view.IRememberNumberPassCourseResultView;

public interface IRememberNumberPassCourseResultPresenter extends MvpPresenter<IRememberNumberPassCourseResultView> {
    void initTrainingResults(int i);
}
