package com.hannesdorfmann.mosby3.mvp.delegate;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.hannesdorfmann.mosby3.mvp.MvpView;

public interface FragmentMvpDelegate<V extends MvpView, P extends MvpPresenter<V>> {
    void onActivityCreated(Bundle bundle);

    void onAttach(Activity activity);

    void onCreate(Bundle bundle);

    void onDestroy();

    void onDestroyView();

    void onDetach();

    void onPause();

    void onResume();

    void onSaveInstanceState(Bundle bundle);

    void onStart();

    void onStop();

    void onViewCreated(View view, @Nullable Bundle bundle);
}
