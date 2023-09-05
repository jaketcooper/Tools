package com.hannesdorfmann.mosby3.mvp.delegate;

import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import android.util.Log;
import android.view.View;
import com.hannesdorfmann.mosby3.PresenterManager;
import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.hannesdorfmann.mosby3.mvp.MvpView;
import com.hannesdorfmann.mosby3.mvp.viewstate.RestorableViewState;
import com.hannesdorfmann.mosby3.mvp.viewstate.ViewState;

public class FragmentMvpViewStateDelegateImpl<V extends MvpView, P extends MvpPresenter<V>, VS extends ViewState<V>> extends FragmentMvpDelegateImpl<V, P> {
    public static boolean DEBUG = false;
    private static final String DEBUG_TAG = "FragmentMvpDelegateImpl";
    private boolean applyViewState = false;
    private boolean applyViewStateFromMemory = false;
    private MvpViewStateDelegateCallback<V, P, VS> delegateCallback;

    public FragmentMvpViewStateDelegateImpl(Fragment fragment, MvpViewStateDelegateCallback<V, P, VS> delegateCallback2, boolean keepPresenterAndViewStateDuringScreenOrientationChange, boolean keepPresenterAndViewStateOnBackstack) {
        super(fragment, delegateCallback2, keepPresenterAndViewStateDuringScreenOrientationChange, keepPresenterAndViewStateOnBackstack);
        this.delegateCallback = delegateCallback2;
    }

    public void onViewCreated(View view, Bundle bundle) {
        VS restoredViewState;
        VS viewState;
        super.onViewCreated(view, bundle);
        if (bundle != null && this.keepPresenterInstanceDuringScreenOrientationChanges) {
            this.mosbyViewId = bundle.getString("com.hannesdorfmann.mosby3.fragment.mvp.id");
            if (DEBUG) {
                Log.d(DEBUG_TAG, "MosbyView ID = " + this.mosbyViewId + " for MvpView: " + this.delegateCallback.getMvpView());
            }
        }
        if (this.mosbyViewId == null || (viewState = (ViewState) PresenterManager.getViewState(this.fragment.getActivity(), this.mosbyViewId)) == null) {
            VS viewState2 = this.delegateCallback.createViewState();
            if (viewState2 == null) {
                throw new NullPointerException("ViewState returned from createViewState() is null! MvpView that has returned null as ViewState is: " + this.delegateCallback.getMvpView());
            } else if (bundle == null || !(viewState2 instanceof RestorableViewState) || (restoredViewState = ((RestorableViewState) viewState2).restoreInstanceState(bundle)) == null) {
                if (this.keepPresenterInstanceDuringScreenOrientationChanges) {
                    if (this.mosbyViewId == null) {
                        throw new IllegalStateException("The (internal) Mosby View id is null. This should never happen. This seems to be a Mosby internal error. Please report this issue at https://github.com/sockeqwe/mosby/issues");
                    }
                    PresenterManager.putViewState(this.fragment.getActivity(), this.mosbyViewId, viewState2);
                }
                this.delegateCallback.setViewState(viewState2);
                this.applyViewState = false;
                this.applyViewStateFromMemory = false;
                if (DEBUG) {
                    Log.d(DEBUG_TAG, "Created a new ViewState instance for view: " + this.delegateCallback.getMvpView() + " viewState: " + viewState2);
                }
            } else {
                VS viewState3 = restoredViewState;
                this.delegateCallback.setViewState(viewState3);
                this.applyViewState = true;
                this.applyViewStateFromMemory = false;
                if (this.keepPresenterInstanceDuringScreenOrientationChanges) {
                    if (this.mosbyViewId == null) {
                        throw new IllegalStateException("The (internal) Mosby View id is null although bundle is not null. This should never happen. This seems to be a Mosby internal error. Please report this issue at https://github.com/sockeqwe/mosby/issues");
                    }
                    PresenterManager.putViewState(this.fragment.getActivity(), this.mosbyViewId, viewState3);
                }
                if (DEBUG) {
                    Log.d(DEBUG_TAG, "Recreated ViewState from bundle for view: " + this.delegateCallback.getMvpView() + " viewState: " + viewState3);
                }
            }
        } else {
            this.delegateCallback.setViewState(viewState);
            this.applyViewState = true;
            this.applyViewStateFromMemory = true;
            if (DEBUG) {
                Log.d(DEBUG_TAG, "ViewState reused from Mosby internal cache for view: " + this.delegateCallback.getMvpView() + " viewState: " + viewState);
            }
        }
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (this.applyViewState) {
            VS viewState = this.delegateCallback.getViewState();
            V mvpView = this.delegateCallback.getMvpView();
            if (viewState == null) {
                throw new NullPointerException("ViewState returned from getViewState() is null! MvpView " + mvpView);
            }
            this.delegateCallback.setRestoringViewState(true);
            viewState.apply(mvpView, this.applyViewStateFromMemory);
            this.delegateCallback.setRestoringViewState(false);
            this.delegateCallback.onViewStateInstanceRestored(this.applyViewStateFromMemory);
            return;
        }
        this.delegateCallback.onNewViewStateInstance();
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        boolean keepInstance = retainPresenterInstance();
        VS viewState = this.delegateCallback.getViewState();
        if (viewState == null) {
            throw new NullPointerException("ViewState returned from getViewState() is null! The MvpView that has returned null in getViewState() is " + this.delegateCallback.getMvpView());
        } else if (keepInstance && (viewState instanceof RestorableViewState)) {
            ((RestorableViewState) viewState).saveInstanceState(outState);
        }
    }
}
