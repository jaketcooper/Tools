package com.safonov.speedreading.training.fragment.lineofsight.passcourseresult.view;

import com.hannesdorfmann.mosby3.mvp.MvpView;

public interface ILineOfSightPassCourseResultView extends MvpView {
    void updateFoundMistakesPercentView(float f);

    void updateFoundMistakesView(int i);

    void updateMistakesView(int i);

    void updatePassCoursePointsView(int i);
}
