package com.hannesdorfmann.mosby3.mvp.delegate;

import android.app.Activity;
import android.content.Context;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import com.hannesdorfmann.mosby3.PresenterManager;
import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.hannesdorfmann.mosby3.mvp.MvpView;
import com.hannesdorfmann.mosby3.mvp.viewstate.RestorableParcelableViewState;
import com.hannesdorfmann.mosby3.mvp.viewstate.ViewState;
import java.util.UUID;

public class ViewGroupMvpViewStateDelegateImpl<V extends MvpView, P extends MvpPresenter<V>, VS extends ViewState<V>> implements ViewGroupMvpDelegate<V, P> {
    public static boolean DEBUG = false;
    private static final String DEBUG_TAG = "ViewGroupMvpDelegateImp";
    private final Activity activity;
    private boolean applyViewState = false;
    private ViewGroupMvpViewStateDelegateCallback<V, P, VS> delegateCallback;
    private final boolean isInEditMode;
    private final boolean keepPresenter;
    private String mosbyViewId;
    private VS restoreableParcelableViewState = null;
    private boolean viewStateFromMemoryRestored = false;

    public ViewGroupMvpViewStateDelegateImpl(@NonNull View view, @NonNull ViewGroupMvpViewStateDelegateCallback<V, P, VS> delegateCallback2, boolean keepPresenter2) {
        if (view == null) {
            throw new NullPointerException("View is null!");
        } else if (delegateCallback2 == null) {
            throw new NullPointerException("MvpDelegateCallback is null!");
        } else {
            this.delegateCallback = delegateCallback2;
            this.keepPresenter = keepPresenter2;
            this.isInEditMode = view.isInEditMode();
            if (!this.isInEditMode) {
                this.activity = PresenterManager.getActivity(delegateCallback2.getContext());
            } else {
                this.activity = null;
            }
        }
    }

    private P createViewIdAndCreatePresenter() {
        P presenter = this.delegateCallback.createPresenter();
        if (presenter == null) {
            throw new NullPointerException("Presenter returned from createPresenter() is null.");
        }
        if (this.keepPresenter) {
            Context context = this.delegateCallback.getContext();
            this.mosbyViewId = UUID.randomUUID().toString();
            PresenterManager.putPresenter(PresenterManager.getActivity(context), this.mosbyViewId, presenter);
        }
        return presenter;
    }

    private VS createViewState() {
        VS viewState = this.delegateCallback.createViewState();
        if (this.keepPresenter) {
            PresenterManager.putViewState(this.activity, this.mosbyViewId, viewState);
        }
        this.applyViewState = false;
        this.viewStateFromMemoryRestored = false;
        return viewState;
    }

    @NonNull
    private Context getContext() {
        Context c = this.delegateCallback.getContext();
        if (c != null) {
            return c;
        }
        throw new NullPointerException("Context returned from " + this.delegateCallback + " is null");
    }

    public void onAttachedToWindow() {
        P presenter;
        VS viewState;
        if (!this.isInEditMode) {
            if (this.mosbyViewId == null) {
                presenter = createViewIdAndCreatePresenter();
                if (DEBUG) {
                    Log.d(DEBUG_TAG, "new Presenter instance created: " + presenter + " MvpView: " + this.delegateCallback.getMvpView());
                }
                viewState = createViewState();
                if (DEBUG) {
                    Log.d(DEBUG_TAG, "new ViewState instance created: " + viewState + " MvpView: " + this.delegateCallback.getMvpView());
                }
            } else {
                presenter = (MvpPresenter) PresenterManager.getPresenter(this.activity, this.mosbyViewId);
                if (presenter == null) {
                    presenter = createViewIdAndCreatePresenter();
                    if (DEBUG) {
                        Log.d(DEBUG_TAG, "No Presenter instance found in cache, although MosbyView ID present. This was caused by process death, therefore new Presenter instance created: " + presenter);
                    }
                } else if (DEBUG) {
                    Log.d(DEBUG_TAG, "Presenter instance reused from internal cache: " + presenter + " MvpView: " + this.delegateCallback.getMvpView());
                }
                viewState = (ViewState) PresenterManager.getViewState(this.activity, this.mosbyViewId);
                if (viewState != null) {
                    this.applyViewState = true;
                    this.viewStateFromMemoryRestored = true;
                    if (DEBUG) {
                        Log.d(DEBUG_TAG, "ViewState instance reused from internal cache: " + viewState + " MvpView: " + this.delegateCallback.getMvpView());
                    }
                } else if (this.restoreableParcelableViewState == null) {
                    viewState = createViewState();
                    if (DEBUG) {
                        Log.d(DEBUG_TAG, "No ViewState instance found in cache, although MosbyView ID present. This was caused by process death, therefore new ViewState instance created: " + viewState);
                    }
                } else {
                    viewState = this.restoreableParcelableViewState;
                    this.applyViewState = true;
                    this.viewStateFromMemoryRestored = false;
                    if (this.keepPresenter) {
                        if (this.mosbyViewId == null) {
                            throw new IllegalStateException("The (internal) Mosby View id is null although restoreable view state (Parcelable) is not null. This should never happen. This seems to be a Mosby internal error. Please report this issue at https://github.com/sockeqwe/mosby/issues");
                        }
                        PresenterManager.putViewState(this.activity, this.mosbyViewId, viewState);
                    }
                    if (DEBUG) {
                        Log.d(DEBUG_TAG, "Parcelable ViewState instance reused from last SavedState: " + viewState + " MvpView: " + this.delegateCallback.getMvpView());
                    }
                }
            }
            V view = this.delegateCallback.getMvpView();
            if (view == null) {
                throw new NullPointerException("MvpView returned from getMvpView() is null. Returned by " + this.delegateCallback);
            } else if (presenter == null) {
                throw new IllegalStateException("Oops, Presenter is null. This seems to be a Mosby internal bug. Please report this issue here: https://github.com/sockeqwe/mosby/issues");
            } else if (viewState == null) {
                throw new IllegalStateException("Oops, ViewState is null. This seems to be a Mosby internal bug. Please report this issue here: https://github.com/sockeqwe/mosby/issues");
            } else {
                this.delegateCallback.setViewState(viewState);
                if (this.applyViewState) {
                    this.delegateCallback.setRestoringViewState(true);
                }
                this.delegateCallback.setPresenter(presenter);
                presenter.attachView(view);
                if (DEBUG) {
                    Log.d(DEBUG_TAG, "MvpView attached to Presenter. MvpView: " + view + "   Presenter: " + presenter);
                }
                if (this.applyViewState) {
                    viewState.apply(view, this.viewStateFromMemoryRestored);
                    this.delegateCallback.setRestoringViewState(false);
                    this.delegateCallback.onViewStateInstanceRestored(this.viewStateFromMemoryRestored);
                    if (DEBUG) {
                        Log.d(DEBUG_TAG, "ViewState restored (from memory = " + this.viewStateFromMemoryRestored + " ). MvpView: " + view + "   ViewState: " + viewState);
                        return;
                    }
                    return;
                }
                this.delegateCallback.onNewViewStateInstance();
            }
        }
    }

    public void onDetachedFromWindow() {
        boolean destroyedPermanently;
        if (!this.isInEditMode) {
            P presenter = this.delegateCallback.getPresenter();
            if (presenter == null) {
                throw new NullPointerException("Presenter returned from delegateCallback.getPresenter() is null");
            } else if (this.keepPresenter) {
                if (!ActivityMvpDelegateImpl.retainPresenterInstance(this.keepPresenter, this.activity)) {
                    destroyedPermanently = true;
                } else {
                    destroyedPermanently = false;
                }
                if (destroyedPermanently) {
                    if (DEBUG) {
                        Log.d(DEBUG_TAG, "Detaching View " + this.delegateCallback.getMvpView() + " from Presenter " + presenter + " and removing presenter permanently from internal cache because the hosting Activity will be destroyed permanently");
                    }
                    if (this.mosbyViewId != null) {
                        PresenterManager.remove(this.activity, this.mosbyViewId);
                    }
                    this.mosbyViewId = null;
                    presenter.detachView(false);
                } else if (ActivityMvpDelegateImpl.retainPresenterInstance(this.keepPresenter, this.activity)) {
                    if (DEBUG) {
                        Log.d(DEBUG_TAG, "Detaching View " + this.delegateCallback.getMvpView() + " from Presenter " + presenter + " temporarily because of orientation change");
                    }
                    presenter.detachView(true);
                }
            } else {
                if (DEBUG) {
                    Log.d(DEBUG_TAG, "Detaching View " + this.delegateCallback.getMvpView() + " from Presenter " + presenter + " permanently");
                }
                presenter.detachView(false);
                if (this.mosbyViewId != null) {
                    PresenterManager.remove(this.activity, this.mosbyViewId);
                }
                this.mosbyViewId = null;
            }
        }
    }

    public Parcelable onSaveInstanceState() {
        if (this.isInEditMode) {
            return null;
        }
        VS viewState = this.delegateCallback.getViewState();
        if (viewState == null) {
            throw new NullPointerException("ViewState returned from getViewState() is null for MvpView " + this.delegateCallback.getMvpView());
        }
        Parcelable superState = this.delegateCallback.superOnSaveInstanceState();
        if (!this.keepPresenter) {
            return superState;
        }
        if (viewState instanceof RestorableParcelableViewState) {
            return new MosbyViewStateSavedState(superState, this.mosbyViewId, (RestorableParcelableViewState) viewState);
        }
        return new MosbyViewStateSavedState(superState, this.mosbyViewId, (RestorableParcelableViewState) null);
    }

    public void onRestoreInstanceState(Parcelable state) {
        if (!this.isInEditMode) {
            if (!(state instanceof MosbyViewStateSavedState)) {
                this.delegateCallback.superOnRestoreInstanceState(state);
                return;
            }
            MosbyViewStateSavedState savedState = (MosbyViewStateSavedState) state;
            this.mosbyViewId = savedState.getMosbyViewId();
            this.restoreableParcelableViewState = savedState.getRestoreableViewState();
            this.delegateCallback.superOnRestoreInstanceState(savedState.getSuperState());
        }
    }
}
