package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.google.android.gms.internal.zzahj;
import com.google.android.gms.internal.zzzb;

@zzzb
final class zzh extends RelativeLayout {
    private zzahj zzaum;
    boolean zzchc;

    public zzh(Context context, String str, String str2) {
        super(context);
        this.zzaum = new zzahj(context, str);
        this.zzaum.zzci(str2);
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.zzchc) {
            return false;
        }
        this.zzaum.zze(motionEvent);
        return false;
    }
}
