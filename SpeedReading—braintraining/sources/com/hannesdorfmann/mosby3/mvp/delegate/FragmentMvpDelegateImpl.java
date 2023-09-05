package com.hannesdorfmann.mosby3.mvp.delegate;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.p000v4.app.BackstackAccessor;
import android.support.p000v4.app.Fragment;
import android.util.Log;
import android.view.View;
import com.hannesdorfmann.mosby3.PresenterManager;
import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.hannesdorfmann.mosby3.mvp.MvpView;
import java.util.UUID;

public class FragmentMvpDelegateImpl<V extends MvpView, P extends MvpPresenter<V>> implements FragmentMvpDelegate<V, P> {
    public static boolean DEBUG = false;
    private static final String DEBUG_TAG = "FragmentMvpVSDelegate";
    protected static final String KEY_MOSBY_VIEW_ID = "com.hannesdorfmann.mosby3.fragment.mvp.id";
    private MvpDelegateCallback<V, P> delegateCallback;
    protected Fragment fragment;
    protected final boolean keepPresenterInstanceDuringScreenOrientationChanges;
    protected final boolean keepPresenterOnBackstack;
    protected String mosbyViewId;
    private boolean onViewCreatedCalled = false;

    public FragmentMvpDelegateImpl(@NonNull Fragment fragment2, @NonNull MvpDelegateCallback<V, P> delegateCallback2, boolean keepPresenterDuringScreenOrientationChange, boolean keepPresenterOnBackstack2) {
        if (delegateCallback2 == null) {
            throw new NullPointerException("MvpDelegateCallback is null!");
        } else if (fragment2 == null) {
            throw new NullPointerException("Fragment is null!");
        } else if (keepPresenterDuringScreenOrientationChange || !keepPresenterOnBackstack2) {
            this.fragment = fragment2;
            this.delegateCallback = delegateCallback2;
            this.keepPresenterInstanceDuringScreenOrientationChanges = keepPresenterDuringScreenOrientationChange;
            this.keepPresenterOnBackstack = keepPresenterOnBackstack2;
        } else {
            throw new IllegalArgumentException("It is not possible to keep the presenter on backstack, but NOT keep presenter through screen orientation changes. Keep presenter on backstack also requires keep presenter through screen orientation changes to be enabled");
        }
    }

    private P createViewIdAndCreatePresenter() {
        P presenter = this.delegateCallback.createPresenter();
        if (presenter == null) {
            throw new NullPointerException("Presenter returned from createPresenter() is null. Activity is " + getActivity());
        }
        if (this.keepPresenterInstanceDuringScreenOrientationChanges) {
            this.mosbyViewId = UUID.randomUUID().toString();
            PresenterManager.putPresenter(getActivity(), this.mosbyViewId, presenter);
        }
        return presenter;
    }

    public void onViewCreated(View view, @Nullable Bundle bundle) {
        P presenter;
        if (bundle == null || !this.keepPresenterInstanceDuringScreenOrientationChanges) {
            presenter = createViewIdAndCreatePresenter();
            if (DEBUG) {
                Log.d(DEBUG_TAG, "New presenter " + presenter + " for view " + getMvpView());
            }
        } else {
            this.mosbyViewId = bundle.getString(KEY_MOSBY_VIEW_ID);
            if (DEBUG) {
                Log.d(DEBUG_TAG, "MosbyView ID = " + this.mosbyViewId + " for MvpView: " + this.delegateCallback.getMvpView());
            }
            if (this.mosbyViewId == null || (presenter = (MvpPresenter) PresenterManager.getPresenter(getActivity(), this.mosbyViewId)) == null) {
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
        this.onViewCreatedCalled = true;
    }

    @NonNull
    private Activity getActivity() {
        Activity activity = this.fragment.getActivity();
        if (activity != null) {
            return activity;
        }
        throw new NullPointerException("Activity returned by Fragment.getActivity() is null. Fragment is " + this.fragment);
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

    /* access modifiers changed from: protected */
    public boolean retainPresenterInstance() {
        Activity activity = getActivity();
        if (activity.isChangingConfigurations()) {
            return this.keepPresenterInstanceDuringScreenOrientationChanges;
        }
        if (activity.isFinishing()) {
            return false;
        }
        if ((!this.keepPresenterOnBackstack || !BackstackAccessor.isFragmentOnBackStack(this.fragment)) && this.fragment.isRemoving()) {
            return false;
        }
        return true;
    }

    public void onDestroyView() {
        this.onViewCreatedCalled = false;
        Activity activity = getActivity();
        boolean retainPresenterInstance = retainPresenterInstance();
        P presenter = getPresenter();
        presenter.detachView(retainPresenterInstance);
        if (!retainPresenterInstance && this.mosbyViewId != null) {
            PresenterManager.remove(activity, this.mosbyViewId);
        }
        if (DEBUG) {
            Log.d(DEBUG_TAG, "detached MvpView from Presenter. MvpView " + this.delegateCallback.getMvpView() + "   Presenter: " + presenter);
            Log.d(DEBUG_TAG, "Retaining presenter instance: " + Boolean.toString(retainPresenterInstance) + " " + presenter);
        }
    }

    public void onPause() {
    }

    public void onResume() {
    }

    public void onStart() {
        if (!this.onViewCreatedCalled) {
            throw new IllegalStateException("It seems that you are using " + this.delegateCallback.getClass().getCanonicalName() + " as headless (UI less) fragment (because onViewCreated() has not been called or maybe delegation misses that part). Having a Presenter without a View (UI) doesn't make sense. Simply use an usual fragment instead of an MvpFragment if you want to use a UI less Fragment");
        }
    }

    public void onStop() {
    }

    public void onActivityCreated(Bundle savedInstanceState) {
    }

    public void onAttach(Activity activity) {
    }

    public void onDetach() {
    }

    public void onSaveInstanceState(Bundle outState) {
        if ((this.keepPresenterInstanceDuringScreenOrientationChanges || this.keepPresenterOnBackstack) && outState != null) {
            outState.putString(KEY_MOSBY_VIEW_ID, this.mosbyViewId);
            if (DEBUG) {
                Log.d(DEBUG_TAG, "Saving MosbyViewId into Bundle. ViewId: " + this.mosbyViewId);
            }
        }
    }

    public void onCreate(Bundle saved) {
    }

    public void onDestroy() {
    }
}
