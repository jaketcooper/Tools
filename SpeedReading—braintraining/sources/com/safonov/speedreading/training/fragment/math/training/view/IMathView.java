package com.safonov.speedreading.training.fragment.math.training.view;

import com.hannesdorfmann.mosby3.mvp.MvpView;

public interface IMathView extends MvpView, MathTrainingCompleteListener {
    void initCountDownTimer(long j);

    void initProgressBar(int i);

    void refreshExpressionTextView();

    void setButtonsEnabled(boolean z);

    void setButtonsText(int[] iArr);

    void setCorrectAnswer();

    void setCorrectAnswerGone();

    void setExpressionText(String str);

    void setIncorrectAnswer(int i);

    void setPointsTextViewCorrect(float f);

    void setPointsTextViewIncorrect();

    void timerPause();

    void timerStart();

    void updateBestScoreView(int i);

    void updateProgressBar(int i);

    void updateScoreView(int i);
}
