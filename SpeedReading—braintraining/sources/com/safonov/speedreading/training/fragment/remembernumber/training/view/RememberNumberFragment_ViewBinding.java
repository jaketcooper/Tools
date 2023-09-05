package com.safonov.speedreading.training.fragment.remembernumber.training.view;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.p000v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.speedreading.alexander.speedreading.R;

public class RememberNumberFragment_ViewBinding implements Unbinder {
    private RememberNumberFragment target;
    private View view2131296609;
    private View view2131296610;
    private View view2131296611;
    private View view2131296612;
    private View view2131296613;
    private View view2131296614;
    private View view2131296615;
    private View view2131296616;
    private View view2131296617;
    private View view2131296618;
    private View view2131296619;

    @UiThread
    public RememberNumberFragment_ViewBinding(final RememberNumberFragment target2, View source) {
        this.target = target2;
        target2.scoreTextView = (TextView) Utils.findRequiredViewAsType(source, R.id.score_text_view, "field 'scoreTextView'", TextView.class);
        target2.recordTextView = (TextView) Utils.findRequiredViewAsType(source, R.id.record_text_view, "field 'recordTextView'", TextView.class);
        target2.progressBar = (ProgressBar) Utils.findRequiredViewAsType(source, R.id.progress_bar, "field 'progressBar'", ProgressBar.class);
        target2.cardsLayout = (LinearLayout) Utils.findRequiredViewAsType(source, R.id.remember_number_card_layout, "field 'cardsLayout'", LinearLayout.class);
        View view = Utils.findRequiredView(source, R.id.remember_number_button_1, "method 'onNumberButtonClick'");
        this.view2131296610 = view;
        view.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target2.onNumberButtonClick((Button) Utils.castParam(p0, "doClick", 0, "onNumberButtonClick", 0));
            }
        });
        View view2 = Utils.findRequiredView(source, R.id.remember_number_button_2, "method 'onNumberButtonClick'");
        this.view2131296611 = view2;
        view2.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target2.onNumberButtonClick((Button) Utils.castParam(p0, "doClick", 0, "onNumberButtonClick", 0));
            }
        });
        View view3 = Utils.findRequiredView(source, R.id.remember_number_button_3, "method 'onNumberButtonClick'");
        this.view2131296612 = view3;
        view3.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target2.onNumberButtonClick((Button) Utils.castParam(p0, "doClick", 0, "onNumberButtonClick", 0));
            }
        });
        View view4 = Utils.findRequiredView(source, R.id.remember_number_button_4, "method 'onNumberButtonClick'");
        this.view2131296613 = view4;
        view4.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target2.onNumberButtonClick((Button) Utils.castParam(p0, "doClick", 0, "onNumberButtonClick", 0));
            }
        });
        View view5 = Utils.findRequiredView(source, R.id.remember_number_button_5, "method 'onNumberButtonClick'");
        this.view2131296614 = view5;
        view5.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target2.onNumberButtonClick((Button) Utils.castParam(p0, "doClick", 0, "onNumberButtonClick", 0));
            }
        });
        View view6 = Utils.findRequiredView(source, R.id.remember_number_button_6, "method 'onNumberButtonClick'");
        this.view2131296615 = view6;
        view6.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target2.onNumberButtonClick((Button) Utils.castParam(p0, "doClick", 0, "onNumberButtonClick", 0));
            }
        });
        View view7 = Utils.findRequiredView(source, R.id.remember_number_button_7, "method 'onNumberButtonClick'");
        this.view2131296616 = view7;
        view7.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target2.onNumberButtonClick((Button) Utils.castParam(p0, "doClick", 0, "onNumberButtonClick", 0));
            }
        });
        View view8 = Utils.findRequiredView(source, R.id.remember_number_button_8, "method 'onNumberButtonClick'");
        this.view2131296617 = view8;
        view8.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target2.onNumberButtonClick((Button) Utils.castParam(p0, "doClick", 0, "onNumberButtonClick", 0));
            }
        });
        View view9 = Utils.findRequiredView(source, R.id.remember_number_button_9, "method 'onNumberButtonClick'");
        this.view2131296618 = view9;
        view9.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target2.onNumberButtonClick((Button) Utils.castParam(p0, "doClick", 0, "onNumberButtonClick", 0));
            }
        });
        View view10 = Utils.findRequiredView(source, R.id.remember_number_button_0, "method 'onNumberButtonClick'");
        this.view2131296609 = view10;
        view10.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target2.onNumberButtonClick((Button) Utils.castParam(p0, "doClick", 0, "onNumberButtonClick", 0));
            }
        });
        View view11 = Utils.findRequiredView(source, R.id.remember_number_button_backspace, "method 'onBackspaceButtonClick'");
        this.view2131296619 = view11;
        view11.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target2.onBackspaceButtonClick();
            }
        });
        target2.buttons = Utils.listOf(Utils.findRequiredView(source, R.id.remember_number_button_1, "field 'buttons'"), Utils.findRequiredView(source, R.id.remember_number_button_2, "field 'buttons'"), Utils.findRequiredView(source, R.id.remember_number_button_3, "field 'buttons'"), Utils.findRequiredView(source, R.id.remember_number_button_4, "field 'buttons'"), Utils.findRequiredView(source, R.id.remember_number_button_5, "field 'buttons'"), Utils.findRequiredView(source, R.id.remember_number_button_6, "field 'buttons'"), Utils.findRequiredView(source, R.id.remember_number_button_7, "field 'buttons'"), Utils.findRequiredView(source, R.id.remember_number_button_8, "field 'buttons'"), Utils.findRequiredView(source, R.id.remember_number_button_9, "field 'buttons'"), Utils.findRequiredView(source, R.id.remember_number_button_0, "field 'buttons'"), Utils.findRequiredView(source, R.id.remember_number_button_backspace, "field 'buttons'"));
        Context context = source.getContext();
        Resources res = context.getResources();
        target2.acceptGreen = ContextCompat.getColor(context, R.color.accept_green);
        target2.reject_red = ContextCompat.getColor(context, R.color.reject_red);
        target2.colorAccent = ContextCompat.getColor(context, R.color.colorAccent);
        target2.cardMargin = res.getDimensionPixelSize(R.dimen.remember_number_card_margin);
        target2.cardPadding = res.getDimensionPixelSize(R.dimen.remember_number_card_padding);
    }

    @CallSuper
    public void unbind() {
        RememberNumberFragment target2 = this.target;
        if (target2 == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        target2.scoreTextView = null;
        target2.recordTextView = null;
        target2.progressBar = null;
        target2.cardsLayout = null;
        target2.buttons = null;
        this.view2131296610.setOnClickListener((View.OnClickListener) null);
        this.view2131296610 = null;
        this.view2131296611.setOnClickListener((View.OnClickListener) null);
        this.view2131296611 = null;
        this.view2131296612.setOnClickListener((View.OnClickListener) null);
        this.view2131296612 = null;
        this.view2131296613.setOnClickListener((View.OnClickListener) null);
        this.view2131296613 = null;
        this.view2131296614.setOnClickListener((View.OnClickListener) null);
        this.view2131296614 = null;
        this.view2131296615.setOnClickListener((View.OnClickListener) null);
        this.view2131296615 = null;
        this.view2131296616.setOnClickListener((View.OnClickListener) null);
        this.view2131296616 = null;
        this.view2131296617.setOnClickListener((View.OnClickListener) null);
        this.view2131296617 = null;
        this.view2131296618.setOnClickListener((View.OnClickListener) null);
        this.view2131296618 = null;
        this.view2131296609.setOnClickListener((View.OnClickListener) null);
        this.view2131296609 = null;
        this.view2131296619.setOnClickListener((View.OnClickListener) null);
        this.view2131296619 = null;
    }
}
