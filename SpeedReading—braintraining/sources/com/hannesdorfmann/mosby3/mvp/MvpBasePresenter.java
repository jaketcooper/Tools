package com.hannesdorfmann.mosby3.mvp;

import android.support.annotation.UiThread;
import com.hannesdorfmann.mosby3.mvp.MvpView;
import java.lang.ref.WeakReference;

public class MvpBasePresenter<V extends MvpView> implements MvpPresenter<V> {
    private WeakReference<V> viewRef;

    @UiThread
    public void attachView(V view) {
        this.viewRef = new WeakReference<>(view);
    }

    @UiThread
    public V getView() {
        if (this.viewRef == null) {
            return null;
        }
        return (MvpView) this.viewRef.get();
    }

    @UiThread
    public boolean isViewAttached() {
        return (this.viewRef == null || this.viewRef.get() == null) ? false : true;
    }

    @UiThread
    public void detachView(boolean retainInstance) {
        if (this.viewRef != null) {
            this.viewRef.clear();
            this.viewRef = null;
        }
    }
}
