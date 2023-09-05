package com.hannesdorfmann.mosby3.mvp.viewstate;

import com.hannesdorfmann.mosby3.mvp.MvpView;

public interface ViewState<V extends MvpView> {
    void apply(V v, boolean z);
}
