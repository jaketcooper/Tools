package com.google.android.gms.internal;

import android.content.SharedPreferences;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.internal.zzbq;

public final class zzcgz {
    private String mValue;
    private final String zzbfo;
    private boolean zzjba;
    private /* synthetic */ zzcgu zzjbb;
    private final String zzjbg = null;

    public zzcgz(zzcgu zzcgu, String str, String str2) {
        this.zzjbb = zzcgu;
        zzbq.zzgi(str);
        this.zzbfo = str;
    }

    @WorkerThread
    public final String zzazg() {
        if (!this.zzjba) {
            this.zzjba = true;
            this.mValue = this.zzjbb.zzaza().getString(this.zzbfo, (String) null);
        }
        return this.mValue;
    }

    @WorkerThread
    public final void zzjl(String str) {
        if (!zzckn.zzas(str, this.mValue)) {
            SharedPreferences.Editor edit = this.zzjbb.zzaza().edit();
            edit.putString(this.zzbfo, str);
            edit.apply();
            this.mValue = str;
        }
    }
}
