package com.safonov.speedreading.training.fragment.wordpairs.passcourseresult.view;

import com.hannesdorfmann.mosby3.mvp.MvpView;

public interface IWordPairsPassCourseResultView extends MvpView {
    void setNewBestScoreViewVisibility(boolean z);

    void updateBestScoreView(int i);

    void updatePassCoursePointsView(int i);

    void updateScoreView(int i);
}
