package com.hannesdorfmann.mosby3.mvp.delegate;

import android.os.Bundle;
import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.hannesdorfmann.mosby3.mvp.MvpView;

public interface ActivityMvpDelegate<V extends MvpView, P extends MvpPresenter<V>> {
    void onContentChanged();

    void onCreate(Bundle bundle);

    void onDestroy();

    void onPause();

    void onPostCreate(Bundle bundle);

    void onRestart();

    void onResume();

    void onSaveInstanceState(Bundle bundle);

    void onStart();

    void onStop();
}
