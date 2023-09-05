package com.safonov.speedreading.training.fragment.concentration.complexity.presenter;

import android.support.annotation.NonNull;
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;
import com.safonov.speedreading.training.fragment.concentration.complexity.view.IConcentrationComplexityFragment;
import com.safonov.speedreading.training.fragment.concentration.repository.IConcentrationRepository;
import com.safonov.speedreading.training.fragment.concentration.repository.entity.ConcentrationConfig;

public class ConcentrationComplexityPresenter extends MvpBasePresenter<IConcentrationComplexityFragment> implements IConcentrationComplexityPresenter {
    private ConcentrationConfig config;
    private int configId;
    private IConcentrationRepository repository;

    public ConcentrationComplexityPresenter(@NonNull IConcentrationRepository repository2) {
        this.repository = repository2;
    }

    public void attachView(IConcentrationComplexityFragment view) {
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
