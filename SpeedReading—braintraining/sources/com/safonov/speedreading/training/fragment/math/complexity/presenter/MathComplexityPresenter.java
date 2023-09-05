package com.safonov.speedreading.training.fragment.math.complexity.presenter;

import android.support.annotation.NonNull;
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;
import com.safonov.speedreading.training.fragment.math.complexity.view.IMathComplexityFragment;
import com.safonov.speedreading.training.fragment.math.repository.IMathRepository;
import com.safonov.speedreading.training.fragment.math.repository.entity.MathConfig;

public class MathComplexityPresenter extends MvpBasePresenter<IMathComplexityFragment> implements IMathComplexityPresenter {
    private MathConfig config;
    private int configId;
    private IMathRepository repository;

    public MathComplexityPresenter(@NonNull IMathRepository repository2) {
        this.repository = repository2;
    }

    public void attachView(IMathComplexityFragment view) {
    }

    public void detachView(boolean retainInstance) {
    }

    public void setComplexity(int complexity) {
        this.repository.updateConfigComplexity(this.configId, complexity);
    }

    public void initConfig(int configId2) {
        this.configId = configId2;
        this.config = this.repository.getConfig(configId2);
    }
}
