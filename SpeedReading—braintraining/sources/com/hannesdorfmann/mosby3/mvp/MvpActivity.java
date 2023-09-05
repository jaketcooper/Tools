package com.hannesdorfmann.mosby3.mvp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.p003v7.app.AppCompatActivity;
import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.hannesdorfmann.mosby3.mvp.MvpView;
import com.hannesdorfmann.mosby3.mvp.delegate.ActivityMvpDelegate;
import com.hannesdorfmann.mosby3.mvp.delegate.ActivityMvpDelegateImpl;
import com.hannesdorfmann.mosby3.mvp.delegate.MvpDelegateCallback;

public abstract class MvpActivity<V extends MvpView, P extends MvpPresenter<V>> extends AppCompatActivity implements MvpView, MvpDelegateCallback<V, P> {
    protected ActivityMvpDelegate mvpDelegate;
    protected P presenter;
    protected boolean retainInstance;

    @NonNull
    public abstract P createPresenter();

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getMvpDelegate().onCreate(savedInstanceState);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        getMvpDelegate().onDestroy();
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        getMvpDelegate().onSaveInstanceState(outState);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        getMvpDelegate().onPause();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        getMvpDelegate().onResume();
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        getMvpDelegate().onStart();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        getMvpDelegate().onStop();
    }

    /* access modifiers changed from: protected */
    public void onRestart() {
        super.onRestart();
        getMvpDelegate().onRestart();
    }

    public void onContentChanged() {
        super.onContentChanged();
        getMvpDelegate().onContentChanged();
    }

    /* access modifiers changed from: protected */
    public void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        getMvpDelegate().onPostCreate(savedInstanceState);
    }

    /* access modifiers changed from: protected */
    @NonNull
    public ActivityMvpDelegate<V, P> getMvpDelegate() {
        if (this.mvpDelegate == null) {
            this.mvpDelegate = new ActivityMvpDelegateImpl(this, this, true);
        }
        return this.mvpDelegate;
    }

    @NonNull
    public P getPresenter() {
        return this.presenter;
    }

    public void setPresenter(@NonNull P presenter2) {
        this.presenter = presenter2;
    }

    @NonNull
    public V getMvpView() {
        return this;
    }
}
