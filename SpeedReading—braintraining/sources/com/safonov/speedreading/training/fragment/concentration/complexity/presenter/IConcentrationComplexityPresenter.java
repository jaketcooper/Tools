package com.safonov.speedreading.training.fragment.concentration.complexity.presenter;

import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.safonov.speedreading.training.fragment.concentration.complexity.view.IConcentrationComplexityFragment;

public interface IConcentrationComplexityPresenter extends MvpPresenter<IConcentrationComplexityFragment> {
    void initConfig(int i);

    void setComplexity(int i);
}
