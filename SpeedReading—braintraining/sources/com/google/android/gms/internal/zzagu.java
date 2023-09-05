package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.zzbs;

final class zzagu implements zzaiv {
    private /* synthetic */ Context val$context;
    private /* synthetic */ String zzczm;

    zzagu(zzagr zzagr, Context context, String str) {
        this.val$context = context;
        this.zzczm = str;
    }

    public final void zzch(String str) {
        zzbs.zzec();
        zzagr.zze(this.val$context, this.zzczm, str);
    }
}
