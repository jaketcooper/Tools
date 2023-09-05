package com.hannesdorfmann.mosby3.mvp.delegate;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import com.hannesdorfmann.mosby3.PresenterManager;
import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.hannesdorfmann.mosby3.mvp.MvpView;
import com.hannesdorfmann.mosby3.mvp.viewstate.RestorableViewState;
import com.hannesdorfmann.mosby3.mvp.viewstate.ViewState;

public class ActivityMvpViewStateDelegateImpl<V extends MvpView, P extends MvpPresenter<V>, VS extends ViewState<V>> extends ActivityMvpDelegateImpl<V, P> {
    public static boolean DEBUG = false;
    private static final String DEBUG_TAG = "ActivityMvpViewStateDel";
    private MvpViewStateDelegateCallback<V, P, VS> delegateCallback;

    public ActivityMvpViewStateDelegateImpl(Activity activity, MvpViewStateDelegateCallback<V, P, VS> delegateCallback2, boolean keepPresenterAndViewState) {
        super(activity, delegateCallback2, keepPresenterAndViewState);
        this.delegateCallback = delegateCallback2;
    }

    private void setViewState(@NonNull VS viewState, boolean applyViewState, boolean applyViewStateFromMemory) {
        if (viewState == null) {
            throw new IllegalStateException("Oops, viewState is null! This seems to be a Mosby internal bug. Please report this issue at https://github.com/sockeqwe/mosby/issues");
        }
        this.delegateCallback.setViewState(viewState);
        if (applyViewState) {
            this.delegateCallback.setRestoringViewState(true);
            this.delegateCallback.getViewState().apply(this.delegateCallback.getMvpView(), applyViewStateFromMemory);
            this.delegateCallback.setRestoringViewState(false);
            this.delegateCallback.onViewStateInstanceRestored(applyViewStateFromMemory);
        }
    }

    public void onPostCreate(Bundle bundle) {
        VS restoredViewState;
        VS viewState;
        super.onPostCreate(bundle);
        if (this.mosbyViewId == null || (viewState = (ViewState) PresenterManager.getViewState(this.activity, this.mosbyViewId)) == null) {
            VS viewState2 = this.delegateCallback.createViewState();
            if (viewState2 == null) {
                throw new NullPointerException("ViewState returned from createViewState() is null! MvpView that has returned null as ViewState is: " + this.delegateCallback.getMvpView());
            } else if (bundle == null || !(viewState2 instanceof RestorableViewState) || (restoredViewState = ((RestorableViewState) viewState2).restoreInstanceState(bundle)) == null) {
                if (this.keepPresenterInstance) {
                    if (this.mosbyViewId == null) {
                        throw new IllegalStateException("The (internal) Mosby View id is null. This should never happen. This seems to be a Mosby internal error. Please report this issue at https://github.com/sockeqwe/mosby/issues");
                    }
                    PresenterManager.putViewState(this.activity, this.mosbyViewId, viewState2);
                }
                setViewState(viewState2, false, false);
                if (DEBUG) {
                    Log.d(DEBUG_TAG, "Created a new ViewState instance for view: " + this.delegateCallback.getMvpView() + " viewState: " + viewState2);
                }
                this.delegateCallback.onNewViewStateInstance();
            } else {
                VS viewState3 = restoredViewState;
                setViewState(viewState3, true, false);
                if (this.keepPresenterInstance) {
                    if (this.mosbyViewId == null) {
                        throw new IllegalStateException("The (internal) Mosby View id is null although bundle is not null. This should never happen. This seems to be a Mosby internal error. Please report this issue at https://github.com/sockeqwe/mosby/issues");
                    }
                    PresenterManager.putViewState(this.activity, this.mosbyViewId, viewState3);
                }
                if (DEBUG) {
                    Log.d(DEBUG_TAG, "Recreated ViewState from bundle for view: " + this.delegateCallback.getMvpView() + " viewState: " + viewState3);
                }
            }
        } else {
            setViewState(viewState, true, true);
            if (DEBUG) {
                Log.d(DEBUG_TAG, "ViewState reused from Mosby internal cache for view: " + this.delegateCallback.getMvpView() + " viewState: " + viewState);
            }
        }
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        boolean keepInstance = retainPresenterInstance(this.keepPresenterInstance, this.activity);
        VS viewState = this.delegateCallback.getViewState();
        if (viewState == null) {
            throw new NullPointerException("ViewState returned from getViewState() is null! The MvpView that has returned null in getViewState() is " + this.delegateCallback.getMvpView());
        } else if (keepInstance && (viewState instanceof RestorableViewState)) {
            ((RestorableViewState) viewState).saveInstanceState(outState);
        }
    }
}
