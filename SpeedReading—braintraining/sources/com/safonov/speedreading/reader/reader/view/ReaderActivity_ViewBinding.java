package com.safonov.speedreading.reader.reader.view;

import android.content.Context;
import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.p000v4.content.ContextCompat;
import android.support.p003v7.widget.AppCompatSeekBar;
import android.support.p003v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.speedreading.alexander.speedreading.R;

public class ReaderActivity_ViewBinding implements Unbinder {
    private ReaderActivity target;
    private View view2131296526;
    private View view2131296528;
    private View view2131296529;
    private View view2131296531;
    private View view2131296532;
    private View view2131296534;

    @UiThread
    public ReaderActivity_ViewBinding(ReaderActivity target2) {
        this(target2, target2.getWindow().getDecorView());
    }

    @UiThread
    public ReaderActivity_ViewBinding(final ReaderActivity target2, View source) {
        this.target = target2;
        target2.toolbar = (Toolbar) Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
        target2.pageTextView = (TextView) Utils.findRequiredViewAsType(source, R.id.page_text_view, "field 'pageTextView'", TextView.class);
        target2.speedTextView = (TextView) Utils.findRequiredViewAsType(source, R.id.speed_text_view, "field 'speedTextView'", TextView.class);
        target2.progressBar = (ProgressBar) Utils.findRequiredViewAsType(source, R.id.progress_bar, "field 'progressBar'", ProgressBar.class);
        target2.contentTextView = (TextView) Utils.findRequiredViewAsType(source, R.id.content_text_view, "field 'contentTextView'", TextView.class);
        target2.navigationView = Utils.findRequiredView(source, R.id.navigation_view, "field 'navigationView'");
        target2.navigationSeekBar = (AppCompatSeekBar) Utils.findRequiredViewAsType(source, R.id.navigation_seek_bar, "field 'navigationSeekBar'", AppCompatSeekBar.class);
        View view = Utils.findRequiredView(source, R.id.navigation_page_text_view, "field 'navigationPageTextView' and method 'onNavigationPageViewClick'");
        target2.navigationPageTextView = (TextView) Utils.castView(view, R.id.navigation_page_text_view, "field 'navigationPageTextView'", TextView.class);
        this.view2131296529 = view;
        view.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target2.onNavigationPageViewClick();
            }
        });
        View view2 = Utils.findRequiredView(source, R.id.navigation_chapter_title_text_view, "field 'navigationChapterTitleTextView' and method 'onNavigationChapterClick'");
        target2.navigationChapterTitleTextView = (TextView) Utils.castView(view2, R.id.navigation_chapter_title_text_view, "field 'navigationChapterTitleTextView'", TextView.class);
        this.view2131296526 = view2;
        view2.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target2.onNavigationChapterClick();
            }
        });
        target2.frameView = Utils.findRequiredView(source, R.id.pencil_frame_view, "field 'frameView'");
        target2.frameLayout = Utils.findRequiredView(source, R.id.pencil_frame_layout, "field 'frameLayout'");
        target2.pencilFrameLayout = Utils.findRequiredView(source, R.id.navigation_pencil_frame_layout, "field 'pencilFrameLayout'");
        target2.lineCountTextView = (TextView) Utils.findRequiredViewAsType(source, R.id.navigation_pencil_frame_selected_line_count_text_view, "field 'lineCountTextView'", TextView.class);
        target2.timeTextView = (TextView) Utils.findRequiredViewAsType(source, R.id.time_text_view, "field 'timeTextView'", TextView.class);
        View view3 = Utils.findRequiredView(source, R.id.navigation_pencil_frame_minus_view, "method 'onMib'");
        this.view2131296531 = view3;
        view3.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target2.onMib();
            }
        });
        View view4 = Utils.findRequiredView(source, R.id.navigation_pencil_frame_plus_view, "method 'onPlb'");
        this.view2131296532 = view4;
        view4.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target2.onPlb();
            }
        });
        View view5 = Utils.findRequiredView(source, R.id.navigation_previous_page_view, "method 'onNavigationPreviousPageClick'");
        this.view2131296534 = view5;
        view5.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target2.onNavigationPreviousPageClick();
            }
        });
        View view6 = Utils.findRequiredView(source, R.id.navigation_next_page_view, "method 'onNavigationNextPageClick'");
        this.view2131296528 = view6;
        view6.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target2.onNavigationNextPageClick();
            }
        });
        Context context = source.getContext();
        target2.blackColor = ContextCompat.getColor(context, 17170435);
        target2.greyColor = ContextCompat.getColor(context, 17170437);
    }

    @CallSuper
    public void unbind() {
        ReaderActivity target2 = this.target;
        if (target2 == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        target2.toolbar = null;
        target2.pageTextView = null;
        target2.speedTextView = null;
        target2.progressBar = null;
        target2.contentTextView = null;
        target2.navigationView = null;
        target2.navigationSeekBar = null;
        target2.navigationPageTextView = null;
        target2.navigationChapterTitleTextView = null;
        target2.frameView = null;
        target2.frameLayout = null;
        target2.pencilFrameLayout = null;
        target2.lineCountTextView = null;
        target2.timeTextView = null;
        this.view2131296529.setOnClickListener((View.OnClickListener) null);
        this.view2131296529 = null;
        this.view2131296526.setOnClickListener((View.OnClickListener) null);
        this.view2131296526 = null;
        this.view2131296531.setOnClickListener((View.OnClickListener) null);
        this.view2131296531 = null;
        this.view2131296532.setOnClickListener((View.OnClickListener) null);
        this.view2131296532 = null;
        this.view2131296534.setOnClickListener((View.OnClickListener) null);
        this.view2131296534 = null;
        this.view2131296528.setOnClickListener((View.OnClickListener) null);
        this.view2131296528 = null;
    }
}
