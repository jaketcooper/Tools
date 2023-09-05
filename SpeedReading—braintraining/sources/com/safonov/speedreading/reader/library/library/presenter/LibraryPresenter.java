package com.safonov.speedreading.reader.library.library.presenter;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;
import com.safonov.speedreading.reader.library.library.async.BookCollectionAsyncTask;
import com.safonov.speedreading.reader.library.library.async.BookCollectionAsyncTaskListener;
import com.safonov.speedreading.reader.library.library.async.BookDeleteAsyncTask;
import com.safonov.speedreading.reader.library.library.async.BookDeleteAsyncTaskListener;
import com.safonov.speedreading.reader.library.library.view.ILibraryView;
import com.safonov.speedreading.reader.repository.IBookController;
import com.safonov.speedreading.reader.repository.entity.BookDescription;
import java.util.List;

public class LibraryPresenter extends MvpBasePresenter<ILibraryView> implements ILibraryPresenter {
    private static final String SHOW_FORMAT_DIALOG_KEY = "show_format_dialog";
    private IBookController bookController;
    /* access modifiers changed from: private */
    public List<BookDescription> itemList;
    /* access modifiers changed from: private */
    public long removeBookId;
    private SharedPreferences sharedPreferences;

    public LibraryPresenter(@NonNull Context context, @NonNull IBookController bookController2) {
        this.sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        this.bookController = bookController2;
    }

    public void init() {
        new BookCollectionAsyncTask(this.bookController, new BookCollectionAsyncTaskListener() {
            public void onCollectionPreExecute() {
                if (LibraryPresenter.this.isViewAttached()) {
                    ((ILibraryView) LibraryPresenter.this.getView()).showLoadingLibraryProgressDialog();
                }
            }

            public void onCollectionPostExecute(@NonNull List<BookDescription> bookDescriptionList) {
                List unused = LibraryPresenter.this.itemList = bookDescriptionList;
                if (LibraryPresenter.this.isViewAttached()) {
                    ((ILibraryView) LibraryPresenter.this.getView()).setItems(bookDescriptionList);
                    ((ILibraryView) LibraryPresenter.this.getView()).dismissProgressDialog();
                }
            }
        }).execute(new Void[0]);
    }

    public void onItemClick(long bookId) {
        if (isViewAttached()) {
            ((ILibraryView) getView()).requestToSetBookDetailFragment(this.bookController.findBookDescription(bookId));
        }
    }

    public void onItemLongClick(long bookId) {
        this.removeBookId = bookId;
        if (isViewAttached()) {
            ((ILibraryView) getView()).showActionDialog(this.bookController.findBookDescription(bookId).getTitle());
        }
    }

    public void requestToRemoveBook() {
        new BookDeleteAsyncTask(this.bookController, new BookDeleteAsyncTaskListener() {
            public void onBookDeletePreExecute() {
                if (LibraryPresenter.this.isViewAttached()) {
                    ((ILibraryView) LibraryPresenter.this.getView()).showRemovingBookProgressDialog();
                }
            }

            public void oBookDeletePostExecute() {
                if (LibraryPresenter.this.isViewAttached()) {
                    ((ILibraryView) LibraryPresenter.this.getView()).removeItem(LibraryPresenter.this.removeBookId);
                    ((ILibraryView) LibraryPresenter.this.getView()).dismissProgressDialog();
                }
            }
        }).execute(new BookDescription[]{this.bookController.findBookDescription(this.removeBookId)});
    }

    public void setSpeedReadingBookInfo(long bookId) {
        ((ILibraryView) getView()).setSpeedReadingBookInfo(this.bookController.findBookDescription(bookId));
    }

    public void requestToAddBook() {
        if (this.sharedPreferences.getBoolean(SHOW_FORMAT_DIALOG_KEY, true)) {
            if (isViewAttached()) {
                ((ILibraryView) getView()).showFormatDialog();
            }
        } else if (isViewAttached()) {
            ((ILibraryView) getView()).requestToSetFileExplorerFragment();
        }
    }

    public void onFormatDialogDismiss(boolean dontShowAgain) {
        this.sharedPreferences.edit().putBoolean(SHOW_FORMAT_DIALOG_KEY, !dontShowAgain).apply();
        if (isViewAttached()) {
            ((ILibraryView) getView()).requestToSetFileExplorerFragment();
        }
    }
}
