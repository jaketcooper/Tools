package com.google.android.gms.internal;

import java.util.HashMap;

public final class zzcw extends zzbq<Integer, Long> {
    public long zzahy;
    public long zzahz;

    public zzcw() {
        this.zzahy = -1;
        this.zzahz = -1;
    }

    public zzcw(String str) {
        this();
        zzi(str);
    }

    /* access modifiers changed from: protected */
    public final void zzi(String str) {
        HashMap zzj = zzj(str);
        if (zzj != null) {
            this.zzahy = ((Long) zzj.get(0)).longValue();
            this.zzahz = ((Long) zzj.get(1)).longValue();
        }
    }

    /* access modifiers changed from: protected */
    public final HashMap<Integer, Long> zzw() {
        HashMap<Integer, Long> hashMap = new HashMap<>();
        hashMap.put(0, Long.valueOf(this.zzahy));
        hashMap.put(1, Long.valueOf(this.zzahz));
        return hashMap;
    }
}
