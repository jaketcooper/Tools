package com.hannesdorfmann.mosby3.mvp.viewstate;

import com.hannesdorfmann.mosby3.mvp.MvpFragment;
import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.hannesdorfmann.mosby3.mvp.MvpView;
import com.hannesdorfmann.mosby3.mvp.delegate.FragmentMvpDelegate;
import com.hannesdorfmann.mosby3.mvp.delegate.FragmentMvpViewStateDelegateImpl;
import com.hannesdorfmann.mosby3.mvp.delegate.MvpViewStateDelegateCallback;
import com.hannesdorfmann.mosby3.mvp.viewstate.ViewState;

public abstract class MvpViewStateFragment<V extends MvpView, P extends MvpPresenter<V>, VS extends ViewState<V>> extends MvpFragment<V, P> implements MvpViewStateDelegateCallback<V, P, VS> {
    private boolean restoringViewState = false;
    protected VS viewState;

    /* access modifiers changed from: protected */
    public FragmentMvpDelegate<V, P> getMvpDelegate() {
        if (this.mvpDelegate == null) {
            this.mvpDelegate = new FragmentMvpViewStateDelegateImpl(this, this, true, true);
        }
        return this.mvpDelegate;
    }

    public VS getViewState() {
        return this.viewState;
    }

    public void setViewState(VS viewState2) {
        this.viewState = viewState2;
    }

    public void setRestoringViewState(boolean restoringViewState2) {
        this.restoringViewState = restoringViewState2;
    }

    public boolean isRestoringViewState() {
        return this.restoringViewState;
    }

    public void onViewStateInstanceRestored(boolean instanceStateRetained) {
    }
}
