package com.safonov.speedreading.training.fragment.lineofsight.passcourseresult.presenter;

import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.safonov.speedreading.training.fragment.lineofsight.passcourseresult.view.ILineOfSightPassCourseResultView;

public interface ILineOfSightPassCourseResultPresenter extends MvpPresenter<ILineOfSightPassCourseResultView> {
    void initTrainingResults(int i);
}
