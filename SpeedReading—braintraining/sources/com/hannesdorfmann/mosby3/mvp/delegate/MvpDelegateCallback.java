package com.hannesdorfmann.mosby3.mvp.delegate;

import android.support.annotation.NonNull;
import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.hannesdorfmann.mosby3.mvp.MvpView;

public interface MvpDelegateCallback<V extends MvpView, P extends MvpPresenter<V>> {
    @NonNull
    P createPresenter();

    V getMvpView();

    P getPresenter();

    void setPresenter(P p);
}
