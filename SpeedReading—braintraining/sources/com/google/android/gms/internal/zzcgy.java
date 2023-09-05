package com.google.android.gms.internal;

import android.content.SharedPreferences;
import android.support.annotation.WorkerThread;
import android.util.Pair;
import com.google.android.gms.common.internal.zzbq;

public final class zzcgy {
    private final long zzdvt;
    private /* synthetic */ zzcgu zzjbb;
    private String zzjbd;
    private final String zzjbe;
    private final String zzjbf;

    private zzcgy(zzcgu zzcgu, String str, long j) {
        this.zzjbb = zzcgu;
        zzbq.zzgi(str);
        zzbq.checkArgument(j > 0);
        this.zzjbd = String.valueOf(str).concat(":start");
        this.zzjbe = String.valueOf(str).concat(":count");
        this.zzjbf = String.valueOf(str).concat(":value");
        this.zzdvt = j;
    }

    @WorkerThread
    private final void zzzr() {
        this.zzjbb.zzut();
        long currentTimeMillis = this.zzjbb.zzwh().currentTimeMillis();
        SharedPreferences.Editor edit = this.zzjbb.zzaza().edit();
        edit.remove(this.zzjbe);
        edit.remove(this.zzjbf);
        edit.putLong(this.zzjbd, currentTimeMillis);
        edit.apply();
    }

    @WorkerThread
    private final long zzzt() {
        return this.zzjbb.zzaza().getLong(this.zzjbd, 0);
    }

    @WorkerThread
    public final void zzg(String str, long j) {
        this.zzjbb.zzut();
        if (zzzt() == 0) {
            zzzr();
        }
        if (str == null) {
            str = "";
        }
        long j2 = this.zzjbb.zzaza().getLong(this.zzjbe, 0);
        if (j2 <= 0) {
            SharedPreferences.Editor edit = this.zzjbb.zzaza().edit();
            edit.putString(this.zzjbf, str);
            edit.putLong(this.zzjbe, 1);
            edit.apply();
            return;
        }
        boolean z = (this.zzjbb.zzawj().zzbao().nextLong() & Long.MAX_VALUE) < Long.MAX_VALUE / (j2 + 1);
        SharedPreferences.Editor edit2 = this.zzjbb.zzaza().edit();
        if (z) {
            edit2.putString(this.zzjbf, str);
        }
        edit2.putLong(this.zzjbe, j2 + 1);
        edit2.apply();
    }

    @WorkerThread
    public final Pair<String, Long> zzzs() {
        long abs;
        this.zzjbb.zzut();
        this.zzjbb.zzut();
        long zzzt = zzzt();
        if (zzzt == 0) {
            zzzr();
            abs = 0;
        } else {
            abs = Math.abs(zzzt - this.zzjbb.zzwh().currentTimeMillis());
        }
        if (abs < this.zzdvt) {
            return null;
        }
        if (abs > (this.zzdvt << 1)) {
            zzzr();
            return null;
        }
        String string = this.zzjbb.zzaza().getString(this.zzjbf, (String) null);
        long j = this.zzjbb.zzaza().getLong(this.zzjbe, 0);
        zzzr();
        return (string == null || j <= 0) ? zzcgu.zzjae : new Pair<>(string, Long.valueOf(j));
    }
}
