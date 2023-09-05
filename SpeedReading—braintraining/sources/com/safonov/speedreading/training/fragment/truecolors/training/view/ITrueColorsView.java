package com.safonov.speedreading.training.fragment.truecolors.training.view;

import com.hannesdorfmann.mosby3.mvp.MvpView;
import com.safonov.speedreading.training.fragment.truecolors.training.model.TrueColorsModel;
import java.util.List;

public interface ITrueColorsView extends MvpView, TrueColorsTrainingCompleteListener {
    void disableButtons();

    void enableButtons();

    List<TrueColorsModel> getColors();

    long getProgress();

    void hideAnswerImage();

    void initCountDownTimer(long j);

    void initProgressBar(int i);

    void setAnswerImage(boolean z);

    void showLevel(TrueColorsModel trueColorsModel, List<TrueColorsModel> list);

    void timerPause();

    void timerStart();

    void updateBestScoreView(int i);

    void updateProgressBar(int i);

    void updateScoreView(int i);
}
