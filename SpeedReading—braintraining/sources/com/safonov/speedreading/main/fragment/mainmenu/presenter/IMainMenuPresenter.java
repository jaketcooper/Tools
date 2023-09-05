package com.safonov.speedreading.main.fragment.mainmenu.presenter;

import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.safonov.speedreading.main.fragment.mainmenu.view.IMainMenuView;

public interface IMainMenuPresenter extends MvpPresenter<IMainMenuView> {
    void init();
}
