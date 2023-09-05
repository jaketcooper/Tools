package com.hannesdorfmann.mosby3.mvp.viewstate.layout;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.hannesdorfmann.mosby3.mvp.MvpView;
import com.hannesdorfmann.mosby3.mvp.delegate.ViewGroupMvpDelegate;
import com.hannesdorfmann.mosby3.mvp.delegate.ViewGroupMvpViewStateDelegateCallback;
import com.hannesdorfmann.mosby3.mvp.delegate.ViewGroupMvpViewStateDelegateImpl;
import com.hannesdorfmann.mosby3.mvp.layout.MvpFrameLayout;
import com.hannesdorfmann.mosby3.mvp.viewstate.ViewState;

public abstract class MvpViewStateFrameLayout<V extends MvpView, P extends MvpPresenter<V>, VS extends ViewState<V>> extends MvpFrameLayout<V, P> implements ViewGroupMvpViewStateDelegateCallback<V, P, VS> {
    private boolean restoringViewState = false;
    protected VS viewState;

    public MvpViewStateFrameLayout(Context context) {
        super(context);
    }

    public MvpViewStateFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MvpViewStateFrameLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(21)
    public MvpViewStateFrameLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    /* access modifiers changed from: protected */
    public ViewGroupMvpDelegate<V, P> getMvpDelegate() {
        if (this.mvpDelegate == null) {
            this.mvpDelegate = new ViewGroupMvpViewStateDelegateImpl(this, this, true);
        }
        return this.mvpDelegate;
    }

    public VS getViewState() {
        return this.viewState;
    }

    public void setViewState(VS viewState2) {
        this.viewState = viewState2;
    }

    public void setRestoringViewState(boolean retstoringViewState) {
        this.restoringViewState = retstoringViewState;
    }

    public boolean isRestoringViewState() {
        return this.restoringViewState;
    }

    public void onViewStateInstanceRestored(boolean instanceStateRetained) {
    }
}
