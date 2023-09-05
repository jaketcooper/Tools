package com.google.android.gms.internal;

import android.view.MotionEvent;
import android.view.View;

final class zzoq implements zzny {
    private /* synthetic */ zzoo zzbtz;
    private /* synthetic */ View zzbua;

    zzoq(zzoo zzoo, View view) {
        this.zzbtz = zzoo;
        this.zzbua = view;
    }

    public final void zzc(MotionEvent motionEvent) {
        this.zzbtz.onTouch((View) null, motionEvent);
    }

    public final void zzjv() {
        this.zzbtz.onClick(this.zzbua);
    }
}
