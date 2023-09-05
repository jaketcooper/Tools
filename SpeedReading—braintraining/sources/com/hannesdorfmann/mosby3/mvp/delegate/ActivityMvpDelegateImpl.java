package com.hannesdorfmann.mosby3.mvp.delegate;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import com.hannesdorfmann.mosby3.PresenterManager;
import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.hannesdorfmann.mosby3.mvp.MvpView;
import java.util.UUID;

public class ActivityMvpDelegateImpl<V extends MvpView, P extends MvpPresenter<V>> implements ActivityMvpDelegate {
    public static boolean DEBUG = false;
    private static final String DEBUG_TAG = "ActivityMvpDelegateImpl";
    protected static final String KEY_MOSBY_VIEW_ID = "com.hannesdorfmann.mosby3.activity.mvp.id";
    protected Activity activity;
    private MvpDelegateCallback<V, P> delegateCallback;
    protected boolean keepPresenterInstance;
    protected String mosbyViewId = null;

    public ActivityMvpDelegateImpl(@NonNull Activity activity2, @NonNull MvpDelegateCallback<V, P> delegateCallback2, boolean keepPresenterInstance2) {
        if (activity2 == null) {
            throw new NullPointerException("Activity is null!");
        } else if (delegateCallback2 == null) {
            throw new NullPointerException("MvpDelegateCallback is null!");
        } else {
            this.delegateCallback = delegateCallback2;
            this.activity = activity2;
            this.keepPresenterInstance = keepPresenterInstance2;
        }
    }

    static boolean retainPresenterInstance(boolean keepPresenterInstance2, Activity activity2) {
        return keepPresenterInstance2 && (activity2.isChangingConfigurations() || !activity2.isFinishing());
    }

    private P createViewIdAndCreatePresenter() {
        P presenter = this.delegateCallback.createPresenter();
        if (presenter == null) {
            throw new NullPointerException("Presenter returned from createPresenter() is null. Activity is " + this.activity);
        }
        if (this.keepPresenterInstance) {
            this.mosbyViewId = UUID.randomUUID().toString();
            PresenterManager.putPresenter(this.activity, this.mosbyViewId, presenter);
        }
        return presenter;
    }

    public void onCreate(Bundle bundle) {
        P presenter;
        if (bundle == null || !this.keepPresenterInstance) {
            presenter = createViewIdAndCreatePresenter();
            if (DEBUG) {
                Log.d(DEBUG_TAG, "New presenter " + presenter + " for view " + getMvpView());
            }
        } else {
            this.mosbyViewId = bundle.getString(KEY_MOSBY_VIEW_ID);
            if (DEBUG) {
                Log.d(DEBUG_TAG, "MosbyView ID = " + this.mosbyViewId + " for MvpView: " + this.delegateCallback.getMvpView());
            }
            if (this.mosbyViewId == null || (presenter = (MvpPresenter) PresenterManager.getPresenter(this.activity, this.mosbyViewId)) == null) {
                presenter = createViewIdAndCreatePresenter();
                if (DEBUG) {
                    Log.d(DEBUG_TAG, "No presenter found although view Id was here: " + this.mosbyViewId + ". Most likely this was caused by a process death. New Presenter created" + presenter + " for view " + getMvpView());
                }
            } else if (DEBUG) {
                Log.d(DEBUG_TAG, "Reused presenter " + presenter + " for view " + this.delegateCallback.getMvpView());
            }
        }
        if (presenter == null) {
            throw new IllegalStateException("Oops, Presenter is null. This seems to be a Mosby internal bug. Please report this issue here: https://github.com/sockeqwe/mosby/issues");
        }
        this.delegateCallback.setPresenter(presenter);
        getPresenter().attachView(getMvpView());
        if (DEBUG) {
            Log.d(DEBUG_TAG, "View" + getMvpView() + " attached to Presenter " + presenter);
        }
    }

    private P getPresenter() {
        P presenter = this.delegateCallback.getPresenter();
        if (presenter != null) {
            return presenter;
        }
        throw new NullPointerException("Presenter returned from getPresenter() is null");
    }

    private V getMvpView() {
        V view = this.delegateCallback.getMvpView();
        if (view != null) {
            return view;
        }
        throw new NullPointerException("View returned from getMvpView() is null");
    }

    public void onDestroy() {
        boolean retainPresenterInstance = retainPresenterInstance(this.keepPresenterInstance, this.activity);
        getPresenter().detachView(retainPresenterInstance);
        if (!retainPresenterInstance && this.mosbyViewId != null) {
            PresenterManager.remove(this.activity, this.mosbyViewId);
        }
        if (!DEBUG) {
            return;
        }
        if (retainPresenterInstance) {
            Log.d(DEBUG_TAG, "View" + getMvpView() + " destroyed temporarily. View detached from presenter " + getPresenter());
        } else {
            Log.d(DEBUG_TAG, "View" + getMvpView() + " destroyed permanently. View detached permanently from presenter " + getPresenter());
        }
    }

    public void onPause() {
    }

    public void onResume() {
    }

    public void onStart() {
    }

    public void onStop() {
    }

    public void onRestart() {
    }

    public void onContentChanged() {
    }

    public void onSaveInstanceState(Bundle outState) {
        if (this.keepPresenterInstance && outState != null) {
            outState.putString(KEY_MOSBY_VIEW_ID, this.mosbyViewId);
            if (DEBUG) {
                Log.d(DEBUG_TAG, "Saving MosbyViewId into Bundle. ViewId: " + this.mosbyViewId + " for view " + getMvpView());
            }
        }
    }

    public void onPostCreate(Bundle savedInstanceState) {
    }
}
