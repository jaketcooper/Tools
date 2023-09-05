package com.safonov.speedreading.training.fragment.aceeleratorcourse.presenter;

import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.safonov.speedreading.training.fragment.aceeleratorcourse.view.IAcceleratorCourseResultView;

public interface IAcceleratorCourseResultPresenter extends MvpPresenter<IAcceleratorCourseResultView> {
    void initTrainingResults(int[] iArr);
}
