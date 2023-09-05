package com.safonov.speedreading.training.fragment.interstitial.view;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.p003v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.speedreading.alexander.speedreading.R;

public class InterstitialFragment_ViewBinding implements Unbinder {
    private InterstitialFragment target;
    private View view2131296442;
    private View view2131296560;

    @UiThread
    public InterstitialFragment_ViewBinding(final InterstitialFragment target2, View source) {
        this.target = target2;
        target2.recyclerView = (RecyclerView) Utils.findRequiredViewAsType(source, R.id.recycler_view, "field 'recyclerView'", RecyclerView.class);
        target2.pager = (LinearLayout) Utils.findRequiredViewAsType(source, R.id.training_pager, "field 'pager'", LinearLayout.class);
        target2.progressBar = (ProgressBar) Utils.findRequiredViewAsType(source, R.id.pass_course_progress, "field 'progressBar'", ProgressBar.class);
        target2.trainersLeft = (TextView) Utils.findRequiredViewAsType(source, R.id.pass_course_trainers_left, "field 'trainersLeft'", TextView.class);
        target2.topIv = (ImageView) Utils.findRequiredViewAsType(source, R.id.interstitial_top_iv, "field 'topIv'", ImageView.class);
        target2.titleTv = (TextView) Utils.findRequiredViewAsType(source, R.id.interstitial_top_title_tv, "field 'titleTv'", TextView.class);
        View view = Utils.findRequiredView(source, R.id.interstitial_start_button, "method 'onStartButtonClick'");
        this.view2131296442 = view;
        view.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target2.onStartButtonClick();
            }
        });
        View view2 = Utils.findRequiredView(source, R.id.pass_course_restart_iv, "method 'onRestartClick'");
        this.view2131296560 = view2;
        view2.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target2.onRestartClick();
            }
        });
    }

    @CallSuper
    public void unbind() {
        InterstitialFragment target2 = this.target;
        if (target2 == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        target2.recyclerView = null;
        target2.pager = null;
        target2.progressBar = null;
        target2.trainersLeft = null;
        target2.topIv = null;
        target2.titleTv = null;
        this.view2131296442.setOnClickListener((View.OnClickListener) null);
        this.view2131296442 = null;
        this.view2131296560.setOnClickListener((View.OnClickListener) null);
        this.view2131296560 = null;
    }
}
