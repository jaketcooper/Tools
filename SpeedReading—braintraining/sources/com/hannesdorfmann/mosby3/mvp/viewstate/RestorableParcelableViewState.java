package com.hannesdorfmann.mosby3.mvp.viewstate;

import android.os.Parcelable;
import com.hannesdorfmann.mosby3.mvp.MvpView;

public interface RestorableParcelableViewState<V extends MvpView> extends RestorableViewState<V>, Parcelable {
}
