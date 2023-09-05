package com.google.android.gms.ads.internal;

import android.view.MotionEvent;
import android.view.View;

final class zzbo implements View.OnTouchListener {
    private /* synthetic */ zzbm zzarm;

    zzbo(zzbm zzbm) {
        this.zzarm = zzbm;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.zzarm.zzark == null) {
            return false;
        }
        this.zzarm.zzark.zza(motionEvent);
        return false;
    }
}
