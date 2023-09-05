package com.safonov.speedreading.reader.library.activity.view;

import com.hannesdorfmann.mosby3.mvp.MvpView;
import com.safonov.speedreading.reader.library.fileexplorer.view.FileExplorerFragmentListener;
import com.safonov.speedreading.reader.library.library.view.LibraryFragmentListener;
import com.safonov.speedreading.reader.repository.entity.BookDescription;

public interface ILibraryView extends MvpView, LibraryFragmentListener, FileExplorerFragmentListener {
    void finish();

    void onFileExplorerBackPressed();

    void setBookDetailFragment(BookDescription bookDescription);

    void setFileExplorerFragment();

    void setLibraryFragment();
}
