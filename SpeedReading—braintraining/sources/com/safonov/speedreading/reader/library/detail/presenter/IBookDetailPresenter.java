package com.safonov.speedreading.reader.library.detail.presenter;

import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.safonov.speedreading.reader.library.detail.view.IBookDetailView;
import com.safonov.speedreading.reader.repository.entity.BookDescription;

public interface IBookDetailPresenter extends MvpPresenter<IBookDetailView> {
    void init(BookDescription bookDescription);
}
