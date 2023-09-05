package com.google.android.gms.internal;

import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;

final class zzyf implements ViewTreeObserver.OnScrollChangedListener {
    private /* synthetic */ zzxy zzcjv;
    private /* synthetic */ WeakReference zzcjx;

    zzyf(zzxy zzxy, WeakReference weakReference) {
        this.zzcjv = zzxy;
        this.zzcjx = weakReference;
    }

    public final void onScrollChanged() {
        this.zzcjv.zza((WeakReference<zzama>) this.zzcjx, true);
    }
}
