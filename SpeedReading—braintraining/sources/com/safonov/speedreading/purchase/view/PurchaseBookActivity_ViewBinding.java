package com.safonov.speedreading.purchase.view;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.p003v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.speedreading.alexander.speedreading.R;

public class PurchaseBookActivity_ViewBinding implements Unbinder {
    private PurchaseBookActivity target;
    private View view2131296574;

    @UiThread
    public PurchaseBookActivity_ViewBinding(PurchaseBookActivity target2) {
        this(target2, target2.getWindow().getDecorView());
    }

    @UiThread
    public PurchaseBookActivity_ViewBinding(final PurchaseBookActivity target2, View source) {
        this.target = target2;
        target2.toolbar = (Toolbar) Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
        View view = Utils.findRequiredView(source, R.id.premium_purchase_button, "field 'purchaseButton' and method 'onPremiumButtonClick'");
        target2.purchaseButton = (Button) Utils.castView(view, R.id.premium_purchase_button, "field 'purchaseButton'", Button.class);
        this.view2131296574 = view;
        view.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target2.onPremiumButtonClick();
            }
        });
    }

    @CallSuper
    public void unbind() {
        PurchaseBookActivity target2 = this.target;
        if (target2 == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        target2.toolbar = null;
        target2.purchaseButton = null;
        this.view2131296574.setOnClickListener((View.OnClickListener) null);
        this.view2131296574 = null;
    }
}
