package com.safonov.speedreading.training.fragment.concentration.training.presenter;

import android.support.annotation.NonNull;
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;
import com.safonov.speedreading.training.fragment.concentration.repository.IConcentrationRepository;
import com.safonov.speedreading.training.fragment.concentration.training.view.IConcentrationView;

public class ConcentrationPresenter extends MvpBasePresenter<IConcentrationView> implements IConcentrationPresenter {
    private IConcentrationRepository repository;

    public ConcentrationPresenter(@NonNull IConcentrationRepository repository2) {
        this.repository = repository2;
    }
}
