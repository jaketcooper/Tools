package com.safonov.speedreading.training.fragment.speedreading.training.view;

import com.hannesdorfmann.mosby3.mvp.MvpView;
import java.util.List;

public interface ISpeedReadingView extends MvpView, SpeedReadingTrainingCompleteListener {
    void hideAnswerView();

    void hideWordsView();

    void initProgressBar(int i);

    void setAnswerButtonsEnabled(boolean z);

    void setAnswerItems(List<String> list);

    void setWordItem(int i, String str);

    void showAnswerView();

    void showWordsView();

    void updateAnswerSpeed(int i);

    void updateAnswerSpeedWithAnimation(int i, boolean z);

    void updateProgressBar(int i);

    void updateSpeed(int i);
}
