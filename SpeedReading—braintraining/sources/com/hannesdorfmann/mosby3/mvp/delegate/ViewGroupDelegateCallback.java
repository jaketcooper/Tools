package com.hannesdorfmann.mosby3.mvp.delegate;

import android.content.Context;
import android.os.Parcelable;
import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.hannesdorfmann.mosby3.mvp.MvpView;

public interface ViewGroupDelegateCallback<V extends MvpView, P extends MvpPresenter<V>> extends MvpDelegateCallback<V, P> {
    Context getContext();

    void superOnRestoreInstanceState(Parcelable parcelable);

    Parcelable superOnSaveInstanceState();
}
