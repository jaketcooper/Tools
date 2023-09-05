package com.safonov.speedreading.training.fragment.description.presenter;

import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.safonov.speedreading.training.FragmentType;
import com.safonov.speedreading.training.fragment.description.view.IDescriptionView;

public interface IDescriptionPresenter extends MvpPresenter<IDescriptionView> {
    void requestToLoadContent(FragmentType fragmentType);

    void setDontShowAgain(FragmentType fragmentType, boolean z);
}
