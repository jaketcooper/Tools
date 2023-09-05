package com.safonov.speedreading.main.fragment.description;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.google.android.gms.ads.AdView;
import com.speedreading.alexander.speedreading.R;

public class DescriptionFragment_ViewBinding implements Unbinder {
    private DescriptionFragment target;

    @UiThread
    public DescriptionFragment_ViewBinding(DescriptionFragment target2, View source) {
        this.target = target2;
        target2.adView = (AdView) Utils.findRequiredViewAsType(source, R.id.ad_view, "field 'adView'", AdView.class);
    }

    @CallSuper
    public void unbind() {
        DescriptionFragment target2 = this.target;
        if (target2 == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        target2.adView = null;
    }
}
