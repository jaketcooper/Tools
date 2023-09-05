package com.safonov.speedreading.training.fragment.description.view;

import android.support.annotation.LayoutRes;
import com.hannesdorfmann.mosby3.mvp.MvpView;

public interface IDescriptionView extends MvpView {
    void setContentLayout(@LayoutRes int i);
}
