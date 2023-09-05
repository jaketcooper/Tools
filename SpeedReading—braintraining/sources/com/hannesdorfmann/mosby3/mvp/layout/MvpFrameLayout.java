package com.hannesdorfmann.mosby3.mvp.layout;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.hannesdorfmann.mosby3.mvp.MvpView;
import com.hannesdorfmann.mosby3.mvp.delegate.ViewGroupDelegateCallback;
import com.hannesdorfmann.mosby3.mvp.delegate.ViewGroupMvpDelegate;
import com.hannesdorfmann.mosby3.mvp.delegate.ViewGroupMvpDelegateImpl;

public abstract class MvpFrameLayout<V extends MvpView, P extends MvpPresenter<V>> extends FrameLayout implements ViewGroupDelegateCallback<V, P>, MvpView {
    protected ViewGroupMvpDelegate<V, P> mvpDelegate;
    protected P presenter;
    private boolean retainInstance = false;

    public abstract P createPresenter();

    public MvpFrameLayout(Context context) {
        super(context);
    }

    public MvpFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MvpFrameLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(21)
    public MvpFrameLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    /* access modifiers changed from: protected */
    @NonNull
    public ViewGroupMvpDelegate<V, P> getMvpDelegate() {
        if (this.mvpDelegate == null) {
            this.mvpDelegate = new ViewGroupMvpDelegateImpl(this, this, true);
        }
        return this.mvpDelegate;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getMvpDelegate().onAttachedToWindow();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getMvpDelegate().onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"MissingSuperCall"})
    public Parcelable onSaveInstanceState() {
        return getMvpDelegate().onSaveInstanceState();
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"MissingSuperCall"})
    public void onRestoreInstanceState(Parcelable state) {
        getMvpDelegate().onRestoreInstanceState(state);
    }

    public P getPresenter() {
        return this.presenter;
    }

    public void setPresenter(P presenter2) {
        this.presenter = presenter2;
    }

    public V getMvpView() {
        return this;
    }

    public final Parcelable superOnSaveInstanceState() {
        return super.onSaveInstanceState();
    }

    public final void superOnRestoreInstanceState(Parcelable state) {
        super.onRestoreInstanceState(state);
    }
}
