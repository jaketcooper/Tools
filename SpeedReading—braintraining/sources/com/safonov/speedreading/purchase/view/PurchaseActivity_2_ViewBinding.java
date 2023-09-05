package com.safonov.speedreading.purchase.view;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.p003v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.speedreading.alexander.speedreading.R;

public class PurchaseActivity_2_ViewBinding implements Unbinder {
    private PurchaseActivity_2 target;
    private View view2131296575;

    @UiThread
    public PurchaseActivity_2_ViewBinding(PurchaseActivity_2 target2) {
        this(target2, target2.getWindow().getDecorView());
    }

    @UiThread
    public PurchaseActivity_2_ViewBinding(final PurchaseActivity_2 target2, View source) {
        this.target = target2;
        target2.toolbar = (Toolbar) Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
        View view = Utils.findRequiredView(source, R.id.premium_purchase_forever_button, "field 'purchaseForeverButton' and method 'onPremiumButtonClick'");
        target2.purchaseForeverButton = (TextView) Utils.castView(view, R.id.premium_purchase_forever_button, "field 'purchaseForeverButton'", TextView.class);
        this.view2131296575 = view;
        view.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target2.onPremiumButtonClick();
            }
        });
        target2.purchaseYearButton = (TextView) Utils.findRequiredViewAsType(source, R.id.premium_purchase_year_button, "field 'purchaseYearButton'", TextView.class);
        target2.purchaseHalfYearButton = (TextView) Utils.findRequiredViewAsType(source, R.id.premium_purchase_half_year_button, "field 'purchaseHalfYearButton'", TextView.class);
        target2.purchaseMonthButton = (TextView) Utils.findRequiredViewAsType(source, R.id.premium_purchase_month_button, "field 'purchaseMonthButton'", TextView.class);
    }

    @CallSuper
    public void unbind() {
        PurchaseActivity_2 target2 = this.target;
        if (target2 == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        target2.toolbar = null;
        target2.purchaseForeverButton = null;
        target2.purchaseYearButton = null;
        target2.purchaseHalfYearButton = null;
        target2.purchaseMonthButton = null;
        this.view2131296575.setOnClickListener((View.OnClickListener) null);
        this.view2131296575 = null;
    }
}
