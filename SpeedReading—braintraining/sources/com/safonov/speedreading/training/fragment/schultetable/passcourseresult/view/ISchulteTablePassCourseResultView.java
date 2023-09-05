package com.safonov.speedreading.training.fragment.schultetable.passcourseresult.view;

import com.hannesdorfmann.mosby3.mvp.MvpView;

public interface ISchulteTablePassCourseResultView extends MvpView {
    void setNewBestTimeViewVisibility(boolean z);

    void updateBestTimeView(long j);

    void updatePassCoursePointsView(int i);

    void updateTimeView(long j);
}
