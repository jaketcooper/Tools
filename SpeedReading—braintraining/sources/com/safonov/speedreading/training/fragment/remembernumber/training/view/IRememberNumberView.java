package com.safonov.speedreading.training.fragment.remembernumber.training.view;

import com.hannesdorfmann.mosby3.mvp.MvpView;

public interface IRememberNumberView extends MvpView, RememberNumberTrainingCompleteListener {
    void initProgressBar(int i);

    void sedDefaultCardValueAt(int i);

    void setBlinkCardsTextColor();

    void setButtonsEnabled(boolean z);

    void setCardAnswerBackgroundAt(int i, boolean z);

    void setCardValueAt(int i, String str);

    void setCardViews(int i);

    void setCardsDefaultBackground();

    void setCardsDefaultTextColor();

    void setCardsDefaultValues();

    void setCardsValues(String[] strArr);

    void updateBestScoreView(int i);

    void updateProgressBar(int i);

    void updateScoreView(int i);
}
