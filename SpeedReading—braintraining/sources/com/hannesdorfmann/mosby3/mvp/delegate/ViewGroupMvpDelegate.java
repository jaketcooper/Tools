package com.hannesdorfmann.mosby3.mvp.delegate;

import android.os.Parcelable;
import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.hannesdorfmann.mosby3.mvp.MvpView;

public interface ViewGroupMvpDelegate<V extends MvpView, P extends MvpPresenter<V>> {
    void onAttachedToWindow();

    void onDetachedFromWindow();

    void onRestoreInstanceState(Parcelable parcelable);

    Parcelable onSaveInstanceState();
}
