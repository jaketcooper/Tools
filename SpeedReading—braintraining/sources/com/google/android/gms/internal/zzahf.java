package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.view.View;
import android.view.ViewGroup;

@TargetApi(19)
public class zzahf extends zzahd {
    public final boolean isAttachedToWindow(View view) {
        return view.isAttachedToWindow();
    }

    public final ViewGroup.LayoutParams zzqc() {
        return new ViewGroup.LayoutParams(-1, -1);
    }
}
