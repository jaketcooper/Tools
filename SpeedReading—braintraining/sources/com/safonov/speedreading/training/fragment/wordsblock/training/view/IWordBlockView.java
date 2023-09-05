package com.safonov.speedreading.training.fragment.wordsblock.training.view;

import com.hannesdorfmann.mosby3.mvp.MvpView;

public interface IWordBlockView extends MvpView {
    void onTrainingCompleted(int i);

    void setWordBlockItemText(String str);

    void updateSpeedView(int i);

    void updateTimeView(long j);

    void updateWordCountView(int i);
}
