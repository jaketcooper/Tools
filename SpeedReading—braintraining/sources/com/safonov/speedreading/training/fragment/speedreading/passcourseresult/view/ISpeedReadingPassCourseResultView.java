package com.safonov.speedreading.training.fragment.speedreading.passcourseresult.view;

import com.hannesdorfmann.mosby3.mvp.MvpView;

public interface ISpeedReadingPassCourseResultView extends MvpView {
    void setNewBestAverageSpeedViewVisibility(boolean z);

    void setNewBestMaxSpeedViewVisibility(boolean z);

    void updateAverageSpeedView(int i);

    void updateBestAverageSpeedView(int i);

    void updateBestMaxSpeedView(int i);

    void updateMaxSpeedView(int i);

    void updatePassCoursePointsView(int i);
}
