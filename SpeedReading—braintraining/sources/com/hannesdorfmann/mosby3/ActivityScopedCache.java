package com.hannesdorfmann.mosby3;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.p000v4.util.ArrayMap;
import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.hannesdorfmann.mosby3.mvp.MvpView;
import java.util.Map;

class ActivityScopedCache {
    private final Map<String, PresenterHolder> presenterMap = new ArrayMap();

    ActivityScopedCache() {
    }

    public void clear() {
        this.presenterMap.clear();
    }

    @Nullable
    public <P> P getPresenter(@NonNull String viewId) {
        PresenterHolder holder = this.presenterMap.get(viewId);
        if (holder == null) {
            return null;
        }
        return holder.presenter;
    }

    @Nullable
    public <VS> VS getViewState(@NonNull String viewId) {
        PresenterHolder holder = this.presenterMap.get(viewId);
        if (holder == null) {
            return null;
        }
        return holder.viewState;
    }

    public void putPresenter(@NonNull String viewId, @NonNull MvpPresenter<? extends MvpView> presenter) {
        if (viewId == null) {
            throw new NullPointerException("ViewId is null");
        } else if (presenter == null) {
            throw new NullPointerException("Presenter is null");
        } else {
            PresenterHolder presenterHolder = this.presenterMap.get(viewId);
            if (presenterHolder == null) {
                PresenterHolder presenterHolder2 = new PresenterHolder();
                MvpPresenter unused = presenterHolder2.presenter = presenter;
                this.presenterMap.put(viewId, presenterHolder2);
                return;
            }
            MvpPresenter unused2 = presenterHolder.presenter = presenter;
        }
    }

    public void putViewState(@NonNull String viewId, @NonNull Object viewState) {
        if (viewId == null) {
            throw new NullPointerException("ViewId is null");
        } else if (viewState == null) {
            throw new NullPointerException("ViewState is null");
        } else {
            PresenterHolder presenterHolder = this.presenterMap.get(viewId);
            if (presenterHolder == null) {
                PresenterHolder presenterHolder2 = new PresenterHolder();
                Object unused = presenterHolder2.viewState = viewState;
                this.presenterMap.put(viewId, presenterHolder2);
                return;
            }
            Object unused2 = presenterHolder.viewState = viewState;
        }
    }

    public void remove(@NonNull String viewId) {
        if (viewId == null) {
            throw new NullPointerException("View Id is null");
        }
        this.presenterMap.remove(viewId);
    }

    static final class PresenterHolder {
        /* access modifiers changed from: private */
        public MvpPresenter<?> presenter;
        /* access modifiers changed from: private */
        public Object viewState;

        PresenterHolder() {
        }
    }
}
