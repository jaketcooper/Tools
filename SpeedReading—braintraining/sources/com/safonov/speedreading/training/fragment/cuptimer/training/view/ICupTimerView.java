package com.safonov.speedreading.training.fragment.cuptimer.training.view;

import com.hannesdorfmann.mosby3.mvp.MvpView;

public interface ICupTimerView extends MvpView, CupTimerCompleteListener {
    void hideImage();

    void hideNotification();

    void hideProgressBar();

    void setImage(int i);

    void setMaxProgress(long j);

    void setProgress(int i);

    void showImage();

    void showNotification(int i);
}
