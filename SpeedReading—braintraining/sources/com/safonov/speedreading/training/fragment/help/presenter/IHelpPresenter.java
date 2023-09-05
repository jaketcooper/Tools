package com.safonov.speedreading.training.fragment.help.presenter;

import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.safonov.speedreading.training.FragmentType;
import com.safonov.speedreading.training.fragment.help.view.IHelpView;

public interface IHelpPresenter extends MvpPresenter<IHelpView> {
    void requestToLoadContent(FragmentType fragmentType);
}
