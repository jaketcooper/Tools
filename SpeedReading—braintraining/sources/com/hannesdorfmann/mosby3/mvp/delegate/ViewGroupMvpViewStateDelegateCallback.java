package com.hannesdorfmann.mosby3.mvp.delegate;

import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.hannesdorfmann.mosby3.mvp.MvpView;
import com.hannesdorfmann.mosby3.mvp.viewstate.ViewState;

public interface ViewGroupMvpViewStateDelegateCallback<V extends MvpView, P extends MvpPresenter<V>, VS extends ViewState<V>> extends MvpViewStateDelegateCallback<V, P, VS>, ViewGroupDelegateCallback<V, P> {
}
