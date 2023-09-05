package com.safonov.speedreading.training.fragment.math.complexity.presenter;

import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.safonov.speedreading.training.fragment.math.complexity.view.IMathComplexityFragment;

public interface IMathComplexityPresenter extends MvpPresenter<IMathComplexityFragment> {
    void initConfig(int i);

    void setComplexity(int i);
}
