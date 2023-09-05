package com.safonov.speedreading.training.fragment.greendot.training.view;

import com.hannesdorfmann.mosby3.mvp.MvpView;

public interface IGreenDotView extends MvpView, GreenDotTrainingCompleteListener {
    void setGreenDotViewProgress(int i);
}
