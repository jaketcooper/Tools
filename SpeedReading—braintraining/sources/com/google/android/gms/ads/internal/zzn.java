package com.google.android.gms.ads.internal;

import android.view.MotionEvent;
import android.view.View;

final class zzn implements View.OnTouchListener {
    private /* synthetic */ zzl zzani;
    private /* synthetic */ zzw zzanj;

    zzn(zzl zzl, zzw zzw) {
        this.zzani = zzl;
        this.zzanj = zzw;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        this.zzanj.recordClick();
        if (this.zzani.zzang == null) {
            return false;
        }
        this.zzani.zzang.zzog();
        return false;
    }
}
