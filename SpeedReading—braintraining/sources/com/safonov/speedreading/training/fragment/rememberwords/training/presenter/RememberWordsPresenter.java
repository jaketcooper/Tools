package com.safonov.speedreading.training.fragment.rememberwords.training.presenter;

import android.support.annotation.NonNull;
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;
import com.safonov.speedreading.training.fragment.rememberwords.repository.IRememberWordsRepository;
import com.safonov.speedreading.training.fragment.rememberwords.training.view.IRememberWordsView;

public class RememberWordsPresenter extends MvpBasePresenter<IRememberWordsView> implements IRememerWordsPresenter {
    private IRememberWordsRepository repository;

    public RememberWordsPresenter(@NonNull IRememberWordsRepository repository2) {
        this.repository = repository2;
    }
}
