package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.zzak;
import com.google.android.gms.ads.internal.zzv;

@zzzb
public final class zzri {
    private final Context mContext;
    private final zzv zzamw;
    private final zzuc zzanb;
    private final zzaiy zzaov;

    zzri(Context context, zzuc zzuc, zzaiy zzaiy, zzv zzv) {
        this.mContext = context;
        this.zzanb = zzuc;
        this.zzaov = zzaiy;
        this.zzamw = zzv;
    }

    public final Context getApplicationContext() {
        return this.mContext.getApplicationContext();
    }

    public final zzak zzau(String str) {
        return new zzak(this.mContext, new zziw(), str, this.zzanb, this.zzaov, this.zzamw);
    }

    public final zzak zzav(String str) {
        return new zzak(this.mContext.getApplicationContext(), new zziw(), str, this.zzanb, this.zzaov, this.zzamw);
    }

    public final zzri zzko() {
        return new zzri(this.mContext.getApplicationContext(), this.zzanb, this.zzaov, this.zzamw);
    }
}
