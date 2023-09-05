package com.google.android.gms.internal;

import android.content.SharedPreferences;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.internal.zzbq;

public final class zzcgx {
    private final String zzbfo;
    private long zzdot;
    private boolean zzjba;
    private /* synthetic */ zzcgu zzjbb;
    private final long zzjbc;

    public zzcgx(zzcgu zzcgu, String str, long j) {
        this.zzjbb = zzcgu;
        zzbq.zzgi(str);
        this.zzbfo = str;
        this.zzjbc = j;
    }

    @WorkerThread
    public final long get() {
        if (!this.zzjba) {
            this.zzjba = true;
            this.zzdot = this.zzjbb.zzaza().getLong(this.zzbfo, this.zzjbc);
        }
        return this.zzdot;
    }

    @WorkerThread
    public final void set(long j) {
        SharedPreferences.Editor edit = this.zzjbb.zzaza().edit();
        edit.putLong(this.zzbfo, j);
        edit.apply();
        this.zzdot = j;
    }
}
