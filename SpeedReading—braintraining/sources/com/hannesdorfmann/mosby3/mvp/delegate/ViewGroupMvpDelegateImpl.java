package com.hannesdorfmann.mosby3.mvp.delegate;

import android.app.Activity;
import android.content.Context;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import com.hannesdorfmann.mosby3.MosbySavedState;
import com.hannesdorfmann.mosby3.PresenterManager;
import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.hannesdorfmann.mosby3.mvp.MvpView;
import java.util.UUID;

public class ViewGroupMvpDelegateImpl<V extends MvpView, P extends MvpPresenter<V>> implements ViewGroupMvpDelegate<V, P> {
    public static boolean DEBUG = false;
    private static final String DEBUG_TAG = "ViewGroupMvpDelegateImp";
    private final Activity activity;
    private ViewGroupDelegateCallback<V, P> delegateCallback;
    private final boolean isInEditMode;
    private final boolean keepPresenterDuringScreenOrientationChange;
    private String mosbyViewId;

    public ViewGroupMvpDelegateImpl(@NonNull View view, @NonNull ViewGroupDelegateCallback<V, P> delegateCallback2, boolean keepPresenterDuringScreenOrientationChange2) {
        if (view == null) {
            throw new NullPointerException("View is null!");
        } else if (delegateCallback2 == null) {
            throw new NullPointerException("MvpDelegateCallback is null!");
        } else {
            this.delegateCallback = delegateCallback2;
            this.keepPresenterDuringScreenOrientationChange = keepPresenterDuringScreenOrientationChange2;
            this.isInEditMode = view.isInEditMode();
            if (!this.isInEditMode) {
                this.activity = PresenterManager.getActivity(delegateCallback2.getContext());
            } else {
                this.activity = null;
            }
        }
    }

    /* access modifiers changed from: protected */
    public P createViewIdAndCreatePresenter() {
        P presenter = this.delegateCallback.createPresenter();
        if (presenter == null) {
            throw new NullPointerException("Presenter returned from createPresenter() is null.");
        }
        if (this.keepPresenterDuringScreenOrientationChange) {
            Context context = this.delegateCallback.getContext();
            this.mosbyViewId = UUID.randomUUID().toString();
            PresenterManager.putPresenter(PresenterManager.getActivity(context), this.mosbyViewId, presenter);
        }
        return presenter;
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
        if (!this.isInEditMode) {
            if (this.mosbyViewId == null) {
                presenter = createViewIdAndCreatePresenter();
                if (DEBUG) {
                    Log.d(DEBUG_TAG, "new Presenter instance created: " + presenter);
                }
            } else {
                presenter = (MvpPresenter) PresenterManager.getPresenter(this.activity, this.mosbyViewId);
                if (presenter == null) {
                    presenter = createViewIdAndCreatePresenter();
                    if (DEBUG) {
                        Log.d(DEBUG_TAG, "No Presenter instance found in cache, although MosbyView ID present. This was caused by process death, therefore new Presenter instance created: " + presenter);
                    }
                } else if (DEBUG) {
                    Log.d(DEBUG_TAG, "Presenter instance reused from internal cache: " + presenter);
                }
            }
            V view = this.delegateCallback.getMvpView();
            if (view == null) {
                throw new NullPointerException("MvpView returned from getMvpView() is null. Returned by " + this.delegateCallback);
            } else if (presenter == null) {
                throw new IllegalStateException("Oops, Presenter is null. This seems to be a Mosby internal bug. Please report this issue here: https://github.com/sockeqwe/mosby/issues");
            } else {
                this.delegateCallback.setPresenter(presenter);
                presenter.attachView(view);
                if (DEBUG) {
                    Log.d(DEBUG_TAG, "MvpView attached to Presenter. MvpView: " + view + "   Presenter: " + presenter);
                }
            }
        }
    }

    public void onDetachedFromWindow() {
        boolean destroyedPermanently;
        if (!this.isInEditMode) {
            P presenter = this.delegateCallback.getPresenter();
            if (presenter == null) {
                throw new NullPointerException("Presenter returned from delegateCallback.getPresenter() is null");
            } else if (this.keepPresenterDuringScreenOrientationChange) {
                if (!ActivityMvpDelegateImpl.retainPresenterInstance(this.keepPresenterDuringScreenOrientationChange, this.activity)) {
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
                } else if (ActivityMvpDelegateImpl.retainPresenterInstance(this.keepPresenterDuringScreenOrientationChange, this.activity)) {
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
        Parcelable superState = this.delegateCallback.superOnSaveInstanceState();
        if (this.keepPresenterDuringScreenOrientationChange) {
            return new MosbySavedState(superState, this.mosbyViewId);
        }
        return superState;
    }

    private void restoreSavedState(MosbySavedState state) {
        this.mosbyViewId = state.getMosbyViewId();
    }

    public void onRestoreInstanceState(Parcelable state) {
        if (!this.isInEditMode) {
            if (!(state instanceof MosbySavedState)) {
                this.delegateCallback.superOnRestoreInstanceState(state);
                return;
            }
            MosbySavedState savedState = (MosbySavedState) state;
            restoreSavedState(savedState);
            this.delegateCallback.superOnRestoreInstanceState(savedState.getSuperState());
        }
    }
}
