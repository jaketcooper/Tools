package com.google.android.gms.internal;

import android.view.MotionEvent;
import android.view.View;

final class zzot implements zzny {
    private /* synthetic */ View zzbua;
    private /* synthetic */ zzor zzbuf;

    zzot(zzor zzor, View view) {
        this.zzbuf = zzor;
        this.zzbua = view;
    }

    public final void zzc(MotionEvent motionEvent) {
        this.zzbuf.onTouch((View) null, motionEvent);
    }

    public final void zzjv() {
        if (this.zzbuf.zza(zzor.zzbto)) {
            this.zzbuf.onClick(this.zzbua);
        }
    }
}
