package com.safonov.speedreading.training.fragment.help.view;

import android.support.annotation.LayoutRes;
import com.hannesdorfmann.mosby3.mvp.MvpView;

public interface IHelpView extends MvpView {
    void setContentLayout(@LayoutRes int i);
}
