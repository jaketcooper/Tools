package com.safonov.speedreading.reader.library.fileexplorer.view;

import com.hannesdorfmann.mosby3.mvp.MvpView;
import com.safonov.speedreading.reader.library.activity.view.BackPressedListener;
import com.safonov.speedreading.reader.library.fileexplorer.async.BookAddAsyncTaskListener;
import com.safonov.speedreading.reader.library.fileexplorer.model.FileExplorerFileWrapper;
import java.util.List;

public interface IFileExplorerView extends MvpView, BackPressedListener, BookAddAsyncTaskListener {
    void closeFileExplorer();

    void setActionBarTitle(String str);

    void setData(List<FileExplorerFileWrapper> list);
}
