package com.hannesdorfmann.mosby3.mvp.viewstate;

import com.hannesdorfmann.mosby3.mvp.MvpActivity;
import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.hannesdorfmann.mosby3.mvp.MvpView;
import com.hannesdorfmann.mosby3.mvp.delegate.ActivityMvpDelegate;
import com.hannesdorfmann.mosby3.mvp.delegate.ActivityMvpViewStateDelegateImpl;
import com.hannesdorfmann.mosby3.mvp.delegate.MvpViewStateDelegateCallback;
import com.hannesdorfmann.mosby3.mvp.viewstate.ViewState;

public abstract class MvpViewStateActivity<V extends MvpView, P extends MvpPresenter<V>, VS extends ViewState<V>> extends MvpActivity<V, P> implements MvpViewStateDelegateCallback<V, P, VS> {
    protected boolean restoringViewState = false;
    protected VS viewState;

    /* access modifiers changed from: protected */
    public ActivityMvpDelegate<V, P> getMvpDelegate() {
        if (this.mvpDelegate == null) {
            this.mvpDelegate = new ActivityMvpViewStateDelegateImpl(this, this, true);
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
