package com.safonov.speedreading.training.fragment.wordscolumns.training.view;

import android.support.annotation.NonNull;
import com.hannesdorfmann.mosby3.mvp.MvpView;

public interface IWordColumnsView extends MvpView {
    void deselectItem(int i);

    void initGridLayout(int i, int i2);

    void onTrainingCompleted(int i);

    void selectItem(int i);

    void setItems(@NonNull String[] strArr);

    void updateSpeedView(int i);

    void updateTimeView(long j);
}
