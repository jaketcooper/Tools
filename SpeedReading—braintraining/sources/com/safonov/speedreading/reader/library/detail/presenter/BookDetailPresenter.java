package com.safonov.speedreading.reader.library.detail.presenter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;
import com.safonov.speedreading.reader.library.detail.view.IBookDetailView;
import com.safonov.speedreading.reader.repository.entity.BookDescription;

public class BookDetailPresenter extends MvpBasePresenter<IBookDetailView> implements IBookDetailPresenter {
    public void init(BookDescription bookDescription) {
        if (isViewAttached()) {
            Bitmap bookCoverBitmap = BitmapFactory.decodeFile(bookDescription.getCoverImagePath());
            if (bookCoverBitmap != null) {
                ((IBookDetailView) getView()).setCoverView(bookCoverBitmap);
            }
            ((IBookDetailView) getView()).setTitleView(bookDescription.getTitle());
            if (TextUtils.isEmpty(bookDescription.getAuthor())) {
                ((IBookDetailView) getView()).setAuthorViewVisibility(false);
            } else {
                ((IBookDetailView) getView()).setAuthorView(bookDescription.getAuthor());
            }
            if (TextUtils.isEmpty(bookDescription.getLanguage())) {
                ((IBookDetailView) getView()).setLanguageViewVisibility(false);
            } else {
                ((IBookDetailView) getView()).setLanguageView(bookDescription.getLanguage());
            }
            ((IBookDetailView) getView()).setFilePathView(bookDescription.getFilePath());
        }
    }
}
