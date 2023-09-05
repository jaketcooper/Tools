package com.safonov.speedreading.training.fragment.schultetable.passcourseresult.presenter;

import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.safonov.speedreading.training.fragment.schultetable.passcourseresult.view.ISchulteTablePassCourseResultView;

public interface ISchulteTablePassCourseResultPresenter extends MvpPresenter<ISchulteTablePassCourseResultView> {
    void initTrainingResults(int i);
}
