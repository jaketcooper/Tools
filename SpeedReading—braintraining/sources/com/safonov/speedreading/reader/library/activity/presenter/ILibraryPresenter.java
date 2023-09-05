package com.safonov.speedreading.reader.library.activity.presenter;

import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.safonov.speedreading.reader.library.activity.view.ILibraryView;
import com.safonov.speedreading.reader.repository.entity.BookDescription;

public interface ILibraryPresenter extends MvpPresenter<ILibraryView> {
    void init();

    void onActionBarHomePressed();

    void onBackPressed();

    void requestToSetBookDetailFragment(BookDescription bookDescription);

    void requestToSetFileExplorerFragment();

    void requestToSetLibraryFragment();
}
