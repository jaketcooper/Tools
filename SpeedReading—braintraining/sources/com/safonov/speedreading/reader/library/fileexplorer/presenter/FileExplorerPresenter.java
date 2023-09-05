package com.safonov.speedreading.reader.library.fileexplorer.presenter;

import android.os.Environment;
import android.support.annotation.NonNull;
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;
import com.safonov.speedreading.reader.library.fileexplorer.async.BookAddAsyncTask;
import com.safonov.speedreading.reader.library.fileexplorer.async.BookAddAsyncTaskListener;
import com.safonov.speedreading.reader.library.fileexplorer.model.FileExplorerFileType;
import com.safonov.speedreading.reader.library.fileexplorer.model.FileExplorerFileWrapper;
import com.safonov.speedreading.reader.library.fileexplorer.util.FileExplorerUtils;
import com.safonov.speedreading.reader.library.fileexplorer.view.IFileExplorerView;
import com.safonov.speedreading.reader.repository.IBookController;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileExplorerPresenter extends MvpBasePresenter<IFileExplorerView> implements IFileExplorerPresenter {
    private IBookController bookController;
    private List<FileExplorerFileWrapper> fileExplorerFileWrapperList = new ArrayList();
    private BookAddAsyncTaskListener listener;
    private final File rootFile = Environment.getExternalStorageDirectory();
    private File selectedFile;

    public FileExplorerPresenter(@NonNull IBookController bookController2, @NonNull BookAddAsyncTaskListener listener2) {
        this.bookController = bookController2;
        this.listener = listener2;
    }

    public void init() {
        setSelectedFile(Environment.getExternalStorageDirectory());
    }

    public void onItemClick(int position) {
        FileExplorerFileWrapper fileWrapper = this.fileExplorerFileWrapperList.get(position);
        switch (fileWrapper.getType()) {
            case PARENT_FOLDER:
            case FOLDER:
                setSelectedFile(fileWrapper.getFile());
                return;
            default:
                new BookAddAsyncTask(this.bookController, this.listener).execute(new String[]{fileWrapper.getFile().getPath()});
                return;
        }
    }

    private void setSelectedFile(File file) {
        this.selectedFile = file;
        this.fileExplorerFileWrapperList.clear();
        if (!file.equals(this.rootFile)) {
            this.fileExplorerFileWrapperList.add(new FileExplorerFileWrapper(file.getParentFile(), FileExplorerFileType.PARENT_FOLDER));
        }
        this.fileExplorerFileWrapperList.addAll(FileExplorerUtils.filterFiles(file.listFiles()));
        if (isViewAttached()) {
            ((IFileExplorerView) getView()).setData(this.fileExplorerFileWrapperList);
            ((IFileExplorerView) getView()).setActionBarTitle(file.getPath());
        }
    }

    public void onBackPressed() {
        if (this.selectedFile.equals(this.rootFile)) {
            ((IFileExplorerView) getView()).closeFileExplorer();
        } else {
            setSelectedFile(this.selectedFile.getParentFile());
        }
    }
}
