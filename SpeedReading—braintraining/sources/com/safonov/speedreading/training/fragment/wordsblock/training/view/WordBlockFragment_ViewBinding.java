package com.safonov.speedreading.training.fragment.wordsblock.training.view;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.google.android.gms.ads.AdView;
import com.speedreading.alexander.speedreading.R;

public class WordBlockFragment_ViewBinding implements Unbinder {
    private WordBlockFragment target;
    private View view2131296360;
    private View view2131296531;
    private View view2131296532;
    private View view2131296682;
    private View view2131296712;

    @UiThread
    public WordBlockFragment_ViewBinding(final WordBlockFragment target2, View source) {
        this.target = target2;
        target2.adView = (AdView) Utils.findRequiredViewAsType(source, R.id.ad_view, "field 'adView'", AdView.class);
        target2.timeTextView = (TextView) Utils.findRequiredViewAsType(source, R.id.time_text_view, "field 'timeTextView'", TextView.class);
        target2.speedTextView = (TextView) Utils.findRequiredViewAsType(source, R.id.speed_text_view, "field 'speedTextView'", TextView.class);
        target2.wordCountTextView = (TextView) Utils.findRequiredViewAsType(source, R.id.word_count_text_view, "field 'wordCountTextView'", TextView.class);
        target2.itemTextView = (TextView) Utils.findRequiredViewAsType(source, R.id.item_text_view, "field 'itemTextView'", TextView.class);
        View view = Utils.findRequiredView(source, R.id.content_view, "method 'onContentViewClick'");
        this.view2131296360 = view;
        view.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target2.onContentViewClick();
            }
        });
        View view2 = Utils.findRequiredView(source, R.id.speed_down_view, "method 'onSpeedDownViewClick'");
        this.view2131296682 = view2;
        view2.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target2.onSpeedDownViewClick();
            }
        });
        View view3 = Utils.findRequiredView(source, R.id.speed_up_view, "method 'onSpeedUpViewClick'");
        this.view2131296712 = view3;
        view3.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target2.onSpeedUpViewClick();
            }
        });
        View view4 = Utils.findRequiredView(source, R.id.navigation_pencil_frame_plus_view, "method 'onPlusViewClick'");
        this.view2131296532 = view4;
        view4.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target2.onPlusViewClick();
            }
        });
        View view5 = Utils.findRequiredView(source, R.id.navigation_pencil_frame_minus_view, "method 'onMinusViewClick'");
        this.view2131296531 = view5;
        view5.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target2.onMinusViewClick();
            }
        });
    }

    @CallSuper
    public void unbind() {
        WordBlockFragment target2 = this.target;
        if (target2 == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        target2.adView = null;
        target2.timeTextView = null;
        target2.speedTextView = null;
        target2.wordCountTextView = null;
        target2.itemTextView = null;
        this.view2131296360.setOnClickListener((View.OnClickListener) null);
        this.view2131296360 = null;
        this.view2131296682.setOnClickListener((View.OnClickListener) null);
        this.view2131296682 = null;
        this.view2131296712.setOnClickListener((View.OnClickListener) null);
        this.view2131296712 = null;
        this.view2131296532.setOnClickListener((View.OnClickListener) null);
        this.view2131296532 = null;
        this.view2131296531.setOnClickListener((View.OnClickListener) null);
        this.view2131296531 = null;
    }
}
