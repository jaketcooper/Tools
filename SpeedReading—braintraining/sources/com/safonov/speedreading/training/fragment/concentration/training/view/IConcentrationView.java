package com.safonov.speedreading.training.fragment.concentration.training.view;

import com.hannesdorfmann.mosby3.mvp.MvpView;

public interface IConcentrationView extends MvpView, ConcentrationCompleteListener {
    void hidePointsTextView();

    void initProgressBar(int i);

    void setPointsTextViewCorrect(int i);

    void setVisibleStatistics(boolean z);

    void updateBestScoreView(int i);

    void updateProgressBar(int i);

    void updateScoreView(int i);
}
