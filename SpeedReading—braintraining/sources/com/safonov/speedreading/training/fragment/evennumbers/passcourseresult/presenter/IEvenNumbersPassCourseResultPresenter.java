package com.safonov.speedreading.training.fragment.evennumbers.passcourseresult.presenter;

import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.safonov.speedreading.training.fragment.evennumbers.passcourseresult.view.IEvenNumbersPassCourseResultView;

public interface IEvenNumbersPassCourseResultPresenter extends MvpPresenter<IEvenNumbersPassCourseResultView> {
    void initTrainingResults(int i);
}
