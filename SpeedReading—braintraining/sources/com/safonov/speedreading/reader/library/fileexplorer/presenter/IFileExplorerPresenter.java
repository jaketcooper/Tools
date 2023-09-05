package com.safonov.speedreading.reader.library.fileexplorer.presenter;

import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.safonov.speedreading.reader.library.activity.view.BackPressedListener;
import com.safonov.speedreading.reader.library.fileexplorer.view.IFileExplorerView;

public interface IFileExplorerPresenter extends MvpPresenter<IFileExplorerView>, BackPressedListener {
    void init();

    void onItemClick(int i);
}
