package com.hannesdorfmann.mosby3.mvp.delegate;

import android.support.annotation.NonNull;
import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.hannesdorfmann.mosby3.mvp.MvpView;
import com.hannesdorfmann.mosby3.mvp.viewstate.ViewState;

public interface MvpViewStateDelegateCallback<V extends MvpView, P extends MvpPresenter<V>, VS extends ViewState<V>> extends MvpDelegateCallback<V, P> {
    @NonNull
    VS createViewState();

    VS getViewState();

    boolean isRestoringViewState();

    void onNewViewStateInstance();

    void onViewStateInstanceRestored(boolean z);

    void setRestoringViewState(boolean z);

    void setViewState(VS vs);
}
