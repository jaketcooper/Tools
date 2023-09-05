package com.hannesdorfmann.mosby3.mvp;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.p000v4.app.Fragment;
import android.view.View;
import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.hannesdorfmann.mosby3.mvp.MvpView;
import com.hannesdorfmann.mosby3.mvp.delegate.FragmentMvpDelegate;
import com.hannesdorfmann.mosby3.mvp.delegate.FragmentMvpDelegateImpl;
import com.hannesdorfmann.mosby3.mvp.delegate.MvpDelegateCallback;

public abstract class MvpFragment<V extends MvpView, P extends MvpPresenter<V>> extends Fragment implements MvpDelegateCallback<V, P>, MvpView {
    protected FragmentMvpDelegate<V, P> mvpDelegate;
    /* access modifiers changed from: protected */
    public P presenter;

    public abstract P createPresenter();

    /* access modifiers changed from: protected */
    @NonNull
    public FragmentMvpDelegate<V, P> getMvpDelegate() {
        if (this.mvpDelegate == null) {
            this.mvpDelegate = new FragmentMvpDelegateImpl(this, this, true, true);
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

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getMvpDelegate().onViewCreated(view, savedInstanceState);
    }

    public void onDestroyView() {
        super.onDestroyView();
        getMvpDelegate().onDestroyView();
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getMvpDelegate().onCreate(savedInstanceState);
    }

    public void onDestroy() {
        super.onDestroy();
        getMvpDelegate().onDestroy();
    }

    public void onPause() {
        super.onPause();
        getMvpDelegate().onPause();
    }

    public void onResume() {
        super.onResume();
        getMvpDelegate().onResume();
    }

    public void onStart() {
        super.onStart();
        getMvpDelegate().onStart();
    }

    public void onStop() {
        super.onStop();
        getMvpDelegate().onStop();
    }

    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getMvpDelegate().onActivityCreated(savedInstanceState);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        getMvpDelegate().onAttach(activity);
    }

    public void onDetach() {
        super.onDetach();
        getMvpDelegate().onDetach();
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        getMvpDelegate().onSaveInstanceState(outState);
    }
}
