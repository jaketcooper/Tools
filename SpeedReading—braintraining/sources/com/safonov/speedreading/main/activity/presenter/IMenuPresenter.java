package com.safonov.speedreading.main.activity.presenter;

import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.safonov.speedreading.main.MenuFragmentListener;
import com.safonov.speedreading.main.activity.view.IMenuView;
import com.safonov.speedreading.reader.repository.entity.BookDescription;

public interface IMenuPresenter extends MvpPresenter<IMenuView>, MenuFragmentListener {
    void onActionBarHelpPressed();

    void onActionBarHomePressed();

    void onActionBarSettingsPressed();

    void onBackPressed();

    void requestToSetBookDetailFragment(BookDescription bookDescription);
}
