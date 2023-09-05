package com.safonov.speedreading.training.fragment.wordscolumns.training.view;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.p000v4.content.ContextCompat;
import android.support.p003v7.widget.GridLayout;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.google.android.gms.ads.AdView;
import com.speedreading.alexander.speedreading.R;

public class WordColumnsFragment_ViewBinding implements Unbinder {
    private WordColumnsFragment target;
    private View view2131296682;
    private View view2131296712;

    @UiThread
    public WordColumnsFragment_ViewBinding(final WordColumnsFragment target2, View source) {
        this.target = target2;
        target2.adView = (AdView) Utils.findRequiredViewAsType(source, R.id.ad_view, "field 'adView'", AdView.class);
        target2.timeTextView = (TextView) Utils.findRequiredViewAsType(source, R.id.time_text_view, "field 'timeTextView'", TextView.class);
        target2.speedTextView = (TextView) Utils.findRequiredViewAsType(source, R.id.speed_text_view, "field 'speedTextView'", TextView.class);
        target2.gridLayout = (GridLayout) Utils.findRequiredViewAsType(source, R.id.grid_layout, "field 'gridLayout'", GridLayout.class);
        View view = Utils.findRequiredView(source, R.id.speed_down_view, "method 'onSpeedDownViewClick'");
        this.view2131296682 = view;
        view.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target2.onSpeedDownViewClick();
            }
        });
        View view2 = Utils.findRequiredView(source, R.id.speed_up_view, "method 'onSpeedUpViewClick'");
        this.view2131296712 = view2;
        view2.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target2.onSpeedUpViewClick();
            }
        });
        target2.itemTextColor = ContextCompat.getColor(source.getContext(), 17170436);
    }

    @CallSuper
    public void unbind() {
        WordColumnsFragment target2 = this.target;
        if (target2 == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        target2.adView = null;
        target2.timeTextView = null;
        target2.speedTextView = null;
        target2.gridLayout = null;
        this.view2131296682.setOnClickListener((View.OnClickListener) null);
        this.view2131296682 = null;
        this.view2131296712.setOnClickListener((View.OnClickListener) null);
        this.view2131296712 = null;
    }
}
