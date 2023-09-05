package com.safonov.speedreading.main.fragment.motivators.view;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.p000v4.view.ViewPager;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.google.android.gms.ads.AdView;
import com.speedreading.alexander.speedreading.R;

public class MotivatorsFragment_ViewBinding implements Unbinder {
    private MotivatorsFragment target;

    @UiThread
    public MotivatorsFragment_ViewBinding(MotivatorsFragment target2, View source) {
        this.target = target2;
        target2.viewPager = (ViewPager) Utils.findRequiredViewAsType(source, R.id.view_pager, "field 'viewPager'", ViewPager.class);
        target2.adView = (AdView) Utils.findRequiredViewAsType(source, R.id.ad_view, "field 'adView'", AdView.class);
        target2.motivatorMessageArray = source.getContext().getResources().getStringArray(R.array.motivators);
    }

    @CallSuper
    public void unbind() {
        MotivatorsFragment target2 = this.target;
        if (target2 == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        target2.viewPager = null;
        target2.adView = null;
    }
}
