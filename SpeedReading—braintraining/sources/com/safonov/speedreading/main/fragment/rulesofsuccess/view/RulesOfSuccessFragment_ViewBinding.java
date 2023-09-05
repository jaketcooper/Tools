package com.safonov.speedreading.main.fragment.rulesofsuccess.view;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.p003v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.google.android.gms.ads.AdView;
import com.speedreading.alexander.speedreading.R;

public class RulesOfSuccessFragment_ViewBinding implements Unbinder {
    private RulesOfSuccessFragment target;

    @UiThread
    public RulesOfSuccessFragment_ViewBinding(RulesOfSuccessFragment target2, View source) {
        this.target = target2;
        target2.adView = (AdView) Utils.findRequiredViewAsType(source, R.id.ad_view, "field 'adView'", AdView.class);
        target2.recyclerView = (RecyclerView) Utils.findRequiredViewAsType(source, R.id.recycler_view, "field 'recyclerView'", RecyclerView.class);
    }

    @CallSuper
    public void unbind() {
        RulesOfSuccessFragment target2 = this.target;
        if (target2 == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        target2.adView = null;
        target2.recyclerView = null;
    }
}
