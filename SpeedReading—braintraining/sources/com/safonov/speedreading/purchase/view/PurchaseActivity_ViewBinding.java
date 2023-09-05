package com.safonov.speedreading.purchase.view;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.constraint.ConstraintLayout;
import android.support.p003v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.speedreading.alexander.speedreading.R;

public class PurchaseActivity_ViewBinding implements Unbinder {
    private PurchaseActivity target;
    private View view2131296571;
    private View view2131296576;
    private View view2131296577;
    private View view2131296578;

    @UiThread
    public PurchaseActivity_ViewBinding(PurchaseActivity target2) {
        this(target2, target2.getWindow().getDecorView());
    }

    @UiThread
    public PurchaseActivity_ViewBinding(final PurchaseActivity target2, View source) {
        this.target = target2;
        target2.toolbar = (Toolbar) Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
        target2.purchaseYearPrice = (TextView) Utils.findRequiredViewAsType(source, R.id.premium_year_price, "field 'purchaseYearPrice'", TextView.class);
        target2.purchaseHalfYearPrice = (TextView) Utils.findRequiredViewAsType(source, R.id.premium_halfyear_price, "field 'purchaseHalfYearPrice'", TextView.class);
        target2.purchaseMonthPrice = (TextView) Utils.findRequiredViewAsType(source, R.id.premium_month_price, "field 'purchaseMonthPrice'", TextView.class);
        View view = Utils.findRequiredView(source, R.id.premium_forever_button, "field 'premiumForeverButton' and method 'onPremiumForeverButtonClick'");
        target2.premiumForeverButton = (TextView) Utils.castView(view, R.id.premium_forever_button, "field 'premiumForeverButton'", TextView.class);
        this.view2131296571 = view;
        view.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target2.onPremiumForeverButtonClick();
            }
        });
        View view2 = Utils.findRequiredView(source, R.id.premium_purchase_year_button, "field 'purchaseYearButton' and method 'onPremiumYearButtonClick'");
        target2.purchaseYearButton = (ConstraintLayout) Utils.castView(view2, R.id.premium_purchase_year_button, "field 'purchaseYearButton'", ConstraintLayout.class);
        this.view2131296578 = view2;
        view2.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target2.onPremiumYearButtonClick();
            }
        });
        View view3 = Utils.findRequiredView(source, R.id.premium_purchase_half_year_button, "field 'purchaseHalfYearButton' and method 'onPremiumHalfYearButtonClick'");
        target2.purchaseHalfYearButton = (ConstraintLayout) Utils.castView(view3, R.id.premium_purchase_half_year_button, "field 'purchaseHalfYearButton'", ConstraintLayout.class);
        this.view2131296576 = view3;
        view3.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target2.onPremiumHalfYearButtonClick();
            }
        });
        View view4 = Utils.findRequiredView(source, R.id.premium_purchase_month_button, "field 'purchaseMonthButton' and method 'onPremiumMonthButtonClick'");
        target2.purchaseMonthButton = (ConstraintLayout) Utils.castView(view4, R.id.premium_purchase_month_button, "field 'purchaseMonthButton'", ConstraintLayout.class);
        this.view2131296577 = view4;
        view4.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target2.onPremiumMonthButtonClick();
            }
        });
    }

    @CallSuper
    public void unbind() {
        PurchaseActivity target2 = this.target;
        if (target2 == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        target2.toolbar = null;
        target2.purchaseYearPrice = null;
        target2.purchaseHalfYearPrice = null;
        target2.purchaseMonthPrice = null;
        target2.premiumForeverButton = null;
        target2.purchaseYearButton = null;
        target2.purchaseHalfYearButton = null;
        target2.purchaseMonthButton = null;
        this.view2131296571.setOnClickListener((View.OnClickListener) null);
        this.view2131296571 = null;
        this.view2131296578.setOnClickListener((View.OnClickListener) null);
        this.view2131296578 = null;
        this.view2131296576.setOnClickListener((View.OnClickListener) null);
        this.view2131296576 = null;
        this.view2131296577.setOnClickListener((View.OnClickListener) null);
        this.view2131296577 = null;
    }
}
