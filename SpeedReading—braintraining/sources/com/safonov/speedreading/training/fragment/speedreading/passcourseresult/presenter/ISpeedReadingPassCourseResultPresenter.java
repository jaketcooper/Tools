package com.safonov.speedreading.training.fragment.speedreading.passcourseresult.presenter;

import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.safonov.speedreading.training.fragment.speedreading.passcourseresult.view.ISpeedReadingPassCourseResultView;

public interface ISpeedReadingPassCourseResultPresenter extends MvpPresenter<ISpeedReadingPassCourseResultView> {
    void initTrainingResults(int i);
}
