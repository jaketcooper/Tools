package com.safonov.speedreading.training.fragment.evennumbers.training.view;

import android.content.Context;
import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.p000v4.content.ContextCompat;
import android.support.p003v7.widget.GridLayout;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.speedreading.alexander.speedreading.R;

public class EvenNumbersFragment_ViewBinding implements Unbinder {
    private EvenNumbersFragment target;

    @UiThread
    public EvenNumbersFragment_ViewBinding(EvenNumbersFragment target2, View source) {
        this.target = target2;
        target2.scoreTextView = (TextView) Utils.findRequiredViewAsType(source, R.id.score_text_view, "field 'scoreTextView'", TextView.class);
        target2.recordTextView = (TextView) Utils.findRequiredViewAsType(source, R.id.record_text_view, "field 'recordTextView'", TextView.class);
        target2.progressBar = (ProgressBar) Utils.findRequiredViewAsType(source, R.id.progress_bar, "field 'progressBar'", ProgressBar.class);
        target2.gridLayout = (GridLayout) Utils.findRequiredViewAsType(source, R.id.even_numbers_grid_layout, "field 'gridLayout'", GridLayout.class);
        Context context = source.getContext();
        target2.backgroundWhiteColor = ContextCompat.getColor(context, R.color.colorBackground);
        target2.textColorWhite = ContextCompat.getColor(context, 17170443);
        target2.textColorBlack = ContextCompat.getColor(context, 17170435);
        target2.greenColor = ContextCompat.getColor(context, R.color.accept_green);
        target2.redColor = ContextCompat.getColor(context, R.color.reject_red);
    }

    @CallSuper
    public void unbind() {
        EvenNumbersFragment target2 = this.target;
        if (target2 == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        target2.scoreTextView = null;
        target2.recordTextView = null;
        target2.progressBar = null;
        target2.gridLayout = null;
    }
}
