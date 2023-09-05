package com.hannesdorfmann.mosby3.mvp.viewstate;

import android.os.Bundle;
import android.support.annotation.NonNull;
import com.hannesdorfmann.mosby3.mvp.MvpView;

public interface RestorableViewState<V extends MvpView> extends ViewState<V> {
    RestorableViewState<V> restoreInstanceState(Bundle bundle);

    void saveInstanceState(@NonNull Bundle bundle);
}
