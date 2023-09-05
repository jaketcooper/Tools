package com.safonov.speedreading.reader.library.library.presenter;

import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.safonov.speedreading.reader.library.library.view.ILibraryView;

public interface ILibraryPresenter extends MvpPresenter<ILibraryView> {
    void init();

    void onFormatDialogDismiss(boolean z);

    void onItemClick(long j);

    void onItemLongClick(long j);

    void requestToAddBook();

    void requestToRemoveBook();

    void setSpeedReadingBookInfo(long j);
}
