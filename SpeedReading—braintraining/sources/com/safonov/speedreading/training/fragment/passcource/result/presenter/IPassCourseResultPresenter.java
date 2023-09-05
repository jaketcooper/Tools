package com.safonov.speedreading.training.fragment.passcource.result.presenter;

import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.safonov.speedreading.training.fragment.passcource.result.view.IPassCourseResultView;

public interface IPassCourseResultPresenter extends MvpPresenter<IPassCourseResultView> {
    void init(int[] iArr);
}
