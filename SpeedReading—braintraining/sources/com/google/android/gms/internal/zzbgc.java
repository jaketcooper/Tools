package com.google.android.gms.internal;

import android.content.Context;

public final class zzbgc {
    private static zzbgc zzgcx = new zzbgc();
    private zzbgb zzgcw = null;

    private final synchronized zzbgb zzcx(Context context) {
        if (this.zzgcw == null) {
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            this.zzgcw = new zzbgb(context);
        }
        return this.zzgcw;
    }

    public static zzbgb zzcy(Context context) {
        return zzgcx.zzcx(context);
    }
}
