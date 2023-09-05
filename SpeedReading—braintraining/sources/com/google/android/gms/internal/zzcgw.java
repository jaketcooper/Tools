package com.google.android.gms.internal;

import android.content.SharedPreferences;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.internal.zzbq;

public final class zzcgw {
    private final String zzbfo;
    private boolean zzfjt;
    private final boolean zzjaz = true;
    private boolean zzjba;
    private /* synthetic */ zzcgu zzjbb;

    public zzcgw(zzcgu zzcgu, String str, boolean z) {
        this.zzjbb = zzcgu;
        zzbq.zzgi(str);
        this.zzbfo = str;
    }

    @WorkerThread
    public final boolean get() {
        if (!this.zzjba) {
            this.zzjba = true;
            this.zzfjt = this.zzjbb.zzaza().getBoolean(this.zzbfo, this.zzjaz);
        }
        return this.zzfjt;
    }

    @WorkerThread
    public final void set(boolean z) {
        SharedPreferences.Editor edit = this.zzjbb.zzaza().edit();
        edit.putBoolean(this.zzbfo, z);
        edit.apply();
        this.zzfjt = z;
    }
}
