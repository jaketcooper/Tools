package com.safonov.speedreading.training.fragment.wordpairs.training.presenter;

import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.safonov.speedreading.training.fragment.wordpairs.training.view.IWordPairsView;

public interface IWordPairsPresenter extends MvpPresenter<IWordPairsView> {
    void cancelTraining();

    void init(int i);

    void onItemTouchDown(int i);

    void onItemTouchUp(int i);

    void pauseTraining();

    void resumeTraining();

    void startTraining();
}
